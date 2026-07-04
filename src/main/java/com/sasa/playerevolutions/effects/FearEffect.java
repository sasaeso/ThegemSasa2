package com.sasa.playerevolutions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.ResourceLocation;

public class FearEffect extends Effect {

    public FearEffect() {
        super(EffectType.HARMFUL, 0x4B0082);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof MobEntity) {
            MobEntity mob = (MobEntity) entity;

            PlayerEntity nearestPlayer = entity.world.getClosestPlayer(
                    entity,
                    15.0
            );

            if (nearestPlayer != null) {
                double dx = entity.getPosX() - nearestPlayer.getPosX();
                double dz = entity.getPosZ() - nearestPlayer.getPosZ();
                double distance = Math.sqrt(dx * dx + dz * dz);

                if (distance > 0.1 && distance < 15.0) {
                    dx /= distance;
                    dz /= distance;

                    double speed = 0.18 + (amplifier * 0.03);

                    entity.setMotion(
                            dx * speed,
                            entity.getMotion().y,
                            dz * speed
                    );
                    entity.velocityChanged = true;

                    float targetYaw = (float)(Math.atan2(dx, dz) * (180.0 / Math.PI));
                    float currentYaw = entity.rotationYaw;
                    float diff = targetYaw - currentYaw;

                    while (diff > 180) diff -= 360;
                    while (diff < -180) diff += 360;

                    entity.rotationYaw = currentYaw + (diff * 0.15F);
                    entity.rotationYawHead = entity.rotationYaw;
                }
            }
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }



}