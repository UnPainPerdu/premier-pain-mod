package com.unpainperdu.premierpainmod.level.world.block.eventBlock;

import com.unpainperdu.premierpainmod.util.datapackRegister.DamageSourcesRegister;
import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.util.datapackRegister.DamageTypesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
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
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public LibertyBlock(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.FALSE).setValue(FACING, Direction.NORTH));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add( WATERLOGGED, FACING);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void falling(FallingBlockEntity pFallingEntity)
    {
        pFallingEntity.setHurtsEntities(100.0F, 1000);
    }

    @Override
    public DamageSource getFallDamageSource(Entity pEntity)
    {
        DamageSource damageSource;
        int randomNumber = new Random().nextInt(3);
        switch (randomNumber)
        {
            case 1:
            {
                damageSource = DamageSourcesRegister.damageSourcesCreator(DamageTypesRegister.LIBERTY_DAMAGE1,pEntity.level(),pEntity);
                break;
            }
            case 2:
            {
                damageSource = DamageSourcesRegister.damageSourcesCreator(DamageTypesRegister.LIBERTY_DAMAGE2,pEntity.level(),pEntity);
                break;
            }
            default:
            {
                damageSource = DamageSourcesRegister.damageSourcesCreator(DamageTypesRegister.LIBERTY_DAMAGE3,pEntity.level(),pEntity);
                break;
            }
        }
        return damageSource;
    }

    @Override
    public void onLand(Level pLevel, BlockPos pPos, BlockState pState, BlockState pReplaceableState, FallingBlockEntity pFallingBlock)
    {
        if (!pFallingBlock.isSilent())
        {
            pLevel.playSound( null, pPos,SoundEvents.WITHER_BREAK_BLOCK, SoundSource.RECORDS, 16f, 1.0F);
        }
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }

    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockState blockstate = this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER)).setValue(FACING, pContext.getHorizontalDirection());
        return blockstate;
    }
}
