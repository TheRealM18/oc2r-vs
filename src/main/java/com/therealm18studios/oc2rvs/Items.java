package com.therealm18studios.oc2rvs;

import li.cil.oc2.common.item.ModItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class Items {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "oc2rvs");

    public static final RegistryObject<Item> SHIP_OPERATIONS_MODULE = register("ship_operations_module", ModItem::new);

    public static void initialize(IEventBus bus) {
        ITEMS.register(bus);
    }

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> factory) {
        return ITEMS.register(name, factory);
    }
}
