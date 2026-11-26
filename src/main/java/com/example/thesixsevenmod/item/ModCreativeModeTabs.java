package com.example.thesixsevenmod.item;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheSixSevenMod.MODID);

    public static void register(IEventBus eventBus) {

        CREATIVE_MOD_TAB.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> ITEMS_TAB =
            CREATIVE_MOD_TAB.register("thesixsevenmod_items",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("creativetab.thesixsevenmod.items"))
                            .icon(() -> new ItemStack(ModItems.GREENSTONE.get()))
                            .displayItems(((itemDisplayParameters, output) -> {
                                output.accept(ModItems.RAW_GREENSTONE);
                                output.accept(ModItems.GREENSTONE);
                                output.accept(ModItems.RAW_RUBY);
                                output.accept(ModItems.RUBY);
                                output.accept(ModItems.FRIED_EGG);
                                output.accept(ModItems.KIWI_BURGER);
                                output.accept(ModItems.CHARM_OF_RESILIENCE);
                                output.accept(ModItems.ORE_LOCATOR);
                                output.accept(ModItems.RUBY_SWORD);
                                output.accept(ModItems.RUBY_PICKAXE);
                                output.accept(ModItems.RUBY_SHOVEL);
                                output.accept(ModItems.RUBY_AXE);
                                output.accept(ModItems.RUBY_HOE);
                                output.accept(ModItems.ESSENCE_PLACEHOLDER);
                                output.accept(ModItems.RUBIKSCUBE);
                                output.accept(ModItems.SPEED_ESSENCE);
                                output.accept(ModItems.TROPHY_SHARD);
                                output.accept(ModItems.TROPHY);
                            }))
                                    .build());

    public static final Supplier<CreativeModeTab> BLOCKS_TAB =
            CREATIVE_MOD_TAB.register("thesixsevenmod_blocks",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("creativetab.thesixsevenmod.blocks"))
                            .icon(() -> new ItemStack(ModBlocks.LEO_FULLER_BLOCK.get()))
                            .displayItems(((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.POLISHED_GREENSTONE_BLOCK);
                                output.accept(ModBlocks.RAW_GREENSTONE_BLOCK);
                                output.accept(ModBlocks.POLISHED_RUBY_BLOCK);
                                output.accept(ModBlocks.RAW_RUBY_BLOCK);
                                output.accept(ModBlocks.LEO_FULLER_BLOCK);
                                output.accept(ModBlocks.OLIVER_REGAN_COE_BLOCK);
                                output.accept(ModBlocks.HAYDEN_DAMAN_BLOCK);
                                output.accept(ModBlocks.WALLRUN_BLOCK);
                                output.accept(ModBlocks.MAGIC_BLOCK);
                                output.accept(ModBlocks.TECHNOBLADE_BLOCK);
                                output.accept(ModBlocks.SPEEDICE);
                                output.accept(ModBlocks.WIND_CHARGE_BLOCK);
                                output.accept(ModBlocks.CLOUD_BLOCK);
                                output.accept(ModBlocks.ARROW_BLOCK);
                            }))
                            .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TheSixSevenMod.MODID, "thesixsevenmod_items"))
                            .build());

    public static final Supplier<CreativeModeTab> CREATORS_TAB =
            CREATIVE_MOD_TAB.register("creators",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("creativetab.thesixsevenmod.creators"))
                            .icon(() -> new ItemStack(ModItems.TROPHY.get()))
                            .displayItems(((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.MAISON_BLOCK);
                                output.accept(ModBlocks.RAFFI_BLOCK);
                                output.accept(ModBlocks.THOMAS_BLOCK);
                            }))
                            .build());
}