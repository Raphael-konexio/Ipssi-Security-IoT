package b.c.a.b.x;

import android.graphics.Typeface;
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final Typeface f1377a;

    /* renamed from: b  reason: collision with root package name */
    private final InterfaceC0062a f1378b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1379c;

    /* renamed from: b.c.a.b.x.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0062a {
        void a(Typeface typeface);
    }

    public a(InterfaceC0062a interfaceC0062a, Typeface typeface) {
        this.f1377a = typeface;
        this.f1378b = interfaceC0062a;
    }

    private void d(Typeface typeface) {
        if (this.f1379c) {
            return;
        }
        this.f1378b.a(typeface);
    }

    @Override // b.c.a.b.x.f
    public void a(int i) {
        d(this.f1377a);
    }

    @Override // b.c.a.b.x.f
    public void b(Typeface typeface, boolean z) {
        d(typeface);
    }

    public void c() {
        this.f1379c = true;
    }
}
