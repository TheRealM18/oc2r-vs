package com.therealm18studios.oc2rvs;

import li.cil.oc2.api.bus.device.ItemDevice;
import li.cil.oc2.api.bus.device.provider.ItemDeviceQuery;
import li.cil.oc2.common.config.Config;
import li.cil.oc2.common.bus.device.provider.util.AbstractItemDeviceProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.valkyrienskies.core.api.ships.ServerShip;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import java.util.Optional;

public final class ShipOperationsModuleDeviceProvider extends AbstractItemDeviceProvider {
    public ShipOperationsModuleDeviceProvider() {
        super(Items.SHIP_OPERATIONS_MODULE);
    }

    ///////////////////////////////////////////////////////////////////

    @Override
    protected @NotNull Optional<ItemDevice> getItemDevice(final ItemDeviceQuery query) {
        return query.getContainerBlockEntity().map(blockEntity -> {
            Level level = blockEntity.getLevel();
            BlockPos pos = blockEntity.getBlockPos();
            ServerShip ship = null;
            if (level instanceof ServerLevel sLevel)
                ship = VSGameUtilsKt.getShipManagingPos(sLevel, pos);
            if (ship == null)
                return null;
            return new ShipOperationsModuleDevice(query.getItemStack(), blockEntity, ship);
        });
    }

    @Override
    protected int getItemDeviceEnergyConsumption(final @NotNull ItemDeviceQuery query) {
        return Config.redstoneInterfaceCardEnergyPerTick;
    }
}
