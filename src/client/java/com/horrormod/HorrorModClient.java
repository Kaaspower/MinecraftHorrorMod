package com.horrormod;

import com.horrormod.entity.ModEntities;
import com.horrormod.client.CubeModel;
import com.horrormod.client.CubeRenderer;
import com.horrormod.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class HorrorModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(ModEntities.CUBE, CubeRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUBE, CubeModel::getTexturedModelData);
	}
}
