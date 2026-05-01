package com.unpainperdu.premierpainmod.level.world.block.geology;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class CrystalSlabBlock extends SlabBlock
{
    public CrystalSlabBlock(Properties properties)
    {
        super(properties);
    }

    @Override
    protected void onProjectileHit(Level level, @NotNull BlockState state, @NotNull BlockHitResult hitResult, @NotNull Projectile projectile) {
        if (!level.isClientSide) {
            BlockPos blockpos = hitResult.getBlockPos();
            level.playSound(null, blockpos, SoundEvents.AMETHYST_BLOCK_HIT, SoundSource.BLOCKS, 1.0F, 0.5F + level.random.nextFloat() * 1.2F);
            level.playSound(null, blockpos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.0F, 0.5F + level.random.nextFloat() * 1.2F);
        }
    }
}