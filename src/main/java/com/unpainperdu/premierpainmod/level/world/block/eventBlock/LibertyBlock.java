package com.unpainperdu.premierpainmod.level.world.block.eventBlock;

import com.unpainperdu.premierpainmod.util.datapackRegister.DamageSourcesRegister;
import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.util.datapackRegister.DamageTypesRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class LibertyBlock extends FallingBlock
{
    public static final MapCodec<LibertyBlock> CODEC = simpleCodec(LibertyBlock::new);
    public static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 1, 16);

    public LibertyBlock(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec()
    {
        return CODEC;
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
}
