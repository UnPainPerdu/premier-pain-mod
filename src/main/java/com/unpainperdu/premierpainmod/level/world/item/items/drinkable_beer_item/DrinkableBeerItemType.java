package com.unpainperdu.premierpainmod.level.world.item.items.drinkable_beer_item;

public enum DrinkableBeerItemType
{
    GLASS("glass", 45),
    BOTTLE("bottle", 20),
    MUG("mug", 35)
    ;
    private final String name;
    private final int effectDuration;

    DrinkableBeerItemType(String name, int effectDuration)
    {
        this.name = name;
        this.effectDuration = effectDuration * 20;
    }

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
