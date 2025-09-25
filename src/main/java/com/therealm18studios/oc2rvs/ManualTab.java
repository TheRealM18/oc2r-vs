package com.therealm18studios.oc2rvs;

import li.cil.manual.api.ManualModel;
import li.cil.manual.api.Tab;
import li.cil.manual.api.prefab.tab.AbstractTab;
import li.cil.manual.api.util.Constants;
import li.cil.manual.api.util.MatchResult;
import li.cil.oc2.client.manual.Manuals;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

public class ManualTab extends AbstractTab {
    public ManualTab() {
        super(ManualModel.LANGUAGE_KEY + "/vs.md", Component.translatable("oc2rvs.manual.tab"));
    }

    @Override
    public void renderIcon(@NotNull GuiGraphics guiGraphics) {
        guiGraphics.renderItem(Items.VS_LOGO.get().getDefaultInstance(), 0, 0);
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
        DeferredRegister<Tab> tabs = DeferredRegister.create(Constants.TAB_REGISTRY, OC2RVSMod.MODID);
        tabs.register(OC2RVSMod.MODID, ManualTab::new);
        tabs.register(bus);
    }
}