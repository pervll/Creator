package com.pervll.creator.utils;

import com.pervll.creator.Creator;
import com.pervll.creator.item.GodArrowItem;
import com.pervll.creator.item.GodBow;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Creator.MOD_ID);

    public static final RegistryObject<Item> GOD_BOW = ITEMS.register("god_bow", GodBow::new);
    public static final RegistryObject<Item> GOD_ARROW = ITEMS.register("god_arrow", () -> new GodArrowItem(10F));
}
