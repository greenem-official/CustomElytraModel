package com.example.examplemod.mixins;

import com.example.examplemod.formixins.IHasLayers;
import com.example.examplemod.visual.WingsLayer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(ArmorStandRenderer.class)
public class ArmorStandRendererMixin {
    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "Lnet/minecraft/client/renderer/entity/ArmorStandRenderer;<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;)V", at = @At("TAIL"))
    public void rendererConstructor(EntityRendererProvider.Context p_173915_, CallbackInfo ci) {
        ArmorStandRenderer renderer = (ArmorStandRenderer) (Object) this;

        List<RenderLayer<?, ?>> layers = ((IHasLayers) this).hasLayers$getLayers();

//        layers.removeIf(layer -> layer instanceof ElytraLayer);
        LOGGER.info("Searching for ElytraLayer ARMORSTAND_RENDERER");

        Iterator<RenderLayer<?, ?>> iterator = layers.iterator();
        while (iterator.hasNext()) {
            RenderLayer<?, ?> layer = iterator.next();
            if (layer instanceof ElytraLayer) {
                iterator.remove();
                LOGGER.info("Removed ElytraLayer ARMORSTAND_RENDERER");
            }
        }

        renderer.addLayer(new WingsLayer<>(renderer, p_173915_.getModelSet()));
    }
}
