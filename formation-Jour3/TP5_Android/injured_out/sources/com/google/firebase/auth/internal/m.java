package com.google.firebase.auth.internal;

import android.text.TextUtils;
import b.c.a.a.d.c.s1;
import com.google.firebase.auth.u0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class m {
    public static u0 a(s1 s1Var) {
        if (s1Var == null || TextUtils.isEmpty(s1Var.b())) {
            return null;
        }
        return new com.google.firebase.auth.e0(s1Var.c(), s1Var.h(), s1Var.j(), s1Var.b());
    }

    public static List<u0> b(List<s1> list) {
        if (list == null || list.isEmpty()) {
            return b.c.a.a.d.c.w.l();
        }
        ArrayList arrayList = new ArrayList();
        for (s1 s1Var : list) {
            u0 a2 = a(s1Var);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }
}
