package com.google.firebase.database.q;

import android.util.Log;
import com.google.firebase.database.q.d;
import java.util.List;
/* loaded from: classes.dex */
public class a extends b {
    public a(d.a aVar, List<String> list) {
        super(aVar, list);
    }

    @Override // com.google.firebase.database.q.b
    protected String c(d.a aVar, String str, String str2, long j) {
        return str2;
    }

    @Override // com.google.firebase.database.q.b
    protected void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.google.firebase.database.q.b
    protected void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.google.firebase.database.q.b
    protected void f(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.google.firebase.database.q.b
    protected void h(String str, String str2) {
        Log.w(str, str2);
    }
}
