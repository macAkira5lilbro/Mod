package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.block.ModBlocks;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.POLISHED_GREENSTONE_BLOCK.get());
        dropSelf(ModBlocks.POLISHED_RUBY_BLOCK.get());
        dropSelf(ModBlocks.LEO_FULLER_BLOCK.get());
        dropSelf(ModBlocks.OLIVER_REGAN_COE_BLOCK.get());
        dropSelf(ModBlocks.HAYDEN_DAMAN_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.WALLRUN_BLOCK.get());
        dropSelf(ModBlocks.TECHNOBLADE_BLOCK.get());
        dropSelf(ModBlocks.SPEEDICE.get());
        dropSelf(ModBlocks.MAISON_BLOCK.get());
        dropSelf(ModBlocks.RAFFI_BLOCK.get());
        dropSelf(ModBlocks.THOMAS_BLOCK.get());

        add(ModBlocks.RAW_GREENSTONE_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.RAW_GREENSTONE_BLOCK.get(), ModItems.RAW_GREENSTONE.get(), 2, 5));
        add(ModBlocks.RAW_RUBY_BLOCK.get(),
                block -> createMultipleOreDrops(ModBlocks.RAW_RUBY_BLOCK.get(), ModItems.RAW_RUBY.get(), 2, 5));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
