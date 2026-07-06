package com.juiceybeans.ubergrowth.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

import static com.juiceybeans.ubergrowth.init.UbergrowthBlocks.*;

public class UbergrowthLootTableGenerator extends FabricBlockLootTableProvider {
    protected UbergrowthLootTableGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        Set<Block> dropNothing = Set.of(
                COBBLESTONE_CHUNKS,
                PRISMARINE_CHUNKS,
                SANDSTONE_CHUNKS,
                RED_SANDSTONE_CHUNKS,
                ENDSTONE_CHUNKS,
                DIORITE_CHUNKS,
                GRANITE_CHUNKS,
                ANDESITE_CHUNKS,
                NETHERRACK_CHUNKS,
                DIRT_SMATTERING,
                MUD_SMATTERING,
                SAND_SMATTERING,
                RED_SAND_SMATTERING,
                ROOTED_DIRT_SMATTERING,
                GRASS_SMATTERING,
                PODZOL_SMATTERING,
                WARPED_NYLIUM_SMATTERING,
                CRIMSON_NYLIUM_SMATTERING,
                SOUL_SOIL_SMATTERING,
                SOUL_SAND_SMATTERING,
                CRIMSON_VINES,
                ROSE_VINES,
                DEAD_CREEPS,
                ARCHAIC_CREEPS,
                ROOT_CREEPS,
                MYCELIUM_HYPHAE,
                MANGROVE_FOLIAGE,
                GLOWBERRY_CREEPS,
                FRUITING_GLOWBERRY_CREEPS,
                BARE_GLOWBERRY_CREEPS,
                FRUITING_SWEET_BERRY_FOLIAGE,
                SWEET_BERRY_FOLIAGE,
                BAMBOO_FOLIAGE,
                MOSS_CLUMPS,
                AQUA_GOO_HYPHAE,
                OCHRE_GOO_HYPHAE,
                PEARLESCENT_GOO_HYPHAE,
                VERDANT_GOO_HYPHAE,
                BEACHED_SEA_GRASS,
                GRIME,
                RUST,
                DUST
        );

        for (Block block : blocks) {
            if (dropNothing.contains(block)) this.dropSelf(block);
        }

        this.add(TACKED_NOTES, createSingleItemTableWithCount(Items.PAPER, 2.0f));
        this.add(TACKED_PAPER, createSingleItemTableWithCount(Items.PAPER, 2.0f));
        this.dropOther(SPLAYED_LEATHER, Items.LEATHER);
        this.dropOther(SPLAYED_HIDE, Items.RABBIT_HIDE); //todo check if rabbit hide is right
        this.dropOther(COPPER_ORE_FRAGMENTS, Items.COPPER_ORE);
        this.dropOther(IRON_ORE_FRAGMENTS, Items.IRON_ORE);
        this.dropOther(GOLD_ORE_FRAGMENTS, Items.GOLD_ORE);
        this.dropOther(NETHER_QUARTZ_FRAGMENTS, Items.QUARTZ);
        this.dropOther(EMERALD_FRAGMENTS, Items.EMERALD);
        this.dropOther(DIAMOND_FRAGMENTS, Items.DIAMOND);
        this.dropOther(COAL_FRAGMENTS, Items.COAL);
        this.dropOther(REDSTONE_FRAGMENTS, Items.REDSTONE);
        this.dropOther(LAPIS_LAZULI_FRAGMENTS, Items.LAPIS_LAZULI);
        this.dropOther(CLAY_SMATTERING, Items.CLAY_BALL);
        this.add(GRAVEL_SMATTERING, createSingleItemTableWithChance(Items.FLINT, 0.1f));
        this.dropOther(SLIME_GLOBULES, Items.SLIME_BALL);
        this.dropOther(NETHER_WART_SPROUTS, Items.NETHER_WART);
        this.dropOther(BUDDING_WARPED_VINES, WARPED_VINES);
        this.add(FRUITING_RED_HYPHAE, createFruitingTable(RED_HYPHAE, Items.RED_MUSHROOM));
        this.add(FRUITING_BROWN_HYPHAE, createFruitingTable(BROWN_HYPHAE, Items.BROWN_MUSHROOM));
        this.dropOther(BUDDING_CRIMSON_HYPHAE, CRIMSON_HYPHAE);
        this.dropOther(BUDDING_WARPED_HYPHAE, WARPED_HYPHAE);
        this.add(OAK_FOLIAGE, createSingleItemTableWithChance(Items.OAK_SAPLING, 0.05f));
        this.add(SPRUCE_FOLIAGE, createSingleItemTableWithChance(Items.SPRUCE_SAPLING, 0.05f));
        this.add(BIRCH_FOLIAGE, createSingleItemTableWithChance(Items.BIRCH_SAPLING, 0.05f));
        this.add(JUNGLE_FOLIAGE, createSingleItemTableWithChance(Items.JUNGLE_SAPLING, 0.025f));
        this.add(ACACIA_FOLIAGE, createSingleItemTableWithChance(Items.ACACIA_SAPLING, 0.05f));
        this.add(DARK_OAK_FOLIAGE, createSingleItemTableWithChance(Items.DARK_OAK_SAPLING, 0.05f));
        this.add(CHERRY_FOLIAGE, createSingleItemTableWithChance(Items.CHERRY_SAPLING, 0.05f));
        this.add(AZALEA_FOLIAGE, createSingleItemTableWithChance(Items.AZALEA, 0.05f));
        this.add(FLOWERING_AZALEA_FOLIAGE, createSingleItemTableWithChance(Items.FLOWERING_AZALEA, 0.05f));
        this.add(GRASS_SHOOTS, createSingleItemTableWithChance(Items.WHEAT_SEEDS, 0.125f));
        this.dropOther(BEACHED_KELP, Items.KELP);
        this.dropOther(OAK_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_OAK_CREEPS, Items.STICK);
        this.dropOther(BIRCH_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_BIRCH_CREEPS, Items.STICK);
        this.dropOther(SPRUCE_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_SPRUCE_CREEPS, Items.STICK);
        this.dropOther(JUNGLE_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_JUNGLE_CREEPS, Items.STICK);
        this.dropOther(DARK_OAK_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_DARK_OAK_CREEPS, Items.STICK);
        this.dropOther(ACACIA_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_ACACIA_CREEPS, Items.STICK);
        this.dropOther(MANGROVE_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_MANGROVE_CREEPS, Items.STICK);
        this.dropOther(CHERRY_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_CHERRY_CREEPS, Items.STICK);
        this.dropOther(WARPED_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_WARPED_CREEPS, Items.STICK);
        this.dropOther(CRIMSON_CREEPS, Items.STICK);
        this.dropOther(STRIPPED_CRIMSON_CREEPS, Items.STICK);
        this.add(SHODDY_OAK_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_BIRCH_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_SPRUCE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_JUNGLE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_ACACIA_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_DARK_OAK_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_MANGROVE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_CHERRY_PLANKS, createShoddyPlanksTable());
    }

    public LootTable.Builder createSingleItemTableWithCount(ItemLike item, float count) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(item))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)))));
    }

    public LootTable.Builder createSingleItemTableWithChance(ItemLike item, float chance) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(item))
                        .when(LootItemRandomChanceCondition.randomChance(chance))));
    }

    public LootTable.Builder createFruitingTable(ItemLike hyphae, ItemLike mushroom) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(hyphae, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(hyphae))))
                .withPool(this.applyExplosionCondition(mushroom, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(mushroom))));
    }

    public LootTable.Builder createShoddyPlanksTable() {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(Items.STICK, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.STICK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))));
    }
}
