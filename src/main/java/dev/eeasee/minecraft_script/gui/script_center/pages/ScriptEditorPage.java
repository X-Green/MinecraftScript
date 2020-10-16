package dev.eeasee.minecraft_script.gui.script_center.pages;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

public class ScriptEditorPage extends AbstractScriptCenterPageWidget {
    public ScriptEditorPage(Screen background) {
        super(background);
    }

    @Override
    public void render(MatrixStack matrices) {
        this.renderBackground(matrices);
    }

    @Override
    protected void prepare() {

    }

    @Override
    protected void eliminate() {

    }
}
