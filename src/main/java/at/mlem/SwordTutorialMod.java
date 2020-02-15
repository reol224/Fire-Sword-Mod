package at.mlem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(SwordTutorialMod.MOD_ID)
public class SwordTutorialMod {
    public static final String MOD_ID = "swordtutorial";

    static Item FIRE_SWORD = new FireSword( new Item.Properties().group(ItemGroup.COMBAT));

    public SwordTutorialMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
