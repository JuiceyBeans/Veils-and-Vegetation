package com.juiceybeans.ubergrowth.client.datagen;

import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.Condition;
import net.minecraft.data.models.blockstates.MultiPartGenerator;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class UbergrowthModelGenerator extends FabricModelProvider {
    private static final ModelTemplate MULTIFACE_TEMPLATE = new ModelTemplate(
            Optional.of(Ubergrowth.id("block/ubergrowth_multiface")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    public UbergrowthModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        Set<Block> excluded = Set.of(UbergrowthBlocks.RUST, UbergrowthBlocks.DUST, UbergrowthBlocks.GRIME);

        for (Block block : UbergrowthBlocks.blocks) {
            this.createMultiface(generator, block, !excluded.contains(block));
            MULTIFACE_TEMPLATE.create(block, new TextureMapping().put(TextureSlot.TEXTURE,
                    Ubergrowth.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath())), generator.modelOutput);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(UbergrowthBlocks.RUST.asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UbergrowthBlocks.DUST.asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(UbergrowthBlocks.GRIME.asItem(), ModelTemplates.FLAT_ITEM);
    }

    public final void createMultiface(BlockModelGenerators generator, Block multifaceBlock, boolean generateItemModel) {
        if (generateItemModel) generator.createSimpleFlatItemModel(multifaceBlock);

        ResourceLocation resourceLocation = ModelLocationUtils.getModelLocation(multifaceBlock);
        MultiPartGenerator multiPartGenerator = MultiPartGenerator.multiPart(multifaceBlock);
        Condition.TerminalCondition terminalCondition = Util.make(
                Condition.condition(), terminalConditionx -> BlockModelGenerators.MULTIFACE_GENERATOR.stream().map(Pair::getFirst).forEach(booleanPropertyx -> {
                    if (multifaceBlock.defaultBlockState().hasProperty(booleanPropertyx)) {
                        terminalConditionx.term(booleanPropertyx, false);
                    }
                })
        );

        for (Pair<BooleanProperty, Function<ResourceLocation, Variant>> pair : BlockModelGenerators.MULTIFACE_GENERATOR) {
            BooleanProperty booleanProperty = pair.getFirst();
            Function<ResourceLocation, Variant> function = pair.getSecond();
            if (multifaceBlock.defaultBlockState().hasProperty(booleanProperty)) {
                multiPartGenerator.with(Condition.condition().term(booleanProperty, true), function.apply(resourceLocation));
                multiPartGenerator.with(terminalCondition, function.apply(resourceLocation));
            }
        }

        generator.blockStateOutput.accept(multiPartGenerator);
    }
}
