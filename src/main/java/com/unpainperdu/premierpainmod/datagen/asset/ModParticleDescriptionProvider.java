package com.unpainperdu.premierpainmod.datagen.asset;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider
{
    /**
     * Creates an instance of the data provider.
     *
     * @param output the expected root directory the data generator outputs to
     */
    public ModParticleDescriptionProvider(PackOutput output)
    {
        super(output);
    }

    @Override
    protected void addDescriptions()
    {
        createBeerFoamDescription(ParticleTypeRegister.BLOND_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.BROWN_BEER_FOAM.get(), "beer_foam/brown/brown_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.GREEN_BEER_FOAM.get(), "beer_foam/green/green_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.RED_BEER_FOAM.get(), "beer_foam/red/red_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.DARK_RED_BEER_FOAM.get(), "beer_foam/dark_red/dark_red_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.WHITE_BEER_FOAM.get(), "beer_foam/white/white_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.BLACK_BEER_FOAM.get(), "beer_foam/black/black_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.AMBER_BEER_FOAM.get(), "beer_foam/amber/amber_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.PURPLE_BEER_FOAM.get(), "beer_foam/purple/purple_beer_foam_");
    }

    /**
     * @param texture x/x/x_0, x/x/x_1 ... become just x/x/x_
     **/
    private void createBeerFoamDescription(ParticleType<?> particleType, String texture)
    {
        spriteSet(particleType,
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, texture + "0"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, texture + "1"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, texture + "2"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, texture + "3"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, texture + "4"));
    }
}