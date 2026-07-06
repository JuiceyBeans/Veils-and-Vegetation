package com.juiceybeans.ubergrowth.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class WaterloggableUbergrowthBlock extends BaseUbergrowthBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final boolean isWaterloggable;

    public WaterloggableUbergrowthBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false));
        this.isWaterloggable = true;
    }

    public WaterloggableUbergrowthBlock(Properties properties, boolean isWaterloggable) {
        super(properties);
        this.isWaterloggable = isWaterloggable;
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return isWaterloggable;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(WATERLOGGED);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
}
