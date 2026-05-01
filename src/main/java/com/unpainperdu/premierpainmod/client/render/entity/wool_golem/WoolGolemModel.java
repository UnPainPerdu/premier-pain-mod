package com.unpainperdu.premierpainmod.client.render.entity.wool_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WoolGolemModel extends EntityModel<WoolGolemRenderState>
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "wool_golem"), "main");

    private final ModelPart head;

    public WoolGolemModel(ModelPart root)
    {
        super(root);
        ModelPart body = root.getChild("Body");
        ModelPart bodyTop = body.getChild("bodyTop");
        this.head = bodyTop.getChild("Head");
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bodyTop = Body.addOrReplaceChild("bodyTop", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -15.0F, -6.5F, 28.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, 0.5F));

        PartDefinition Head = bodyTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 110).addBox(-11.0F, -11.0F, -3.5F, 22.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 0.0F));

        Head.addOrReplaceChild("noise", CubeListBuilder.create().texOffs(102, 103).addBox(-4.0F, -2.0F, -4.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

        PartDefinition ArmR = bodyTop.addOrReplaceChild("ArmR", CubeListBuilder.create(), PartPose.offset(13.0F, -10.0F, 0.0F));

        ArmR.addOrReplaceChild("upAR", CubeListBuilder.create().texOffs(64, 76).addBox(2.0F, -4.0F, -4.5F, 7.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -1.0F, 0.0F));

        ArmR.addOrReplaceChild("bottomAR", CubeListBuilder.create().texOffs(32, 56).addBox(-1.0F, 0.0F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 6.0F, 0.0F));

        PartDefinition ArmL = bodyTop.addOrReplaceChild("ArmL", CubeListBuilder.create(), PartPose.offset(-13.0F, -10.0F, 0.0F));

        ArmL.addOrReplaceChild("upAL", CubeListBuilder.create().texOffs(64, 56).addBox(-17.0F, 10.0F, -4.5F, 7.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -15.0F, 0.0F));

        ArmL.addOrReplaceChild("bottomAL", CubeListBuilder.create().texOffs(0, 56).addBox(-6.0F, 0.0F, -4.5F, 7.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 6.0F, 0.0F));

        Body.addOrReplaceChild("bodyBttom", CubeListBuilder.create().texOffs(0, 28).addBox(-14.0F, -7.0F, -6.5F, 28.0F, 15.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.5F));

        Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(82, 18).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, -5.0F, 0.0F));

        Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(82, 28).addBox(-2.5F, 0.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.5F, -5.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(WoolGolemRenderState renderState)
    {
        super.setupAnim(renderState);
        this.applyHeadRotation(renderState.yRot, renderState.xRot);

        this.animateWalk(WoolGolemAnimation.WALK, renderState.walkAnimationPos, renderState.walkAnimationSpeed, 2F, 2.5F);
        this.animate(renderState.HUG, WoolGolemAnimation.HUG, renderState.ageInTicks, 1F);
        this.animate(renderState.SIT, WoolGolemAnimation.SIT, renderState.ageInTicks, 1F);
        this.animate(renderState.GETUP, WoolGolemAnimation.GETUP, renderState.ageInTicks, 1F);
    }

    private void applyHeadRotation(float headYaw, float headPitch)
    {
        headYaw = Mth.clamp(headYaw, -45F, 45F);
        headPitch = Mth.clamp(headPitch, -45F, 45F);

        this.head.yRot = headYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
    }
}