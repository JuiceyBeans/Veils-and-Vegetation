package com.juiceybeans.veilsandvegetation.client.datagen;

import com.juiceybeans.veilsandvegetation.init.VVBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.stream.Collectors;

public class VVLangGenerator extends FabricLanguageProvider {
    protected VVLangGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add("itemGroup.veilsandvegetation.veilsandvegetation_blocks", "Veils and Vegetation Blocks");

        for (Block block : VVBlocks.blocks) {
            builder.add("block.veilsandvegetation." + BuiltInRegistries.BLOCK.getKey(block).getPath(), getLocalisedName(block));
        }
    }

    private static String getLocalisedName(Block block) {
        var id = BuiltInRegistries.BLOCK.getKey(block).getPath();

        return Arrays.stream(id.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
