package d.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends e {
    public static int a(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int b(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static int c(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static a d(int i, int i2) {
        return a.i.a(i, i2, -1);
    }

    public static c e(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? c.k.a() : new c(i, i2 - 1);
    }
}
