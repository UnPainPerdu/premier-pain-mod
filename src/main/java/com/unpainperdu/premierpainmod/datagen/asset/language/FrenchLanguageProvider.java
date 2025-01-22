package com.unpainperdu.premierpainmod.datagen.asset.language;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class FrenchLanguageProvider extends LanguageProvider
{
    public FrenchLanguageProvider(PackOutput packOutput)
    {
        super(packOutput, PremierPainMod.MOD_ID, "fr_fr");
    }
    @Override
    protected void addTranslations()
    {
        add("itemGroup.premierpainmod", "Mod Premier Pain");
        //gui
        add("container."+ PremierPainMod.MOD_ID +".villager_workshop","Atelier du villageois");
            //container
        add("container."+ PremierPainMod.MOD_ID +".villager_drawer","Tiroir du villageois");
        add("container."+ PremierPainMod.MOD_ID +".villager_brewing_station","Fut de brassage");
        //potion effect
        add("effect.minecraft.hero_of_the_village","Héro des villageois");
        //death message
        //%s to get player name
        deathTranslation("liberty_damage1", "%s était un socialiste");
        deathTranslation("liberty_damage2", "%s voulait une tasse de LIBER-THÉ");
        deathTranslation("liberty_damage3", "%s n'a pas saluer le drapeau de la Super-Terre");
        //item
            //villagerSingingStone
        add(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get(),"Pierre chantante du villageois de la liberté");
        descriptionMaker(ItemRegister.LIBERTY_VILLAGER_SINGING_STONE.get().toString(),"Est-tu un vrai patriote ?");
        add(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get(),"Pierre chantante du villageois des mines");
        descriptionMaker(ItemRegister.DIGGY_VILLAGER_SINGING_STONE.get().toString(),"N'ais pas peur des profondeurs");
        add(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get(),"Pierre chantante du villageois foux");
        descriptionMakerWIP(ItemRegister.MADNESS_VILLAGER_SINGING_STONE.get().toString(),"Assez! J'en ai enduré bien assez...");
        add(ItemRegister.PREMIER_PAIN_VILLAGER_SINGING_STONE.get(),"Pierre chantante du Premier Pain");
        descriptionMakerWIP(ItemRegister.PREMIER_PAIN_VILLAGER_SINGING_STONE.get().toString(),"De la cuisson du pain au maniement de l'épée, nous venons de si loin!");
            //food
                //vegetation
        add(ItemRegister.SKY_SPEARS_FRUIT.get(), "Fruit de lances du ciel");
        add(ItemRegister.CACTUS_FLOWER_FRUIT.get(), "Fruit de fleure de cactus");
        add(ItemRegister.JELLY_HAT.get(), "Chapeau-gelée");
        add(ItemRegister.MOUNTAIN_CURRANT.get(), "Groseille des montagnes");
                //stew
        add(ItemRegister.JELLYSHROOM_STEW.get(), "Soupe de champigelée");
        add(ItemRegister.CACTUS_STEW.get(), "Soupe de fruits de cactus");
        add(ItemRegister.POTATOES_AND_SPEARS_BOWL.get(), "Bol de patates et de fruit de lance");
        add(ItemRegister.FRUITS_BOWL.get(), "Bol de fruits");
        //block
            //blockEvent
        add(BlockRegister.LIBERTY_BLOCK.get(),"HellPod");
            // villager workshop
        villagerWorkshopTranslation();
            //vegetation
                //tall grass
        add(BlockRegister.SKY_SPEARS.get(), "Lances du ciel");
        add(BlockRegister.SKY_SPEARS_FLOWER.get(), "Fleure de lances du ciel");
        add(BlockRegister.DEAD_TALL_BUSH.get(), "Buisson sec");
        add(BlockRegister.OLD_WILD_WHEAT.get(), "Ancien blé sauvage");
                //misc
        add(BlockRegister.FLOWERED_CACTUS_BLOCK.get(), "Cactus fleuri");
        add(BlockRegister.CACTUS_FLOWER_BLOCK.get(), "Fleure de cactus");

                //flower
                    //1 block flower
        add(BlockRegister.RUINS_FLOWER.get(), "Fleure de ruines");
        add(BlockRegister.CURIOSITY_FLOWER.get(), "Fleure de curiosité");
                    //growing flower
        add(BlockRegister.CIVILIZATIONS_FLOWER.get(), "Fleure des civilisations");
                    //dead bush
        add(BlockRegister.DEAD_RUINS_FLOWER.get(), "Fleure de ruines mortes");
                //crop
        add(BlockRegister.JELLYSHROOM.get(), "Champigelée");
            //tree
        treeTranslator("mountain_currant", "groseillier des montagnes");
            // "All material"
        globalAllMaterialTranslation("oak", "chêne");
        globalAllMaterialTranslation("birch","bouleau");
        globalAllMaterialTranslation("spruce","sapin");
        globalAllMaterialTranslation("jungle","acajou");
        globalAllMaterialTranslation("acacia","acacia");
        globalAllMaterialTranslation("dark_oak","chêne noir");
        globalAllMaterialTranslation("pale_oak","chêne pâle");
        globalAllMaterialTranslation("mangrove","palétuvier");
        globalAllMaterialTranslation("cherry","cerisier");
        globalAllMaterialTranslation("crimson", "bois carmin");
        globalAllMaterialTranslation("warped","bois biscornu");
        globalAllMaterialTranslation("bamboo","bambou");
        globalAllMaterialTranslation("stone","pierre");
        globalAllMaterialTranslation("mossy_stone","pierre mossue");
        globalAllMaterialTranslation("andesite","andésite");
        globalAllMaterialTranslation("diorite","diorite");
        globalAllMaterialTranslation("granite","granite");
        globalAllMaterialTranslation("prismarine","prismarine");
        globalAllMaterialTranslation("blackstone","pierre noir");
        globalAllMaterialTranslation("purpur_block","purpur");
        globalAllMaterialTranslation("deepslate","pierre des abîmes");
        globalAllMaterialTranslation("tuff","tuf");
        globalAllMaterialTranslation("packed_mud","terre crue");
        globalAllMaterialTranslation("sandstone","grès");
        globalAllMaterialTranslation("red_sandstone","grès rouge");
        globalAllMaterialTranslation("quartz_block","quartz");
        globalAllMaterialTranslation("nether_bricks","briques du nether");
        globalAllMaterialTranslation("basalt","basalt");
        globalAllMaterialTranslation("end_stone","pierre de l'end");
        globalAllMaterialTranslation("coal_block","charbon");
        globalAllMaterialTranslation("iron_block","fer");
        globalAllMaterialTranslation("gold_block","or");
        globalAllMaterialTranslation("redstone_block","redstone");
        globalAllMaterialTranslation("emerald_block","émeraude");
        globalAllMaterialTranslation("diamond_block","diamant");
        globalAllMaterialTranslation("copper_block","cuivre");
        globalAllMaterialTranslation("lapis_block","lapis-lazuli");
        globalAllMaterialTranslation("netherite_block","netherite");
        globalAllMaterialTranslation("obsidian","obsidienne");
        globalAllMaterialTranslation("amethyst_block","améthyste");
        globalAllMaterialTranslation("dripstone_block","spéléothème");
        globalAllMaterialTranslation("bedrock","bedrock");
        globalAllMaterialTranslation("mountain_currant","groseillier des montagnes");
    }
    //Only use for "all material" blocks
    private void globalAllMaterialTranslation(String suffix, String translationSuffix)
    {
        statueTranslation(suffix, translationSuffix);
        pedestalTranslation(suffix, translationSuffix);
        brazierTranslation(suffix, translationSuffix);
        tableTranslation(suffix, translationSuffix);
        chairTranslation(suffix, translationSuffix);
        throneChairTranslation(suffix, translationSuffix);
        drawerTranslation(suffix,translationSuffix);
        shelfTranslation(suffix,translationSuffix);
        benchTranslation(suffix,translationSuffix);
        couchTranslation(suffix,translationSuffix);
        brewingStationTranslation(suffix,translationSuffix);
    }

    // will create translation : "block.premierpainmod.suffix_villager_statue": "Statue de villageois 'Suffix'"
    private void statueTranslation(String suffix, String translation)
    {
        String statue = "_villager_statue";
        String translationStatue = "Statue de villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+statue,translationStatue + translation);
    }
    // will create translation : "block.premierpainmod.suffix_villager_statue": "'Suffix' pedestal"
    private void pedestalTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_pedestal";
        String translationPedestal = "Piédestale en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void brazierTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_brazier";
        String translationPedestal = "Brazero en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void villagerWorkshopTranslation()
    {
        add("block."+PremierPainMod.MOD_ID +".villager_workshop","Atelier du villageois");
    }
    private void tableTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_table";
        String translationPedestal = "Table en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void chairTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_chair";
        String translationPedestal = "Chaise en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void throneChairTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_throne_chair";
        String translationPedestal = "Chaise seigneurial en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void drawerTranslation(String suffix, String translation)
    {
        String pedestal = "_villager_drawer";
        String translationPedestal = "Tiroir du villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+pedestal,translationPedestal + translation);
    }
    private void shelfTranslation(String suffix, String translation)
    {
        String standingShelf = "_standing_villager_shelf";
        String translationPedestal = "Etagère du villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+standingShelf,translationPedestal + translation);
    }

    private void benchTranslation(String suffix, String translation)
    {
        String standingShelf = "_villager_bench";
        String translationPedestal = "Banc du villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+standingShelf,translationPedestal + translation);
    }

    private void couchTranslation(String suffix, String translation)
    {
        String standingShelf = "_villager_couch";
        String translationPedestal = "Canapé du villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+standingShelf,translationPedestal + translation);
    }

    private void brewingStationTranslation(String suffix, String translation)
    {
        String standingShelf = "_villager_brewing_station";
        String translationPedestal = "Fut de brassage du villageois en ";
        add("block."+PremierPainMod.MOD_ID +"."+suffix+standingShelf,translationPedestal + translation);
    }

    private void deathTranslation(String id, String translation)
    {
        add("death.attack." + PremierPainMod.MOD_ID + ":" + id, translation);
    }
    private void descriptionMakerWIP(String idOfItem, String translation)
    {
        descriptionMaker(idOfItem,translation + " !!!Sound in WIP, will be more villager like when i will know how to do");
    }
    private void descriptionMaker(String idOfItem, String translation)
    {
        add("item.description."+idOfItem.replace(PremierPainMod.MOD_ID +":",""),translation);
    }

    /***
     *
     * @param nameOfTree need to be in this : form dark_oak
     * @param translation need to be in this form : chêne noir
     */
    private void treeTranslator(String nameOfTree, String translation)
    {
        String block = "block." + PremierPainMod.MOD_ID + ".";
        String item = "block." + PremierPainMod.MOD_ID + ".";
        add(block + nameOfTree + "_log","Bûche de " + translation);
        add(block + nameOfTree + "_wood", "Bois de " + translation);
        add(block + "stripped_" + nameOfTree + "_log", "Bûche de " + translation + " écorcé");
        add(block + "stripped_" + nameOfTree + "_wood", "Bois de " + translation + " écorcé");
        add(block + nameOfTree + "_planks", "Planche en " + translation);
        add(block + nameOfTree + "_leaves", "Feuilles de " + translation);
        add(block + nameOfTree + "_stairs", "Escalier en " + translation);
        add(block + nameOfTree + "_slab", "Dalle en " + translation);
        add(block + nameOfTree + "_button", "Bouton en " + translation);
        add(block + nameOfTree + "_pressure_plate", "Plaque de pression en " + translation);
        add(block + nameOfTree + "_fence", "Barrière en " + translation);
        add(block + nameOfTree + "_fence_gate", "Portillon en " + translation);
        add(block + nameOfTree + "_door", "Porte en " + translation);
        add(block + nameOfTree + "_trapdoor", "Trappe en " + translation);
        add(item + nameOfTree + "_sign", "Pancarte en " + translation);
        add(item + nameOfTree + "_hanging_sign", "Pancarte suspendue en " + translation);
        add(item + nameOfTree + "_sapling", "Pousse de " + translation);
    }
}