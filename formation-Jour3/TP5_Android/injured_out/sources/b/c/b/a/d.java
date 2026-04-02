package b.c.b.a;
/* loaded from: classes.dex */
public final class d {
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z, String str, char c2) {
        if (!z) {
            throw new IllegalArgumentException(e.a(str, Character.valueOf(c2)));
        }
    }

    public static void d(boolean z, String str, char c2, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(e.a(str, Character.valueOf(c2), obj));
        }
    }

    public static void e(boolean z, String str, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(e.a(str, obj));
        }
    }

    public static void f(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(e.a(str, obj, obj2));
        }
    }

    public static <T> T g(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static <T> T h(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
