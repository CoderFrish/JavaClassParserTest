package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleContent extends BaseContent {
    public final int high_bytes;
    public final int low_bytes;

    public DoubleContent(DataInputStream stream) throws IOException {
        super(stream);
        this.high_bytes = stream.readInt();
        this.low_bytes = stream.readInt();
    }
}
