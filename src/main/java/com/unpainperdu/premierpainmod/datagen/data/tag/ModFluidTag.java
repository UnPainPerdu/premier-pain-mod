package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.level.world.fluid.beer.BeerFluid;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.concurrent.CompletableFuture;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUIDS;


public class ModFluidTag extends FluidTagsProvider
{
    public ModFluidTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider)
    {
        super(output, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        for (DeferredHolder<Fluid, Fluid> fluidHolder : FLUIDS.values())
        {
            Fluid fluid = fluidHolder.get();
            {
                if (fluid instanceof BeerFluid)
                {
                    this.tag(FluidTags.WATER).add(fluid);
                    this.tag(Tags.Fluids.WATER).add(fluid);
                }
            }
        }
    }
}
