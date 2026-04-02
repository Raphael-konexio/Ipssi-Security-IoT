package b.c.a.a.d.c;
/* loaded from: classes.dex */
public final class m {
    public static int a(int i, int i2) {
        String b2;
        if (i < 0 || i >= i2) {
            if (i < 0) {
                b2 = t.b("%s (%s) must not be negative", "index", Integer.valueOf(i));
            } else if (i2 < 0) {
                StringBuilder sb = new StringBuilder(26);
                sb.append("negative size: ");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            } else {
                b2 = t.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
            }
            throw new IndexOutOfBoundsException(b2);
        }
        return i;
    }

    public static int b(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(f(i, i2, str));
        }
        return i;
    }

    public static <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    public static void d(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException((i < 0 || i > i3) ? f(i, i3, "start index") : (i2 < 0 || i2 > i3) ? f(i2, i3, "end index") : t.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i)));
        }
    }

    public static int e(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(f(i, i2, "index"));
        }
        return i;
    }

    private static String f(int i, int i2, String str) {
        if (i < 0) {
            return t.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return t.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }
}
