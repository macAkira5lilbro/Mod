package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TheSixSevenMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.POLISHED_GREENSTONE_BLOCK);
        blockWithItem(ModBlocks.RAW_GREENSTONE_BLOCK);
        blockWithItem(ModBlocks.POLISHED_RUBY_BLOCK);
        blockWithItem(ModBlocks.LEO_FULLER_BLOCK);
        blockWithItem(ModBlocks.OLIVER_REGAN_COE_BLOCK);
        blockWithItem(ModBlocks.HAYDEN_DAMAN_BLOCK);
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.WALLRUN_BLOCK);
        blockWithItem(ModBlocks.RAW_RUBY_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}