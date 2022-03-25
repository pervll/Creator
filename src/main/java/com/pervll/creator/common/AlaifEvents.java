package com.pervll.creator.common;

import com.pervll.creator.Creator;
import com.pervll.creator.client.renderer.entity.AlaifRenderer;
import com.pervll.creator.client.renderer.entity.GodArrowRenderer;
import com.pervll.creator.client.renderer.model.AlaifModel;
import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.world.entity.monster.Alaif;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.jline.utils.DiffHelper;

@Mod.EventBusSubscriber(modid = Creator.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
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
