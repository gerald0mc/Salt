package com.example.examplemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ExampleMod.MOD_ID, name = ExampleMod.MOD_NAME, version = ExampleMod.MOD_VERSION, clientSideOnly = true)
public class ExampleMod {

    public static final String MOD_NAME = "${GRADLE_MOD_NAME}";
    public static final String MOD_ID = "${GRADLE_MOD_ID}";
    public static final String MOD_VERSION = "${GRADLE_MOD_VERSION}";

    @Mod.Instance(ExampleMod.MOD_ID)
    private static ExampleMod instance;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    public static ExampleMod getInstance() {
        return instance;
    }

}
