package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider
{
    // for full tuto https://docs.neoforged.net/docs/1.21.1/resources/server/advancements
    public ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper)
    {
        super(output, registries, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator
    {
        @Override
        public void generate(HolderLookup.@NotNull Provider registries, @NotNull Consumer<AdvancementHolder> saver, @NotNull ExistingFileHelper existingFileHelper)
        {
            Advancement.Builder builder = Advancement.Builder.advancement();

            // Sets the parent of the advancement. You can use another advancement you have already generated,
            // or create a placeholder advancement using the static AdvancementSubProvider#createPlaceholder method.
            builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/root"));

            // Sets the display properties of the advancement. This can either be a DisplayInfo object,
            // or pass in the values directly. If values are passed in directly, a DisplayInfo object will be created for you.
            builder.display(
                    // The advancement icon. Can be an ItemStack or an ItemLike.
                    new ItemStack(Items.GRASS_BLOCK),
                    // The advancement title and description. Don't forget to add translations for these!
                    Component.translatable("advancements.premierpainmod.test_advancement.title"),
                    Component.translatable("advancements.premierpainmod.test_advancement.description"),
                    // The background texture. Use null if you don't want a background texture (for non-root advancements).
                    null,
                    // The frame type. Valid values are AdvancementType.TASK, CHALLENGE, or GOAL.
                    AdvancementType.GOAL,
                    // Whether to show the advancement toast or not.
                    true,
                    // Whether to announce the advancement into chat or not.
                    true,
                    // Whether the advancement should be hidden or not.
                    false
            );

            // Adds a criterion with the given name to the advancement. Use the corresponding trigger instance's static method.
            builder.addCriterion("pickup_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT));

            // Adds a requirement's handler. Minecraft natively provides allOf() and anyOf(), more complex requirements
            // must be implemented manually. Only has an effect with two or more criteria.
            builder.requirements(AdvancementRequirements.allOf(List.of("pickup_dirt")));

            // Save the advancement to disk, using the given resource location. This returns an AdvancementHolder,
            // which may be stored in a variable and used as a parent by other advancement builders.
            builder.save(saver, ResourceUtil.createResourceLocation("example_advancement"), existingFileHelper);
        }
    }
}
