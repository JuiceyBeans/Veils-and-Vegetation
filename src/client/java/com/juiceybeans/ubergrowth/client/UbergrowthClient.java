package com.juiceybeans.ubergrowth.client;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class UbergrowthClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        Set<Block> translucentBlocks = Set.of(
                UbergrowthBlocks.RUST,
                UbergrowthBlocks.DUST,
                UbergrowthBlocks.GRIME
        );

        translucentBlocks.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.translucent()));

        for (Block block : UbergrowthBlocks.blocks) {
            if (!translucentBlocks.contains(block)) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderType.cutout());
        }

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                return BiomeColors.getAverageFoliageColor(world, pos);
            }

            return FoliageColor.getDefaultColor();
        },
                UbergrowthBlocks.OAK_FOLIAGE,
                UbergrowthBlocks.JUNGLE_FOLIAGE,
                UbergrowthBlocks.ACACIA_FOLIAGE,
                UbergrowthBlocks.DARK_OAK_FOLIAGE,
                UbergrowthBlocks.MANGROVE_FOLIAGE
        );

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (world != null && pos != null) {
                return BiomeColors.getAverageGrassColor(world, pos);
            }

            return GrassColor.getDefaultColor();
            },
                UbergrowthBlocks.GRASS_SHOOTS
        );
	}
}