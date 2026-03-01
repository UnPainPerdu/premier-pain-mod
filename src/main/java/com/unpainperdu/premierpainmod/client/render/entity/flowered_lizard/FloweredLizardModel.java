package com.unpainperdu.premierpainmod.client.render.entity.flowered_lizard;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.unpainperdu.premierpainmod.PremierPainMod;
import com.unpainperdu.premierpainmod.client.render.entity.mountain_currant_golem.MountainCurrantGolemAnimation;
import com.unpainperdu.premierpainmod.level.world.entity.mobs.FloweredLizardEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

public class FloweredLizardModel extends HierarchicalModel<FloweredLizardEntity>
{
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(PremierPainMod.MOD_ID, "flowered_lizard"), "main");
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart bottom;
    private final ModelPart leg;
    private final ModelPart leftLeg;
    private final ModelPart leftMiddleLeg;
    private final ModelPart leftFoot;
    private final ModelPart rightLeg;
    private final ModelPart rightMiddleLeg;
    private final ModelPart rightfoot;
    private final ModelPart up;
    private final ModelPart head;
    private final ModelPart mouth;
    private final ModelPart jaw;
    private final ModelPart arm;
    private final ModelPart leftArm;
    private final ModelPart middleLeftArm;
    private final ModelPart leftHand;
    private final ModelPart rightArm;
    private final ModelPart middleRightArm;
    private final ModelPart rightHand;
    private final ModelPart torso;
    private final ModelPart tail;
    private final ModelPart middleTail;
    private final ModelPart endTail;
    private final ModelPart neck;

    public FloweredLizardModel(ModelPart root)
    {
        this.root = root;
        this.body = root.getChild("body");
        this.bottom = this.body.getChild("bottom");
        this.leg = this.bottom.getChild("leg");
        this.leftLeg = this.leg.getChild("leftLeg");
        this.leftMiddleLeg = this.leftLeg.getChild("leftMiddleLeg");
        this.leftFoot = this.leftMiddleLeg.getChild("leftFoot");
        this.rightLeg = this.leg.getChild("rightLeg");
        this.rightMiddleLeg = this.rightLeg.getChild("rightMiddleLeg");
        this.rightfoot = this.rightMiddleLeg.getChild("rightfoot");
        this.up = this.body.getChild("up");
        this.head = this.up.getChild("head");
        this.mouth = this.head.getChild("mouth");
        this.jaw = this.mouth.getChild("jaw");
        this.arm = this.up.getChild("arm");
        this.leftArm = this.arm.getChild("leftArm");
        this.middleLeftArm = this.leftArm.getChild("middleLeftArm");
        this.leftHand = this.middleLeftArm.getChild("leftHand");
        this.rightArm = this.arm.getChild("rightArm");
        this.middleRightArm = this.rightArm.getChild("middleRightArm");
        this.rightHand = this.middleRightArm.getChild("rightHand");
        this.torso = this.up.getChild("torso");
        this.tail = this.up.getChild("tail");
        this.middleTail = this.tail.getChild("middleTail");
        this.endTail = this.middleTail.getChild("endTail");
        this.neck = this.up.getChild("neck");
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition bottom = body.addOrReplaceChild("bottom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg = bottom.addOrReplaceChild("leg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leftLeg = leg.addOrReplaceChild("leftLeg", CubeListBuilder.create(), PartPose.offset(4.0F, -12.0F, 0.5F));

        PartDefinition cube_r1 = leftLeg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 11).addBox(-1.0F, -7.0F, -1.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.125F, 1.375F, -2.1875F, 0.0F, 0.0F, 1.1868F));

        PartDefinition leftMiddleLeg = leftLeg.addOrReplaceChild("leftMiddleLeg", CubeListBuilder.create(), PartPose.offset(-2.125F, 3.5F, 0.0F));

        PartDefinition cube_r2 = leftMiddleLeg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(10, 56).addBox(0.0F, -6.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(58, 57).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.875F, -2.25F, 0.0F, 0.0F, -0.384F));

        PartDefinition leftFoot = leftMiddleLeg.addOrReplaceChild("leftFoot", CubeListBuilder.create().texOffs(52, 59).addBox(0.1051F, 0.0F, -1.0692F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 5.5F, -2.3125F, 0.0F, -0.0698F, 0.0F));

        PartDefinition cube_r3 = leftFoot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 57).addBox(-2.9751F, -1.0F, -1.0573F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3551F, 3.0625F, 0.9308F, 0.0F, 0.48F, 0.0F));

        PartDefinition cube_r4 = leftFoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 40).addBox(-3.9989F, -1.0F, -1.0625F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2301F, 3.0F, 0.5558F, 0.0F, 0.0873F, 0.0F));

        PartDefinition cube_r5 = leftFoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 8).addBox(-3.0254F, -1.0F, -1.0571F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0824F, 3.0625F, 0.1183F, 0.0F, -0.3491F, 0.0F));

        PartDefinition rightLeg = leg.addOrReplaceChild("rightLeg", CubeListBuilder.create(), PartPose.offset(4.0F, -12.0F, 0.5F));

        PartDefinition cube_r6 = rightLeg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(52, 19).addBox(-1.0F, -7.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.125F, 1.375F, 3.1875F, 0.0F, 0.0F, 1.1868F));

        PartDefinition rightMiddleLeg = rightLeg.addOrReplaceChild("rightMiddleLeg", CubeListBuilder.create(), PartPose.offset(-2.4375F, 3.375F, 0.0F));

        PartDefinition cube_r7 = rightMiddleLeg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(56, 49).addBox(0.0F, -6.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(38, 59).addBox(0.0F, -3.0F, -2.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3125F, 6.0F, 3.125F, 0.0F, 0.0F, -0.384F));

        PartDefinition rightfoot = rightMiddleLeg.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(18, 60).addBox(0.1226F, 0.0F, -1.8198F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0625F, 5.625F, 2.8125F, 0.0F, -0.0698F, 0.0F));

        PartDefinition cube_r8 = rightfoot.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 58).addBox(-2.9751F, -1.0F, -1.0573F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4976F, 3.0625F, 0.1802F, 0.0F, 0.48F, 0.0F));

        PartDefinition cube_r9 = rightfoot.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(52, 27).addBox(-3.9989F, -1.0F, -1.0625F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3726F, 3.0F, -0.1948F, 0.0F, 0.0873F, 0.0F));

        PartDefinition cube_r10 = rightfoot.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 57).addBox(-3.0254F, -1.0F, -1.0571F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0601F, 3.0625F, -0.6323F, 0.0F, -0.3491F, 0.0F));

        PartDefinition up = body.addOrReplaceChild("up", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = up.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 22).addBox(-3.0F, -5.0F, -2.5875F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -23.0F, 0.5625F));

        PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -16.0F, -3.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, -5.0875F, 0.0F, 0.0F, 0.3054F));

        PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create().texOffs(40, 42).addBox(-19.0F, -27.0F, -2.025F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(10.0F, 23.0F, -0.5625F));

        PartDefinition jaw = mouth.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 47).addBox(-6.0F, -1.0F, -2.525F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -24.0F, 0.5F));

        PartDefinition arm = up.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.offset(-6.0F, -15.0F, 0.5F));

        PartDefinition leftArm = arm.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(22, 53).addBox(-1.0F, -1.0F, -3.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

        PartDefinition middleLeftArm = leftArm.addOrReplaceChild("middleLeftArm", CubeListBuilder.create().texOffs(0, 54).addBox(-3.0F, 0.0F, -0.9875F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -2.5F));

        PartDefinition cube_r12 = middleLeftArm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(44, 59).addBox(-1.7845F, -1.4505F, -3.9875F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3405F, 2.388F, 3.05F, 0.0F, 0.0F, -0.5672F));

        PartDefinition leftHand = middleLeftArm.addOrReplaceChild("leftHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.625F, 2.3125F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r13 = leftHand.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(10, 54).addBox(-5.6074F, -4.4401F, 0.0852F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, 3.0F, 1.5708F, -0.0175F, -0.5672F));

        PartDefinition cube_r14 = leftHand.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(56, 4).addBox(-5.4869F, -2.4589F, 0.0852F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, 3.0F, 1.5708F, 0.0175F, -0.5672F));

        PartDefinition cube_r15 = leftHand.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(61, 33).addBox(-6.5298F, -3.45F, 0.0852F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, 3.0F, 1.5708F, 0.0F, -0.5672F));

        PartDefinition rightArm = arm.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(30, 53).addBox(-1.0F, -1.0F, 1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition middleRightArm = rightArm.addOrReplaceChild("middleRightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, 0.0F, -0.9875F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 2.5F));

        PartDefinition cube_r16 = middleRightArm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 60).addBox(-1.7845F, -1.4505F, 2.0125F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3405F, 2.388F, -3.025F, 0.0F, 0.0F, -0.5672F));

        PartDefinition rightHand = middleRightArm.addOrReplaceChild("rightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.625F, 2.3125F, 0.0F, 0.0F, 0.0F, -0.3491F));

        PartDefinition cube_r17 = rightHand.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(50, 55).addBox(-5.504F, 1.484F, 0.0852F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, -3.0F, 1.5708F, -0.0175F, -0.5672F));

        PartDefinition cube_r18 = rightHand.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 6).addBox(-5.5903F, 3.4652F, 0.0852F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, -3.0F, 1.5708F, 0.0175F, -0.5672F));

        PartDefinition cube_r19 = rightHand.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(61, 33).addBox(-6.5298F, 2.475F, 0.0852F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4095F, 0.513F, -3.0F, 1.5708F, 0.0F, -0.5672F));

        PartDefinition torso = up.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r20 = torso.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 42).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5796F, -13.1066F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r21 = torso.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(32, 11).addBox(-4.0F, -4.0F, -2.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -11.8125F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition cube_r22 = torso.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(32, 0).addBox(-6.0F, -4.0F, -2.0F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0115F, -10.0008F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition tail = up.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(40, 49).addBox(0.4226F, -2.0937F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -10.0F, 0.5F, 0.0F, 0.0F, 0.4363F));

        PartDefinition middleTail = tail.addOrReplaceChild("middleTail", CubeListBuilder.create(), PartPose.offset(5.4226F, -0.0937F, 0.0F));

        PartDefinition cube_r23 = middleTail.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.0F, -2.0F, 6.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.644F, 1.125F, -0.4358F, 0.0F, 0.0F, 0.2182F));

        PartDefinition endTail = middleTail.addOrReplaceChild("endTail", CubeListBuilder.create(), PartPose.offset(6.019F, 1.0F, -0.4358F));

        PartDefinition cube_r24 = endTail.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 32).addBox(0.0567F, -0.6348F, -3.5F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.427F, 0.75F, 0.5202F, 0.0F, 0.0F, 0.1309F));

        PartDefinition neck = up.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(30, 32).addBox(-10.0F, -18.0F, -1.9625F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(50, 32).addBox(-10.0F, -23.0F, -0.9625F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public @NotNull ModelPart root()
    {
        return this.root;
    }

    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color)
    {
        this.root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public void setupAnim(@NotNull FloweredLizardEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.animate(entity.idleAnimationState, FloweredLizardAnimation.IDLE, ageInTicks, 1F);
        this.animate(entity.walkAnimationState, FloweredLizardAnimation.WALK, ageInTicks, 1F);
        this.animate(entity.attack0AnimationState, FloweredLizardAnimation.ATTACK0, ageInTicks, 1F);
        this.animate(entity.attack1AnimationState, FloweredLizardAnimation.ATTACK1, ageInTicks, 1F);
        this.animate(entity.attack2AnimationState, FloweredLizardAnimation.ATTACK2, ageInTicks, 1F);
        this.animate(entity.eatAnimationState, FloweredLizardAnimation.EAT, ageInTicks, 1F);
    }

    private void applyHeadRotation(float headYaw, float headPitch)
    {
        headYaw = Mth.clamp(headYaw, -60F, 60F);
        headPitch = Mth.clamp(headPitch, -60F, 60F);

        this.head.yRot = headYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
    }
}