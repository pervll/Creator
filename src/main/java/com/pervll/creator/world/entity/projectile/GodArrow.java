package com.pervll.creator.world.entity.projectile;

import com.pervll.creator.world.entity.ModEntityType;
import com.pervll.creator.utils.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GodArrow extends AbstractArrow {
    private final Item referenceItem;

    public GodArrow(EntityType<? extends AbstractArrow> type, Level level) {
        super(type, level);
        referenceItem = Registry.GOD_ARROW.get();
    }

    public GodArrow(LivingEntity shooter, Level level, Item referenceItem) {
        super(ModEntityType.GOD_ARROW.get(), shooter, level);
        this.referenceItem = referenceItem;
    }

    @Override
    public ItemStack getPickupItem() {
        return new ItemStack(this.referenceItem);
    }

}
