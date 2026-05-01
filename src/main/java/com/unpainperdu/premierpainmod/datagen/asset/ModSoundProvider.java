package com.unpainperdu.premierpainmod.datagen.asset;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.util.register.SoundEventRegister;
import net.minecraft.data.PackOutput;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModSoundProvider extends SoundDefinitionsProvider
{
    public ModSoundProvider(PackOutput output)
    {
        super(output, PremierPainMod.MOD_ID);
    }

    @Override
    public void registerSounds()
    {
        //item
        //villager_singing_stone
        add(SoundEventRegister.LIBERTY_SOUND, SoundDefinition.definition().with(sound("premierpainmod:item/villager_singing_stone/liberty_sound")));
        add(SoundEventRegister.DIGGY_SOUND, SoundDefinition.definition().with(sound("premierpainmod:item/villager_singing_stone/diggy_sound")));
        add(SoundEventRegister.MADNESS_SOUND, SoundDefinition.definition().with(sound("premierpainmod:item/villager_singing_stone/madness_sound")));
        add(SoundEventRegister.PREMIER_PAIN_SOUND, SoundDefinition.definition().with(sound("premierpainmod:item/villager_singing_stone/premier_pain_sound")));
        //entity
        //toilet_seat
        addMultipleSoundToEvent(SoundEventRegister.TOILET_SEAT_FART, "premierpainmod:entity/toilet_seat/", "fart01", "fart02", "fart03", "fart04", "fart05");
        add(SoundEventRegister.TOILET_SEAT_NOT_ONLY_FART, SoundDefinition.definition().with(sound("premierpainmod:entity/toilet_seat/not_only_fart")));
        //  mob
        //      mountain_currant_golem
        addMultipleSoundToEvent(SoundEventRegister.MCG_WALK, "premierpainmod:entity/mountain_currant_golem/", "walk_01", "walk_02", "walk_03", "walk_04");
        addMultipleSoundToEvent(SoundEventRegister.MCG_HURT, "premierpainmod:entity/mountain_currant_golem/", "hurt_01", "hurt_02", "hurt_03");
        add(SoundEventRegister.MCG_DEATH, SoundDefinition.definition().with(sound("premierpainmod:entity/mountain_currant_golem/death")));
        add(SoundEventRegister.MCG_BONE_MEALING, SoundDefinition.definition().with(sound("premierpainmod:entity/mountain_currant_golem/use_bone_meal")));
        addMultipleSoundToEvent(SoundEventRegister.MCG_AMBIENT, "premierpainmod:entity/mountain_currant_golem/", "ambient_01", "ambient_02");
        //      wool_golem
        addMultipleSoundToEvent(SoundEventRegister.WG_WALK, "premierpainmod:entity/wool_golem/", "walk_01", "walk_02", "walk_03");
        addMultipleSoundToEvent(SoundEventRegister.WG_HURT, "premierpainmod:entity/wool_golem/", "hurt_01", "hurt_02", "hurt_03");
        add(SoundEventRegister.WG_DEATH, SoundDefinition.definition().with(sound("premierpainmod:entity/wool_golem/death_01")));
        addMultipleSoundToEvent(SoundEventRegister.WG_AMBIENT, "premierpainmod:entity/wool_golem/", "ambient_01", "ambient_02", "ambient_03");
        //      flowered lizard
        add(SoundEventRegister.FLOWERED_LIZARD_DEATH, SoundDefinition.definition().with(sound("premierpainmod:entity/flowered_lizard/death_01")));
        addMultipleSoundToEvent(SoundEventRegister.FLOWERED_LIZARD_EAT, "premierpainmod:entity/flowered_lizard/", "eat_01", "eat_02");
        addMultipleSoundToEvent(SoundEventRegister.FLOWERED_LIZARD_HURT, "premierpainmod:entity/flowered_lizard/", "hurt_01", "hurt_02");
        addMultipleSoundToEvent(SoundEventRegister.FLOWERED_LIZARD_AMBIENT, "premierpainmod:entity/flowered_lizard/", "ambient_01", "ambient_02", "ambient_03");
    }

    private void addMultipleSoundToEvent(Supplier<SoundEvent> soundEvent, String folder, String... soundNames)
    {
        SoundDefinition soundDefinition = SoundDefinition.definition();
        List<SoundDefinition.Sound> finalSoundDefinitions = new ArrayList<>();
        for (String soundName : soundNames)
        {
            finalSoundDefinitions.add(sound(folder + soundName));
        }
        soundDefinition.with(finalSoundDefinitions.toArray(new SoundDefinition.Sound[0]));
        add(soundEvent, soundDefinition);
    }
}