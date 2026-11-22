package com.example.thesixsevenmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ItemTrophy extends Item {
    public ItemTrophy() {
        super(new Properties()
                .durability(100)
                .rarity(Rarity.EPIC)
        );
    }}

