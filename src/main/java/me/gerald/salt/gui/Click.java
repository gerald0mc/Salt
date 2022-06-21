package me.gerald.salt.gui;

import me.gerald.salt.gui.comps.CategoryComponent;
import me.gerald.salt.module.Module;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Click extends GuiScreen {
    public List<CategoryComponent> categoryComponentList = new LinkedList<>();

    public Click() {
        int xOffset = 25;
        for (Module.Category category : Module.Category.values()) {
            categoryComponentList.add(new CategoryComponent(category, xOffset, 100, 100, 16));
            xOffset += 110;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for(CategoryComponent component : categoryComponentList) {
            component.drawScreen(mouseX, mouseY, partialTicks);
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        for(CategoryComponent component : categoryComponentList) {
            component.keyTyped(typedChar, keyCode);
        }
        super.keyTyped(typedChar, keyCode);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        for(CategoryComponent component : categoryComponentList) {
            component.mouseClicked(mouseX, mouseY, mouseButton);
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        for(CategoryComponent component : categoryComponentList) {
            component.mouseReleased(mouseX, mouseY, state);
        }
        super.mouseReleased(mouseX, mouseY, state);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
}
