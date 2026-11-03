package com.juiceybeans.veilsandvegetation.block;

import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BaseVVBlock extends MultifaceBlock {

    public BaseVVBlock(Properties properties) {
        super(properties.noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.NONE));
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return null;
    }
}
