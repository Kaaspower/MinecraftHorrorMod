package com.horrormod;

import com.horrormod.entity.ModEntities;
import com.horrormod.entity.client.CubeModel;
import com.horrormod.entity.client.CubeRenderer;
import com.horrormod.entity.client.ModModelLayers;
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
