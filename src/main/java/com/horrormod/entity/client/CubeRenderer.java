package com.horrormod.entity.client;

import com.HorrorMod;
import com.horrormod.entity.custom.CubeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CubeRenderer extends MobEntityRenderer<CubeEntity, CubeModel<CubeEntity>> {
    private static final Identifier TEXTURE = new Identifier(HorrorMod.MOD_ID, "textures/entity/cube.png");

    public CubeRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeModel<>(context.getPart(ModModelLayers.CUBE)), 0.6f);
    }

    @Override
    public Identifier getTexture(CubeEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CubeEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
