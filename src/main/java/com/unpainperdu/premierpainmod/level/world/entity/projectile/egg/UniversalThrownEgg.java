package com.unpainperdu.premierpainmod.level.world.entity.projectile.egg;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.NotNull;

//Remember add rendering
public abstract class UniversalThrownEgg extends ThrowableItemProjectile
{
    private static final EntityDimensions ZERO_SIZED_DIMENSIONS = EntityDimensions.fixed(0.0F, 0.0F);

    public UniversalThrownEgg(EntityType<? extends UniversalThrownEgg> entityType, Level level)
    {
        super(entityType, level);
    }

    public UniversalThrownEgg(EntityType<? extends UniversalThrownEgg> entityType, LivingEntity shooter, Level level, ItemStack itemstack)
    {
        super(entityType, shooter, level, itemstack);
    }

    public UniversalThrownEgg(EntityType<? extends UniversalThrownEgg> entityType, double x, double y, double z, Level level, ItemStack itemstack)
    {
        super(entityType, x, y, z, level, itemstack);
    }

    @Override
    public void handleEntityEvent(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; i++)
            {
                this.level()
                        .addParticle(
                                new ItemParticleOption(ParticleTypes.ITEM, this.getItem()),
                                this.getX(),
                                this.getY(),
                                this.getZ(),
                                ((double) this.random.nextFloat() - 0.5) * 0.08,
                                ((double) this.random.nextFloat() - 0.5) * 0.08,
                                ((double) this.random.nextFloat() - 0.5) * 0.08
                        );
            }
        }
    }

    /**
     * Called when the arrow hits an entity
     */
    @Override
    protected void onHitEntity(@NotNull EntityHitResult result)
    {
        if (!this.level().isClientSide())
        {
            result.getEntity().hurtServer((ServerLevel) this.level(), this.damageSources().thrown(this, this.getOwner()), 0.0F);
        }
        super.onHitEntity(result);
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    @Override
    protected void onHit(@NotNull HitResult result)
    {
        super.onHit(result);
        if (!this.level().isClientSide)
        {
            if (this.random.nextInt(8) == 0)
            {
                int i = 1;
                if (this.random.nextInt(32) == 0)
                {
                    i = 4;
                }

                for (int j = 0; j < i; j++)
                {
                    AgeableMob ageableMob = getMobThatCanSpawn().create(this.level(), EntitySpawnReason.MOB_SUMMONED);
                    if (ageableMob != null)
                    {
                        ageableMob.setAge(-24000);
                        ageableMob.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
                        if (!ageableMob.fudgePositionAfterSizeChange(ZERO_SIZED_DIMENSIONS))
                        {
                            break;
                        }

                        this.level().addFreshEntity(ageableMob);
                    }
                }
            }

            this.level().broadcastEntityEvent(this, (byte) 3);
            this.discard();
        }
    }

    protected abstract EntityType<? extends AgeableMob> getMobThatCanSpawn();
}