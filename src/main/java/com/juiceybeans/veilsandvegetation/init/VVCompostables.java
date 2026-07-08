package com.juiceybeans.veilsandvegetation.init;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

import static com.juiceybeans.veilsandvegetation.init.VVBlocks.*;

public class VVCompostables {
    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(DEAD_CREEPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ARCHAIC_CREEPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(WARPED_VINES, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(RED_HYPHAE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BROWN_HYPHAE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ROOT_CREEPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(MYCELIUM_HYPHAE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(CRIMSON_HYPHAE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(WARPED_HYPHAE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(OAK_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(SPRUCE_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BIRCH_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(JUNGLE_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(ACACIA_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(DARK_OAK_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(MANGROVE_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(CHERRY_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(AZALEA_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(FLOWERING_AZALEA_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(GLOWBERRY_CREEPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BARE_GLOWBERRY_CREEPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(SWEET_BERRY_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BAMBOO_FOLIAGE, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(GRASS_SHOOTS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(MOSS_CLUMPS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(MOSS_GROWTH, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BEACHED_KELP, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(BEACHED_SEA_GRASS, 0.3f);
        CompostingChanceRegistry.INSTANCE.add(NETHER_WART_SPROUTS, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(CRIMSON_VINES, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ROSE_CREEPS, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(ROSE_VINES, 0.65f);
        CompostingChanceRegistry.INSTANCE.add(WARPED_GROWTHS, 0.65f);
    }
}
