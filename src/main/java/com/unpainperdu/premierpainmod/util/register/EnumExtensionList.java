package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import java.util.function.Supplier;

public class EnumExtensionList
{
    private EnumExtensionList()
    {
    }

    public static final EnumProxy<Boat.Type> MOUNTAIN_CURRANT_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.MOUNTAIN_CURRANT_PLANKS,
            "premierpainmod:mountain_currant",
            ItemRegister.MOUNTAIN_CURRANT_BOAT,
            ItemRegister.MOUNTAIN_CURRANT_CHEST_BOAT,
            Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> MORICHE_PALM_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.MORICHE_PALM_PLANKS,
            "premierpainmod:moriche_palm",
            ItemRegister.MORICHE_PALM_BOAT,
            ItemRegister.MORICHE_PALM_CHEST_BOAT,
            Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> ACHIOTE_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            BlockRegister.ACHIOTE_PLANKS,
            "premierpainmod:achiote",
            ItemRegister.ACHIOTE_BOAT,
            ItemRegister.ACHIOTE_CHEST_BOAT,
            Items.STICK,
            false
    );
}
