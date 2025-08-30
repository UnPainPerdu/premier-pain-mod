package com.unpainperdu.premierpainmod.level.world.entity.seat;

import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class ToiletSeatEntity extends SeatEntity
{
    private int timeWithPassengerInTick;

    public ToiletSeatEntity(EntityType<SeatEntity> type, Level level)
    {
        super(type, level);
    }

    public ToiletSeatEntity(Level level, BlockPos pos)
    {
        super(AllInOneEntityRegister.TOILET_SEAT_ENTITY.get(), level);
        BlockState state = level.getBlockState(pos);
        double xPos = pos.getX() + 0.5D;
        double yPos = pos.getY() + 0.5D;
        double zPos = pos.getZ() + 0.5D;
        if (state.hasProperty(HorizontalDirectionalBlock.FACING))
        {
            switch (state.getValue(HorizontalDirectionalBlock.FACING))
            {
                case NORTH -> zPos += 0.25D;
                case WEST -> xPos += 0.25D;
                case SOUTH -> zPos -= 0.25D;
                default -> xPos -= 0.25D;
            }
        }
        setPos(xPos, yPos, zPos);
        noPhysics = true;
    }

    @Override
    public void tick()
    {
        super.tick();
        if (!level().isClientSide())
        {
            if (!this.getPassengers().isEmpty())
            {
                this.timeWithPassengerInTick += 1;
            }
            else
            {
                this.timeWithPassengerInTick = 0;
                return;
            }

            if (timeWithPassengerInTick / 20 > RandomUtil.getRandomPositiveIntInRange(15, this.random) + 10)
            {
                this.fart();
                this.timeWithPassengerInTick = 0;
            }
        }
    }

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag tag)
    {
        this.timeWithPassengerInTick = tag.getInt("time_with_passenger_in_tick");
    }

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag tag)
    {
        tag.putInt("time_with_passenger_in_tick", this.timeWithPassengerInTick);
    }

    private void fart()
    {
        int randomChance = RandomUtil.getRandomPositiveIntInRange(100, this.random);

        if (randomChance < 95)
        {
            playSound(SoundEventRegister.TOILET_SEAT_FART.get());
        }
        else
        {
            playSound(SoundEventRegister.TOILET_SEAT_NOT_ONLY_FART.get());
            Entity passenger = this.getFirstPassenger();
            if (passenger instanceof LivingEntity livingPassenger)
            {
                int randomTimeEffect = (RandomUtil.getRandomPositiveIntInRange(30, this.random) + 30) * 20;
                livingPassenger.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, randomTimeEffect, 1));
                livingPassenger.addEffect(new MobEffectInstance(MobEffects.JUMP, randomTimeEffect, 1));
                if (livingPassenger instanceof Player player)
                {
                    player.displayClientMessage(Component.translatable("entity.toilet_seat.not_only_fart").withStyle(ChatFormatting.WHITE), true);
                }
            }
        }
    }
}
