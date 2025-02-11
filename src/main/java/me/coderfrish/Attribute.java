package me.coderfrish;

import me.coderfrish.contents.UTF8Content;

import java.io.DataInputStream;
import java.io.IOException;

public class Attribute {
    public final String name;

    /* 这里先不理着 */
    public final byte[] attribute_info;

    public Attribute(DataInputStream stream) throws IOException {
        int attribute_name_index = stream.readShort();
        this.name = ((UTF8Content) Main.contents.get(attribute_name_index)).content;

        int attribute_length = stream.readInt();
        this.attribute_info = new byte[attribute_length];
        stream.readFully(attribute_info);
    }
}
