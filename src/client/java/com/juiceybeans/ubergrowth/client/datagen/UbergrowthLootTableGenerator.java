package com.juiceybeans.ubergrowth.client.datagen;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.level.block.Block;

public class UbergrowthLootTableGenerator extends FabricBlockLootTableProvider {
    protected UbergrowthLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        for (Block block : UbergrowthBlocks.blocks) {
            this.dropSelf(block);
        }
    }
}
