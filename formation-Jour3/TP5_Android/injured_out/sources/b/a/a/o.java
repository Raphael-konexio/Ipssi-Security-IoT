package b.a.a;

import b.a.a.b;
/* loaded from: classes.dex */
public class o<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f1167a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f1168b;

    /* renamed from: c  reason: collision with root package name */
    public final t f1169c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f1170d;

    /* loaded from: classes.dex */
    public interface a {
        void a(t tVar);
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        void a(T t);
    }

    private o(t tVar) {
        this.f1170d = false;
        this.f1167a = null;
        this.f1168b = null;
        this.f1169c = tVar;
    }

    private o(T t, b.a aVar) {
        this.f1170d = false;
        this.f1167a = t;
        this.f1168b = aVar;
        this.f1169c = null;
    }

    public static <T> o<T> a(t tVar) {
        return new o<>(tVar);
    }

    public static <T> o<T> c(T t, b.a aVar) {
        return new o<>(t, aVar);
    }

    public boolean b() {
        return this.f1169c == null;
    }
}
