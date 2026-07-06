package com.juiceybeans.ubergrowth.client.datagen;

import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.stream.Collectors;

public class UbergrowthLangGenerator extends FabricLanguageProvider {
    protected UbergrowthLangGenerator(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add("itemGroup.ubergrowth.ubergrowth_blocks", "Ubergrowth Blocks");

        for (Block block : UbergrowthBlocks.blocks) {
            builder.add("block.ubergrowth." + BuiltInRegistries.BLOCK.getKey(block).getPath(), getLocalisedName(block));
        }
    }

    private static String getLocalisedName(Block block) {
        var id = BuiltInRegistries.BLOCK.getKey(block).getPath();

        return Arrays.stream(id.split("_"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
