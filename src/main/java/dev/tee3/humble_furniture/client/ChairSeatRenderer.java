package dev.tee3.humble_furniture.client;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;

import dev.tee3.humble_furniture.entity.ChairSeatEntity;

public class ChairSeatRenderer extends EntityRenderer<ChairSeatEntity, EntityRenderState> {
	public ChairSeatRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@Override
	public EntityRenderState createRenderState() {
		return new EntityRenderState();
	}

	@Override
	public boolean shouldRender(ChairSeatEntity entity, Frustum frustum, double x, double y, double z) {
		return false;
	}
}
