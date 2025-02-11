# JavaClassParser

感谢[Oracle Docs](https://docs.oracle.com/en/java/javase/22/)提供文档

Java `.class`中结构类型
 - u1 (指的是一个字节的数据，一般在Java的类型中指byte类型)
 - u2 (指的是二个字节的数据，一般在Java的类型中指short类型)
 - u4 (指的是四个字节的数据，一般在Java的类型中指int类型)
 - cp_info (常量池的结构类型)

Java `.class`主要结构
```text
ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}
```

---

### 字段解读：
##### 1，magic
魔数，主要用来校验class文件是否有效，次数通常为`0xCAFEBABE`，转化为十进制是3,405,691,582

##### 2，minor_version，major_version
前者是次要版本后者是主要版本，不需要深入理解，只是让java 知道这个字节码文件是什么版本的。

##### 3，constant_pool_count
常量池数量，对后面读取常量池有用

##### 4，constant_pool
常量池，可以根据前面的`constant_pool_count`来读取，
但是他们每一项都有独特类型：比如UTF8，String，ClassRef等等
