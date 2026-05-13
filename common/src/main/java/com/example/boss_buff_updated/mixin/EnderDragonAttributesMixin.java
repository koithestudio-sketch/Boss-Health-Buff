package com.example.boss_buff_updated.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;

@Mixin(EnderDragonEntity.class)
public abstract class EnderDragonAttributesMixin {

    @ModifyReturnValue(
            method = "createEnderDragonAttributes",
            at = @At("TAIL")
    )
    private static DefaultAttributeContainer.Builder modifyAttributes(
            DefaultAttributeContainer.Builder original
    ) {
        return original.add(EntityAttributes.MAX_HEALTH, 500.0);
    }
}