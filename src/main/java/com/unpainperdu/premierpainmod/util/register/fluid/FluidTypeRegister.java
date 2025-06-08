package com.unpainperdu.premierpainmod.util.register.fluid;

import com.unpainperdu.premierpainmod.level.world.fluid.fluid_type.BeerFluidType;
import net.neoforged.neoforge.fluids.FluidType;
import org.joml.Vector3f;

import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_TYPES;
import static com.unpainperdu.premierpainmod.util.register.fluid.AllInOneFluidRegister.FLUID_TYPE_REGISTRIES;

public class FluidTypeRegister
{
    public static final String BEER_TYPE = "beer_type";

    private FluidTypeRegister()
    {
    }

    public static void fluidTypeRegister(String name, String type, int tintColor, Vector3f fogColor)
    {
        switch (type)
        {
            case BEER_TYPE ->
            {
                beerRegister(name, tintColor, fogColor);
            }
        }
    }

    public static void beerRegister(String name, int tintColor, Vector3f fogColor)
    {
        FluidType.Properties baseBeerProperties = FluidType.Properties.create().canConvertToSource(false).fallDistanceModifier(0F).canHydrate(false);
        String fluidTypeName = name + "_type";
        FLUID_TYPES.put(fluidTypeName, FLUID_TYPE_REGISTRIES.register(fluidTypeName, () -> new BeerFluidType(baseBeerProperties.descriptionId("premierpainmod.block.description." + fluidTypeName), tintColor, fogColor)));
    }
}
