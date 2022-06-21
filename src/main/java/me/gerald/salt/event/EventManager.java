package me.gerald.salt.event;

import me.gerald.salt.Salt;
import me.gerald.salt.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class EventManager extends Event {
    public EventManager() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onInput(InputEvent.KeyInputEvent event) {
        if (Keyboard.getEventKeyState()) {
            int key = Keyboard.getEventKey();
            for (Module module : Salt.INSTANCE.moduleManager.getModules())
                if (module.getKeybind() == key && key != Keyboard.KEY_NONE)
                    module.toggle();
        }
    }
}
