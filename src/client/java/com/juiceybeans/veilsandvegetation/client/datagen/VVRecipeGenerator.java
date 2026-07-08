package com.juiceybeans.veilsandvegetation.client.datagen;

import com.juiceybeans.veilsandvegetation.VeilsAndVegetation;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

import static com.juiceybeans.veilsandvegetation.init.VVBlocks.*;
import static com.juiceybeans.veilsandvegetation.init.VVBlocks.CRIMSON_HYPHAE;
import static com.juiceybeans.veilsandvegetation.init.VVBlocks.WARPED_HYPHAE;
import static net.minecraft.world.item.Items.*;

public class VVRecipeGenerator extends FabricRecipeProvider {
    public VVRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> writer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TACKED_PAPER)
                .requires(PAPER, 2)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(PAPER))
                .save(writer, VeilsAndVegetation.id("tacked_paper"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, TACKED_NOTES)
                .requires(PAPER, 2)
                .requires(IRON_NUGGET)
                .requires(Ingredient.of(INK_SAC, BLACK_DYE, CHARCOAL))
                .unlockedBy("has_item", has(PAPER))
                .save(writer, VeilsAndVegetation.id("tacked_notes"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SPLAYED_LEATHER)
                .requires(LEATHER)
                .requires(IRON_NUGGET)
                .requires(STRING)
                .unlockedBy("has_item", has(LEATHER))
                .save(writer, VeilsAndVegetation.id("splayed_leather"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SPLAYED_HIDE)
                .requires(RABBIT_HIDE)
                .requires(IRON_NUGGET)
                .requires(STRING)
                .unlockedBy("has_item", has(RABBIT_HIDE))
                .save(writer, VeilsAndVegetation.id("splayed_hide"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, STONE_BRICK_CHUNKS, 4)
                .requires(STONE_BRICKS, 2)
                .unlockedBy("has_item", has(STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("stone_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, STONE_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("stone_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MOSSY_STONE_BRICK_CHUNKS, 4)
                .requires(MOSSY_STONE_BRICKS, 2)
                .unlockedBy("has_item", has(MOSSY_STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("mossy_stone_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MOSSY_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, MOSSY_STONE_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(MOSSY_STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("mossy_stone_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BRICK_CHUNKS, 4)
                .requires(BRICKS, 2)
                .unlockedBy("has_item", has(BRICKS))
                .save(writer, VeilsAndVegetation.id("brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(BRICKS), RecipeCategory.BUILDING_BLOCKS, BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(BRICKS))
                .save(writer, VeilsAndVegetation.id("brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MUD_BRICK_CHUNKS, 4)
                .requires(MUD_BRICKS, 2)
                .unlockedBy("has_item", has(MUD_BRICKS))
                .save(writer, VeilsAndVegetation.id("mud_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MUD_BRICKS), RecipeCategory.BUILDING_BLOCKS, MUD_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(MUD_BRICKS))
                .save(writer, VeilsAndVegetation.id("mud_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_BRICK_CHUNKS, 4)
                .requires(DEEPSLATE_BRICKS, 2)
                .unlockedBy("has_item", has(DEEPSLATE_BRICKS))
                .save(writer, VeilsAndVegetation.id("deepslate_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DEEPSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(DEEPSLATE_BRICKS))
                .save(writer, VeilsAndVegetation.id("deepslate_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_BRICK_CHUNKS, 4)
                .requires(POLISHED_BLACKSTONE_BRICKS, 2)
                .unlockedBy("has_item", has(POLISHED_BLACKSTONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("blackstone_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(POLISHED_BLACKSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(POLISHED_BLACKSTONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("blackstone_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, NETHERWART_BRICK_CHUNKS, 4)
                .requires(RED_NETHER_BRICKS, 2)
                .unlockedBy("has_item", has(RED_NETHER_BRICKS))
                .save(writer, VeilsAndVegetation.id("netherwart_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(RED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, NETHERWART_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(RED_NETHER_BRICKS))
                .save(writer, VeilsAndVegetation.id("netherwart_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, NETHER_BRICK_CHUNKS, 4)
                .requires(NETHER_BRICKS, 2)
                .unlockedBy("has_item", has(NETHER_BRICKS))
                .save(writer, VeilsAndVegetation.id("nether_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, NETHER_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(NETHER_BRICKS))
                .save(writer, VeilsAndVegetation.id("nether_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, QUARTZ_BRICK_CHUNKS, 4)
                .requires(QUARTZ_BRICKS, 2)
                .unlockedBy("has_item", has(QUARTZ_BRICKS))
                .save(writer, VeilsAndVegetation.id("quartz_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(QUARTZ_BRICKS), RecipeCategory.BUILDING_BLOCKS, QUARTZ_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(QUARTZ_BRICKS))
                .save(writer, VeilsAndVegetation.id("quartz_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ENDSTONE_BRICK_CHUNKS, 4)
                .requires(END_STONE_BRICKS, 2)
                .unlockedBy("has_item", has(END_STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("endstone_brick_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(END_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ENDSTONE_BRICK_CHUNKS, 2)
                .unlockedBy("has_item", has(END_STONE_BRICKS))
                .save(writer, VeilsAndVegetation.id("endstone_brick_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PURPUR_CHUNKS, 4)
                .requires(PURPUR_BLOCK, 2)
                .unlockedBy("has_item", has(PURPUR_BLOCK))
                .save(writer, VeilsAndVegetation.id("purpur_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(PURPUR_BLOCK), RecipeCategory.BUILDING_BLOCKS, PURPUR_CHUNKS, 2)
                .unlockedBy("has_item", has(PURPUR_BLOCK))
                .save(writer, VeilsAndVegetation.id("purpur_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, COPPER_PLATING, 16)
                .requires(COPPER_BLOCK, 2)
                .unlockedBy("has_item", has(COPPER_BLOCK))
                .save(writer, VeilsAndVegetation.id("copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(COPPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, COPPER_PLATING, 8)
                .unlockedBy("has_item", has(COPPER_BLOCK))
                .save(writer, VeilsAndVegetation.id("copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, EXPOSED_COPPER_PLATING, 16)
                .requires(EXPOSED_COPPER, 2)
                .unlockedBy("has_item", has(EXPOSED_COPPER))
                .save(writer, VeilsAndVegetation.id("exposed_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(EXPOSED_COPPER), RecipeCategory.BUILDING_BLOCKS, EXPOSED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(EXPOSED_COPPER))
                .save(writer, VeilsAndVegetation.id("exposed_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WEATHERED_COPPER_PLATING, 16)
                .requires(WEATHERED_COPPER, 2)
                .unlockedBy("has_item", has(WEATHERED_COPPER))
                .save(writer, VeilsAndVegetation.id("weathered_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(WEATHERED_COPPER), RecipeCategory.BUILDING_BLOCKS, WEATHERED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(WEATHERED_COPPER))
                .save(writer, VeilsAndVegetation.id("weathered_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, OXIDIZED_COPPER_PLATING, 16)
                .requires(OXIDIZED_COPPER, 2)
                .unlockedBy("has_item", has(OXIDIZED_COPPER))
                .save(writer, VeilsAndVegetation.id("oxidized_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(OXIDIZED_COPPER), RecipeCategory.BUILDING_BLOCKS, OXIDIZED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(OXIDIZED_COPPER))
                .save(writer, VeilsAndVegetation.id("oxidized_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_COPPER_PLATING, 16)
                .requires(WAXED_COPPER_BLOCK, 2)
                .unlockedBy("has_item", has(WAXED_COPPER_BLOCK))
                .save(writer, VeilsAndVegetation.id("waxed_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(WAXED_COPPER_BLOCK), RecipeCategory.BUILDING_BLOCKS, WAXED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(WAXED_COPPER_BLOCK))
                .save(writer, VeilsAndVegetation.id("waxed_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_EXPOSED_COPPER_PLATING, 16)
                .requires(WAXED_EXPOSED_COPPER, 2)
                .unlockedBy("has_item", has(WAXED_EXPOSED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_exposed_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(EXPOSED_COPPER), RecipeCategory.BUILDING_BLOCKS, WAXED_EXPOSED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(WAXED_EXPOSED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_exposed_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_WEATHERED_COPPER_PLATING, 16)
                .requires(WAXED_WEATHERED_COPPER, 2)
                .unlockedBy("has_item", has(WEATHERED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_weathered_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(WAXED_WEATHERED_COPPER), RecipeCategory.BUILDING_BLOCKS, WAXED_WEATHERED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(WAXED_WEATHERED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_weathered_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WAXED_OXIDIZED_COPPER_PLATING, 16)
                .requires(WAXED_OXIDIZED_COPPER, 2)
                .unlockedBy("has_item", has(WAXED_OXIDIZED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_oxidized_copper_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(WAXED_OXIDIZED_COPPER), RecipeCategory.BUILDING_BLOCKS, WAXED_OXIDIZED_COPPER_PLATING, 8)
                .unlockedBy("has_item", has(WAXED_OXIDIZED_COPPER))
                .save(writer, VeilsAndVegetation.id("waxed_oxidized_copper_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING, 16)
                .requires(GOLD_BLOCK, 2)
                .unlockedBy("has_item", has(GOLD_BLOCK))
                .save(writer, VeilsAndVegetation.id("gold_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GOLD_BLOCK), RecipeCategory.BUILDING_BLOCKS, GOLD_PLATING, 8)
                .unlockedBy("has_item", has(GOLD_BLOCK))
                .save(writer, VeilsAndVegetation.id("gold_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, IRON_PLATING, 16)
                .requires(IRON_BLOCK, 2)
                .unlockedBy("has_item", has(IRON_BLOCK))
                .save(writer, VeilsAndVegetation.id("iron_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IRON_BLOCK), RecipeCategory.BUILDING_BLOCKS, IRON_PLATING, 8)
                .unlockedBy("has_item", has(IRON_BLOCK))
                .save(writer, VeilsAndVegetation.id("iron_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, NETHERITE_PLATING, 16)
                .requires(NETHERITE_BLOCK, 2)
                .unlockedBy("has_item", has(NETHERITE_BLOCK))
                .save(writer, VeilsAndVegetation.id("netherite_plating"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(NETHERITE_BLOCK), RecipeCategory.BUILDING_BLOCKS, NETHERITE_PLATING, 8)
                .unlockedBy("has_item", has(NETHERITE_BLOCK))
                .save(writer, VeilsAndVegetation.id("netherite_plating_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, COPPER_ORE_FRAGMENTS, 16)
                .requires(COPPER_ORE, 2)
                .unlockedBy("has_item", has(COPPER_ORE))
                .save(writer, VeilsAndVegetation.id("copper_ore_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(COPPER_ORE), RecipeCategory.MISC, COPPER_ORE_FRAGMENTS, 8)
                .unlockedBy("has_item", has(COPPER_ORE))
                .save(writer, VeilsAndVegetation.id("copper_ore_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, IRON_ORE_FRAGMENTS, 16)
                .requires(IRON_ORE, 2)
                .unlockedBy("has_item", has(IRON_ORE))
                .save(writer, VeilsAndVegetation.id("iron_ore_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(IRON_ORE), RecipeCategory.MISC, IRON_ORE_FRAGMENTS, 8)
                .unlockedBy("has_item", has(IRON_ORE))
                .save(writer, VeilsAndVegetation.id("iron_ore_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GOLD_ORE_FRAGMENTS, 16)
                .requires(GOLD_ORE, 2)
                .unlockedBy("has_item", has(GOLD_ORE))
                .save(writer, VeilsAndVegetation.id("gold_ore_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GOLD_ORE), RecipeCategory.MISC, GOLD_ORE_FRAGMENTS, 8)
                .unlockedBy("has_item", has(GOLD_ORE))
                .save(writer, VeilsAndVegetation.id("gold_ore_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NETHER_QUARTZ_FRAGMENTS, 8)
                .requires(QUARTZ_BLOCK, 2)
                .unlockedBy("has_item", has(QUARTZ_BLOCK))
                .save(writer, VeilsAndVegetation.id("nether_quartz_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(QUARTZ_BLOCK), RecipeCategory.MISC, NETHER_QUARTZ_FRAGMENTS, 4)
                .unlockedBy("has_item", has(QUARTZ_BLOCK))
                .save(writer, VeilsAndVegetation.id("nether_quartz_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, EMERALD_FRAGMENTS, 16)
                .requires(EMERALD_BLOCK, 2)
                .unlockedBy("has_item", has(EMERALD_BLOCK))
                .save(writer, VeilsAndVegetation.id("emerald_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(EMERALD_BLOCK), RecipeCategory.MISC, EMERALD_FRAGMENTS, 8)
                .unlockedBy("has_item", has(EMERALD_BLOCK))
                .save(writer, VeilsAndVegetation.id("emerald_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DIAMOND_FRAGMENTS, 16)
                .requires(DIAMOND_BLOCK, 2)
                .unlockedBy("has_item", has(DIAMOND_BLOCK))
                .save(writer, VeilsAndVegetation.id("diamond_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DIAMOND_BLOCK), RecipeCategory.MISC, DIAMOND_FRAGMENTS, 8)
                .unlockedBy("has_item", has(DIAMOND_BLOCK))
                .save(writer, VeilsAndVegetation.id("diamond_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, COAL_FRAGMENTS, 16)
                .requires(COAL_BLOCK, 2)
                .unlockedBy("has_item", has(COAL_BLOCK))
                .save(writer, VeilsAndVegetation.id("coal_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(COAL_BLOCK), RecipeCategory.MISC, COAL_FRAGMENTS, 8)
                .unlockedBy("has_item", has(COAL_BLOCK))
                .save(writer, VeilsAndVegetation.id("coal_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, REDSTONE_FRAGMENTS, 16)
                .requires(REDSTONE_BLOCK, 2)
                .unlockedBy("has_item", has(REDSTONE_BLOCK))
                .save(writer, VeilsAndVegetation.id("redstone_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(REDSTONE_BLOCK), RecipeCategory.MISC, REDSTONE_FRAGMENTS, 8)
                .unlockedBy("has_item", has(REDSTONE_BLOCK))
                .save(writer, VeilsAndVegetation.id("redstone_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, LAPIS_LAZULI_FRAGMENTS, 16)
                .requires(LAPIS_BLOCK, 2)
                .unlockedBy("has_item", has(LAPIS_BLOCK))
                .save(writer, VeilsAndVegetation.id("lapis_lazuli_fragments"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(LAPIS_BLOCK), RecipeCategory.MISC, LAPIS_LAZULI_FRAGMENTS, 8)
                .unlockedBy("has_item", has(LAPIS_BLOCK))
                .save(writer, VeilsAndVegetation.id("lapis_lazuli_fragments_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE_CHUNKS, 4)
                .requires(MOSSY_COBBLESTONE, 2)
                .unlockedBy("has_item", has(MOSSY_COBBLESTONE))
                .save(writer, VeilsAndVegetation.id("mossy_cobblestone_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MOSSY_COBBLESTONE), RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLESTONE_CHUNKS, 2)
                .unlockedBy("has_item", has(MOSSY_COBBLESTONE))
                .save(writer, VeilsAndVegetation.id("mossy_cobblestone_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_CHUNKS, 4)
                .requires(COBBLESTONE, 2)
                .unlockedBy("has_item", has(COBBLESTONE))
                .save(writer, VeilsAndVegetation.id("cobblestone_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(COBBLESTONE), RecipeCategory.BUILDING_BLOCKS, COBBLESTONE_CHUNKS, 2)
                .unlockedBy("has_item", has(COBBLESTONE))
                .save(writer, VeilsAndVegetation.id("cobblestone_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PRISMARINE_CHUNKS, 4)
                .requires(PRISMARINE, 2)
                .unlockedBy("has_item", has(PRISMARINE))
                .save(writer, VeilsAndVegetation.id("prismarine_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(PRISMARINE), RecipeCategory.BUILDING_BLOCKS, PRISMARINE_CHUNKS, 2)
                .unlockedBy("has_item", has(PRISMARINE))
                .save(writer, VeilsAndVegetation.id("prismarine_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SANDSTONE_CHUNKS, 4)
                .requires(SANDSTONE, 2)
                .unlockedBy("has_item", has(SANDSTONE))
                .save(writer, VeilsAndVegetation.id("sandstone_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(SANDSTONE), RecipeCategory.BUILDING_BLOCKS, SANDSTONE_CHUNKS, 2)
                .unlockedBy("has_item", has(SANDSTONE))
                .save(writer, VeilsAndVegetation.id("sandstone_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_CHUNKS, 4)
                .requires(RED_SANDSTONE, 2)
                .unlockedBy("has_item", has(RED_SANDSTONE))
                .save(writer, VeilsAndVegetation.id("red_sandstone_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(RED_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_CHUNKS, 2)
                .unlockedBy("has_item", has(RED_SANDSTONE))
                .save(writer, VeilsAndVegetation.id("red_sandstone_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ENDSTONE_CHUNKS, 4)
                .requires(END_STONE, 2)
                .unlockedBy("has_item", has(END_STONE))
                .save(writer, VeilsAndVegetation.id("endstone_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(END_STONE), RecipeCategory.BUILDING_BLOCKS, ENDSTONE_CHUNKS, 2)
                .unlockedBy("has_item", has(END_STONE))
                .save(writer, VeilsAndVegetation.id("endstone_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DIORITE_CHUNKS, 4)
                .requires(DIORITE, 2)
                .unlockedBy("has_item", has(DIORITE))
                .save(writer, VeilsAndVegetation.id("diorite_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(DIORITE), RecipeCategory.BUILDING_BLOCKS, DIORITE_CHUNKS, 2)
                .unlockedBy("has_item", has(DIORITE))
                .save(writer, VeilsAndVegetation.id("diorite_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GRANITE_CHUNKS, 4)
                .requires(GRANITE, 2)
                .unlockedBy("has_item", has(GRANITE))
                .save(writer, VeilsAndVegetation.id("granite_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(GRANITE), RecipeCategory.BUILDING_BLOCKS, GRANITE_CHUNKS, 2)
                .unlockedBy("has_item", has(GRANITE))
                .save(writer, VeilsAndVegetation.id("granite_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ANDESITE_CHUNKS, 4)
                .requires(ANDESITE, 2)
                .unlockedBy("has_item", has(ANDESITE))
                .save(writer, VeilsAndVegetation.id("andesite_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ANDESITE), RecipeCategory.BUILDING_BLOCKS, ANDESITE_CHUNKS, 2)
                .unlockedBy("has_item", has(ANDESITE))
                .save(writer, VeilsAndVegetation.id("andesite_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, NETHERRACK_CHUNKS, 4)
                .requires(NETHERRACK, 2)
                .unlockedBy("has_item", has(NETHERRACK))
                .save(writer, VeilsAndVegetation.id("netherrack_chunks"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(NETHERRACK), RecipeCategory.BUILDING_BLOCKS, NETHERRACK_CHUNKS, 2)
                .unlockedBy("has_item", has(NETHERRACK))
                .save(writer, VeilsAndVegetation.id("netherrack_chunks_from_stonecutter"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, DIRT_SMATTERING, 4)
                .requires(DIRT, 2)
                .unlockedBy("has_item", has(DIRT))
                .save(writer, VeilsAndVegetation.id("dirt_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, MUD_SMATTERING, 4)
                .requires(MUD, 2)
                .unlockedBy("has_item", has(MUD))
                .save(writer, VeilsAndVegetation.id("mud_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CLAY_SMATTERING, 4)
                .requires(CLAY, 2)
                .unlockedBy("has_item", has(CLAY))
                .save(writer, VeilsAndVegetation.id("clay_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GRAVEL_SMATTERING, 4)
                .requires(GRAVEL, 2)
                .unlockedBy("has_item", has(GRAVEL))
                .save(writer, VeilsAndVegetation.id("gravel_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SAND_SMATTERING, 4)
                .requires(SAND, 2)
                .unlockedBy("has_item", has(SAND))
                .save(writer, VeilsAndVegetation.id("sand_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, RED_SAND_SMATTERING, 4)
                .requires(RED_SAND, 2)
                .unlockedBy("has_item", has(RED_SAND))
                .save(writer, VeilsAndVegetation.id("red_sand_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ROOTED_DIRT_SMATTERING, 4)
                .requires(ROOTED_DIRT, 2)
                .unlockedBy("has_item", has(ROOTED_DIRT))
                .save(writer, VeilsAndVegetation.id("rooted_dirt_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, GRASS_SMATTERING, 4)
                .requires(GRASS_BLOCK, 2)
                .unlockedBy("has_item", has(GRASS_BLOCK))
                .save(writer, VeilsAndVegetation.id("grass_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, PODZOL_SMATTERING, 4)
                .requires(PODZOL, 2)
                .unlockedBy("has_item", has(PODZOL))
                .save(writer, VeilsAndVegetation.id("podzol_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, WARPED_NYLIUM_SMATTERING, 4)
                .requires(WARPED_NYLIUM, 2)
                .unlockedBy("has_item", has(WARPED_NYLIUM))
                .save(writer, VeilsAndVegetation.id("warped_nylium_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CRIMSON_NYLIUM_SMATTERING, 4)
                .requires(CRIMSON_NYLIUM, 2)
                .unlockedBy("has_item", has(CRIMSON_NYLIUM))
                .save(writer, VeilsAndVegetation.id("crimson_nylium_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SOUL_SOIL_SMATTERING, 4)
                .requires(SOUL_SOIL, 2)
                .unlockedBy("has_item", has(SOUL_SOIL))
                .save(writer, VeilsAndVegetation.id("soul_soil_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SOUL_SAND_SMATTERING, 4)
                .requires(SOUL_SAND, 2)
                .unlockedBy("has_item", has(SOUL_SAND))
                .save(writer, VeilsAndVegetation.id("soul_sand_smattering"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, SLIME_GLOBULES, 4)
                .requires(SLIME_BALL, 3)
                .unlockedBy("has_item", has(SLIME_BALL))
                .save(writer, VeilsAndVegetation.id("slime_globules"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, NETHER_WART_SPROUTS, 4)
                .requires(NETHER_WART, 3)
                .unlockedBy("has_item", has(NETHER_WART))
                .save(writer, VeilsAndVegetation.id("nether_wart_sprouts"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CRIMSON_VINES, 4)
                .requires(CRIMSON_ROOTS, 3)
                .unlockedBy("has_item", has(CRIMSON_ROOTS))
                .save(writer, VeilsAndVegetation.id("crimson_vines"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ROSE_CREEPS, 4)
                .requires(ROSE_BUSH, 3)
                .unlockedBy("has_item", has(ROSE_BUSH))
                .save(writer, VeilsAndVegetation.id("rose_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WARPED_GROWTHS, 4)
                .requires(NETHER_SPROUTS, 3)
                .unlockedBy("has_item", has(NETHER_SPROUTS))
                .save(writer, VeilsAndVegetation.id("warped_growths"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WARPED_VINES, 2)
                .requires(WARPED_ROOTS, 3)
                .unlockedBy("has_item", has(WARPED_ROOTS))
                .save(writer, VeilsAndVegetation.id("warped_vines"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, RED_HYPHAE, 4)
                .requires(RED_MUSHROOM, 3)
                .unlockedBy("has_item", has(RED_MUSHROOM))
                .save(writer, VeilsAndVegetation.id("red_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BROWN_HYPHAE, 4)
                .requires(BROWN_MUSHROOM, 3)
                .unlockedBy("has_item", has(BROWN_MUSHROOM))
                .save(writer, VeilsAndVegetation.id("brown_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, DEAD_CREEPS, 4)
                .requires(DEAD_BUSH, 3)
                .unlockedBy("has_item", has(DEAD_BUSH))
                .save(writer, VeilsAndVegetation.id("dead_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ARCHAIC_CREEPS, 4)
                .requires(DEAD_CREEPS, 3)
                .requires(SOUL_SAND)
                .unlockedBy("has_item", has(DEAD_CREEPS))
                .save(writer, VeilsAndVegetation.id("archaic_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ROOT_CREEPS, 4)
                .requires(HANGING_ROOTS, 3)
                .unlockedBy("has_item", has(HANGING_ROOTS))
                .save(writer, VeilsAndVegetation.id("root_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MYCELIUM_HYPHAE, 2)
                .requires(MYCELIUM)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(MYCELIUM))
                .save(writer, VeilsAndVegetation.id("mycelium_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CRIMSON_HYPHAE, 4)
                .requires(CRIMSON_FUNGUS, 3)
                .unlockedBy("has_item", has(CRIMSON_FUNGUS))
                .save(writer, VeilsAndVegetation.id("crimson_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WARPED_HYPHAE, 4)
                .requires(WARPED_FUNGUS, 3)
                .unlockedBy("has_item", has(WARPED_FUNGUS))
                .save(writer, VeilsAndVegetation.id("warped_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, OAK_FOLIAGE, 4)
                .requires(OAK_LEAVES, 3)
                .unlockedBy("has_item", has(OAK_LEAVES))
                .save(writer, VeilsAndVegetation.id("oak_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SPRUCE_FOLIAGE, 4)
                .requires(SPRUCE_LEAVES, 3)
                .unlockedBy("has_item", has(SPRUCE_LEAVES))
                .save(writer, VeilsAndVegetation.id("spruce_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BIRCH_FOLIAGE, 4)
                .requires(BIRCH_LEAVES, 3)
                .unlockedBy("has_item", has(BIRCH_LEAVES))
                .save(writer, VeilsAndVegetation.id("birch_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, JUNGLE_FOLIAGE, 4)
                .requires(JUNGLE_LEAVES, 3)
                .unlockedBy("has_item", has(JUNGLE_LEAVES))
                .save(writer, VeilsAndVegetation.id("jungle_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ACACIA_FOLIAGE, 4)
                .requires(ACACIA_LEAVES, 3)
                .unlockedBy("has_item", has(ACACIA_LEAVES))
                .save(writer, VeilsAndVegetation.id("acacia_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, DARK_OAK_FOLIAGE, 4)
                .requires(DARK_OAK_LEAVES, 3)
                .unlockedBy("has_item", has(DARK_OAK_LEAVES))
                .save(writer, VeilsAndVegetation.id("dark_oak_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MANGROVE_FOLIAGE, 4)
                .requires(MANGROVE_LEAVES, 3)
                .unlockedBy("has_item", has(MANGROVE_LEAVES))
                .save(writer, VeilsAndVegetation.id("mangrove_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CHERRY_FOLIAGE, 4)
                .requires(CHERRY_LEAVES, 3)
                .unlockedBy("has_item", has(CHERRY_LEAVES))
                .save(writer, VeilsAndVegetation.id("cherry_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AZALEA_FOLIAGE, 4)
                .requires(AZALEA_LEAVES, 3)
                .unlockedBy("has_item", has(AZALEA_LEAVES))
                .save(writer, VeilsAndVegetation.id("azalea_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, FLOWERING_AZALEA_FOLIAGE, 4)
                .requires(FLOWERING_AZALEA_LEAVES, 3)
                .unlockedBy("has_item", has(FLOWERING_AZALEA_LEAVES))
                .save(writer, VeilsAndVegetation.id("flowering_azalea_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, GLOWBERRY_CREEPS, 4)
                .requires(GLOW_BERRIES, 2)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(GLOW_BERRIES))
                .save(writer, VeilsAndVegetation.id("glowberry_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SWEET_BERRY_FOLIAGE, 4)
                .requires(SWEET_BERRIES, 2)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(SWEET_BERRIES))
                .save(writer, VeilsAndVegetation.id("sweet_berry_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BAMBOO_FOLIAGE, 2)
                .requires(BAMBOO)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(BAMBOO))
                .save(writer, VeilsAndVegetation.id("bamboo_foliage"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, GRASS_SHOOTS, 2)
                .requires(GRASS)
                .requires(WHEAT_SEEDS)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(GRASS))
                .save(writer, VeilsAndVegetation.id("grass_shoots"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MOSS_CLUMPS, 4)
                .requires(MOSS_BLOCK, 2)
                .unlockedBy("has_item", has(MOSS_BLOCK))
                .save(writer, VeilsAndVegetation.id("moss_clumps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MOSS_GROWTH, 6)
                .requires(MOSS_CARPET, 2)
                .unlockedBy("has_item", has(MOSS_CARPET))
                .save(writer, VeilsAndVegetation.id("moss_growth"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AQUA_GOO_NODES)
                .requires(WATER_BUCKET)
                .requires(SLIME_BALL)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(WATER_BUCKET))
                .save(writer, VeilsAndVegetation.id("aqua_goo_nodes"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, OCHRE_GOO_NODES, 4)
                .requires(OCHRE_FROGLIGHT, 2)
                .unlockedBy("has_item", has(OCHRE_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("ochre_goo_nodes"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, PEARLESCENT_GOO_NODES, 4)
                .requires(PEARLESCENT_FROGLIGHT, 2)
                .unlockedBy("has_item", has(PEARLESCENT_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("pearlescent_goo_nodes"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, VERDANT_GOO_NODES, 4)
                .requires(VERDANT_FROGLIGHT, 2)
                .unlockedBy("has_item", has(VERDANT_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("verdant_goo_nodes"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, AQUA_GOO_HYPHAE, 2)
                .requires(AQUA_GOO_NODES)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(WATER_BUCKET))
                .save(writer, VeilsAndVegetation.id("aqua_goo_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, OCHRE_GOO_HYPHAE, 2)
                .requires(OCHRE_FROGLIGHT)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(OCHRE_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("ochre_goo_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, PEARLESCENT_GOO_HYPHAE, 2)
                .requires(PEARLESCENT_FROGLIGHT)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(PEARLESCENT_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("pearlescent_goo_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, VERDANT_GOO_HYPHAE, 2)
                .requires(VERDANT_FROGLIGHT)
                .requires(BONE_MEAL)
                .unlockedBy("has_item", has(VERDANT_FROGLIGHT))
                .save(writer, VeilsAndVegetation.id("verdant_goo_hyphae"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BEACHED_KELP, 4)
                .requires(KELP, 3)
                .unlockedBy("has_item", has(KELP))
                .save(writer, VeilsAndVegetation.id("beached_kelp"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BEACHED_SEA_GRASS, 4)
                .requires(SEAGRASS, 3)
                .unlockedBy("has_item", has(SEAGRASS))
                .save(writer, VeilsAndVegetation.id("beached_sea_grass"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, OAK_CREEPS, 6)
                .requires(OAK_WOOD, 2)
                .unlockedBy("has_item", has(OAK_WOOD))
                .save(writer, VeilsAndVegetation.id("oak_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_OAK_CREEPS, 6)
                .requires(STRIPPED_OAK_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_OAK_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_oak_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, BIRCH_CREEPS, 6)
                .requires(BIRCH_WOOD, 2)
                .unlockedBy("has_item", has(BIRCH_WOOD))
                .save(writer, VeilsAndVegetation.id("birch_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_BIRCH_CREEPS, 6)
                .requires(STRIPPED_BIRCH_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_BIRCH_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_birch_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, SPRUCE_CREEPS, 6)
                .requires(SPRUCE_WOOD, 2)
                .unlockedBy("has_item", has(SPRUCE_WOOD))
                .save(writer, VeilsAndVegetation.id("spruce_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_SPRUCE_CREEPS, 6)
                .requires(STRIPPED_SPRUCE_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_SPRUCE_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_spruce_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, JUNGLE_CREEPS, 6)
                .requires(JUNGLE_WOOD, 2)
                .unlockedBy("has_item", has(JUNGLE_WOOD))
                .save(writer, VeilsAndVegetation.id("jungle_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_JUNGLE_CREEPS, 6)
                .requires(STRIPPED_JUNGLE_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_JUNGLE_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_jungle_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, DARK_OAK_CREEPS, 6)
                .requires(DARK_OAK_WOOD, 2)
                .unlockedBy("has_item", has(DARK_OAK_WOOD))
                .save(writer, VeilsAndVegetation.id("dark_oak_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_DARK_OAK_CREEPS, 6)
                .requires(STRIPPED_DARK_OAK_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_DARK_OAK_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_dark_oak_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ACACIA_CREEPS, 6)
                .requires(ACACIA_WOOD, 2)
                .unlockedBy("has_item", has(ACACIA_WOOD))
                .save(writer, VeilsAndVegetation.id("acacia_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_ACACIA_CREEPS, 6)
                .requires(STRIPPED_ACACIA_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_ACACIA_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_acacia_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, MANGROVE_CREEPS, 6)
                .requires(MANGROVE_WOOD, 2)
                .unlockedBy("has_item", has(MANGROVE_WOOD))
                .save(writer, VeilsAndVegetation.id("mangrove_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_MANGROVE_CREEPS, 6)
                .requires(STRIPPED_MANGROVE_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_MANGROVE_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_mangrove_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CHERRY_CREEPS, 6)
                .requires(CHERRY_WOOD, 2)
                .unlockedBy("has_item", has(CHERRY_WOOD))
                .save(writer, VeilsAndVegetation.id("cherry_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_CHERRY_CREEPS, 6)
                .requires(STRIPPED_CHERRY_WOOD, 2)
                .unlockedBy("has_item", has(STRIPPED_CHERRY_WOOD))
                .save(writer, VeilsAndVegetation.id("stripped_cherry_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, WARPED_CREEPS, 6)
                .requires(Items.WARPED_HYPHAE, 2)
                .unlockedBy("has_item", has(Items.WARPED_HYPHAE))
                .save(writer, VeilsAndVegetation.id("warped_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_WARPED_CREEPS, 6)
                .requires(Items.STRIPPED_WARPED_HYPHAE, 2)
                .unlockedBy("has_item", has(Items.STRIPPED_WARPED_HYPHAE))
                .save(writer, VeilsAndVegetation.id("stripped_warped_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, CRIMSON_CREEPS, 6)
                .requires(Items.CRIMSON_HYPHAE, 2)
                .unlockedBy("has_item", has(Items.CRIMSON_HYPHAE))
                .save(writer, VeilsAndVegetation.id("crimson_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, STRIPPED_CRIMSON_CREEPS, 6)
                .requires(Items.STRIPPED_CRIMSON_HYPHAE, 2)
                .unlockedBy("has_item", has(Items.STRIPPED_CRIMSON_HYPHAE))
                .save(writer, VeilsAndVegetation.id("stripped_crimson_creeps"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GRIME, 9)
                .requires(ROTTEN_FLESH)
                .requires(DIRT)
                .requires(Ingredient.of(COBWEB, STRING))
                .unlockedBy("has_item", has(ROTTEN_FLESH))
                .save(writer, VeilsAndVegetation.id("grime"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RUST, 9)
                .requires(RAW_IRON)
                .requires(WATER_BUCKET)
                .unlockedBy("has_item", has(RAW_IRON))
                .save(writer, VeilsAndVegetation.id("rust"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, RUST, 81)
                .requires(RAW_IRON_BLOCK)
                .requires(WATER_BUCKET)
                .unlockedBy("has_item", has(RAW_IRON_BLOCK))
                .save(writer, VeilsAndVegetation.id("rust_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, DUST, 9)
                .requires(GUNPOWDER)
                .requires(SAND)
                .requires(Ingredient.of(COBWEB, STRING))
                .unlockedBy("has_item", has(GUNPOWDER))
                .save(writer, VeilsAndVegetation.id("dust"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_OAK_PLANKS, 9)
                .requires(OAK_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(OAK_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_oak_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_BIRCH_PLANKS, 9)
                .requires(BIRCH_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(BIRCH_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_birch_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_SPRUCE_PLANKS, 9)
                .requires(SPRUCE_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(SPRUCE_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_spruce_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_JUNGLE_PLANKS, 9)
                .requires(JUNGLE_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(JUNGLE_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_jungle_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_ACACIA_PLANKS, 9)
                .requires(ACACIA_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(ACACIA_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_acacia_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_DARK_OAK_PLANKS, 9)
                .requires(DARK_OAK_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(DARK_OAK_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_dark_oak_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_MANGROVE_PLANKS, 9)
                .requires(MANGROVE_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(MANGROVE_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_mangrove_planks"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, SHODDY_CHERRY_PLANKS, 9)
                .requires(CHERRY_PLANKS, 3)
                .requires(IRON_NUGGET)
                .unlockedBy("has_item", has(CHERRY_PLANKS))
                .save(writer, VeilsAndVegetation.id("shoddy_cherry_planks"));
    }
}