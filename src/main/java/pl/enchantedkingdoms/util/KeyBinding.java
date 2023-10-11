package pl.enchantedkingdoms.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

import javax.net.ssl.KeyManager;

public class KeyBinding {
    public static final String KEY_CATEGORY_ENCHANTEDKINGDOMS = "key.category.enchantedkingdoms.enchantedkingdoms";
    public static final String KEY_SHOW_CASH = "key.enchantedkingdoms.show_cash";

    public static final KeyMapping SHOWING_CASH_KEY = new KeyMapping(KEY_SHOW_CASH, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, KEY_CATEGORY_ENCHANTEDKINGDOMS);
}
