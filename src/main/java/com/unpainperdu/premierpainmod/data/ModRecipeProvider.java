package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static RecipeOutput recipeOutput;
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput pRecipeOutput)
    {
        ModRecipeProvider.recipeOutput = pRecipeOutput;
        statueRecipeBuilder(BlockRegister.OAK_VILLAGER_STATUE,"has_oak_planks",Blocks.OAK_PLANKS);
        statueRecipeBuilder(BlockRegister.BIRCH_VILLAGER_STATUE,"has_birch_planks",Blocks.BIRCH_PLANKS);
        statueRecipeBuilder(BlockRegister.STONE_VILLAGER_STATUE,"has_stone",Blocks.STONE);
    }
    private void statueRecipeBuilder(ItemLike craftedBlock,String pName, ItemLike ingredient)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(craftedBlock, 1))
                .define('#', ingredient)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy(pName, has(ingredient))
                .save(ModRecipeProvider.recipeOutput);
    }
}