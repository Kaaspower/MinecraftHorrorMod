package com.handlers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.WorldSavePath;
import net.minecraft.world.level.storage.LevelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.HorrorMod.MOD_ID;

public class AudioFileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    private static File audioDirectory;

    public static void onWorldLoad(MinecraftServer server, ServerWorld serverWorld) {
        LOGGER.info("World loaded: {}", serverWorld.getRegistryKey().getValue());
        createAudioDirIfNotExists(server);
    }

    private static void createAudioDirIfNotExists(MinecraftServer server) {
        if(audioDirectory == null) {
            audioDirectory = new File(getWorldDirectory(server).getAbsolutePath() + "/audio");
        }

        if(!audioDirectory.exists()) {
            if(audioDirectory.mkdirs()) {
                LOGGER.info("Created audio directory");
            } else {
                LOGGER.error("Failed to create audio directory");
                throw new RuntimeException("Failed to create audio directory");
            }
        }
    }

    public static File getWorldDirectory(MinecraftServer server) {
        if(server == null) {
            LOGGER.error("MinecraftServer instance is null");
            throw new RuntimeException("Server is null");
        }

        Path worldDirectoryPath = server.getSavePath(WorldSavePath.ROOT);
        if(worldDirectoryPath == null) {
            LOGGER.error("World directory path is null");
            throw new RuntimeException("World directory path is null");
        }

        return worldDirectoryPath.toFile();
    }
}
