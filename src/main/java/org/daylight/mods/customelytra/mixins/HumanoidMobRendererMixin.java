package org.daylight.mods.customelytra.mixins;

import org.daylight.mods.customelytra.formixins.IHasLayers;
import org.daylight.mods.customelytra.visual.WingsLayer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.Mob;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.List;

@Mixin(HumanoidMobRenderer.class)
public abstract class HumanoidMobRendererMixin<T extends Mob, M extends HumanoidModel<T>> { //extends LivingEntityRendererMixin {
    private static final Logger LOGGER = LogUtils.getLogger();

//    @Override
//    public List<RenderLayer<?, ?>> customElytra$getLayers() {
//        return layers;
//    }

//    @Definition(id = "addLayer", method = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;addLayer(Lnet/minecraft/client/renderer/entity/layers/RenderLayer;)Z")
//    @Definition(id = "ElytraLayer", type = ElytraLayer.class)
//    @Expression("addLayer(new ElytraLayer(?, ?))")
////    @WrapMethod()
//    @ModifyExpressionValue(method = "<init>*", at = @At("HEAD")) //, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/LivingEntityRenderer;addLayer(Lnet/minecraft/client/renderer/entity/layers/RenderLayer;)Z"))
//    public void HumanoidMobRenderer(EntityRendererProvider.Context pContext, EntityModel pModel, float pShadowRadius, float pScaleX, float pScaleY, float pScaleZ, @Cancellable CallbackInfo ci) {
//        ci.cancel();
////        addLayer(new ElytraLayer<>(this, pContext.getModelSet()));
//        HumanoidMobRenderer<?, ?> renderer = (HumanoidMobRenderer<?, ?>) (Object) this;
////        renderer.addLayer(new ElytraLayer<?, ?>(renderer, pContext.getModelSet()));
//
////        LocalCapture.
//        ElytraLayer<?, ?> layer = new ElytraLayer<>(renderer, pContext.getModelSet());
//    }

    @Inject(method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lnet/minecraft/client/model/HumanoidModel;FFFF)V", at = @At("TAIL"))
    public void rendererConstructor(EntityRendererProvider.Context pContext, M pModel, float pShadowRadius, float pScaleX, float pScaleY, float pScaleZ, CallbackInfo ci) {

//        LOGGER.info("getViewScale: {}", T.getViewScale());
        HumanoidMobRenderer<T, M> renderer = (HumanoidMobRenderer<T, M>) (Object) this;

//        try {
//            Field field = renderer.getClass().getSuperclass().getSuperclass().getDeclaredField("layers");
//            field.setAccessible(true);
//            List<RenderLayer<?, ?>> layers = (List<RenderLayer<?, ?>>) field.get(renderer);
        List<RenderLayer<?, ?>> layers = ((IHasLayers) this).hasLayers$getLayers(); // ((IHasLayers) this).customElytra$getLayers();

//        layers.removeIf(layer -> layer instanceof ElytraLayer);

        LOGGER.info("Searching for ElytraLayer HUMANOID_MOB_RENDERER");

        Iterator<RenderLayer<?, ?>> iterator = layers.iterator();
        while (iterator.hasNext()) {
            RenderLayer<?, ?> layer = iterator.next();
            if (layer instanceof ElytraLayer) {
                iterator.remove();
                LOGGER.info("Removed ElytraLayer HUMANOID_MOB_RENDERER");
            }
        }

//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }

        renderer.addLayer(new WingsLayer<>(renderer, pContext.getModelSet()));
    }

//    @ModifyArg(method = "<init>(Lnet/minecraft/client/renderer/entity/EntityRendererProvider$Context;Lnet/minecraft/client/model/HumanoidModel;FFFF)V",
//            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/HumanoidMobRenderer;addLayer(Lnet/minecraft/client/renderer/entity/layers/RenderLayer;)Z"))
//    private RenderLayer replaceLayer(RenderLayer layer, EntityRendererProvider.Context pContext) {
//        HumanoidMobRenderer<?, ?> renderer = (HumanoidMobRenderer<?, ?>) (Object) this;
//
//        return new ElytraLayer<>(renderer, pContext.getModelSet());
//    }
}
