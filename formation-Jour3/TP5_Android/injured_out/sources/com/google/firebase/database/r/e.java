package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends k<e> {
    private Map<Object, Object> h;

    public e(Map<Object, Object> map, n nVar) {
        super(nVar);
        this.h = map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            return this.h.equals(eVar.h) && this.f.equals(eVar.f);
        }
        return false;
    }

    @Override // com.google.firebase.database.r.k
    protected k.b g() {
        return k.b.DeferredValue;
    }

    @Override // com.google.firebase.database.r.n
    public Object getValue() {
        return this.h;
    }

    public int hashCode() {
        return this.h.hashCode() + this.f.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.r.k
    /* renamed from: m */
    public int d(e eVar) {
        return 0;
    }

    @Override // com.google.firebase.database.r.n
    /* renamed from: s */
    public e j(n nVar) {
        return new e(this.h, nVar);
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        return i(bVar) + "deferredValue:" + this.h;
    }
}
