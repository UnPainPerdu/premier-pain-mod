package com.unpainperdu.premierpainmod.util.register.entity.villager;

import com.google.common.collect.ImmutableSet;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.block.AllMaterialsBlockEnum;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A state can only be register once as poi see vanilla {@link net.minecraft.world.entity.ai.village.poi.PoiTypes} for other register
 */
public class VillagerPointOfInterestRegister
{
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(BuiltInRegistries.POINT_OF_INTEREST_TYPE, PremierPainMod.MOD_ID);

    public static DeferredHolder<PoiType, PoiType> BREWER = POI_TYPES.register("brewer_poi",
            () -> new PoiType(getMatchingStateFromList(AllMaterialsBlockEnum.getAllMaterialBlocks(AllMaterialsBlockEnum.Type.VILLAGER_BREWING_STATION)),
                    1,
                    1)
    );

    private static Set<BlockState> getMatchingStateFromList(List<DeferredBlock<Block>> deferredBlocks)
    {
        List<BlockState> blockStates = new ArrayList<>();
        for (DeferredBlock<Block> deferredBlock : deferredBlocks)
        {
            blockStates.addAll(getMatchingState(deferredBlock));
        }
        return getMatchingState(blockStates);
    }

    private static Set<BlockState> getMatchingState(DeferredBlock<Block> deferredBlock)
    {
        return getMatchingState(deferredBlock.get().getStateDefinition().getPossibleStates());
    }

    private static Set<BlockState> getMatchingState(List<BlockState> blockStates)
    {
        return ImmutableSet.copyOf(blockStates);
    }

    public static void register(IEventBus modEventBus)
    {
        POI_TYPES.register(modEventBus);
    }
}