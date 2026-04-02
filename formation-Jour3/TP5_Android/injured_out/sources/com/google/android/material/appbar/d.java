package com.google.android.material.appbar;

import a.g.k.s;
import android.view.View;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private final View f1671a;

    /* renamed from: b  reason: collision with root package name */
    private int f1672b;

    /* renamed from: c  reason: collision with root package name */
    private int f1673c;

    /* renamed from: d  reason: collision with root package name */
    private int f1674d;
    private int e;
    private boolean f = true;
    private boolean g = true;

    public d(View view) {
        this.f1671a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f1671a;
        s.S(view, this.f1674d - (view.getTop() - this.f1672b));
        View view2 = this.f1671a;
        s.R(view2, this.e - (view2.getLeft() - this.f1673c));
    }

    public int b() {
        return this.f1674d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1672b = this.f1671a.getTop();
        this.f1673c = this.f1671a.getLeft();
    }

    public boolean d(int i) {
        if (!this.g || this.e == i) {
            return false;
        }
        this.e = i;
        a();
        return true;
    }

    public boolean e(int i) {
        if (!this.f || this.f1674d == i) {
            return false;
        }
        this.f1674d = i;
        a();
        return true;
    }
}
