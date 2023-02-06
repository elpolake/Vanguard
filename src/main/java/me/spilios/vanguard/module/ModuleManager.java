package me.spilios.vanguard.module;

import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleManager(){
        //COMBAT

        //MOVEMENT

        //RENDER

        //PLAYER

        //MISC

        //CLIENT

    }

    public Module getModuleByName(String name){
        return modules.stream().filter(module -> module.name.equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
