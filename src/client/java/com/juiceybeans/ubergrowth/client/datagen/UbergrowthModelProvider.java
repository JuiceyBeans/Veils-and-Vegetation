package com.juiceybeans.ubergrowth.client.datagen;

import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.world.level.block.Block;

import java.util.Optional;

public class UbergrowthModelProvider extends FabricModelProvider {
    private static final ModelTemplate MULTIFACE_TEMPLATE = new ModelTemplate(
            Optional.of(Ubergrowth.id("block/ubergrowth_multiface")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    public UbergrowthModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators generator) {
        for (Block block : UbergrowthBlocks.blocks) {
            generator.createMultiface(block);
            MULTIFACE_TEMPLATE.create(block, new TextureMapping().put(TextureSlot.TEXTURE,
                    Ubergrowth.id("block/" + BuiltInRegistries.BLOCK.getKey(block).getPath())), generator.modelOutput);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators generator) {
    }
}
