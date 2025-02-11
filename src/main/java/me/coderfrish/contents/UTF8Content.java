package me.coderfrish.contents;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UTF8Content extends BaseContent {
    public final String content;

    public UTF8Content(DataInputStream stream) throws IOException {
        super(stream);
        this.content = readUTF(stream);
    }

    private String readUTF(DataInputStream stream) throws IOException {
        int length = stream.readShort();
        byte[] content = new byte[length];
        stream.readFully(content);

        return new String(content, StandardCharsets.UTF_8);
    }
}
