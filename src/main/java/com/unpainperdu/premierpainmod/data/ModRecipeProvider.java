package com.unpainperdu.premierpainmod.data;

import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.IntersectionIngredient;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider)
    {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput)
    {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, new ItemStack(BlockRegister.OAK_VILLAGER_STATUE, 1))
                .define('#', Blocks.OAK_PLANKS)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_rgb_glass", has(Blocks.OAK_PLANKS))
                .save(pRecipeOutput);
    }
}