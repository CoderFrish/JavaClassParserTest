package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeContent extends BaseContent {
    public final int descriptor_index;

    public MethodTypeContent(DataInputStream stream) throws IOException {
        super(stream);
        this.descriptor_index = stream.readShort();
    }
}
