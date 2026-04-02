package d.s.d;

import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class a implements d.u.a, Serializable {
    public static final Object l = C0111a.f;
    private transient d.u.a f;
    protected final Object g;
    private final Class h;
    private final String i;
    private final String j;
    private final boolean k;

    /* renamed from: d.s.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0111a implements Serializable {
        private static final C0111a f = new C0111a();

        private C0111a() {
        }
    }

    public a() {
        this(l);
    }

    protected a(Object obj) {
        this(obj, null, null, null, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Object obj, Class cls, String str, String str2, boolean z) {
        this.g = obj;
        this.h = cls;
        this.i = str;
        this.j = str2;
        this.k = z;
    }

    @Override // d.u.a
    public Object a(Object... objArr) {
        return i().a(objArr);
    }

    public d.u.a d() {
        d.u.a aVar = this.f;
        if (aVar == null) {
            e();
            this.f = this;
            return this;
        }
        return aVar;
    }

    protected abstract d.u.a e();

    public Object f() {
        return this.g;
    }

    public String g() {
        return this.i;
    }

    public d.u.c h() {
        Class cls = this.h;
        if (cls == null) {
            return null;
        }
        return this.k ? m.b(cls) : m.a(cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d.u.a i() {
        d.u.a d2 = d();
        if (d2 != this) {
            return d2;
        }
        throw new d.s.b();
    }

    public String j() {
        return this.j;
    }
}
