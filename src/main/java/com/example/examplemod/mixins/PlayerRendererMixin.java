package com.example.examplemod.mixins;

import com.example.examplemod.formixins.IHasLayers;
import com.example.examplemod.visual.WingsLayer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(PlayerRenderer.class)
public class PlayerRendererMixin {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "Lnet/minecraft/client/renderer/entity/player/PlayerRenderer;<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Z)V", at = @At("TAIL"))
    public void rendererConstructor(EntityRendererProvider.Context pContext, boolean pUseSlimModel, CallbackInfo ci) {
        PlayerRenderer renderer = (PlayerRenderer) (Object) this;

        List<RenderLayer<?, ?>> layers = ((IHasLayers) this).hasLayers$getLayers();

//        layers.removeIf(layer -> layer instanceof ElytraLayer);
        LOGGER.info("Searching for ElytraLayer PLAYER_RENDERER");

        Iterator<RenderLayer<?, ?>> iterator = layers.iterator();
        while (iterator.hasNext()) {
            RenderLayer<?, ?> layer = iterator.next();
            if (layer instanceof ElytraLayer) {
                iterator.remove();
                LOGGER.info("Removed ElytraLayer PLAYER_RENDERER");
            }
        }

        renderer.addLayer(new WingsLayer<>(renderer, pContext.getModelSet()));
    }
}
