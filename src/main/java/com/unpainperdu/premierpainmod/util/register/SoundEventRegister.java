package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundEventRegister
{
    private SoundEventRegister()
    {
    }

    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PremierPainMod.MOD_ID);
    /*register part
        --> ModSoundProvider needed, need tool conversion for mp3 to ogg
    */
    //item
    //villager_singing_stone
    public static final DeferredHolder<SoundEvent, SoundEvent> LIBERTY_SOUND = register("item.villager_singing_stone.liberty_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> DIGGY_SOUND = register("item.villager_singing_stone.diggy_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> MADNESS_SOUND = register("item.villager_singing_stone.madness_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> PREMIER_PAIN_SOUND = register("item.villager_singing_stone.premier_pain_sound");
    //entity
    //mountain_currant_golem
    public static final DeferredHolder<SoundEvent, SoundEvent> MCG_WALK = register("entity.mountain_currant_golem.walk");
    public static final DeferredHolder<SoundEvent, SoundEvent> MCG_HURT = register("entity.mountain_currant_golem.hurt");
    public static final DeferredHolder<SoundEvent, SoundEvent> MCG_DEATH = register("entity.mountain_currant_golem.death");
    public static final DeferredHolder<SoundEvent, SoundEvent> MCG_BONE_MEALING = register("entity.mountain_currant_golem.bone_mealing");
    public static final DeferredHolder<SoundEvent, SoundEvent> MCG_AMBIENT = register("entity.mountain_currant_golem.ambient");

    //Method register
    private static DeferredHolder<SoundEvent, SoundEvent> register(String soundName)
    {
        return SOUND_EVENT.register(soundName, () -> SoundEvent.createVariableRangeEvent(getSound(soundName)));
    }

    private static ResourceLocation getSound(String path)
    {
        return ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, path);
    }

    public static void register(IEventBus modEventBus)
    {
        SOUND_EVENT.register(modEventBus);
    }
}
