package me.rex.gui;

import me.rex.VanguardClient;
import me.rex.module.Module;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class ModuleButton {
    public Module module;
    public Frame parent;
    public int offset;
    public ModuleButton(Module module, int offset, Frame parent){
        this.module = module;
        this.offset = offset;
        this.parent = parent;
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
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        if(isHovered(mouseX, mouseY) && button == 0){
            module.toggle();
        }
    }
    public boolean isHovered(double mouseX, double mouseY){
        return mouseX > parent.x && mouseX < parent.x + parent.width && mouseY > parent.y + offset && mouseY < parent.y + offset + parent.height;
    }
}