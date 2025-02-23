package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.ModList;
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
        super(output, PremierPainMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        //beer
            //empty
        item(ItemRegister.EMPTY_GLASS.get(),"beer/glass/");
        item(ItemRegister.EMPTY_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.EMPTY_MUG.get(),"beer/mug/");
            //LA_CHATEAU
        item(ItemRegister.LA_CHATEAU_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.LA_CHATEAU_GLASS.get(),"beer/glass/");
        item(ItemRegister.LA_CHATEAU_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.LA_CHATEAU_MUG.get(),"beer/mug/");
        //DEBIER
        item(ItemRegister.DEBIER_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.DEBIER_GLASS.get(),"beer/glass/");
        item(ItemRegister.DEBIER_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.DEBIER_MUG.get(),"beer/mug/");
        //ENVAHISSEUR_ROUGE
        item(ItemRegister.ENVAHISSEUR_ROUGE_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.ENVAHISSEUR_ROUGE_GLASS.get(),"beer/glass/");
        item(ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.ENVAHISSEUR_ROUGE_MUG.get(),"beer/mug/");
        //RASPBUISSON
        item(ItemRegister.RASPBUISSON_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.RASPBUISSON_GLASS.get(),"beer/glass/");
        item(ItemRegister.RASPBUISSON_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.RASPBUISSON_MUG.get(),"beer/mug/");
        //pain dieux
        item(ItemRegister.PAIN_DIEUX_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.PAIN_DIEUX_GLASS.get(),"beer/glass/");
        item(ItemRegister.PAIN_DIEUX_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.PAIN_DIEUX_MUG.get(),"beer/mug/");
        //LA_BLANCHE_CITADINE
        item(ItemRegister.LA_BLANCHE_CITADINE_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.LA_BLANCHE_CITADINE_GLASS.get(),"beer/glass/");
        item(ItemRegister.LA_BLANCHE_CITADINE_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.LA_BLANCHE_CITADINE_MUG.get(),"beer/mug/");
        //CRANE_NOIR
        item(ItemRegister.CRANE_NOIR_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.CRANE_NOIR_GLASS.get(),"beer/glass/");
        item(ItemRegister.CRANE_NOIR_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.CRANE_NOIR_MUG.get(),"beer/mug/");
        //TAK
        item(ItemRegister.TAK_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.TAK_GLASS.get(),"beer/glass/");
        item(ItemRegister.TAK_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.TAK_MUG.get(),"beer/mug/");
        //DISENDER
        item(ItemRegister.DISENDER_BUCKET.get(),"beer/bucket/");
        item(ItemRegister.DISENDER_GLASS.get(),"beer/glass/");
        item(ItemRegister.DISENDER_BOTTLE.get(),"beer/bottle/");
        item(ItemRegister.DISENDER_MUG.get(),"beer/mug/");
        //food
            //item
        vegetationFoodItem(ItemRegister.SKY_SPEARS_FRUIT.get());
        vegetationFoodItem(ItemRegister.CACTUS_FLOWER_FRUIT.get());
        vegetationFoodItem(ItemRegister.JELLY_HAT.get());
        vegetationFoodItem(ItemRegister.MOUNTAIN_CURRANT.get());
            //stew
        stewFoodItem(ItemRegister.JELLYSHROOM_STEW.get());
        stewFoodItem(ItemRegister.CACTUS_STEW.get());
        stewFoodItem(ItemRegister.POTATOES_AND_SPEARS_BOWL.get());
        stewFoodItem(ItemRegister.FRUITS_BOWL.get());
        //tree
            //mountain currant
        item(ItemRegister.MOUNTAIN_CURRANT_SIGN.get(), "tree/mountain_currant_tree/");
        item(ItemRegister.MOUNTAIN_CURRANT_HANGING_SIGN.get(), "tree/mountain_currant_tree/");
        itemWithTexturePath(ItemRegister.MOUNTAIN_CURRANT_BOAT.get(), "item/tree/mountain_currant_tree/mountain_currant_boat");
        itemWithTexturePath(ItemRegister.MOUNTAIN_CURRANT_CHEST_BOAT.get(), "item/tree/mountain_currant_tree/mountain_currant_chest_boat");
        for(DeferredItem<Item> deferredItem : ModList.ALL_ITEMS)
        {
            Item item = deferredItem.get();
            if(item instanceof VillagerShelfItem) {villagerShelfItem(item);}
            if(item instanceof VillagerSingingStone){villagerSingingStone(item);}
        }
    }
    private void item(Item item, String folder)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/"+ folder + name);
    }
     /***
     * path with /textures/ as root
     ***/
    private void itemWithTexturePath(Item item, String path)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0",path);
    }

    private void villagerShelfItem(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/all_materials_block_item/villager_shelf/" + name);
    }

    private void villagerSingingStone(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0","item/villager_singing_stone/" + name);
    }

    private void vegetationFoodItem(Item item)
    {
        item(item,"food/vegetation/");
    }

    private void stewFoodItem(Item item)
    {
        item(item,"food/stew/");
    }

    private String getName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID +":","");
    }
}
