package dev.eeasee.minecraft_client_script.gui.script_manager;

import dev.eeasee.minecraft_client_script.gui.script_manager.widgets.AbstractScriptManagerPageWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.screen.options.ControlsListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;

public class ScriptManagerScreen extends Screen {

    private Screen parent;

    private int pageSequence = 0;

    private ButtonWidget[] pageSelectorButtons;

    private AbstractScriptManagerPageWidget[] pageContents;

    public ScriptManagerScreen(Screen previousGui) {
        super(new TranslatableText("cscript.gui.manager_screen"));
        this.parent = previousGui;
    }

    private ControlsListWidget keyBindingListWidget;
    private ButtonWidget resetButton;

    @Override
    protected void init() {
        this.pageSelectorButtons = new ButtonWidget[3];
        this.pageContents = new AbstractScriptManagerPageWidget[3];
        WidgetFactory.addPage(this, 0, new TranslatableText("Scripts"), new AbstractScriptManagerPageWidget() );
        WidgetFactory.addPage(this, 1, new TranslatableText("Editor"), new AbstractScriptManagerPageWidget());
        WidgetFactory.addPage(this, 2, new TranslatableText("xxx"), new AbstractScriptManagerPageWidget());

        //this.keyBindingListWidget = new ControlsListWidget(this, this.client);
        //this.children.add(this.keyBindingListWidget);
        this.addButton(new ButtonWidget(this.width / 2 - 155 + 160, this.height - 29, 150, 20, ScreenTexts.DONE, (buttonWidget) -> this.client.openScreen(this.parent)));

        this.switchPage(0);
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
        //this.keyBindingListWidget.render(matrices, mouseX, mouseY, delta);
        drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 8, 16777215);


        // this.resetButton.active = bl;
        super.render(matrices, mouseX, mouseY, delta);
    }

    private void switchPage(int sequence) {
        if (sequence >= pageContents.length || sequence < 0) {
            this.pageSequence = 0;
        } else {
            this.pageSequence = sequence;
        }
        for (ButtonWidget widget : this.pageSelectorButtons) {
            widget.active = true;
        }
        this.pageSelectorButtons[this.pageSequence].active = false;
    }

    public AbstractScriptManagerPageWidget currentPage() {
        return pageContents[pageSequence];
    }

    private static class WidgetFactory {
        private static void addPage(ScriptManagerScreen screen, int sequence, Text title, AbstractScriptManagerPageWidget page) {
            final int baseY = 40;
            final int intervalY = 10;
            final int x = 20;
            final int width = 60;
            final int height = 20;
            ButtonWidget.PressAction action = (buttonWidget) -> {
                screen.switchPage(sequence);
            };
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

    public static class ScriptManagerButtonWidget {

        private static final Identifier SCRIPT_MANAGER_ICON_TEXTURE = new Identifier("client_script","textures/gui/manager.png");

        public static ButtonWidget newScriptManagerButtonWidget(Screen screen) {
            return new TexturedButtonWidget(
                    screen.width / 2 + 128,
                    screen.height / 4 + 48 + 72 + 12,
                    20,
                    20,
                    0,
                    0,
                    20,
                    SCRIPT_MANAGER_ICON_TEXTURE,
                    32,
                    64,
                    (buttonWidget) -> MinecraftClient.getInstance().openScreen(new ScriptManagerScreen(screen))
            );
        }
    }
}
