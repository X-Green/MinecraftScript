package dev.eeasee.minecraft_client_script.mixin;

import dev.eeasee.minecraft_client_script.gui.ScriptManagerButtonWidget;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class MixinGameMenuScreen extends Screen {

    public MixinGameMenuScreen(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgets()V")
    private void drawMenuButton(CallbackInfo info) {
        System.out.println("LOLOLOLOLOLOL");
        addButton(ScriptManagerButtonWidget.newScriptManagerButtonWidget(this));
    }
}