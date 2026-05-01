package com.unpainperdu.premierpainmod.util.register.block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height_with_block_entity.VillagerMusicalFridgeBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModHangingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModStandingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModWallHangingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModWallSignBlock;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.*;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.crafting_block.CookingPotBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.tree.ModHangingSignBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.tree.ModSignBlockEntity;
import com.unpainperdu.premierpainmod.util.mod_list.ModBLockList;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockEntityRegister
{
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PedestalBlockEntity>> PEDESTAL_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "pedestal_block_entity",
            () -> new BlockEntityType<>(PedestalBlockEntity::new, ModBLockList.getAllBlocksFromClass(VillagerPedestalBlock.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VillagerDrawerBlockEntity>> VILLAGER_DRAWER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "villager_drawer_block_entity",
            () -> new BlockEntityType<>(VillagerDrawerBlockEntity::new, ModBLockList.getAllBlocksFromClass(VillagerDrawer.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VillagerShelfBlockEntity>> VILLAGER_SHELF_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "villager_shelf_block_entity",
            () -> new BlockEntityType<>(VillagerShelfBlockEntity::new, ModBLockList.getAllBlocksFromClass(VillagerShelf.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITY_TYPES.register(
            "mod_sign",
            () -> new BlockEntityType<>(ModSignBlockEntity::new, ModBLockList.getAllBlocksFromClass(ModStandingSignBlock.class, ModWallSignBlock.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITY_TYPES.register(
            "mod_hanging_sign",
            () -> new BlockEntityType<>(ModHangingSignBlockEntity::new, ModBLockList.getAllBlocksFromClass(ModHangingSignBlock.class, ModWallHangingSignBlock.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VillagerBrewingStationBlockEntity>> VILLAGER_BREWING_STATION_ENTITY = BLOCK_ENTITY_TYPES.register(
            "villager_brewing_station_entity",
            () -> new BlockEntityType<>(VillagerBrewingStationBlockEntity::new, ModBLockList.getAllBlocksFromClass(VillagerBrewingStation.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<VillagerMusicalFridgeBlockEntity>> VILLAGER_MUSICAL_FRIDGE_ENTITY = BLOCK_ENTITY_TYPES.register(
            "villager_musical_fridge_entity",
            () -> new BlockEntityType<>(VillagerMusicalFridgeBlockEntity::new, ModBLockList.getAllBlocksFromClass(VillagerMusicalFridgeBlock.class).toArray(new Block[0])));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CookingPotBlockEntity>> COOKING_POT_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register(
            "cooking_pot_block_entity",
            () -> new BlockEntityType<>(CookingPotBlockEntity::new, BlockRegister.COOKING_POT_BLOCK.get()));

    public static void register(IEventBus modEventBus)
    {
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }
}