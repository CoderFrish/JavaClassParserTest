package me.coderfrish;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

public abstract class BaseAttribute {
    protected final DataInputStream buffer;

    public BaseAttribute(DataInputStream stream) throws IOException {
        byte[] buffer = new byte[stream.readInt()];
        stream.readFully(buffer);
        ByteArrayInputStream wrapper = new ByteArrayInputStream(buffer);
        this.buffer = new DataInputStream(wrapper);
    }
}
