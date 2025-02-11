package me.coderfrish;

import java.io.IOException;

public class TestImpl implements TestInterface {
    public static final int TEST_INT = 123;
    public static final long TEST_LONG = 4654654654654L;
    public static final double TEST_DOUBLE = 6765.5555;
    public static final float TEST = 123.4F;

    public TestImpl() throws IOException {
        try {
            System.out.println("ssss");
        } catch (MatchException e) {
            throw new IOException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
    }
}
