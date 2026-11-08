package com.juiceybeans.veilsandvegetation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;

public class BaseVVBlock extends MultifaceBlock {

    private boolean canBeReplaced = false;

    public BaseVVBlock(Properties properties, boolean canBeReplaced) {
        super(properties.noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.NONE));
        this.canBeReplaced = canBeReplaced;
    }

    public BaseVVBlock(Properties properties) {
        this(properties, false);
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        if (canBeReplaced) return true;
        return useContext.getItemInHand().is(this.asItem());
    }

    @Override
    public boolean canBeReplaced(BlockState state, Fluid fluid) {
        return canBeReplaced;
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                  LevelAccessor levelAccess, BlockPos pos, BlockPos neighborPos) {
        BlockState theStatesman = super.updateShape(state, direction, neighborState, levelAccess, pos, neighborPos);
        int prevFaces = 0;
        int newFaces = 0;

        for (BooleanProperty prop : PipeBlock.PROPERTY_BY_DIRECTION.values()) {
            if (state.hasProperty(prop) && state.getValue(prop)) prevFaces++;
            if (theStatesman.hasProperty(prop) && theStatesman.getValue(prop)) newFaces++;
        }

        if (!levelAccess.isClientSide() && levelAccess instanceof Level level && newFaces < prevFaces) {
            popResource(level, pos, new ItemStack(this));
        }

        return theStatesman;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
