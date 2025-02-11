package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class DoubleContent extends BaseContent {
    public final double value;

    public DoubleContent(DataInputStream stream) throws IOException {
        super(stream);
        this.value = Double.longBitsToDouble(new LongContent(stream).value);
    }
}
