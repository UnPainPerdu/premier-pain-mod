package com.unpainperdu.premierpainmod.util.register;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleTypeRegister
{
    //the rest of stuff in client part
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPE = DeferredRegister.create(Registries.PARTICLE_TYPE, PremierPainMod.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOND_BEER_FOAM = PARTICLE_TYPE.register("blond_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BROWN_BEER_FOAM = PARTICLE_TYPE.register("brown_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GREEN_BEER_FOAM = PARTICLE_TYPE.register("green_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RED_BEER_FOAM = PARTICLE_TYPE.register("red_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DARK_RED_BEER_FOAM = PARTICLE_TYPE.register("dark_red_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WHITE_BEER_FOAM = PARTICLE_TYPE.register("white_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLACK_BEER_FOAM = PARTICLE_TYPE.register("black_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> AMBER_BEER_FOAM = PARTICLE_TYPE.register("amber_beer_foam", () -> new SimpleParticleType(false));
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PURPLE_BEER_FOAM = PARTICLE_TYPE.register("purple_beer_foam", () -> new SimpleParticleType(false));

    public static void register(IEventBus bus)
    {
        PARTICLE_TYPE.register(bus);
    }
}