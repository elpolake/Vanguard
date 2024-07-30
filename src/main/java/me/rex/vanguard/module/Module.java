package me.rex.vanguard.module;

import net.minecraft.client.MinecraftClient;
import static me.rex.vanguard.utils.EventUtil.EVENT_BUS;

public class Module {
    public String description;
    public String name;
    public Category category;
    public int key;
    public boolean enabled = false;
    public boolean hasListener;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Module(String name, Category category, int key, boolean hasListener){
        this.name = name;
        this.category = category;
        this.key = key;
        this.hasListener = hasListener;
    }
    public void toggle(){
        this.enabled = !this.enabled;
        if(enabled){
            onEnable();
        }else{
            onDisable();
        }
    }
    public void onEnable(){
        if(hasListener){
            EVENT_BUS.register(this);
        }
    }
    public void onDisable(){
        if(hasListener){
            EVENT_BUS.unregister(this);
        }
    }
    public void onTick(){
    }
}