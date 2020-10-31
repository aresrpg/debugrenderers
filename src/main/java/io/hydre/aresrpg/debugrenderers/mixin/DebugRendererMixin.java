package io.hydre.aresrpg.debugrenderers.mixin;

import net.minecraft.client.renderer.debug.*;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DebugRenderer.class)
public class DebugRendererMixin {
	@Final @Shadow public PathfindingRenderer pathfindingRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer waterDebugRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer chunkBorderRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer heightMapRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer collisionBoxRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer neighborsUpdateRenderer;
	@Final @Shadow public CaveDebugRenderer caveRenderer;
	@Final @Shadow public StructureRenderer structureRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer lightDebugRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer worldGenAttemptRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer solidFaceRenderer;
	@Final @Shadow public DebugRenderer.SimpleDebugRenderer chunkRenderer;
	@Final @Shadow public BrainDebugRenderer brainDebugRenderer;
	@Final @Shadow public VillageSectionsDebugRenderer villageSectionsDebugRenderer;
	@Final @Shadow public BeeDebugRenderer beeDebugRenderer;
	@Final @Shadow public RaidDebugRenderer raidDebugRenderer;
	@Final @Shadow public GoalSelectorDebugRenderer goalSelectorRenderer;
	@Final @Shadow public GameTestDebugRenderer gameTestDebugRenderer;

	@Inject(at = @At("HEAD"), method = "render")
	public void render(PoseStack poseStack, MultiBufferSource.BufferSource bufferSource, double d, double e, double f, CallbackInfo info) {
		this.pathfindingRenderer.render(poseStack, bufferSource, d, e, f);
		this.neighborsUpdateRenderer.render(poseStack, bufferSource, d, e, f);
		this.caveRenderer.render(poseStack, bufferSource, d, e, f);
		this.structureRenderer.render(poseStack, bufferSource, d, e, f);
		this.worldGenAttemptRenderer.render(poseStack, bufferSource, d, e, f);
		this.villageSectionsDebugRenderer.render(poseStack, bufferSource, d, e, f);
		this.brainDebugRenderer.render(poseStack, bufferSource, d, e, f);
		this.goalSelectorRenderer.render(poseStack, bufferSource, d, e, f);
		this.raidDebugRenderer.render(poseStack, bufferSource, d, e, f);
		this.beeDebugRenderer.render(poseStack, bufferSource, d, e, f);
	}
}
