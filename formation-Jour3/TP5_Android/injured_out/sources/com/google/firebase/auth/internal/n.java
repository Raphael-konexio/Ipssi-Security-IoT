package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import b.c.a.a.d.c.a2;
import com.google.android.gms.common.api.Status;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final b.c.a.a.d.c.w<String> f1899a = b.c.a.a.d.c.w.s("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");

    /* renamed from: b  reason: collision with root package name */
    private static final n f1900b = new n();

    private n() {
    }

    public static n a() {
        return f1900b;
    }

    public static void c(Context context, Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.b());
        edit.putString("statusMessage", status.c());
        edit.putLong("timestamp", com.google.android.gms.common.util.f.b().a());
        edit.commit();
    }

    public static void d(Context context, a2 a2Var, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", com.google.android.gms.common.internal.w.e.f(a2Var));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", com.google.android.gms.common.util.f.b().a());
        edit.commit();
    }

    private static void e(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        b.c.a.a.d.c.w<String> wVar = f1899a;
        int size = wVar.size();
        int i = 0;
        while (i < size) {
            String str = wVar.get(i);
            i++;
            edit.remove(str);
        }
        edit.commit();
    }

    public final void b(Context context) {
        com.google.android.gms.common.internal.r.h(context);
        e(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007c, code lost:
        if (r4.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(com.google.firebase.auth.FirebaseAuth r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.r.h(r11)
            b.c.c.c r0 = r11.o()
            android.content.Context r0 = r0.j()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            b.c.c.c r4 = r11.o()
            java.lang.String r4 = r4.m()
            boolean r1 = r4.equals(r1)
            if (r1 != 0) goto L29
            return
        L29:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r4 = r0.contains(r1)
            r5 = 0
            java.lang.String r7 = "timestamp"
            if (r4 == 0) goto Lda
            java.lang.String r1 = r0.getString(r1, r3)
            android.os.Parcelable$Creator<b.c.a.a.d.c.a2> r4 = b.c.a.a.d.c.a2.CREATOR
            com.google.android.gms.common.internal.w.d r1 = com.google.android.gms.common.internal.w.e.c(r1, r4)
            b.c.a.a.d.c.a2 r1 = (b.c.a.a.d.c.a2) r1
            java.lang.String r4 = "operation"
            java.lang.String r4 = r0.getString(r4, r3)
            r8 = 0
            java.lang.String r9 = "tenantId"
            java.lang.String r8 = r0.getString(r9, r8)
            java.lang.String r9 = "firebaseUserUid"
            java.lang.String r3 = r0.getString(r9, r3)
            r0.getLong(r7, r5)
            if (r8 == 0) goto L5f
            r11.m(r8)
            r1.c(r8)
        L5f:
            r5 = -1
            int r6 = r4.hashCode()
            r7 = -1843829902(0xffffffff92196372, float:-4.8400863E-28)
            r8 = 2
            r9 = 1
            if (r6 == r7) goto L89
            r7 = -286760092(0xffffffffeee86364, float:-3.596034E28)
            if (r6 == r7) goto L7f
            r7 = 1731327805(0x6731f73d, float:8.404196E23)
            if (r6 == r7) goto L76
            goto L93
        L76:
            java.lang.String r6 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L93
            goto L94
        L7f:
            java.lang.String r2 = "com.google.firebase.auth.internal.LINK"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L93
            r2 = 1
            goto L94
        L89:
            java.lang.String r2 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L93
            r2 = 2
            goto L94
        L93:
            r2 = -1
        L94:
            if (r2 == 0) goto Lcf
            if (r2 == r9) goto Lb5
            if (r2 == r8) goto L9b
            goto Ld6
        L9b:
            com.google.firebase.auth.n r2 = r11.c()
            java.lang.String r2 = r2.c()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto Ld6
            com.google.firebase.auth.n r11 = r11.c()
            com.google.firebase.auth.i0 r1 = com.google.firebase.auth.i0.o(r1)
            r11.k(r1)
            goto Ld6
        Lb5:
            com.google.firebase.auth.n r2 = r11.c()
            java.lang.String r2 = r2.c()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto Ld6
            com.google.firebase.auth.n r11 = r11.c()
            com.google.firebase.auth.i0 r1 = com.google.firebase.auth.i0.o(r1)
            r11.j(r1)
            goto Ld6
        Lcf:
            com.google.firebase.auth.i0 r1 = com.google.firebase.auth.i0.o(r1)
            r11.e(r1)
        Ld6:
            e(r0)
            return
        Lda:
            java.lang.String r11 = "statusCode"
            boolean r1 = r0.contains(r11)
            if (r1 == 0) goto L100
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r11 = r0.getInt(r11, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r11, r1)
            r0.getLong(r7, r5)
            e(r0)
            b.c.c.e r11 = com.google.firebase.auth.z.a.o0.a(r2)
            b.c.a.a.f.j.a(r11)
        L100:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.n.f(com.google.firebase.auth.FirebaseAuth):void");
    }
}
