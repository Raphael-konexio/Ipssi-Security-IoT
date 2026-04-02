package d.r;

import d.n;
import d.s.c.l;
import d.s.d.g;
import d.v.f;
import java.io.BufferedReader;
import java.io.Reader;
/* loaded from: classes.dex */
public final class c {
    public static final void a(Reader reader, l<? super String, n> lVar) {
        g.e(reader, "$this$forEachLine");
        g.e(lVar, "action");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            for (String str : b(bufferedReader)) {
                lVar.c(str);
            }
            n nVar = n.f2401a;
            a.a(bufferedReader, null);
        } finally {
        }
    }

    public static final d.v.b<String> b(BufferedReader bufferedReader) {
        d.v.b<String> a2;
        g.e(bufferedReader, "$this$lineSequence");
        a2 = f.a(new b(bufferedReader));
        return a2;
    }
}
