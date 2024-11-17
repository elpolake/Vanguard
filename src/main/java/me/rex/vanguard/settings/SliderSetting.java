package me.rex.vanguard.settings;

public class SliderSetting extends Setting {
    public double min, max, defaultValue;
    public double value;

    public SliderSetting(String name, double min, double max, double defaultValue) {
        super(name);
        this.min = min;
        this.max = max;
        this.defaultValue = defaultValue;
        this.value = defaultValue;  // Start with default value
    }

    public static double clamp(double value, double min, double max) {
        value = Math.max(min, value);
        value = Math.min(max, value);
        return value;
    }

    public float getValueFloat() {
        return (float) value;
    }

    public int getValueInt() {
        return (int) value;
    }

    public void setValue(double value) {
        value = clamp(value, this.min, this.max);
        this.value = value;
    }
}
