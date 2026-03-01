package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractCropLikeBlock;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityFollowTargetWhenItemInHand;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityGoToBlockAndMemorizeIt;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityLookTarget;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.mountain_currant_golem.BoneMealingField;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
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
import net.tslat.smartbrainlib.api.core.sensor.custom.NearbyBlocksSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class MountainCurrantGolemEntity extends AbstractGolem implements SmartBrainOwner<MountainCurrantGolemEntity>
{
    public final AnimationState boneMealingAnimationState = new AnimationState();

    public MountainCurrantGolemEntity(EntityType<? extends AbstractGolem> entityType, Level level)
    {
        super(entityType, level);
    }

    //https://github.com/Tslat/SmartBrainLib/wiki/Making-an-Entity-With-SmartBrainLib
    @Override
    public List<ExtendedSensor<MountainCurrantGolemEntity>> getSensors()
    {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<MountainCurrantGolemEntity>()    // Keep track of nearby entities the golem is interested in
                        .setPredicate((target, entity) ->
                                target instanceof Player ||
                                        target instanceof Villager ||
                                        target instanceof IronGolem),
                new NearbyBlocksSensor<MountainCurrantGolemEntity>().setRadius(15).setPredicate(this::isValidBlockToBoneMeal) // Keep track of nearby block the golem is interested in
        );
    }

    @Override
    public BrainActivityGroup<MountainCurrantGolemEntity> getCoreTasks() // These are the tasks that run all the time (usually)
    {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),// Have the entity turn to face and look at its current look target
                new MoveToWalkTarget<>()// Walk towards the current walk target
        );
    }

    @Override
    public BrainActivityGroup<MountainCurrantGolemEntity> getIdleTasks() // These are the tasks that run when the mob isn't doing anything else (usually)
    {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<MountainCurrantGolemEntity>(      // Run only one of the below behaviours, trying each one in order. Include the generic type because JavaC is silly
                        new SetEntityGoToBlockAndMemorizeIt<>().closeEnoughWhen((e, p) -> 0),
                        SetEntityFollowTargetWhenItemInHand.builder().setItems(Items.EMERALD).setMaxDistanceSight(10).build(),
                        new SetEntityLookTarget<>(5),
                        new SetRandomLookTarget<>()),         // Set a random look target
                new OneRandomBehaviour<>(                 // Run a random task from the below options
                        new SetRandomWalkTarget<>(),          // Set a random walk target to a nearby position
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(60, 100))) // Do nothing in tick
        );
    }

    private BrainActivityGroup<MountainCurrantGolemEntity> getWorkTasks()
    {
        return new BrainActivityGroup<MountainCurrantGolemEntity>(Activity.WORK)
                .priority(10)
                .behaviours(
                        new BoneMealingField<>()
                )
                .requireAndWipeMemoriesOnUse(MemoryModuleTypeRegister.CHOSEN_BLOCK.get())
                .onlyStartWithMemoryStatus(MemoryModuleTypeRegister.BONE_MEALING_CD.get(), MemoryStatus.VALUE_ABSENT)
                .onlyStartWithMemoryStatus(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT)
                ;
    }

    @Override
    public Map<Activity, BrainActivityGroup<? extends MountainCurrantGolemEntity>> getAdditionalTasks()
    {
        return Map.of(Activity.WORK, getWorkTasks());
    }

    @Override
    public List<Activity> getActivityPriorities()
    {
        return ObjectArrayList.of(
                Activity.WORK,
                Activity.IDLE
        );
    }

    @Override
    protected Brain.@NotNull Provider<MountainCurrantGolemEntity> brainProvider()
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
                .add(Attributes.MAX_HEALTH, 50)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 24);
    }

    @Override
    public void handleEntityEvent(byte id)
    {
        if (id == 4)
        {
            this.boneMealingAnimationState.start(this.tickCount);
        }
        else
        {
            super.handleEntityEvent(id);
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

    private void setupAnimationStates()
    {
    }

    @Override
    protected int decreaseAirSupply(int air)
    {
        return air;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource)
    {
        return SoundEventRegister.MCG_HURT.get();
    }

    @Override
    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state)
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

    private boolean isValidBlockToBoneMeal(BlockState state, LivingEntity livingEntity)
    {
        boolean isValidBlockToBoneMeal = false;
        Block block = state.getBlock();
        if (block instanceof AbstractCropLikeBlock crop)
        {
            isValidBlockToBoneMeal = !crop.isMaxAge(state);
        }
        else if (block instanceof CropBlock crop)
        {
            isValidBlockToBoneMeal = !crop.isMaxAge(state);
        }
        return state.is(BlockTags.BEE_GROWABLES) && isValidBlockToBoneMeal;
    }
}
