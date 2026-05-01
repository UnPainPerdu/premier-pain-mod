package com.unpainperdu.premierpainmod.level.world.item.crafting.builders;

import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotRecipe;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class CookingPotRecipeBuilder implements RecipeBuilder
{
    private final SizedFluidIngredient inputFluid;
    private final Ingredient ingredient;
    private final ItemStack result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    protected String group;

    public CookingPotRecipeBuilder(SizedFluidIngredient inputFluid, Ingredient ingredient, ItemStack result)
    {
        this.inputFluid = inputFluid;
        this.ingredient = ingredient;
        this.result = result;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion)
    {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String groupName)
    {
        this.group = groupName;
        return this;
    }

    @Override
    public Item getResult()
    {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resourceKey)
    {
        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);
        CookingPotRecipe recipe = new CookingPotRecipe(this.inputFluid, this.ingredient, this.result);
        output.accept(resourceKey, recipe, advancement.build(ResourceUtil.createResourceLocation("recipes/" + resourceKey.location().getPath())));
    }
}