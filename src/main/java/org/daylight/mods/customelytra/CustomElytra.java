package org.daylight.mods.customelytra;

import org.daylight.mods.customelytra.visual.WingsModel;
import com.mojang.logging.LogUtils;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CustomElytra.MODID)
public class CustomElytra
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "customelytra";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public CustomElytra(IEventBus modEventBus)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

//    public static final ModelLayerLocation ELYTRA = ModelLayers.register("elytra");

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
//        @SubscribeEvent
//        public static void onClientSetup(FMLClientSetupEvent event) {
//            // Some client setup code
//        }

        @SubscribeEvent
        public static void registerArmorRenderers(final EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(WingsModel.LAYER_LOCATION, WingsModel::createBodyLayer);
        }

//        @SubscribeEvent
//        public static void onRegisterLayers(EntityRenderersEvent.AddLayers event) {
////            LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getRenderer(EntityType.PLAYER);
//        }

//        @SubscribeEvent
//        public static void onClientTick(TickEvent.ClientTickEvent event) {
//
//        }

//        @SubscribeEvent
//        public static void onServerTick(TickEvent.ServerTickEvent event) {
//
//        }

//        @SubscribeEvent
//        public static void elytraOpen()
    }
}
