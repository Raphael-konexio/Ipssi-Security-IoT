package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements h {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Handler f1142a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Runnable f1143b;

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.f1142a.removeCallbacks(this.f1143b);
            jVar.a().c(this);
        }
    }
}
