package me.coderfrish.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class IntegerContent extends BaseContent {
    public byte[] content;

    public IntegerContent(DataInputStream buffer) throws IOException {
        super(buffer);
        byte[] content = new byte[4];
        buffer.readFully(content);
        this.content = content;
    }
}
