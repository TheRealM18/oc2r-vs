package com.therealm18studios.oc2rvs;
import li.cil.oc2.common.bus.device.rpc.item.*;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3dc;

import li.cil.oc2.api.bus.device.object.Callback;
import li.cil.oc2.api.bus.device.object.DocumentedDevice;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.joml.primitives.AABBic;
import org.valkyrienskies.core.api.bodies.properties.BodyInertia;
import org.valkyrienskies.core.api.ships.properties.ShipTransform;
import org.valkyrienskies.core.api.ships.ServerShip;

public final class ShipOperationsModuleDevice extends AbstractItemRPCDevice implements DocumentedDevice {

    private final BlockEntity blockEntity;
    private final ServerShip ship;

    public ShipOperationsModuleDevice(final ItemStack identity, final BlockEntity blockEntity, final ServerShip ship) {
        super(identity, "ship");
        this.blockEntity = blockEntity;
        this.ship = ship;
    }

    ///////////////////////////////////////////////////////////////////

    @Callback(name = "getId")
    public long getId(){
        return this.ship.getId();
    }

    @Callback(name = "getInertiaData")
    public BodyInertia getInertiaData() {
        return this.ship.getInertiaData();
    }

    @Callback(name = "getSlug")
    public String getSlug() {
        return this.ship.getSlug();
    }

    @Callback(name = "getAngularVelocity")
    public Vector3dc getAngularVelocity() {
        return this.ship.getAngularVelocity();
    }

    @Callback(name = "getShipTransform")
    public ShipTransform getShipTransform() {
        return this.ship.getTransform();
    }

    @Callback(name = "getShipAABB")
    public AABBic getShipAABB() {
        return this.ship.getShipAABB();
    }

    @Callback(name = "getLinearVelocity")
    public Vector3dc getLinearVelocity() {
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
        visitor.visitCallback("getId")
                .description("Gives the numeric id of the ship")
                .returnValueDescription("The numeric id of the ship");
        visitor.visitCallback("getInertiaData")
                .description("Returns the inertia data of the ship")
                .returnValueDescription("The inertia data of the ship");
        visitor.visitCallback("getSlug")
                .description("Returns the slug of the ship")
                .returnValueDescription("The slug of the ship");
        visitor.visitCallback("getAngularVelocity")
                .description("Returns the anular velocity of the ship as Euler angles")
                .returnValueDescription("The rotational velocity of the ship");
        visitor.visitCallback("getShipTransform")
                .description("Returns the transform of the ship")
                .returnValueDescription("Returns the transform of the ship");
        visitor.visitCallback("getShipAABB")
                .description("Returns the AABB of the ship")
                .returnValueDescription("The AABB of the ship");
        visitor.visitCallback("getVelocity")
                .description("Returns the linear velocity of the ship")
                .returnValueDescription("The linear velocity of the ship");
        visitor.visitCallback("isStatic")
                .description("Check if the ship is currently an active physics object")
                .returnValueDescription("false if the ship is asleep");
        visitor.visitCallback("setSlug")
                .parameterDescription("arg1", "slug")
                .description("Sets the slug of the ship as a string");
    }

    ///////////////////////////////////////////////////////////////////


}
