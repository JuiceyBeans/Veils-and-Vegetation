package com.juiceybeans.ubergrowth.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.juiceybeans.ubergrowth.block.blockentity.TackedNotesBlockEntity;
import com.juiceybeans.ubergrowth.menu.TackedNotesMenu;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

public class TackedNotesBlock extends BaseEntityBlock {
    private static final float AABB_OFFSET = 1.0F;
    private static final VoxelShape UP_AABB = Block.box(0.0, 15.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape DOWN_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 1.0, 16.0);
    private static final VoxelShape WEST_AABB = Block.box(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
    private static final VoxelShape EAST_AABB = Block.box(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    private static final VoxelShape NORTH_AABB = Block.box(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
    private static final VoxelShape SOUTH_AABB = Block.box(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    private static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;
    private static final Map<Direction, VoxelShape> SHAPE_BY_DIRECTION = Util.make(Maps.newEnumMap(Direction.class), enumMap -> {
        enumMap.put(Direction.NORTH, NORTH_AABB);
        enumMap.put(Direction.EAST, EAST_AABB);
        enumMap.put(Direction.SOUTH, SOUTH_AABB);
        enumMap.put(Direction.WEST, WEST_AABB);
        enumMap.put(Direction.UP, UP_AABB);
        enumMap.put(Direction.DOWN, DOWN_AABB);
    });
    protected static final Direction[] DIRECTIONS = Direction.values();
    private final ImmutableMap<BlockState, VoxelShape> shapesCache;
    private final boolean canRotate;
    private final boolean canMirrorX;
    private final boolean canMirrorZ;

    public TackedNotesBlock(Properties properties) {
        super(properties.noOcclusion());
        this.registerDefaultState(getDefaultMultifaceState(this.stateDefinition));
        this.shapesCache = this.getShapeForEachState(TackedNotesBlock::calculateMultifaceShape);
        this.canRotate = Direction.Plane.HORIZONTAL.stream().allMatch(this::isFaceSupported);
        this.canMirrorX = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.X).filter(this::isFaceSupported).count() % 2L == 0L;
        this.canMirrorZ = Direction.Plane.HORIZONTAL.stream().filter(Direction.Axis.Z).filter(this::isFaceSupported).count() % 2L == 0L;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player,
                                 InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof TackedNotesBlockEntity notesEntity) {
                ServerPlayer serverPlayer = (ServerPlayer) player;

                serverPlayer.openMenu(new ExtendedScreenHandlerFactory() {
                    @Override
                    public void writeScreenOpeningData(ServerPlayer player, FriendlyByteBuf buf) {
                        buf.writeBlockPos(pos);
                    }

                    @Override
                    public Component getDisplayName() {
                        return Component.translatable("block.ubergrowth.tacked_notes");
                    }

                    @Nullable
                    @Override
                    public AbstractContainerMenu createMenu(int syncId, Inventory inv, Player player) {
                        return new TackedNotesMenu(syncId, notesEntity);
                    }
                });
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new TackedNotesBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public static Set<Direction> availableFaces(BlockState state) {
        if (!(state.getBlock() instanceof MultifaceBlock)) {
            return Set.of();
        }

        Set<Direction> set = EnumSet.noneOf(Direction.class);

        for (Direction direction : Direction.values()) {
            if (hasFace(state, direction)) {
                set.add(direction);
            }
        }

        return set;
    }

    public static Set<Direction> unpack(byte packedDirections) {
        Set<Direction> set = EnumSet.noneOf(Direction.class);

        for (Direction direction : Direction.values()) {
            if ((packedDirections & (byte)(1 << direction.ordinal())) > 0) {
                set.add(direction);
            }
        }

        return set;
    }

    public static byte pack(Collection<Direction> directions) {
        byte b = 0;

        for (Direction direction : directions) {
            b = (byte)(b | 1 << direction.ordinal());
        }

        return b;
    }

    protected boolean isFaceSupported(Direction face) {
        return true;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        for (Direction direction : DIRECTIONS) {
            if (this.isFaceSupported(direction)) {
                builder.add(getFaceProperty(direction));
            }
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return state;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return this.shapesCache.get(state);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        boolean bl = false;

        for (Direction direction : DIRECTIONS) {
            if (hasFace(state, direction)) {
                BlockPos blockPos = pos.relative(direction);
                if (!canAttachTo(level, direction, blockPos, level.getBlockState(blockPos))) {
                    return false;
                }

                bl = true;
            }
        }

        return bl;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return hasAnyVacantFace(state);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean movedByPiston) {
        for (Direction direction : DIRECTIONS) {
            if (hasFace(state, direction)) {
                BlockPos neighbor = pos.relative(direction);
                if (!canAttachTo(level, direction, neighbor, level.getBlockState(neighbor))) {
                    level.destroyBlock(pos, true);
                    return;
                }
            }
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        BlockState blockState = level.getBlockState(blockPos);
        return Arrays.stream(context.getNearestLookingDirections())
                .map(direction -> this.getStateForPlacement(blockState, level, blockPos, direction))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }

    public boolean isValidStateForPlacement(BlockGetter level, BlockState state, BlockPos pos, Direction direction) {
        if (this.isFaceSupported(direction) && (!state.is(this) || !hasFace(state, direction))) {
            BlockPos blockPos = pos.relative(direction);
            return canAttachTo(level, direction, blockPos, level.getBlockState(blockPos));
        } else {
            return false;
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockState currentState, BlockGetter level, BlockPos pos, Direction lookingDirection) {
        if (!this.isValidStateForPlacement(level, currentState, pos, lookingDirection)) {
            return null;
        }

        BlockState blockState;
        if (currentState.is(this)) {
            blockState = currentState;
        } else if (this.isWaterloggable() && currentState.getFluidState().isSourceOfType(Fluids.WATER)) {
            blockState = this.defaultBlockState().setValue(BlockStateProperties.WATERLOGGED, true);
        } else {
            blockState = this.defaultBlockState();
        }

        return blockState.setValue(getFaceProperty(lookingDirection), true);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return !this.canRotate ? state : this.mapDirections(state, rotation::rotate);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        if (mirror == Mirror.FRONT_BACK && !this.canMirrorX) {
            return state;
        } else {
            return mirror == Mirror.LEFT_RIGHT && !this.canMirrorZ ? state : this.mapDirections(state, mirror::mirror);
        }
    }

    private BlockState mapDirections(BlockState state, Function<Direction, Direction> directionalFunction) {
        BlockState blockState = state;

        for (Direction direction : DIRECTIONS) {
            if (this.isFaceSupported(direction)) {
                blockState = blockState.setValue(getFaceProperty(directionalFunction.apply(direction)), state.getValue(getFaceProperty(direction)));
            }
        }

        return blockState;
    }

    public static boolean hasFace(BlockState state, Direction direction) {
        BooleanProperty booleanProperty = getFaceProperty(direction);
        return state.hasProperty(booleanProperty) && state.getValue(booleanProperty);
    }

    public static boolean canAttachTo(BlockGetter level, Direction direction, BlockPos pos, BlockState state) {
        return Block.isFaceFull(state.getBlockSupportShape(level, pos), direction.getOpposite())
                || Block.isFaceFull(state.getCollisionShape(level, pos), direction.getOpposite());
    }

    private boolean isWaterloggable() {
        return this.stateDefinition.getProperties().contains(BlockStateProperties.WATERLOGGED);
    }

    private static BlockState removeFace(BlockState state, BooleanProperty faceProp) {
        BlockState blockState = state.setValue(faceProp, false);
        return hasAnyFace(blockState) ? blockState : Blocks.AIR.defaultBlockState();
    }

    public static BooleanProperty getFaceProperty(Direction direction) {
        return PROPERTY_BY_DIRECTION.get(direction);
    }

    private static BlockState getDefaultMultifaceState(StateDefinition<Block, BlockState> stateDefinition) {
        BlockState blockState = stateDefinition.any();

        for (BooleanProperty booleanProperty : PROPERTY_BY_DIRECTION.values()) {
            if (blockState.hasProperty(booleanProperty)) {
                blockState = blockState.setValue(booleanProperty, false);
            }
        }

        return blockState;
    }

    private static VoxelShape calculateMultifaceShape(BlockState state) {
        VoxelShape voxelShape = Shapes.empty();

        for (Direction direction : DIRECTIONS) {
            if (hasFace(state, direction)) {
                voxelShape = Shapes.or(voxelShape, SHAPE_BY_DIRECTION.get(direction));
            }
        }

        return voxelShape.isEmpty() ? Shapes.block() : voxelShape;
    }

    protected static boolean hasAnyFace(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> hasFace(state, direction));
    }

    private static boolean hasAnyVacantFace(BlockState state) {
        return Arrays.stream(DIRECTIONS).anyMatch(direction -> !hasFace(state, direction));
    }
}
