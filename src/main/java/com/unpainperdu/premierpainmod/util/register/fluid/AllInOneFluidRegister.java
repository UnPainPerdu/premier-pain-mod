package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.fluid.beer.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister.BEER_TYPE;

public class AllInOneFluidRegister
{
    private AllInOneFluidRegister()
    {
    }

    public static final DeferredRegister<Fluid> FLUID_REGISTRIES = DeferredRegister.create(Registries.FLUID, PremierPainMod.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPE_REGISTRIES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, PremierPainMod.MOD_ID);

    //fluid named x_fluid and flowing fluid flowing_x_fluid
    public static final Map<String, DeferredHolder<Fluid, Fluid>> FLUIDS = new HashMap<>();
    //Key always named x_type
    public static final Map<String, DeferredHolder<FluidType, FluidType>> FLUID_TYPES = new HashMap<>();
    //key is just x
    public static final Map<String, DeferredBlock<Block>> FLUID_BLOCKS = new HashMap<>();
    private static final boolean INITIATOR = createFluids();

    //don't forget blockstate json
    private static boolean createFluids()
    {
        registerNewFluid("pain_dieux", BEER_TYPE, PainDieuxFluid.Source::new, PainDieuxFluid.Flowing::new, 0xf1faa12d, new Vector3f(250f / 255f, 161f / 255f, 45f / 255f));
        registerNewFluid("la_chateau", BEER_TYPE, LaChateauFluid.Source::new, LaChateauFluid.Flowing::new, 0xf1935800, new Vector3f(147f / 255f, 88f / 255f, 0f));
        registerNewFluid("debier", BEER_TYPE, DeBierFluid.Source::new, DeBierFluid.Flowing::new, 0xf1369244, new Vector3f(54f / 255f, 146f / 255f, 68f / 255f));
        registerNewFluid("envahisseur_rouge", BEER_TYPE, EnvahisseurRougeFluid.Source::new, EnvahisseurRougeFluid.Flowing::new, 0xf1ce2222, new Vector3f(206f / 255f, 34f / 255f, 34f / 255f));
        registerNewFluid("raspbuisson", BEER_TYPE, RaspBuissonFluid.Source::new, RaspBuissonFluid.Flowing::new, 0xf1520c0c, new Vector3f(82f / 255f, 12f / 255f, 12f / 255f));
        registerNewFluid("la_blanche_citadine", BEER_TYPE, LaBlancheCitadineFluid.Source::new, LaBlancheCitadineFluid.Flowing::new, 0xf1e9de95, new Vector3f(233f / 255f, 222f / 255f, 149f / 255f));
        registerNewFluid("crane_noir", BEER_TYPE, CraneNoirFluid.Source::new, CraneNoirFluid.Flowing::new, 0xf12c1a04, new Vector3f(44f / 255f, 26f / 255f, 04f / 255f));
        registerNewFluid("tak", BEER_TYPE, TakFluid.Source::new, TakFluid.Flowing::new, 0xf1fa7700, new Vector3f(250f / 255f, 119f / 255f, 0));
        registerNewFluid("disender", BEER_TYPE, DisEnderFluid.Source::new, DisEnderFluid.Flowing::new, 0xf1ac08cc, new Vector3f(172f / 255f, 8f / 255f, 204f / 255f));
        return true;
    }

    private static <T extends Fluid> void registerNewFluid(String name, String type, Supplier<Fluid> source, Supplier<Fluid> flowing, int tintColor, Vector3f fogColor)
    {
        FluidRegister.registerFluid(name, source, flowing);
        FluidTypeRegister.fluidTypeRegister(name, type, tintColor, fogColor);
        BlockFluidRegister.registerFluidBlock(name, type);
    }

    public static void register(IEventBus bus)
    {
        FLUID_REGISTRIES.register(bus);
        FLUID_TYPE_REGISTRIES.register(bus);
    }
}
