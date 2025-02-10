package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class UTF8Content extends BaseContent {
    public byte[] content;

    public UTF8Content(DataInputStream buffer) throws IOException {
        super(buffer);
        int length = buffer.readShort();
        byte[] content = new byte[length];
        buffer.readFully(content);
        this.content = content;
    }
}
