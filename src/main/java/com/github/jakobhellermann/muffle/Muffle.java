package com.github.jakobhellermann.muffle;

import com.github.jakobhellermann.muffle.blockentities.SoundMufflerBlockEntity;
import com.github.jakobhellermann.muffle.blocks.SoundMuffler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

public class Muffle implements ModInitializer {
    public static final String MOD_ID = "muffle";

    public static final Block SOUND_MUFFLER = new SoundMuffler(Block.Settings.of(Material.WOOL).strength(0.8F, 1.0F));
    public static BlockEntityType<SoundMufflerBlockEntity> SOUND_MUFFLER_ENTITY;

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, SoundMuffler.ID, SOUND_MUFFLER);
        Registry.register(Registry.ITEM, SoundMuffler.ID, new BlockItem(SOUND_MUFFLER, new Item.Settings().group(ItemGroup.MISC)));

        SOUND_MUFFLER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, SoundMuffler.ID, BlockEntityType.Builder.create(SoundMufflerBlockEntity::new, SOUND_MUFFLER).build(null));
    }
}
