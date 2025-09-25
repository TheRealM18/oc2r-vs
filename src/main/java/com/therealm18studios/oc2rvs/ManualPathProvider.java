package com.therealm18studios.oc2rvs;

import li.cil.manual.api.ManualModel;
import li.cil.manual.api.prefab.provider.NamespacePathProvider;
import li.cil.manual.api.provider.PathProvider;
import li.cil.manual.api.util.Constants;
import li.cil.manual.api.util.MatchResult;
import li.cil.oc2.client.manual.Manuals;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ManualPathProvider extends NamespacePathProvider {
    public ManualPathProvider() {
        super(OC2RVSMod.MODID, false);
    }

    @Override
    public @NotNull MatchResult matches(@NotNull ManualModel manual) {
        return manual == Manuals.MANUAL.get() ? MatchResult.MATCH : MatchResult.MISMATCH;
    }

    @Override
    public int sortOrder() {
        return Integer.MAX_VALUE;
    }

    public static void register(IEventBus bus) {
        DeferredRegister<PathProvider> paths = DeferredRegister.create(Constants.PATH_PROVIDER_REGISTRY, OC2RVSMod.MODID);
        paths.register("path_provider", ManualPathProvider::new);
        paths.register(bus);
    }
}
