package com.pervll.creator;

import com.pervll.creator.config.Config;
import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.util.Registry;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("creator")

public class Creator
{
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "creator";

    public Creator() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("creator-server.toml").toString());

        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {}
}
