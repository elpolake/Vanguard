package me.rex.module;

import me.rex.module.modules.movement.*;
import java.util.ArrayList;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    public ArrayList<Module> modules = new ArrayList<Module>();
    public ModuleManager(){
        //COMBAT

        //MOVEMENT
        modules.add(new Sprint());
        modules.add(new Flight());

        //RENDER

        //PLAYER

        //MISC

        //CLIENT

    }

    public Module getModuleByName(String name){
        return modules.stream().filter(module -> module.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    public ArrayList<Module> getEnabledModules(){
        ArrayList<Module> enabled = new ArrayList<>();
        for(Module module : modules){
            if (module.enabled){
                enabled.add(module);
            }
        }
        return enabled;
    }
}
