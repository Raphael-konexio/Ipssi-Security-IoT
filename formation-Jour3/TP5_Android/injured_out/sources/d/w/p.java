package d.w;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends o {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends d.s.d.h implements d.s.c.p<CharSequence, Integer, d.i<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List f;
        final /* synthetic */ boolean g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List list, boolean z) {
            super(2);
            this.f = list;
            this.g = z;
        }

        @Override // d.s.c.p
        public /* bridge */ /* synthetic */ d.i<? extends Integer, ? extends Integer> a(CharSequence charSequence, Integer num) {
            return d(charSequence, num.intValue());
        }

        public final d.i<Integer, Integer> d(CharSequence charSequence, int i) {
            d.s.d.g.e(charSequence, "$receiver");
            d.i i2 = p.i(charSequence, this.f, i, this.g, false);
            if (i2 != null) {
                return d.k.a(i2.c(), Integer.valueOf(((String) i2.d()).length()));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends d.s.d.h implements d.s.c.l<d.t.c, String> {
        final /* synthetic */ CharSequence f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(CharSequence charSequence) {
            super(1);
            this.f = charSequence;
        }

        @Override // d.s.c.l
        /* renamed from: d */
        public final String c(d.t.c cVar) {
            d.s.d.g.e(cVar, "it");
            return p.E(this.f, cVar);
        }
    }

    static /* synthetic */ d.v.b A(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return z(charSequence, strArr, i, z, i2);
    }

    public static final boolean B(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        d.s.d.g.e(charSequence, "$this$regionMatchesImpl");
        d.s.d.g.e(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!d.w.b.b(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final d.v.b<String> C(CharSequence charSequence, String[] strArr, boolean z, int i) {
        d.s.d.g.e(charSequence, "$this$splitToSequence");
        d.s.d.g.e(strArr, "delimiters");
        return d.v.c.b(A(charSequence, strArr, 0, z, i, 2, null), new b(charSequence));
    }

    public static /* synthetic */ d.v.b D(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return C(charSequence, strArr, z, i);
    }

    public static final String E(CharSequence charSequence, d.t.c cVar) {
        d.s.d.g.e(charSequence, "$this$substring");
        d.s.d.g.e(cVar, "range");
        return charSequence.subSequence(cVar.m().intValue(), cVar.l().intValue() + 1).toString();
    }

    public static final String F(String str, char c2, String str2) {
        d.s.d.g.e(str, "$this$substringAfterLast");
        d.s.d.g.e(str2, "missingDelimiterValue");
        int u = u(str, c2, 0, false, 6, null);
        if (u == -1) {
            return str2;
        }
        String substring = str.substring(u + 1, str.length());
        d.s.d.g.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String G(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return F(str, c2, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d.i<Integer, String> i(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        int d2;
        Object obj;
        String str;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str2 = (String) d.o.g.m(collection);
            int q = !z2 ? q(charSequence, str2, i, false, 4, null) : v(charSequence, str2, i, false, 4, null);
            if (q < 0) {
                return null;
            }
            return d.k.a(Integer.valueOf(q), str2);
        }
        d.t.a cVar = !z2 ? new d.t.c(d.t.d.a(i, 0), charSequence.length()) : d.t.d.d(d.t.d.b(i, k(charSequence)), 0);
        if (!(charSequence instanceof String)) {
            d2 = cVar.d();
            int e = cVar.e();
            int f = cVar.f();
            if (f < 0 ? d2 >= e : d2 <= e) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        String str3 = (String) obj;
                        if (B(str3, 0, charSequence, d2, str3.length(), z)) {
                            break;
                        }
                    }
                    str = (String) obj;
                    if (str == null) {
                        if (d2 == e) {
                            break;
                        }
                        d2 += f;
                    } else {
                        break;
                    }
                }
            }
            return null;
        }
        d2 = cVar.d();
        int e2 = cVar.e();
        int f2 = cVar.f();
        if (f2 < 0 ? d2 >= e2 : d2 <= e2) {
            while (true) {
                Iterator<T> it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    String str4 = (String) obj2;
                    if (o.g(str4, 0, (String) charSequence, d2, str4.length(), z)) {
                        break;
                    }
                }
                str = (String) obj2;
                if (str == null) {
                    if (d2 == e2) {
                        break;
                    }
                    d2 += f2;
                } else {
                    break;
                }
            }
            return d.k.a(Integer.valueOf(d2), str);
        }
        return null;
    }

    public static final d.t.c j(CharSequence charSequence) {
        d.s.d.g.e(charSequence, "$this$indices");
        return new d.t.c(0, charSequence.length() - 1);
    }

    public static final int k(CharSequence charSequence) {
        d.s.d.g.e(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final int l(CharSequence charSequence, char c2, int i, boolean z) {
        d.s.d.g.e(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? r(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static final int m(CharSequence charSequence, String str, int i, boolean z) {
        d.s.d.g.e(charSequence, "$this$indexOf");
        d.s.d.g.e(str, "string");
        return (z || !(charSequence instanceof String)) ? o(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    private static final int n(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        d.t.a cVar = !z2 ? new d.t.c(d.t.d.a(i, 0), d.t.d.b(i2, charSequence.length())) : d.t.d.d(d.t.d.b(i, k(charSequence)), d.t.d.a(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int d2 = cVar.d();
            int e = cVar.e();
            int f = cVar.f();
            if (f >= 0) {
                if (d2 > e) {
                    return -1;
                }
            } else if (d2 < e) {
                return -1;
            }
            while (!o.g((String) charSequence2, 0, (String) charSequence, d2, charSequence2.length(), z)) {
                if (d2 == e) {
                    return -1;
                }
                d2 += f;
            }
            return d2;
        }
        int d3 = cVar.d();
        int e2 = cVar.e();
        int f2 = cVar.f();
        if (f2 >= 0) {
            if (d3 > e2) {
                return -1;
            }
        } else if (d3 < e2) {
            return -1;
        }
        while (!B(charSequence2, 0, charSequence, d3, charSequence2.length(), z)) {
            if (d3 == e2) {
                return -1;
            }
            d3 += f2;
        }
        return d3;
    }

    static /* synthetic */ int o(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return n(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static /* synthetic */ int p(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l(charSequence, c2, i, z);
    }

    public static /* synthetic */ int q(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m(charSequence, str, i, z);
    }

    public static final int r(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        char b2;
        d.s.d.g.e(charSequence, "$this$indexOfAny");
        d.s.d.g.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            b2 = d.o.e.b(cArr);
            return ((String) charSequence).indexOf(b2, i);
        }
        int a2 = d.t.d.a(i, 0);
        int k = k(charSequence);
        if (a2 > k) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(a2);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                } else if (d.w.b.b(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return a2;
            }
            if (a2 == k) {
                return -1;
            }
            a2++;
        }
    }

    public static final int s(CharSequence charSequence, char c2, int i, boolean z) {
        d.s.d.g.e(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? w(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static final int t(CharSequence charSequence, String str, int i, boolean z) {
        d.s.d.g.e(charSequence, "$this$lastIndexOf");
        d.s.d.g.e(str, "string");
        return (z || !(charSequence instanceof String)) ? n(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ int u(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = k(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return s(charSequence, c2, i, z);
    }

    public static /* synthetic */ int v(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = k(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return t(charSequence, str, i, z);
    }

    public static final int w(CharSequence charSequence, char[] cArr, int i, boolean z) {
        char b2;
        d.s.d.g.e(charSequence, "$this$lastIndexOfAny");
        d.s.d.g.e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            b2 = d.o.e.b(cArr);
            return ((String) charSequence).lastIndexOf(b2, i);
        }
        for (int b3 = d.t.d.b(i, k(charSequence)); b3 >= 0; b3--) {
            char charAt = charSequence.charAt(b3);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (d.w.b.b(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                return b3;
            }
        }
        return -1;
    }

    public static final d.v.b<String> x(CharSequence charSequence) {
        d.s.d.g.e(charSequence, "$this$lineSequence");
        return D(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> y(CharSequence charSequence) {
        d.s.d.g.e(charSequence, "$this$lines");
        return d.v.c.d(x(charSequence));
    }

    private static final d.v.b<d.t.c> z(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        List a2;
        if (i2 >= 0) {
            a2 = d.o.d.a(strArr);
            return new d(charSequence, i, i2, new a(a2, z));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }
}
