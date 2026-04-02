package b.c.c;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements b.c.c.l.a {

    /* renamed from: a  reason: collision with root package name */
    private final c f1409a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1410b;

    private b(c cVar, Context context) {
        this.f1409a = cVar;
        this.f1410b = context;
    }

    public static b.c.c.l.a a(c cVar, Context context) {
        return new b(cVar, context);
    }

    @Override // b.c.c.l.a
    public Object get() {
        return c.u(this.f1409a, this.f1410b);
    }
}
