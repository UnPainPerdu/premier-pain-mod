package com.unpainperdu.premierpainmod.util.register.block;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerBrewingStation;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.VillagerDrawer;
import com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_width_with_block_entity.villager_shelf.VillagerShelf;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModHangingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModStandingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModWallHangingSignBlock;
import com.unpainperdu.premierpainmod.level.world.block.tree.ModWallSignBlock;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.PedestalBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerBrewingStationBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerDrawerBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.all_materials_block.VillagerShelfBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.tree.ModHangingSignBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.block_entity.tree.ModSignBlockEntity;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class BlockEntityRegister
{
    private BlockEntityRegister(){}

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<PedestalBlockEntity>> PEDESTAL_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("pedestal_block_entity",() -> BlockEntityType.Builder.of(PedestalBlockEntity::new, (listPedestalHelper()).toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<VillagerDrawerBlockEntity>> VILLAGER_DRAWER_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("villager_drawer_block_entity",() -> BlockEntityType.Builder.of(VillagerDrawerBlockEntity::new, (listDrawerHelper()).toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<VillagerShelfBlockEntity>> VILLAGER_SHELF_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("villager_shelf_block_entity",() -> BlockEntityType.Builder.of(VillagerShelfBlockEntity::new, listShelfHelper().toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ModSignBlockEntity>> MOD_SIGN = BLOCK_ENTITY_TYPES.register("mod_sign",() -> BlockEntityType.Builder.of(ModSignBlockEntity::new, listSignHelper().toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN = BLOCK_ENTITY_TYPES.register("mod_hanging_sign",() -> BlockEntityType.Builder.of(ModHangingSignBlockEntity::new, listHangingSignHelper().toArray(new Block[0])).build(null));
    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<VillagerBrewingStationBlockEntity>> VILLAGER_BREWING_STATION_ENTITY = BLOCK_ENTITY_TYPES.register("villager_brewing_station_entity",() -> BlockEntityType.Builder.of(VillagerBrewingStationBlockEntity::new, ModList.getAllBlocksFromClass(VillagerBrewingStation.class).toArray(new Block[0])).build(null));

    public static void register(IEventBus modEventBus)
    {
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }

    private static List<Block> listPedestalHelper()
    {
        List<Block> listPedestal = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof VillagerPedestalBlock)
                listPedestal.add(block);
        }
        return  listPedestal;
    }

    private static List<Block> listDrawerHelper()
    {
        List<Block> listPedestal = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof VillagerDrawer)
                listPedestal.add(block);
        }
        return  listPedestal;
    }

    private static List<Block> listShelfHelper()
    {
        List<Block> listPedestal = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof VillagerShelf)
                listPedestal.add(block);
        }
        return  listPedestal;
    }

    private static List<Block> listSignHelper()
    {
        List<Block> list = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof ModStandingSignBlock || block instanceof ModWallSignBlock)
                list.add(block);
        }
        return  list;
    }

    private static List<Block> listHangingSignHelper()
    {
        List<Block> list = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : ModList.ALL_BLOCKS)
        {
            Block block = deferredBlock.get();
            if(block instanceof ModHangingSignBlock || block instanceof ModWallHangingSignBlock)
                list.add(block);
        }
        return  list;
    }
}
