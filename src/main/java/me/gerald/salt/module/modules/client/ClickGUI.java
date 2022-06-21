package me.gerald.salt.module.modules.client;

import me.gerald.salt.Salt;
import me.gerald.salt.module.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Category.CLIENT, Keyboard.KEY_U);
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Salt.INSTANCE.clickGUI);
        toggle();
    }
}
