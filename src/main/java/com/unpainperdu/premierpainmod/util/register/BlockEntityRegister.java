package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.VillagerPedestalBlock;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.PedestalBlockEntity;
import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
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
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, PremierPainMod.MODID);

    public static final DeferredHolder<BlockEntityType<?>,BlockEntityType<PedestalBlockEntity>> PEDESTAL_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("pedestal_block_entity",() -> BlockEntityType.Builder.<PedestalBlockEntity>of(PedestalBlockEntity::new, (listPedestalHelper()).toArray(new Block[0])).build(null));

    public static void register(IEventBus modEventBus)
    {
        BLOCK_ENTITY_TYPES.register(modEventBus);
    }

    private static List<Block> listPedestalHelper()
    {
        List<Block> listPedestal = new ArrayList<>();
        for (DeferredBlock<Block> defferedBlock : BlockList.ALL_BLOCKS)
        {
            Block block = defferedBlock.get();
            if(block instanceof VillagerPedestalBlock)
                listPedestal.add(block);
        }
        return  listPedestal;
    }
}
