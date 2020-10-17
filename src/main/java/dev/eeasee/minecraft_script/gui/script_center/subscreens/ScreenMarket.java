package dev.eeasee.minecraft_script.gui.script_center.subscreens;

import dev.eeasee.minecraft_script.utils.InModTranslatableScreenTexts;
import dev.eeasee.minecraft_script.utils.ScreenBackToParentOnClose;
import net.minecraft.client.gui.screen.Screen;

public class ScreenMarket extends ScreenBackToParentOnClose {
    public ScreenMarket(Screen parent) {
        super(InModTranslatableScreenTexts.SubScreens.SCRIPT_MARKET, parent);
    }
}
