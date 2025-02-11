package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class IntegerContent extends BaseContent {
    public final int value;

    public IntegerContent(DataInputStream stream) throws IOException {
        super(stream);
        byte[] bytes = new byte[4];
        stream.readFully(bytes);
        this.value = ByteBuffer.wrap(bytes).getInt();
    }
}
