package b.c.b.c;
/* loaded from: classes.dex */
final class b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(String str, int i) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " (" + i + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z) {
        if (!z) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
