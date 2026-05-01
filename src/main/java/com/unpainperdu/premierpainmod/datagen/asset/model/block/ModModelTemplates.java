package com.unpainperdu.premierpainmod.datagen.asset.model.block;

import net.minecraft.client.data.models.model.ModelTemplate;

import static net.minecraft.client.data.models.model.ModelTemplates.create;

public class ModModelTemplates
{
    //all_materials
    //  statue
    public static final ModelTemplate VILLAGER_STATUE_BOTTOM = create("all_materials_block/villager_statue/villager_statue_bottom", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_STATUE_TOP = create("all_materials_block/villager_statue/villager_statue_upper", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    //  pedestal
    public static final ModelTemplate VILLAGER_PEDESTAL = create("all_materials_block/villager_pedestal/villager_pedestal", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    //  brazier
    public static final ModelTemplate VILLAGER_BRAZIER_BOTTOM = create("all_materials_block/villager_brazier/villager_brazier_bottom", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_BRAZIER_UPPER_UNLIT = create("all_materials_block/villager_brazier/villager_brazier_upper_unlit");
    public static final ModelTemplate VILLAGER_BRAZIER_UPPER_LIT = create("all_materials_block/villager_brazier/villager_brazier_upper_lit");
    public static final ModelTemplate VILLAGER_BRAZIER_ITEM = create("all_materials_block/villager_brazier/villager_brazier_item", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    //  table    //TODO Carpeted not handle, simplify this nightmare with a simple BE
    public static final ModelTemplate VILLAGER_TABLE_SOLO = create("all_materials_block/villager_table/villager_table_solo/villager_table_solo", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_TABLE_DUO = create("all_materials_block/villager_table/villager_table_solo/villager_table_duo", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_TABLE_TRIO_ANGLE = create("all_materials_block/villager_table/villager_table_solo/villager_table_trio_angle", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_TABLE_TRIO_LINE = create("all_materials_block/villager_table/villager_table_solo/villager_table_trio_line", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_TABLE_QUATUOR = create("all_materials_block/villager_table/villager_table_solo/villager_table_quatuor", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
    public static final ModelTemplate VILLAGER_TABLE_PENTUOR = create("all_materials_block/villager_table/villager_table_solo/villager_table_pentuor", ModTextureSlot.BASE, ModTextureSlot.PARTICLE);
}