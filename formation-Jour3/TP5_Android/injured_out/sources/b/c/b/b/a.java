package b.c.b.b;

import java.math.RoundingMode;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f1400a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.c.b.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0064a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1401a;

        /* renamed from: b  reason: collision with root package name */
        private final char[] f1402b;

        /* renamed from: c  reason: collision with root package name */
        final int f1403c;

        /* renamed from: d  reason: collision with root package name */
        final int f1404d;
        final int e;
        final int f;
        private final byte[] g;

        C0064a(String str, char[] cArr) {
            b.c.b.a.d.g(str);
            this.f1401a = str;
            b.c.b.a.d.g(cArr);
            this.f1402b = cArr;
            try {
                int d2 = b.c.b.c.a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f1404d = d2;
                int min = Math.min(8, Integer.lowestOneBit(d2));
                try {
                    this.e = 8 / min;
                    this.f = this.f1404d / min;
                    this.f1403c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i = 0; i < cArr.length; i++) {
                        char c2 = cArr[i];
                        b.c.b.a.d.c(c2 < 128, "Non-ASCII character: %s", c2);
                        b.c.b.a.d.c(bArr[c2] == -1, "Duplicate character: %s", c2);
                        bArr[c2] = (byte) i;
                    }
                    this.g = bArr;
                    boolean[] zArr = new boolean[this.e];
                    for (int i2 = 0; i2 < this.f; i2++) {
                        zArr[b.c.b.c.a.a(i2 * 8, this.f1404d, RoundingMode.CEILING)] = true;
                    }
                } catch (ArithmeticException e) {
                    throw new IllegalArgumentException("Illegal alphabet " + new String(cArr), e);
                }
            } catch (ArithmeticException e2) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e2);
            }
        }

        char b(int i) {
            return this.f1402b[i];
        }

        public boolean c(char c2) {
            byte[] bArr = this.g;
            return c2 < bArr.length && bArr[c2] != -1;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0064a) {
                return Arrays.equals(this.f1402b, ((C0064a) obj).f1402b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f1402b);
        }

        public String toString() {
            return this.f1401a;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends d {

        /* renamed from: d  reason: collision with root package name */
        final char[] f1405d;

        private b(C0064a c0064a) {
            super(c0064a, null);
            this.f1405d = new char[512];
            b.c.b.a.d.a(c0064a.f1402b.length == 16);
            for (int i = 0; i < 256; i++) {
                this.f1405d[i] = c0064a.b(i >>> 4);
                this.f1405d[i | 256] = c0064a.b(i & 15);
            }
        }

        b(String str, String str2) {
            this(new C0064a(str, str2.toCharArray()));
        }

        @Override // b.c.b.b.a.d
        a c(C0064a c0064a, Character ch) {
            return new b(c0064a);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends d {
        private c(C0064a c0064a, Character ch) {
            super(c0064a, ch);
            b.c.b.a.d.a(c0064a.f1402b.length == 64);
        }

        c(String str, String str2, Character ch) {
            this(new C0064a(str, str2.toCharArray()), ch);
        }

        @Override // b.c.b.b.a.d
        a c(C0064a c0064a, Character ch) {
            return new c(c0064a, ch);
        }
    }

    /* loaded from: classes.dex */
    static class d extends a {

        /* renamed from: b  reason: collision with root package name */
        final C0064a f1406b;

        /* renamed from: c  reason: collision with root package name */
        final Character f1407c;

        d(C0064a c0064a, Character ch) {
            b.c.b.a.d.g(c0064a);
            this.f1406b = c0064a;
            b.c.b.a.d.e(ch == null || !c0064a.c(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f1407c = ch;
        }

        d(String str, String str2, Character ch) {
            this(new C0064a(str, str2.toCharArray()), ch);
        }

        @Override // b.c.b.b.a
        public a b() {
            return this.f1407c == null ? this : c(this.f1406b, null);
        }

        a c(C0064a c0064a, Character ch) {
            return new d(c0064a, ch);
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.f1406b.equals(dVar.f1406b) && b.c.b.a.c.a(this.f1407c, dVar.f1407c);
            }
            return false;
        }

        public int hashCode() {
            return this.f1406b.hashCode() ^ b.c.b.a.c.b(this.f1407c);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f1406b.toString());
            if (8 % this.f1406b.f1404d != 0) {
                if (this.f1407c == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f1407c);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }
    }

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new d("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new d("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        new b("base16()", "0123456789ABCDEF");
    }

    a() {
    }

    public static a a() {
        return f1400a;
    }

    public abstract a b();
}
