package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class DynamicContent extends BaseContent {
    public final int bootstrap_method_attr_index;
    public final int name_and_type_index;

    public DynamicContent(DataInputStream stream) throws IOException {
        super(stream);
        this.bootstrap_method_attr_index = stream.readShort();
        this.name_and_type_index = stream.readShort();
    }
}
