package com.horrormod.entity.client;

import com.HorrorMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer CUBE =
            new EntityModelLayer(new Identifier(HorrorMod.MOD_ID, "cube"), "main");
}
