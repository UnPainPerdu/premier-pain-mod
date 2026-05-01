package com.unpainperdu.premierpainmod.level.world.entity.mobs;

import com.google.common.collect.Maps;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.RestoreHitbox;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.SetEntityLookTarget;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.wool_golem.Huging;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour.wool_golem.SetHugTarget;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.ai.MemoryModuleTypeRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Shulker;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.schedule.Activity;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;
import net.tslat.smartbrainlib.api.core.SmartBrainProvider;
import net.tslat.smartbrainlib.api.core.behaviour.FirstApplicableBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.OneRandomBehaviour;
import net.tslat.smartbrainlib.api.core.behaviour.custom.look.LookAtTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.misc.Idle;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.FollowTemptation;
import net.tslat.smartbrainlib.api.core.behaviour.custom.move.MoveToWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.path.SetRandomWalkTarget;
import net.tslat.smartbrainlib.api.core.behaviour.custom.target.SetRandomLookTarget;
import net.tslat.smartbrainlib.api.core.sensor.ExtendedSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.ItemTemptingSensor;
import net.tslat.smartbrainlib.api.core.sensor.vanilla.NearbyLivingEntitySensor;
import net.tslat.smartbrainlib.util.BrainUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WoolGolemEntity extends AbstractGolem implements SmartBrainOwner<WoolGolemEntity>
{
    public final AnimationState HUG = new AnimationState();
    public final AnimationState SIT = new AnimationState();
    public final AnimationState GETUP = new AnimationState();

    private static final EntityDataAccessor<Byte> DATA_WOOL_ID = SynchedEntityData.defineId(WoolGolemEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> DATA_IS_SAT = SynchedEntityData.defineId(WoolGolemEntity.class, EntityDataSerializers.BOOLEAN);
    private int satCD;
    private int hugCD;
    private int clientSideHugTick;

    private boolean clientSideOnlyAsRefreshPose = false;

    private static final EntityDimensions SITTING_DIMENSIONS = EntityDimensions.scalable(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get().getWidth(),
                    AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get().getHeight() - 0.33F)
            .withEyeHeight(AllInOneEntityRegister.WOOL_GOLEM_ENTITY.get().getDimensions().eyeHeight() - 0.33F);

    private static final Map<ItemLike, DyeColor> DYE_BY_ITEM = Util.make(Maps.newHashMap(), map ->
    {
        map.put(Blocks.WHITE_WOOL, DyeColor.WHITE);
        map.put(Blocks.ORANGE_WOOL, DyeColor.ORANGE);
        map.put(Blocks.MAGENTA_WOOL, DyeColor.MAGENTA);
        map.put(Blocks.LIGHT_BLUE_WOOL, DyeColor.LIGHT_BLUE);
        map.put(Blocks.YELLOW_WOOL, DyeColor.YELLOW);
        map.put(Blocks.LIME_WOOL, DyeColor.LIME);
        map.put(Blocks.PINK_WOOL, DyeColor.PINK);
        map.put(Blocks.GRAY_WOOL, DyeColor.GRAY);
        map.put(Blocks.LIGHT_GRAY_WOOL, DyeColor.LIGHT_GRAY);
        map.put(Blocks.CYAN_WOOL, DyeColor.CYAN);
        map.put(Blocks.PURPLE_WOOL, DyeColor.PURPLE);
        map.put(Blocks.BLUE_WOOL, DyeColor.BLUE);
        map.put(Blocks.BROWN_WOOL, DyeColor.BROWN);
        map.put(Blocks.GREEN_WOOL, DyeColor.GREEN);
        map.put(Blocks.RED_WOOL, DyeColor.RED);
        map.put(Blocks.BLACK_WOOL, DyeColor.BLACK);
    });

    private static final Map<Integer, DyeColor> DYE_BY_BYTE = Util.make(Maps.newHashMap(), map ->
    {
        map.put(0, DyeColor.WHITE);
        map.put(1, DyeColor.ORANGE);
        map.put(2, DyeColor.MAGENTA);
        map.put(3, DyeColor.LIGHT_BLUE);
        map.put(4, DyeColor.YELLOW);
        map.put(5, DyeColor.LIME);
        map.put(6, DyeColor.PINK);
        map.put(7, DyeColor.GRAY);
        map.put(8, DyeColor.LIGHT_GRAY);
        map.put(9, DyeColor.CYAN);
        map.put(10, DyeColor.PURPLE);
        map.put(11, DyeColor.BLUE);
        map.put(12, DyeColor.BROWN);
        map.put(13, DyeColor.GREEN);
        map.put(14, DyeColor.RED);
        map.put(15, DyeColor.BLACK);
    });

    private static final Map<DyeColor, Integer> COLOR_BY_DYE = Maps.newHashMap(Arrays.stream(DyeColor.values()).collect(Collectors.toMap(dyeColor -> dyeColor, WoolGolemEntity::createWoolColor)));

    public WoolGolemEntity(EntityType<? extends AbstractGolem> entityType, Level level)
    {
        super(entityType, level);
    }

    public boolean isFollowedItem(@NotNull ItemStack stack)
    {
        return stack.is(Items.EMERALD);
    }

    @Override
    public List<ExtendedSensor<WoolGolemEntity>> getSensors()
    {
        return ObjectArrayList.of(
                new NearbyLivingEntitySensor<WoolGolemEntity>()
                        .setPredicate((target, entity) ->
                                target instanceof Player ||
                                        target instanceof Villager ||
                                        (target instanceof AbstractGolem && !(target instanceof Shulker)) ||
                                        target instanceof Monster),
                new ItemTemptingSensor<WoolGolemEntity>().temptedWith(WoolGolemEntity::isFollowedItem)
                        .setRadius(10, 8)
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
                        new RestoreHitbox<>(), //TODO is this still used ? I remember fixed this
                        new SetHugTarget<>(),
                        new FollowTemptation<>().speedMod((g, p) -> 1.5F),
                        new SetEntityLookTarget<>(5),
                        new SetRandomLookTarget<>()),
                new OneRandomBehaviour<>(
                        new SetRandomWalkTarget<>(),
                        new Idle<>().runFor(entity -> entity.getRandom().nextInt(60, 100)))
        );
    }

    private BrainActivityGroup<WoolGolemEntity> getWorkTasks()
    {
        return new BrainActivityGroup<WoolGolemEntity>(Activity.WORK)
                .priority(10)
                .behaviours(
                        new Huging<>()
                ).requireAndWipeMemoriesOnUse(MemoryModuleTypeRegister.TARGET.get()).onlyStartWithMemoryStatus(MemoryModuleType.WALK_TARGET, MemoryStatus.VALUE_ABSENT);
    }

    @Override
    public Map<Activity, BrainActivityGroup<? extends WoolGolemEntity>> getAdditionalTasks()
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
    protected Brain.@NotNull Provider<?> brainProvider()
    {
        return new SmartBrainProvider<>(this);
    }

    @Override
    public void tick()
    {
        super.tick();
        if (!level().isClientSide)
        {
            if (this.satCD > 0)
            {
                this.satCD--;
            }
            if (this.hugCD > 0)
            {
                this.hugCD--;
            }
        }
        else
        {
            if (!this.clientSideOnlyAsRefreshPose && isSat())
            {
                startSittingAnimation();
            }
            if (clientSideHugTick > 0)
            {
                clientSideHugTick--;
            }
            else if (this.HUG.isStarted())
            {
                this.HUG.stop();
            }
        }
    }

    @Override
    protected void customServerAiStep(ServerLevel level)
    {
        if (!isSat())
        {
            tickBrain(this);
        }
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

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_IS_SAT, false);
        builder.define(DATA_WOOL_ID, (byte) 0);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound)
    {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsSat", this.isSat());
        compound.putByte("DataWool", this.getWoolDyeByte());
        compound.putInt("SatCD", this.getSatCD());
        compound.putInt("HugCD", this.getHugCD());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound)
    {
        super.readAdditionalSaveData(compound);
        this.setIsSat(compound.getBoolean("IsSat"));
        this.setWoolDyeByte(compound.getByte("DataWool"));
        this.setSatCD(compound.getInt("SatCD"));
        this.setHugCD(compound.getInt("HugCD"));
    }

    public DyeColor getWoolDye()
    {
        return DYE_BY_BYTE.get((int) getWoolDyeByte());
    }

    public static DyeColor getWoolDyeFromBlock(ItemLike wool)
    {
        return DYE_BY_ITEM.get(wool);
    }

    public static int getColor(DyeColor dyeColor)
    {
        return COLOR_BY_DYE.get(dyeColor);
    }

    public byte getWoolDyeByte()
    {
        return this.entityData.get(DATA_WOOL_ID);
    }

    public void setWoolDye(DyeColor dyeColor)
    {
        setWoolDyeByte((byte) DYE_BY_BYTE.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(dyeColor))
                .map(Map.Entry::getKey)
                .toList().getFirst().intValue());
    }

    public void setWoolDyeByte(byte b)
    {
        this.entityData.set(DATA_WOOL_ID, b);
    }

    public Boolean isSat()
    {
        return this.entityData.get(DATA_IS_SAT);
    }

    public void setIsSat(boolean isSat)
    {
        this.entityData.set(DATA_IS_SAT, isSat);
        refreshSatPose();
    }

    private void refreshSatPose()
    {
        if (isSat())
        {
            this.setPose(Pose.SITTING);
        }
        else
        {
            this.setPose(Pose.STANDING);
        }
    }

    public int getSatCD()
    {
        return satCD;
    }

    public void setSatCD(int satCD)
    {
        this.satCD = satCD;
    }

    public int getHugCD()
    {
        return this.hugCD;
    }

    public void setHugCD(int hugCD)
    {
        this.hugCD = hugCD;
    }

    public void switchIsSat()
    {
        if (isSat())
        {
            setIsSat(false);
            startGettingUpAnimation();
        }
        else
        {
            setIsSat(true);
            this.getNavigation().stop();
            BrainUtil.clearMemory(this, MemoryModuleType.WALK_TARGET);
            BrainUtil.clearMemory(this, MemoryModuleTypeRegister.TARGET.get());
            startSittingAnimation();
        }
        this.satCD = 60;
    }

    @Override
    protected @NotNull EntityDimensions getDefaultDimensions(@NotNull Pose pose)
    {
        return pose == Pose.SITTING ? SITTING_DIMENSIONS : super.getDefaultDimensions(pose);
    }

    @Override
    public void push(@NotNull Entity entity)
    {
        if (this.getPose() != Pose.SHOOTING)
        {
            super.push(entity);
        }
    }

    @Override
    protected void doPush(@NotNull Entity entity)
    {
        if (this.getPose() != Pose.SHOOTING)
        {
            super.doPush(entity);
        }
    }

    @Override
    protected @NotNull InteractionResult mobInteract(@NotNull Player player, @NotNull InteractionHand hand)
    {
        if (!level().isClientSide())
        {
            ItemStack itemstack = player.getItemInHand(hand);
            if (player.isCrouching() && itemstack.isEmpty() && this.satCD == 0)
            {
                switchIsSat();
                return InteractionResult.CONSUME;
            }
            else if (itemstack.getItem() instanceof DyeItem dye)
            {
                this.setWoolDye(dye.getDyeColor());
                itemstack.shrink(1);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        }
        return InteractionResult.PASS;
    }

    private void startSittingAnimation()
    {
        if (level().isClientSide)
        {
            this.SIT.start(this.tickCount);
            this.clientSideOnlyAsRefreshPose = true;
        }
        else
        {
            this.level().broadcastEntityEvent(this, (byte) 101);
        }
    }

    private void startGettingUpAnimation()
    {
        if (level().isClientSide)
        {
            this.SIT.stop();
            this.GETUP.start(this.tickCount);
        }
        else
        {
            this.level().broadcastEntityEvent(this, (byte) 102);
        }
    }

    private void startHugAnimation()
    {
        if (level().isClientSide)
        {
            this.HUG.start(this.tickCount);
            this.clientSideHugTick = 60;
        }
        else
        {
            this.level().broadcastEntityEvent(this, (byte) 100);
        }
    }

    @Override
    public void handleEntityEvent(byte id)
    {
        if (id == 100)//hug
        {
            startHugAnimation();
        }
        else if (id == 101)//sit
        {
            startSittingAnimation();
        }
        else if (id == 102)//get up
        {
            startGettingUpAnimation();
        }
        else
        {
            super.handleEntityEvent(id);
        }
    }

    private static int createWoolColor(DyeColor dyeColor)
    {
        if (dyeColor == DyeColor.WHITE)
        {
            return -1644826;
        }
        else
        {
            int i = dyeColor.getTextureDiffuseColor();
            return ARGB.color(
                    255,
                    Mth.floor((float) ARGB.red(i) * 0.75F),
                    Mth.floor((float) ARGB.green(i) * 0.75F),
                    Mth.floor((float) ARGB.blue(i) * 0.75F)
            );
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound()
    {
        return SoundEventRegister.WG_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound()
    {
        return SoundEventRegister.WG_DEATH.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource)
    {
        return SoundEventRegister.WG_HURT.get();
    }

    @Override
    protected void playStepSound(@NotNull BlockPos pos, @NotNull BlockState state)
    {
        this.playSound(SoundEventRegister.WG_WALK.get(), 1.0F, 1.0F);
    }
}