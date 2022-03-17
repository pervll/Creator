package com.pervll.creator.client;

import com.pervll.creator.Creator;
import com.pervll.creator.client.renderer.entity.GodArrowRenderer;
import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientModEventSubscriber {

    @SubscribeEvent
    public static void onClientSetup(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntityType.GOD_ARROW.get(), GodArrowRenderer::new);
    }

    /*@SubscribeEvent
    public static void onGodArrowHitBlock(ProjectileImpactEvent event) {
        Projectile arrow = event.getProjectile();
        if(arrow instanceof GodArrow) {
            GodArrow god_arrow = (GodArrow)arrow;
            Level world = event.getProjectile().level;
            world.explode(god_arrow, event.getProjectile().position().x, event.getProjectile().position().y, event.getProjectile().position().z,3.5F, Explosion.BlockInteraction.DESTROY);
        }
    }*/
}
