package com.sasa.playerevolutions.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SasaOre extends Block {
    public SasaOre() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(4.5F, 6.0F)
                .harvestLevel(3)
                .sound(SoundType.STONE));
    }
}