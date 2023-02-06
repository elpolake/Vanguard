package me.spilios.vanguard.module;

public class Module {
    public String description;
    public String name;
    public Category category;
    //public int key;
    public boolean enabled;
    public Module(String name, Category category){
        this.name = name;
        this.category = category;
        //this.key = key;
    }
    public void onEnable(){
        enabled = !enabled;
    }
}