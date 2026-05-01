package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.recipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VillagerWorkshoppingCategory implements IRecipeCategory<VillagerWorkshopRecipe>
{
    private final IDrawable background;
    private final IDrawable icon;

    public VillagerWorkshoppingCategory(IGuiHelper helper)
    {
        this.background = helper.createDrawable(getBackgroundTexture(), 0, 0, 76, 18);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegister.VILLAGER_WORKSHOP.get()));
    }

    @Override
    public @NotNull IRecipeType<VillagerWorkshopRecipe> getRecipeType()
    {
        return JEIRecipeType.VILLAGER_WORKSHOP_TYPE;
    }

    @Override
    public @NotNull Component getTitle()
    {
        return Component.translatable("container." + PremierPainMod.MOD_ID + ".villager_workshop");
    }

    @Override
    public void draw(@NotNull VillagerWorkshopRecipe recipe, @NotNull IRecipeSlotsView recipeSlotsView, @NotNull GuiGraphics guiGraphics, double mouseX, double mouseY)
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
    public void setRecipe(IRecipeLayoutBuilder builder, VillagerWorkshopRecipe recipe, @NotNull IFocusGroup focuses)
    {
        Item inputItem = recipe.input().getValues().get(0).value();
        ItemStack outputItem = recipe.result();
        builder.addSlot(RecipeIngredientRole.INPUT, 1, 1).add(inputItem);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 59, 1).add(outputItem);
    }

    private static ResourceLocation getBackgroundTexture()
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "textures/jei/gui/villager_workshopping_jei.png");
    }
}