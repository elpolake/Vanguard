package me.rex.vanguard.gui.setting;

import me.rex.vanguard.gui.ModuleButton;
import me.rex.vanguard.settings.NumberSetting;
import me.rex.vanguard.settings.Setting;
import me.rex.vanguard.VanguardClient;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberBox extends Component{
    private NumberSetting numberSetting;
    public NumberBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.numberSetting = (NumberSetting) setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, setting.name, parent.parent.x + 2, parent.parent.y + offset + 2, -1);
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, String.valueOf(numberSetting.getValueInt()), parent.parent.x + 2, parent.parent.y + offset + 12, Color.GREEN.getRGB());
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public void mouseReleased(double mouseX, double mouseY, int button) {
        super.mouseReleased(mouseX, mouseY, button);
    }

    public double roundRoundToPlace(double value, int place){
        if(place < 0) return value;
        else return new BigDecimal(value).setScale(place, RoundingMode.UP).doubleValue();
    }
}