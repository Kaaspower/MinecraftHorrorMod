package com.handlers;

import java.io.File;
import java.io.IOException;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.storage.LevelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.HorrorMod.MOD_ID;

public class AudioFileHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static File getWorldDirectory(MinecraftServer server) {
        if(server == null) {
            LOGGER.error("MinecraftServer instance is null");
            throw new RuntimeException("Server is null");
        }

        LevelStorage session = server.getSaveProperties().getLevelStorage();
//        File worldDirectory = session.getWorldDirectory().toFile();

        if(worldDirectory == null) {
            LOGGER.error("World directory is null");
            throw new RuntimeException("World directory is null");
        }

        return worldDirectory;
    }
}
