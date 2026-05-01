package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.recipe.RecipeTypeRegister;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.types.IRecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.server.ServerLifecycleHooks;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin
{
    private static final ResourceLocation PLUGIN_ID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid()
    {
        return PLUGIN_ID;
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration)
    {
        register(registration, RecipeTypeRegister.VILLAGER_WORKSHOP_RECIPE_TYPE.get(), JEIRecipeType.VILLAGER_WORKSHOP_TYPE);
        register(registration, RecipeTypeRegister.VILLAGER_BREWING_STATION_RECIPE_TYPE.get(), JEIRecipeType.VILLAGER_BREWING_STATION_TYPE);
        register(registration, RecipeTypeRegister.COOKING_POT_RECIPE_TYPE.get(), JEIRecipeType.COOKING_POT_STATION_TYPE);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration)
    {
        IGuiHelper helper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new VillagerWorkshoppingCategory(helper));
        registration.addRecipeCategories(new VillagerBrewingStationCategory(helper));
        registration.addRecipeCategories(new CookingPotCategory(helper));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration)
    {
        registration.addCraftingStation(JEIRecipeType.VILLAGER_WORKSHOP_TYPE, BlockRegister.VILLAGER_WORKSHOP);
        registration.addCraftingStation(JEIRecipeType.VILLAGER_BREWING_STATION_TYPE, ModBLockList.getAllBlocksFromClass(VillagerBrewingStation.class).stream().map(Block::asItem).toArray(Item[]::new));
        registration.addCraftingStation(JEIRecipeType.COOKING_POT_STATION_TYPE, BlockRegister.COOKING_POT_BLOCK);
    }

    private <E extends RecipeInput, T extends Recipe<E>> void register(IRecipeRegistration registration, net.minecraft.world.item.crafting.RecipeType<T> vanillaRecipeType, IRecipeType<T> jeiRecipeType)
    {
        registration.addRecipes(jeiRecipeType, getAllRecipesFor(vanillaRecipeType));
    }

    private <E extends RecipeInput, T extends Recipe<E>> List<T> getAllRecipesFor(net.minecraft.world.item.crafting.RecipeType<T> vanillaRecipeType)
    {
        RecipeManager manager = ServerLifecycleHooks.getCurrentServer().getRecipeManager();
        List<T> outputList = new ArrayList<>();

        for (RecipeHolder<T> recipeHolder : manager.recipeMap().byType(vanillaRecipeType))
        {
            outputList.add(recipeHolder.value());
        }
        return outputList;
    }
}