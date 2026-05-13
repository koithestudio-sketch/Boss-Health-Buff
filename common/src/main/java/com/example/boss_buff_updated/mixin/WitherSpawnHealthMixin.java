package com.example.boss_buff_updated.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.boss.WitherEntity;

@Mixin(WitherEntity.class)
public abstract class WitherSpawnHealthMixin {

    @Inject(
            method = "mobTick",
            at = @At("TAIL")
    )
    private void bosshealth$doubleSpawnHealing(CallbackInfo ci) {
        WitherEntity self = (WitherEntity)(Object)this;
        int age = self.age;
        // If vanilla is still raising health, add more
        if (self.age < 243) {
            if (self.getHealth() < self.getMaxHealth()) {
                self.setHealth(600.0f);
            }
        }
    }
}