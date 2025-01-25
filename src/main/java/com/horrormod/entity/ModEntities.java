package com.horrormod.entity;

import com.HorrorMod;
import com.horrormod.entity.custom.CubeEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<CubeEntity> CUBE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(HorrorMod.MOD_ID, "cube"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CubeEntity::new).dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
