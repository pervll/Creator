package com.pervll.creator.client.renderer.entity;

import com.pervll.creator.Creator;
import com.pervll.creator.client.renderer.model.AlaifModel;
import com.pervll.creator.world.entity.monster.Alaif;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class AlaifRenderer<Type extends Alaif> extends MobRenderer<Type, AlaifModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Creator.MOD_ID, "textures/entity/alaif.png");

    public AlaifRenderer(EntityRendererProvider.Context context) {
        super(context, new AlaifModel<>(context.bakeLayer(AlaifModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type pEntity) {
        return TEXTURE;
    }
}
