package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.VillagerTableBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerBrazier;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerStatue;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight.VillagerThroneChairBlock;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.StandingVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidthWithBlockEntity.villagerShelf.WallVillagerShelf;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.register.BlockList;
import com.unpainperdu.premierpainmod.util.register.ItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
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
        for(DeferredItem<Item> deferredItem : ItemList.CREATIVE_TAB_ITEMS)
        {
            Item item = deferredItem.get();
            if(item instanceof VillagerShelfItem) {villagerShelfItem(item);}
        }
    }
    private void item(Item item)
    {
        String name = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MODID+":","");
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/" + name);
    }

    private void villagerShelfItem(Item item)
    {
        String name = BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MODID+":","");
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_shelf/" + name);
    }
}
