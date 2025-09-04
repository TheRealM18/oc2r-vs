package com.therealm18studios.oc2rvs;
import li.cil.oc2.common.bus.device.rpc.item.*;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector3d;
import org.joml.primitives.AABBi;

import java.util.*;

import li.cil.oc2.api.bus.device.object.Callback;
import li.cil.oc2.api.bus.device.object.DocumentedDevice;
import net.minecraft.world.level.block.entity.BlockEntity;
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

    @Callback(name = "getMass")
    public double getMass() {
        verify();
        return this.ship.getInertiaData().getShipMass();
    }

//    @Callback(name = "getMomentOfInertiaTensorToSave")
//    public List<List<Double>> getMomentOfInertiaTensorToSave() {
//        verify();
//        return this.ship.getInertiaData().getMomentOfInertiaTensor();
//     }
//
//    @Callback(name = "getMomentOfInertiaTensor")
//    public List<List<Double>> getMomentOfInertiaTensor() {
//        verify();
//        return this.ship.inertiaData.momentOfInertiaTensor;
//    }

    @Callback(name = "getName")
    public String getName() {
        verify();
        return this.ship.getSlug();
    }


    @Callback(name = "getOmega")
    public Map<String, Double> getOmega() {
        verify();
        final var o = this.ship.getOmega();
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );
    }

    @Callback(name = "getEulerAnglesXYZ")
    public Map<String, Double> getEulerAnglesXYZ() {
        verify();
        final var o = new Vector3d();
        this.ship.getTransform().getShipToWorldRotation().getEulerAnglesXYZ(o);
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );

    }


    @Callback(name = "getScale")
    public Map<String, Double> getScale() {
        verify();
        final var o = this.ship.getTransform().getShipToWorldScaling();
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );

    }

    @Callback(name = "getShipyardPosition")
    public Map<String, Double> getShipyardPosition() {
        verify();
        final var o = this.ship.getTransform().getPositionInShip();
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );

    }

    @Callback(name = "getSize")
    public Map<String, Object> getSize() {
        verify();
        var aabb = this.ship.getShipAABB();
        if (aabb == null) {
            aabb = new AABBi(0, 0, 0, 0, 0, 0);
        }
        return Map.of(
                     "x", aabb.maxX() - aabb.minX(),
                     "y", aabb.maxY() - aabb.minY(),
                     "z", aabb.maxZ() - aabb.minZ()
                     );
    }

    @Callback(name = "getVelocity")
    public Map<String, Double> getVelocity() {
        final var o = this.ship.getVelocity();
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );

    }

    @Callback(name = "getWorldspacePosition")
    public Map<String, Double> getWorldspacePosition() {
        final var o = this.ship.getTransform().getPositionInWorld();
        return Map.of(
                      "x", o.x(),
                      "y", o.y(),
                      "z", o.z()
                      );
    }


    @Callback(name = "isStatic")
    public boolean isStatic() {
        return this.ship.isStatic();
    }

    @Callback(name = "setName")
    public void setName(final String name) {
        this.ship.setSlug(name);
    }


    /*
    @LuaFunction
    fun doFluidDrag() = this.physShip.doFluidDrag

    @LuaFunction
    fun getInertia(): Map<String, Any> {
        val inertia = this.physShip.inertia
        return mapOf(
            Pair("momentOfInertiaTensor", inertia.momentOfInertiaTensor.toLua()),
            Pair("mass", inertia.shipMass)
        )
    }

    @LuaFunction
    fun getPoseVel(): Map<String, Map<String, Double>> {
        val poseVel = this.physShip.poseVel
        return mapOf(
            Pair("vel", poseVel.vel.toLua()),
            Pair("omega", poseVel.omega.toLua()),
            Pair("pos", poseVel.pos.toLua()),
            Pair("rot", poseVel.rot.toLua())
        )
    }

    */

    @Override
    public void getDeviceDocumentation(final DocumentedDevice.DeviceVisitor visitor) {
        visitor.visitCallback("onShip")
            .description("Check if the ship interface is on an assembled ship. ")
            .returnValueDescription("true if on a ship, otherwise false.");
        visitor.visitCallback("getId")
            .description("Gives the numeric id of the ship")
            .returnValueDescription("The numeric id of the ship")
            ;
        visitor.visitCallback("getMass")
            .description("Returns the mass of the ship")
            .returnValueDescription("The mass of the ship")
            ;
        visitor.visitCallback("getName")
            .description("Returns the name of the ship")
            .returnValueDescription("The name of the ship")
            ;
        visitor.visitCallback("getOmega")
            .description("Returns the omega of the ship as Euler angles")
            .returnValueDescription("The rotational velocity of the ship")
            ;
        visitor.visitCallback("getEulerAnglesXYZ")
            .description("Returns the rotation of the ship as euler angles")
            .returnValueDescription("The rotation of the ship")
            ;
        visitor.visitCallback("getScale")
            .description("Returns the scale factor of the ship")
            .returnValueDescription("The scale of the ship")
            ;
        visitor.visitCallback("getShipyardPosition")
            .description("Returns the position of the ship in the shipyard")
            .returnValueDescription("The position of the ship")
            ;
        visitor.visitCallback("getSize")
            .description("Returns the AABB size of the ship")
            .returnValueDescription("The AABB size of the ship")
            ;
        visitor.visitCallback("getVelocity")
            .description("Returns the velocity of the ship")
            .returnValueDescription("The velocity of the ship")
            ;

        visitor.visitCallback("getWorldspacePosition")
            .description("Returns the position of the ship in the world")
            .returnValueDescription("The position of the ship")
            ;
        visitor.visitCallback("isStatic")
            .description("Check if the ship is currently an active physics object")
            .returnValueDescription("false if the ship is asleep")
            ;
        visitor.visitCallback("getBuoyantfactor")
            .description("If the ship is a PhysShip, gets its buoyancy")
            .returnValueDescription("The buoyancy factor, -1 if the ship is not a PhysShip")
            ;
        visitor.visitCallback("setName")
            .description("Sets the name of the ship as a string")
            ;





    }

    ///////////////////////////////////////////////////////////////////


}
