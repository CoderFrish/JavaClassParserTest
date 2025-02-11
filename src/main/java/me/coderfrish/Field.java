package me.coderfrish;

import me.coderfrish.contents.StringContent;
import me.coderfrish.contents.UTF8Content;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Field {
    public final List<FieldModifier> modifiers = new ArrayList<>();
    public final String name;
    public final String descriptor;
    public final List<Attribute> attributes = new ArrayList<>();

    public Field(DataInputStream stream) throws IOException {
        int access_flags = stream.readShort();
        FieldModifier.getMap().forEach((k, v) -> {
            if ((access_flags & k) != 0) {
                modifiers.add(v);
            }
        });

        int name_index = stream.readShort();
        int descriptor_index = stream.readShort();
        this.name = ((UTF8Content) Main.contents.get(name_index)).content;
        this.descriptor = ((UTF8Content) Main.contents.get(descriptor_index)).content;

        int attributes_count = stream.readShort();
        for (int i = 0; i < attributes_count; i++) {
            attributes.add(new Attribute(stream));
        }
    }
}
