package d.s.d;

import d.u.d;
/* loaded from: classes.dex */
public abstract class j extends l implements d.u.d {
    public j(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }

    @Override // d.u.d
    public d.a b() {
        return ((d.u.d) i()).b();
    }

    @Override // d.s.c.l
    public Object c(Object obj) {
        return get(obj);
    }

    @Override // d.s.d.a
    protected d.u.a e() {
        m.c(this);
        return this;
    }
}
