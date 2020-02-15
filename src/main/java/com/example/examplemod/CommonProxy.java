package com.example.examplemod;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(ExampleMod.FIRE_SWORD);
    }

    private static void registerRender(Item item) {
        ModelLoader.addSpecialModel(
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ExampleMod.FIRE_SWORD);
    }
}
