package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public final class x implements com.google.android.gms.common.internal.w.d {
    public static final Parcelable.Creator<x> CREATOR = new a0();
    private d0 f;
    private w g;
    private com.google.firebase.auth.i0 h;

    public x(d0 d0Var) {
        com.google.android.gms.common.internal.r.h(d0Var);
        d0 d0Var2 = d0Var;
        this.f = d0Var2;
        List<z> F = d0Var2.F();
        this.g = null;
        for (int i = 0; i < F.size(); i++) {
            if (!TextUtils.isEmpty(F.get(i).o())) {
                this.g = new w(F.get(i).a(), F.get(i).o(), d0Var.G());
            }
        }
        if (this.g == null) {
            this.g = new w(d0Var.G());
        }
        this.h = d0Var.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(d0 d0Var, w wVar, com.google.firebase.auth.i0 i0Var) {
        this.f = d0Var;
        this.g = wVar;
        this.h = i0Var;
    }

    public final com.google.firebase.auth.a a() {
        return this.g;
    }

    public final com.google.firebase.auth.n b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.j(parcel, 1, b(), i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 2, a(), i, false);
        com.google.android.gms.common.internal.w.c.j(parcel, 3, this.h, i, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
