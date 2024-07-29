package me.rex.module;

import me.rex.module.modules.client.ClickGUI;
import me.rex.module.modules.combat.AutoCrystal;
import me.rex.module.modules.misc.TestingPlayer;
import me.rex.module.modules.movement.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager {
    public static final ModuleManager INSTANCE = new ModuleManager();
    public ArrayList<Module> modules = new ArrayList<Module>();
    public ModuleManager(){
        //COMBAT
        modules.add(new AutoCrystal());

        //MOVEMENT
        modules.add(new Sprint());
        modules.add(new Flight());

        //RENDER

        //PLAYER

        //MISC
        modules.add(new TestingPlayer());

        //CLIENT
        modules.add(new ClickGUI());

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
    public List<Module> getModulesInCategory(Category category){
        List<Module> categoryModules = new ArrayList<>();
        for(Module module : modules){
            if(module.category == category){
                categoryModules.add(module);
            }
        }
        return categoryModules;
    }
}
