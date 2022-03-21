package com.pervll.creator.item;

import com.pervll.creator.util.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Predicate;

public class GodBow extends CrossbowItem {
    public GodBow() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS));
    }

    public static final Predicate<ItemStack> GOD_ARROW = (p_43017_) -> {
        return p_43017_.is(Registry.GOD_ARROW.get());
    };

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return GOD_ARROW;
    }
}
