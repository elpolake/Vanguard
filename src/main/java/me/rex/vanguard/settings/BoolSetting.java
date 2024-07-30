package me.rex.vanguard.settings;

public class BoolSetting extends Setting{
    public boolean enabled;
    public BoolSetting(String name, boolean defaultValue){
        super(name);
        this.enabled = defaultValue;
    }

    public void toggle(){
        this.enabled = !this.enabled;
    }
}
