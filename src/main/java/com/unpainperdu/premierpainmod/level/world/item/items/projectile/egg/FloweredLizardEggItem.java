package com.unpainperdu.premierpainmod.level.world.item.items.projectile.egg;

import com.unpainperdu.premierpainmod.level.world.entity.projectile.egg.FloweredLizardThrownEgg;
import com.unpainperdu.premierpainmod.level.world.entity.projectile.egg.UniversalThrownEgg;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FloweredLizardEggItem extends UniversalEggItem
{
    public FloweredLizardEggItem(Properties properties)
    {
        super(properties);
    }

    @Override
    protected UniversalThrownEgg getEntityProjectile(Level level, Player player)
    {
        return new FloweredLizardThrownEgg(level, player, new ItemStack(this));
    }

    @Override
    protected UniversalThrownEgg getEntityProjectile(Level level, double x, double y, double z)
    {
        return new FloweredLizardThrownEgg(level, x, y ,z, new ItemStack(this));
    }
}
