package com.unpainperdu.premierpainmod.util.toolKit;

import net.minecraft.util.RandomSource;

public class RandomUtil
{
    /**
     * maxExcludedBorn must be >= 2, or it will be set to 2
     */
    public static int getRandomPositiveIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        if (maxExcludedBorn<2)
        {
            maxExcludedBorn = 2;
        }
        return (Math.abs(rand.nextInt()))%maxExcludedBorn;
    }

    public static int getRandomIntInRange(int maxExcludedBorn, RandomSource rand)
    {
        if (maxExcludedBorn<2)
        {
            maxExcludedBorn = 2;
        }
        return (rand.nextInt())%maxExcludedBorn;
    }
}
