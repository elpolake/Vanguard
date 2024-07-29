package me.rex.gui;

import me.rex.module.Category;
import me.rex.module.Module;
import me.rex.module.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.MatrixStack;
import me.rex.VanguardClient;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame {
    public int x, y, width, height;
    public Category category;
    public boolean draggable;
    private List<ModuleButton> buttons;
    public Frame(Category category, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.category = category;
        this.width = width;
        this.height = height;
        this.draggable = false;
        buttons = new ArrayList<ModuleButton>();
        int offset = height;
        for(Module module : ModuleManager.INSTANCE.getModulesInCategory(category)){
            buttons.add(new ModuleButton(module, offset,this));
            offset += height;
        }
    }
    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        context.fill(this.x, this.y, this.x + this.width, this.y + this.height, Color.MAGENTA.getRGB());
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, category.name(), x + 2, y + 2, -1);
        for (ModuleButton button : buttons){
            button.render(context, mouseX, mouseY, delta);
        }
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {
        for (ModuleButton moduleButton : buttons){
            moduleButton.mouseClicked(mouseX, mouseY, button);
        }
    }
}