package com.example.thesixsevenmod.item;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.item.custom.ItemCharmOfResilience;
import com.example.thesixsevenmod.item.custom.ItemOreLocator;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheSixSevenMod.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredItem<Item> GREENSTONE = ITEMS.register("greenstone", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_GREENSTONE = ITEMS.register("raw_greenstone", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_RUBY = ITEMS.register("raw_ruby", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> FRIED_EGG =
            ITEMS.register("fried_egg", () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationModifier(1.2f)
                            .build())
            ));

    public static final DeferredItem<Item> KIWI_BURGER =
            ITEMS.register("kiwi_burger", () -> new Item(new Item.Properties()
                    .stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder()
                            .nutrition(12)
                            .saturationModifier(2.0f)
                            .build())
            ));
    public static final DeferredItem<Item> CHARM_OF_RESILIENCE =
            ITEMS.register("charm_of_resilience", () -> new ItemCharmOfResilience());

    public static final DeferredItem<Item> ORE_LOCATOR =
            ITEMS.register("ore_locator", () -> new ItemOreLocator());

    public static final DeferredItem<SwordItem> RUBY_SWORD =
            ITEMS.register("ruby_sword", () -> new SwordItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.RUBY, 5, -2.4f))));

    public static final DeferredItem<PickaxeItem> RUBY_PICKAXE =
            ITEMS.register("ruby_pickaxe", () -> new PickaxeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.RUBY, 1, -2.8f))));

    public static final DeferredItem<ShovelItem> RUBY_SHOVEL =
            ITEMS.register("ruby_shovel", () -> new ShovelItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.RUBY, 1.5f, -3.4f))));

    public static final DeferredItem<AxeItem> RUBY_AXE =
            ITEMS.register("ruby_axe", () -> new AxeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.RUBY, 6, -3.2f))));

    public static final DeferredItem<HoeItem> RUBY_HOE =
            ITEMS.register("ruby_hoe", () -> new HoeItem(ModToolTiers.RUBY, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.RUBY, 0, -3.0f))));

    public static final DeferredItem<Item> ESSENCE_PLACEHOLDER =
            ITEMS.register("essence_placeholder", () -> new Item(new Item.Properties()));

}
