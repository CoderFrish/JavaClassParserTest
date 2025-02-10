package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodContent extends BaseContent {
    public int index_0;
    public int index_1;

    public MethodContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.index_0 = buffer.readShort();
        this.index_1 = buffer.readShort();
    }
}
