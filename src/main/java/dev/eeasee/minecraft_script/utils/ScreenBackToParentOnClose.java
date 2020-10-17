package dev.eeasee.minecraft_script.utils;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public abstract class ScreenBackToParentOnClose extends Screen {

    protected final Screen parent;

    protected ScreenBackToParentOnClose(Text title, Screen parent) {
        super(title);
        this.parent = parent;
    }

    @Override
    public void onClose() {
        this.client.openScreen(this.parent);
    }

}
