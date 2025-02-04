package com.unpainperdu.premierpainmod.client.util.register;

import com.unpainperdu.premierpainmod.client.particle.beer_particle.blond.BlondBeerFoamProvider;
import com.unpainperdu.premierpainmod.client.render.FluidRender;
import com.unpainperdu.premierpainmod.util.register.ParticleTypeRegister;
import com.unpainperdu.premierpainmod.util.register.fluid.FluidTypeRegister;
import com.unpainperdu.premierpainmod.util.type.ModWoodTypes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientRegisterHandler
{
    @FunctionalInterface
    public interface BlockRendererRegistry
    {
        <T extends BlockEntity> void register(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> factory);
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        BlockEntityRenderRegister.onRegisterBlockRenderers(new BlockRendererRegistry()
        {
            @Override
            public <T extends BlockEntity> void register(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> factory)
            {
                event.registerBlockEntityRenderer(type, factory);
            }
        });
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        Sheets.addWoodType(ModWoodTypes.MOUNTAIN_CURRANT);
        event.enqueueWork(() ->  FluidRender.setRenderLayerForFluid(event));
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event)
    {
        event.registerFluidType(FluidTypeRegister.PAIN_DIEUX_TYPE.get().register(), FluidTypeRegister.PAIN_DIEUX_TYPE.get());
        event.registerFluidType(FluidTypeRegister.LA_CHATEAU_TYPE.get().register(), FluidTypeRegister.LA_CHATEAU_TYPE.get());
        event.registerFluidType(FluidTypeRegister.DEBIER_TYPE.get().register(), FluidTypeRegister.DEBIER_TYPE.get());
        event.registerFluidType(FluidTypeRegister.ENVAHISSEUR_ROUGE_TYPE.get().register(), FluidTypeRegister.ENVAHISSEUR_ROUGE_TYPE.get());
        event.registerFluidType(FluidTypeRegister.RASPBUISSON_TYPE.get().register(), FluidTypeRegister.RASPBUISSON_TYPE.get());
        event.registerFluidType(FluidTypeRegister.LA_BLANCHE_CITADINE_TYPE.get().register(), FluidTypeRegister.LA_BLANCHE_CITADINE_TYPE.get());
        event.registerFluidType(FluidTypeRegister.CRANE_NOIR_TYPE.get().register(), FluidTypeRegister.CRANE_NOIR_TYPE.get());
        event.registerFluidType(FluidTypeRegister.TAK_TYPE.get().register(), FluidTypeRegister.TAK_TYPE.get());
        event.registerFluidType(FluidTypeRegister.DISENDER_TYPE.get().register(), FluidTypeRegister.DISENDER_TYPE.get());
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event)
    {
        // There are multiple ways to register providers, all differing in the functional type they provide in the
        // second parameter. For example, #registerSpriteSet represents a Function<SpriteSet, ParticleProvider<?>>:
        event.registerSpriteSet(ParticleTypeRegister.BLOND_BEER_FOAM.get(), BlondBeerFoamProvider::new);
        // Other methods include #registerSprite, which is essentially a Supplier<TextureSheetParticle>,
        // and #registerSpecial, which maps to a Supplier<Particle>. See the source code of the event for further info.
    }
}
