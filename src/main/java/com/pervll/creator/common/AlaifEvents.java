package com.pervll.creator.common;

import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.monster.Alaif;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class AlaifEvents {
    @SubscribeEvent
    public static void onAlaifDied(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof Alaif) {
            if (event.getEntityLiving().getHealth() - event.getAmount() <= 1) {
                event.getEntityLiving().setHealth(1f);
                if (!event.getEntityLiving().getTags().contains("dying")) {
                    event.getEntityLiving().addTag("dying");
                }
                event.setCanceled(true);
            }
        }
    }
}
