package com.unpainperdu.premierpainmod.level.world.block.crafting_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockWidth;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import com.unpainperdu.premierpainmod.level.world.menu.menu.all_materials_block.villager_workshop_menu.VillagerWorkshopMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VillagerWorkshop extends AbstractTwoBlockWidth
{
    public static final MapCodec<VillagerWorkshop> CODEC = simpleCodec(VillagerWorkshop::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container."+ PremierPainMod.MOD_ID +".villager_workshop");
    private static final VoxelShape SHAPE = Block.box(0, 7, 0, 16, 12, 16);

    public VillagerWorkshop(Properties pProperties)
    {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return CODEC;
    }

    @Nullable
    public static Direction getVillagerWorkshopOrientation(BlockGetter pLevel, BlockPos pPos)
    {
        BlockState blockstate = pLevel.getBlockState(pPos);
        return blockstate.getBlock() instanceof VillagerWorkshop
                ? (Direction)blockstate.getValue(FACING)
                : null;
    }

    //Applique la hit-box
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE;
    }

    public static Direction getConnectedDirection(BlockState pState)
    {
        Direction direction = DirectionSwitcher(pState.getValue(FACING));
        return pState.getValue(PART) == TwoBlockWidthPart.LEFT ? direction.getOpposite() : direction;
    }

    public static DoubleBlockCombiner.BlockType getBlockType(BlockState pState)
    {
        TwoBlockWidthPart twoBlockWidthPart = (TwoBlockWidthPart)pState.getValue(PART);
        return twoBlockWidthPart == TwoBlockWidthPart.LEFT ? DoubleBlockCombiner.BlockType.FIRST : DoubleBlockCombiner.BlockType.SECOND;
    }

    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
    {
        builder.add(new Property[]{FACING, PART, WATERLOGGED});
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult)
    {
        if (pLevel.isClientSide)
        {
            return InteractionResult.SUCCESS;
        }
        else
        {
            pPlayer.openMenu(pState.getMenuProvider(pLevel, pPos));
            return InteractionResult.CONSUME;
        }
    }

    @Nullable
    @Override
    protected MenuProvider getMenuProvider(BlockState pState, Level pLevel, BlockPos pPos)
    {
        return new SimpleMenuProvider((pContainerId, pPlayerInventory, pAccess) -> new VillagerWorkshopMenu(pContainerId, pPlayerInventory, ContainerLevelAccess.create(pLevel, pPos)), CONTAINER_TITLE);
    }
    @Override
    protected @NotNull BlockState rotate(BlockState state, Rotation rot)
    {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }
}
