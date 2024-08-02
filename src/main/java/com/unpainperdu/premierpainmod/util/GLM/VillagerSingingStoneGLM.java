package com.unpainperdu.premierpainmod.util.GLM;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class VillagerSingingStoneGLM extends LootModifier
{
    public static final MapCodec<VillagerSingingStoneGLM> CODEC = RecordCodecBuilder.mapCodec(inst ->
            // LootModifier#codecStart adds the conditions field.
            LootModifier.codecStart(inst).and(
                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(e -> e.item)
            ).apply(inst, VillagerSingingStoneGLM::new)
    );

    private final Item item;

    public VillagerSingingStoneGLM(LootItemCondition[] conditions, Item item)
    {
        super(conditions);
        this.item = item;
    }

    // This is where the magic happens. Use your extra properties here if needed.
    // Parameters are the existing loot, and the loot context.
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        for(LootItemCondition condition : this.conditions)
        {
            if(!condition.test(context))
            {
                return generatedLoot;
            }
        }

        generatedLoot.add(new ItemStack(this.item));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return CODEC;
    }
}
