package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.item.items.VillagerSingingStone;
import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil.getModItemFromId;

public class ModItemStateProvider extends ItemModelProvider
{
    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        //fluid
        //oil
        item(ItemRegister.MORICHE_PALM_OIL_BUCKET.get(), "fluid/");
        //beer
        //empty
        item(ItemRegister.EMPTY_GLASS.get(), "fluid/beer/glass/");
        item(ItemRegister.EMPTY_BOTTLE.get(), "fluid/beer/bottle/");
        item(ItemRegister.EMPTY_MUG.get(), "fluid/beer/mug/");
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
        item(ItemRegister.HALF_COOKED_FRIES.asItem(), "food/");
        item(ItemRegister.FRIES.asItem(), "food/");
        item(ItemRegister.FRIES_CONE.asItem(), "food/");
        vegetationFoodItem(ItemRegister.SKY_SPEARS_FRUIT.get());
        vegetationFoodItem(ItemRegister.CACTUS_FLOWER_FRUIT.get());
        vegetationFoodItem(ItemRegister.JELLY_HAT.get());
        vegetationFoodItem(ItemRegister.MOUNTAIN_CURRANT.get());
        vegetationFoodItem(ItemRegister.MORICHE_PALM_FRUIT.get());
        vegetationFoodItem(ItemRegister.ACHIOTE_FRUIT.get());
        item(ItemRegister.BREADING.asItem(), "food/");
        item(ItemRegister.UNCOOKED_BREADED_CHICKEN_WING.asItem(), "food/");
        item(ItemRegister.BREADED_CHICKEN_WING.asItem(), "food/");
        item(ItemRegister.UNCOOKED_BREADED_FISH.asItem(), "food/");
        item(ItemRegister.BREADED_FISH.asItem(), "food/");
        item(ItemRegister.UNCOOKED_SCHNITZEL.asItem(), "food/");
        item(ItemRegister.SCHNITZEL.asItem(), "food/");
        item(ItemRegister.HARD_BOILED_EGG.asItem(), "food/");
        //stew
        stewFoodItem(ItemRegister.JELLYSHROOM_STEW.get());
        stewFoodItem(ItemRegister.CACTUS_STEW.get());
        stewFoodItem(ItemRegister.POTATOES_AND_SPEARS_BOWL.get());
        stewFoodItem(ItemRegister.FRUITS_BOWL.get());
        //tree
        woodItems("mountain_currant");
        woodItems("moriche_palm");
        woodItems("achiote");
        woodItems("weeping_willow");

        //spawn_eggs
        item(AllInOneEntityRegister.EGG_ITEM_MAP.get("mountain_currant_golem_spawn_egg").get(), "spawn_egg/");
        item(AllInOneEntityRegister.EGG_ITEM_MAP.get("wool_golem_spawn_egg").get(), "spawn_egg/");

        for (Item item : ModItemList.ALL_ITEMS)
        {
            if (item instanceof VillagerShelfItem)
            {
                villagerShelfItem(item);
            }
            if (item instanceof VillagerSingingStone)
            {
                villagerSingingStone(item);
            }
        }
    }

    private void item(Item item, String folder)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + folder + name);
    }

    private void itemWithFullPath(Item item, String path)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + path);
    }

    private void villagerShelfItem(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/all_materials_block_item/villager_shelf/" + name.replace("_villager_shelf", ""));
    }

    private void villagerSingingStone(Item item)
    {
        String name = getName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/villager_singing_stone/" + name);
    }

    private void vegetationFoodItem(Item item)
    {
        item(item, "food/vegetation/");
    }

    private void stewFoodItem(Item item)
    {
        item(item, "food/stew/");
    }

    /**
     * will generate item state
     * for beerId_bucket
     * beerId_glass
     * beerId_bottle
     * beerId_mug
     */
    private void beerItems(String beerId)
    {
        item(getModItemFromId(beerId + "_bucket"), "fluid/beer/bucket/");
        item(getModItemFromId(beerId + "_glass"), "fluid/beer/glass/");
        item(getModItemFromId(beerId + "_bottle"), "fluid/beer/bottle/");
        item(getModItemFromId(beerId + "_mug"), "fluid/beer/mug/");
    }

    private void woodItems(String woodId)
    {
        itemWithFullPath(getModItemFromId(woodId + "_sign"), "tree/" + woodId + "/sign");
        itemWithFullPath(getModItemFromId(woodId + "_hanging_sign"), "tree/" + woodId + "/hanging_sign");
        itemWithFullPath(getModItemFromId(woodId + "_boat"), "tree/" + woodId + "/boat");
        itemWithFullPath(getModItemFromId(woodId + "_chest_boat"), "tree/" + woodId + "/chest_boat");
    }

    private String getName(Item item)
    {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(PremierPainMod.MOD_ID + ":", "");
    }
}
