package com.sasa.playerevolutions.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.world.server.ServerWorld;

public class SasaVenomEffect extends Effect {

    public SasaVenomEffect() {
        super(EffectType.HARMFUL, 0x800080);
    }

    @Override
    public void performEffect(LivingEntity entity, int amplifier) {
        if (entity.getHealth() > 1.0F) {
            entity.attackEntityFrom(
                    net.minecraft.util.DamageSource.MAGIC,
                    1.0F + amplifier
            );
        }

        spawnPurpleParticles(entity);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    private void spawnPurpleParticles(LivingEntity entity) {
        if (!entity.world.isRemote) {
            ServerWorld world = (ServerWorld) entity.world;
            double x = entity.getPosX();
            double y = entity.getPosY() + entity.getHeight() / 2.0;
            double z = entity.getPosZ();

            for (int i = 0; i < 5; i++) {
                double ox = (entity.getRNG().nextDouble() - 0.5) * entity.getWidth();
                double oy = (entity.getRNG().nextDouble() - 0.5) * entity.getHeight();
                double oz = (entity.getRNG().nextDouble() - 0.5) * entity.getWidth();

                world.spawnParticle(
                        new RedstoneParticleData(0.5F, 0.0F, 0.5F, 1.0F),
                        x + ox, y + oy, z + oz,
                        1, 0, 0.05, 0, 0
                );
            }
        }
    }
}