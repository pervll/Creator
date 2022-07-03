package com.pervll.creator.item;

import com.pervll.creator.util.Registry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class GodBow extends CrossbowItem {
    public GodBow() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS));
    }

    public static final Predicate<ItemStack> GOD_ARROW = (p_43017_) -> p_43017_.is(Registry.GOD_ARROW.get());

    @Override
    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return GOD_ARROW;
    }
}
