package com.pervll.creator.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.monster.Alaif;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class AlaifModel<Type extends Alaif> extends EntityModel<Type> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            new ResourceLocation(Creator.MOD_ID, "alaif"), "main");

    private final ModelPart body;

    public AlaifModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-5.0F, -8.0F, -7.0F, 10.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        body.addOrReplaceChild("legs",
                CubeListBuilder.create().texOffs(26, 27)
                        .addBox(5.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(17, 27)
                        .addBox(-7.0F, -3.0F, -6.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-7.0F, -3.0F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
                        .addBox(5.0F, -3.0F, 4.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("head",
                CubeListBuilder.create().texOffs(0, 22)
                        .addBox(-2.0F, -10.0F, -11.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(17, 22)
                        .addBox(-2.0F, -11.0F, -11.0F, 4.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(13, 22)
                        .addBox(-1.0F, -11.0F, -8.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 30)
                        .addBox(1.0F, -12.0F, -8.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 30)
                        .addBox(-3.0F, -12.0F, -8.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
                          float headPitch) {}

    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        this.body.render(poseStack, buffer, packedLight, packedOverlay);
    }
}
