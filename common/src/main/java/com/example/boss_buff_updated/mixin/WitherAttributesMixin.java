package com.example.boss_buff_updated.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.WitherEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

@Mixin(WitherEntity.class)
public abstract class WitherAttributesMixin {

    @ModifyReturnValue(
            method = "createWitherAttributes",
            at = @At("TAIL")
    )
    private static DefaultAttributeContainer.Builder modifyAttributes(
            DefaultAttributeContainer.Builder original
    ) {
        return original
                .add(EntityAttributes.MAX_HEALTH, 600.0)
                .add(EntityAttributes.ARMOR, 14.0);
    }
}
