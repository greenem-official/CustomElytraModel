package com.example.examplemod.visual;

import com.example.examplemod.ExampleMod;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class WingsLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation WINGS_LOCATION = new ResourceLocation(ExampleMod.MODID, "textures/elytra/wings_texture.png");
    private final WingsModel<T> elytraModel;

    public WingsLayer(RenderLayerParent<T, M> pRenderer, EntityModelSet pModelSet) {
        super(pRenderer);
        this.elytraModel = new WingsModel<>(pModelSet.bakeLayer(WingsModel.LAYER_LOCATION)); // Originally ModelLayers.ELYTRA
    }

    public void render(
            @NotNull PoseStack pPoseStack,
            @NotNull MultiBufferSource pBuffer,
            int pPackedLight,
            T pLivingEntity,
            float pLimbSwing,
            float pLimbSwingAmount,
            float pPartialTicks,
            float pAgeInTicks,
            float pNetHeadYaw,
            float pHeadPitch
    ) {
        ItemStack itemstack = pLivingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if (shouldRender(itemstack, pLivingEntity)) {
            ResourceLocation resourcelocation = getElytraTexture(itemstack, pLivingEntity);

            pPoseStack.pushPose();
            pPoseStack.translate(0.0F, 0.0F, 0.125F);
            this.getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(pLivingEntity, pLimbSwing, pLimbSwingAmount, pAgeInTicks, pNetHeadYaw, pHeadPitch);
            VertexConsumer vertexconsumer = ItemRenderer.getArmorFoilBuffer(
                    pBuffer, RenderType.armorCutoutNoCull(resourcelocation), false, itemstack.hasFoil()
            );
            this.elytraModel.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            pPoseStack.popPose();
        }
    }

    public boolean shouldRender(ItemStack stack, T entity) {
        return stack.getItem() == Items.ELYTRA;
    }

    public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
        return WINGS_LOCATION;
    }
}
