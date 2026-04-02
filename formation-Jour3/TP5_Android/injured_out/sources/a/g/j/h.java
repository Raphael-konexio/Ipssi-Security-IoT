package a.g.j;
/* loaded from: classes.dex */
public class h<T> extends g<T> {

    /* renamed from: c  reason: collision with root package name */
    private final Object f221c;

    public h(int i) {
        super(i);
        this.f221c = new Object();
    }

    @Override // a.g.j.g, a.g.j.f
    public boolean a(T t) {
        boolean a2;
        synchronized (this.f221c) {
            a2 = super.a(t);
        }
        return a2;
    }

    @Override // a.g.j.g, a.g.j.f
    public T b() {
        T t;
        synchronized (this.f221c) {
            t = (T) super.b();
        }
        return t;
    }
}
