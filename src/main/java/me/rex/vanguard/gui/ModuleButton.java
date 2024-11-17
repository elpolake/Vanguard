package me.rex.vanguard.gui;

import me.rex.vanguard.VanguardClient;
import me.rex.vanguard.gui.setting.BoolBox;
import me.rex.vanguard.gui.setting.Component;
import me.rex.vanguard.gui.setting.EnumBox;
import me.rex.vanguard.gui.setting.NumberBox;
import me.rex.vanguard.module.Module;
import me.rex.vanguard.settings.BoolSetting;
import me.rex.vanguard.settings.EnumSetting;
import me.rex.vanguard.settings.NumberSetting;
import me.rex.vanguard.settings.Setting;
import me.rex.vanguard.settings.SliderSetting;
import me.rex.vanguard.gui.setting.SliderBox;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleButton {
    public Module module;
    public Frame parent;
    public int offset;

    public List<Component> components;
    public boolean extended;

    public ModuleButton(Module module, int offset, Frame parent){
        this.module = module;
        this.offset = offset;
        this.parent = parent;
        this.components = new ArrayList<>();
        this.extended = false;

        int setOffset = parent.height;
        for(Setting setting : module.settings){
            if(setting instanceof BoolSetting){
                components.add(new BoolBox(setting, this, setOffset));
            }else if(setting instanceof NumberSetting){
                components.add(new NumberBox(setting, this, setOffset));
            } else if(setting instanceof EnumSetting){
                components.add(new EnumBox(setting, this, setOffset));
            } else if (setting instanceof SliderSetting) {
                components.add(new SliderBox(setting, this, setOffset));
            }
        }
    }
    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, Color.PINK.getRGB());
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, module.name, parent.x + 2, parent.y + offset + 2, -1);
        if(isHovered(mouseX, mouseY)){
            context.fill(parent.x, parent.y + offset, parent.x + parent.width, parent.y + offset + parent.height, new Color(0, 0, 0, 160).getRGB());
        }
        if(module.enabled){
            context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, module.name, parent.x + 2, parent.y + offset + 2, Color.MAGENTA.getRGB());
        }
        if(extended) {
            for (Component component : components) {
                component.render(context, mouseX, mouseY, delta);
            }
        }
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if (isHovered(mouseX, mouseY) && button == 0) {
            module.toggle(); // Toggle the module on left-click
        } else if (isHovered(mouseX, mouseY) && button == 1) {
            extended = !extended; // Toggle the extended state on right-click
            parent.updateButtons();
        }

        // Iterate through components and pass the mouse event
        for (Component component : components) {
            if (component.isHovered(mouseX, mouseY)) {
                component.mouseClicked(mouseX, mouseY, button); // Pass the click to the component
            }
        }
    }


    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}