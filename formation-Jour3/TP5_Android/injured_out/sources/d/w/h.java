package d.w;

import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends d.s.d.h implements d.s.c.l<String, String> {
        public static final a f = new a();

        a() {
            super(1);
        }

        @Override // d.s.c.l
        public /* bridge */ /* synthetic */ String c(String str) {
            String str2 = str;
            d(str2);
            return str2;
        }

        public final String d(String str) {
            d.s.d.g.e(str, "line");
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends d.s.d.h implements d.s.c.l<String, String> {
        final /* synthetic */ String f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(1);
            this.f = str;
        }

        @Override // d.s.c.l
        /* renamed from: d */
        public final String c(String str) {
            d.s.d.g.e(str, "line");
            return this.f + str;
        }
    }

    private static final d.s.c.l<String, String> b(String str) {
        return str.length() == 0 ? a.f : new b(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (!d.w.a.a(str.charAt(i))) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    public static final String d(String str, String str2) {
        String c2;
        d.s.d.g.e(str, "$this$replaceIndent");
        d.s.d.g.e(str2, "newIndent");
        List<String> y = p.y(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : y) {
            if (!o.f((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(d.o.g.g(arrayList, 10));
        for (String str3 : arrayList) {
            arrayList2.add(Integer.valueOf(c(str3)));
        }
        Integer num = (Integer) d.o.g.l(arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * y.size());
        d.s.c.l<String, String> b2 = b(str2);
        int c3 = d.o.g.c(y);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : y) {
            int i2 = i + 1;
            String str4 = null;
            if (i < 0) {
                d.o.g.f();
                throw null;
            }
            String str5 = (String) obj2;
            if ((i != 0 && i != c3) || !o.f(str5)) {
                String H = r.H(str5, intValue);
                str4 = (H == null || (c2 = b2.c(H)) == null) ? str5 : c2;
            }
            if (str4 != null) {
                arrayList3.add(str4);
            }
            i = i2;
        }
        StringBuilder sb = new StringBuilder(length);
        d.o.g.i(arrayList3, sb, "\n", null, null, 0, null, null, 124, null);
        String sb2 = sb.toString();
        d.s.d.g.d(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static String e(String str) {
        d.s.d.g.e(str, "$this$trimIndent");
        return d(str, "");
    }
}
