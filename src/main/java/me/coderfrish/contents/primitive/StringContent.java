package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class StringContent extends BaseContent {
    public final int string_index;

    public StringContent(DataInputStream stream) throws IOException {
        super(stream);
        this.string_index = stream.readShort();
    }
}
