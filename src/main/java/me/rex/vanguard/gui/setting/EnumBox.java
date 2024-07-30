package me.rex.vanguard.gui.setting;

import me.rex.vanguard.gui.ModuleButton;
import me.rex.vanguard.settings.EnumSetting;
import me.rex.vanguard.settings.Setting;
import net.minecraft.client.gui.DrawContext;

public class EnumBox extends Component{
    private EnumSetting enumSetting = (EnumSetting) setting;
    public EnumBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        this.enumSetting = (EnumSetting) setting;
    }
}
