package com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.configured_features.misc.random_ruins_state.villager_statue_ruins;

import com.mojang.serialization.Codec;
import com.unpainperdu.premierpainmod.level.world.worldgen.biome.feature.AbstractFeature;
import com.unpainperdu.premierpainmod.util.tool_kit.DirectionHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.PosHelper;
import com.unpainperdu.premierpainmod.util.tool_kit.RandomUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.*;

import static com.unpainperdu.premierpainmod.util.tool_kit.PosHelper.*;

public class VillagerStatueRuinsFeature extends AbstractFeature<VillagerStatueRuinsConfiguration>
{
    private List<BlockState> blockStates;
    private List<BlockState> stairStates;
    private List<BlockState> slabStates;
    private Map<BlockPos, BlockState> map;
    private RandomSource rand;
    private Direction direction;
    private static final String BLOCK = "block";
    private static final String STAIR = "stair";
    private static final String SLAB = "slab";

    public VillagerStatueRuinsFeature(Codec<VillagerStatueRuinsConfiguration> codec)
    {
        super(codec);
    }

    @Override
    public boolean canGenerate(FeaturePlaceContext<VillagerStatueRuinsConfiguration> context)
    {
        WorldGenLevel worldIn = context.level();
        BlockPos pos = context.origin();
        BlockState stateBelow = worldIn.getBlockState(pos.below());


        return (!isFlying(pos, worldIn))
                && (
                (stateBelow.is(BlockTags.DIRT))
                        || (stateBelow.is(BlockTags.SAND))
                        || (stateBelow.is(BlockTags.BASE_STONE_OVERWORLD))
        );
    }

    @Override
    public void generate(FeaturePlaceContext<VillagerStatueRuinsConfiguration> context)
    {
        VillagerStatueRuinsConfiguration config = context.config();
        List<BlockStateProvider> blockStates = config.blockStates();
        List<BlockStateProvider> stairStates = config.stairStates();
        List<BlockStateProvider> slabStates = config.slabStates();

        WorldGenLevel worldIn = context.level();
        ChunkGenerator chunkGenerator = context.chunkGenerator();
        RandomSource rand = context.random();
        BlockPos pos = context.origin();

        init(blockStates, stairStates, slabStates, rand, pos);

        pos = pos.below(3 + (RandomUtil.getRandomPositiveIntInRange(15, rand)));

        //register base pos
        pos = base3x2(pos);
        pos = base3x2(pos);
        pos = base3x2(pos);
        pos = base3x2(pos);
        pos = base3x2(pos);
        pos = base3x2(pos);
        pos = base3x2(pos);
        //register arm
        arm(pos);
        //register neck
        pos = neck(pos);
        //register mouth
        pos = mouth(pos);
        //register noise
        pos = noise(pos);
        //register eyes + top head
        topHead(pos);

        int chance = 10000;
        int blockMissed = 0;
        boolean isGenerating = true;
        int i = 0; //max 98 -> 99 blocks

        for (BlockPos definedPos : this.map.keySet())
        {
            if (isGenerating)
            {
                boolean flag = false;
                if (RandomUtil.getRandomPositiveIntInRange(100, this.rand) > chance)
                {
                    flag = true;
                }
                else
                {
                    worldIn.setBlock(definedPos, this.map.get(definedPos), 1 & 2);
                    BlockPos leftPos = PosHelper.getLeft(definedPos, direction);
                    BlockPos rightPos = PosHelper.getRight(definedPos, direction);
                    BlockPos frontPos = PosHelper.getFront(definedPos, direction);
                    BlockPos behindPos = PosHelper.getBehind(definedPos, direction);
                    Block leftBlock = worldIn.getBlockState(leftPos).getBlock();
                    Block rightBlock = worldIn.getBlockState(rightPos).getBlock();
                    Block frontBlock = worldIn.getBlockState(frontPos).getBlock();
                    Block behindBlock = worldIn.getBlockState(behindPos).getBlock();
                    int random2 = RandomUtil.getRandomPositiveIntInRange(10, rand);
                    if (random2 == 1 && leftBlock instanceof AirBlock)
                    {
                        generateVine(leftPos,worldIn, rand, direction);
                    }
                    random2 = RandomUtil.getRandomPositiveIntInRange(10, rand);
                    if (random2 == 1 && rightBlock instanceof AirBlock)
                    {
                        generateVine(rightPos,worldIn, rand, direction);
                    }
                    random2 = RandomUtil.getRandomPositiveIntInRange(10, rand);
                    if (random2 == 1 && frontBlock instanceof AirBlock)
                    {
                        generateVine(behindPos,worldIn, rand, direction);
                    }
                    random2 = RandomUtil.getRandomPositiveIntInRange(10, rand);
                    if (random2 == 1 && behindBlock instanceof AirBlock)
                    {
                        generateVine(frontPos,worldIn, rand, direction);
                    }
                }
                if (flag)
                {
                    blockMissed++;
                }
                if (blockMissed > 6)
                {
                    isGenerating = false;
                }
                if (i == 18)
                {
                    chance = 90;
                }
                else if (i == 50)
                {
                    chance = 75;
                }
                else if (i == 80)
                {
                    chance = 60;
                }
                i++;
            }
        }
    }

    private void init(List<BlockStateProvider> blockStateProviders, List<BlockStateProvider> stairStatesProviders, List<BlockStateProvider> slabStatesProviders, RandomSource rand, BlockPos pos)
    {
        this.map = new LinkedHashMap<>();
        this.blockStates = new ArrayList<>();
        blockStateProviders.forEach(s -> this.blockStates.add(s.getState(rand, pos)));
        this.stairStates = new ArrayList<>();
        stairStatesProviders.forEach(s -> this.stairStates.add(s.getState(rand, pos)));
        this.slabStates = new ArrayList<>();
        slabStatesProviders.forEach(s -> this.slabStates.add(s.getState(rand, pos)));
        this.rand = rand;
        this.direction = DirectionHelper.getRandomDirection(rand);
    }

    /**
     * @return pos.above()
     */
    private BlockPos base3x2(BlockPos pos)
    {
        BlockPos currentPos = pos;
        this.map.put(currentPos, getStateFromType(BLOCK));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(BLOCK));
        currentPos = getFront(currentPos, this.direction);
        this.map.put(currentPos, getStateFromType(BLOCK));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(BLOCK));
        return pos.above();
    }

    private void arm(BlockPos currentPos)
    {
        currentPos = currentPos.below();
        this.map.put(getLeft(currentPos, this.direction, 2), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction, 2), getStateFromType(BLOCK));
        currentPos = getFront(currentPos, this.direction);
        this.map.put(getLeft(currentPos, this.direction, 2), getStateFromType(STAIR).setValue(StairBlock.FACING, direction));
        this.map.put(getRight(currentPos, this.direction, 2), getStateFromType(STAIR).setValue(StairBlock.FACING, direction));
        currentPos = currentPos.below();
        this.map.put(getLeft(currentPos, this.direction, 2), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction, 2), getStateFromType(BLOCK));
        currentPos = getFront(currentPos, this.direction);
        this.map.put(getLeft(currentPos, this.direction, 2), getStateFromType(STAIR).setValue(StairBlock.FACING, direction));
        this.map.put(getRight(currentPos, this.direction, 2), getStateFromType(STAIR).setValue(StairBlock.FACING, direction));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(currentPos, getStateFromType(BLOCK));
    }

    /**
     * @return pos.above()
     */
    private BlockPos neck(BlockPos pos)
    {
        BlockPos currentPos = pos;
        this.map.put(currentPos, getStateFromType(BLOCK));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(BLOCK));
        currentPos = getFront(currentPos, this.direction);
        this.map.put(currentPos, getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        return pos.above();
    }

    /**
     * @return pos.above()
     */
    private BlockPos mouth(BlockPos pos)
    {
        BlockPos currentPos = pos;
        this.map.put(currentPos, getStateFromType(BLOCK));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(BLOCK));
        currentPos = getFront(currentPos, this.direction);
        this.map.put(currentPos, getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getLeft(currentPos, this.direction), getStateFromType(STAIR).setValue(StairBlock.FACING, DirectionHelper.getLeftDirection(direction)).setValue(StairBlock.HALF, Half.TOP));
        this.map.put(getRight(currentPos, this.direction), getStateFromType(STAIR).setValue(StairBlock.FACING, DirectionHelper.getRightDirection(direction)).setValue(StairBlock.HALF, Half.TOP));
        return pos.above();
    }

    /**
     * @return pos.above()
     */
    private BlockPos noise(BlockPos pos)
    {
        base3x2(pos);
        BlockPos currentPos = getFront(pos, direction, 2);
        this.map.put(currentPos, getStateFromType(BLOCK));
        this.map.put(currentPos.below(), getStateFromType(BLOCK));
        this.map.put(currentPos.below().below(), getStateFromType(BLOCK));
        return pos.above();
    }

    private void topHead(BlockPos pos)
    {
        this.map.put(pos, getStateFromType(BLOCK));
        this.map.put(getLeft(pos, this.direction), getStateFromType(BLOCK));
        this.map.put(getRight(pos, this.direction), getStateFromType(BLOCK));
        pos = getFront(pos, this.direction);
        this.map.put(pos, getStateFromType(BLOCK));
        this.map.put(getLeft(pos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getRight(pos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        pos = getFront(pos, this.direction);
        this.map.put(pos, getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getLeft(pos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        this.map.put(getRight(pos, this.direction), getStateFromType(SLAB).setValue(SlabBlock.TYPE, SlabType.TOP));
        pos = pos.above();
        this.map.put(pos, getStateFromType(SLAB));
        this.map.put(getLeft(pos, this.direction), getStateFromType(SLAB));
        this.map.put(getRight(pos, this.direction), getStateFromType(SLAB));
        pos = getBehind(pos, this.direction, 2);
        pos = base3x2(pos);
        base3x2(pos);
    }

    private BlockState getStateFromType(String type)
    {
        switch (type)
        {
            case STAIR ->
            {
                try
                {
                    return this.stairStates.get(RandomUtil.getRandomPositiveIntInRange(this.stairStates.size(), this.rand));
                } catch (Exception e)
                {
                    return this.stairStates.getFirst();
                }
            }
            case SLAB ->
            {
                try
                {
                    return this.slabStates.get(RandomUtil.getRandomPositiveIntInRange(this.slabStates.size(), this.rand));
                } catch (Exception e)
                {
                    return this.slabStates.getFirst();
                }
            }
            default ->
            {
                try
                {
                    return this.blockStates.get(RandomUtil.getRandomPositiveIntInRange(this.blockStates.size(), this.rand));
                } catch (Exception e)
                {
                    return this.blockStates.getFirst();
                }
            }
        }
    }
    private void generateVine(BlockPos pos, WorldGenLevel worldIn, RandomSource rand, Direction direction)
    {
        int i = 0;
        List<BlockPos> posList =  Arrays.asList(PosHelper.getLeft(pos, direction), PosHelper.getRight(pos, direction), PosHelper.getFront(pos, direction), PosHelper.getBehind(pos, direction));
        List<Block> blockList = new ArrayList<>();
        List<Direction> directionList = new ArrayList<>();

        for(BlockPos posFor : posList)
        {
            blockList.add(worldIn.getBlockState(posFor).getBlock());
            int basePoseX = pos.getX();
            int basePoseY = pos.getY();
            int basePoseZ = pos.getZ();
            int poseX = posList.get(i).getX();
            int poseY = posList.get(i).getY();
            int poseZ = posList.get(i).getZ();
            directionList.add(Direction.fromDelta(basePoseX - poseX,basePoseY - poseY,basePoseZ - poseZ));
            i ++;
        }
        i = 0;
        BlockState blockState = Blocks.VINE.defaultBlockState();

        for(Block block : blockList)
        {
            if(!(block instanceof AirBlock) && !(block instanceof VineBlock) && !(block instanceof BushBlock))
            {
                switch (directionList.get(i))
                {
                    case NORTH :
                    {
                        blockState = blockState.setValue(VineBlock.SOUTH, true);
                        break;
                    }
                    case EAST :
                    {
                        blockState = blockState.setValue(VineBlock.WEST, true);
                        break;
                    }
                    case SOUTH :
                    {
                        blockState = blockState.setValue(VineBlock.NORTH, true);
                        break;
                    }
                    default :
                    {
                        blockState = blockState.setValue(VineBlock.EAST, true);
                        break;
                    }
                }
            }
            i++;
        }

        worldIn.setBlock(pos, blockState,1 & 2);

        int randomLength = RandomUtil.getRandomPositiveIntInRange(4, rand);
        boolean flagLengthVine = false;
        BlockPos posModif = pos;

        for (int j = 0; j < randomLength; j++)
        {
            posModif = posModif.below();
            Block blockModif = worldIn.getBlockState(posModif).getBlock();
            if(!flagLengthVine && blockModif instanceof AirBlock)
            {
                worldIn.setBlock(posModif, blockState,1 & 2);
            }
            else
            {
                flagLengthVine = true;
            }
        }
    }
}
