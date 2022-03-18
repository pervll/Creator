package com.pervll.creator.client;

import com.pervll.creator.Creator;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class t {
    @SubscribeEvent
    public static void onGodArrowShot(ArrowLooseEvent event) {
        Player player = event.getPlayer();
        //final new AttributeModifier(player.getUUID(), "Emblem Speed Boost", 0.3D, AttributeModifier.Operation.ADDITION);
        player.setHealth(200f);
    }
}
