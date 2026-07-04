package com.sasa.playerevolutions.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class SasaArmorItem extends ArmorItem {

    public SasaArmorItem(IArmorMaterial material, EquipmentSlotType slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (!world.isRemote && player.ticksExisted % 20 == 0) {

            boolean hasHelmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD).getItem() instanceof SasaArmorItem;
            boolean hasChestplate = player.getItemStackFromSlot(EquipmentSlotType.CHEST).getItem() instanceof SasaArmorItem;
            boolean hasLeggings = player.getItemStackFromSlot(EquipmentSlotType.LEGS).getItem() instanceof SasaArmorItem;
            boolean hasBoots = player.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() instanceof SasaArmorItem;

            if (hasHelmet && hasChestplate && hasLeggings && hasBoots) {
                // FULL SET BUFFS
                player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 40, 1));     // Resistance II
                player.addPotionEffect(new EffectInstance(Effects.SPEED, 40, 0));           // Speed I
                player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 40, 0));     // Jump Boost I
            }
        }
    }
}