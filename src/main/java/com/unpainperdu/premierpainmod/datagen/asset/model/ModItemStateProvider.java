package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemStateProvider extends ItemModelProvider
{
    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        item(ItemRegister.VILLAGER_ICON.get());
    }
    private void item(Item item)
    {
        String name = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MODID+":","");
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/" + name);
    }
}
