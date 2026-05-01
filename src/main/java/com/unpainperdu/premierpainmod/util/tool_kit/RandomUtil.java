package com.unpainperdu.premierpainmod.util.tool_kit;

import net.minecraft.util.RandomSource;

public class RandomUtil
{
    //TODO read the fucking random java class, minecraft random class has same doc
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