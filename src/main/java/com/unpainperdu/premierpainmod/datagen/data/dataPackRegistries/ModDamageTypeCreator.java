package com.unpainperdu.premierpainmod.datagen.data.dataPackRegistries;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.datapackRegister.DamageTypesRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.world.damagesource.DamageEffects;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DeathMessageType;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDamageTypeCreator
{
    public static void onGatherData(GatherDataEvent event)
    {
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        event.getGenerator().addProvider(
                event.includeServer(),
                (DataProvider.Factory<DatapackBuiltinEntriesProvider>) output -> new DatapackBuiltinEntriesProvider(output, lookupProvider, new RegistrySetBuilder()
                        .add(Registries.DAMAGE_TYPE, bootstrap ->
                        {
                            bootstrap.register(DamageTypesRegister.LIBERTY_DAMAGE1, new DamageType(DamageTypesRegister.LIBERTY_DAMAGE1.location().toString(),
                                    DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                                    0.1f,
                                    DamageEffects.HURT,
                                    DeathMessageType.DEFAULT));
                            bootstrap.register(DamageTypesRegister.LIBERTY_DAMAGE2, new DamageType(DamageTypesRegister.LIBERTY_DAMAGE2.location().toString(),
                                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                                0.1f,
                                DamageEffects.HURT,
                                DeathMessageType.DEFAULT));
                            bootstrap.register(DamageTypesRegister.LIBERTY_DAMAGE3, new DamageType(DamageTypesRegister.LIBERTY_DAMAGE3.location().toString(),
                                DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER,
                                0.1f,
                                DamageEffects.HURT,
                                DeathMessageType.DEFAULT));
                        }),
        Set.of(PremierPainMod.MOD_ID))
        );
    }
}
