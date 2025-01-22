package org.daylight.mods.customelytra.visual.generated;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WingsModelData {
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r1 = left_wing.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(37.8022F, -0.25F, 4.2842F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(51.8022F, -0.25F, 6.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(48.8022F, -0.25F, 5.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 6.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 5.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 3.2842F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 2.2842F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 1.2842F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, 0.2842F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -0.7158F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -1.7158F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -2.7158F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -3.7158F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -4.7158F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(37.8022F, -0.25F, -5.7158F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 5.2842F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 0.2842F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(31.8022F, -0.25F, 3.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 5.2842F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 5.2842F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(36.8022F, -0.25F, 6.2842F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(34.8022F, -0.25F, 5.2842F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(33.8022F, -0.25F, 4.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(28.8022F, -0.25F, 2.2842F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 2.2842F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(23.8022F, -0.25F, 0.2842F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(25.8022F, -0.25F, -1.7158F, 11.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(29.8022F, -0.25F, -3.7158F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(33.8022F, -0.25F, -5.7158F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(31.8022F, -0.25F, -4.7158F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(21.1978F, -0.25F, 4.2842F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(17.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(13.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(20.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(14.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(16.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(18.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(15.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(11.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(9.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(19.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(12.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(21.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(9.8022F, -1.25F, -0.7158F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(22.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(10.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(20.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1978F, -9.75F, 0.7158F, -1.5708F, 0.0F, 1.5708F));

        PartDefinition cube_r2 = left_wing.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-51.4417F, -0.25F, 25.9718F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-49.4754F, -1.25F, 26.0366F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1978F, -9.75F, 0.7158F, -1.5708F, 0.0F, -0.9599F));

        PartDefinition cube_r3 = left_wing.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0147F, -0.25F, 36.7616F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.9954F, -1.25F, 36.467F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.0375F, -1.25F, 21.5953F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.0204F, -0.25F, 22.3342F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1978F, -9.75F, 0.7158F, -1.5708F, 0.0F, -0.1309F));

        PartDefinition cube_r4 = left_wing.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(6.4056F, -0.25F, -37.4276F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1978F, -9.75F, 0.7158F, -1.5708F, 0.0F, 2.7053F));

        PartDefinition cube_r5 = left_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(20.2067F, -1.25F, 10.1494F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1978F, -9.75F, 0.7158F, -1.5708F, 0.0F, 1.0908F));

        PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r6 = right_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-53.8022F, -0.25F, 4.2842F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-55.8022F, -0.25F, 6.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-54.8022F, -0.25F, 5.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-41.8022F, -0.25F, 6.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-43.8022F, -0.25F, 5.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-51.8022F, -0.25F, 3.2842F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-50.8022F, -0.25F, 2.2842F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-48.8022F, -0.25F, 1.2842F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-47.8022F, -0.25F, 0.2842F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-46.8022F, -0.25F, -0.7158F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-44.8022F, -0.25F, -1.7158F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-43.8022F, -0.25F, -2.7158F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-42.8022F, -0.25F, -3.7158F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-39.8022F, -0.25F, -5.7158F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-40.8022F, -0.25F, -4.7158F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-25.8022F, -0.25F, 5.2842F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 0.2842F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 3.2842F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-24.8022F, -0.25F, 5.2842F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-26.8022F, -0.25F, 5.2842F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 6.2842F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 5.2842F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 4.2842F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 2.2842F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-28.8022F, -0.25F, 2.2842F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-37.8022F, -0.25F, 0.2842F, 14.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-36.8022F, -0.25F, -1.7158F, 11.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-36.8022F, -0.25F, -3.7158F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-36.8022F, -0.25F, -5.7158F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-36.8022F, -0.25F, -4.7158F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-11.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-17.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-18.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-14.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-21.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-15.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-19.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-16.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-12.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-20.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-13.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-22.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-23.8022F, -1.25F, -0.7158F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-23.8022F, -0.25F, 1.2842F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8022F, -9.75F, 0.7158F, -1.5708F, 0.0F, -1.5708F));

        PartDefinition cube_r7 = right_wing.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(48.4417F, -0.25F, 25.9718F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(25.4754F, -1.25F, 26.0366F, 24.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8022F, -9.75F, 0.7158F, -1.5708F, 0.0F, 0.9599F));

        PartDefinition cube_r8 = right_wing.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(11.0147F, -0.25F, 36.7616F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-2.0046F, -1.25F, 36.467F, 15.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(3.0375F, -1.25F, 21.5953F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(10.0204F, -0.25F, 22.3342F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8022F, -9.75F, 0.7158F, -1.5708F, 0.0F, 0.1309F));

        PartDefinition cube_r9 = right_wing.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-9.4056F, -0.25F, -37.4276F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8022F, -9.75F, 0.7158F, -1.5708F, 0.0F, -2.7053F));

        PartDefinition cube_r10 = right_wing.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-36.2067F, -1.25F, 10.1494F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8022F, -9.75F, 0.7158F, -1.5708F, 0.0F, -1.0908F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
