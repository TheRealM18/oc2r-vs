package com.therealm18studios.oc2rvs.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import com.therealm18studios.oc2rvs.OC2RVSMod;
import li.cil.oc2.client.renderer.blockentity.ComputerRenderer;
import li.cil.oc2.common.blockentity.ComputerBlockEntity;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;
import org.valkyrienskies.mod.common.util.VectorConversionsMCKt;

@Pseudo
@Mixin(ComputerRenderer.class)
public class MixinComputerRenderer {
    @WrapOperation(method = "renderTerminal", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z"
    ))
    private boolean valkyrienskies$renderTerminalDistanceCheck(Vec3 instance, Position arg, double d, Operation<Boolean> original, @Local(argsOnly = true) ComputerBlockEntity be) {
        Ship ship = VSGameUtilsKt.getShipObjectManagingPos(be.getLevel(), VectorConversionsMCKt.toJOML(instance));
        if (ship != null) instance =
                VectorConversionsMCKt.toMinecraft(ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(instance)));

        return original.call(instance, arg, d);
    }

    @WrapOperation(method = "renderStatusText", at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/phys/Vec3;closerThan(Lnet/minecraft/core/Position;D)Z"
    ))
    private boolean valkyrienskies$renderStatusTextDistanceCheck(Vec3 instance, Position arg, double d, Operation<Boolean> original, @Local(argsOnly = true) ComputerBlockEntity be) {
        Ship ship = VSGameUtilsKt.getShipObjectManagingPos(be.getLevel(), VectorConversionsMCKt.toJOML(instance));
        if (ship != null) instance =
                VectorConversionsMCKt.toMinecraft(ship.getTransform().getShipToWorld().transformPosition(VectorConversionsMCKt.toJOML(instance)));

        return original.call(instance, arg, d);
    }
}