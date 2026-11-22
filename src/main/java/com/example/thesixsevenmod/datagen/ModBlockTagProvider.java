package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.block.ModBlocks;
import com.example.thesixsevenmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TheSixSevenMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .add(ModBlocks.POLISHED_RUBY_BLOCK.get())
                .add(ModBlocks.RAW_GREENSTONE_BLOCK.get())
                .add(ModBlocks.RAW_RUBY_BLOCK.get())
                .add(ModBlocks.WALLRUN_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.POLISHED_GREENSTONE_BLOCK.get())
                .add(ModBlocks.POLISHED_RUBY_BLOCK.get())
                .add(ModBlocks.RAW_GREENSTONE_BLOCK.get())
                .add(ModBlocks.RAW_RUBY_BLOCK.get())
                .add(ModBlocks.WALLRUN_BLOCK.get());

        tag(ModTags.Blocks.NEEDS_RUBY_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_RUBY_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_RUBY_TOOL);
    }
}
