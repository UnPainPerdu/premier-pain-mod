package com.unpainperdu.premierpainmod.integration.jei;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class VillagerWorkshoppingCategory implements IRecipeCategory<VillagerWorkshopRecipe>
{
    public static ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,"villager_workshopping");
    public static ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID,"textures/jei/gui/villager_workshopping_jei.png");
    public static final RecipeType<VillagerWorkshopRecipe> VILLAGER_WORKSHOP_TYPE = new RecipeType<>(UID, VillagerWorkshopRecipe.class);
    private final IDrawable background;
    private final IDrawable icon;

    public VillagerWorkshoppingCategory(IGuiHelper helper)
    {
        this.background = helper.createDrawable(TEXTURE,0,0,76,18);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(BlockRegister.VILLAGER_WORKSHOP.get()));
    }

    @Override
    public RecipeType<VillagerWorkshopRecipe> getRecipeType()
    {
        return VILLAGER_WORKSHOP_TYPE;
    }

    @Override
    public Component getTitle()
    {
        return Component.translatable("container."+ PremierPainMod.MOD_ID +".villager_workshop");
    }

    @Override
    public IDrawable getBackground()
    {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon()
    {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, VillagerWorkshopRecipe recipe, IFocusGroup focuses)
    {
        builder.addSlot(RecipeIngredientRole.INPUT,1,1).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT,59,1).addItemStack(recipe.getResultItem(null));
    }
}
