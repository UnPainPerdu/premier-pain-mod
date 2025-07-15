package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.schedule.Activity;
import net.tslat.smartbrainlib.api.SmartBrainOwner;
import net.tslat.smartbrainlib.api.core.BrainActivityGroup;

public class BrainActivityCreator
{
    private BrainActivityCreator()
    {
    }

    @SafeVarargs
    public static  <T extends LivingEntity & SmartBrainOwner<T>>BrainActivityGroup<T> workTasks(Behavior<T>... behaviours)
    {
        return new BrainActivityGroup<T>(Activity.CORE).priority(10).behaviours(behaviours);
    }
}
