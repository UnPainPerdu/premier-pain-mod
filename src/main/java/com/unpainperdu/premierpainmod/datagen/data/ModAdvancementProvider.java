package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

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
            //root
            generateRootAdvancement("main", BlockRegister.VILLAGER_WORKSHOP);
            //main
            generateAdvancementWithMainAsRoot(BlockRegister.VILLAGER_WORKSHOP, "villager_workshop", AdvancementType.TASK,
                    Map.of(
                            "has_villager_workshop", InventoryChangeTrigger.TriggerInstance.hasItems(BlockRegister.VILLAGER_WORKSHOP)
                    ),
                    null);
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
        private void generateAdvancementWithMainAsRoot(ItemLike itemToDisplay, String advancementName, AdvancementType advancementType, Map<String, Criterion<?>> condition, @Nullable List<String> requiredAdvancement)
        {
            generateAdvancement("main", "premierpainmod:main/root", itemToDisplay, advancementName, advancementType, condition, requiredAdvancement);
        }

        private void generateAdvancement(String page, String parent, ItemLike itemToDisplay, String advancementName, AdvancementType advancementType, Map<String, Criterion<?>> condition, @Nullable List<String> requiredAdvancement)
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
            condition.forEach(builder::addCriterion);
            List<String> requirement = new ArrayList<>(condition.keySet());
            if (requiredAdvancement != null)
            {
                requirement.addAll(requiredAdvancement);
            }
            builder.requirements(AdvancementRequirements.allOf(requirement));
            builder.save(saver, ResourceUtil.createResourceLocation(page + "/" + advancementName), existingFileHelper);
        }
    }
}
