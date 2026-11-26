package com.example.thesixsevenmod.block;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.block.custom.MagicBlock;
import com.example.thesixsevenmod.block.custom.WallrunBlock;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlazedTerracottaBlock;
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
    public static final DeferredBlock<Block> LEO_FULLER_BLOCK =
            registerBlock("leo_fuller_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BLUE)
                    .strength(3.0F, 3.0F)));

    public static final DeferredBlock<Block> OLIVER_REGAN_COE_BLOCK =
            registerBlock("oliver_regan_coe_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_ORANGE)
                    .strength(3.0F, 3.0F)));

    public static final DeferredBlock<Block> HAYDEN_DAMAN_BLOCK =
            registerBlock("hayden_daman_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(3.0F, 3.0F)));


    public static final DeferredBlock<WallrunBlock> WALLRUN_BLOCK =
            registerBlock("wallrun_block", () -> new WallrunBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .strength(3.0F, 3.0F)));

    public static final DeferredBlock<Block> MAGIC_BLOCK =
            registerBlock("magic_block", () -> new MagicBlock(BlockBehaviour.Properties.of()
                    .strength(2f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> POLISHED_RUBY_BLOCK =
            registerBlock("polished_ruby_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.TUFF)));

    public static final DeferredBlock<Block> RAW_RUBY_BLOCK =
            registerBlock("raw_ruby_block", () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_RED)
                    .requiresCorrectToolForDrops()
                    .strength(3.0F, 3.0F)
                    .sound(SoundType.TUFF)));
    public static final DeferredBlock<Block> ARROW_BLOCK =
            registerBlock("arrow_block", () -> new GlazedTerracottaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_GLAZED_TERRACOTTA)));

    public static final DeferredBlock<Block> CLOUD_BLOCK =
            registerBlock("cloud_block", () -> new Block(BlockBehaviour.Properties.of().
                    mapColor(MapColor.SNOW).
                    instrument(NoteBlockInstrument.GUITAR).
                    strength(0.8F).
                    sound(SoundType.WOOL).
                    ignitedByLava()));

    public static final DeferredBlock<Block> WIND_CHARGE_BLOCK =
            registerBlock("wind_charge_block", () -> new WindChargeBlock());

    public static final DeferredBlock<Block> TECHNOBLADE_BLOCK =
            registerBlock("technoblade_block",() -> new Block(BlockBehaviour.Properties.of()
                    .instabreak()
                    .mapColor(MapColor.EMERALD)));

    public static final DeferredBlock<Block> SPEEDICE =
            registerBlock("speedice",() -> new Block( BlockBehaviour.Properties.of()
                    .speedFactor(1.15F)
                    .mapColor(MapColor.ICE)
                    .friction(0.98F)
                    .randomTicks()
                    .strength(0.5F)
                    .sound(SoundType.POWDER_SNOW)
                    .noOcclusion()
                    .isValidSpawn((p_187426_, p_187427_, p_187428_, p_187429_) -> p_187429_ == EntityType.POLAR_BEAR)));

    public static final DeferredBlock<Block> MAISON_BLOCK =
            registerBlock("maison_block",() -> new Block(BlockBehaviour.Properties.of().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> RAFFI_BLOCK =
            registerBlock("raffi_block",() -> new Block(BlockBehaviour.Properties.of().sound(SoundType.ANCIENT_DEBRIS)));

    public static final DeferredBlock<Block> THOMAS_BLOCK =
            registerBlock("thomas_block",() -> new Block(BlockBehaviour.Properties.of().sound(SoundType.SLIME_BLOCK)));
}
