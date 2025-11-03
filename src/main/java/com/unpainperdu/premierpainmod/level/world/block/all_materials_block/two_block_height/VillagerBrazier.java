package com.unpainperdu.premierpainmod.level.world.block.all_materials_block.two_block_height;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockHeightBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static net.minecraft.world.level.material.Fluids.WATER;

public class VillagerBrazier extends AbstractTwoBlockHeightBlock
{
    public static final MapCodec<VillagerBrazier> CODEC = simpleCodec(VillagerBrazier::new);
    public static final BooleanProperty LIT = BlockStateProperties.LIT;


    public VillagerBrazier(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, FALSE)
                .setValue(LIT, TRUE));
    }


    @Override
    public @NotNull MapCodec<VillagerBrazier> codec()
    {
        return CODEC;
    }

    //forme hit-box, début-fin x y z
    private static final VoxelShape UPPER_SHAPE = Block.box(2, 0, 2, 14, 4, 14);
    private static final VoxelShape BELOW_SHAPE = Block.box(2, 0, 2, 14, 16, 14);


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        Level level = context.getLevel();
        FluidState fluidstateDown = level.getFluidState(blockpos);
        boolean flag = fluidstateDown.getType() == WATER;
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(context))
        {
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)
                    .setValue(WATERLOGGED, flag)
                    .setValue(LIT, FALSE)
                    .setValue(FACING, context.getHorizontalDirection());
        }
        else
        {
            return null;
        }
    }

    // Pose le bloc du dessus
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, @NotNull ItemStack stack)
    {
        FluidState fluidstateUp = level.getFluidState(pos.above());
        boolean flag = fluidstateUp.getType() == WATER;
        level.setBlock(pos.above(), state.setValue(HALF, DoubleBlockHalf.UPPER)
                .setValue(WATERLOGGED, flag)
                .setValue(LIT, !flag), 3);
    }

    //Applique la hit-box
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter blockGetter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER)
        {
            return UPPER_SHAPE;
        }
        else
        {
            return BELOW_SHAPE;
        }
    }

    @Override
    protected void onProjectileHit(Level level, @NotNull BlockState state, BlockHitResult pHit, @NotNull Projectile projectile)
    {
        BlockPos blockpos = pHit.getBlockPos();
        if (!level.isClientSide
                && projectile.isOnFire()
                && projectile.mayInteract(level, blockpos)
                && !state.getValue(LIT)
                && !state.getValue(WATERLOGGED)
                && !(state.getValue(HALF) == DoubleBlockHalf.LOWER)
        )
        {
            level.setBlock(blockpos, state.setValue(BlockStateProperties.LIT, Boolean.TRUE), 11);
        }
    }

    @Override
    public void animateTick(BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull RandomSource random)
    {
        if (state.getValue(LIT))
        {
            if (random.nextInt(10) == 0)
            {
                level.playLocalSound(
                        (double) pos.getX() + 0.5,
                        (double) pos.getY() + 0.5,
                        (double) pos.getZ() + 0.5,
                        SoundEvents.CAMPFIRE_CRACKLE,
                        SoundSource.BLOCKS,
                        0.5F + random.nextFloat(),
                        random.nextFloat() * 0.7F + 0.6F,
                        false
                );
            }

            if (random.nextInt(5) == 0)
            {
                for (int i = 0; i < random.nextInt(1) + 1; i++)
                {
                    level.addParticle(
                            ParticleTypes.LAVA,
                            (double) pos.getX() + 0.5,
                            (double) pos.getY() + 0.5,
                            (double) pos.getZ() + 0.5,
                            random.nextFloat() / 2.0F,
                            5.0E-5,
                            random.nextFloat() / 2.0F
                    );
                }
            }
        }
    }

    @Override
    public boolean placeLiquid(@NotNull LevelAccessor level, @NotNull BlockPos pos, BlockState state, @NotNull FluidState fluidState)
    {
        if (!state.getValue(BlockStateProperties.WATERLOGGED) && fluidState.getType() == WATER)
        {
            boolean flag = state.getValue(LIT);
            if (flag)
            {
                if (!level.isClientSide() && state.getValue(HALF) == DoubleBlockHalf.UPPER)
                {
                    level.playSound(null, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            }

            level.setBlock(pos, state.setValue(WATERLOGGED, TRUE).setValue(LIT, FALSE), 3);
            level.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(level));
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(HALF, LIT, WATERLOGGED, FACING);
    }

    @Override
    public void stepOn(@NotNull Level level, @NotNull BlockPos pos, BlockState state, @NotNull Entity entity)
    {
        if (state.getValue(LIT))
        {
            if (!entity.isSteppingCarefully() && entity instanceof LivingEntity)
            {
                entity.hurt(level.damageSources().hotFloor(), 1.0F);
            }
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    protected boolean isPathfindable(@NotNull BlockState state, @NotNull PathComputationType pathComputationType)
    {
        return false;
    }
}
