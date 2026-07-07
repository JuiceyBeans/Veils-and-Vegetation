package com.juiceybeans.ubergrowth.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BonemealableUbergrowthBlock extends WaterloggableUbergrowthBlock implements BonemealableBlock {
    private final Block bonemealedBlock;

    public BonemealableUbergrowthBlock(Properties properties, Block bonemealedBlock) {
        super(properties);
        this.bonemealedBlock = bonemealedBlock;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        level.setBlock(pos, this.bonemealedBlock.withPropertiesOf(state), 3);
    }
}
