package util;

public class Assert {
    public static void eq(int a, int b) {
        if (a != b) {
            System.out.println("wrong!!! pls check line "+ getCallerLine());
        }
    }

    public static void eq(String a, String b) {
        if (a == null) {
            if (b != null) {
                System.out.println("wrong!!!");
            }
            return;
        }
        if (!a.equals(b)) {
            System.out.println("wrong!!!");
        }
    }

    public static void neq(int a, int b) {
        if (a == b) {
            System.out.println("wrong!!!");
        }
    }

    private static int getCallerLine() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // The first element is the current method, so we need the second element.
        if (stackTrace.length > 3) {
            return stackTrace[3].getLineNumber();
        } else {
            return -1;
        }
    }
}
