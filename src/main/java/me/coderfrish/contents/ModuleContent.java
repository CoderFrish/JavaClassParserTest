package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class ModuleContent extends BaseContent {
    public final int name_index;

    public ModuleContent(DataInputStream stream) throws IOException {
        super(stream);
        this.name_index = stream.readShort();
    }
}
