package com.therealm18studios.oc2rvs;

import dev.architectury.platform.forge.EventBuses;
import li.cil.oc2.common.bus.device.provider.ProviderRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import li.cil.oc2.api.bus.device.provider.ItemDeviceProvider;
import net.minecraftforge.registries.DeferredRegister;

@Mod("oc2rvs")
public class OC2RVSModForge {
    public OC2RVSModForge() {
        EventBuses.registerModEventBus("oc2rvs", FMLJavaModLoadingContext.get().getModEventBus());
        Items.initialize();
        DeferredRegister<ItemDeviceProvider> registry;
        try {
            for (var field : ProviderRegistry.class.getDeclaredFields()) {
                if (field.getName().equals("ITEM_DEVICE_PROVIDERS")) {
                    field.setAccessible(true);
                    registry = (DeferredRegister<ItemDeviceProvider>) field.get(null);
                    registry.register("ship_operations_module", ShipOperationsModuleDeviceProvider::new);
                    return;
                }
            }
        }
        catch (IllegalAccessException e) {
        }
        catch (NullPointerException n) {
        }
        catch (SecurityException e) {
        }

    }

}
