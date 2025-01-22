package org.daylight.mods.customelytra.mixins;

import net.minecraft.client.model.geom.LayerDefinitions;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LayerDefinitions.class)
public class LayerDefinitionsMixin {
//    @Definition(id = "ELYTRA", field = ModelLayers.ELYTRA)
//    @Expression("ModelLayers.ELYTRA")
//    @ModifyArg(method = "createRoots", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;"), index = 1)
//    private LayerDefinition createRoots(LayerDefinition definition) {
//        return WingsModel.createBodyLayer();
//    }
}