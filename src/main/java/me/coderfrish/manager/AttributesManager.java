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
        return attributes.get(name).getConstructor(DataInputStream.class).newInstance(stream);
    }
}
