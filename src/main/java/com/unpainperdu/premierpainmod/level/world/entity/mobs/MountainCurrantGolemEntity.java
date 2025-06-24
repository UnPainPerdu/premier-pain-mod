package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.goal.UseBoneMealOnCropGoal;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MountainCurrantGolemEntity extends AbstractGolem
{
    public final AnimationState boneMealingAnimationState = new AnimationState();
    private int boneMealingAnimationTimeout = 0;

    public MountainCurrantGolemEntity(EntityType<? extends AbstractGolem> entityType, Level level)
    {
        super(entityType, level);
    }

    //TODO transform it into new brain system
    @Override
    protected void registerGoals()
    {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TemptGoal(this, 1.25, s -> s.is(Items.EMERALD), false));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(2, new UseBoneMealOnCropGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Villager.class, 6F));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, IronGolem.class, 6F));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    private void setupAnimationStates()
    {
        if (this.boneMealingAnimationTimeout >= 61)
        {
            this.boneMealingAnimationTimeout--;
            this.boneMealingAnimationState.start(this.tickCount);
        }
        else if (this.boneMealingAnimationTimeout >= 0)
        {
            this.boneMealingAnimationTimeout--;
        }
    }

    @Override
    public void handleEntityEvent(byte id)
    {
        if (id == 4)
        {
            this.boneMealingAnimationTimeout = 61;
        }
        else
        {
            super.handleEntityEvent(id);
        }
    }

    public void isBoneMealing(boolean isBoneMealing)
    {
        if (isBoneMealing)
        {
            this.level().broadcastEntityEvent(this, (byte) 4);
        }
    }

    @Override
    public void tick()
    {
        super.tick();

        if (this.level().isClientSide())
        {
            this.setupAnimationStates();
        }
    }

    @Override
    protected int decreaseAirSupply(int air)
    {
        return air;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource)
    {
        return SoundEventRegister.MCG_HURT.get();
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state)
    {
        this.playSound(SoundEventRegister.MCG_WALK.get(), 1.0F, 1.0F);
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEventRegister.MCG_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEventRegister.MCG_AMBIENT.get();
    }
}
