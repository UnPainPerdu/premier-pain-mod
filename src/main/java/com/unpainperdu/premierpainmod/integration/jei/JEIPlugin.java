package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin
{
    private static final ResourceLocation PLUGIN_ID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,"jei_plugin");
    @Override
    public ResourceLocation getPluginUid()
    {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration)
    {
        RecipeManager manager = Minecraft.getInstance().level.getRecipeManager();
        List<VillagerWorkshopRecipe> villagerWorkshopRecipes = holderToNotHolder(manager.getAllRecipesFor(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get()));
        registration.addRecipes(VillagerWorkshoppingCategory.VILLAGER_WORKSHOP_TYPE,villagerWorkshopRecipes);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        registration.addRecipeCategories(new VillagerWorkshoppingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    private List<VillagerWorkshopRecipe> holderToNotHolder(List<RecipeHolder<VillagerWorkshopRecipe>> list)
    {
        List<VillagerWorkshopRecipe> outputList = new ArrayList<>();
        for(RecipeHolder<VillagerWorkshopRecipe> recipeHolder : list)
        {
            outputList.add(recipeHolder.value());
        }
        return outputList;
    }
}
