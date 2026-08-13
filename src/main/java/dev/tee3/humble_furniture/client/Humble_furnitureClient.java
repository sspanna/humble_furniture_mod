package dev.tee3.humble_furniture.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import dev.tee3.humble_furniture.entity.ModEntities;

public class Humble_furnitureClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.CHAIR_SEAT, ChairSeatRenderer::new);
	}
}
