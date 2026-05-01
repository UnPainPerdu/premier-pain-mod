package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.behavior.BlockPosTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.memory.WalkTarget;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToBlock;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.registry.SBLMemoryTypes;
import net.tslat.smartbrainlib.util.BrainUtil;

import java.util.List;

public class SetEntityGoToBlockAndMemorizeIt<E extends PathfinderMob> extends SetWalkTargetToBlock<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(4)
            .hasMemory(SBLMemoryTypes.NEARBY_BLOCKS.get())
            .noMemory(MemoryModuleTypeRegister.BONE_MEALING_CD.get())
            .noMemory(MemoryModuleTypeRegister.CHOSEN_BLOCK.get())
            .noMemory(MemoryModuleTypeRegister.FAIL_CD.get());

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity)
    {
        List<Pair<BlockPos, BlockState>> nearbyBlocks = BrainUtil.getMemory(entity, SBLMemoryTypes.NEARBY_BLOCKS.get());
        if (nearbyBlocks != null)
        {
            int sizeList = nearbyBlocks.size();
            if (sizeList == 1)
            {
                this.target = nearbyBlocks.getFirst();
                BrainUtil.setForgettableMemory(entity, MemoryModuleTypeRegister.CHOSEN_BLOCK.get(), this.target.getFirst(), 200);
                BrainUtil.setForgettableMemory(entity, MemoryModuleTypeRegister.FAIL_CD.get(), Unit.INSTANCE, 400);
            }
            else if (sizeList > 1)
            {
                this.target = nearbyBlocks.get(RandomUtil.getRandomPositiveIntInRange(nearbyBlocks.size(), level.getRandom()));
                BrainUtil.setForgettableMemory(entity, MemoryModuleTypeRegister.CHOSEN_BLOCK.get(), this.target.getFirst(), 200);
                BrainUtil.setForgettableMemory(entity, MemoryModuleTypeRegister.FAIL_CD.get(), Unit.INSTANCE, 400);
            }
        }

        return this.target != null;
    }

    @Override
    protected void start(E entity)
    {
        BrainUtil.setMemory(entity, MemoryModuleType.WALK_TARGET, new WalkTarget(this.target.getFirst(), this.speedMod.applyAsFloat(entity, this.target), this.closeEnoughDist.applyAsInt(entity, this.target)));
        BrainUtil.setForgettableMemory(entity, MemoryModuleType.LOOK_TARGET, new BlockPosTracker(this.target.getFirst()), 150);
    }
}