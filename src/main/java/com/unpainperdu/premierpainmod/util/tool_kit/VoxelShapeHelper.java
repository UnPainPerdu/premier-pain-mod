package com.unpainperdu.premierpainmod.util.tool_kit;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

/**
 * Utility class for VoxelShape transformation.
 * Get the helper with fromVoxelShape(VoxelShape).
 * When transformation is done, get final VoxelHSape with toVoxelShape(VoxelShapeHelper).
 */
public class VoxelShapeHelper
{
    private List<AABBCoo> voxelShapeAABBs;

    private VoxelShapeHelper(List<AABBCoo> voxelShapeAABBs)
    {
        this.voxelShapeAABBs = voxelShapeAABBs;
    }

    public static VoxelShapeHelper fromVoxelShape(VoxelShape voxelShape)
    {
        return new VoxelShapeHelper(voxelShape.toAabbs().stream().map(aabb -> new AABBCoo(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ)).toList());
    }

    public VoxelShape toVoxelShape()
    {
        List<VoxelShape> voxelShapes = this.voxelShapeAABBs.stream().map(aabbCoo -> Shapes.create(aabbCoo.minX, aabbCoo.minY, aabbCoo.minZ, aabbCoo.maxX, aabbCoo.maxY, aabbCoo.maxZ)).toList();
        VoxelShape finalVoxelShape = Block.box(0, 0, 0, 0, 0, 0);
        for (VoxelShape vs : voxelShapes)
        {
            finalVoxelShape = Shapes.or(finalVoxelShape, vs);
        }

        return finalVoxelShape;
    }

    /**
     * Rotate from center (8,8,8) by the direction (Up is the default one)
     *
     * @param direction the direction of the block
     * @return the shape rotated
     */
    public VoxelShapeHelper rotateFromCenterByDirection(Direction direction)
    {
        switch (direction)
        {
            case UP ->
            {
                return this;
            }

            case DOWN ->
            {
                return rotateFromCenter(2, RotationAxis.PITCH);
            }
            default ->
            {
                VoxelShapeHelper tempVsh = rotateFromCenter(1, RotationAxis.PITCH);
                return tempVsh.rotateFromCenterByDirectionNSWE(direction);
            }
        }
    }

    /**
     * Rotate from center (8,8,8) by the direction for NSWE (north is the default one)
     *
     * @param direction the direction of the block
     * @return the shape rotated
     */
    public VoxelShapeHelper rotateFromCenterByDirectionNSWE(Direction direction)
    {
        switch (direction)
        {
            case SOUTH ->
            {
                return rotateFromCenter(2, RotationAxis.YAW);
            }
            case EAST ->
            {
                return rotateFromCenter(3, RotationAxis.YAW);
            }
            case WEST ->
            {
                return rotateFromCenter(1, RotationAxis.YAW);
            }
            default ->
            {
                return this;
            }
        }
    }

    /**
     * Rotate from center (8,8,8) by rotation and axis
     *
     * @param rotation     the rotation in quart -> 0 = 0°, 1 = 90° ...
     * @param rotationAxis the rotation axis
     * @return the shape rotated
     */
    public VoxelShapeHelper rotateFromCenter(int rotation, RotationAxis rotationAxis)
    {
        this.voxelShapeAABBs = this.voxelShapeAABBs.stream()
                .map(aabbCoo -> aabbCoo.offSetAABBCoo((double) -1 / 2)) // (0,0,0) is now at center of the cube (old (8,8,8))
                .map(aabbCoo ->
                {
                    switch (rotationAxis)
                    {
                        case YAW ->
                        {
                            Pair<Double, Double> newMin = aabbCoo.getNewCoodWithRotation(aabbCoo.minX, aabbCoo.minZ, rotation);
                            Pair<Double, Double> newMax = aabbCoo.getNewCoodWithRotation(aabbCoo.maxX, aabbCoo.maxZ, rotation);
                            aabbCoo.minX = newMin.getFirst();
                            aabbCoo.maxX = newMax.getFirst();
                            aabbCoo.minZ = newMin.getSecond();
                            aabbCoo.maxZ = newMax.getSecond();
                        }
                        case ROLL ->
                        {
                            Pair<Double, Double> newMin = aabbCoo.getNewCoodWithRotation(aabbCoo.minX, aabbCoo.minY, rotation);
                            Pair<Double, Double> newMax = aabbCoo.getNewCoodWithRotation(aabbCoo.maxX, aabbCoo.maxY, rotation);
                            aabbCoo.minX = newMin.getFirst();
                            aabbCoo.maxX = newMax.getFirst();
                            aabbCoo.minY = newMin.getSecond();
                            aabbCoo.maxY = newMax.getSecond();
                        }
                        default ->
                        {
                            Pair<Double, Double> newMin = aabbCoo.getNewCoodWithRotation(aabbCoo.minY, aabbCoo.minZ, rotation);
                            Pair<Double, Double> newMax = aabbCoo.getNewCoodWithRotation(aabbCoo.maxY, aabbCoo.maxZ, rotation);
                            aabbCoo.minY = newMin.getFirst();
                            aabbCoo.maxY = newMax.getFirst();
                            aabbCoo.minZ = newMin.getSecond();
                            aabbCoo.maxZ = newMax.getSecond();
                        }
                    }
                    return aabbCoo.correctIfMinBiggerThanMax();
                })
                .map(aabbCoo -> aabbCoo.offSetAABBCoo((double) 1 / 2)) //  (0,0,0) become (8,8,8) --> back to normal
                .toList();

        return this;
    }

    public enum RotationAxis
    {
        YAW, //lacet -> rotation axis UP-DOWN 2d coord = (z,x)
        PITCH, //tangage -> rotation axis E-W 2d coord = (z,y)
        ROLL //roulis -> rotation axis N-S 2d coord = (x,y)
    }

    public static class AABBCoo
    {
        public double minX;
        public double minY;
        public double minZ;
        public double maxX;
        public double maxY;
        public double maxZ;

        private AABBCoo(double minX, double minY, double minZ, double maxX, double maxY, double maxZ)
        {
            this.minX = minX;
            this.minY = minY;
            this.minZ = minZ;
            this.maxX = maxX;
            this.maxY = maxY;
            this.maxZ = maxZ;
        }

        public AABBCoo offSetAABBCoo(double offSet)
        {
            this.minX += offSet;
            this.minY += offSet;
            this.minZ += offSet;
            this.maxX += offSet;
            this.maxY += offSet;
            this.maxZ += offSet;
            return this;
        }

        /**
         * @param rotation must be [0,3]
         */
        public Pair<Double, Double> getNewCoodWithRotation(double a, double b, int rotation)
        {
            return switch (rotation)
            {
                case 1 -> Pair.of(b, -a);
                case 2 -> Pair.of(-a, -b);
                case 3 -> Pair.of(-b, a);
                default -> Pair.of(a, b);
            };
        }

        public AABBCoo correctIfMinBiggerThanMax()
        {
            Pair<Double, Double> finalXs = correctIfMinBiggerThanMax(this.minX, this.maxX);
            Pair<Double, Double> finalYs = correctIfMinBiggerThanMax(this.minY, this.maxY);
            Pair<Double, Double> finalZs = correctIfMinBiggerThanMax(this.minZ, this.maxZ);
            this.minX = finalXs.getFirst();
            this.maxX = finalXs.getSecond();
            this.minY = finalYs.getFirst();
            this.maxY = finalYs.getSecond();
            this.minZ = finalZs.getFirst();
            this.maxZ = finalZs.getSecond();
            return this;
        }

        private Pair<Double, Double> correctIfMinBiggerThanMax(double min, double max)
        {
            return min > max ? Pair.of(max, min) : Pair.of(min, max);
        }
    }
}