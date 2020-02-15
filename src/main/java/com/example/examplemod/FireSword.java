package com.example.examplemod;

import net.minecraft.item.Item;

public class FireSword extends Item {

    public static final String REGISTRY_NAME = "fire_sword";

    public FireSword(Properties builder) {
        super(builder);

        this.setRegistryName(REGISTRY_NAME);
    }

}
