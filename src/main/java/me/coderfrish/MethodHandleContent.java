package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodHandleContent extends BaseContent {
    public int reference_kind;
    public int reference_index;

    public MethodHandleContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.reference_kind = buffer.readShort();
        this.reference_kind = buffer.read();
    }
}
