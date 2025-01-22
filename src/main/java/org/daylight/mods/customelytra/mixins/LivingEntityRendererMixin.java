package org.daylight.mods.customelytra.mixins;

import org.daylight.mods.customelytra.formixins.IHasLayers;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(LivingEntityRenderer.class)
public abstract class LivingEntityRendererMixin<T extends LivingEntity, M extends EntityModel<T>> implements IHasLayers {
    @Shadow @Final
    protected List<RenderLayer<?, ?>> layers;

    public List<RenderLayer<?, ?>> hasLayers$getLayers() {
        return layers;
    }
}
