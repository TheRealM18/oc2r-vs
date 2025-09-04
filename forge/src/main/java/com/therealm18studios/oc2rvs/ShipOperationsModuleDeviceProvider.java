package com.therealm18studios.oc2rvs;

import li.cil.oc2.api.bus.device.ItemDevice;
import li.cil.oc2.api.bus.device.provider.ItemDeviceQuery;
import li.cil.oc2.common.config.Config;
import li.cil.oc2.common.bus.device.provider.util.AbstractItemDeviceProvider;

import java.util.Optional;

public final class ShipOperationsModuleDeviceProvider extends AbstractItemDeviceProvider {
    public ShipOperationsModuleDeviceProvider() {
        super(Items.SHIP_OPERATIONS_MODULE);
    }

    ///////////////////////////////////////////////////////////////////

    @Override
    protected Optional<ItemDevice> getItemDevice(final ItemDeviceQuery query) {
        return query.getContainerBlockEntity().map(blockEntity ->
            new ShipOperationsModuleDevice(query.getItemStack(), blockEntity));
    }

    @Override
    protected int getItemDeviceEnergyConsumption(final ItemDeviceQuery query) {
        return Config.redstoneInterfaceCardEnergyPerTick;
    }
}
