package com.unpainperdu.premierpainmod.util.register.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

public class ModBlockProperties
{
    // reminder that modify a property without copying modify everywhere it is used
    //geology
    //  gypsum
    public static final Properties GYPSUM = Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_GRAY);
    public static final Properties GYPSUM_NO_OCLUSION = Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_LIGHT_GRAY).noOcclusion();
    //crafting block
    public static final Properties VILLAGER_WORKSHOP = Properties.ofFullCopy(Blocks.STONE).noOcclusion();
    public static final Properties COOKING_POT_BLOCK = Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion();
    //villager Singing stone event block
    public static final Properties LIBERTY_BLOCK = Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).strength(0.0F, 0.0F).noLootTable().noOcclusion();
    //vegetation
    //  misc
    public static final Properties FLOWERED_CACTUS_BLOCK = Properties.ofFullCopy(Blocks.CACTUS).noOcclusion();
    public static final Properties CACTUS_FLOWER_BLOCK = Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.XZ);
    public static final Properties SKY_SPEARS = Properties.of().mapColor(MapColor.PLANT).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ);
    public static final Properties DEAD_TALL_BUSH = Properties.of().mapColor(MapColor.WOOD).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ);
    public static final Properties OLD_WILD_WHEAT = Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ);
    //  cropLike
    public static final Properties JELLYSHROOM = Properties.of().mapColor(MapColor.COLOR_PURPLE).noCollission().noOcclusion().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).offsetType(BlockBehaviour.OffsetType.XZ);
    //  1 block flower
    public static final Properties BASIC_FLOWER = Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission();
    // pot
    public static final Properties BASIC_POT = BlockBehaviour.Properties.ofFullCopy(Blocks.POTTED_ALLIUM).noOcclusion();
    //  2 blocks tall flower
    public static final Properties BASIC_TALL_FLOWER = Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).ignitedByLava().pushReaction(PushReaction.DESTROY);
    //  dead bush like
    public static final Properties DEAD_RUINS_FLOWER = Properties.ofFullCopy(Blocks.DEAD_BUSH).noOcclusion().noCollission().offsetType(BlockBehaviour.OffsetType.XZ);
    //  tree
    public static final Properties MOUNTAIN_CURRANT_GENERIC = Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava();
    public static final Properties MORICHE_PALM_GENERIC = Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava();
    public static final Properties ACHIOTE_GENERIC = Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava();
    public static final Properties WEEPING_WILLOW_GENERIC = Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava();
    public static final Properties FALLING_WEEPING_WILLOW_LEAVES = Properties.ofFullCopy(Blocks.ALLIUM).noOcclusion().noCollission();

    public static Properties getPropertiesCopy(Properties properties){
        Properties finalProperties = Properties.of();
        finalProperties.destroyTime = properties.destroyTime;
        finalProperties.explosionResistance = properties.explosionResistance;
        finalProperties.hasCollision = properties.hasCollision;
        finalProperties.isRandomlyTicking = properties.isRandomlyTicking;
        finalProperties.lightEmission = properties.lightEmission;
        finalProperties.mapColor = properties.mapColor;
        finalProperties.soundType = properties.soundType;
        finalProperties.friction = properties.friction;
        finalProperties.speedFactor = properties.speedFactor;
        finalProperties.dynamicShape = properties.dynamicShape;
        finalProperties.canOcclude = properties.canOcclude;
        finalProperties.isAir = properties.isAir;
        finalProperties.ignitedByLava = properties.ignitedByLava;
        finalProperties.liquid = properties.liquid;
        finalProperties.forceSolidOff = properties.forceSolidOff;
        finalProperties.forceSolidOn = properties.forceSolidOn;
        finalProperties.pushReaction = properties.pushReaction;
        finalProperties.requiresCorrectToolForDrops = properties.requiresCorrectToolForDrops;
        finalProperties.offsetFunction = properties.offsetFunction;
        finalProperties.spawnTerrainParticles = properties.spawnTerrainParticles;
        finalProperties.requiredFeatures = properties.requiredFeatures;
        finalProperties.emissiveRendering = properties.emissiveRendering;
        finalProperties.instrument = properties.instrument;
        finalProperties.replaceable = properties.replaceable;
        finalProperties.jumpFactor = properties.jumpFactor;
        finalProperties.isRedstoneConductor = properties.isRedstoneConductor;
        finalProperties.isValidSpawn = properties.isValidSpawn;
        finalProperties.hasPostProcess = properties.hasPostProcess;
        finalProperties.isSuffocating = properties.isSuffocating;
        finalProperties.isViewBlocking = properties.isViewBlocking;
        finalProperties.drops = properties.drops;
        return finalProperties;
    }
}
