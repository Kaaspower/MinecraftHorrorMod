package com;

import com.handlers.AudioFileHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HorrorMod implements ModInitializer, ServerWorldEvents.Load {
	public static final String MOD_ID = "horror-mod";

	public void onWorldLoad(MinecraftServer server, ServerWorld serverWorld) {
		LOGGER.info("World loaded: {}", serverWorld.getRegistryKey().getValue());
		AudioFileHandler.onWorldLoad(server, serverWorld);
	}

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Register the ServerWorldEvents.Load event
		ServerWorldEvents.LOAD.register(this);
	}
}