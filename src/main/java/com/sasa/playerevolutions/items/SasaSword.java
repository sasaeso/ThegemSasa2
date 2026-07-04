package com.sasa.playerevolutions.items;

import com.sasa.playerevolutions.util.ModItemTier;
import com.sasa.playerevolutions.util.RegistryHandler;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SasaSword extends SwordItem {

    public SasaSword() {

        super(ModItemTier.SASA, 3, -2.4F, new Item.Properties().group(ItemGroup.COMBAT));
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean result = super.hitEntity(stack, target, attacker);

        target.addPotionEffect(new EffectInstance(
                net.minecraft.potion.Effects.POISON,
                100,
                0
        ));

        target.addPotionEffect(new EffectInstance(
                RegistryHandler.SASA_VENOM.get(),
                100,
                0
        ));

        target.addPotionEffect(new EffectInstance(
                RegistryHandler.FEAR.get(),
                250,
                0
        ));

        return result;
    }
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        // Apply effects to yourself on right-click
        player.addPotionEffect(new EffectInstance(
                RegistryHandler.SASA_VENOM.get(),
                200, // 10 seconds
                0
        ));

        player.addPotionEffect(new EffectInstance(
                RegistryHandler.FEAR.get(),
                200, // 10 seconds
                0
        ));

        return ActionResult.resultSuccess(stack);
    }
}