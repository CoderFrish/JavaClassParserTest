package me.coderfrish.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class LongContent extends BaseContent {
    public byte[] content;

    public LongContent(DataInputStream buffer) throws IOException {
        super(buffer);
        byte[] content = new byte[8];
        buffer.readFully(content);
        this.content = content;
    }
}
