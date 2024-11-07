package me.rex.vanguard.gui.setting;

import me.rex.vanguard.VanguardClient;
import me.rex.vanguard.gui.ModuleButton;
import me.rex.vanguard.settings.EnumSetting;
import me.rex.vanguard.settings.Setting;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class EnumBox extends Component{
    private EnumSetting enumSetting;
    public EnumBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.enumSetting = (EnumSetting) setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
       context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, setting.name, parent.parent.x + 2, parent.parent.y + offset + 2, -1);
       context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, enumSetting.defaultMode.name(), parent.parent.x + 2, parent.parent.y + offset + 12, Color.GREEN.getRGB());
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        this.enumSetting = (EnumSetting) setting;
        if(isHovered(mouseX, mouseY)) {
            enumSetting.cycle();
        }
    }
}
