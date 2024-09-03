package com.unpainperdu.premierpainmod.level.world.block.vegetation.specialVegetation.CactusFloweredBlock;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.vegetation.VegetationUtil;
import com.unpainperdu.premierpainmod.util.register.BlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class FloweredCactusBlock extends Block
{
    /*
    0 = base
    1 = arm top
    2 = arm
    3 = arm with top above
    */
    private static final int BASE_PART = 0;
    private static final int ARM_TOP_PART = 1;
    private static final int ARM_PART = 2;
    private static final int ARM_WITH_ARM_TOP_ABOVE_PART = 3;
    public static final IntegerProperty PART_NUM = IntegerProperty.create("part_num", 0, 3);
    public static final IntegerProperty GROW_STAGE = IntegerProperty.create("grow_stage", 0, 15);
    public static final BooleanProperty CAN_GROW = BooleanProperty.create("can_grow");
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    protected static final VoxelShape SHAPE = Block.box(0, 0, 0, 16, 16, 16);
    protected static final VoxelShape COLLISION_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);
    public static final MapCodec<FloweredCactusBlock> CODEC = simpleCodec(FloweredCactusBlock::new);
    private static final int MAX_HEIGHT = 4;

    public FloweredCactusBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART_NUM, 0).setValue(GROW_STAGE, 0).setValue(CAN_GROW, true).setValue(FACING ,Direction.NORTH));
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context)
    {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext)
    {
        return COLLISION_SHAPE;
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom)
    {
        if (!pState.canSurvive(pLevel, pPos))
        {
            pLevel.destroyBlock(pPos, true);
        }
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        if(state.getValue(CAN_GROW))
        {
            int randomInt = VegetationUtil.getRandomPositiveIntInRange(10, rand); //[0,9]
            int actualGrowStage = state.getValue(GROW_STAGE);
            int actualAmountOfCactusBelow = 1;
            while (level.getBlockState(pos.below(actualAmountOfCactusBelow)).getBlock() instanceof FloweredCactusBlock)
            {
                actualAmountOfCactusBelow++;
            }
            if (state.getValue(PART_NUM) == BASE_PART)
            {
                if (state.getValue(GROW_STAGE) == 15)
                {
                    if(actualAmountOfCactusBelow < MAX_HEIGHT && level.getBlockState(pos.above()).getBlock() instanceof AirBlock)
                    {
                        level.setBlock(pos.above(), state.setValue(PART_NUM, BASE_PART), 2);
                    }
                    else if (getNumberOfArm(state, level, pos)<=1 && randomInt < 7)
                    {
                        generateNewArm(state, level, pos, rand);
                    }
                    else
                    {
                        level.setBlock(pos, state.setValue(CAN_GROW, false), 4);
                    }
                }
                else
                {
                    level.setBlock(pos, state.setValue(GROW_STAGE, actualGrowStage + 1), 4);
                }
            }
            else if (state.getValue(PART_NUM) == ARM_TOP_PART)
            {
                if (state.getValue(GROW_STAGE) == 15)
                {
                    if(level.getBlockState(pos.above()).getBlock() instanceof AirBlock)
                    {
                        level.setBlock(pos.above(), BlockRegister.CACTUS_FLOWER_BLOCK.get().defaultBlockState(), 2);
                        level.setBlock(pos, state.setValue(GROW_STAGE, 0), 4);
                    }
                }
                else
                {
                    if(level.getBlockState(pos.above()).getBlock() instanceof AirBlock)
                    {
                        level.setBlock(pos, state.setValue(GROW_STAGE, actualGrowStage + 1), 4);
                    }
                }
            }
            else if (state.getValue(PART_NUM) == ARM_PART)
            {
                if (state.getValue(GROW_STAGE) == 15)
                {
                    if(level.getBlockState(pos.above()).getBlock() instanceof AirBlock)
                    {
                        level.setBlock(pos.above(), state.setValue(PART_NUM, ARM_TOP_PART), 2);
                        level.setBlock(pos, state.setValue(CAN_GROW, false).setValue(PART_NUM, ARM_WITH_ARM_TOP_ABOVE_PART), 4);
                    }
                    else
                    {
                        level.setBlock(pos, state.setValue(CAN_GROW, false), 4);
                    }
                }
                else
                {
                    level.setBlock(pos, state.setValue(GROW_STAGE, actualGrowStage + 1), 4);
                }
            }
        }
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState pFacingState, LevelAccessor level, BlockPos pos, BlockPos pFacingPos)
    {
        if (!state.canSurvive(level, pos))
        {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, pFacingState, level, pos, pFacingPos);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos)
    {
        boolean flag = false;
        BlockState selfBlockstate = pLevel.getBlockState(pPos);
        BlockState blockstateBelow = pLevel.getBlockState(pPos.below());

        if (selfBlockstate.getBlock() instanceof FloweredCactusBlock)
        {
            if (selfBlockstate.getValue(PART_NUM) == BASE_PART)
            {
                if (blockstateBelow.is(BlockTags.SAND))
                {
                    flag = true;
                }
                else if (blockstateBelow.is(this))
                {
                    if(blockstateBelow.getValue(PART_NUM) == BASE_PART)
                    {
                        flag = true;
                    }
                }
            }
            if (selfBlockstate.getValue(PART_NUM) >= 2)
            {
                List<BlockPos> NSEWPos = Arrays.asList(pPos.north(), pPos.south(), pPos.east(), pPos.west());
                for (BlockPos pos1 : NSEWPos)
                {
                    BlockState state = pLevel.getBlockState(pos1);
                    if (state.is(this))
                    {
                        if (state.getValue(PART_NUM) < 3)
                        {
                            flag = true;
                        }
                    }
                }
            }
            else
            {
                if (blockstateBelow.is(this))
                {
                    if(blockstateBelow.getValue(PART_NUM) == ARM_WITH_ARM_TOP_ABOVE_PART)
                    {
                        flag = true;
                    }
                }
            }
        }
        else
        {
            if(blockstateBelow.is(BlockTags.SAND))
            {
                flag = true;
            }
            else if (blockstateBelow.is(this))
            {
                if(blockstateBelow.getValue(PART_NUM) == BASE_PART)
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(PART_NUM, GROW_STAGE, CAN_GROW, FACING);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState state)
    {
        return true;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        return this.defaultBlockState().setValue(PART_NUM, 0).setValue(GROW_STAGE, 0).setValue(CAN_GROW, true).setValue(FACING, pContext.getHorizontalDirection());
    }

    @Override
    public MapCodec<FloweredCactusBlock> codec()
    {
        return CODEC;
    }

    @Override
    protected void entityInside(BlockState pState, Level pLevel, BlockPos pPos, Entity pEntity)
    {
        pEntity.hurt(pLevel.damageSources().cactus(), 1.0F);
    }

    @Override
    protected boolean isPathfindable(BlockState pState, PathComputationType pPathComputationType)
    {
        return false;
    }

    private int getNumberOfArm(BlockState state, ServerLevel level, BlockPos pos)
    {
        int arm = 0;
        List<BlockPos> NSEWPos = Arrays.asList(pos.north(), pos.south(), pos.east(), pos.west());
        for (BlockPos pos1 : NSEWPos)
        {
            BlockState stateFor = level.getBlockState(pos1);
            if (stateFor.is(this))
            {
                if(state.getValue(PART_NUM) < 3)
                {
                    arm ++;
                }
            }
        }

        return arm;
    }

    private void generateNewArm(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand)
    {
        int randomInt = VegetationUtil.getRandomPositiveIntInRange(4, rand);
        Direction direction;
        switch (randomInt)
        {
            case 0 :
            {
                direction = Direction.NORTH;
                break;
            }
            case 1 :
            {
                direction = Direction.SOUTH;
                break;
            }
            case 2 :
            {
                direction = Direction.WEST;
                break;
            }
            default:
            {
                direction = Direction.EAST;
                break;
            }
        }

        BlockPos newPos = pos.relative(direction);
        if (level.getBlockState(newPos).getBlock() instanceof AirBlock)
        {
            level.setBlock(newPos, state.setValue(PART_NUM, 2), 2);
        }
    }
}
