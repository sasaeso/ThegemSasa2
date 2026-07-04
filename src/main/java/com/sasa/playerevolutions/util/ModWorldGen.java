package com.sasa.playerevolutions.util;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            
            OreFeatureConfig featureConfig = new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    RegistryHandler.SASA_ORE.get().getDefaultState(),
                    3
            );


            CountRangeConfig placementConfig = new CountRangeConfig(1, 5, 0, 12);

            biome.addFeature(
                    GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(featureConfig)
                            .withPlacement(Placement.COUNT_RANGE.configure(placementConfig))
            );
        }
    }
}