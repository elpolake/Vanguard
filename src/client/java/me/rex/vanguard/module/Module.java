package me.rex.vanguard.module;

import net.minecraft.client.MinecraftClient;

public class Module {
    public String description;
    public String name;
    public Category category;
    public int key;
    public boolean enabled = false;
    protected MinecraftClient mc = MinecraftClient.getInstance();
    public Module(String name, Category category, int key){
        this.name = name;
        this.category = category;
        this.key = key;
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
    }
    public void onDisable(){
    }
    public void onTick(){
    }
}