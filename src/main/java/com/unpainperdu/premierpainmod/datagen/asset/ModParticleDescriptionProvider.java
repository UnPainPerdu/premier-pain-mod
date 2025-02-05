package com.unpainperdu.premierpainmod.datagen.asset;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider;

public class ModParticleDescriptionProvider extends ParticleDescriptionProvider
{
    /**
     * Creates an instance of the data provider.
     *
     * @param output     the expected root directory the data generator outputs to
     * @param fileHelper the helper used to validate a texture's existence
     */
    public ModParticleDescriptionProvider(PackOutput output, ExistingFileHelper fileHelper)
    {
        super(output, fileHelper);
    }

    @Override
    protected void addDescriptions()
    {
        createBeerFoamDescription(ParticleTypeRegister.BLOND_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.BROWN_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.GREEN_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.RED_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.DARK_RED_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.WHITE_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.BLACK_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.AMBER_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
        createBeerFoamDescription(ParticleTypeRegister.PURPLE_BEER_FOAM.get(), "beer_foam/blond/blond_beer_foam_");
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
