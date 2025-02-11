package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class PackageContent extends BaseContent {
    public final int name_index;

    public PackageContent(DataInputStream stream) throws IOException {
        super(stream);
        this.name_index = stream.readShort();
    }
}
