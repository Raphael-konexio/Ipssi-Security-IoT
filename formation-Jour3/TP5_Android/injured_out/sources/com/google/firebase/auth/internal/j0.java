package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a.d.c.h1;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.u0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class j0 extends com.google.firebase.auth.b0 {
    public static final Parcelable.Creator<j0> CREATOR = new i0();
    private final List<com.google.firebase.auth.e0> f = new ArrayList();
    private final l0 g;
    private final String h;
    private final com.google.firebase.auth.i0 i;
    private final d0 j;

    public j0(List<com.google.firebase.auth.e0> list, l0 l0Var, String str, com.google.firebase.auth.i0 i0Var, d0 d0Var) {
        for (com.google.firebase.auth.e0 e0Var : list) {
            if (e0Var instanceof com.google.firebase.auth.e0) {
                this.f.add(e0Var);
            }
        }
        com.google.android.gms.common.internal.r.h(l0Var);
        this.g = l0Var;
        com.google.android.gms.common.internal.r.f(str);
        this.h = str;
        this.i = i0Var;
        this.j = d0Var;
    }

    public static j0 b(h1 h1Var, FirebaseAuth firebaseAuth, com.google.firebase.auth.n nVar) {
        List<u0> h = h1Var.h();
        ArrayList arrayList = new ArrayList();
        for (u0 u0Var : h) {
            if (u0Var instanceof com.google.firebase.auth.e0) {
                arrayList.add((com.google.firebase.auth.e0) u0Var);
            }
        }
        return new j0(arrayList, l0.b(h1Var.h(), h1Var.b()), firebaseAuth.o().m(), h1Var.c(), (d0) nVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.n(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, this.g, i, false);
        com.google.android.gms.common.internal.w.c.k(parcel, 3, this.h, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 4, this.i, i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 5, this.j, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
