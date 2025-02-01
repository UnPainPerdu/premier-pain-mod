package com.unpainperdu.premierpainmod.datagen.asset;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
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
        spriteSet(ParticleTypeRegister.BLOND_BEER_FOAM.get(),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "beer_foam/blond/blond_beer_foam_0"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "beer_foam/blond/blond_beer_foam_1"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "beer_foam/blond/blond_beer_foam_2"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "beer_foam/blond/blond_beer_foam_3"),
                ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "beer_foam/blond/blond_beer_foam_4")
        );
    }
}
