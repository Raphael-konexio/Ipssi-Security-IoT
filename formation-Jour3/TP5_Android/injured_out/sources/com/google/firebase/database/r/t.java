package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class t extends k<t> {
    private final String h;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2372a;

        static {
            int[] iArr = new int[n.b.values().length];
            f2372a = iArr;
            try {
                iArr[n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2372a[n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public t(String str, n nVar) {
        super(nVar);
        this.h = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.h.equals(tVar.h) && this.f.equals(tVar.f);
        }
        return false;
    }

    @Override // com.google.firebase.database.r.k
    protected k.b g() {
        return k.b.String;
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
    public int d(t tVar) {
        return this.h.compareTo(tVar.h);
    }

    @Override // com.google.firebase.database.r.n
    /* renamed from: s */
    public t j(n nVar) {
        return new t(this.h, nVar);
    }

    @Override // com.google.firebase.database.r.n
    public String v(n.b bVar) {
        StringBuilder sb;
        String str;
        int i = a.f2372a[bVar.ordinal()];
        if (i == 1) {
            sb = new StringBuilder();
            sb.append(i(bVar));
            sb.append("string:");
            str = this.h;
        } else if (i != 2) {
            throw new IllegalArgumentException("Invalid hash version for string node: " + bVar);
        } else {
            sb = new StringBuilder();
            sb.append(i(bVar));
            sb.append("string:");
            str = com.google.firebase.database.p.g0.l.i(this.h);
        }
        sb.append(str);
        return sb.toString();
    }
}
