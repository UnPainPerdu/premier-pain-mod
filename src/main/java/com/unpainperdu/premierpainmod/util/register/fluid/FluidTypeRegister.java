package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.fluid.fluid_type.BeerFluidType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class FluidTypeRegister
{
    private FluidTypeRegister()
    {
    }

    public static final DeferredRegister<FluidType> FLUID_TYPE = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, PremierPainMod.MOD_ID);

    //beer
    public static final DeferredHolder<FluidType, BeerFluidType> PAIN_DIEUX_TYPE = beerRegister("pain_dieux_type", LiquidContent.BLOND_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> LA_CHATEAU_TYPE = beerRegister("la_chateau_type", LiquidContent.BROWN_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> DEBIER_TYPE = beerRegister("debier_type", LiquidContent.GREEN_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> ENVAHISSEUR_ROUGE_TYPE = beerRegister("envahisseur_rouge_type", LiquidContent.RED_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> RASPBUISSON_TYPE = beerRegister("raspbuisson_type", LiquidContent.DARK_RED_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> LA_BLANCHE_CITADINE_TYPE = beerRegister("la_blanche_citadine_type", LiquidContent.WHITE_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> CRANE_NOIR_TYPE = beerRegister("crane_noir_type", LiquidContent.BLACK_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> TAK_TYPE = beerRegister("tak_type", LiquidContent.AMBER_BEER);
    public static final DeferredHolder<FluidType, BeerFluidType> DISENDER_TYPE = beerRegister("disender_type", LiquidContent.PURPLE_BEER);

    public static DeferredHolder<FluidType, BeerFluidType> beerRegister(String name, LiquidContent content)
    {
        FluidType.Properties baseBeerProperties = FluidType.Properties.create().canConvertToSource(false).fallDistanceModifier(0F).canHydrate(false);

        return FLUID_TYPE.register(name, () -> new BeerFluidType(baseBeerProperties.descriptionId("premierpainmod.block.description." + name), content));
    }

    public static void register(IEventBus bus)
    {
        FLUID_TYPE.register(bus);
    }
}
