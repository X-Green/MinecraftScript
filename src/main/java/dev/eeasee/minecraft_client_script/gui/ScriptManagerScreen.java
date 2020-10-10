package dev.eeasee.minecraft_client_script.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;

public class ScriptManagerScreen extends Screen {

    private final String textTitle;

    private Screen parent;

    public ScriptManagerScreen(Screen previousGui) {
        super(new TranslatableText("modmenu.title"));
        this.parent = previousGui;
        this.textTitle = title.asOrderedText().toString();
    }

}
