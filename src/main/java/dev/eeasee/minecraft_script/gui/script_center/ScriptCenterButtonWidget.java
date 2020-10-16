package dev.eeasee.minecraft_script.gui.script_center;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.util.Identifier;

public class ScriptCenterButtonWidget {

    private static final Identifier SCRIPT_MANAGER_ICON_TEXTURE = new Identifier("mine_script","textures/gui/manager.png");

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
                (buttonWidget) -> MinecraftClient.getInstance().openScreen(new ScriptCenterScreen(screen))
        );
    }
}
