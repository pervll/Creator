package com.pervll.creator.item;

import com.pervll.creator.utils.Registry;
import com.pervll.creator.world.entity.projectile.GodArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class GodArrowItem extends ArrowItem {
    public final float damage;


    public GodArrowItem(float damage) {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS));
        this.damage=damage;
    }

    @Override
    public AbstractArrow createArrow(Level pLevel, ItemStack pStack, LivingEntity pShooter) {
        GodArrow arrow = new GodArrow(pShooter,pLevel, Registry.GOD_ARROW.get());
        arrow.setBaseDamage(this.damage);
        return arrow;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, Player player) {
        int enchant = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, bow);
        return enchant <= 0 ? false : this.getClass() == GodArrowItem.class;
    }
}
