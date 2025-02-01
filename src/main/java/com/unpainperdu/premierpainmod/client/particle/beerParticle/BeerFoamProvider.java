package com.unpainperdu.premierpainmod.client.particle.beerParticle;

import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

public abstract class BeerFoamProvider implements ParticleProvider<SimpleParticleType>
{
    protected final SpriteSet spriteSet;

    public BeerFoamProvider(SpriteSet spriteSet)
    {
        this.spriteSet = spriteSet;
    }
}
