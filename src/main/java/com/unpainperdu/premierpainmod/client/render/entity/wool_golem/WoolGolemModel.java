package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.WoolGolemEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class WoolGolemModel extends HierarchicalModel<WoolGolemEntity>
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "wool_golem"), "main");
    private final ModelPart Body;
    private final ModelPart bodyTop;
    private final ModelPart Head;
    private final ModelPart noise;
    private final ModelPart ArmR;
    private final ModelPart upAR;
    private final ModelPart bottomAR;
    private final ModelPart ArmL;
    private final ModelPart upAL;
    private final ModelPart bottomAL;
    private final ModelPart bodyBttom;
    private final ModelPart LegR;
    private final ModelPart LegL;

    public WoolGolemModel(ModelPart root) {
        this.Body = root.getChild("Body");
        this.bodyTop = this.Body.getChild("bodyTop");
        this.Head = this.bodyTop.getChild("Head");
        this.noise = this.Head.getChild("noise");
        this.ArmR = this.bodyTop.getChild("ArmR");
        this.upAR = this.ArmR.getChild("upAR");
        this.bottomAR = this.ArmR.getChild("bottomAR");
        this.ArmL = this.bodyTop.getChild("ArmL");
        this.upAL = this.ArmL.getChild("upAL");
        this.bottomAL = this.ArmL.getChild("bottomAL");
        this.bodyBttom = this.Body.getChild("bodyBttom");
        this.LegR = this.Body.getChild("LegR");
        this.LegL = this.Body.getChild("LegL");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bodyTop = Body.addOrReplaceChild("bodyTop", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -15.0F, -6.5F, 28.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 0.5F));

        PartDefinition Head = bodyTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 110).addBox(-11.0F, -11.0F, -3.5F, 22.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));

        PartDefinition noise = Head.addOrReplaceChild("noise", CubeListBuilder.create().texOffs(102, 103).addBox(-4.0F, -2.0F, -4.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

        PartDefinition ArmR = bodyTop.addOrReplaceChild("ArmR", CubeListBuilder.create(), PartPose.offset(13.0F, -10.0F, 0.0F));

        PartDefinition upAR = ArmR.addOrReplaceChild("upAR", CubeListBuilder.create().texOffs(64, 76).addBox(2.0F, -4.0F, -4.5F, 7.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

        PartDefinition bottomAR = ArmR.addOrReplaceChild("bottomAR", CubeListBuilder.create().texOffs(32, 56).addBox(-1.0F, 0.0F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 6.0F, 0.0F));

        PartDefinition ArmL = bodyTop.addOrReplaceChild("ArmL", CubeListBuilder.create(), PartPose.offset(-13.0F, -10.0F, 0.0F));

        PartDefinition upAL = ArmL.addOrReplaceChild("upAL", CubeListBuilder.create().texOffs(64, 56).addBox(-17.0F, 10.0F, -4.5F, 7.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -15.0F, 0.0F));

        PartDefinition bottomAL = ArmL.addOrReplaceChild("bottomAL", CubeListBuilder.create().texOffs(0, 56).addBox(-6.0F, 0.0F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.0F, 0.0F));

        PartDefinition bodyBttom = Body.addOrReplaceChild("bodyBttom", CubeListBuilder.create().texOffs(0, 28).addBox(-14.0F, -7.0F, -6.5F, 28.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.5F));

        PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(82, 18).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, 0.0F));

        PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(82, 28).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }


    @Override
    public void setupAnim(WoolGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animateWalk(WoolGolemAnimation.WALK, limbSwing, limbSwingAmount, 2F, 2.5F);
        this.animate(entity.HUG, WoolGolemAnimation.HUG, ageInTicks, 1F);
        this.animate(entity.SIT, WoolGolemAnimation.SIT, ageInTicks, 1F);
        this.animate(entity.GETUP, WoolGolemAnimation.GETUP, ageInTicks, 1F);
    }

    private void applyHeadRotation(float headYaw, float headPitch)
    {
        headYaw = Mth.clamp(headYaw, -45F, 45F);
        headPitch = Mth.clamp(headPitch, -45F, 45F);

        this.Head.yRot = headYaw * ((float) Math.PI / 180F);
        this.Head.xRot = headPitch * ((float) Math.PI / 180F);
    }

    @Override
    public @NotNull ModelPart root()
    {
        return this.Body;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color)
    {
        this.Body.render(poseStack, buffer, packedLight, packedOverlay, color);
    }
}
