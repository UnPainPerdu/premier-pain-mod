package com.unpainperdu.premierpainmod.datagen.data;

import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.block.twoBlockWidth.VillagerWorkshop;
import com.unpainperdu.premierpainmod.util.register.ModList;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper fileHelper) {
        super(packOutput, lookupProvider, PremierPainMod.MOD_ID, fileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider)
    {
        for (DeferredBlock<Block> Defferedblock : ModList.ALL_BLOCKS)
        {
            Block block = Defferedblock.get();
            String blockName = BuiltInRegistries.BLOCK.getKey(block).toString().replace(PremierPainMod.MOD_ID + ":", "");
            //mineable with pickaxe
            if ((block instanceof VillagerWorkshop)
                    || (blockName.contains("red_sandstone"))
                    || (blockName.contains("sandstone"))
                    || (blockName.contains("mossy_stone"))
                    || (blockName.contains("end_stone"))
                    || (blockName.contains("blackstone"))
                    || (blockName.contains("redstone"))
                    || (blockName.contains("dripstone"))
                    || (blockName.contains("stone"))
                    || (blockName.contains("andesite"))
                    || (blockName.contains("diorite"))
                    || (blockName.contains("granite"))
                    || (blockName.contains("prismarine"))
                    || (blockName.contains("purpur"))
                    || (blockName.contains("deepslate"))
                    || (blockName.contains("tuff"))
                    || (blockName.contains("packed_mud"))
                    || (blockName.contains("quartz"))
                    || (blockName.contains("nether_bricks"))
                    || (blockName.contains("basalt"))
                    || (blockName.contains("coal"))
                    || (blockName.contains("iron"))
                    || (blockName.contains("gold"))
                    || (blockName.contains("emerald"))
                    || (blockName.contains("diamond"))
                    || (blockName.contains("copper"))
                    || (blockName.contains("lapis"))
                    || (blockName.contains("netherite"))
                    || (blockName.contains("obsidian"))
                    || (blockName.contains("amethyst"))
            )
            {
                this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                //need stone tool
                if ((blockName.contains("iron"))
                        || (blockName.contains("lapis"))
                        || (blockName.contains("copper"))
                )
                {
                    this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                }
                //need iron tool
                else if ((blockName.contains("gold"))
                    || (blockName.contains("emerald"))
                    || (blockName.contains("diamond"))
                )
                {
                    this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                }
                //need diamond tool
                else if ((blockName.contains("netherite"))
                        || (blockName.contains("obsidian"))
                )
                {
                    this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                }
            }
            //mineable with axe
            else if ((blockName.contains("dark_oak"))
                    || (blockName.contains("oak"))
                    || (blockName.contains("birch"))
                    || (blockName.contains("spruce"))
                    || (blockName.contains("jungle"))
                    || (blockName.contains("acacia"))
                    || (blockName.contains("mangrove"))
                    || (blockName.contains("cherry"))
                    || (blockName.contains("crimson"))
                    || (blockName.contains("warped"))
                    || (blockName.contains("bamboo"))
            )
            {
                this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
            }
        }
    }
}
