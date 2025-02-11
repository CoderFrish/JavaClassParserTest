package me.coderfrish.manager;

import me.coderfrish.BaseAttribute;
import me.coderfrish.attribute.ConstantValueAttribute;

import java.io.DataInputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class AttributesManager {
    private static final Map<String, Class<? extends BaseAttribute>> attributes = new HashMap<>();

    private static void registerAttribute(String name, Class<? extends BaseAttribute> clazz) {
        attributes.put(name, clazz);
    }

    static {
        registerAttribute("ConstantValue", ConstantValueAttribute.class);
    }

    public static BaseAttribute getAttribute(String name, DataInputStream stream) throws Exception {
        Class<? extends BaseAttribute> clazz = attributes.get(name);
        if (clazz == null) {
            throw new RuntimeException(name + "is not extist.");
        }

        return clazz.getConstructor(DataInputStream.class).newInstance(stream);
    }
}
