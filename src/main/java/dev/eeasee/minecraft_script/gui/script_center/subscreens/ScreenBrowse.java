package dev.eeasee.minecraft_script.gui.script_center.subscreens;

import dev.eeasee.minecraft_script.utils.InModTranslatableScreenTexts;
import dev.eeasee.minecraft_script.utils.ScreenBackToParentOnClose;
import net.minecraft.client.gui.screen.Screen;

public class ScreenBrowse extends ScreenBackToParentOnClose {
    public ScreenBrowse(Screen parent) {
        super(InModTranslatableScreenTexts.SubScreens.BROWSE_SCRIPTS, parent);
    }
}
