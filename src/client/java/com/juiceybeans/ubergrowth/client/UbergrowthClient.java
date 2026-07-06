package com.juiceybeans.ubergrowth.client;

import com.juiceybeans.ubergrowth.init.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;

public class UbergrowthClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        for (Block block : ModBlocks.blocks) {
            BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
        }
	}
}