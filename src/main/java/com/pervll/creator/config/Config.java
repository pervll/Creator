package com.pervll.creator.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.pervll.creator.Creator;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {
    private static final ForgeConfigSpec.Builder server_builder = new ForgeConfigSpec.Builder();
    public static ForgeConfigSpec server_config;

    static {
        HealthLockConfig.init(server_builder);
        server_config = server_builder.build();

    }

    public static void loadConfig(ForgeConfigSpec config, String path) {
        Creator.LOGGER.info("Loading Config: " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        Creator.LOGGER.info("Build server_config: "+path);
        file.load();
        Creator.LOGGER.info("Loaded Config: "+path);
        config.setConfig(file);
    }
}
