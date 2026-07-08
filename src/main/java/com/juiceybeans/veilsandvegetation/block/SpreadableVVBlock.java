package com.juiceybeans.veilsandvegetation.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockState;

public class SpreadableVVBlock extends BaseVVBlock implements BonemealableBlock {

    private MultifaceSpreader spreader;
    private BaseVVBlock spreadBlock;

    public SpreadableVVBlock(Properties properties) {
        super(properties);
        this.spreadBlock = this;
        this.spreader = new MultifaceSpreader(spreadBlock);
    }

    public void setSpreadBlock(BaseVVBlock spreadBlock) {
        this.spreadBlock = spreadBlock;
        this.spreader = new MultifaceSpreader(spreadBlock);
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean isClient) {
        return Direction.stream().anyMatch(
                direction -> this.spreader.canSpreadInAnyDirection(state, level, pos, direction.getOpposite()));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.spreader.spreadFromRandomFaceTowardRandomDirection(spreadBlock.withPropertiesOf(state)
                .trySetValue(WaterloggableVVBlock.WATERLOGGED, false), level, pos, random);
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }
}
