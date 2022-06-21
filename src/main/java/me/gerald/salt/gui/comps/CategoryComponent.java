package me.gerald.salt.gui.comps;

import me.gerald.salt.Salt;
import me.gerald.salt.gui.api.AbstractContainer;
import me.gerald.salt.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

import java.awt.*;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CategoryComponent extends AbstractContainer {
    public Module.Category category;

    public List<ModuleComponent> moduleComponentList = new LinkedList<>();

    public CategoryComponent(Module.Category category, int x, int y, int width, int height) {
        super(x, y, width, height);
        this.category = category;
        int yOffset = y + height;
        for (Module module : Salt.INSTANCE.moduleManager.getModulesInCategory(category)) {
            moduleComponentList.add(new ModuleComponent(module, x, yOffset, width, height));
            yOffset += this.height;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        Gui.drawRect(x, y, x + width, y + height, new Color(255, 0, 0).getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(category.toString(), x + 2, y + ((height - Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT) / 2f), -1);
        for (ModuleComponent component : moduleComponentList) {
            component.drawScreen(mouseX, mouseY, partialTicks);
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        for (ModuleComponent component : moduleComponentList) {
            component.mouseClicked(mouseX, mouseY, mouseButton);
        }
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
