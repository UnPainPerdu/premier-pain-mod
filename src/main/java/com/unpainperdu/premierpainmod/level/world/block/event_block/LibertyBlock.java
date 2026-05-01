package com.unpainperdu.premierpainmod.level.world.block.event_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.datagen.data.level.world.ModDamageType;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.ModBlockStateProperties;
import com.unpainperdu.premierpainmod.util.tool_kit.DamageSourcesCreator;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class LibertyBlock extends FallingBlock implements SimpleWaterloggedBlock
{
    public static final MapCodec<LibertyBlock> CODEC = simpleCodec(LibertyBlock::new);
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = ModBlockStateProperties.DIRECTION;
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public LibertyBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(WATERLOGGED, FACING);
    }

    @Override
    protected @NotNull MapCodec<? extends FallingBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected void falling(FallingBlockEntity fallingEntity)
    {
        fallingEntity.setHurtsEntities(100.0F, 1000);
    }

    @Override
    public @NotNull DamageSource getFallDamageSource(@NotNull Entity entity)
    {
        DamageSource damageSource;
        int randomNumber = new Random().nextInt(3);
        switch (randomNumber)
        {
            case 1:
            {
                damageSource = DamageSourcesCreator.create(ModDamageType.LIBERTY_DAMAGE1, entity.level(), entity);
                break;
            }
            case 2:
            {
                damageSource = DamageSourcesCreator.create(ModDamageType.LIBERTY_DAMAGE2, entity.level(), entity);
                break;
            }
            default:
            {
                damageSource = DamageSourcesCreator.create(ModDamageType.LIBERTY_DAMAGE3, entity.level(), entity);
                break;
            }
        }
        return damageSource;
    }

    @Override
    public void onLand(@NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState state, @NotNull BlockState replaceableState, FallingBlockEntity fallingBlock)
    {
        if (!fallingBlock.isSilent())
        {
            level.playSound(null, pos, SoundEvents.WITHER_BREAK_BLOCK, SoundSource.RECORDS, 16f, 1.0F);
        }
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected BlockState updateShape(BlockState selfState, LevelReader level, ScheduledTickAccess scheduledTickAccess, BlockPos selfPos, Direction direction, BlockPos facingPos, BlockState facingState, RandomSource rand)
    {
        if (selfState.getValue(WATERLOGGED))
        {
            scheduledTickAccess.createTick(selfPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(selfState, level, scheduledTickAccess, selfPos, direction, facingPos, facingState, rand);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState().setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER).setValue(FACING, context.getHorizontalDirection());
    }
}