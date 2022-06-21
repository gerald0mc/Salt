package me.gerald.salt.module;

import me.gerald.salt.module.modules.client.ClickGUI;
import net.minecraftforge.fml.common.Mod;

import java.util.LinkedList;
import java.util.List;

public class ModuleManager {
    private final List<Module> moduleList;

    public ModuleManager() {
        moduleList = new LinkedList<>();
        //COMBAT
        //MOVEMENT
        //PLAYER
        //RENDER
        //MISC
        //CLIENT
        moduleList.add(new ClickGUI());
    }

    public List<Module> getModules() {
        return moduleList;
    }

    public Module getModuleByName(String name) {
        for(Module module : moduleList) {
            if (module.getName().equalsIgnoreCase(name)) return module;
        }
        return null;
    }

    public List<Module> getModulesInCategory(Module.Category category) {
        List<Module> categoryModules = new LinkedList<>();
        for (Module module : getModules()) {
            if (module.getCategory().equals(category)) categoryModules.add(module);
        }
        return categoryModules;
    }
}
