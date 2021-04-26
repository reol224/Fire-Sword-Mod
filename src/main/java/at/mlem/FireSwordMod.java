package at.mlem;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(FireSwordMod.MOD_ID)
public class FireSwordMod {
    public static final String MOD_ID = "firesword";
    public static final String VERSION = "1.0";

    static Item FIRE_SWORD = new FireSword( new Item.Properties().group(ItemGroup.COMBAT));

    public FireSwordMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

}
