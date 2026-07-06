package com.juiceybeans.ubergrowth.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;

public class SpreadableUbergrowthBlock extends BaseUbergrowthBlock implements BonemealableBlock {
    private MultifaceSpreader spreader;
    private BaseUbergrowthBlock spreadBlock;

    public SpreadableUbergrowthBlock(Properties properties) {
        super(properties);
        this.spreadBlock = this;
        this.spreader = new MultifaceSpreader(spreadBlock);
    }

    public void setSpreadBlock(BaseUbergrowthBlock spreadBlock) {
        this.spreadBlock = spreadBlock;
        this.spreader = new MultifaceSpreader(spreadBlock);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return Direction.stream().anyMatch(direction -> this.spreader.canSpreadInAnyDirection(state, level, pos, direction.getOpposite()));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.spreader.spreadFromRandomFaceTowardRandomDirection(spreadBlock.withPropertiesOf(state)
                .trySetValue(WaterloggableUbergrowthBlock.WATERLOGGED, false), level, pos, random);
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }
}
