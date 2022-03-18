package com.pervll.creator.world.entity;

import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityType {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Creator.MOD_ID);

    public static final RegistryObject<EntityType<GodArrow>> GOD_ARROW = ENTITIES.register("god_arrow", () -> EntityType.Builder.<GodArrow>of(GodArrow::new, MobCategory.MISC)
            .sized(0.5F,0.5F)
            .clientTrackingRange(4)
            .updateInterval(20)
            .build(new ResourceLocation(Creator.MOD_ID,"god_arrow").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
