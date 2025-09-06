package com.therealm18studios.oc2rvs;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OC2RVSMod.MODID)
public class OC2RVSMod {

    public static final String MODID = "oc2rvs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public OC2RVSMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        MinecraftForge.EVENT_BUS.register(this);
        Items.initialize(eventBus);
        Providers.initialize(eventBus);
    }
}