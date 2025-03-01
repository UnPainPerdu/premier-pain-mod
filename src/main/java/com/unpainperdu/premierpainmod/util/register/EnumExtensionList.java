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
    private EnumExtensionList(){}

    public static final EnumProxy<Boat.Type> MOUNTAIN_CURRANT_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>)() -> BlockRegister.MOUNTAIN_CURRANT_PLANKS.get(),
            "premierpainmod:mountain_currant",
            (Supplier<Item>)() -> ItemRegister.MOUNTAIN_CURRANT_BOAT.get(),
            (Supplier<Item>)() -> ItemRegister.MOUNTAIN_CURRANT_CHEST_BOAT.get(),
            (Supplier<Item>)() -> Items.STICK,
            false
    );

    public static final EnumProxy<Boat.Type> MORICHE_PALM_BOAT_TYPE = new EnumProxy<>(Boat.Type.class,
            (Supplier<Block>)() -> BlockRegister.MORICHE_PALM_PLANKS.get(),
            "premierpainmod:moriche_palm",
            (Supplier<Item>)() -> ItemRegister.MORICHE_PALM_BOAT.get(),
            (Supplier<Item>)() -> ItemRegister.MORICHE_PALM_CHEST_BOAT.get(),
            (Supplier<Item>)() -> Items.STICK,
            false
    );
}
