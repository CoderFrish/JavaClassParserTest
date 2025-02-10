package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeContent extends BaseContent {
    public int descriptor_index;

    public MethodTypeContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.descriptor_index = buffer.readShort();
    }
}
