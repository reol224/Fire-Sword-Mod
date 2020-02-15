package com.example.examplemod;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class MessageBusSubscriber {

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(SwordTutorialMod.FIRE_SWORD);
    }

    private static void registerRender(Item item) {
        ModelLoader.addSpecialModel(
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(SwordTutorialMod.FIRE_SWORD);
    }
}
