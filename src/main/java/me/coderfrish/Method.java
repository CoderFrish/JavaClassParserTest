package me.coderfrish;

import me.coderfrish.contents.UTF8Content;
import me.coderfrish.manager.AttributesManager;
import me.coderfrish.modifier.FieldModifier;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

public class Method {
    public final List<FieldModifier> modifiers = new ArrayList<>();
    public final List<BaseAttribute> attributes = new ArrayList<>();
    public final String name;
    public final String descriptor;

    public Method(DataInputStream stream) throws java.lang.Exception {
        int access_flags = stream.readShort();
        FieldModifier.getMap().forEach((k, v) -> {
            if ((access_flags & k) != 0) {
                modifiers.add(v);
            }
        });

        int name_index = stream.readShort();
        UTF8Content name_utf8_content = (UTF8Content) Main.contents.get(name_index);
        this.name = name_utf8_content.content;

        int descriptor_index = stream.readShort();
        UTF8Content descriptor_utf8_content = (UTF8Content) Main.contents.get(descriptor_index);
        this.descriptor = descriptor_utf8_content.content;

        int attributes_count = stream.readShort();
        for (int i = 0; i < attributes_count; i++) {
            int attribute_name_index = stream.readShort();
            UTF8Content content = (UTF8Content) Main.contents.get(attribute_name_index);
            attributes.add(AttributesManager.getAttribute(content.content, stream));
        }
    }
}
