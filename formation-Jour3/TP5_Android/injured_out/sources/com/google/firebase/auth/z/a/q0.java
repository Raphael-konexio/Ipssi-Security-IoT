package com.google.firebase.auth.z.a;

import android.os.Parcel;
import b.c.a.a.d.c.k1;
import b.c.a.a.d.c.m1;
import b.c.a.a.d.c.q1;
import b.c.a.a.d.c.x1;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public abstract class q0 extends b.c.a.a.d.c.a implements r0 {
    public q0() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    @Override // b.c.a.a.d.c.a
    protected final boolean d(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                I((q1) b.c.a.a.d.c.u0.a(parcel, q1.CREATOR));
                return true;
            case 2:
                t((q1) b.c.a.a.d.c.u0.a(parcel, q1.CREATOR), (m1) b.c.a.a.d.c.u0.a(parcel, m1.CREATOR));
                return true;
            case 3:
                w((k1) b.c.a.a.d.c.u0.a(parcel, k1.CREATOR));
                return true;
            case 4:
                F((x1) b.c.a.a.d.c.u0.a(parcel, x1.CREATOR));
                return true;
            case 5:
                e((Status) b.c.a.a.d.c.u0.a(parcel, Status.CREATOR));
                return true;
            case 6:
                A();
                return true;
            case 7:
                a();
                return true;
            case 8:
                f(parcel.readString());
                return true;
            case 9:
                z(parcel.readString());
                return true;
            case 10:
                q((com.google.firebase.auth.t) b.c.a.a.d.c.u0.a(parcel, com.google.firebase.auth.t.CREATOR));
                return true;
            case 11:
                o(parcel.readString());
                return true;
            case 12:
                i((Status) b.c.a.a.d.c.u0.a(parcel, Status.CREATOR), (com.google.firebase.auth.t) b.c.a.a.d.c.u0.a(parcel, com.google.firebase.auth.t.CREATOR));
                return true;
            case 13:
                b();
                return true;
            case 14:
                T((b.c.a.a.d.c.g1) b.c.a.a.d.c.u0.a(parcel, b.c.a.a.d.c.g1.CREATOR));
                return true;
            case 15:
                E((b.c.a.a.d.c.h1) b.c.a.a.d.c.u0.a(parcel, b.c.a.a.d.c.h1.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
