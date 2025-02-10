package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfaceMethodContent extends BaseContent {
    public int index_0;
    public int index_1;

    public InterfaceMethodContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.index_0 = buffer.readShort();
        this.index_1 = buffer.readShort();
    }
}
