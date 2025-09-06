package com.therealm18studios.oc2rvs;

import com.mojang.logging.LogUtils;
import li.cil.oc2.common.bus.device.provider.ProviderRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.NewRegistryEvent;
import net.minecraftforge.registries.RegisterEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OC2RVSMod.MODID)
public class OC2RVSMod {

    public static final String MODID = "oc2rvs";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OC2RVSMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.addListener(this::registerProviders);
        Items.initialize(eventBus);
    }

    private void registerProviders(RegisterEvent event) {
        event.register(
                ProviderRegistry.ITEM_DEVICE_PROVIDER_REGISTRY.get().getRegistryKey(),
                ResourceLocation.fromNamespaceAndPath(MODID, "ship_operations_module"),
                ShipOperationsModuleDeviceProvider::new
        );
    }
}