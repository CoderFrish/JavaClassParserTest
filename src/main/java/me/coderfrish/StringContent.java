package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class StringContent extends BaseContent {
    public int index;

    public StringContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.index = buffer.readShort();
    }
}
