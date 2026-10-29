package com.example.thesixsevenmod.block;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TheSixSevenMod.MODID);

    //Method used to register a block.
    //Will register the block form as well as the held item form too.
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    //Helper method called by the code above to register the item form of a block.
    //Probably shouldn't be called anywhere else?
    public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    public static final DeferredBlock<Block> POLISHED_GREENSTONE_BLOCK =
            registerBlock("polished_greenstone_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.TUFF)));

    public static final DeferredBlock<Block> RAW_GREENSTONE_BLOCK =
            registerBlock("raw_greenstone_block", () -> new Block(BlockBehaviour.Properties.of()
                .mapColor(MapColor.COLOR_GREEN)
                .requiresCorrectToolForDrops()
                .strength(3.0F, 3.0F)
                    .sound(SoundType.TUFF)));

    public static final DeferredBlock<Block> SIX_SEVEN_BLOCK =
            registerBlock("six_seven_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.5F, 6.0F)));

    public static final DeferredBlock<Block> WALLRUN_BLOCK =
            registerBlock("wallrun_block", () -> new HoneyBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.STONE)
                    .speedFactor(1.5F)
                    .jumpFactor(1.5F)
                    .strength(1.5F, 6.0F)));
}
