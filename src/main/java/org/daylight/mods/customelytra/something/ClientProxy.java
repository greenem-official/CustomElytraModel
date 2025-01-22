package org.daylight.mods.customelytra.something;

import org.daylight.mods.customelytra.visual.WingsLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.stream.Stream;

public class ClientProxy {
    public void init(IEventBus eventBus) {
        eventBus.addListener(this::setup);

        eventBus.<FMLClientSetupEvent>addListener(e -> {
            e.enqueueWork(() -> {
                Minecraft mc = Minecraft.getInstance();
                EntityRenderDispatcher manager = mc.getEntityRenderDispatcher();
                Stream.concat(manager.getSkinMap().values().stream(), manager.renderers.values().stream())
                        .filter(LivingEntityRenderer.class::isInstance)
                        .map(r -> (LivingEntityRenderer<?, ?>) r)
                        .filter(render -> render.getModel() instanceof PlayerModel<?>) // HumanoidModel<?> || render.getModel() instanceof PlayerModel<?> || render.getModel() instanceof ArmorStandModel)
                        .unordered()
                        .distinct()
                        .forEach(render -> {
//                            ModelPart body = ((PlayerModel<?>) render.getModel()).body;
                            @SuppressWarnings("unchecked") LivingEntityRenderer<LivingEntity, PlayerModel<LivingEntity>> livingRender = (LivingEntityRenderer<LivingEntity, PlayerModel<LivingEntity>>) render;
                            livingRender.addLayer(new WingsLayer<>(livingRender, Minecraft.getInstance().getEntityModels()));
                        });
            });
        });
    }

    protected void setup(FMLCommonSetupEvent event) {

    }
}
