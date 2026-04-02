package b.a.a.v;

import b.a.a.o;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public class l extends b.a.a.m<String> {
    private final Object u;
    private o.b<String> v;

    public l(int i, String str, o.b<String> bVar, o.a aVar) {
        super(i, str, aVar);
        this.u = new Object();
        this.v = bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.m
    public o<String> S(b.a.a.k kVar) {
        String str;
        try {
            str = new String(kVar.f1159a, g.d(kVar.f1160b));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.f1159a);
        }
        return o.c(str, g.c(kVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b.a.a.m
    /* renamed from: a0 */
    public void i(String str) {
        o.b<String> bVar;
        synchronized (this.u) {
            bVar = this.v;
        }
        if (bVar != null) {
            bVar.a(str);
        }
    }
}
