package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassContent extends BaseContent {
    public int index;

    public ClassContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.index = buffer.readShort();
    }
}
