package com.juiceybeans.ubergrowth;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import com.juiceybeans.ubergrowth.init.UbergrowthCreativeTabs;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ubergrowth implements ModInitializer {
	public static final String MOD_ID = "ubergrowth";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        UbergrowthBlocks.initialize();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Ubergrowth.id("ubergrowth_blocks"), UbergrowthCreativeTabs.UBERGROWTH_BLOCKS);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
