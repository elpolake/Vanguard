package me.spilios.vanguard.settings;

public class Setting {
    public String name;
    public int min;
    public int max;
    public int defaultVal;
    public boolean enabled;
    public Setting(String name, int defaultVal, int min, int max, boolean enabled){
        this.name = name;
        this.defaultVal = defaultVal;
        this.max = max;
        this.min = min;
        this.enabled = enabled;
    }
}
