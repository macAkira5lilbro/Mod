package com.example.thesixsevenmod.datagen;

import com.example.thesixsevenmod.TheSixSevenMod;
import com.example.thesixsevenmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TheSixSevenMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_GREENSTONE.get());
        basicItem(ModItems.RAW_RUBY.get());
        basicItem(ModItems.GREENSTONE.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.CHARM_OF_RESILIENCE.get());
        basicItem(ModItems.FRIED_EGG.get());
        basicItem(ModItems.KIWI_BURGER.get());
        basicItem(ModItems.ORE_LOCATOR.get());
        basicItem(ModItems.ESSENCE_PLACEHOLDER.get());

        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_HOE);
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(TheSixSevenMod.MODID,"item/" + item.getId().getPath()));
    }
}
