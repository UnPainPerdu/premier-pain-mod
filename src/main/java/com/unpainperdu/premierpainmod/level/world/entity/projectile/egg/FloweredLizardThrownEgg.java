package com.unpainperdu.premierpainmod.level.world.entity.projectile.egg;

import com.unpainperdu.premierpainmod.util.register.Item.ItemRegister;
import com.unpainperdu.premierpainmod.util.register.entity.AllInOneEntityRegister;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class FloweredLizardThrownEgg extends UniversalThrownEgg
{
    public FloweredLizardThrownEgg(EntityType<? extends UniversalThrownEgg> entityType, Level level)
    {
        super(entityType, level);
    }

    public FloweredLizardThrownEgg(Level level, LivingEntity shooter)
    {
        super(AllInOneEntityRegister.FLOWERED_LIZARD_THROWN_EGG.get(), shooter, level);
    }

    public FloweredLizardThrownEgg(Level level, double x, double y, double z)
    {
        super(AllInOneEntityRegister.FLOWERED_LIZARD_THROWN_EGG.get(), x, y, z, level);
    }

    @Override
    protected EntityType<? extends AgeableMob> getMobThatCanSpawn()
    {
        return AllInOneEntityRegister.FLOWERED_LIZARD_ENTITY.get();
    }

    @Override
    protected @NotNull Item getDefaultItem()
    {
        return ItemRegister.FLOWERED_LIZARD_EGG.get();
    }
}
