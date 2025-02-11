package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodHandleContent extends BaseContent {
    public final int reference_kind;
    public final int reference_index;

    public MethodHandleContent(DataInputStream stream) throws IOException {
        super(stream);
        this.reference_kind = stream.read();
        this.reference_index = stream.readShort();
    }
}
