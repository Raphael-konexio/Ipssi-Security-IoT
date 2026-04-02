package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.b;
/* loaded from: classes.dex */
public abstract class m<A extends a.b, ResultT> {

    /* renamed from: a  reason: collision with root package name */
    private final b.c.a.a.b.c[] f1570a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1571b;

    /* loaded from: classes.dex */
    public static class a<A extends a.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        private k<A, b.c.a.a.f.h<ResultT>> f1572a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1573b;

        /* renamed from: c  reason: collision with root package name */
        private b.c.a.a.b.c[] f1574c;

        private a() {
            this.f1573b = true;
        }

        public m<A, ResultT> a() {
            com.google.android.gms.common.internal.r.b(this.f1572a != null, "execute parameter required");
            return new g0(this, this.f1574c, this.f1573b);
        }

        public a<A, ResultT> b(k<A, b.c.a.a.f.h<ResultT>> kVar) {
            this.f1572a = kVar;
            return this;
        }

        public a<A, ResultT> c(boolean z) {
            this.f1573b = z;
            return this;
        }

        public a<A, ResultT> d(b.c.a.a.b.c... cVarArr) {
            this.f1574c = cVarArr;
            return this;
        }
    }

    private m(b.c.a.a.b.c[] cVarArr, boolean z) {
        this.f1570a = cVarArr;
        this.f1571b = z;
    }

    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void b(A a2, b.c.a.a.f.h<ResultT> hVar);

    public boolean c() {
        return this.f1571b;
    }

    public final b.c.a.a.b.c[] d() {
        return this.f1570a;
    }
}
