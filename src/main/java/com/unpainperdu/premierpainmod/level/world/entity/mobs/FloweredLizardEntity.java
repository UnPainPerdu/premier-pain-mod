package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModItemTags;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.ConvertLastHitByEntityIntoTarget;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.ModAnimatableMeleeAttack;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityLookTarget;
import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.Swim;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.gameevent.GameEvent;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.BreedWithPartner;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.FollowParent;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.FollowTemptation;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetWalkTargetToAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.InvalidateAttackTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.HurtBySensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.ItemTemptingSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FloweredLizardEntity extends Animal implements SmartBrainOwner<FloweredLizardEntity>
{
    public static final float BABY_SCALE = 0.6F; //TODO real model for baby if possible (for 26.1)

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public final AnimationState walkAnimationState = new AnimationState();
    private int walkAnimationTimeout = 0;
    public final AnimationState attack0AnimationState = new AnimationState();
    public final AnimationState attack1AnimationState = new AnimationState();
    public final AnimationState attack2AnimationState = new AnimationState();
    public final AnimationState eatAnimationState = new AnimationState();

    public int eggTime = this.random.nextInt(9000) + 9000;

    public FloweredLizardEntity(EntityType<? extends FloweredLizardEntity> entityType, Level level)
    {
        super(entityType, level);
    }

    @Override
    public boolean isFood(@NotNull ItemStack stack)
    {
        return stack.is(ModItemTags.FLOWERED_LIZARD_FOOD);
    }

    @Override
    protected void customServerAiStep()
    {
        tickBrain(this);
    }

    @Override
    protected Brain.@NotNull Provider<FloweredLizardEntity> brainProvider()
    {
        return new SmartBrainProvider<>(this);
    }

    @Override
    public List<? extends ExtendedSensor<? extends FloweredLizardEntity>> getSensors()
    {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<FloweredLizardEntity>()
                        .setPredicate((target, entity) ->
                                target instanceof Player ||
                                        target instanceof FloweredLizardEntity
                        ),
                new HurtBySensor<>(),
                new ItemTemptingSensor<FloweredLizardEntity>().temptedWith(FloweredLizardEntity::isFood)
                        .setRadius(16, 8)
        );
    }

    @Override
    public BrainActivityGroup<? extends FloweredLizardEntity> getCoreTasks()
    {
        return BrainActivityGroup.coreTasks(
                new LookAtTarget<>(),
                new Swim(0.8F),
                new MoveToWalkTarget<>(),
                new ConvertLastHitByEntityIntoTarget<>()
        );
    }

    @Override
    public BrainActivityGroup<? extends FloweredLizardEntity> getIdleTasks()
    {
        return BrainActivityGroup.idleTasks(
                new FirstApplicableBehaviour<FloweredLizardEntity>(
                        new BreedWithPartner<>(),
                        new FollowTemptation<>().speedMod((f, p) -> 1.5F),
                        new FollowParent<>(),
                        new SetEntityLookTarget<>(5),
                        new SetRandomLookTarget<>()
                ),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>(),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(60, 100))
                )
        );
    }

    @Override
    public BrainActivityGroup<? extends FloweredLizardEntity> getFightTasks()
    {
        return new BrainActivityGroup<FloweredLizardEntity>(Activity.FIGHT)
                .priority(10)
                .behaviours(
                        new InvalidateAttackTarget<>(),
                        new SetWalkTargetToAttackTarget<>().closeEnoughDist((entity, taget) -> 1).speedMod((entity, target) -> 1.5F),
                        new ModAnimatableMeleeAttack<>(0)
                )
                .onlyStartWithMemoryStatus(MemoryModuleType.ATTACK_TARGET, MemoryStatus.VALUE_PRESENT);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel level, @NotNull AgeableMob otherParent)
    {
        return AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get().create(level);
    }

    public static AttributeSupplier.Builder createAttributes()
    {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.MOVEMENT_SPEED, 0.25)
                .add(Attributes.FOLLOW_RANGE, 25)
                .add(Attributes.ARMOR, 2)
                .add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.ATTACK_SPEED, 0.9)
                .add(Attributes.ATTACK_KNOCKBACK, 2);
    }

    @Override
    public void tick()
    {
        super.tick();

        if (this.level().isClientSide())
        {
            this.setupAnimationStates();
        }
        else if (this.isAlive() && !this.isBaby() && --this.eggTime <= 0)
        {
            this.playSound(SoundEvents.CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.spawnAtLocation(ItemRegister.FLOWERED_LIZARD_EGG);
            this.gameEvent(GameEvent.ENTITY_PLACE);
            this.eggTime = this.random.nextInt(9000) + 9000;
        }
    }

    private void setupAnimationStates()
    {
        if (this.idleAnimationTimeout <= 0)
        {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        }
        else
        {
            --this.idleAnimationTimeout;
        }

        if (this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6)
        {
            if (walkAnimationTimeout <= 0)
            {
                this.walkAnimationTimeout = 20;
                this.walkAnimationState.start(this.tickCount);
            }
            else
            {
                --this.walkAnimationTimeout;
            }
        }
        else
        {
            this.walkAnimationTimeout = 0;
            this.walkAnimationState.stop();
        }
    }

    @Override
    protected void usePlayerItem(@NotNull Player player, @NotNull InteractionHand hand, @NotNull ItemStack stack)
    {
        this.level().broadcastEntityEvent(this, (byte) 4);
        this.playEatSound();
        super.usePlayerItem(player, hand, stack);
    }

    @Override
    public @NotNull InteractionResult mobInteract(Player player, @NotNull InteractionHand hand)
    {
        ItemStack itemstack = player.getItemInHand(hand);
        if (itemstack.canPerformAction(net.neoforged.neoforge.common.ItemAbilities.BRUSH_BRUSH) && !this.isBaby())
        {
            this.spawnAtLocation(new ItemStack(ItemRegister.FLOWERED_LIZARD_SCALE.get()));
            this.gameEvent(GameEvent.ENTITY_INTERACT);
            this.playSound(SoundEvents.ARMADILLO_BRUSH);
            itemstack.hurtAndBreak(16, player, getSlotForHand(hand));
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }
        else
        {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public void handleEntityEvent(byte id)
    {
        switch (id)
        {
            case 4 -> startEatAnimation();
            case 5 -> this.startAttackAnimation();
            default -> super.handleEntityEvent(id);
        }
    }

    private void startEatAnimation()
    {
        this.eatAnimationState.start(this.tickCount);
    }

    private void startAttackAnimation()
    {
        switch (RandomUtil.getRandomPositiveIntInRange(3, this.random))
        {
            case 0 -> this.attack0AnimationState.start(this.tickCount);
            case 1 -> this.attack1AnimationState.start(this.tickCount);
            default -> this.attack2AnimationState.start(this.tickCount);
        }
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource)
    {
        return SoundEventRegister.FLOWERED_LIZARD_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEventRegister.FLOWERED_LIZARD_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEventRegister.FLOWERED_LIZARD_AMBIENT.get();
    }

    protected void playEatSound()
    {
        this.playSound(SoundEventRegister.FLOWERED_LIZARD_EAT.get(), 1.0F, 1.0F);
    }

    public static boolean checkFloweredLizardSpawnRules(EntityType<? extends FloweredLizardEntity> floweredLizard, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random)
    {
        return level.getBlockState(pos.below()).is(BlockTags.DIRT) && isBrightEnoughToSpawn(level, pos);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        if (compound.contains("EggLayTime"))
        {
            this.eggTime = compound.getInt("EggLayTime");
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putInt("EggLayTime", this.eggTime);
    }
}