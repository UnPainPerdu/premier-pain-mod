package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.util.register.fluid.FluidRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.tags.FluidTags;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModFluidTag extends FluidTagsProvider
{
    public ModFluidTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider)
    {
        super(output, provider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider)
    {
        this.tag(FluidTags.WATER)
                .add(FluidRegister.PAIN_DIEUX_FLUID.get())
                .add(FluidRegister.FLOWING_PAIN_DIEUX_FLUID.get())
                .add(FluidRegister.LA_CHATEAU_FLUID.get())
                .add(FluidRegister.FLOWING_LA_CHATEAU_FLUID.get())
                .add(FluidRegister.DEBIER_FLUID.get())
                .add(FluidRegister.FLOWING_DEBIER_FLUID.get())
                .add(FluidRegister.ENVAHISSEUR_ROUGE_FLUID.get())
                .add(FluidRegister.FLOWING_ENVAHISSEUR_ROUGE_FLUID.get())
                .add(FluidRegister.RASPBUISSON_FLUID.get())
                .add(FluidRegister.FLOWING_RASPBUISSON_FLUID.get())
                .add(FluidRegister.LA_BLANCHE_CITADINE_FLUID.get())
                .add(FluidRegister.FLOWING_LA_BLANCHE_CITADINE_FLUID.get())
                .add(FluidRegister.CRANE_NOIR_FLUID.get())
                .add(FluidRegister.FLOWING_CRANE_NOIR_FLUID.get())
                .add(FluidRegister.TAK_FLUID.get())
                .add(FluidRegister.FLOWING_TAK_FLUID.get())
                .add(FluidRegister.DISENDER_FLUID.get())
                .add(FluidRegister.FLOWING_DISENDER_FLUID.get())
        ;

        this.tag(Tags.Fluids.WATER)
                .add(FluidRegister.PAIN_DIEUX_FLUID.get())
                .add(FluidRegister.FLOWING_PAIN_DIEUX_FLUID.get())
                .add(FluidRegister.LA_CHATEAU_FLUID.get())
                .add(FluidRegister.FLOWING_LA_CHATEAU_FLUID.get())
                .add(FluidRegister.DEBIER_FLUID.get())
                .add(FluidRegister.FLOWING_DEBIER_FLUID.get())
                .add(FluidRegister.ENVAHISSEUR_ROUGE_FLUID.get())
                .add(FluidRegister.FLOWING_ENVAHISSEUR_ROUGE_FLUID.get())
                .add(FluidRegister.RASPBUISSON_FLUID.get())
                .add(FluidRegister.FLOWING_RASPBUISSON_FLUID.get())
                .add(FluidRegister.LA_BLANCHE_CITADINE_FLUID.get())
                .add(FluidRegister.FLOWING_LA_BLANCHE_CITADINE_FLUID.get())
                .add(FluidRegister.CRANE_NOIR_FLUID.get())
                .add(FluidRegister.FLOWING_CRANE_NOIR_FLUID.get())
                .add(FluidRegister.TAK_FLUID.get())
                .add(FluidRegister.FLOWING_TAK_FLUID.get())
                .add(FluidRegister.DISENDER_FLUID.get())
                .add(FluidRegister.FLOWING_DISENDER_FLUID.get())
        ;
    }
}
