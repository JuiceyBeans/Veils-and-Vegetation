package com.juiceybeans.veilsandvegetation;

import com.juiceybeans.veilsandvegetation.init.*;
import com.juiceybeans.veilsandvegetation.network.VVNetworking;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VeilsAndVegetation implements ModInitializer {

    public static final String MOD_ID = "veilsandvegetation";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        VVBlocks.initialize();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, VeilsAndVegetation.id("veilsandvegetation_blocks"),
                VVCreativeTabs.UBERGROWTH_BLOCKS);
        VVBlockEntityTypes.initialize();
        VVMenus.registerAll();
        VVNetworking.registerServerReceivers();
    }

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
