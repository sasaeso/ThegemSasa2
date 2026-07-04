package com.sasa.playerevolutions.items;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class SasaGem extends Item {
    public SasaGem() {
        super(new Item.Properties().group(ItemGroup.MISC));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {

        tooltip.add(new StringTextComponent("This gem forged a legendary and powerful sword...")
                .setStyle(new net.minecraft.util.text.Style().setColor(TextFormatting.GRAY).setItalic(true)));

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}