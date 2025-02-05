package com.unpainperdu.premierpainmod.client.particle.beer_particle.dark_red;

import com.unpainperdu.premierpainmod.client.particle.beer_particle.BeerFoamProvider;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class DarkRedBeerFoamProvider extends BeerFoamProvider
{
    public DarkRedBeerFoamProvider(SpriteSet spriteSet)
    {
        super(spriteSet);
    }

    @Nullable
    @Override
    public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
    {
        return new DarkRedBeerFoamParticle(level, x , y, z, this.spriteSet);
    }
}
