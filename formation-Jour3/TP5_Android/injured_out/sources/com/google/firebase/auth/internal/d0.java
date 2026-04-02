package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.q1;
import com.google.firebase.auth.u0;
import com.google.firebase.auth.v0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d0 extends com.google.firebase.auth.n {
    public static final Parcelable.Creator<d0> CREATOR = new f0();
    private q1 f;
    private z g;
    private String h;
    private String i;
    private List<z> j;
    private List<String> k;
    private String l;
    private Boolean m;
    private e0 n;
    private boolean o;
    private com.google.firebase.auth.i0 p;
    private l q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(q1 q1Var, z zVar, String str, String str2, List<z> list, List<String> list2, String str3, Boolean bool, e0 e0Var, boolean z, com.google.firebase.auth.i0 i0Var, l lVar) {
        this.f = q1Var;
        this.g = zVar;
        this.h = str;
        this.i = str2;
        this.j = list;
        this.k = list2;
        this.l = str3;
        this.m = bool;
        this.n = e0Var;
        this.o = z;
        this.p = i0Var;
        this.q = lVar;
    }

    public d0(b.c.c.c cVar, List<? extends com.google.firebase.auth.y> list) {
        com.google.android.gms.common.internal.r.h(cVar);
        this.h = cVar.m();
        this.i = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.l = "2";
        n(list);
    }

    public com.google.firebase.auth.o A() {
        return this.n;
    }

    public final d0 B(String str) {
        this.l = str;
        return this;
    }

    public final void C(e0 e0Var) {
        this.n = e0Var;
    }

    public final void D(com.google.firebase.auth.i0 i0Var) {
        this.p = i0Var;
    }

    public final void E(boolean z) {
        this.o = z;
    }

    public final List<z> F() {
        return this.j;
    }

    public final boolean G() {
        return this.o;
    }

    public final com.google.firebase.auth.i0 H() {
        return this.p;
    }

    public final List<u0> I() {
        l lVar = this.q;
        return lVar != null ? lVar.c() : b.c.a.a.d.c.w.l();
    }

    @Override // com.google.firebase.auth.y
    public String a() {
        return this.g.a();
    }

    @Override // com.google.firebase.auth.n
    public List<? extends com.google.firebase.auth.y> b() {
        return this.j;
    }

    @Override // com.google.firebase.auth.n
    public String c() {
        return this.g.j();
    }

    @Override // com.google.firebase.auth.n
    public boolean h() {
        com.google.firebase.auth.p a2;
        Boolean bool = this.m;
        if (bool == null || bool.booleanValue()) {
            q1 q1Var = this.f;
            String str = "";
            if (q1Var != null && (a2 = k.a(q1Var.k())) != null) {
                str = a2.b();
            }
            boolean z = true;
            if (b().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.m = Boolean.valueOf(z);
        }
        return this.m.booleanValue();
    }

    @Override // com.google.firebase.auth.n
    public final com.google.firebase.auth.n n(List<? extends com.google.firebase.auth.y> list) {
        com.google.android.gms.common.internal.r.h(list);
        this.j = new ArrayList(list.size());
        this.k = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            com.google.firebase.auth.y yVar = list.get(i);
            if (yVar.a().equals("firebase")) {
                this.g = (z) yVar;
            } else {
                this.k.add(yVar.a());
            }
            this.j.add((z) yVar);
        }
        if (this.g == null) {
            this.g = this.j.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.n
    public final List<String> o() {
        return this.k;
    }

    @Override // com.google.firebase.auth.n
    public final void p(q1 q1Var) {
        com.google.android.gms.common.internal.r.h(q1Var);
        this.f = q1Var;
    }

    @Override // com.google.firebase.auth.n
    public final /* synthetic */ com.google.firebase.auth.n q() {
        this.m = Boolean.FALSE;
        return this;
    }

    @Override // com.google.firebase.auth.n
    public final void r(List<u0> list) {
        this.q = l.b(list);
    }

    @Override // com.google.firebase.auth.n
    public final b.c.c.c t() {
        return b.c.c.c.l(this.h);
    }

    @Override // com.google.firebase.auth.n
    public final String v() {
        Map map;
        q1 q1Var = this.f;
        if (q1Var == null || q1Var.k() == null || (map = (Map) k.a(this.f.k()).a().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.n
    public final q1 w() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, w(), i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 4, this.i, false);
        com.google.android.gms.common.internal.w.c.n(parcel, 5, this.j, false);
        com.google.android.gms.common.internal.w.c.l(parcel, 6, o(), false);
        com.google.android.gms.common.internal.w.c.k(parcel, 7, this.l, false);
        com.google.android.gms.common.internal.w.c.d(parcel, 8, Boolean.valueOf(h()), false);
        com.google.android.gms.common.internal.w.c.j(parcel, 9, A(), i, false);
        com.google.android.gms.common.internal.w.c.c(parcel, 10, this.o);
        com.google.android.gms.common.internal.w.c.j(parcel, 11, this.p, i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 12, this.q, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }

    @Override // com.google.firebase.auth.n
    public final String x() {
        return this.f.p();
    }

    @Override // com.google.firebase.auth.n
    public final String y() {
        return w().k();
    }

    @Override // com.google.firebase.auth.n
    public final /* synthetic */ v0 z() {
        return new g0(this);
    }
}
