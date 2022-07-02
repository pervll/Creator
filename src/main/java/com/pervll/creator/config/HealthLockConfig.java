package com.pervll.creator.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class HealthLockConfig {
    public static ForgeConfigSpec.DoubleValue lock_percent;

    public static void init(ForgeConfigSpec.Builder server) {
        server.comment("Entity Health Lock Config");

        lock_percent = server
                .comment("Maximum damage monster will take per attack.")
                .defineInRange("lockPercent", 0.2, 0.01, 1);
    }
}
