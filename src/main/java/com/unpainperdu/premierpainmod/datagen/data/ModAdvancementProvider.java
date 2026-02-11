package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.overworld.ModOverworldSurfaceBiomes;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.structure.ModStructure;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item.DrinkableBeerItem;
import com.unpainperdu.premierpainmod.datagen.data.level.world.worldgen.biome.ModBiomes;
import com.unpainperdu.premierpainmod.util.mod_list.ModItemList;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.block.WoodBlockEnum;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum.*;

public class ModAdvancementProvider extends AdvancementProvider
{
    // for full tutorial https://docs.neoforged.net/docs/1.21.1/resources/server/advancements
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper)
    {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator
    {
        private Consumer<AdvancementHolder> saver;
        private ExistingFileHelper existingFileHelper;
        private HolderLookup.Provider registries;

        @Override
        public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
        {
            this.saver = saver;
            this.existingFileHelper = existingFileHelper;
            this.registries = registries;
            HolderGetter<Biome> biomeHoldergetter = this.registries.lookupOrThrow(Registries.BIOME);
            HolderGetter<Structure> structureHolderGetter = this.registries.lookupOrThrow(Registries.STRUCTURE);
            //root
            generateRootAdvancement("main", Items.EMERALD);
            //main
            generateAdvancementWithMainAsRoot(BlockRegister.VILLAGER_WORKSHOP, "villager_workshop", "root", AdvancementType.TASK,
                    Map.of(
                            "has_villager_workshop", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.VILLAGER_WORKSHOP)
                    ));
            generateAdvancementWithMainAsRoot(BlockRegister.CIVILIZATIONS_FLOWER, "civilization_flower", "root", AdvancementType.TASK,
                    Map.of(
                            "has_civilization_flower", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.CIVILIZATIONS_FLOWER)
                    ));
            generateAdvancementWithMainAsRoot(ItemRegister.PAIN_DIEUX_MUG, "first_beer", "civilization_flower", AdvancementType.TASK,
                    Map.of(
                            "has_beer", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(
                                            ModItemList.getAllItemsFromClass(DrinkableBeerItem.class).stream()
                                                    .filter(item -> ResourceUtil.getKey(item).toString().contains("mug"))
                                                    .toList()
                                                    .toArray(new Item[0])
                                    )
                            )
                    ));

            generateAdvancementWithMainAsRoot(ItemRegister.PAIN_DIEUX_BOTTLE, "all_beer_bottle", "first_beer", AdvancementType.TASK,
                    Map.of(
                            "has_all_beer_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(
                                    ModItemList.getAllItemsFromClass(DrinkableBeerItem.class).stream()
                                            .filter(item -> ResourceUtil.getKey(item).toString().contains("bottle"))
                                            .toList()
                                            .toArray(new Item[0])
                            )
                    ));

            generateAdvancementWithMainAsRoot(BlockRegister.COOKING_POT_BLOCK, "cooking_pot", "root", AdvancementType.TASK,
                    Map.of("cooking_pot", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.COOKING_POT_BLOCK)));

            Map<String, Criterion<?>> conditions = new LinkedHashMap<>();
            for (ResourceKey<Biome> biome : ModBiomes.OVERWORLD_BIOMES)
            {
                String name = "has_visited_" + biome.location().toString().replace("premierpainmod:", "").replace("/", "_");
                conditions.put(name, PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(biomeHoldergetter.getOrThrow(biome))));
            }
            generateAdvancementWithMainAsRoot(BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get(WoodBlockEnum.SAPLING.toString()), "visit_all_biomes", "root", AdvancementType.CHALLENGE,
                    conditions,
                    AdvancementRewards.Builder.experience(350));

            conditions = new LinkedHashMap<>();
            for (ResourceKey<Structure> structure : ModStructure.ALL_STRUCTURES)
            {
                String name = "has_visited_" + structure.location().toString().replace("premierpainmod:", "").replace("/", "_");
                conditions.put(name, PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inStructure(structureHolderGetter.getOrThrow(structure))));
            }
            generateAdvancementWithMainAsRoot(AllMaterialsBlockEnum.getAllMaterialBlock(Type.VILLAGER_CHISELED_HEAD, Material.OAK).get(), "visit_all_structures", "visit_all_biomes", AdvancementType.CHALLENGE,
                    conditions,
                    AdvancementRewards.Builder.experience(550));

            conditions = new LinkedHashMap<>();
            for (TagKey<Item> tagKey : ModItemTags.ALL_MATERIALS_TAGS)
            {
                conditions.put(tagKey.toString(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(tagKey)));
            }

            generateAdvancementWithMainAsRoot(getAllMaterialBlock(Type.VILLAGER_STATUE, Material.EMERALD_BLOCK), "full_set_all_material", "villager_workshop", AdvancementType.CHALLENGE,
                    conditions,
                    AdvancementRewards.Builder.experience(250));

            conditions = new LinkedHashMap<>();
            conditions.put("has_build_iron_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.IRON_GOLEM)));
            conditions.put("has_build_snow_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(EntityType.SNOW_GOLEM)));
            conditions.put("has_build_mountain_currant_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(AllInOneEntityRegister.MOUNTAIN_CURRANT_GOLEM_ENTITY.get())));
            conditions.put("has_build_wool_golem", SummonedEntityTrigger.TriggerInstance.summonedEntity(EntityPredicate.Builder.entity().of(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get())));

            generateAdvancementWithMainAsRoot(AllInOneEntityRegister.EGG_ITEM_MAP.get("mountain_currant_golem_spawn_egg").get(), "get_them_all", "root", AdvancementType.GOAL, conditions);
        }

        /**
         * description component will be "advancements.premierpainmod.\folder/.root.description"
         * title component will be "advancements.premierpainmod.\folder/.root.title"
         *
         * @param folder like "end" for the End page, can't use a / in it
         */
        private void generateRootAdvancement(String folder, ItemLike itemToDisplay)
        {
            Advancement.Builder builder = Advancement.Builder.advancement();
            builder.display(
                    itemToDisplay,
                    Component.translatable("advancements.premierpainmod." + folder + ".root.title"),
                    Component.translatable("advancements.premierpainmod." + folder + ".root.description"),
                    ResourceUtil.createResourceLocation("textures/gui/advancements/backgrounds/" + folder + ".png"),
                    AdvancementType.TASK,
                    false,
                    false,
                    true
            );
            builder.addCriterion("craft_crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Items.CRAFTING_TABLE));
            builder.requirements(AdvancementRequirements.allOf(List.of("craft_crafting_table")));
            builder.save(this.saver, ResourceUtil.createResourceLocation(folder + "/root"), this.existingFileHelper);
        }

        /**
         * description component will be "advancements.premierpainmod.\advancementName/.description"
         * title component will be "advancements.premierpainmod.\advancementName/.title"
         */
        private void generateAdvancementWithMainAsRoot(ItemLike itemToDisplay, String advancementName, String parentName, AdvancementType advancementType, Map<String, Criterion<?>> condition)
        {
            generateAdvancement("main", "premierpainmod:main/" + parentName, itemToDisplay, advancementName, advancementType, condition, null);
        }

        private void generateAdvancementWithMainAsRoot(ItemLike itemToDisplay, String advancementName, String parentName, AdvancementType advancementType, Map<String, Criterion<?>> condition, AdvancementRewards.Builder rewardsBuilder)
        {
            generateAdvancement("main", "premierpainmod:main/" + parentName, itemToDisplay, advancementName, advancementType, condition, rewardsBuilder);
        }

        private void generateAdvancement(String page, String parent, ItemLike itemToDisplay, String advancementName, AdvancementType advancementType, Map<String, Criterion<?>> conditions, @Nullable AdvancementRewards.Builder rewardsBuilder)
        {
            Advancement.Builder builder = Advancement.Builder.advancement();
            builder.parent(AdvancementSubProvider.createPlaceholder(parent));
            builder.display(
                    itemToDisplay,
                    Component.translatable("advancements.premierpainmod." + advancementName + ".title"),
                    Component.translatable("advancements.premierpainmod." + advancementName + ".description"),
                    null,
                    advancementType,
                    true,
                    true,
                    false
            );
            conditions.forEach(builder::addCriterion);
            List<String> requirement = new ArrayList<>(conditions.keySet());
            builder.requirements(AdvancementRequirements.allOf(requirement));
            if (rewardsBuilder != null)
            {
                builder.rewards(rewardsBuilder);
            }
            builder.save(saver, ResourceUtil.createResourceLocation(page + "/" + advancementName), existingFileHelper);
        }
    }
}
