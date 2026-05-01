package com.unpainperdu.premierpainmod.level.world.item.crafting.builders;

import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
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
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.crafting.SizedFluidIngredient;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class VillagerBrewingStationRecipeBuilder implements RecipeBuilder
{
    private final SizedFluidIngredient inputFluid;
    private final List<Ingredient> ingredients;
    private final FluidStack result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    @Nullable
    protected String group;

    public VillagerBrewingStationRecipeBuilder(SizedFluidIngredient inputFluid, List<Ingredient> ingredients, FluidStack result)
    {
        this.inputFluid = inputFluid;
        this.ingredients = ingredients;
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
        return null;
    }

    @Override
    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resourceKey)
    {
        Advancement.Builder advancement = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement::addCriterion);
        VillagerBrewingStationRecipe recipe = new VillagerBrewingStationRecipe(this.inputFluid, this.ingredients, this.result);
        output.accept(resourceKey, recipe, advancement.build(ResourceUtil.createResourceLocation("recipes/" + resourceKey.location().getPath())));
    }
}