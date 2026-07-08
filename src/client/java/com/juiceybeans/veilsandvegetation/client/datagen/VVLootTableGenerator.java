package com.juiceybeans.veilsandvegetation.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

import static com.juiceybeans.veilsandvegetation.init.VVBlocks.*;

public class VVLootTableGenerator extends FabricBlockLootTableProvider {
    protected VVLootTableGenerator(FabricDataOutput dataOutput) {
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
            if (!dropNothing.contains(block)) this.dropSelfMultiface(block);
        }

        dropOtherMultiface(TACKED_NOTES, Items.PAPER, 2.0f);
        dropOtherMultiface(TACKED_PAPER, Items.PAPER, 2.0f);
        dropOtherMultiface(SPLAYED_LEATHER, Items.LEATHER);
        dropOtherMultiface(SPLAYED_HIDE, Items.RABBIT_HIDE); //todo check if rabbit hide is right

        dropOtherMultiface(COPPER_ORE_FRAGMENTS, Items.COPPER_ORE);
        dropOtherMultiface(IRON_ORE_FRAGMENTS, Items.IRON_ORE);
        dropOtherMultiface(GOLD_ORE_FRAGMENTS, Items.GOLD_ORE);
        dropOtherMultiface(NETHER_QUARTZ_FRAGMENTS, Items.QUARTZ);
        dropOtherMultiface(EMERALD_FRAGMENTS, Items.EMERALD);
        dropOtherMultiface(DIAMOND_FRAGMENTS, Items.DIAMOND);
        dropOtherMultiface(COAL_FRAGMENTS, Items.COAL);
        dropOtherMultiface(REDSTONE_FRAGMENTS, Items.REDSTONE);
        dropOtherMultiface(LAPIS_LAZULI_FRAGMENTS, Items.LAPIS_LAZULI);

        dropOtherMultiface(CLAY_SMATTERING, Items.CLAY_BALL);
        dropItemWithChanceMultiface(GRAVEL_SMATTERING, Items.FLINT, 0.1f);

        dropOtherMultiface(SLIME_GLOBULES, Items.SLIME_BALL);
        dropOtherMultiface(BUDDING_WARPED_VINES, WARPED_VINES);

        createFruitingTable(FRUITING_RED_HYPHAE, RED_HYPHAE, Items.RED_MUSHROOM);
        createFruitingTable(FRUITING_BROWN_HYPHAE, BROWN_HYPHAE, Items.BROWN_MUSHROOM);
        dropOtherMultiface(BUDDING_CRIMSON_HYPHAE, CRIMSON_HYPHAE);
        dropOtherMultiface(BUDDING_WARPED_HYPHAE, WARPED_HYPHAE);

        dropOtherMultiface(BEACHED_KELP, Items.KELP);

        createShearsOrSilkTouchOrFixedDropTable(OAK_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_OAK_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(BIRCH_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_BIRCH_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(SPRUCE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_SPRUCE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(JUNGLE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_JUNGLE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(DARK_OAK_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_DARK_OAK_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(ACACIA_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_ACACIA_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(MANGROVE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_MANGROVE_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(CHERRY_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_CHERRY_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(WARPED_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_WARPED_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(CRIMSON_CREEPS, Items.STICK);
        createShearsOrSilkTouchOrFixedDropTable(STRIPPED_CRIMSON_CREEPS, Items.STICK);

        createShoddyPlanksTable(SHODDY_OAK_PLANKS);
        createShoddyPlanksTable(SHODDY_BIRCH_PLANKS);
        createShoddyPlanksTable(SHODDY_SPRUCE_PLANKS);
        createShoddyPlanksTable(SHODDY_JUNGLE_PLANKS);
        createShoddyPlanksTable(SHODDY_ACACIA_PLANKS);
        createShoddyPlanksTable(SHODDY_DARK_OAK_PLANKS);
        createShoddyPlanksTable(SHODDY_MANGROVE_PLANKS);
        createShoddyPlanksTable(SHODDY_CHERRY_PLANKS);

        createShearsOrSilkTouchOrFixedDropTable(NETHER_WART_SPROUTS, Items.NETHER_WART);
        createShearsOrSilkTouchTable(CRIMSON_VINES);
        createShearsOrSilkTouchTable(ROSE_CREEPS);
        createShearsOrSilkTouchTable(ROSE_VINES);
        createShearsOrSilkTouchTable(WARPED_GROWTHS);
        createShearsOrSilkTouchTable(WARPED_VINES);
        createShearsOrSilkTouchTable(RED_HYPHAE);
        createShearsOrSilkTouchTable(BROWN_HYPHAE);
        createShearsOrSilkTouchTable(ROOT_CREEPS);
        createShearsOrSilkTouchTable(DEAD_CREEPS);
        createShearsOrSilkTouchTable(ARCHAIC_CREEPS);
        createShearsOrSilkTouchTable(MYCELIUM_HYPHAE);
        createShearsOrSilkTouchTable(CRIMSON_HYPHAE);
        createShearsOrSilkTouchTable(WARPED_HYPHAE);

        createShearsOrSilkTouchOrChancedDropTable(OAK_FOLIAGE, Items.OAK_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(SPRUCE_FOLIAGE, Items.SPRUCE_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(BIRCH_FOLIAGE, Items.BIRCH_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(JUNGLE_FOLIAGE, Items.JUNGLE_SAPLING, 0.025f);
        createShearsOrSilkTouchOrChancedDropTable(ACACIA_FOLIAGE, Items.ACACIA_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(DARK_OAK_FOLIAGE, Items.DARK_OAK_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(CHERRY_FOLIAGE, Items.CHERRY_SAPLING, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(AZALEA_FOLIAGE, Items.AZALEA, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(FLOWERING_AZALEA_FOLIAGE, Items.FLOWERING_AZALEA, 0.05f);
        createShearsOrSilkTouchOrChancedDropTable(GRASS_SHOOTS, Items.WHEAT_SEEDS, 0.125f);

        createShearsOrSilkTouchTable(GLOWBERRY_CREEPS);
        createShearsOrSilkTouchTable(BARE_GLOWBERRY_CREEPS);
        createShearsOrSilkTouchTable(BAMBOO_FOLIAGE);
        createShearsOrSilkTouchTable(MOSS_CLUMPS);
        createShearsOrSilkTouchTable(MOSS_GROWTH);

        createShearsOrSilkTouchTable(AQUA_GOO_HYPHAE);
        createShearsOrSilkTouchTable(OCHRE_GOO_HYPHAE);
        createShearsOrSilkTouchTable(PEARLESCENT_GOO_HYPHAE);
        createShearsOrSilkTouchTable(VERDANT_GOO_HYPHAE);

        createShearsOrSilkTouchTable(BEACHED_KELP);
        createShearsOrSilkTouchTable(BEACHED_SEA_GRASS);
    }

    private void dropOtherMultiface(Block block, ItemLike item, float count) {
        var builder = LootTable.lootTable().withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0)))));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(ConstantValue.exactly(count), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        this.add(block, builder);
    }

    public void dropOtherMultiface(Block block, ItemLike item) {
        dropOtherMultiface(block, item, 1.0f);
    }

    public void dropSelfMultiface(Block block) {
        dropOtherMultiface(block, block.asItem(), 1.0f);
    }

    private void dropItemWithChanceMultiface(Block block, ItemLike item, float chance) {
        var builder =  LootTable.lootTable()
                .withPool(this.applyExplosionCondition(item, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(item))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0)))));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true)))
                        .when(LootItemRandomChanceCondition.randomChance(chance)));
            }
        }

        this.add(block, builder);
    }

    private void createFruitingTable(Block block, ItemLike hyphae, ItemLike mushroom) {
        var builder = LootTable.lootTable()
                .withPool(this.applyExplosionCondition(hyphae, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(hyphae)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0))))
                .withPool(this.applyExplosionCondition(mushroom, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(mushroom)))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0))));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        this.add(block, builder);
    }

    private void createShoddyPlanksTable(Block block) {
        var builder = LootTable.lootTable()
                .withPool(this.applyExplosionCondition(Items.STICK, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(Items.STICK))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0), true))));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        this.add(block, builder);
    }

    private void createShearsOrSilkTouchTable(Block block, ItemLike item) {
        var builder = LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(item).when(HAS_SHEARS_OR_SILK_TOUCH))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0))));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        this.add(block, builder);
    }

    private void createShearsOrSilkTouchTable(Block block) {
        createShearsOrSilkTouchTable(block, block.asItem());
    }

    private void createShearsOrSilkTouchOrFixedDropTable(Block block, ItemLike drop) {
        var builder = LootTable.lootTable()
                .withPool(this.applyExplosionCondition(drop, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(drop))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0)))
                        .when(HAS_SHEARS_OR_SILK_TOUCH.invert())))
                .withPool(this.applyExplosionCondition(block, LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(block))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0)))
                        .when(HAS_SHEARS_OR_SILK_TOUCH)));

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                builder.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        this.add(block, builder);
    }

    private void createShearsOrSilkTouchOrChancedDropTable(Block block, ItemLike drop, float chance) {
        LootPool.Builder itemPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(drop)
                                .when(LootItemRandomChanceCondition.randomChance(chance)))
                        .when(HAS_SHEARS_OR_SILK_TOUCH.invert());

        LootPool.Builder blockPool = LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0f))
                        .add(LootItem.lootTableItem(block))
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(0)))
                        .when(HAS_SHEARS_OR_SILK_TOUCH);

        for (Direction dir : Direction.values()) {
            BooleanProperty prop = PipeBlock.PROPERTY_BY_DIRECTION.get(dir);
            if (block.getStateDefinition().getProperties().contains(prop)) {
                blockPool.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true)))
                        .when(LootItemRandomChanceCondition.randomChance(chance)));

                blockPool.apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0f), true)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(prop, true))));
            }
        }

        LootTable.Builder builder = LootTable.lootTable()
                .withPool(this.applyExplosionCondition(drop, itemPool))
                .withPool(this.applyExplosionCondition(block, blockPool));

        this.add(block, builder);
    }
}
