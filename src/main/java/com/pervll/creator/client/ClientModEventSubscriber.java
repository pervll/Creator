package com.pervll.creator.client;

import com.pervll.creator.Creator;
import com.pervll.creator.client.renderer.entity.GodArrowRenderer;
import com.pervll.creator.world.entity.ModEntityType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
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
