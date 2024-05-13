package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegister.OAK_VILLAGER_STATUE, 1))
                .define('#', Blocks.OAK_PLANKS)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .unlockedBy("has_oak_planks", has(Blocks.OAK_PLANKS))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegister.BIRCH_VILLAGER_STATUE, 1))
                .define('#', Blocks.BIRCH_PLANKS)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .unlockedBy("has_birch_planks", has(Blocks.BIRCH_PLANKS))
                .save(pRecipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegister.STONE_VILLAGER_STATUE, 1))
                .define('#', Blocks.STONE)
                .pattern(" # ")
                .pattern("###")
                .pattern(" # ")
                .unlockedBy("has_stone_planks", has(Blocks.STONE))
                .save(pRecipeOutput);
    }
}