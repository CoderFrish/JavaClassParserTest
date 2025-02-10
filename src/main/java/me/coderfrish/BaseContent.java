package me.coderfrish;

import java.io.DataInputStream;

public abstract class BaseContent {
    protected final DataInputStream buffer;

    public BaseContent(DataInputStream buffer) {
        this.buffer = buffer;
    }
}
