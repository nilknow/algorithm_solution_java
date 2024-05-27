package util;

public class Assert {
    public static void eq(int a, int b) {
        if (a != b) {
            System.out.println("wrong!!!");
        }
    }

    public static void neq(int a, int b) {
        if (a == b) {
            System.out.println("wrong!!!");
        }
    }
}
