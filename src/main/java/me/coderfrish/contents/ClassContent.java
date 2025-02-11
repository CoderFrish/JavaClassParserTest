package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassContent extends BaseContent {
    public final int name_index;

    public ClassContent(DataInputStream stream) throws IOException {
        super(stream);
        this.name_index = stream.readShort();
    }
}
