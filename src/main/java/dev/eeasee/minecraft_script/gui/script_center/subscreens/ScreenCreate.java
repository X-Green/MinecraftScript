package dev.eeasee.minecraft_script.gui.script_center.subscreens;

import dev.eeasee.minecraft_script.utils.InModTranslatableScreenTexts;
import dev.eeasee.minecraft_script.utils.ScreenBackToParentOnClose;
import net.minecraft.client.gui.screen.Screen;

public class ScreenCreate extends ScreenBackToParentOnClose {
    public ScreenCreate(Screen parent) {
        super(InModTranslatableScreenTexts.SubScreens.CREATE_NEW_SCRIPT, parent);
    }
}
