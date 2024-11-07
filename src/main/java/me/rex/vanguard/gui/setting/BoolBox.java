package me.rex.vanguard.gui.setting;

import me.rex.vanguard.VanguardClient;
import me.rex.vanguard.gui.ModuleButton;
import me.rex.vanguard.settings.BoolSetting;
import me.rex.vanguard.settings.Setting;
import net.minecraft.client.gui.DrawContext;

import java.awt.*;

public class BoolBox extends Component{
    private BoolSetting boolSetting;
    public BoolBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        this.boolSetting = (BoolSetting)setting;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        if(boolSetting.enabled){
            context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, boolSetting.name, parent.parent.x + 2, parent.parent.y + offset + 2, Color.GREEN.getRGB());
        }else{
            context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, setting.name, parent.parent.x + 2, parent.parent.y + offset + 2, Color.RED.getRGB());
        }
    }

    public void mouseClicked(double mouseX, double mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        boolSetting.toggle();
    }
}