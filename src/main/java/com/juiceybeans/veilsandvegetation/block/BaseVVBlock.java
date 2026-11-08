package com.juiceybeans.veilsandvegetation.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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
        return canBeReplaced;
    }

    @Override
    public boolean canBeReplaced(BlockState state, Fluid fluid) {
        return canBeReplaced;
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
