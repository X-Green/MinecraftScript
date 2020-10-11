package dev.eeasee.minecraft_client_script.gui.script_manager.widgets;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Element;

import java.util.List;

public class AbstractScriptManagerPageWidget extends AbstractParentElement {

    protected final List<Element> children = Lists.newArrayList();

    @Override
    public List<? extends Element> children() {
        return this.children;
    }
}
