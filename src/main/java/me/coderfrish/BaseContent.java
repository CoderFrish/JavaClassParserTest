package me.coderfrish;

import java.io.DataInputStream;

public abstract class BaseContent {
    protected final DataInputStream stream;

    public BaseContent(DataInputStream stream) {
        this.stream = stream;
    }
}
