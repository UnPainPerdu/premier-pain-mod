package com.unpainperdu.premierpainmod.client.particle.beerParticle;

import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.util.RandomSource;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeerFoamParticle extends TextureSheetParticle
{
    private final SpriteSet spriteSet;

    protected BeerFoamParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet)
    {
        super(level, x, y, z );
        RandomSource randomSource = RandomSource.create();
        double speedMultiplier = 0.05;
        this.spriteSet = spriteSet;
        this.gravity = 0.0f;
        this.scale(RandomUtil.getRandomPositiveIntInRange(4, randomSource)*0.5f + 2.0f);
        this.hasPhysics = false;
        this.setSpriteFromAge(spriteSet);
        this.friction = 1.0F;
        setParticleSpeed(RandomUtil.getRandomIntInRange(1, randomSource) * speedMultiplier,0,RandomUtil.getRandomIntInRange(1, randomSource) * speedMultiplier);
    }

    @Override
    public void tick() {
        this.setSpriteFromAge(spriteSet);
        super.tick();
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
}
