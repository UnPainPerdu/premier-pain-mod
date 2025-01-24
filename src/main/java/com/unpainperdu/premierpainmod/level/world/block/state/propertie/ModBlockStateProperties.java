package com.unpainperdu.premierpainmod.level.world.block.state.propertie;

import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.AdaptableSitShape;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.LiquidContent;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.VillagerCarpetColor;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockStateProperties
{
    public static final EnumProperty<AdaptableSitShape> ADAPTABLE_SIT_SHAPE = EnumProperty.create("adaptable_sit_shape", AdaptableSitShape.class);
    public static final EnumProperty<TwoBlockWidthPart> TWO_BLOCK_WIDTH_PART = EnumProperty.create("two_block_width_part", TwoBlockWidthPart.class);
    public static final EnumProperty<VillagerCarpetColor> VILLAGER_CARPET_COLOR = EnumProperty.create("villager_carpet_color", VillagerCarpetColor.class);
    public static final EnumProperty<LiquidContent> LIQUID_CONTENT = EnumProperty.create("liquid_content", LiquidContent.class);
    public static final IntegerProperty LEVEL_4 = IntegerProperty.create("level_4", 0, 4);
}
