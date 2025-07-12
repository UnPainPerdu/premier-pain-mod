package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.level.world.fluid.fluid_type.BeerFluidType;
import com.unpainperdu.premierpainmod.level.world.fluid.fluid_type.OilFluidType;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_TYPES;
import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_TYPE_REGISTRIES;

public class FluidTypeRegister
{
    public static final String BEER_TYPE = "beer_type";
    public static final String OIL_TYPE = "oil_type";

    private FluidTypeRegister()
    {
    }

    public static void fluidTypeRegister(String name, String type, int tintColor, Vector3f fogColor)
    {
        String fluidTypeName = name + "_type";
        switch (type)
        {
            case BEER_TYPE -> beerRegister(fluidTypeName, tintColor, fogColor);
            case OIL_TYPE -> oilRegister(fluidTypeName, tintColor, fogColor);
        }
    }

    public static void beerRegister(String name, int tintColor, Vector3f fogColor)
    {
        FluidType.Properties baseBeerProperties = FluidType.Properties.create().canConvertToSource(false).fallDistanceModifier(0F).canHydrate(false);
        FLUID_TYPES.put(name, FLUID_TYPE_REGISTRIES.register(name, () -> new BeerFluidType(baseBeerProperties.descriptionId("premierpainmod.block.description." + name), tintColor, fogColor)));
    }

    public static void oilRegister(String name, int tintColor, Vector3f fogColor)
    {
        FluidType.Properties properties = FluidType.Properties.create().canConvertToSource(false).fallDistanceModifier(0F).canHydrate(false);
        FLUID_TYPES.put(name, FLUID_TYPE_REGISTRIES.register(name, () -> new OilFluidType(properties.descriptionId("premierpainmod.block.description." + name), tintColor, fogColor)));
    }
}
