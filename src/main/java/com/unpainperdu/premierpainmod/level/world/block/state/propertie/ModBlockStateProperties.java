package com.unpainperdu.premierpainmod.level.world.block.state.propertie;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class ModBlockStateProperties
{
    public static final EnumProperty<AdaptableSitShape> ADAPTABLE_SIT_SHAPE = EnumProperty.create("adaptable_sit_shape", AdaptableSitShape.class);
    public static final EnumProperty<TwoBlockWidthPart> TWO_BLOCK_WIDTH_PART = EnumProperty.create("two_block_width_part", TwoBlockWidthPart.class);
}
