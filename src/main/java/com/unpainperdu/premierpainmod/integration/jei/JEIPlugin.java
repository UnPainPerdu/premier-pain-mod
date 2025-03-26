package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;

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
        List<VillagerWorkshopRecipe> villagerWorkshopRecipes = holderToNotHolderVillagerWorkshop(manager.getAllRecipesFor(RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get()));
        registration.addRecipes(VillagerWorkshoppingCategory.VILLAGER_WORKSHOP_TYPE,villagerWorkshopRecipes);
        List<VillagerBrewingStationRecipe> villagerBrewingStationRecipes = holderToNotHolderVillagerBrewingStation(manager.getAllRecipesFor(RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get()));
        registration.addRecipes(VillagerBrewingStationCategory.VILLAGER_BREWING_STATION_TYPE, villagerBrewingStationRecipes);

    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        registration.addRecipeCategories(new VillagerWorkshoppingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new VillagerBrewingStationCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        registration.addRecipeCatalyst(new ItemStack(BlockRegister.VILLAGER_WORKSHOP), JEIRecipeType.VILLAGER_WORKSHOP_TYPE);

        for (Block block : ModBLockList.getAllBlocksFromClass(VillagerBrewingStation.class))
        {
            registration.addRecipeCatalyst(new ItemStack(block), JEIRecipeType.VILLAGER_BREWING_STATION_TYPE);
        }
    }

    private List<VillagerWorkshopRecipe> holderToNotHolderVillagerWorkshop(List<RecipeHolder<VillagerWorkshopRecipe>> list)
    {
        List<VillagerWorkshopRecipe> outputList = new ArrayList<>();
        for(RecipeHolder<VillagerWorkshopRecipe> recipeHolder : list)
        {
            outputList.add(recipeHolder.value());
        }
        return outputList;
    }

    private List<VillagerBrewingStationRecipe> holderToNotHolderVillagerBrewingStation(List<RecipeHolder<VillagerBrewingStationRecipe>> list)
    {
        List<VillagerBrewingStationRecipe> outputList = new ArrayList<>();
        for(RecipeHolder<VillagerBrewingStationRecipe> recipeHolder : list)
        {
            outputList.add(recipeHolder.value());
        }
        return outputList;
    }
}
