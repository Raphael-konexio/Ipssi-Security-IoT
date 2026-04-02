package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class a extends k<a> {
    private final boolean h;

    public a(Boolean bool, n nVar) {
        super(nVar);
        this.h = bool.booleanValue();
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.h == aVar.h && this.f.equals(aVar.f);
        }
        return false;
    }

    @Override // com.google.firebase.database.r.k
    protected k.b g() {
        return k.b.Boolean;
    }

    @Override // com.google.firebase.database.r.n
    public Object getValue() {
        return Boolean.valueOf(this.h);
    }

    public int hashCode() {
        boolean z = this.h;
        return (z ? 1 : 0) + this.f.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.database.r.k
    /* renamed from: m */
    public int d(a aVar) {
        boolean z = this.h;
        if (z == aVar.h) {
            return 0;
        }
        return z ? 1 : -1;
    }

    @Override // com.google.firebase.database.r.n
    /* renamed from: s */
    public a j(n nVar) {
        return new a(Boolean.valueOf(this.h), nVar);
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        return i(bVar) + "boolean:" + this.h;
    }
}
