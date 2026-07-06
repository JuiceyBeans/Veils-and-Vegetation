package com.juiceybeans.ubergrowth.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class UbergrowthDataGenerators implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(UbergrowthRecipeGenerator::new);
        pack.addProvider(UbergrowthModelGenerator::new);
        pack.addProvider(UbergrowthLangGenerator::new);
        pack.addProvider(UbergrowthLootTableGenerator::new);
        pack.addProvider(UbergrowthBlockTagsGenerator::new);
        pack.addProvider(UbergrowthItemTagsGenerator::new);
	}
}
