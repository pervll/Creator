package com.pervll.creator.client;

import com.pervll.creator.Creator;
import com.pervll.creator.client.renderer.entity.GodArrowRenderer;
import com.pervll.creator.utils.Registry;
import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityType.GOD_ARROW.get(), GodArrowRenderer::new);
    }
}
