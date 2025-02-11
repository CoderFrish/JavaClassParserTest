package me.coderfrish;

import java.util.HashMap;
import java.util.Map;

public enum FieldModifier {
    ACC_PUBLIC(0x0001),
    ACC_PRIVATE(0x0002),
    ACC_PROTECTED(0x0004),
    ACC_STATIC(0x0008),
    ACC_FINAL(0x0010),
    ACC_VOLATILE(	0x0040),
    ACC_TRANSIENT(0x0080),
    ACC_SYNTHETIC(0x1000),
    ACC_ENUM(0x4000);

    private final int value;

    FieldModifier(int value) {
        this.value = value;
    }

    private static final Map<Integer, FieldModifier> map = new HashMap<>();
    static {
        for (FieldModifier modifier : values()) {
            map.put(modifier.value, modifier);
        }
    }

    public static Map<Integer, FieldModifier> getMap() {
        return map;
    }
}
