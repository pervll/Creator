package com.pervll.creator.client.renderer.entity;

import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@OnlyIn(Dist.CLIENT)
public class GodArrowRenderer extends ArrowRenderer<GodArrow> {
    public GodArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(GodArrow godArrow) {
        return new ResourceLocation(Creator.MOD_ID, "textures/entity/projectiles/god_arrow.png");
    }

}
