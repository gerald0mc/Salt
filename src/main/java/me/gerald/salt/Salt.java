package me.gerald.salt;

import me.gerald.salt.event.EventManager;
import me.gerald.salt.gui.Click;
import me.gerald.salt.module.ModuleManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = Salt.MOD_ID, name = Salt.MOD_NAME, version = Salt.MOD_VERSION, clientSideOnly = true)
public class Salt {

    public static final String MOD_NAME = "${GRADLE_MOD_NAME}";
    public static final String MOD_ID = "${GRADLE_MOD_ID}";
    public static final String MOD_VERSION = "${GRADLE_MOD_VERSION}";

    @Mod.Instance(Salt.MOD_ID)
    public static Salt INSTANCE;

    public ModuleManager moduleManager;
    public EventManager eventManager;

    public Click clickGUI;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        moduleManager = new ModuleManager();
        eventManager = new EventManager();

        clickGUI = new Click();
    }
}
