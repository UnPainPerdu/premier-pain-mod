package com.unpainperdu.premierpainmod.util.seat;

import java.util.HashMap;
import java.util.Map;

import com.unpainperdu.premierpainmod.level.world.entity.blockEntity.SeatEntity;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class SeatUtil
{
    /**
     * <dimension type id, <position, <entity, previous player position>>> This map only gets populated on server side.
     */
    private static final Map<ResourceLocation, Map<BlockPos, Pair<SeatEntity, Vec3>>> OCCUPIED = new HashMap<>();

    private SeatUtil() {}

    /**
     * Adds a sit entity to the map that keeps track of them. This does not spawn the entity itself.
     *
     * @param level The level to add the entity in
     * @param blockPos The position at which to add the entity
     * @param entity The entity to add
     * @param playerPos The position of the player who is sitting down. Used for correctly positioning the player after
     *            dismounting
     * @return true if the entity was added, false otherwhise. This is always false on the client.
     */
    public static boolean addSitEntity(Level level, BlockPos blockPos, SeatEntity entity, Vec3 playerPos)
    {
        if (!level.isClientSide)
        {
            ResourceLocation id = getDimensionTypeId(level);

            if (!OCCUPIED.containsKey(id))
                OCCUPIED.put(id, new HashMap<>());

            OCCUPIED.get(id).put(blockPos, Pair.of(entity, playerPos));
            return true;
        }

        return false;
    }

    /**
     * Removes a sit entity from the map that keeps track of them. This does not remove the entity itself.
     *
     * @param level The level to remove the entity from
     * @param pos The position to remove the entity from
     * @return true if the entity was removed, false otherwhise. This is always false on the client.
     */
    public static boolean removeSitEntity(Level level, BlockPos pos)
    {
        if (!level.isClientSide) {
            ResourceLocation id = getDimensionTypeId(level);

            if (OCCUPIED.containsKey(id)) {
                OCCUPIED.get(id).remove(pos);
                return true;
            }
        }

        return false;
    }

    /**
     * Gets the sit entity that is situated at the given position in the given level
     *
     * @param level The level to get the entity from
     * @param pos The position to get the entity from
     * @return The entity at the given position in the given level, null if there is none. This is always null on the client.
     */
    public static SeatEntity getSitEntity(Level level, BlockPos pos)
    {
        if (!level.isClientSide)
        {
            ResourceLocation id = getDimensionTypeId(level);

            if (OCCUPIED.containsKey(id) && OCCUPIED.get(id).containsKey(pos))
                return OCCUPIED.get(id).get(pos).getLeft();
        }

        return null;
    }

    /**
     * Gets the position the player was at before he sat down
     *
     * @param player The player
     * @param sitEntity The sit entity the player is sitting on
     * @return The position the player was at before he sat down, null if the player is not sitting. This is always null on the
     *         client.
     */
    public static Vec3 getPreviousPlayerPosition(Player player, SeatEntity sitEntity)
    {
        if (!player.level().isClientSide)
        {
            ResourceLocation id = getDimensionTypeId(player.level());

            if (OCCUPIED.containsKey(id))
            {
                for (Pair<SeatEntity, Vec3> pair : OCCUPIED.get(id).values())
                {
                    if (pair.getLeft() == sitEntity)
                        return pair.getRight();
                }
            }
        }

        return null;
    }

    /**
     * Checks whether there is a player sitting at the given block position in the given level
     *
     * @param level The level to check in
     * @param pos The position to check at
     * @return true if a player is sitting at the given position in the given level, false otherwhise. This is always false on
     *         the client.
     */
    public static boolean isOccupied(Level level, BlockPos pos) {
        ResourceLocation id = getDimensionTypeId(level);

        return SeatUtil.OCCUPIED.containsKey(id) && SeatUtil.OCCUPIED.get(id).containsKey(pos);
    }

    /**
     * Checks whether a player is sitting anywhere
     *
     * @param player The player to check
     * @return true if the given player is sitting anywhere, false otherwhise
     */
    public static boolean isPlayerSitting(Player player) {
        for (ResourceLocation i : OCCUPIED.keySet()) {
            for (Pair<SeatEntity, Vec3> pair : OCCUPIED.get(i).values()) {
                if (pair.getLeft().hasPassenger(player))
                    return true;
            }
        }

        return false;
    }

    private static ResourceLocation getDimensionTypeId(Level level) {
        return level.dimension().location();
    }
}
