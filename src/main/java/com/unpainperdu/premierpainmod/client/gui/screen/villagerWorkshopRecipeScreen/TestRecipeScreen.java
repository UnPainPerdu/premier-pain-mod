package com.unpainperdu.premierpainmod.client.gui.screen.villagerWorkshopRecipeScreen;

import com.unpainperdu.premierpainmod.level.world.item.crafting.villagerWorkshopRecipe.VillagerWorkshopRecipe;
import com.unpainperdu.premierpainmod.level.world.menu.villagerWorkshopMenu.TestMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TestRecipeScreen extends VillagerWorkshopRecipeScreen<TestMenu, VillagerWorkshopRecipe>
{
    public TestRecipeScreen(TestMenu menu, Inventory inventory, Component component)
    {
        super(menu, inventory, component);
    }
}
