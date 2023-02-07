package me.spilios.vanguard.settings;

public class SettingInt {
    public String name;
    public int min, max, defaultVal;
    public SettingInt(String name, int defaultVal, int min, int max){
        this.name = name;
        this.defaultVal = defaultVal;
        this.max = max;
        this.min = min;
    }
}
