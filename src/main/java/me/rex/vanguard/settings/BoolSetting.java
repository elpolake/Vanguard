package me.rex.vanguard.settings;

public class BoolSetting extends Setting {
    private boolean enabled;

    public BoolSetting(String name, boolean defaultValue) {
        super(name);
        this.enabled = defaultValue;
    }

    // Getter for the current state
    public boolean getValue() {
        return enabled;
    }

    // Setter for the value (if you need to set it manually)
    public void setValue(boolean value) {
        this.enabled = value;
    }

    // Toggle the value (switch from true to false or vice versa)
    public void toggle() {
        this.enabled = !this.enabled;
    }
}
