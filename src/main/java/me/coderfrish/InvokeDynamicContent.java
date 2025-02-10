package me.coderfrish;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeDynamicContent extends BaseContent {
    public int bootstrap_method_attr_index;
    public int name_and_type_index;

    public InvokeDynamicContent(DataInputStream buffer) throws IOException {
        super(buffer);
        this.bootstrap_method_attr_index = buffer.readShort();
        this.name_and_type_index = buffer.readShort();
    }
}
