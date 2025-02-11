package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodContent extends BaseContent {
    public final int class_index;
    public final int name_and_type_index;

    public MethodContent(DataInputStream stream) throws IOException {
        super(stream);
        this.class_index = stream.readShort();
        this.name_and_type_index = stream.readShort();
    }
}
