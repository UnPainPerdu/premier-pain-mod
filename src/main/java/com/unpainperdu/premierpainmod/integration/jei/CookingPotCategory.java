package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.cooking_pot_block.CookingPotRecipe;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
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
import net.neoforged.neoforge.fluids.FluidStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CookingPotCategory implements IRecipeCategory<CookingPotRecipe>
{
    private final IDrawable background;
    private final IDrawable icon;

    public CookingPotCategory(IGuiHelper helper)
    {
        this.background = helper.createDrawable(getBackgroundTexture(), 0, 0, 120, 70);
        this.icon = helper.createDrawableItemStack(new ItemStack(BlockRegister.COOKING_POT_BLOCK.get()));
    }

    @Override
    public @NotNull RecipeType<CookingPotRecipe> getRecipeType()
    {
        return JEIRecipeType.COOKING_POT_STATION_TYPE;
    }

    @Override
    public @NotNull Component getTitle()
    {
        return Component.translatable(BlockRegister.COOKING_POT_BLOCK.get().getDescriptionId());
    }

    @Override
    public @Nullable IDrawable getIcon()
    {
        return this.icon;
    }

    @Override
    public void setRecipe(@NotNull IRecipeLayoutBuilder builder, @NotNull CookingPotRecipe recipe, @NotNull IFocusGroup focuses)
    {
        FluidStack inputFluid = recipe.getInputFluid().getFluids()[0];
        ItemStack inputItem = recipe.getInputItem().getItems()[0];
        ItemStack outputItem = recipe.getResultItem();

        builder.addSlot(RecipeIngredientRole.INPUT, 13, 14).addFluidStack(inputFluid.getFluid(), inputFluid.getAmount()).setFluidRenderer(1000, true, 16, 43);
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 28).addItemStack(inputItem);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 91, 28).addItemStack(outputItem);
    }

    @Override
    public void draw(@NotNull CookingPotRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY)
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

    private static ResourceLocation getBackgroundTexture()
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/jei/gui/cooking_pot_jei.png");
    }
}
