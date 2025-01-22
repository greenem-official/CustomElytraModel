package com.example.examplemod.formixins;

import net.minecraft.client.renderer.entity.layers.RenderLayer;

import java.util.List;

public interface IHasLayers {
    List<RenderLayer<?, ?>> hasLayers$getLayers();
}
