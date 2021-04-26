package at.mlem;

import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MessageBusSubscriber {

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(FireSwordMod.FIRE_SWORD);
    }

    private static void registerRender(Item item) {
        ModelLoader.addSpecialModel(
                new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory")
        );
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(FireSwordMod.FIRE_SWORD);
    }
}
