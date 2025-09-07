package com.therealm18studios.oc2rvs;
import li.cil.oc2.common.bus.device.rpc.item.*;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3dc;

import java.util.*;

import li.cil.oc2.api.bus.device.object.Callback;
import li.cil.oc2.api.bus.device.object.DocumentedDevice;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.ships.properties.ShipInertiaData;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.core.api.ships.ServerShip;

public final class ShipOperationsModuleDevice extends AbstractItemRPCDevice implements DocumentedDevice {

    private final BlockEntity blockEntity;
    ServerShip ship = null;

    public ShipOperationsModuleDevice(final ItemStack identity, final BlockEntity blockEntity) {
        super(identity, "ship");
        this.blockEntity = blockEntity;

    }

    ///////////////////////////////////////////////////////////////////

    @Callback(name = "onShip")
    public boolean onShip() {
        ship = (ServerShip) (VSGameUtilsKt.getShipObjectManagingPos(this.blockEntity.getLevel(), this.blockEntity.getBlockPos()));
        return ship != null;
    }

    private void verify() {
        if (ship == null) {
            onShip();
        }
    }

    @Callback(name = "getId")
    public long getId(){
        verify();
        return this.ship.getId();
    }

    @Callback(name = "getInertiaData")
    public ShipInertiaData getInertiaData() {
        verify();
        return this.ship.getInertiaData();
    }

    @Callback(name = "getSlug")
    public String getSlug() {
        verify();
        return this.ship.getSlug();
    }

    @Callback(name = "getOmega")
    public Vector3dc getOmega() {
        verify();
        return this.ship.getOmega();
    }

    @Callback(name = "getShipTransform")
    public ShipTransform getShipTransform() {
        verify();
        return this.ship.getTransform();
    }

    @Callback(name = "getShipAABB")
    public AABBic getShipAABB() {
        verify();
        return this.ship.getShipAABB();
    }

    @Callback(name = "getVelocity")
    public Vector3dc getVelocity() {
        verify();
        return this.ship.getVelocity();
    }

    @Callback(name = "isStatic")
    public boolean isStatic() {
        return this.ship.isStatic();
    }

    @Callback(name = "setSlug")
    public void setSlug(final String slug) {
        this.ship.setSlug(slug);
    }

    @Override
    public void getDeviceDocumentation(final DocumentedDevice.DeviceVisitor visitor) {
        visitor.visitCallback("onShip")
                .description("Check if the ship interface is on an assembled ship.")
                .returnValueDescription("true if on a ship, otherwise false.");
        visitor.visitCallback("getId")
                .description("Gives the numeric id of the ship")
                .returnValueDescription("The numeric id of the ship");
        visitor.visitCallback("getInertiaData")
                .description("Returns the inertia data of the ship")
                .returnValueDescription("The inertia data of the ship");
        visitor.visitCallback("getSlug")
                .description("Returns the slug of the ship")
                .returnValueDescription("The slug of the ship");
        visitor.visitCallback("getOmega")
                .description("Returns the omega of the ship as Euler angles")
                .returnValueDescription("The rotational velocity of the ship");
        visitor.visitCallback("getShipAABB")
                .description("Returns the AABB of the ship")
                .returnValueDescription("The AABB of the ship");
        visitor.visitCallback("getVelocity")
                .description("Returns the velocity of the ship")
                .returnValueDescription("The velocity of the ship");
        visitor.visitCallback("isStatic")
                .description("Check if the ship is currently an active physics object")
                .returnValueDescription("false if the ship is asleep");
        visitor.visitCallback("setSlug")
                .parameterDescription("slug", "The new slug")
                .description("Sets the slug of the ship as a string");
    }

    ///////////////////////////////////////////////////////////////////


}
