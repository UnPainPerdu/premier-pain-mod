package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.datagen.data.tag.mod_tags.ModFluidTags;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import com.unpainperdu.premierpainmod.level.world.fluid.oil.OilFluid;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUIDS;


public class ModFluidTag extends FluidTagsProvider
{
    public ModFluidTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, ExistingFileHelper fileHelper)
    {
        super(output, provider, PremierPainMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        for (DeferredHolder<Fluid, Fluid> fluidHolder : FLUIDS.values())
        {
            Fluid fluid = fluidHolder.get();
            {
                if (fluid instanceof BeerFluid)
                {
                    this.tag(ModFluidTags.BEER).add(fluid);
                }
                if (fluid instanceof OilFluid)
                {
                    this.tag(ModFluidTags.OIL).add(fluid);
                }
            }
        }
    }
}
