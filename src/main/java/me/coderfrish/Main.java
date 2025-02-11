package me.coderfrish;

import me.coderfrish.attribute.ConstantValueAttribute;
import me.coderfrish.contents.*;
import me.coderfrish.contents.primitive.*;
import me.coderfrish.modifier.Modifier;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static final Map<Integer, BaseContent> contents = new HashMap<>();
    private static final List<Modifier> modifiers = new ArrayList<>();
    private static final List<Field> fields = new ArrayList<>();
    private static final List<String> interfaces = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        try(
                InputStream stream = new FileInputStream("D:\\Test\\test\\TestImpl.class");
                DataInputStream data = new DataInputStream(stream)
        ) {
            int magic = data.readInt();
            if (magic != 0xCAFEBABE) {
                System.out.println("Invalid magic number.");
            }

            int minor_version = data.readShort();
            int major_version = data.readShort();
            System.out.println("Version: " + major_version + "." + minor_version);

            int constant_pool_count = data.readShort();
            System.out.println("Constants pool count: " + constant_pool_count);
            for (int i = 1; i <= constant_pool_count - 1; i++) {
                int tag = data.read();
                switch (tag) {
                    case 7 -> contents.put(i, new ClassContent(data));

                    case 9 -> contents.put(i, new FieldContent(data));
                    case 10 -> contents.put(i, new MethodContent(data));
                    case 11 -> contents.put(i, new InterfaceMethodContent(data));

                    case 8 -> contents.put(i, new StringContent(data));

                    case 3 -> contents.put(i, new IntegerContent(data));
                    case 4 -> contents.put(i, new FloatContent(data));

                    case 5 -> {
                        contents.put(i, new LongContent(data));
                        i = i + 1;
                    }
                    case 6 -> {
                        contents.put(i, new DoubleContent(data));
                        i = i + 1;
                    }

                    case 12 -> contents.put(i, new NameAndTypeContent(data));

                    case 1 -> contents.put(i, new UTF8Content(data));

                    case 15 -> contents.put(i, new MethodHandleContent(data));

                    case 16 -> contents.put(i, new MethodTypeContent(data));
                    case 17 -> contents.put(i, new DynamicContent(data));
                    case 18 -> contents.put(i, new InvokeDynamicContent(data));

                    case 19 -> contents.put(i, new ModuleContent(data));
                    case 20 -> contents.put(i, new PackageContent(data));
                }
            }

            int access_flags = data.readShort();
            Modifier.getMap().forEach((k, v) -> {
                if ((access_flags & k) != 0) {
                    modifiers.add(v);
                }
            });

            int this_class = data.readShort();
            ClassContent this_class_content = (ClassContent) contents.get(this_class);
            UTF8Content this_class_utf8_content = (UTF8Content) contents.get(this_class_content.name_index);
            System.out.println("Class name: " + this_class_utf8_content.content);

            int super_class = data.readShort();
            ClassContent super_class_content = (ClassContent) contents.get(super_class);
            UTF8Content super_class_utf8_content = (UTF8Content) contents.get(super_class_content.name_index);
            System.out.println("Super class name: " + super_class_utf8_content.content);

            int interfaces_count = data.readShort();
            System.out.println("Interface count: " + interfaces_count);
            for (int i = 0; i < interfaces_count; i++) {
                int index = data.readShort();
                ClassContent interface_class_content = (ClassContent) contents.get(index);
                UTF8Content interface_utf8_content = (UTF8Content) contents.get(interface_class_content.name_index);
                interfaces.add(interface_utf8_content.content);
            }

            int fields_count = data.readShort();
            for (int i = 0; i < fields_count; i++) {
                fields.add(new Field(data));
            }
        }
    }
}
