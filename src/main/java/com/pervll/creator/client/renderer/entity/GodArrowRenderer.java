package com.pervll.creator.client.renderer.entity;

import com.pervll.creator.Creator;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GodArrowRenderer extends ArrowRenderer<GodArrow> {
    public GodArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(GodArrow godArrow) {
        Item referenceItem = godArrow.getPickupItem().getItem();
        return new ResourceLocation(Creator.MOD_ID, "textures/entity/projectiles" + referenceItem.getRegistryName().getPath() + ".png");
    }
}
