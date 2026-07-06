package com.juiceybeans.ubergrowth.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class UbergrowthLangProvider extends FabricLanguageProvider {
    protected UbergrowthLangProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder builder) {
        builder.add("itemGroup.ubergrowth.ubergrowth_blocks", "Ubergrowth Blocks");
    }
}
