package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.mountain_currant_golem;

import com.mojang.datafixers.util.Pair;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.smartbrainlib.api.core.behaviour.ExtendedBehaviour;
import net.tslat.smartbrainlib.object.MemoryTest;
import net.tslat.smartbrainlib.util.BrainUtils;

import java.util.List;

public class BoneMealingField<E extends LivingEntity> extends ExtendedBehaviour<E>
{
    private static final MemoryTest MEMORY_REQUIREMENTS = MemoryTest.builder(2).hasMemory(MemoryModuleTypeRegister.CHOSEN_BLOCK.get()).noMemory(MemoryModuleTypeRegister.BONE_MEALING_CD.get());
    private BlockPos target;

    @Override
    protected List<Pair<MemoryModuleType<?>, MemoryStatus>> getMemoryRequirements()
    {
        return MEMORY_REQUIREMENTS;
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, E entity)
    {
        boolean canStart = false;
        BlockPos entityPos = entity.getOnPos().above();
        BlockPos targetField = BrainUtils.getMemory(entity, MemoryModuleTypeRegister.CHOSEN_BLOCK.get());
        if (entityPos.equals(targetField))
        {
            BlockState state = level.getBlockState(targetField);
            Block targetBlock = state.getBlock();
            if (targetBlock instanceof CropBlock crop)
            {
                if (!crop.isMaxAge(state))
                {
                    this.target = targetField;
                    canStart = true;
                }
            }
            else if (targetBlock instanceof AbstractCropLikeBlock crop)
            {
                if (!crop.isMaxAge(state))
                {
                    this.target = targetField;
                    canStart = true;
                }
            }
            else
            {
                BrainUtils.setForgettableMemory(entity, MemoryModuleTypeRegister.BONE_MEALING_CD.get(), Unit.INSTANCE, 300 + RandomUtil.getRandomIntInRange(100, entity.getRandom()));
            }
        }
        return canStart;
    }

    @Override
    protected void start(E entity)
    {
        startBoneMealing(entity);
    }

    @Override
    protected void stop(E entity)
    {
        this.target = null;
        BrainUtils.setForgettableMemory(entity, MemoryModuleTypeRegister.BONE_MEALING_CD.get(), Unit.INSTANCE, 600 + RandomUtil.getRandomIntInRange(200, entity.getRandom()));
    }

    public void startBoneMealing(E entity)
    {
        boneMeal(entity);
        entity.level().broadcastEntityEvent(entity, (byte) 4);
        entity.playSound(SoundEventRegister.MCG_BONE_MEALING.get(), 1F, 1F);
    }

    private void boneMeal(E entity)
    {
        Level level = entity.level();
        RandomSource rand = entity.getRandom();
        BlockState state = level.getBlockState(this.target);
        Block block = state.getBlock();
        if (block instanceof BonemealableBlock field)
        {
            field.performBonemeal((ServerLevel) level, rand, this.target, state);
        }
    }
}
