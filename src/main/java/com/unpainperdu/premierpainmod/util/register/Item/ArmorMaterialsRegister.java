package com.unpainperdu.premierpainmod.util.register.Item;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ArmorMaterialsRegister
{
    private ArmorMaterialsRegister()
    {
    }

    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, PremierPainMod.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> FLOWERED_LIZARD_SCALE = register(
            "flowered_lizard_scale",
            Util.make(
                    new EnumMap<>(ArmorItem.Type.class),
                    map ->
                    {
                        map.put(ArmorItem.Type.BOOTS, 1);
                        map.put(ArmorItem.Type.LEGGINGS, 4);
                        map.put(ArmorItem.Type.CHESTPLATE, 5);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 4);
                    }),
            12,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            () -> Ingredient.of(Items.IRON_INGOT),
            0.0F,
            0.0F);

    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name,
            Map<ArmorItem.Type, Integer> defense,
            int enchantValue,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngrediant,
            float toughness,
            float knockbackResistance
    )
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceUtil.createResourceLocation(name)));
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(defense, enchantValue, equipSound, repairIngrediant, list, toughness, knockbackResistance));
    }

    public static void register(IEventBus modEventBus)
    {
        ARMOR_MATERIALS.register(modEventBus);
    }
}
