package com.juiceybeans.veilsandvegetation.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class VVCreativeTabs {

    public static final CreativeModeTab UBERGROWTH_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(VVBlocks.TACKED_NOTES.asItem()))
            .title(Component.translatable("itemGroup.veilsandvegetation.veilsandvegetation_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                for (Block block : VVBlocks.blocks) {
                    output.accept(block);
                }
            }).build();
}
