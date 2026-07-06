package com.juiceybeans.ubergrowth.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

public class UbergrowthCreativeTabs {
    public static final CreativeModeTab UBERGROWTH_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(UbergrowthBlocks.TACKED_NOTES.asItem()))
            .title(Component.translatable("itemGroup.ubergrowth.ubergrowth_blocks"))
            .displayItems((itemDisplayParameters, output) -> {
                for (Block block : UbergrowthBlocks.blocks) {
                    output.accept(block);
                }
            }).build();
}
