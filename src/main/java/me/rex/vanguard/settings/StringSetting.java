package me.rex.vanguard.settings;

public class StringSetting extends Setting{
    public String value;
    public StringSetting(String name, String value) {
        super(name);
        this.value = value;
    }
}
