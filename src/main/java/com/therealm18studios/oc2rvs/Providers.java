package com.therealm18studios.oc2rvs;

import li.cil.oc2.api.bus.device.provider.ItemDeviceProvider;
import li.cil.oc2.api.util.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Providers {
    private static final DeferredRegister<ItemDeviceProvider> PROVIDERS =
            DeferredRegister.create(Registries.ITEM_DEVICE_PROVIDER, OC2RVSMod.MODID);

    public static final RegistryObject<ItemDeviceProvider> SHIP_OPERATIONS_MODULE =
            PROVIDERS.register("ship_operations_module", ShipOperationsModuleDeviceProvider::new);

    public static void initialize(IEventBus bus) {
        PROVIDERS.register(bus);
    }
}
