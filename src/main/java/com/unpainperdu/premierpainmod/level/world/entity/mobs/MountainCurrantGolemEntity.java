package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MountainCurrantGolemEntity extends AbstractGolem
{
    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout = 0;

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
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6F));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Villager.class, 6F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
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
        if (this.walkAnimationTimeout <= 0)
        {
            this.walkAnimationTimeout = 20;
            this.walkAnimationState.start(this.tickCount);
        }
        else
        {
            this.walkAnimationTimeout--;
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
}
