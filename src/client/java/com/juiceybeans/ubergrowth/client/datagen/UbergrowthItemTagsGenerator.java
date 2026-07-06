package com.juiceybeans.ubergrowth.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

import java.util.concurrent.CompletableFuture;

public class UbergrowthItemTagsGenerator extends FabricTagProvider<Item> {
    public UbergrowthItemTagsGenerator(FabricDataOutput output, CompletableFuture registriesFuture) {
        super(output, Registries.ITEM, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

    }
}
