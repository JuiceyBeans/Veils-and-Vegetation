package com.juiceybeans.ubergrowth.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import static com.juiceybeans.ubergrowth.init.UbergrowthBlocks.*;

public class UbergrowthBlockTagsGenerator extends FabricTagProvider<Block> {
    public UbergrowthBlockTagsGenerator(FabricDataOutput output, CompletableFuture registriesFuture) {
        super(output, Registries.BLOCK, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(STONE_BRICK_CHUNKS)
                .add(MOSSY_STONE_BRICK_CHUNKS)
                .add(BRICK_CHUNKS)
                .add(DEEPSLATE_BRICK_CHUNKS)
                .add(BLACKSTONE_BRICK_CHUNKS)
                .add(NETHERWART_BRICK_CHUNKS)
                .add(NETHER_BRICK_CHUNKS)
                .add(QUARTZ_BRICK_CHUNKS)
                .add(ENDSTONE_BRICK_CHUNKS)
                .add(PURPUR_CHUNKS)
                .add(COPPER_PLATING)
                .add(EXPOSED_COPPER_PLATING)
                .add(WEATHERED_COPPER_PLATING)
                .add(OXIDIZED_COPPER_PLATING)
                .add(GOLD_PLATING)
                .add(IRON_PLATING)
                .add(NETHERITE_PLATING)
                .add(COPPER_ORE_FRAGMENTS)
                .add(IRON_ORE_FRAGMENTS)
                .add(GOLD_ORE_FRAGMENTS)
                .add(NETHER_QUARTZ_FRAGMENTS)
                .add(EMERALD_FRAGMENTS)
                .add(DIAMOND_FRAGMENTS)
                .add(COAL_FRAGMENTS)
                .add(REDSTONE_FRAGMENTS)
                .add(LAPIS_LAZULI_FRAGMENTS)
                .add(MOSSY_COBBLESTONE_CHUNKS)
                .add(COBBLESTONE_CHUNKS)
                .add(PRISMARINE_CHUNKS)
                .add(SANDSTONE_CHUNKS)
                .add(RED_SANDSTONE_CHUNKS)
                .add(ENDSTONE_CHUNKS)
                .add(DIORITE_CHUNKS)
                .add(GRANITE_CHUNKS)
                .add(ANDESITE_CHUNKS)
                .add(NETHERRACK_CHUNKS)
                .add(WARPED_NYLIUM_SMATTERING)
                .add(CRIMSON_NYLIUM_SMATTERING);

        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_AXE)
                .add(BUDDING_CRIMSON_HYPHAE)
                .add(CRIMSON_HYPHAE)
                .add(BUDDING_WARPED_HYPHAE)
                .add(WARPED_HYPHAE)
                .add(OAK_CREEPS)
                .add(STRIPPED_OAK_CREEPS)
                .add(BIRCH_CREEPS)
                .add(STRIPPED_BIRCH_CREEPS)
                .add(SPRUCE_CREEPS)
                .add(STRIPPED_SPRUCE_CREEPS)
                .add(JUNGLE_CREEPS)
                .add(STRIPPED_JUNGLE_CREEPS)
                .add(DARK_OAK_CREEPS)
                .add(STRIPPED_DARK_OAK_CREEPS)
                .add(ACACIA_CREEPS)
                .add(STRIPPED_ACACIA_CREEPS)
                .add(MANGROVE_CREEPS)
                .add(STRIPPED_MANGROVE_CREEPS)
                .add(CHERRY_CREEPS)
                .add(STRIPPED_CHERRY_CREEPS)
                .add(WARPED_CREEPS)
                .add(STRIPPED_WARPED_CREEPS)
                .add(CRIMSON_CREEPS)
                .add(STRIPPED_CRIMSON_CREEPS)
                .add(SHODDY_OAK_PLANKS)
                .add(SHODDY_BIRCH_PLANKS)
                .add(SHODDY_SPRUCE_PLANKS)
                .add(SHODDY_JUNGLE_PLANKS)
                .add(SHODDY_ACACIA_PLANKS)
                .add(SHODDY_DARK_OAK_PLANKS)
                .add(SHODDY_MANGROVE_PLANKS)
                .add(SHODDY_CHERRY_PLANKS);

        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(DIRT_SMATTERING)
                .add(MUD_SMATTERING)
                .add(CLAY_SMATTERING)
                .add(GRAVEL_SMATTERING)
                .add(SAND_SMATTERING)
                .add(RED_SAND_SMATTERING)
                .add(ROOTED_DIRT_SMATTERING)
                .add(GRASS_SMATTERING)
                .add(PODZOL_SMATTERING)
                .add(SOUL_SOIL_SMATTERING)
                .add(SOUL_SAND_SMATTERING);

        this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_HOE)
                .add(OAK_FOLIAGE)
                .add(SPRUCE_FOLIAGE)
                .add(BIRCH_FOLIAGE)
                .add(JUNGLE_FOLIAGE)
                .add(ACACIA_FOLIAGE)
                .add(DARK_OAK_FOLIAGE)
                .add(MANGROVE_FOLIAGE)
                .add(CHERRY_FOLIAGE)
                .add(AZALEA_FOLIAGE)
                .add(FLOWERING_AZALEA_FOLIAGE)
                .add(GLOWBERRY_CREEPS)
                .add(FRUITING_GLOWBERRY_CREEPS)
                .add(BARE_GLOWBERRY_CREEPS)
                .add(FRUITING_SWEET_BERRY_FOLIAGE)
                .add(SWEET_BERRY_FOLIAGE)
                .add(BAMBOO_FOLIAGE)
                .add(GRASS_SHOOTS)
                .add(MOSS_CLUMPS)
                .add(AQUA_GOO_NODES)
                .add(OCHRE_GOO_NODES)
                .add(PEARLESCENT_GOO_NODES)
                .add(VERDANT_GOO_NODES)
                .add(AQUA_GOO_HYPHAE)
                .add(OCHRE_GOO_HYPHAE)
                .add(PEARLESCENT_GOO_HYPHAE)
                .add(VERDANT_GOO_HYPHAE)
                .add(BEACHED_KELP)
                .add(BEACHED_SEA_GRASS);
    }
}
