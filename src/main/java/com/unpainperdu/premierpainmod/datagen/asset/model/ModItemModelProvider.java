package com.unpainperdu.premierpainmod.datagen.asset.model;

import com.unpainperdu.premierpainmod.level.world.item.items.all_materials_block.VillagerShelfItem;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.Map;

public class ModItemModelProvider
{
    public static void generate(ItemModelGenerators itemModels)
    {
        //fluid
        //  oil
        itemModels.generateFlatItem(ItemRegister.MORICHE_PALM_OIL_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        //  beer
        //      empty
        itemModels.generateFlatItem(ItemRegister.EMPTY_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.EMPTY_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.EMPTY_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      PAIN_DIEUX
        itemModels.generateFlatItem(ItemRegister.PAIN_DIEUX_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.PAIN_DIEUX_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.PAIN_DIEUX_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.PAIN_DIEUX_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      LA_CHATEAU
        itemModels.generateFlatItem(ItemRegister.LA_CHATEAU_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_CHATEAU_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_CHATEAU_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_CHATEAU_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      DEBIER
        itemModels.generateFlatItem(ItemRegister.DEBIER_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DEBIER_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DEBIER_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DEBIER_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      ENVAHISSEUR_ROUGE
        itemModels.generateFlatItem(ItemRegister.ENVAHISSEUR_ROUGE_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.ENVAHISSEUR_ROUGE_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.ENVAHISSEUR_ROUGE_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.ENVAHISSEUR_ROUGE_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      RASPBUISSON
        itemModels.generateFlatItem(ItemRegister.RASPBUISSON_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.RASPBUISSON_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.RASPBUISSON_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.RASPBUISSON_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      LA_BLANCHE_CITADINE
        itemModels.generateFlatItem(ItemRegister.LA_BLANCHE_CITADINE_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_BLANCHE_CITADINE_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_BLANCHE_CITADINE_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.LA_BLANCHE_CITADINE_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      CRANE_NOIR
        itemModels.generateFlatItem(ItemRegister.CRANE_NOIR_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.CRANE_NOIR_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.CRANE_NOIR_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.CRANE_NOIR_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      TAK
        itemModels.generateFlatItem(ItemRegister.TAK_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.TAK_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.TAK_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.TAK_MUG.get(), ModelTemplates.FLAT_ITEM);
        //      DISENDER
        itemModels.generateFlatItem(ItemRegister.DISENDER_BUCKET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DISENDER_GLASS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DISENDER_BOTTLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DISENDER_MUG.get(), ModelTemplates.FLAT_ITEM);
        //food
        itemModels.generateFlatItem(ItemRegister.HALF_COOKED_FRIES.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.FRIES.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.FRIES_CONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.SKY_SPEARS_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.CACTUS_FLOWER_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.JELLY_HAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.MOUNTAIN_CURRANT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.MORICHE_PALM_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.ACHIOTE_FRUIT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.BREADING.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.UNCOOKED_BREADED_CHICKEN_WING.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.BREADED_CHICKEN_WING.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.UNCOOKED_BREADED_FISH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.BREADED_FISH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.UNCOOKED_SCHNITZEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.SCHNITZEL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.HARD_BOILED_EGG.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.FLOWERED_LIZARD_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.COOKED_FLOWERED_LIZARD_MEAT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.HARD_BOILED_FLOWERED_LIZARD_EGG.get(), ModelTemplates.FLAT_ITEM);
        //  stew
        itemModels.generateFlatItem(ItemRegister.JELLYSHROOM_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.CACTUS_STEW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.POTATOES_AND_SPEARS_BOWL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.FRUITS_BOWL.get(), ModelTemplates.FLAT_ITEM);
        //wood
        woodItems(itemModels, ItemRegister.ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP);
        woodItems(itemModels, ItemRegister.ITEM_MORICHE_PALM_WOOD_TYPE_MAP);
        woodItems(itemModels, ItemRegister.ITEM_ACHIOTE_WOOD_TYPE_MAP);
        woodItems(itemModels, ItemRegister.ITEM_WEEPING_WILLOW_WOOD_TYPE_MAP);
        //mob
        //  spawn egg
        itemModels.generateFlatItem(AllInOneEntityRegister.getEgg(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY).get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AllInOneEntityRegister.getEgg(AllInOneEntityRegister.WOOL_GOLEM_ENTITY).get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AllInOneEntityRegister.getEgg(AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY).get(), ModelTemplates.FLAT_ITEM);
        //  loot_mob
        itemModels.generateFlatItem(ItemRegister.FLOWERED_LIZARD_SCALE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.FLOWERED_LIZARD_EGG.get(), ModelTemplates.FLAT_ITEM);
        //equipement
        //  villager_singing_stone
        itemModels.generateFlatItem(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get(), ModelTemplates.FLAT_ITEM);
        //  armor
        itemModels.generateFlatItem(ItemRegister.FLOWERED_LIZARD_SCALE_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
        //all_materials
        generateAllMaterialsItems(itemModels);
        //other
        itemModels.generateFlatItem(ItemRegister.GYPSUM_SHARD.get(), ModelTemplates.FLAT_ITEM);
    }

    //item function
    private static void woodItems(ItemModelGenerators itemModels, Map<String, DeferredItem<Item>> woodItemMap)
    {
        for (Item item : woodItemMap.values().stream().map(DeferredHolder::get).toList())
        {
            itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }

    private static void generateAllMaterialsItems(ItemModelGenerators itemModels)
    {
        for (Item item : ModItemList.getAllItemsFromClass(VillagerShelfItem.class))
        {
            itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
        }
    }
}