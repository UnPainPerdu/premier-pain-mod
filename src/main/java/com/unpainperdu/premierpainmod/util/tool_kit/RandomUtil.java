package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.util.RandomSource;

public class RandomUtil
{
    private RandomUtil(){}
    /**
     * maxExcludedBorn must be >= 2, or it will be set to 2
     * return [0, maxExcludedBorn[
     */
    public static int getRandomPositiveIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        return Math.abs(getRandomIntInRange(maxExcludedBorn, rand));
    }

    /**
     * maxExcludedBorn must be >= 2, or it will be set to 2
     * return ]-maxExcludedBorn , maxExcludedBorn[
     */
    public static int getRandomIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        if (maxExcludedBorn<2)
        {
            maxExcludedBorn = 2;
        }
        return (rand.nextInt())%maxExcludedBorn;
    }
}
