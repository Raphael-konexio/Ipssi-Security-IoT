package c.b;

import java.util.BitSet;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d<String> f1514a = new b();

    /* renamed from: b  reason: collision with root package name */
    static final b.c.b.b.a f1515b = b.c.b.b.a.a().b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0074a {
    }

    /* loaded from: classes.dex */
    class b implements d<String> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<T> extends e<T> {
        private c(String str, boolean z, d<T> dVar) {
            super(str, z, null);
            b.c.b.a.d.f(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            b.c.b.a.d.h(dVar, "marshaller");
        }

        /* synthetic */ c(String str, boolean z, d dVar, C0074a c0074a) {
            this(str, z, dVar);
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
    }

    /* loaded from: classes.dex */
    public static abstract class e<T> {

        /* renamed from: c  reason: collision with root package name */
        private static final BitSet f1516c = a();

        /* renamed from: a  reason: collision with root package name */
        private final String f1517a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1518b;

        private e(String str, boolean z) {
            b.c.b.a.d.h(str, "name");
            String str2 = str;
            this.f1517a = str2;
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            d(lowerCase, z);
            this.f1518b = lowerCase;
            lowerCase.getBytes(b.c.b.a.a.f1399a);
        }

        /* synthetic */ e(String str, boolean z, C0074a c0074a) {
            this(str, z);
        }

        private static BitSet a() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
                bitSet.set(c2);
            }
            for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
                bitSet.set(c3);
            }
            return bitSet;
        }

        public static <T> e<T> b(String str, d<T> dVar) {
            return c(str, false, dVar);
        }

        static <T> e<T> c(String str, boolean z, d<T> dVar) {
            return new c(str, z, dVar, null);
        }

        private static String d(String str, boolean z) {
            b.c.b.a.d.h(str, "name");
            b.c.b.a.d.b(!str.isEmpty(), "token must have at least 1 tchar");
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (!z || charAt != ':' || i != 0) {
                    b.c.b.a.d.d(f1516c.get(charAt), "Invalid character '%s' in key name '%s'", charAt, str);
                }
            }
            return str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1518b.equals(((e) obj).f1518b);
        }

        public final int hashCode() {
            return this.f1518b.hashCode();
        }

        public String toString() {
            return "Key{name='" + this.f1518b + "'}";
        }
    }
}
