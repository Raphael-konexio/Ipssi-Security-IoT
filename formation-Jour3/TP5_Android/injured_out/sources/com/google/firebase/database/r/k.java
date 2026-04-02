package com.google.firebase.database.r;

import com.google.firebase.database.r.k;
import com.google.firebase.database.r.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class k<T extends k> implements n {
    protected final n f;
    private String g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2363a;

        static {
            int[] iArr = new int[n.b.values().length];
            f2363a = iArr;
            try {
                iArr[n.b.V1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2363a[n.b.V2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public enum b {
        DeferredValue,
        Boolean,
        Number,
        String
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(n nVar) {
        this.f = nVar;
    }

    private static int e(l lVar, f fVar) {
        return Double.valueOf(((Long) lVar.getValue()).longValue()).compareTo((Double) fVar.getValue());
    }

    @Override // com.google.firebase.database.r.n
    public int a() {
        return 0;
    }

    @Override // com.google.firebase.database.r.n
    public n b(com.google.firebase.database.r.b bVar) {
        return bVar.w() ? this.f : g.s();
    }

    @Override // com.google.firebase.database.r.n
    public n c() {
        return this.f;
    }

    protected abstract int d(T t);

    @Override // java.lang.Comparable
    /* renamed from: f */
    public int compareTo(n nVar) {
        if (nVar.isEmpty()) {
            return 1;
        }
        if (nVar instanceof c) {
            return -1;
        }
        return ((this instanceof l) && (nVar instanceof f)) ? e((l) this, (f) nVar) : ((this instanceof f) && (nVar instanceof l)) ? e((l) nVar, (f) this) * (-1) : l((k) nVar);
    }

    protected abstract b g();

    @Override // com.google.firebase.database.r.n
    public String getHash() {
        if (this.g == null) {
            this.g = com.google.firebase.database.p.g0.l.h(v(n.b.V1));
        }
        return this.g;
    }

    @Override // com.google.firebase.database.r.n
    public n h(com.google.firebase.database.p.l lVar) {
        return lVar.isEmpty() ? this : lVar.x().w() ? this.f : g.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String i(n.b bVar) {
        int i = a.f2363a[bVar.ordinal()];
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("Unknown hash version: " + bVar);
        } else if (this.f.isEmpty()) {
            return "";
        } else {
            return "priority:" + this.f.v(bVar) + ":";
        }
    }

    @Override // com.google.firebase.database.r.n
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<m> iterator() {
        return Collections.emptyList().iterator();
    }

    @Override // com.google.firebase.database.r.n
    public boolean k() {
        return true;
    }

    protected int l(k<?> kVar) {
        b g = g();
        b g2 = kVar.g();
        return g.equals(g2) ? d(kVar) : g.compareTo(g2);
    }

    @Override // com.google.firebase.database.r.n
    public com.google.firebase.database.r.b n(com.google.firebase.database.r.b bVar) {
        return null;
    }

    @Override // com.google.firebase.database.r.n
    public boolean o(com.google.firebase.database.r.b bVar) {
        return false;
    }

    @Override // com.google.firebase.database.r.n
    public n p(com.google.firebase.database.r.b bVar, n nVar) {
        return bVar.w() ? j(nVar) : nVar.isEmpty() ? this : g.s().p(bVar, nVar).j(this.f);
    }

    @Override // com.google.firebase.database.r.n
    public n q(com.google.firebase.database.p.l lVar, n nVar) {
        com.google.firebase.database.r.b x = lVar.x();
        return x == null ? nVar : (!nVar.isEmpty() || x.w()) ? p(x, g.s().q(lVar.A(), nVar)) : this;
    }

    @Override // com.google.firebase.database.r.n
    public Object r(boolean z) {
        if (!z || this.f.isEmpty()) {
            return getValue();
        }
        HashMap hashMap = new HashMap();
        hashMap.put(".value", getValue());
        hashMap.put(".priority", this.f.getValue());
        return hashMap;
    }

    @Override // com.google.firebase.database.r.n
    public Iterator<m> t() {
        return Collections.emptyList().iterator();
    }

    public String toString() {
        String obj = r(true).toString();
        if (obj.length() <= 100) {
            return obj;
        }
        return obj.substring(0, 100) + "...";
    }
}
