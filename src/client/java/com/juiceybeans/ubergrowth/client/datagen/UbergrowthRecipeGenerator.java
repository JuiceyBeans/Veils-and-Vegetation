package com.juiceybeans.ubergrowth.client.datagen;

import com.juiceybeans.ubergrowth.Ubergrowth;
import com.juiceybeans.ubergrowth.init.UbergrowthBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class UbergrowthRecipeGenerator extends FabricRecipeProvider {
    public UbergrowthRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> writer) {
    }
}
