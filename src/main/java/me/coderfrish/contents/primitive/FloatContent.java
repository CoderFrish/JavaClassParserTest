package me.coderfrish.contents.primitive;

import me.coderfrish.BaseContent;

import java.io.DataInputStream;
import java.io.IOException;

public class FloatContent extends BaseContent {
    public final float value;

    public FloatContent(DataInputStream stream) throws IOException {
        super(stream);
        this.value = Float.intBitsToFloat(new IntegerContent(stream).value);
    }
}
