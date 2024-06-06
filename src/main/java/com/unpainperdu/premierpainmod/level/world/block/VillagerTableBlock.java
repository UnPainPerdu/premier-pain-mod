package com.unpainperdu.premierpainmod.level.world.block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerTableCarpetColor;
import com.unpainperdu.premierpainmod.level.world.block.state.properties.VillagerWorkshopPart;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.WoolCarpetBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Map;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static net.minecraft.world.level.material.Fluids.WATER;

public class VillagerTableBlock extends Block implements SimpleWaterloggedBlock
{
    public static final MapCodec<VillagerTableBlock> CODEC = simpleCodec(VillagerTableBlock::new);
    public static final BooleanProperty NORTH = PipeBlock.NORTH;
    public static final BooleanProperty EAST = PipeBlock.EAST;
    public static final BooleanProperty SOUTH = PipeBlock.SOUTH;
    public static final BooleanProperty WEST = PipeBlock.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<VillagerTableCarpetColor> COLOR;
    protected static final Map<Direction, BooleanProperty> PROPERTY_BY_DIRECTION = PipeBlock.PROPERTY_BY_DIRECTION;
    private static final VoxelShape SHAPE = Block.box(1, 12, 1, 15, 15, 15);

    public VillagerTableBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(NORTH, Boolean.FALSE)
                        .setValue(EAST, Boolean.FALSE)
                        .setValue(SOUTH, Boolean.FALSE)
                        .setValue(WEST, Boolean.FALSE)
                        .setValue(WATERLOGGED, Boolean.FALSE)
                        .setValue(COLOR, VillagerTableCarpetColor.NONE)
        );
    }

    protected MapCodec<VillagerTableBlock> codec()
    {
        return CODEC;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder)
    {
        pBuilder.add(NORTH, EAST, SOUTH, WEST, WATERLOGGED, COLOR);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_)
    {
        return SHAPE;
    }
    //check si le dessus est libre
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext)
    {
        BlockGetter blockgetter = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        FluidState fluidstate = pContext.getLevel().getFluidState(pContext.getClickedPos());
        BlockPos blockpos1 = blockpos.north();
        BlockPos blockpos2 = blockpos.east();
        BlockPos blockpos3 = blockpos.south();
        BlockPos blockpos4 = blockpos.west();
        BlockState blockstate = blockgetter.getBlockState(blockpos1);
        BlockState blockstate1 = blockgetter.getBlockState(blockpos2);
        BlockState blockstate2 = blockgetter.getBlockState(blockpos3);
        BlockState blockstate3 = blockgetter.getBlockState(blockpos4);
        return super.getStateForPlacement(pContext)
                .setValue(NORTH, this.connectsTo(blockstate, blockstate.isFaceSturdy(blockgetter, blockpos1, Direction.SOUTH), Direction.SOUTH))
                .setValue(EAST, this.connectsTo(blockstate1, blockstate1.isFaceSturdy(blockgetter, blockpos2, Direction.WEST), Direction.WEST))
                .setValue(SOUTH, this.connectsTo(blockstate2, blockstate2.isFaceSturdy(blockgetter, blockpos3, Direction.NORTH), Direction.NORTH))
                .setValue(WEST, this.connectsTo(blockstate3, blockstate3.isFaceSturdy(blockgetter, blockpos4, Direction.EAST), Direction.EAST))
                .setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
    }
    public boolean connectsTo(BlockState pState, boolean pIsSideSolid, Direction pDirection)
    {
        Block block = pState.getBlock();
        return block instanceof VillagerTableBlock;
    }
    @Override
    protected @NotNull FluidState getFluidState(BlockState pState)
    {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }
    @Override
    protected BlockState updateShape(BlockState pState, Direction pFacing, BlockState pFacingState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pFacingPos)
    {
        if (pState.getValue(WATERLOGGED))
        {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        return pFacing.getAxis().getPlane() == Direction.Plane.HORIZONTAL
                ? pState.setValue(
                PROPERTY_BY_DIRECTION.get(pFacing),
                this.connectsTo(pFacingState, pFacingState.isFaceSturdy(pLevel, pFacingPos, pFacing.getOpposite()), pFacing.getOpposite())
        )
                : super.updateShape(pState, pFacing, pFacingState, pLevel, pCurrentPos, pFacingPos);
    }
    static
    {
        COLOR = EnumProperty.create("villagertablecarpetcolor", VillagerTableCarpetColor.class);
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult
    )
    {
        if (pLevel.isClientSide)
        {
            return ItemInteractionResult.SUCCESS;
        }
        else
        {
            Block carpetBlock = Block.byItem(pStack.getItem());
            if(carpetBlock instanceof WoolCarpetBlock)
            {

                pLevel.setBlock(pPos, pState.setValue(COLOR, colorDedection((WoolCarpetBlock) carpetBlock)), 3);
                return ItemInteractionResult.CONSUME;
            }

            if ((pStack.getItem() instanceof ShearsItem) && (pState.getValue(COLOR) != VillagerTableCarpetColor.NONE))
            {
                pLevel.setBlock(pPos, pState.setValue(COLOR, VillagerTableCarpetColor.NONE), 3);
                pLevel.playSound(null, pPos, SoundEvents.SHEEP_SHEAR, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.CONSUME;
            }
            else
            {
                return ItemInteractionResult.SUCCESS;
            }

        }
    }
    private VillagerTableCarpetColor colorDedection(WoolCarpetBlock carpetBlock)
    {
        switch (carpetBlock.getColor())
        {
            case WHITE : return VillagerTableCarpetColor.WHITE;
            case LIGHT_GRAY : return VillagerTableCarpetColor.LIGHT_GRAY;
            case GRAY : return VillagerTableCarpetColor.GRAY;
            case BLACK : return VillagerTableCarpetColor.BLACK;
            case BROWN : return VillagerTableCarpetColor.BROWN;
            case RED : return VillagerTableCarpetColor.RED;
            case ORANGE : return VillagerTableCarpetColor.ORANGE;
            case YELLOW : return VillagerTableCarpetColor.YELLOW;
            case LIME : return VillagerTableCarpetColor.LIME;
            case GREEN : return VillagerTableCarpetColor.GREEN;
            case CYAN : return VillagerTableCarpetColor.CYAN;
            case LIGHT_BLUE : return VillagerTableCarpetColor.LIGHT_BLUE;
            case BLUE : return VillagerTableCarpetColor.BLUE;
            case PURPLE : return VillagerTableCarpetColor.PURPLE;
            case MAGENTA : return VillagerTableCarpetColor.MAGENTA;
            case PINK : return VillagerTableCarpetColor.PINK;
            default: return VillagerTableCarpetColor.NONE;
        }
    }
}
