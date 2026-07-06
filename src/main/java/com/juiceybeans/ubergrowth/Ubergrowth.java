package com.juiceybeans.ubergrowth;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ubergrowth implements ModInitializer {
	public static final String MOD_ID = "ubergrowth";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        UbergrowthBlocks.initialize();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}
}
