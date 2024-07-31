package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.util.register.ItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

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
        for(DeferredItem<Item> deferredItem : ItemList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if(item instanceof VillagerShelfItem) {villagerShelfItem(item);}
            if(item instanceof VillagerSingingStone){villagerSingingStone(item);}
        }
    }
    private void item(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/" + name);
    }

    private void villagerShelfItem(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_shelf/" + name);
    }

    private void villagerSingingStone(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_singing_stone/" + name);
    }
    private String getName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MODID+":","");
    }
}
