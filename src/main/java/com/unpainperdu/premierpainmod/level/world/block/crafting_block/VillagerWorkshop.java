package com.unpainperdu.premierpainmod.level.world.block.crafting_block;

import com.mojang.serialization.MapCodec;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.menu.menu.all_materials_block.VillagerWorkshopMenu;
import com.unpainperdu.premierpainmod.level.world.block.abstract_block.AbstractTwoBlockWidth;
import com.unpainperdu.premierpainmod.level.world.block.state.propertie.properties.TwoBlockWidthPart;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class VillagerWorkshop extends AbstractTwoBlockWidth
{
    public static final MapCodec<VillagerWorkshop> CODEC = simpleCodec(VillagerWorkshop::new);
    private static final Component CONTAINER_TITLE = Component.translatable("container." + PremierPainMod.MOD_ID + ".villager_workshop");
    private static final VoxelShape SHAPE = Block.box(0, 7, 0, 16, 12, 16);

    public VillagerWorkshop(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(PART, TwoBlockWidthPart.RIGHT).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec()
    {
        return CODEC;
    }

    //Applique la hit-box
    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter getter, @NotNull BlockPos pos, @NotNull CollisionContext context)
    {
        return SHAPE;
    }

    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder)
    {
        builder.add(FACING, PART, WATERLOGGED);
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
}