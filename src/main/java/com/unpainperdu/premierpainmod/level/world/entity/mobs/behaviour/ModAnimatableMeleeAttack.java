package com.unpainperdu.premierpainmod.level.world.entity.mobs.behaviour;

import net.minecraft.world.entity.Mob;
import net.tslat.smartbrainlib.api.core.behaviour.custom.attack.AnimatableMeleeAttack;

public class ModAnimatableMeleeAttack<E extends Mob> extends AnimatableMeleeAttack<E>
{
    public ModAnimatableMeleeAttack(int delayTicks)
    {
        super(delayTicks);
    }

    @Override
    protected void start(E entity)
    {
        super.start(entity);
        entity.level().broadcastEntityEvent(entity, (byte) 5);
    }
}
