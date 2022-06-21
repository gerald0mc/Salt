package me.gerald.salt.module;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

public class Module {
    private String name;
    private Category category;
    private int keybind;
    private boolean enabled = false;

    public static Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, Category category, int keybind) {
        this.name = name;
        this.category = category;
        this.keybind = keybind;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public int getKeybind() {
        return keybind;
    }

    public void setKeybind(int keybind) {
        this.keybind = keybind;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void toggle() {
        enabled = !enabled;
        if (enabled) {
            enable();
        } else {
            disable();
        }
    }

    public void onEnable() {}

    public void enable() {
        MinecraftForge.EVENT_BUS.register(this);
        onEnable();
    }

    public void onDisable() {}

    public void disable() {
        MinecraftForge.EVENT_BUS.unregister(this);
        onDisable();
    }

    public enum Category {COMBAT, MOVEMENT, PLAYER, RENDER, MISC, CLIENT}
}
