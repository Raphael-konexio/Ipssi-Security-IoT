package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private d f1668a;

    /* renamed from: b  reason: collision with root package name */
    private int f1669b;

    /* renamed from: c  reason: collision with root package name */
    private int f1670c;

    public c() {
        this.f1669b = 0;
        this.f1670c = 0;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1669b = 0;
        this.f1670c = 0;
    }

    public int E() {
        d dVar = this.f1668a;
        if (dVar != null) {
            return dVar.b();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.I(v, i);
    }

    public boolean G(int i) {
        d dVar = this.f1668a;
        if (dVar != null) {
            return dVar.e(i);
        }
        this.f1669b = i;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v, int i) {
        F(coordinatorLayout, v, i);
        if (this.f1668a == null) {
            this.f1668a = new d(v);
        }
        this.f1668a.c();
        this.f1668a.a();
        int i2 = this.f1669b;
        if (i2 != 0) {
            this.f1668a.e(i2);
            this.f1669b = 0;
        }
        int i3 = this.f1670c;
        if (i3 != 0) {
            this.f1668a.d(i3);
            this.f1670c = 0;
            return true;
        }
        return true;
    }
}
