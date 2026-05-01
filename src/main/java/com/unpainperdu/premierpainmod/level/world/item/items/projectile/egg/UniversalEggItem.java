package com.unpainperdu.premierpainmod.level.world.item.items.projectile.egg;

import com.unpainperdu.premierpainmod.level.world.entity.projectile.egg.UniversalThrownEgg;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class UniversalEggItem extends Item implements ProjectileItem
{
    public UniversalEggItem(Item.Properties properties)
    {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand hand)
    {
        ItemStack itemstack = player.getItemInHand(hand);
        level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.EGG_THROW,
                SoundSource.PLAYERS,
                0.5F,
                0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!level.isClientSide)
        {
            UniversalThrownEgg thrownegg = getEntityProjectile(level, player);
            thrownegg.setItem(itemstack);
            thrownegg.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(thrownegg);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

    @Override
    public @NotNull Projectile asProjectile(@NotNull Level level, Position pos, @NotNull ItemStack stack, @NotNull Direction direction)
    {
        UniversalThrownEgg thrownegg = getEntityProjectile(level, pos.x(), pos.y(), pos.z());
        thrownegg.setItem(stack);
        return thrownegg;
    }

    protected abstract UniversalThrownEgg getEntityProjectile(Level level, Player player);

    protected abstract UniversalThrownEgg getEntityProjectile(Level level, double x, double y, double z);
}