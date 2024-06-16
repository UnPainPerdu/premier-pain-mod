package com.unpainperdu.premierpainmod.level.world.block.twoBlockHeight;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
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
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static net.minecraft.world.level.material.Fluids.WATER;

public class VillagerBrazier extends AbstactTwoBlockHeightBlock
{
    public static final MapCodec<VillagerBrazier> CODEC = RecordCodecBuilder.mapCodec(
            p_308808_ -> p_308808_.group(
                            Codec.BOOL.fieldOf("spawn_particles").forGetter(p_304361_ -> p_304361_.spawnParticles),
                            Codec.intRange(0, 1000).fieldOf("fire_damage").forGetter(p_304360_ -> p_304360_.fireDamage),
                            propertiesCodec()
                    )
                    .apply(p_308808_, VillagerBrazier::new));

    private final boolean spawnParticles;
    private final int fireDamage;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;


    public VillagerBrazier(boolean p_51236_, int p_51237_,Properties pProperties)
    {
        super(pProperties);
        this.spawnParticles = p_51236_;
        this.fireDamage = p_51237_;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH)
                .setValue(HALF, DoubleBlockHalf.LOWER)
                .setValue(WATERLOGGED, FALSE)
                .setValue(LIT, TRUE));
    }


    @Override
    public MapCodec<VillagerBrazier> codec() {
        return CODEC;
    }

    //forme hit-box, début-fin x y z
    private static final VoxelShape UPPER_SHAPE = Block.box(2, 0, 2, 14, 4, 14);
    private static final VoxelShape BELOW_SHAPE = Block.box(2, 0, 2, 14, 16, 14);


    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockPos blockpos = pContext.getClickedPos();
        Level level = pContext.getLevel();
        FluidState fluidstateDown = level.getFluidState(blockpos);
        FluidState fluidstateUp = level.getFluidState(blockpos.above());
        boolean flag = fluidstateDown.getType() == WATER;
        if (blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(pContext))
        {
            return this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)
                    .setValue(WATERLOGGED, flag)
                    .setValue(LIT, FALSE)
                    .setValue(FACING, pContext.getHorizontalDirection());

        } else {
            return null;
        }
    }

    // Pose le bloc du dessus
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, ItemStack pStack)
    {
        FluidState fluidstateUp = pLevel.getFluidState(pPos.above());
        boolean flag = fluidstateUp.getType() == WATER;
        pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER)
                .setValue(WATERLOGGED, flag)
                .setValue(LIT, !flag), 3);
    }

    //Applique la hit-box
    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter p_60556_, BlockPos bPos, CollisionContext p_60558_)
    {
        DoubleBlockHalf doubleblockhalf = pState.getValue(HALF);
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
    protected void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile)
    {
        BlockPos blockpos = pHit.getBlockPos();
        if (!pLevel.isClientSide
                && pProjectile.isOnFire()
                && pProjectile.mayInteract(pLevel, blockpos)
                && !pState.getValue(LIT)
                && !pState.getValue(WATERLOGGED)
                && !(pState.getValue(HALF) == DoubleBlockHalf.LOWER)
        )
        {
            pLevel.setBlock(blockpos, pState.setValue(BlockStateProperties.LIT, Boolean.valueOf(true)), 11);
        }
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (pState.getValue(LIT))
        {
            if (pRandom.nextInt(10) == 0)
            {
                pLevel.playLocalSound(
                        (double)pPos.getX() + 0.5,
                        (double)pPos.getY() + 0.5,
                        (double)pPos.getZ() + 0.5,
                        SoundEvents.CAMPFIRE_CRACKLE,
                        SoundSource.BLOCKS,
                        0.5F + pRandom.nextFloat(),
                        pRandom.nextFloat() * 0.7F + 0.6F,
                        false
                );
            }

            if (this.spawnParticles && pRandom.nextInt(5) == 0)
            {
                for (int i = 0; i < pRandom.nextInt(1) + 1; i++)
                {
                    pLevel.addParticle(
                            ParticleTypes.LAVA,
                            (double)pPos.getX() + 0.5,
                            (double)pPos.getY() + 0.5,
                            (double)pPos.getZ() + 0.5,
                            (double)(pRandom.nextFloat() / 2.0F),
                            5.0E-5,
                            (double)(pRandom.nextFloat() / 2.0F)
                    );
                }
            }
        }
    }
    @Override
    public boolean placeLiquid(LevelAccessor pLevel, BlockPos pPos, BlockState pState, FluidState pFluidState)
    {
        if (!pState.getValue(BlockStateProperties.WATERLOGGED) && pFluidState.getType() == WATER)
        {
            boolean flag = pState.getValue(LIT);
            if (flag)
            {
                if (!pLevel.isClientSide() && pState.getValue(HALF) == DoubleBlockHalf.UPPER)
                {
                    pLevel.playSound(null, pPos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.BLOCKS, 1.0F, 1.0F);
                }
            }

            pLevel.setBlock(pPos, pState.setValue(WATERLOGGED, TRUE).setValue(LIT, FALSE), 3);
            pLevel.scheduleTick(pPos, pFluidState.getType(), pFluidState.getType().getTickDelay(pLevel));
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(HALF,LIT, WATERLOGGED, FACING);
    }
    
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity)
    {
        if(pState.getValue(LIT))
        {
            if (!pEntity.isSteppingCarefully() && pEntity instanceof LivingEntity && !EnchantmentHelper.hasFrostWalker((LivingEntity) pEntity)) {
                pEntity.hurt(pLevel.damageSources().hotFloor(), 1.0F);
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
