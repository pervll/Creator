package com.pervll.creator.common;

import com.pervll.creator.config.HealthLockConfig;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HealthLockEvent {
    @SubscribeEvent
    public static void onDamageTooLarge(LivingAttackEvent event) {
        if (event.getEntityLiving() instanceof Monster) {
            if (!event.getEntityLiving().getTags().contains("locking")) {
                event.setCanceled(true);
                event.getEntityLiving().addTag("locking");
                event.getEntityLiving().hurt(event.getSource(), (float) Math.min(event.getEntityLiving().getMaxHealth()*HealthLockConfig.lock_percent.get(), event.getAmount()));
                event.getEntityLiving().removeTag("locking");
            }
        }
    }

}
