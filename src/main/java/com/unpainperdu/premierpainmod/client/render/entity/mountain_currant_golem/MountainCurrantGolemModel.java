package com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem;

import com.unpainperdu.premierpainmod.PremierPainMod;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MountainCurrantGolemModel extends EntityModel<MountainCurrantGolemRenderState>
{
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "mountain_currant_golem"), "main");
    private final ModelPart body;
    private final ModelPart bodyTop;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart armR;
    private final ModelPart armL;
    private final ModelPart bodyBttom;
    private final ModelPart legR;
    private final ModelPart legL;

    public MountainCurrantGolemModel(ModelPart root)
    {
        super(root);
        this.body = root.getChild("Body");
        this.bodyTop = this.body.getChild("bodyTop");
        this.head = this.bodyTop.getChild("Head");
        this.hat = this.head.getChild("hat");
        this.armR = this.bodyTop.getChild("ArmR");
        this.armL = this.bodyTop.getChild("ArmL");
        this.bodyBttom = this.body.getChild("bodyBttom");
        this.legR = this.body.getChild("LegR");
        this.legL = this.body.getChild("LegL");
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition bodyTop = Body.addOrReplaceChild("bodyTop", CubeListBuilder.create().texOffs(0, 20).addBox(-5.0F, -7.0F, -2.5F, 10.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -41.0F, 0.5F));

        PartDefinition Head = bodyTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(30, 0).addBox(-4.0F, -8.0F, -3.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(24, 40).addBox(-1.0F, -4.0F, -4.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -7.0F, 0.0F));

        PartDefinition hat = Head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(34, 55).addBox(-2.0F, -58.0F, -3.0F, 8.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(22, 48).addBox(-5.0F, -56.0F, -3.0F, 14.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 48.0F, -0.5F));

        PartDefinition cube_r1 = hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(45, 50).addBox(7.0F, 0.001F, -5.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -56.0F, 14.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 50).addBox(7.0F, 0.0F, -5.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -56.0F, 4.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition ArmR = bodyTop.addOrReplaceChild("ArmR", CubeListBuilder.create().texOffs(30, 15).addBox(0.0F, -1.0F, -1.5F, 3.0F, 25.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -3.0F, 0.0F));

        PartDefinition ArmL = bodyTop.addOrReplaceChild("ArmL", CubeListBuilder.create().texOffs(12, 40).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -4.0F, 0.0F));

        PartDefinition bodyBttom = Body.addOrReplaceChild("bodyBttom", CubeListBuilder.create(), PartPose.offset(1.0F, -26.0F, 0.5F));

        PartDefinition bodyBottom_r1 = bodyBttom.addOrReplaceChild("bodyBottom_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -51.0F, -1.0F, 10.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 44.0F, -1.5F, 0.0F, 0.0F, 0.0873F));

        PartDefinition LegR = Body.addOrReplaceChild("LegR", CubeListBuilder.create().texOffs(42, 15).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -18.0F, 0.0F));

        PartDefinition LegL = Body.addOrReplaceChild("LegL", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -18.0F, 1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(MountainCurrantGolemRenderState renderState)
    {
        super.setupAnim(renderState);
        this.applyHeadRotation(renderState.yRot, renderState.xRot);

        this.animateWalk(MountainCurrantGolemAnimation.WALK, renderState.walkAnimationPos, renderState.walkAnimationSpeed, 2F, 2.5F);
        this.animate(renderState.boneMealingAnimationState, MountainCurrantGolemAnimation.BONEMEALING, renderState.ageInTicks, 1F);
    }

    private void applyHeadRotation(float headYaw, float headPitch)
    {
        headYaw = Mth.clamp(headYaw, -45F, 45F);
        headPitch = Mth.clamp(headPitch, -45F, 45F);

        this.head.yRot = headYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
    }
}