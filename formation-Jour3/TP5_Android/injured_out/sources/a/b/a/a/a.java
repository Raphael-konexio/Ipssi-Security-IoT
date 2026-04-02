package a.b.a.a;
/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f45c;

    /* renamed from: a  reason: collision with root package name */
    private c f46a;

    /* renamed from: b  reason: collision with root package name */
    private c f47b;

    private a() {
        b bVar = new b();
        this.f47b = bVar;
        this.f46a = bVar;
    }

    public static a b() {
        if (f45c != null) {
            return f45c;
        }
        synchronized (a.class) {
            if (f45c == null) {
                f45c = new a();
            }
        }
        return f45c;
    }

    @Override // a.b.a.a.c
    public boolean a() {
        return this.f46a.a();
    }
}
