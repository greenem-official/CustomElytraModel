package com.example.examplemod.visual;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.visual.generated.WingsAnimation;
import com.example.examplemod.visual.generated.WingsModelData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.logging.LogUtils;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;
import org.slf4j.Logger;

public class WingsModel<T extends LivingEntity> extends HierarchicalModel<T> {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "wings_elytra"), "main");

    private final ModelPart root;
    private final ModelPart left_wing;
    private final ModelPart right_wing;

    public AnimationState wingsOpeningState = new AnimationState();
    public AnimationState wingsClosingState = new AnimationState();
    public AnimationState wingsCrouchOpeningState = new AnimationState();
    public AnimationState wingsIdleState = new AnimationState();

    public AnimationState zAnimationState = new AnimationState();
    private int zAnimationStateStartedAt = 0;
    public AnimationState xAnimationState = new AnimationState();
    private int xAnimationStateStartedAt = 0;

    private static AnimationDefinition WINGS_Z_ANIMATION = WingsAnimation.WINGS_OPEN;
    private static AnimationDefinition WINGS_X_ANIMATION = WingsAnimation.WINGS_OPEN;

    private boolean wasFlyingRecently = false;

    public WingsModel(ModelPart root) {
        super(RenderType::entityCutoutNoCull);
        this.root = root;
        this.left_wing = root.getChild("left_wing");
        this.right_wing = root.getChild("right_wing");
//        .getChild("rightwing1");
    }

    public static LayerDefinition createBodyLayer() {
        return WingsModelData.createBodyLayer();
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public @NotNull ModelPart root() {
        return root;
    }

//    @Override
//    protected Iterable<ModelPart> headParts() { return ImmutableList.of(); }
//
//    @Override
//    protected Iterable<ModelPart> bodyParts() { return ImmutableList.of(this.left_wing, this.right_wing); }

//    private static void resetModelPartRecursively(ModelPart modelPart, int i) {
//        LOGGER.info("part {}: {}", i, modelPart);
//        modelPart.getAllParts().forEach(modelPart1 -> resetModelPartRecursively(modelPart, i+1));
//        modelPart.resetPose();
//    }

    private void calculateAbscractElytraAngles(T pEntity) {
        float f = (float) (Math.PI / 12);
        float f1 = (float) (-Math.PI / 12);
        float f2 = 0.0F;
        float f3 = 0.0F;
        if (pEntity.isFallFlying()) {
            float f4 = 1.0F;
            Vec3 vec3 = pEntity.getDeltaMovement();
            if (vec3.y < 0.0) {
                Vec3 vec31 = vec3.normalize();
                f4 = 1.0F - (float)Math.pow(-vec31.y, 1.5);
            }

            f = f4 * (float) (Math.PI / 9) + (1.0F - f4) * f;
            f1 = f4 * (float) (-Math.PI / 2) + (1.0F - f4) * f1;
        } else if (pEntity.isCrouching()) {
            f = (float) (Math.PI * 2.0 / 9.0);
            f1 = (float) (-Math.PI / 4);
            f2 = 3.0F;
            f3 = 0.08726646F;
        }

//        this.leftWing.y = f2;
        if (pEntity instanceof AbstractClientPlayer abstractclientplayer) {
            abstractclientplayer.elytraRotX += (f - abstractclientplayer.elytraRotX) * 0.1F;
            abstractclientplayer.elytraRotY += (f3 - abstractclientplayer.elytraRotY) * 0.1F;
            abstractclientplayer.elytraRotZ += (f1 - abstractclientplayer.elytraRotZ) * 0.1F;

//            LOGGER.info("X {}", abstractclientplayer.elytraRotX);
//            LOGGER.info("Z {}", abstractclientplayer.elytraRotZ);
        }
    }

    private void animateAll1(float pAgeInTicks) {
        this.animate(wingsIdleState, WingsAnimation.WINGS_IDLE, pAgeInTicks);
        this.animate(wingsOpeningState, WingsAnimation.WINGS_OPEN, pAgeInTicks);
        this.animate(wingsClosingState, WingsAnimation.WINGS_CLOSE, pAgeInTicks);
        this.animate(wingsCrouchOpeningState, WingsAnimation.WINGS_CROUCH, pAgeInTicks, 1F);
    }

    private void animateAll3(float pAgeInTicks) {
        this.animate(wingsIdleState, WingsAnimation.WINGS_IDLE, pAgeInTicks);
    }

    private void toggleAllStates1(T pEntity, float pAgeInTicks) {
        wingsIdleState.startIfStopped((int) pAgeInTicks); // always

        if (pEntity.isFallFlying()) {
            wingsClosingState.stop();
            if(!wingsOpeningState.isStarted()) {
                wingsCrouchOpeningState.stop();
                LOGGER.info("starting OPEN");
            }
            wingsOpeningState.startIfStopped((int) pAgeInTicks);
            wasFlyingRecently = true;
        } else if (!pEntity.isCrouching()) {
            wingsOpeningState.stop();
            wingsCrouchOpeningState.stop();
            if(!wingsClosingState.isStarted() && wasFlyingRecently) {
                LOGGER.info("starting CLOSE");
                wingsClosingState.start((int) pAgeInTicks);
                wasFlyingRecently = false;
            }

        }

        if(pEntity.isCrouching()) {
            if(!pEntity.isFallFlying()) {
                wingsClosingState.stop();
                if(!wingsCrouchOpeningState.isStarted()) {
                    wingsOpeningState.stop();
                    LOGGER.info("starting OPEN CROUCH");
                }
                wingsCrouchOpeningState.startIfStopped((int) pAgeInTicks);
            }
        }
    }

    private void toggleAllStates2(T pEntity, float pAgeInTicks) {
        wingsIdleState.startIfStopped((int) pAgeInTicks); // always
    }

    private void toggleAllStates3(T pEntity, float pAgeInTicks) {
        wingsIdleState.startIfStopped((int) pAgeInTicks); // always
        if(!zAnimationState.isStarted()) {
            zAnimationState.start((int) pAgeInTicks); // vanilla, always
            zAnimationStateStartedAt = (int) pAgeInTicks;
        }
        if(!xAnimationState.isStarted()) {
            xAnimationState.start((int) pAgeInTicks); // vanilla, always
            xAnimationStateStartedAt = (int) pAgeInTicks;
        }
    }

    private void animateWithVanillaNumbers2(T pEntity) {
        if (pEntity instanceof AbstractClientPlayer abstractclientplayer) {
            this.left_wing.xRot = abstractclientplayer.elytraRotX;
//            this.left_wing.yRot = abstractclientplayer.elytraRotY;
            this.left_wing.zRot = abstractclientplayer.elytraRotZ;

            this.right_wing.yRot = -this.left_wing.yRot;
//            this.right_wing.xRot = this.left_wing.xRot;
            this.right_wing.zRot = -this.left_wing.zRot;
        }
    }

    private double testMin = Double.MAX_VALUE;
    private double testMax = -Double.MAX_VALUE;

    private void setTestMin(double value) {
        if(value < testMin) testMin = value;
    }

    private void setTestMax(double value) {
        if(value > testMax) testMax = value;
    }

    private void animateWithVanillaNumbers3(T pEntity, float pAgeInTicks) {
        double minZ = -1.5707958;
        double maxZ = -Math.PI / 120;

        double minX = Math.PI / 120;
        double maxX = 0.6981314420700073;

        double zProportion = 0.5;
        double xProportion = 0.5;


        if (pEntity instanceof AbstractClientPlayer abstractclientplayer) {
//            setTestMin(abstractclientplayer.elytraRotZ);
//            setTestMax(abstractclientplayer.elytraRotZ);
//            LOGGER.info("{} - {}", testMin, testMax);

            zProportion = 1 - org.joml.Math.clamp(0, 1, (abstractclientplayer.elytraRotZ - minZ) / (maxZ - minZ));
            xProportion = 1 - org.joml.Math.clamp(0, 1, (abstractclientplayer.elytraRotX - minX) / (maxX - minX));

//            LOGGER.info("Z {}, {}", abstractclientplayer.elytraRotZ, 1 - (abstractclientplayer.elytraRotZ - min) / (max - min));
        }

        float zTicks = (float) (zProportion * WINGS_Z_ANIMATION.lengthInSeconds() * 20);
//        float xTicks = (float) (xProportion * WINGS_X_ANIMATION.lengthInSeconds() * 20);

//        LOGGER.info("{}, zProportion {} | {}", alwaysActiveState.isStarted(), zProportion, zTicks);

        this.animate(zAnimationState, WINGS_Z_ANIMATION, (float) zAnimationStateStartedAt + zTicks); // Z Animation
//        this.animate(xAnimationState, WINGS_X_ANIMATION, (float) xAnimationStateStartedAt + xTicks); // X Animation
    }

    private void lowerModeOnShift(T pEntity) {
        if(pEntity.isCrouching()) {
            // f2
            root().getAllParts().forEach(modelPart -> {
                modelPart.offsetPos(new Vector3f(0, 3.0F, 0));
            });
        }
    }

    @Override
    public void setupAnim(@NotNull T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        root().getAllParts().forEach(ModelPart::resetPose);
        //resetModelPartRecursively(root(), 0);

        calculateAbscractElytraAngles(pEntity);
        toggleAllStates3(pEntity, pAgeInTicks);
        animateWithVanillaNumbers3(pEntity, pAgeInTicks);
        animateAll3(pAgeInTicks);

        lowerModeOnShift(pEntity);
    }
}