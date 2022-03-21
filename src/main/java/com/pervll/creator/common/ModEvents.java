package com.pervll.creator.common;

import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.world.entity.monster.Alaif;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityType.ALAIF.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, Alaif::canSpawn);
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityType.ALAIF.get(), Alaif.createAttributes().build());
    }
}
