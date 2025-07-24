package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Items;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

public class EnumExtensionList
{
    private EnumExtensionList()
    {
    }

    public static final EnumProxy<Boat.Type> MOUNTAIN_CURRANT_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("planks"),
            "premierpainmod:mountain_currant",
            ItemRegister.ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("boat"),
            ItemRegister.ITEM_MOUNTAIN_CURRANT_WOOD_TYPE_MAP.get("chest_boat"),
            Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> MORICHE_PALM_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.MORICHE_PALM_WOOD_TYPE_MAP.get("planks"),
            "premierpainmod:moriche_palm",
            ItemRegister.ITEM_MORICHE_PALM_WOOD_TYPE_MAP.get("boat"),
            ItemRegister.ITEM_MORICHE_PALM_WOOD_TYPE_MAP.get("chest_boat"),
            Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> ACHIOTE_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.ACHIOTE_WOOD_TYPE_MAP.get("planks"),
            "premierpainmod:achiote",
            ItemRegister.ITEM_ACHIOTE_WOOD_TYPE_MAP.get("boat"),
            ItemRegister.ITEM_ACHIOTE_WOOD_TYPE_MAP.get("chest_boat"),
            Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> WEEPING_WILLOW_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.WEEPING_WILLOW_WOOD_TYPE_MAP.get("planks"),
            "premierpainmod:weeping_willow",
            ItemRegister.ITEM_WEEPING_WILLOW_WOOD_TYPE_MAP.get("boat"),
            ItemRegister.ITEM_WEEPING_WILLOW_WOOD_TYPE_MAP.get("chest_boat"),
            Items.STICK,
            false
    );
}
