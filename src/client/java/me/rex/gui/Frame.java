package me.rex.gui;

import me.rex.module.Category;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import me.rex.VanguardClient;

import java.awt.*;

public class Frame {
    public int x, y, width, height;
    public Category category;
    public boolean draggable;
    public Frame(Category category, int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.category = category;
        this.width = width;
        this.height = height;
        this.draggable = false;
    }
    public void render(DrawContext context, int mouseX, int mouseY, float delta){
        context.fill(this.x, this.y, this.x + this.width, this.y + this.height, -1);
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, category.name(), x + 2, y + 2, Color.black.getRGB());
    }
    public void mouseClicked(double mouseX, double mouseY, int button) {

    }
}