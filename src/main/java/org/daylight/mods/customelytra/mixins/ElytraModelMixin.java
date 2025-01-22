package org.daylight.mods.customelytra.mixins;

import net.minecraft.client.model.ElytraModel;
import com.mojang.logging.LogUtils;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//@Mixin(ElytraModel.class)
public class ElytraModelMixin {
    private static final Logger LOGGER = LogUtils.getLogger();
    private ModelPart leftWing;
    private ModelPart rightWing;

//    @Redirect(method = "<init>", at = @At(value = "HEAD"))
    public void ElytraModel(ModelPart pRoot, CallbackInfo cir) {
//        ElytraModel model = (ElytraModel) (Object) this;
//
//        this.leftWing = pRoot.getChild("left_wing");
//        this.rightWing = pRoot.getChild("right_wing");
//
//        try {
//            Field f1 = model.getClass().getDeclaredField("leftWing");
//            f1.setAccessible(true);
//            f1.set(model, this.leftWing);
//
//            Field f2 = model.getClass().getDeclaredField("rightWing");
//            f2.setAccessible(true);
//            f2.set(model, this.rightWing);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }

    }

//    @Inject(method = "Lnet/minecraft/client/model/ElytraModel;createLayer()Lnet/minecraft/client/model/geom/builders/LayerDefinition;", at = @At(value = "HEAD"))
    public void createLayer(CallbackInfoReturnable<LayerDefinition> ci) {
        ElytraModel model = (ElytraModel) (Object) this;

        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        CubeDeformation cubedeformation = new CubeDeformation(1.0F);
        partdefinition.addOrReplaceChild(
                "left_wing",
                CubeListBuilder.create().texOffs(22, 0).addBox(-10.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, cubedeformation),
                PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, (float) (Math.PI / 12), 0.0F, (float) (-Math.PI / 12))
        );
        partdefinition.addOrReplaceChild(
                "right_wing",
                CubeListBuilder.create().texOffs(22, 0).mirror().addBox(0.0F, 0.0F, 0.0F, 10.0F, 20.0F, 2.0F, cubedeformation),
                PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, (float) (Math.PI / 12), 0.0F, (float) (Math.PI / 12))
        );

        ci.setReturnValue(LayerDefinition.create(meshdefinition, 64, 32));
    }
}
