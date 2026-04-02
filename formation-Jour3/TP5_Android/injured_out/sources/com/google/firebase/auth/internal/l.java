package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.auth.u0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class l extends com.google.android.gms.common.internal.w.a {
    public static final Parcelable.Creator<l> CREATOR = new o();
    private final List<com.google.firebase.auth.e0> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(List<com.google.firebase.auth.e0> list) {
        this.f = list == null ? b.c.a.a.d.c.w.l() : list;
    }

    public static l b(List<u0> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (u0 u0Var : list) {
            if (u0Var instanceof com.google.firebase.auth.e0) {
                arrayList.add((com.google.firebase.auth.e0) u0Var);
            }
        }
        return new l(arrayList);
    }

    public final List<u0> c() {
        ArrayList arrayList = new ArrayList();
        for (com.google.firebase.auth.e0 e0Var : this.f) {
            arrayList.add(e0Var);
        }
        return arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int a2 = com.google.android.gms.common.internal.w.c.a(parcel);
        com.google.android.gms.common.internal.w.c.n(parcel, 1, this.f, false);
        com.google.android.gms.common.internal.w.c.b(parcel, a2);
    }
}
