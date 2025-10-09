package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityFollowTargetWhenItemInHand;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityLookTarget;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WoolGolemEntity extends AbstractGolem implements SmartBrainOwner<WoolGolemEntity>
{
    public final AnimationState HUG = new AnimationState();
    public final AnimationState SIT = new AnimationState();
    public final AnimationState GETUP = new AnimationState();

    public WoolGolemEntity(EntityType<? extends AbstractGolem> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    public List<ExtendedSensor<WoolGolemEntity>> getSensors()
    {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<WoolGolemEntity>()
                        .setPredicate((target, entity) ->
                                target instanceof Player ||
                                        target instanceof Villager ||
                                        target instanceof IronGolem ||
                                        target instanceof Monster)
        );
    }

    @Override
    public BrainActivityGroup<? extends WoolGolemEntity> getCoreTasks()
    {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new MoveToWalkTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<? extends WoolGolemEntity> getIdleTasks()
    {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<WoolGolemEntity>(
                        new SetEntityFollowTargetWhenItemInHand<>(Items.EMERALD, 10),
                        new SetEntityLookTarget<>(5),
                        new SetRandomLookTarget<>()),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>(),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(60, 100)))
        );
    }

    @Override
    public List<Activity> getActivityPriorities()
    {
        return ObjectArrayList.of(
                Activity.IDLE
        );
    }

    @Override
    protected Brain.@NotNull Provider<?> brainProvider()
    {
        return new SmartBrainProvider<>(this);
    }

    @Override
    protected void customServerAiStep()
    {
        tickBrain(this);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 30)
                .add(Attributes.MOVEMENT_SPEED, 0.15)
                .add(Attributes.FOLLOW_RANGE, 30);
    }

    @Override
    protected int decreaseAirSupply(int air)
    {
        return air;
    }
}
