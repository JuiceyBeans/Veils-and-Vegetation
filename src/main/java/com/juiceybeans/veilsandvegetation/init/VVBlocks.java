package com.juiceybeans.veilsandvegetation.init;

import com.juiceybeans.veilsandvegetation.VeilsAndVegetation;
import com.juiceybeans.veilsandvegetation.block.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.world.level.block.Blocks.*;

@SuppressWarnings("deprecation")
public class VVBlocks {

    public static List<Block> blocks = new ArrayList<>();

    private static <T extends Block> T registerBlock(String id, T block) {
        Registry.register(BuiltInRegistries.BLOCK, VeilsAndVegetation.id(id), block);
        Registry.register(BuiltInRegistries.ITEM, VeilsAndVegetation.id(id),
                new BlockItem(block, new FabricItemSettings()));

        blocks.add(block);
        return block;
    }

    public static final Block TACKED_PAPER = registerBlock("tacked_paper", new BaseVVBlock(
            FabricBlockSettings.of().burnable().instabreak().mapColor(DyeColor.WHITE).sound(SoundType.GRASS)));
    public static final Block TACKED_NOTES = registerBlock("tacked_notes", new TackedNotesBlock(
            FabricBlockSettings.of().burnable().instabreak().mapColor(DyeColor.WHITE).sound(SoundType.GRASS)));
    public static final Block SPLAYED_LEATHER = registerBlock("splayed_leather", new BaseVVBlock(
            FabricBlockSettings.of().burnable().instabreak().mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRASS)));
    public static final Block SPLAYED_HIDE = registerBlock("splayed_hide", new BaseVVBlock(
            FabricBlockSettings.of().burnable().instabreak().mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRASS)));
    public static final Block STONE_BRICK_CHUNKS = registerBlock("stone_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STONE_BRICKS)));
    public static final Block MOSSY_STONE_BRICK_CHUNKS = registerBlock("mossy_stone_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MOSSY_STONE_BRICKS)));
    public static final Block BRICK_CHUNKS = registerBlock("brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(BRICKS)));
    public static final Block MUD_BRICK_CHUNKS = registerBlock("mud_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MUD_BRICKS)));
    public static final Block DEEPSLATE_BRICK_CHUNKS = registerBlock("deepslate_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DEEPSLATE_BRICKS)));
    public static final Block BLACKSTONE_BRICK_CHUNKS = registerBlock("blackstone_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(POLISHED_BLACKSTONE_BRICKS)));
    public static final Block NETHERWART_BRICK_CHUNKS = registerBlock("netherwart_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(RED_NETHER_BRICKS)));
    public static final Block NETHER_BRICK_CHUNKS = registerBlock("nether_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(NETHER_BRICKS)));
    public static final Block QUARTZ_BRICK_CHUNKS = registerBlock("quartz_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(QUARTZ_BRICKS)));
    public static final Block ENDSTONE_BRICK_CHUNKS = registerBlock("endstone_brick_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(END_STONE_BRICKS)));
    public static final Block PURPUR_CHUNKS = registerBlock("purpur_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(PURPUR_BLOCK)));
    public static final Block COPPER_PLATING = registerBlock("copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(COPPER_BLOCK), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final Block EXPOSED_COPPER_PLATING = registerBlock("exposed_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER), WeatheringCopper.WeatherState.EXPOSED));
    public static final Block WEATHERED_COPPER_PLATING = registerBlock("weathered_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER), WeatheringCopper.WeatherState.WEATHERED));
    public static final Block OXIDIZED_COPPER_PLATING = registerBlock("oxidized_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER), WeatheringCopper.WeatherState.OXIDIZED));
    public static final Block WAXED_COPPER_PLATING = registerBlock("waxed_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(COPPER_BLOCK), WeatheringCopper.WeatherState.UNAFFECTED));
    public static final Block WAXED_EXPOSED_COPPER_PLATING = registerBlock("waxed_exposed_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(EXPOSED_COPPER), WeatheringCopper.WeatherState.EXPOSED));
    public static final Block WAXED_WEATHERED_COPPER_PLATING = registerBlock("waxed_weathered_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(WEATHERED_COPPER), WeatheringCopper.WeatherState.WEATHERED));
    public static final Block WAXED_OXIDIZED_COPPER_PLATING = registerBlock("waxed_oxidized_copper_plating",
            new CopperVVBlock(FabricBlockSettings.copyOf(OXIDIZED_COPPER), WeatheringCopper.WeatherState.OXIDIZED));
    public static final Block GOLD_PLATING = registerBlock("gold_plating", new WaterloggableVVBlock(FabricBlockSettings
            .copyOf(GOLD_BLOCK)));
    public static final Block IRON_PLATING = registerBlock("iron_plating", new WaterloggableVVBlock(FabricBlockSettings
            .copyOf(IRON_BLOCK)));
    public static final Block NETHERITE_PLATING = registerBlock("netherite_plating",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(NETHERITE_BLOCK)));
    public static final Block COPPER_ORE_FRAGMENTS = registerBlock("copper_ore_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(COPPER_ORE).mapColor(MapColor.COLOR_ORANGE)));
    public static final Block IRON_ORE_FRAGMENTS = registerBlock("iron_ore_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(IRON_ORE).mapColor(MapColor.RAW_IRON)));
    public static final Block GOLD_ORE_FRAGMENTS = registerBlock("gold_ore_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(GOLD_ORE).mapColor(MapColor.GOLD)));
    public static final Block NETHER_QUARTZ_FRAGMENTS = registerBlock("nether_quartz_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(NETHER_QUARTZ_ORE).mapColor(MapColor.QUARTZ)));
    public static final Block EMERALD_FRAGMENTS = registerBlock("emerald_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(EMERALD_ORE).mapColor(MapColor.EMERALD)));
    public static final Block DIAMOND_FRAGMENTS = registerBlock("diamond_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DIAMOND_ORE).mapColor(MapColor.DIAMOND)));
    public static final Block COAL_FRAGMENTS = registerBlock("coal_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(COAL_ORE).burnable().mapColor(MapColor.COLOR_BLACK)));
    public static final Block REDSTONE_FRAGMENTS = registerBlock("redstone_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.of().instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().mapColor(MapColor.COLOR_RED)));
    public static final Block LAPIS_LAZULI_FRAGMENTS = registerBlock("lapis_lazuli_fragments",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(LAPIS_ORE).mapColor(MapColor.LAPIS)));
    public static final Block MOSSY_COBBLESTONE_CHUNKS = registerBlock("mossy_cobblestone_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MOSSY_COBBLESTONE)));
    public static final Block COBBLESTONE_CHUNKS = registerBlock("cobblestone_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(COBBLESTONE)));
    public static final Block PRISMARINE_CHUNKS = registerBlock("prismarine_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(PRISMARINE)));
    public static final Block SANDSTONE_CHUNKS = registerBlock("sandstone_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(SANDSTONE)));
    public static final Block RED_SANDSTONE_CHUNKS = registerBlock("red_sandstone_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(RED_SANDSTONE)));
    public static final Block ENDSTONE_CHUNKS = registerBlock("endstone_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(END_STONE)));
    public static final Block DIORITE_CHUNKS = registerBlock("diorite_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DIORITE)));
    public static final Block GRANITE_CHUNKS = registerBlock("granite_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(GRANITE)));
    public static final Block ANDESITE_CHUNKS = registerBlock("andesite_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(ANDESITE)));
    public static final Block NETHERRACK_CHUNKS = registerBlock("netherrack_chunks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(NETHERRACK)));
    public static final Block DIRT_SMATTERING = registerBlock("dirt_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DIRT)));
    public static final Block MUD_SMATTERING = registerBlock("mud_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MUD)));
    public static final Block CLAY_SMATTERING = registerBlock("clay_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(CLAY)));
    public static final Block GRAVEL_SMATTERING = registerBlock("gravel_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(GRAVEL)));
    public static final Block SAND_SMATTERING = registerBlock("sand_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(SAND)));
    public static final Block RED_SAND_SMATTERING = registerBlock("red_sand_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(RED_SAND)));
    public static final Block ROOTED_DIRT_SMATTERING = registerBlock("rooted_dirt_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(ROOTED_DIRT)));
    public static final Block GRASS_SMATTERING = registerBlock("grass_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(GRASS_BLOCK)));
    public static final Block PODZOL_SMATTERING = registerBlock("podzol_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(PODZOL)));
    public static final Block WARPED_NYLIUM_SMATTERING = registerBlock("warped_nylium_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(WARPED_NYLIUM)));
    public static final Block CRIMSON_NYLIUM_SMATTERING = registerBlock("crimson_nylium_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(CRIMSON_NYLIUM)));
    public static final Block SOUL_SOIL_SMATTERING = registerBlock("soul_soil_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(SOUL_SOIL)));
    public static final Block SOUL_SAND_SMATTERING = registerBlock("soul_sand_smattering",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(Blocks.SOUL_SAND)));
    public static final Block SLIME_GLOBULES = registerBlock("slime_globules", new BaseVVBlock(
            FabricBlockSettings.copyOf(SLIME_BLOCK)));
    public static final Block NETHER_WART_SPROUTS = registerBlock("nether_wart_sprouts",
            new BaseVVBlock(FabricBlockSettings.copyOf(NETHER_WART)));
    public static final Block CRIMSON_VINES = registerBlock("crimson_vines", new SpreadableVVBlock(FabricBlockSettings
            .copyOf(WEEPING_VINES)));
    public static final Block ROSE_CREEPS = registerBlock("rose_creeps", new RoseCreepsBlock(
            FabricBlockSettings.copyOf(ROSE_BUSH).burnable()));
    public static final Block ROSE_VINES = registerBlock("rose_vines", new BonemealableVVBlock(
            FabricBlockSettings.copyOf(ROSE_BUSH).burnable(), ROSE_CREEPS));
    public static final Block WARPED_GROWTHS = registerBlock("warped_growths", new SpreadableVVBlock(FabricBlockSettings
            .copyOf(Blocks.NETHER_SPROUTS)));
    public static final Block BUDDING_WARPED_VINES = registerBlock("budding_warped_vines",
            new FruitingHyphaeVVBlock(FabricBlockSettings.copyOf(WARPED_ROOTS)));
    public static final Block WARPED_VINES = registerBlock("warped_vines", new BonemealableVVBlock(
            FabricBlockSettings.copyOf(WARPED_ROOTS), BUDDING_WARPED_VINES));
    public static final Block FRUITING_RED_HYPHAE = registerBlock("fruiting_red_hyphae", new FruitingHyphaeVVBlock(
            FabricBlockSettings.copyOf(RED_MUSHROOM).burnable()));
    public static final Block RED_HYPHAE = registerBlock("red_hyphae", new BonemealableVVBlock(
            FabricBlockSettings.copyOf(RED_MUSHROOM).burnable(), FRUITING_RED_HYPHAE));
    public static final Block FRUITING_BROWN_HYPHAE = registerBlock("fruiting_brown_hyphae", new FruitingHyphaeVVBlock(
            FabricBlockSettings.copyOf(BROWN_MUSHROOM).burnable()));
    public static final Block BROWN_HYPHAE = registerBlock("brown_hyphae", new BonemealableVVBlock(
            FabricBlockSettings.copyOf(BROWN_MUSHROOM).burnable(), FRUITING_BROWN_HYPHAE));
    public static final Block DEAD_CREEPS = registerBlock("dead_creeps", new SpreadableVVBlock(
            FabricBlockSettings.copyOf(DEAD_BUSH).burnable()));
    public static final Block ARCHAIC_CREEPS = registerBlock("archaic_creeps", new SpreadableVVBlock(
            FabricBlockSettings.copyOf(Blocks.SOUL_SAND).burnable().sound(SoundType.GRASS)));
    public static final Block ROOT_CREEPS = registerBlock("root_creeps", new SpreadableVVBlock(
            FabricBlockSettings.copyOf(HANGING_ROOTS).burnable()));
    public static final Block MYCELIUM_HYPHAE = registerBlock("mycelium_hyphae",
            new SpreadableVVBlock(FabricBlockSettings.copyOf(MYCELIUM).burnable()));
    public static final Block BUDDING_CRIMSON_HYPHAE = registerBlock("budding_crimson_hyphae",
            new BuddingHyphaeVVBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE),
                    Items.CRIMSON_FUNGUS.getDefaultInstance()));
    public static final Block CRIMSON_HYPHAE = registerBlock("crimson_hyphae",
            new BonemealableVVBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE), BUDDING_CRIMSON_HYPHAE));
    public static final Block BUDDING_WARPED_HYPHAE = registerBlock("budding_warped_hyphae",
            new BuddingHyphaeVVBlock(FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE),
                    Items.WARPED_FUNGUS.getDefaultInstance()));
    public static final Block WARPED_HYPHAE = registerBlock("warped_hyphae",
            new BonemealableVVBlock(FabricBlockSettings.copyOf(Blocks.WARPED_HYPHAE), BUDDING_WARPED_HYPHAE));
    public static final Block OAK_FOLIAGE = registerBlock("oak_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(OAK_LEAVES)));
    public static final Block SPRUCE_FOLIAGE = registerBlock("spruce_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(SPRUCE_LEAVES)));
    public static final Block BIRCH_FOLIAGE = registerBlock("birch_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(BIRCH_LEAVES)));
    public static final Block JUNGLE_FOLIAGE = registerBlock("jungle_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(JUNGLE_LEAVES)));
    public static final Block ACACIA_FOLIAGE = registerBlock("acacia_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(ACACIA_LEAVES)));
    public static final Block DARK_OAK_FOLIAGE = registerBlock("dark_oak_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(DARK_OAK_LEAVES)));
    public static final Block MANGROVE_FOLIAGE = registerBlock("mangrove_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(MANGROVE_LEAVES)));
    public static final Block CHERRY_FOLIAGE = registerBlock("cherry_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(CHERRY_LEAVES)));
    public static final Block AZALEA_FOLIAGE = registerBlock("azalea_foliage",
            new BaseVVBlock(FabricBlockSettings.copyOf(AZALEA_LEAVES)));
    public static final Block FLOWERING_AZALEA_FOLIAGE = registerBlock("flowering_azalea_foliage", new BaseVVBlock(
            FabricBlockSettings.copyOf(FLOWERING_AZALEA_LEAVES)));
    public static final Block FRUITING_GLOWBERRY_CREEPS = registerBlock("fruiting_glowberry_creeps",
            new FruitingGlowberryCreepsBlock(FabricBlockSettings.of().lightLevel(14).mapColor(MapColor.PLANT)
                    .noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final Block GLOWBERRY_CREEPS = registerBlock("glowberry_creeps",
            new GlowberryCreepsBlock(FabricBlockSettings.of().lightLevel(0).mapColor(MapColor.PLANT)
                    .noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY)));
    public static final Block BARE_GLOWBERRY_CREEPS = registerBlock("bare_glowberry_creeps",
            new BonemealableVVBlock(FabricBlockSettings.of().lightLevel(0).mapColor(MapColor.PLANT)
                    .noCollission().instabreak().sound(SoundType.CAVE_VINES).pushReaction(PushReaction.DESTROY), GLOWBERRY_CREEPS));
    public static final Block FRUITING_SWEET_BERRY_FOLIAGE = registerBlock("fruiting_sweet_berry_foliage",
            new FrutingSweetBerryFoliage(FabricBlockSettings.copyOf(SWEET_BERRY_BUSH)));
    public static final Block SWEET_BERRY_FOLIAGE = registerBlock("sweet_berry_foliage",
            new BonemealableVVBlock(FabricBlockSettings.copyOf(SWEET_BERRY_BUSH).mapColor(MapColor.PLANT),
                    FRUITING_SWEET_BERRY_FOLIAGE));
    public static final Block BAMBOO_FOLIAGE = registerBlock("bamboo_foliage", new BaseVVBlock(FabricBlockSettings
            .copyOf(BAMBOO)));
    public static final Block GRASS_SHOOTS = registerBlock("grass_shoots", new BaseVVBlock(FabricBlockSettings
            .copyOf(GRASS_BLOCK).burnable()));
    public static final Block MOSS_CLUMPS = registerBlock("moss_clumps", new SpreadableVVBlock(FabricBlockSettings
            .copyOf(MOSS_BLOCK).burnable()));
    public static final Block MOSS_GROWTH = registerBlock("moss_growth", new SpreadableVVBlock(FabricBlockSettings
            .copyOf(MOSS_BLOCK).burnable()));
    public static final Block AQUA_GOO_NODES = registerBlock("aqua_goo_nodes",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.COLOR_CYAN).lightLevel(4).sound(SoundType.SLIME_BLOCK)));
    public static final Block OCHRE_GOO_NODES = registerBlock("ochre_goo_nodes",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.SAND).lightLevel(4).sound(SoundType.SLIME_BLOCK)));
    public static final Block PEARLESCENT_GOO_NODES = registerBlock("pearlescent_goo_nodes",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.COLOR_PINK).lightLevel(4).sound(SoundType.SLIME_BLOCK)));
    public static final Block VERDANT_GOO_NODES = registerBlock("verdant_goo_nodes",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.GLOW_LICHEN).lightLevel(4).sound(SoundType.SLIME_BLOCK)));
    public static final Block AQUA_GOO_HYPHAE = registerBlock("aqua_goo_hyphae",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.COLOR_CYAN).lightLevel(8).sound(SoundType.SLIME_BLOCK)));
    public static final Block OCHRE_GOO_HYPHAE = registerBlock("ochre_goo_hyphae",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.SAND).lightLevel(8).sound(SoundType.SLIME_BLOCK)));
    public static final Block PEARLESCENT_GOO_HYPHAE = registerBlock("pearlescent_goo_hyphae",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.COLOR_PINK).lightLevel(8).sound(SoundType.SLIME_BLOCK)));
    public static final Block VERDANT_GOO_HYPHAE = registerBlock("verdant_goo_hyphae",
            new SpreadableVVBlock(FabricBlockSettings.of().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.GLOW_LICHEN).lightLevel(8).sound(SoundType.SLIME_BLOCK)));
    public static final Block BEACHED_KELP = registerBlock("beached_kelp", new BaseVVBlock(FabricBlockSettings.of()
            .burnable().strength(0.2f, 0.2f).requiresTool().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WET_GRASS)));
    public static final Block BEACHED_SEA_GRASS = registerBlock("beached_sea_grass",
            new BaseVVBlock(FabricBlockSettings.of().burnable().strength(0.2f, 0.2f).requiresTool()
                    .mapColor(MapColor.COLOR_GREEN).sound(SoundType.WET_GRASS)));
    public static final Block OAK_CREEPS = registerBlock("oak_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(OAK_WOOD)));
    public static final Block STRIPPED_OAK_CREEPS = registerBlock("stripped_oak_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_OAK_WOOD)));
    public static final Block BIRCH_CREEPS = registerBlock("birch_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(BIRCH_WOOD)));
    public static final Block STRIPPED_BIRCH_CREEPS = registerBlock("stripped_birch_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_BIRCH_WOOD)));
    public static final Block SPRUCE_CREEPS = registerBlock("spruce_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(SPRUCE_WOOD)));
    public static final Block STRIPPED_SPRUCE_CREEPS = registerBlock("stripped_spruce_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_SPRUCE_WOOD)));
    public static final Block JUNGLE_CREEPS = registerBlock("jungle_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(JUNGLE_WOOD)));
    public static final Block STRIPPED_JUNGLE_CREEPS = registerBlock("stripped_jungle_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_JUNGLE_WOOD)));
    public static final Block DARK_OAK_CREEPS = registerBlock("dark_oak_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DARK_OAK_WOOD)));
    public static final Block STRIPPED_DARK_OAK_CREEPS = registerBlock("stripped_dark_oak_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_DARK_OAK_WOOD)));
    public static final Block ACACIA_CREEPS = registerBlock("acacia_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(ACACIA_WOOD)));
    public static final Block STRIPPED_ACACIA_CREEPS = registerBlock("stripped_acacia_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_ACACIA_WOOD)));
    public static final Block MANGROVE_CREEPS = registerBlock("mangrove_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MANGROVE_WOOD)));
    public static final Block STRIPPED_MANGROVE_CREEPS = registerBlock("stripped_mangrove_creeps",
            new WaterloggableVVBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED)
                    .instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final Block CHERRY_CREEPS = registerBlock("cherry_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(CHERRY_WOOD)));
    public static final Block STRIPPED_CHERRY_CREEPS = registerBlock("stripped_cherry_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_CHERRY_WOOD)));
    public static final Block WARPED_CREEPS = registerBlock("warped_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(WARPED_HYPHAE)));
    public static final Block STRIPPED_WARPED_CREEPS = registerBlock("stripped_warped_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_WARPED_HYPHAE)));
    public static final Block CRIMSON_CREEPS = registerBlock("crimson_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(Blocks.CRIMSON_HYPHAE)));
    public static final Block STRIPPED_CRIMSON_CREEPS = registerBlock("stripped_crimson_creeps",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(STRIPPED_CRIMSON_HYPHAE)));
    public static final Block GRIME = registerBlock("grime", new BaseVVBlock(
            FabricBlockSettings.of().instabreak().mapColor(MapColor.COLOR_GRAY).sound(SoundType.SNOW)));
    public static final Block RUST = registerBlock("rust", new BaseVVBlock(
            FabricBlockSettings.of().instabreak().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.SNOW)));
    public static final Block DUST = registerBlock("dust", new BaseVVBlock(FabricBlockSettings.of().hardness(0)
            .resistance(0).mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.SNOW)));
    public static final Block SHODDY_OAK_PLANKS = registerBlock("shoddy_oak_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(OAK_PLANKS)));
    public static final Block SHODDY_BIRCH_PLANKS = registerBlock("shoddy_birch_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(BIRCH_PLANKS)));
    public static final Block SHODDY_SPRUCE_PLANKS = registerBlock("shoddy_spruce_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(SPRUCE_PLANKS)));
    public static final Block SHODDY_JUNGLE_PLANKS = registerBlock("shoddy_jungle_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(JUNGLE_PLANKS)));
    public static final Block SHODDY_ACACIA_PLANKS = registerBlock("shoddy_acacia_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(ACACIA_PLANKS)));
    public static final Block SHODDY_DARK_OAK_PLANKS = registerBlock("shoddy_dark_oak_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(DARK_OAK_PLANKS)));
    public static final Block SHODDY_MANGROVE_PLANKS = registerBlock("shoddy_mangrove_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(MANGROVE_PLANKS)));
    public static final Block SHODDY_CHERRY_PLANKS = registerBlock("shoddy_cherry_planks",
            new WaterloggableVVBlock(FabricBlockSettings.copyOf(CHERRY_PLANKS)));

    public static void initialize() {
        ((SpreadableVVBlock) BUDDING_WARPED_VINES).setSpreadBlock((BaseVVBlock) WARPED_VINES);
        ((SpreadableVVBlock) FRUITING_RED_HYPHAE).setSpreadBlock((BaseVVBlock) RED_HYPHAE);
        ((SpreadableVVBlock) FRUITING_BROWN_HYPHAE).setSpreadBlock((BaseVVBlock) BROWN_HYPHAE);
        ((SpreadableVVBlock) FRUITING_GLOWBERRY_CREEPS).setSpreadBlock((BaseVVBlock) GLOWBERRY_CREEPS);
        ((SpreadableVVBlock) BUDDING_CRIMSON_HYPHAE).setSpreadBlock((BaseVVBlock) CRIMSON_HYPHAE);
        ((SpreadableVVBlock) BUDDING_WARPED_HYPHAE).setSpreadBlock((BaseVVBlock) WARPED_HYPHAE);
        ((SpreadableVVBlock) AQUA_GOO_NODES).setSpreadBlock((BaseVVBlock) AQUA_GOO_HYPHAE);
        ((SpreadableVVBlock) OCHRE_GOO_NODES).setSpreadBlock((BaseVVBlock) OCHRE_GOO_HYPHAE);
        ((SpreadableVVBlock) PEARLESCENT_GOO_NODES).setSpreadBlock((BaseVVBlock) PEARLESCENT_GOO_HYPHAE);
        ((SpreadableVVBlock) VERDANT_GOO_NODES).setSpreadBlock((BaseVVBlock) VERDANT_GOO_HYPHAE);

        ((BuddingHyphaeVVBlock) BUDDING_CRIMSON_HYPHAE).setStrippedBlock(CRIMSON_HYPHAE);
        ((BuddingHyphaeVVBlock) BUDDING_WARPED_HYPHAE).setStrippedBlock(WARPED_HYPHAE);

        ((FruitingHyphaeVVBlock) BUDDING_WARPED_VINES).setShearedBlock(WARPED_VINES);
        ((FruitingHyphaeVVBlock) FRUITING_RED_HYPHAE).setShearedBlock(RED_HYPHAE);
        ((FruitingHyphaeVVBlock) FRUITING_BROWN_HYPHAE).setShearedBlock(BROWN_HYPHAE);

        registerCompostables();
        registerOxidizables();
        registerFuels();
    }

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

    public static void registerOxidizables() {
        OxidizableBlocksRegistry.registerOxidizableBlockPair(VVBlocks.COPPER_PLATING, VVBlocks.EXPOSED_COPPER_PLATING);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(VVBlocks.EXPOSED_COPPER_PLATING,
                VVBlocks.WEATHERED_COPPER_PLATING);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(VVBlocks.WEATHERED_COPPER_PLATING,
                VVBlocks.OXIDIZED_COPPER_PLATING);

        OxidizableBlocksRegistry.registerWaxableBlockPair(VVBlocks.COPPER_PLATING, VVBlocks.WAXED_COPPER_PLATING);
        OxidizableBlocksRegistry.registerWaxableBlockPair(VVBlocks.EXPOSED_COPPER_PLATING,
                VVBlocks.WAXED_EXPOSED_COPPER_PLATING);
        OxidizableBlocksRegistry.registerWaxableBlockPair(VVBlocks.WEATHERED_COPPER_PLATING,
                VVBlocks.WAXED_WEATHERED_COPPER_PLATING);
        OxidizableBlocksRegistry.registerWaxableBlockPair(VVBlocks.OXIDIZED_COPPER_PLATING,
                VVBlocks.WAXED_OXIDIZED_COPPER_PLATING);
    }

    public static void registerFuels() {
        FuelRegistry.INSTANCE.add(VVBlocks.DEAD_CREEPS, 100);
        FuelRegistry.INSTANCE.add(VVBlocks.ARCHAIC_CREEPS, 100);
        FuelRegistry.INSTANCE.add(VVBlocks.OAK_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_OAK_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.BIRCH_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_BIRCH_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SPRUCE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_SPRUCE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.JUNGLE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_JUNGLE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.DARK_OAK_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_DARK_OAK_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.ACACIA_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_ACACIA_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.MANGROVE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_MANGROVE_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.CHERRY_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_CHERRY_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.WARPED_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_WARPED_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.CRIMSON_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.STRIPPED_CRIMSON_CREEPS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_OAK_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_BIRCH_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_SPRUCE_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_JUNGLE_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_ACACIA_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_DARK_OAK_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_MANGROVE_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.SHODDY_CHERRY_PLANKS, 200);
        FuelRegistry.INSTANCE.add(VVBlocks.COAL_FRAGMENTS, 1600);
    }
}
