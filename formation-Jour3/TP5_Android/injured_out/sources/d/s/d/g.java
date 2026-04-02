package d.s.d;

import java.util.Arrays;
/* loaded from: classes.dex */
public class g {
    private g() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        h(illegalStateException);
        throw illegalStateException;
    }

    public static void c(Object obj) {
        if (obj != null) {
            return;
        }
        j();
        throw null;
    }

    public static void d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str + " must not be null");
        h(nullPointerException);
        throw nullPointerException;
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        l(str);
        throw null;
    }

    public static void f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        k(str);
        throw null;
    }

    private static String g(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    private static <T extends Throwable> T h(T t) {
        i(t, g.class.getName());
        return t;
    }

    static <T extends Throwable> T i(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static void j() {
        NullPointerException nullPointerException = new NullPointerException();
        h(nullPointerException);
        throw nullPointerException;
    }

    private static void k(String str) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(g(str));
        h(illegalArgumentException);
        throw illegalArgumentException;
    }

    private static void l(String str) {
        NullPointerException nullPointerException = new NullPointerException(g(str));
        h(nullPointerException);
        throw nullPointerException;
    }

    public static void m(String str) {
        d.m mVar = new d.m(str);
        h(mVar);
        throw mVar;
    }

    public static void n(String str) {
        m("lateinit property " + str + " has not been initialized");
        throw null;
    }
}
