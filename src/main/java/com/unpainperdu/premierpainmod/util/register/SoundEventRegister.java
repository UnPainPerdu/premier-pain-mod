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
    public static final DeferredRegister<SoundEvent> SOUND_EVENT = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, PremierPainMod.MOD_ID);
    /*register part
        --> ModSoundProvider needed, need tool conversion for mp3 to ogg
    */
    public static final DeferredHolder<SoundEvent, SoundEvent> LIBERTY_SOUND = register("item/villager_singing_stone/liberty_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> DIGGY_SOUND = register("item/villager_singing_stone/diggy_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> MADNESS_SOUND = register("item/villager_singing_stone/madness_sound");
    public static final DeferredHolder<SoundEvent, SoundEvent> PREMIER_PAIN_SOUND = register("item/villager_singing_stone/premier_pain_sound");

    //Method register
    private static DeferredHolder<SoundEvent, SoundEvent> register(String soundPath)
    {
        return SOUND_EVENT.register(soundPath, () -> SoundEvent.createVariableRangeEvent(getSound(soundPath)));
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
