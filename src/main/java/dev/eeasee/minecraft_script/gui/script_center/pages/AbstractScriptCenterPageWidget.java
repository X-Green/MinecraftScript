package dev.eeasee.minecraft_script.gui.script_center.pages;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;

import java.util.List;

public abstract class AbstractScriptCenterPageWidget extends AbstractParentElement {

    protected final List<Element> children = Lists.newArrayList();

    protected final Screen background;

    private boolean showing = false;

    public AbstractScriptCenterPageWidget(Screen background) {
        this.background = background;
    }

    @Override
    public List<? extends Element> children() {
        return this.children;
    }

    public abstract void render(MatrixStack matrices);

    protected abstract void prepare();

    protected abstract void eliminate();

    public void onShow() {
        if (showing) {
            return;
        }
        this.prepare();
        showing = true;
    }

    public void onHide() {
        if (!showing) {
            return;
        }
        this.eliminate();
        showing = false;
    }

    void renderBackground(MatrixStack matrices) {
        fill(matrices, 80, 24, this.background.width - 20, this.background.height - 36, (100 << 24) & -16777216);
    }
}
