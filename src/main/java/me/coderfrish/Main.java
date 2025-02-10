package me.coderfrish;

import me.coderfrish.primitive.DoubleContent;
import me.coderfrish.primitive.FloatContent;
import me.coderfrish.primitive.IntegerContent;
import me.coderfrish.primitive.LongContent;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static final Map<Integer, BaseContent> contents = new HashMap<>();
    public static void main(String[] args) throws Exception {
        try(
                InputStream stream = new FileInputStream("D:\\Test\\test\\Main.class");
                DataInputStream data = new DataInputStream(stream)
        ) {
            int magicNumber = data.readInt();
            if (magicNumber != 0xCAFEBABE) {
                throw new RuntimeException("Invalid magic number.");
            }

            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            System.out.println("Version: " + majorVersion + "." + minorVersion);

            short contentPoolSize = data.readShort();
            for (int i = 1; i <= contentPoolSize; i++) {
                int tag = data.read();
                switch (tag) {
                    case 1 -> contents.put(i, new UTF8Content(data));

                    case 3 -> contents.put(i, new IntegerContent(data));
                    case 4 -> contents.put(i, new FloatContent(data));
                    case 5 -> contents.put(i, new LongContent(data));
                    case 6 -> contents.put(i, new DoubleContent(data));

                    case 7 -> contents.put(i, new ClassContent(data));
                    case 8 -> contents.put(i, new StringContent(data));

                    case 9 -> contents.put(i, new FieldContent(data));
                    case 10 -> contents.put(i, new MethodContent(data));
                    case 11 -> contents.put(i, new InterfaceMethodContent(data));
                    case 12 -> contents.put(i, new NameAndTypeContent(data));

                    case 15 -> contents.put(i, new MethodHandleContent(data));
                    case 16 -> contents.put(i, new MethodTypeContent(data));

                    case 18 -> contents.put(i, new InvokeDynamicContent(data));
                }
            }

            // Class
            /*
                ACC_PUBLIC (0x0001): 类是公共的，可以被外部访问。
                ACC_FINAL (0x0010): 类是最终的，不能被继承。
                ACC_SUPER (0x0020): 允许访问父类的方法，通常用于 invokespecial 指令。
                ACC_INTERFACE (0x0200): 表示这是一个接口。
                ACC_ABSTRACT (0x0400): 类是抽象的，不能直接实例化。
                ACC_SYNTHETIC (0x1000): 该类是由编译器自动生成的，而不是手写的。
                ACC_ANNOTATION (0x2000): 类是一个注解类型。
                ACC_ENUM (0x4000): 类是一个枚举类型。
             */

            // Field
            /*
                ACC_PUBLIC (0x0001): 字段是公共的。
                ACC_PRIVATE (0x0002): 字段是私有的。
                ACC_PROTECTED (0x0004): 字段是保护的。
                ACC_STATIC (0x0008): 字段是静态的。
                ACC_FINAL (0x0010): 字段是常量的，不能修改。
                ACC_VOLATILE (0x0040): 字段是易变的，可能会被多个线程并发修改。
                ACC_TRANSIENT (0x0080): 字段是瞬态的，不会被序列化。
                ACC_SYNTHETIC (0x1000): 字段是由编译器生成的，不是由开发者定义的。
                ACC_ENUM (0x4000): 字段是枚举常量。
             */

            // Method
            /*
                ACC_PUBLIC (0x0001): 方法是公共的。
                ACC_PRIVATE (0x0002): 方法是私有的。
                ACC_PROTECTED (0x0004): 方法是保护的。
                ACC_STATIC (0x0008): 方法是静态的。
                ACC_FINAL (0x0010): 方法是最终的，不能被重写。
                ACC_SYNCHRONIZED (0x0020): 方法是同步的。
                ACC_BRIDGE (0x0040): 方法是编译器生成的桥接方法（通常是为了支持泛型）。
                ACC_VARARGS (0x0080): 方法接受可变参数。
                ACC_NATIVE (0x0100): 方法是本地方法（用 JNI 实现）。
                ACC_ABSTRACT (0x0400): 方法是抽象的，必须在子类中实现。
                ACC_STRICT (0x0800): 方法是严格的，用于执行一些严格的错误检查（如，除法操作的异常检测）。
                ACC_SYNTHETIC (0x1000): 方法是由编译器自动生成的。
             */
        }
    }
}
