package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class IntegerContent extends BaseContent {
    public final int bytes;

    public IntegerContent(DataInputStream stream) throws IOException {
        super(stream);
        this.bytes = stream.readInt();
    }
}
