package com.sasa.playerevolutions.util;

import com.sasa.playerevolutions.PlayerEvolutions;
import com.sasa.playerevolutions.blocks.BakryBlock;
import com.sasa.playerevolutions.blocks.BlockItemBase;
import com.sasa.playerevolutions.blocks.RubyBlock;
import com.sasa.playerevolutions.blocks.SasaOre;
import com.sasa.playerevolutions.effects.FearEffect;
import com.sasa.playerevolutions.effects.SasaVenomEffect;
import com.sasa.playerevolutions.items.ItemBase;
import com.sasa.playerevolutions.items.SasaArmorItem;
import com.sasa.playerevolutions.items.SasaGem;
import com.sasa.playerevolutions.items.SasaSword;
import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PlayerEvolutions.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, PlayerEvolutions.MOD_ID);
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, PlayerEvolutions.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EFFECTS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // ==================== ITEMS ====================
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", ItemBase::new);

    public static final RegistryObject<Item> BAKRY = ITEMS.register("bakry", ItemBase::new);

    public static final RegistryObject<Item> SASA = ITEMS.register("sasa", SasaGem::new);
    public static final RegistryObject<Item> SASA_SWORD = ITEMS.register("sasa_sword", SasaSword::new);

    // Armor - Uses SasaArmorItem for buffs!
    public static final RegistryObject<Item> SASA_HELMET = ITEMS.register("sasa_helmet",
            () -> new SasaArmorItem(ModArmorMaterial.SASA, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SASA_CHESTPLATE = ITEMS.register("sasa_chestplate",
            () -> new SasaArmorItem(ModArmorMaterial.SASA, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SASA_LEGGINGS = ITEMS.register("sasa_leggings",
            () -> new SasaArmorItem(ModArmorMaterial.SASA, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    public static final RegistryObject<Item> SASA_BOOTS = ITEMS.register("sasa_boots",
            () -> new SasaArmorItem(ModArmorMaterial.SASA, EquipmentSlotType.FEET,
                    new Item.Properties().group(ItemGroup.COMBAT)));

    // ==================== BLOCKS ====================
    public static final RegistryObject<Block> RUBY_BLOCK = BLOCKS.register("ruby_block", RubyBlock::new);
    public static final RegistryObject<Item> RUBY_BLOCK_ITEM = ITEMS.register("ruby_block",
            () -> new BlockItemBase(RUBY_BLOCK.get()));

    public static final RegistryObject<Block> BAKRY_BLOCK = BLOCKS.register("bakry_block", BakryBlock::new);
    public static final RegistryObject<Item> BAKRY_BLOCK_ITEM = ITEMS.register("bakry_block",
            () -> new BlockItemBase(BAKRY_BLOCK.get()));

    public static final RegistryObject<Block> SASA_ORE = BLOCKS.register("sasa_ore", SasaOre::new);
    public static final RegistryObject<Item> SASA_ORE_ITEM = ITEMS.register("sasa_ore",
            () -> new BlockItem(SASA_ORE.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));

    // ==================== EFFECTS ====================
    public static final RegistryObject<Effect> SASA_VENOM = EFFECTS.register("sasa_venom", SasaVenomEffect::new);
    public static final RegistryObject<Effect> FEAR = EFFECTS.register("fear", FearEffect::new);
}