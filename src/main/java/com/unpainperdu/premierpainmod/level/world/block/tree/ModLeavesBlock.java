package com.unpainperdu.premierpainmod.level.world.block.tree;

import com.unpainperdu.premierpainmod.util.register.block.BlockRegister;
import com.unpainperdu.premierpainmod.util.register.ItemRegister;
import com.unpainperdu.premierpainmod.util.toolKit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class ModLeavesBlock extends LeavesBlock
{
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_FRUIT = BooleanProperty.create("has_fruit");

    private final int flammability;
    private final int fireSpreadSpeed;
    public final boolean CAN_HAVE_FRUIT;

    public ModLeavesBlock(boolean canHaveFruit, int flammability, int fireSpreadSpeed, Properties properties)
    {
        super(properties);
        this.CAN_HAVE_FRUIT = canHaveFruit;
        this.flammability = flammability;
        this.fireSpreadSpeed = fireSpreadSpeed;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(HAS_FRUIT, false)
                .setValue(WATERLOGGED, false)
                .setValue(DISTANCE, 7)
                .setValue(PERSISTENT, false)
        );
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(WATERLOGGED, HAS_FRUIT, DISTANCE, PERSISTENT);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return flammability;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction)
    {
        return fireSpreadSpeed;
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos)
    {
        if (state.getValue(WATERLOGGED))
        {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        return super.updateShape(state, facing, facingState, level, pos, facingPos);
    }

    @Override
    protected @NotNull FluidState getFluidState(BlockState state)
    {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        BlockState blockstate = this.defaultBlockState()
                .setValue(PERSISTENT, true)
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        return updateDistance(blockstate, context.getLevel(), context.getClickedPos());
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return ((this.CAN_HAVE_FRUIT) && !(state.getValue(ModLeavesBlock.HAS_FRUIT))) || super.isRandomlyTicking(state) ;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random)
    {
        if((RandomUtil.getRandomPositiveIntInRange(10, random) <= 3) && !decaying(state))
        {
            level.setBlock(pos, state.setValue(ModLeavesBlock.HAS_FRUIT, true), 2);
        }
        super.randomTick(state, level, pos, random);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult)
    {
        if (state.getValue(ModLeavesBlock.HAS_FRUIT))
        {
            int j = 1 + RandomUtil.getRandomIntInRange(3, level.random);
            popResource(level, pos, new ItemStack(getFruitForLeaves(state), j ));
            level.playSound(
                    null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F
            );
            BlockState blockstate = state.setValue(ModLeavesBlock.HAS_FRUIT, false);
            level.setBlock(pos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else
        {
            return super.useWithoutItem(state, level, pos, player, hitResult);
        }
    }

    private static BlockState updateDistance(BlockState state, LevelAccessor level, BlockPos pos)
    {
        int i = 7;
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for (Direction direction : Direction.values())
        {
            blockpos$mutableblockpos.setWithOffset(pos, direction);
            i = Math.min(i, getDistanceAt(level.getBlockState(blockpos$mutableblockpos)) + 1);
            if (i == 1)
            {
                break;
            }
        }

        return state.setValue(DISTANCE, i);
    }

    private static int getDistanceAt(BlockState neighbor)
    {
        return getOptionalDistanceAt(neighbor).orElse(7);
    }

    protected ItemLike getFruitForLeaves(BlockState state)
    {
        Map<BlockState, ItemLike> fruitAndLeavesMap = new HashMap<>();
        fruitAndLeavesMap.put(BlockRegister.MOUNTAIN_CURRANT_LEAVES.get().defaultBlockState(), ItemRegister.MOUNTAIN_CURRANT);

        if (fruitAndLeavesMap.containsKey(state.getBlock().defaultBlockState()))
        {
            return  fruitAndLeavesMap.get(state.getBlock().defaultBlockState());
        }
        else
        {
            return state.getBlock().asItem();
        }
    }
}
