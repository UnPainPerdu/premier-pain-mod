package com.unpainperdu.premierpainmod.level.world.item.items.DrinkableBeerItem;

public enum DrinkableBeerItemType
{
    GLASS("glass", 30),
    BOTTLE("bottle", 20),
    MUG("mug", 45)
    ;
    private final String name;
    private final int effectDuration;

    DrinkableBeerItemType(String name, int effectDuration)
    {
        this.name = name;
        this.effectDuration = effectDuration * 20;
    };

    @Override
    public String toString()
    {
        return this.name;
    }

    public int getEffectDuration()
    {
        return this.effectDuration;
    }
}
