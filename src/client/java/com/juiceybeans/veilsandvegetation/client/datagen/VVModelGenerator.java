package com.juiceybeans.veilsandvegetation.client.datagen;

import com.juiceybeans.veilsandvegetation.VeilsAndVegetation;
import com.juiceybeans.veilsandvegetation.init.VVBlocks;
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

public class VVModelGenerator extends FabricModelProvider {
    Set<Block> excludeItemModel = Set.of(VVBlocks.RUST, VVBlocks.DUST, VVBlocks.GRIME);
    Set<Block> foliage = Set.of(
            VVBlocks.ACACIA_FOLIAGE,
            VVBlocks.AZALEA_FOLIAGE,
            VVBlocks.BIRCH_FOLIAGE,
            VVBlocks.CHERRY_FOLIAGE,
            VVBlocks.DARK_OAK_FOLIAGE,
            VVBlocks.FLOWERING_AZALEA_FOLIAGE,
            VVBlocks.JUNGLE_FOLIAGE,
            VVBlocks.MANGROVE_FOLIAGE,
            VVBlocks.OAK_FOLIAGE,
            VVBlocks.SPRUCE_FOLIAGE
    );

    private static final ModelTemplate MULTIFACE_TEMPLATE = new ModelTemplate(
            Optional.of(VeilsAndVegetation.id("block/vv_multiface")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );
    private static final ModelTemplate FOLIAGE_ITEM_MODEL = new ModelTemplate(
            Optional.of(new ResourceLocation("minecraft", "item/generated")),
            Optional.empty(),
            TextureSlot.LAYER0
    );

    public VVModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        for (Block block : VVBlocks.blocks) {
            ResourceLocation resLoc = VeilsAndVegetation.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath());
            if (foliage.contains(block)) resLoc = new ResourceLocation("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath()
                    .replace("foliage", "leaves"));

            this.createMultiface(generator, block, !excludeItemModel.contains(block) && !foliage.contains(block));
            MULTIFACE_TEMPLATE.create(block, new TextureMapping().put(TextureSlot.TEXTURE, resLoc), generator.modelOutput);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
        generator.generateFlatItem(VVBlocks.RUST.asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(VVBlocks.DUST.asItem(), ModelTemplates.FLAT_ITEM);
        generator.generateFlatItem(VVBlocks.GRIME.asItem(), ModelTemplates.FLAT_ITEM);

        for (Block block : foliage) {
            String blockName = BuiltInRegistries.BLOCK.getKey(block).getPath();
            String leavesName = blockName.replace("foliage", "leaves");
            ResourceLocation leavesTexture = new ResourceLocation("minecraft", "block/" + leavesName);

            TextureMapping textureMapping = new TextureMapping()
                    .put(TextureSlot.LAYER0, leavesTexture);

            FOLIAGE_ITEM_MODEL.create(
                    ModelLocationUtils.getModelLocation(block.asItem()),
                    textureMapping,
                    generator.output
            );
        }
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
