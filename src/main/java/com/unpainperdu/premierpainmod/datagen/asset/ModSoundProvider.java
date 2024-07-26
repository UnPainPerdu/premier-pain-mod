package com.unpainperdu.premierpainmod.datagen.asset;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

public class ModSoundProvider extends SoundDefinitionsProvider
{
    public ModSoundProvider(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, PremierPainMod.MODID, existingFileHelper);
    }

    @Override
    public void registerSounds()
    {
        add(SoundEventRegister.LIBERTY_SOUND, SoundDefinition.definition()
                .with(sound("premierpainmod:liberty_sound", SoundDefinition.SoundType.SOUND))
        );
        add(SoundEventRegister.DIGGY_SOUND, SoundDefinition.definition()
                .with(sound("premierpainmod:diggy_sound", SoundDefinition.SoundType.SOUND))
        );
        add(SoundEventRegister.MADNESS_SOUND, SoundDefinition.definition()
                .with(sound("premierpainmod:madness_sound", SoundDefinition.SoundType.SOUND))
        );
    }
}
