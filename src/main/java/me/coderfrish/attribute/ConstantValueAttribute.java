package me.coderfrish.attribute;

import me.coderfrish.BaseAttribute;
import me.coderfrish.BaseContent;
import me.coderfrish.Main;
import me.coderfrish.contents.primitive.DoubleContent;
import me.coderfrish.contents.primitive.FloatContent;
import me.coderfrish.contents.primitive.IntegerContent;
import me.coderfrish.contents.primitive.LongContent;

import java.io.DataInputStream;
import java.io.IOException;

public class ConstantValueAttribute extends BaseAttribute {
    public final Object value;

    public ConstantValueAttribute(DataInputStream stream) throws IOException {
        super(stream);
        int value_index = buffer.readShort();
        BaseContent value_content = Main.contents.get(value_index);
        if (value_content instanceof IntegerContent integerContent) {
            this.value = integerContent.value;
        } else if (value_content instanceof FloatContent floatContent) {
            this.value = floatContent.value;
        } else if (value_content instanceof LongContent longContent) {
            this.value = longContent.value;
        } else if (value_content instanceof DoubleContent doubleContent) {
            this.value = doubleContent.value;
        } else {
            this.value = null;
        }
    }
}
