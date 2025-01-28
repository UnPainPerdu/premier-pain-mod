package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villagerBrewingStation.VillagerBrewingStationRecipe;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

public class VillagerBrewingStationCategory implements IRecipeCategory<VillagerBrewingStationRecipe>
{
    public static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,"villager_brewing");
    public static final RecipeType<VillagerBrewingStationRecipe> VILLAGER_BREWING_STATION_TYPE = new RecipeType<>(UID, VillagerBrewingStationRecipe.class);

    @Override
    public RecipeType<VillagerBrewingStationRecipe> getRecipeType()
    {
        return VILLAGER_BREWING_STATION_TYPE;
    }

    @Override
    public Component getTitle()
    {
        return null;
    }

    @Override
    public IDrawable getBackground()
    {
        return null;
    }

    @Override
    public @Nullable IDrawable getIcon()
    {
        return null;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, VillagerBrewingStationRecipe villagerBrewingStationRecipe, IFocusGroup iFocusGroup)
    {

    }
}
