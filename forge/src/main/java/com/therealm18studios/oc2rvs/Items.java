package com.therealm18studios.oc2rvs;

import li.cil.oc2.common.item.*;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public final class Items {
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "oc2rvs");

    public static final RegistryObject<Item> SHIP_OPERATIONS_MODULE = register("ship_operations_module", ModItem::new);

    public static void initialize() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> factory) {
        return ITEMS.register(name, factory);
    }
}
