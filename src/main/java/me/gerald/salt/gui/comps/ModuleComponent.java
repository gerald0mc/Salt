package me.gerald.salt.gui.comps;

import me.gerald.salt.gui.api.AbstractContainer;
import me.gerald.salt.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;

public class ModuleComponent extends AbstractContainer {
    public Module module;

    public ModuleComponent(Module module, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.module = module;
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x, y, x + width, y + height, module.isEnabled() ? new Color(255, 0, 0).getRGB() : new Color(0, 0, 0, 146).getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(module.getName(), x + 2, y + ((height - Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT) / 2f), -1);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if (isInside(mouseX, mouseY))
            module.toggle();
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) { }

    @Override
    public void keyTyped(char keyChar, int key) { }

    @Override
    public int getHeight() {
        return height;
    }
}
