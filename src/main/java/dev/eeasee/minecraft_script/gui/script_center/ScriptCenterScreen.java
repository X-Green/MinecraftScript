package dev.eeasee.minecraft_script.gui.script_center;

import dev.eeasee.minecraft_script.gui.script_center.pages.AbstractScriptCenterPageWidget;
import dev.eeasee.minecraft_script.gui.script_center.pages.ScriptEditorPage;
import dev.eeasee.minecraft_script.gui.script_center.pages.ScriptManagerPage;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ScriptCenterScreen extends Screen {

    private Screen parent;

    private int pageSequence = 0;

    private ButtonWidget[] pageSelectorButtons;

    private AbstractScriptCenterPageWidget[] pageContents;

    public ScriptCenterScreen(Screen previousGui) {
        super(new TranslatableText("cscript.gui.manager_screen"));
        this.parent = previousGui;
    }

    @Override
    protected void init() {
        this.pageSelectorButtons = new ButtonWidget[3];
        this.pageContents = new AbstractScriptCenterPageWidget[3];
        WidgetFactory.addPage(this, 0, new TranslatableText("Manager"), new ScriptManagerPage(this));
        WidgetFactory.addPage(this, 1, new TranslatableText("Editor"), new ScriptEditorPage(this));
        WidgetFactory.addPage(this, 2, new TranslatableText("xxx"), new ScriptEditorPage(this));

        this.addButton(new ButtonWidget(this.width / 2 - 155 + 160, this.height - 29, 150, 20, ScreenTexts.DONE, (buttonWidget) -> this.client.openScreen(this.parent)));

        this.switchPage(pageSequence);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
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

        // Render page
        this.currentPage().render(matrices);

        // Render buttons
        super.render(matrices, mouseX, mouseY, delta);
    }

    private void switchPage(int sequence) {
        if (sequence >= pageContents.length || sequence < 0) {
            this.pageSequence = 0;
        } else {
            this.pageSequence = sequence;
        }

        for (int i = 0; i < this.pageSelectorButtons.length; i++) {
            if (i != this.pageSequence) {
                this.pageSelectorButtons[i].active = true;
                this.pageContents[i].onHide();
            } else {
                this.pageSelectorButtons[i].active = false;
                this.pageContents[i].onShow();
            }
        }
        for (ButtonWidget widget : this.pageSelectorButtons) {
            widget.active = true;
        }
        this.pageSelectorButtons[this.pageSequence].active = false;
    }

    private AbstractScriptCenterPageWidget currentPage() {
        return pageContents[pageSequence];
    }

    private static class WidgetFactory {
        private static void addPage(ScriptCenterScreen screen, int sequence, Text title, AbstractScriptCenterPageWidget page) {
            final int baseY = 40;
            final int intervalY = 10;
            final int x = 12;
            final int width = 60;
            final int height = 20;
            ButtonWidget.PressAction action = (buttonWidget) -> screen.switchPage(sequence);
            ButtonWidget buttonWidget = new ButtonWidget(
                    x, baseY + (intervalY + height) * sequence, width, height, title, action
            );
            screen.pageSelectorButtons[sequence] = buttonWidget;
            screen.addButton(buttonWidget);

            if (screen.pageContents[sequence] != null) {
                screen.children.remove(screen.pageContents[sequence]);
            }
            screen.addChild(page);
            screen.pageContents[sequence] = page;
        }

    }

}
