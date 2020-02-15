package com.example.examplemod;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class FireSword extends Item {

    public static final String REGISTRY_NAME = "fire_sword";

    public FireSword(Properties builder) {
        super(builder);

        this.setRegistryName(REGISTRY_NAME);
    }

}
