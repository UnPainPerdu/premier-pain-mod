package com.unpainperdu.premierpainmod.level.world.entity.mobs.goal;

import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.MountainCurrantGolemEntity;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class UseBoneMealOnCropGoal extends Goal
{
    private final Mob mob;
    private final RandomSource rand;
    private static final int MAX_COOLDOWN = 600;
    private int cooldown = 0;
    private boolean isBoneMealing = false;
    private static final int MAX_TIME_BONE_MEALING = 60;
    private int timeBoneMealing = 0;
    private BlockPos cropPosToBoneMeal = null;

    public UseBoneMealOnCropGoal(Mob mob)
    {
        this.mob = mob;
        this.rand = mob.getRandom();
    }

    @Override
    public boolean canUse()
    {
        return !(this.rand.nextFloat() < 0.3F);
    }

    @Override
    public void tick()
    {
        BlockPos pos = this.mob.getOnPos().above();
        ServerLevel level = (ServerLevel) this.mob.level();
        BlockState state = level.getBlockState(pos);
        if (RandomUtil.getRandomPositiveIntInRange(100, this.rand) > 70 && this.cooldown >= MAX_COOLDOWN + MAX_TIME_BONE_MEALING)
        {
            if (blockIsBoneMeanable(state))
            {
                this.isBoneMealing = true;
                playBoneMealSound();
                setClientState(true);
                this.cropPosToBoneMeal = pos;
                this.cooldown = 0;
            }
        }
        if (this.isBoneMealing)
        {
            if (this.cropPosToBoneMeal != null)
            {
                Vec3 vec3 = new Vec3(this.cropPosToBoneMeal.getX(), this.cropPosToBoneMeal.getY(), this.cropPosToBoneMeal.getZ());
                this.mob.getNavigation().moveTo(this.mob.getNavigation().createPath(BlockPos.containing(vec3), 1), 1);
                this.timeBoneMealing++;
            }
            else
            {
                this.isBoneMealing = false;
                this.timeBoneMealing = 0;
            }
        }
        if (this.timeBoneMealing >= MAX_TIME_BONE_MEALING)
        {
            BlockState currentTargetedState = level.getBlockState(this.cropPosToBoneMeal);
            Block block = currentTargetedState.getBlock();
            if (block instanceof CropBlock crop)
            {
                if (!crop.isMaxAge(currentTargetedState))
                {
                    crop.performBonemeal(level, rand, this.cropPosToBoneMeal, currentTargetedState);
                }
            }
            else if (block instanceof AbstractCropLikeBlock crop)
            {
                if (!crop.isMaxAge(currentTargetedState))
                {
                    crop.performBonemeal(level, rand, this.cropPosToBoneMeal, currentTargetedState);
                }
            }
            this.isBoneMealing = false;
            this.timeBoneMealing = 0;
            this.cropPosToBoneMeal = null;
        }
        //memory security
        if (this.cooldown < 1000)
        {
            this.cooldown++;
        }
    }

    @Override
    public boolean requiresUpdateEveryTick()
    {
        return true;
    }

    private boolean blockIsBoneMeanable(BlockState state)
    {
        Block block = state.getBlock();
        boolean flag = true;
        if (block instanceof AbstractCropLikeBlock crop)
        {
            flag = !crop.isMaxAge(state);
        }
        else if (block instanceof CropBlock crop)
        {
            flag = !crop.isMaxAge(state);
        }
        return state.is(BlockTags.BEE_GROWABLES) && flag;
    }

    private void setClientState(boolean bool)
    {
        if (this.mob instanceof MountainCurrantGolemEntity golem)
        {
            golem.isBoneMealing(bool);
        }
    }

    private void playBoneMealSound()
    {
        this.mob.playSound(SoundEventRegister.MCG_BONE_MEALING.get(), 1F, 1F);
    }
}
