package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndTypeContent extends BaseContent {
    public final int name_index;
    public final int descriptor_index;

    public NameAndTypeContent(DataInputStream stream) throws IOException {
        super(stream);
        this.name_index = stream.readShort();
        this.descriptor_index = stream.readShort();
    }
}
