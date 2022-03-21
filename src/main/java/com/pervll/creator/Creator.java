package com.pervll.creator;

import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.util.Registry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("creator")

public class Creator
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "creator";

    public Creator() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        Registry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityType.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void setup(final FMLCommonSetupEvent event) {}
}
