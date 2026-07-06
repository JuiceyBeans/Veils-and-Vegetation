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
                FRUITING_GLOWBERRY_CREEPS,
                FRUITING_SWEET_BERRY_FOLIAGE,
                GRIME,
                RUST,
                DUST
        );

        for (Block block : blocks) {
            if (!dropNothing.contains(block)) this.dropSelf(block);
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
        this.add(OAK_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(OAK_FOLIAGE, Items.OAK_SAPLING, 0.05f));
        this.add(SPRUCE_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(SPRUCE_FOLIAGE, Items.SPRUCE_SAPLING, 0.05f));
        this.add(BIRCH_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(BIRCH_FOLIAGE, Items.BIRCH_SAPLING, 0.05f));
        this.add(JUNGLE_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(JUNGLE_FOLIAGE, Items.JUNGLE_SAPLING, 0.025f));
        this.add(ACACIA_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(ACACIA_FOLIAGE, Items.ACACIA_SAPLING, 0.05f));
        this.add(DARK_OAK_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(DARK_OAK_FOLIAGE, Items.DARK_OAK_SAPLING, 0.05f));
        this.add(CHERRY_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(CHERRY_FOLIAGE, Items.CHERRY_SAPLING, 0.05f));
        this.add(AZALEA_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(AZALEA_FOLIAGE, Items.AZALEA, 0.05f));
        this.add(FLOWERING_AZALEA_FOLIAGE, createShearsOrSilkTouchOrChancedDropTable(FLOWERING_AZALEA_FOLIAGE, Items.FLOWERING_AZALEA, 0.05f));
        this.add(GRASS_SHOOTS, createShearsOrSilkTouchOrChancedDropTable(GRASS_SHOOTS, Items.WHEAT_SEEDS, 0.125f));
        this.dropOther(BEACHED_KELP, Items.KELP);
        this.add(OAK_CREEPS, createShearsOrSilkTouchOrFixedDropTable(OAK_CREEPS, Items.STICK));
        this.add(STRIPPED_OAK_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_OAK_CREEPS, Items.STICK));
        this.add(BIRCH_CREEPS, createShearsOrSilkTouchOrFixedDropTable(BIRCH_CREEPS, Items.STICK));
        this.add(STRIPPED_BIRCH_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_BIRCH_CREEPS, Items.STICK));
        this.add(SPRUCE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(SPRUCE_CREEPS, Items.STICK));
        this.add(STRIPPED_SPRUCE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_SPRUCE_CREEPS, Items.STICK));
        this.add(JUNGLE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(JUNGLE_CREEPS, Items.STICK));
        this.add(STRIPPED_JUNGLE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_JUNGLE_CREEPS, Items.STICK));
        this.add(DARK_OAK_CREEPS, createShearsOrSilkTouchOrFixedDropTable(DARK_OAK_CREEPS, Items.STICK));
        this.add(STRIPPED_DARK_OAK_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_DARK_OAK_CREEPS, Items.STICK));
        this.add(ACACIA_CREEPS, createShearsOrSilkTouchOrFixedDropTable(ACACIA_CREEPS, Items.STICK));
        this.add(STRIPPED_ACACIA_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_ACACIA_CREEPS, Items.STICK));
        this.add(MANGROVE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(MANGROVE_CREEPS, Items.STICK));
        this.add(STRIPPED_MANGROVE_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_MANGROVE_CREEPS, Items.STICK));
        this.add(CHERRY_CREEPS, createShearsOrSilkTouchOrFixedDropTable(CHERRY_CREEPS, Items.STICK));
        this.add(STRIPPED_CHERRY_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_CHERRY_CREEPS, Items.STICK));
        this.add(WARPED_CREEPS, createShearsOrSilkTouchOrFixedDropTable(WARPED_CREEPS, Items.STICK));
        this.add(STRIPPED_WARPED_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_WARPED_CREEPS, Items.STICK));
        this.add(CRIMSON_CREEPS, createShearsOrSilkTouchOrFixedDropTable(CRIMSON_CREEPS, Items.STICK));
        this.add(STRIPPED_CRIMSON_CREEPS, createShearsOrSilkTouchOrFixedDropTable(STRIPPED_CRIMSON_CREEPS, Items.STICK));
        this.add(SHODDY_OAK_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_BIRCH_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_SPRUCE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_JUNGLE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_ACACIA_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_DARK_OAK_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_MANGROVE_PLANKS, createShoddyPlanksTable());
        this.add(SHODDY_CHERRY_PLANKS, createShoddyPlanksTable());

        this.add(DEAD_CREEPS, createShearsOrSilkTouchTable(DEAD_CREEPS));
        this.add(ARCHAIC_CREEPS, createShearsOrSilkTouchTable(ARCHAIC_CREEPS));
        this.add(OAK_CREEPS, createShearsOrSilkTouchTable(OAK_CREEPS));
        this.add(STRIPPED_OAK_CREEPS, createShearsOrSilkTouchTable(STRIPPED_OAK_CREEPS));
        this.add(BIRCH_CREEPS, createShearsOrSilkTouchTable(BIRCH_CREEPS));
        this.add(STRIPPED_BIRCH_CREEPS, createShearsOrSilkTouchTable(STRIPPED_BIRCH_CREEPS));
        this.add(SPRUCE_CREEPS, createShearsOrSilkTouchTable(SPRUCE_CREEPS));
        this.add(STRIPPED_SPRUCE_CREEPS, createShearsOrSilkTouchTable(STRIPPED_SPRUCE_CREEPS));
        this.add(JUNGLE_CREEPS, createShearsOrSilkTouchTable(JUNGLE_CREEPS));
        this.add(STRIPPED_JUNGLE_CREEPS, createShearsOrSilkTouchTable(STRIPPED_JUNGLE_CREEPS));
        this.add(DARK_OAK_CREEPS, createShearsOrSilkTouchTable(DARK_OAK_CREEPS));
        this.add(STRIPPED_DARK_OAK_CREEPS, createShearsOrSilkTouchTable(STRIPPED_DARK_OAK_CREEPS));
        this.add(ACACIA_CREEPS, createShearsOrSilkTouchTable(ACACIA_CREEPS));
        this.add(STRIPPED_ACACIA_CREEPS, createShearsOrSilkTouchTable(STRIPPED_ACACIA_CREEPS));
        this.add(MANGROVE_CREEPS, createShearsOrSilkTouchTable(MANGROVE_CREEPS));
        this.add(STRIPPED_MANGROVE_CREEPS, createShearsOrSilkTouchTable(STRIPPED_MANGROVE_CREEPS));
        this.add(CHERRY_CREEPS, createShearsOrSilkTouchTable(CHERRY_CREEPS));
        this.add(STRIPPED_CHERRY_CREEPS, createShearsOrSilkTouchTable(STRIPPED_CHERRY_CREEPS));
        this.add(WARPED_CREEPS, createShearsOrSilkTouchTable(WARPED_CREEPS));
        this.add(STRIPPED_WARPED_CREEPS, createShearsOrSilkTouchTable(STRIPPED_WARPED_CREEPS));
        this.add(CRIMSON_CREEPS, createShearsOrSilkTouchTable(CRIMSON_CREEPS));
        this.add(STRIPPED_CRIMSON_CREEPS, createShearsOrSilkTouchTable(STRIPPED_CRIMSON_CREEPS));
        this.add(NETHER_WART_SPROUTS, createShearsOrSilkTouchTable(NETHER_WART_SPROUTS));
        this.add(CRIMSON_VINES, createShearsOrSilkTouchTable(CRIMSON_VINES));
        this.add(ROSE_CREEPS, createShearsOrSilkTouchTable(ROSE_CREEPS));
        this.add(ROSE_VINES, createShearsOrSilkTouchTable(ROSE_VINES));
        this.add(WARPED_GROWTHS, createShearsOrSilkTouchTable(WARPED_GROWTHS));
        this.add(WARPED_VINES, createShearsOrSilkTouchTable(WARPED_VINES));
        this.add(RED_HYPHAE, createShearsOrSilkTouchTable(RED_HYPHAE));
        this.add(BROWN_HYPHAE, createShearsOrSilkTouchTable(BROWN_HYPHAE));
        this.add(ROOT_CREEPS, createShearsOrSilkTouchTable(ROOT_CREEPS));
        this.add(MYCELIUM_HYPHAE, createShearsOrSilkTouchTable(MYCELIUM_HYPHAE));
        this.add(CRIMSON_HYPHAE, createShearsOrSilkTouchTable(CRIMSON_HYPHAE));
        this.add(WARPED_HYPHAE, createShearsOrSilkTouchTable(WARPED_HYPHAE));
        this.add(OAK_FOLIAGE, createShearsOrSilkTouchTable(OAK_FOLIAGE));
        this.add(SPRUCE_FOLIAGE, createShearsOrSilkTouchTable(SPRUCE_FOLIAGE));
        this.add(BIRCH_FOLIAGE, createShearsOrSilkTouchTable(BIRCH_FOLIAGE));
        this.add(JUNGLE_FOLIAGE, createShearsOrSilkTouchTable(JUNGLE_FOLIAGE));
        this.add(ACACIA_FOLIAGE, createShearsOrSilkTouchTable(ACACIA_FOLIAGE));
        this.add(DARK_OAK_FOLIAGE, createShearsOrSilkTouchTable(DARK_OAK_FOLIAGE));
        this.add(MANGROVE_FOLIAGE, createShearsOrSilkTouchTable(MANGROVE_FOLIAGE));
        this.add(CHERRY_FOLIAGE, createShearsOrSilkTouchTable(CHERRY_FOLIAGE));
        this.add(AZALEA_FOLIAGE, createShearsOrSilkTouchTable(AZALEA_FOLIAGE));
        this.add(FLOWERING_AZALEA_FOLIAGE, createShearsOrSilkTouchTable(FLOWERING_AZALEA_FOLIAGE));
        this.add(GLOWBERRY_CREEPS, createShearsOrSilkTouchTable(GLOWBERRY_CREEPS));
        this.add(BARE_GLOWBERRY_CREEPS, createShearsOrSilkTouchTable(BARE_GLOWBERRY_CREEPS));
        this.add(BAMBOO_FOLIAGE, createShearsOrSilkTouchTable(BAMBOO_FOLIAGE));
        this.add(GRASS_SHOOTS, createShearsOrSilkTouchTable(GRASS_SHOOTS));
        this.add(MOSS_CLUMPS, createShearsOrSilkTouchTable(MOSS_CLUMPS));
        this.add(AQUA_GOO_HYPHAE, createShearsOrSilkTouchTable(AQUA_GOO_HYPHAE));
        this.add(OCHRE_GOO_HYPHAE, createShearsOrSilkTouchTable(OCHRE_GOO_HYPHAE));
        this.add(PEARLESCENT_GOO_HYPHAE, createShearsOrSilkTouchTable(PEARLESCENT_GOO_HYPHAE));
        this.add(VERDANT_GOO_HYPHAE, createShearsOrSilkTouchTable(VERDANT_GOO_HYPHAE));
        this.add(BEACHED_KELP, createShearsOrSilkTouchTable(BEACHED_KELP));
        this.add(BEACHED_SEA_GRASS, createShearsOrSilkTouchTable(BEACHED_SEA_GRASS));
    }

    private LootTable.Builder createSingleItemTableWithCount(ItemLike item, float count) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(item))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)))));
    }

    private LootTable.Builder createSingleItemTableWithChance(ItemLike item, float chance) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(item))
                        .when(LootItemRandomChanceCondition.randomChance(chance))));
    }

    private LootTable.Builder createFruitingTable(ItemLike hyphae, ItemLike mushroom) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(hyphae, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(hyphae))))
                .withPool(this.applyExplosionCondition(mushroom, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(mushroom))));
    }

    private LootTable.Builder createShoddyPlanksTable() {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(Items.STICK, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.STICK))
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))));
    }

    private LootTable.Builder createShearsOrSilkTouchTable(Block block) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(block).when(HAS_SHEARS_OR_SILK_TOUCH)));
    }

    private LootTable.Builder createShearsOrSilkTouchOrFixedDropTable(Block block, ItemLike drop) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(drop, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(drop))
                        .when(HAS_SHEARS_OR_SILK_TOUCH.invert())))
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(block))
                        .when(HAS_SHEARS_OR_SILK_TOUCH)));
    }

    private LootTable.Builder createShearsOrSilkTouchOrChancedDropTable(Block block, ItemLike drop, float chance) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionCondition(drop, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(drop)
                                .when(LootItemRandomChanceCondition.randomChance(chance)))
                        .when(HAS_SHEARS_OR_SILK_TOUCH.invert())))
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(block))
                        .when(HAS_SHEARS_OR_SILK_TOUCH)));
    }
}
