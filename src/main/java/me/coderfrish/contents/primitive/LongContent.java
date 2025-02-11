package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class LongContent extends BaseContent {
    public final long value;

    public LongContent(DataInputStream stream) throws IOException {
        super(stream);
        byte[] bytes = new byte[8];
        stream.readFully(bytes);
        this.value = ByteBuffer.wrap(bytes).getLong();
    }
}
