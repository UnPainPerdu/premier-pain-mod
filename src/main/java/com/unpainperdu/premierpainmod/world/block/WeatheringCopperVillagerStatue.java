package com.unpainperdu.premierpainmod.world.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.ChangeOverTimeBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class WeatheringCopperVillagerStatue extends VillagerStatue implements WeatheringCopper
{
    public static final MapCodec<WeatheringCopperVillagerStatue> CODEC = RecordCodecBuilder.mapCodec(
            p_308850_ -> p_308850_.group(WeatheringCopper.WeatherState.CODEC.fieldOf("weathering_state").forGetter(ChangeOverTimeBlock::getAge), propertiesCodec())
                    .apply(p_308850_, WeatheringCopperVillagerStatue::new)
    );
    private final WeatheringCopper.WeatherState weatherState;

    @Override
    public MapCodec<WeatheringCopperVillagerStatue> codec() {
        return CODEC;
    }

    public WeatheringCopperVillagerStatue(WeatheringCopper.WeatherState p_154925_, BlockBehaviour.Properties p_154926_) {
        super(p_154926_);
        this.weatherState = p_154925_;
    }

    /**
     * Performs a random tick on a block.
     */
    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        this.changeOverTime(pState, pLevel, pPos, pRandom);
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return WeatheringCopper.getNext(pState.getBlock()).isPresent();
    }

    public WeatheringCopper.WeatherState getAge() {
        return this.weatherState;
    }
}
