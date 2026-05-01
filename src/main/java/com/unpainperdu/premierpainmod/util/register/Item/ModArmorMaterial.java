package com.unpainperdu.premierpainmod.util.register.Item;

import com.unpainperdu.premierpainmod.util.tool_kit.ResourceUtil;
import net.minecraft.Util;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.EnumMap;

public class ModArmorMaterial
{
    public static final ArmorMaterial FLOWERED_LIZARD_SCALE = new ArmorMaterial(
            12,
            Util.make(
                    new EnumMap<>(ArmorType.class),
                    map ->
                    {
                        map.put(ArmorType.BOOTS, 1);
                        map.put(ArmorType.LEGGINGS, 4);
                        map.put(ArmorType.CHESTPLATE, 5);
                        map.put(ArmorType.HELMET, 2);
                        map.put(ArmorType.BODY, 4);
                    }),
            12,
            SoundEvents.ARMOR_EQUIP_CHAIN,
            0.0F,
            0.0F,
            ItemTags.REPAIRS_IRON_ARMOR, //TODO add tag
            ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceUtil.createResourceLocation("flowered_lizard_scale"))
    );
}