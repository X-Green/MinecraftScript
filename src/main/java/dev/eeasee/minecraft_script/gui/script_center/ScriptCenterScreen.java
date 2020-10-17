package dev.eeasee.minecraft_script.gui.script_center;

import dev.eeasee.minecraft_script.gui.script_center.subscreens.ScreenBrowse;
import dev.eeasee.minecraft_script.gui.script_center.subscreens.ScreenCreate;
import dev.eeasee.minecraft_script.gui.script_center.subscreens.ScreenMarket;
import dev.eeasee.minecraft_script.utils.InModTranslatableScreenTexts;
import dev.eeasee.minecraft_script.utils.ScreenBackToParentOnClose;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.TranslatableText;

public class ScriptCenterScreen extends ScreenBackToParentOnClose {

    public ScriptCenterScreen(Screen previousGui) {
        super(InModTranslatableScreenTexts.SCRIPT_CENTER, previousGui);
    }

    @Override
    protected void init() {
        this.addScreenAndButton();
    }

    private void addScreenAndButton() {
        this.addButton(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 * 1 - 16, 204, 20,
                InModTranslatableScreenTexts.SubScreens.BROWSE_SCRIPTS,
                (buttonWidget) -> this.client.openScreen(new ScreenBrowse(this.parent))));
        this.addButton(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 * 2 - 16, 204, 20,
                InModTranslatableScreenTexts.SubScreens.CREATE_NEW_SCRIPT,
                (buttonWidget) -> this.client.openScreen(new ScreenCreate(this.parent))));
        this.addButton(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 * 3 - 16, 204, 20,
                InModTranslatableScreenTexts.SubScreens.SCRIPT_MARKET,
                (buttonWidget) -> this.client.openScreen(new ScreenMarket(this.parent))));
        this.addButton(new ButtonWidget(this.width / 2 - 102, this.height / 4 + 24 * 5 - 16, 204, 20,
                ScreenTexts.BACK,
                (buttonWidget) -> this.onClose()));
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        System.out.println("X:" + mouseX + "  Y:" + mouseY + "  B:" + button);
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);

        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);

        // Render buttons
        super.render(matrices, mouseX, mouseY, delta);
    }

}
