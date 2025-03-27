package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
        beerItems("la_chateau");
        beerItems("debier");
        beerItems("envahisseur_rouge");
        beerItems("raspbuisson");
        beerItems("pain_dieux");
        beerItems("la_blanche_citadine");
        beerItems("raspbuisson");
        beerItems("crane_noir");
        beerItems("tak");
        beerItems("disender");
        //food
            //item
        vegetationFoodItem(ItemRegister.SKY_SPEARS_FRUIT.get());
        vegetationFoodItem(ItemRegister.CACTUS_FLOWER_FRUIT.get());
        vegetationFoodItem(ItemRegister.JELLY_HAT.get());
        vegetationFoodItem(ItemRegister.MOUNTAIN_CURRANT.get());
        vegetationFoodItem(ItemRegister.MORICHE_PALM_FRUIT.get());
        vegetationFoodItem(ItemRegister.ACHIOTE_FRUIT.get());
            //stew
        stewFoodItem(ItemRegister.JELLYSHROOM_STEW.get());
        stewFoodItem(ItemRegister.CACTUS_STEW.get());
        stewFoodItem(ItemRegister.POTATOES_AND_SPEARS_BOWL.get());
        stewFoodItem(ItemRegister.FRUITS_BOWL.get());
        //tree
        woodItems("mountain_currant");
        woodItems("moriche_palm");
        woodItems("achiote");

        for(Item item : ModItemList.ALL_ITEMS)
        {
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

    /**
     * will generate item state
     * for beerId_bucket
     *     beerId_glass
     *     beerId_bottle
     *     beerId_mug
     * */
    private void beerItems(String beerId)
    {
        item(getItemFromId(beerId + "_bucket"),"beer/bucket/");
        item(getItemFromId(beerId + "_glass"),"beer/glass/");
        item(getItemFromId(beerId + "_bottle"),"beer/bottle/");
        item(getItemFromId(beerId + "_mug"),"beer/mug/");
    }

    private void woodItems(String woodId)
    {
        item(getItemFromId(woodId + "_sign"), "tree/" + woodId + "_tree/");
        item(getItemFromId(woodId + "_hanging_sign"), "tree/" + woodId + "_tree/");
        itemWithTexturePath(getItemFromId(woodId + "_boat"), "item/tree/" + woodId + "_tree/" + woodId + "_boat");
        itemWithTexturePath(getItemFromId(woodId + "_chest_boat"), "item/tree/" + woodId + "_tree/" + woodId + "_chest_boat");
    }

    private static Item getItemFromId(String path)
    {
        return getItemFromId(PremierPainMod.MOD_ID, path);
    }

    private static Item getItemFromId(String nameSpace, String path)
    {
        return BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath(nameSpace, path));
    }

    private String getName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID +":","");
    }
}
