package me.coderfrish.modifier;

import java.util.HashMap;
import java.util.Map;

public enum Modifier {
    ACC_PUBLIC(0x0001),
    ACC_FINAL(0x0010),
    ACC_SUPER(0x0020),
    ACC_INTERFACE(0x0200),
    ACC_ABSTRACT(0x0400),
    ACC_SYNTHETIC(0x1000),
    ACC_ANNOTATION(0x2000),
    ACC_ENUM(0x4000),
    ACC_MODULE(0x8000);

    private final int value;

    Modifier(int value) {
        this.value = value;
    }

    private static final Map<Integer, Modifier> map = new HashMap<>();
    static {
        for (Modifier modifier : values()) {
            map.put(modifier.value, modifier);
        }
    }

    public static Map<Integer, Modifier> getMap() {
        return map;
    }
}
