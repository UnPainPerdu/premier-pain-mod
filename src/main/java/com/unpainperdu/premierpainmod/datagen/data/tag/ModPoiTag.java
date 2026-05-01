package com.unpainperdu.premierpainmod.datagen.data.tag;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.entity.villager.VillagerPointOfInterestRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.tags.PoiTypeTags;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ModPoiTag extends PoiTypeTagsProvider
{
    public ModPoiTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider)
    {
        super(output, provider, PremierPainMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .add(Objects.requireNonNull(VillagerPointOfInterestRegister.BREWER.getKey()));
    }
}
