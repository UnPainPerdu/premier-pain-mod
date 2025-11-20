package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.villager_brewing_station.VillagerBrewingStationRecipe;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VillagerBrewingStationCategory implements IRecipeCategory<VillagerBrewingStationRecipe>
{

    private final IDrawable background;
    private final IDrawable icon;

    public VillagerBrewingStationCategory(IGuiHelper helper)
    {
        this.background = helper.createDrawable(getBackgroundTexture(), 0, 0, 146, 69);
        this.icon = helper.createDrawableItemStack(new ItemStack(ItemRegister.EMPTY_MUG.get()));
    }

    @Override
    public @NotNull RecipeType<VillagerBrewingStationRecipe> getRecipeType()
    {
        return JEIRecipeType.VILLAGER_BREWING_STATION_TYPE;
    }

    @Override
    public @NotNull Component getTitle()
    {
        return Component.translatable("container." + PremierPainMod.MOD_ID + ".villager_brewing_station");
    }

    @Override
    public void draw(@NotNull VillagerBrewingStationRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY)
    {
        this.background.draw(guiGraphics);
    }

    @Override
    public int getWidth()
    {
        return this.background.getWidth();
    }

    @Override
    public int getHeight()
    {
        return this.background.getHeight();
    }

    @Override
    public @Nullable IDrawable getIcon()
    {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull VillagerBrewingStationRecipe recipe, @NotNull IFocusGroup focuses)
    {
        int row = 3;
        int slotPerRow = 4;

        FluidStack inputFluid = recipe.getInputFluid().getFluids()[0];
        builder.addSlot(RecipeIngredientRole.INPUT, 12, 11).addFluidStack(inputFluid.getFluid(), inputFluid.getAmount()).setFluidRenderer(1000, true, 16, 48);
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < slotPerRow; j++)
            {
                List<Ingredient> inputList = recipe.getInputItems();
                Ingredient ingredient;
                if (j + i * slotPerRow < inputList.size())
                {
                    ingredient = inputList.get(j + i * slotPerRow);
                }
                else
                {
                    ingredient = Ingredient.of();
                }
                builder.addSlot(RecipeIngredientRole.INPUT, 33 + j * 18, 9 + i * 18).addIngredients(ingredient);
            }
        }
        FluidStack outputFluid = recipe.getResultFluid();
        builder.addSlot(RecipeIngredientRole.OUTPUT, 118, 11).addFluidStack(outputFluid.getFluid(), outputFluid.getAmount()).setFluidRenderer(1000, true, 16, 48);
    }

    private static ResourceLocation getBackgroundTexture()
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/jei/gui/villager_brewing_station_jei.png");
    }
}
