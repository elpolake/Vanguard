package me.rex.vanguard.gui.setting;

import me.rex.vanguard.settings.BoolSetting;
import me.rex.vanguard.gui.ModuleButton;
import me.rex.vanguard.settings.Setting;
import me.rex.vanguard.VanguardClient;
import net.minecraft.client.gui.DrawContext;
import java.awt.*;

public class BoolBox extends Component {

    private BoolSetting boolSetting;

    public BoolBox(Setting setting, ModuleButton parent, int offset) {
        super(setting, parent, offset);
        if (setting instanceof BoolSetting) {
            this.boolSetting = (BoolSetting) setting;
        } else {
            throw new IllegalArgumentException("Setting must be a BoolSetting");
        }
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);

        // Position the box and set its size
        int boxX = parent.parent.x + 2;
        int boxWidth = parent.parent.width - 4;
        int boxY = parent.parent.y + offset + 2;
        int boxHeight = parent.parent.height - 4;

        // Draw the background of the setting box
        context.fill(boxX, boxY, boxX + boxWidth, boxY + boxHeight, new Color(50, 50, 50).getRGB());

        // Set the color based on the value of the setting (green if enabled, red if disabled)
        Color color = boolSetting.getValue() ? Color.GREEN : Color.RED;
        context.fill(boxX, boxY, boxX + boxWidth, boxY + boxHeight, color.getRGB());

        // Draw the setting name above the box
        context.drawTextWithShadow(VanguardClient.INSTANCE.mc.textRenderer, setting.name,
                parent.parent.x + 2, parent.parent.y + offset + 2, -1);
    }

    @Override
    public void mouseClicked(double mouseX, double mouseY, int button) {
        // Toggle the setting when the box is clicked
        if (isHovered(mouseX, mouseY) && button == 0) {  // Only left-clicks (button 0)
            boolSetting.toggle();  // Toggle the setting value
        }
    }
}
