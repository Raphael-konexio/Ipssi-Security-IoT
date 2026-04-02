package com.google.android.material.bottomappbar;

import b.c.a.b.a0.f;
import b.c.a.b.a0.m;
/* loaded from: classes.dex */
public class a extends f implements Cloneable {
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;

    @Override // b.c.a.b.a0.f
    public void a(float f, float f2, float f3, m mVar) {
        float f4 = this.h;
        if (f4 == 0.0f) {
            mVar.l(f, 0.0f);
            return;
        }
        float f5 = ((this.g * 2.0f) + f4) / 2.0f;
        float f6 = f3 * this.f;
        float f7 = f2 + this.j;
        float f8 = (this.i * f3) + ((1.0f - f3) * f5);
        if (f8 / f5 >= 1.0f) {
            mVar.l(f, 0.0f);
            return;
        }
        float f9 = f5 + f6;
        float f10 = f8 + f6;
        float sqrt = (float) Math.sqrt((f9 * f9) - (f10 * f10));
        float f11 = f7 - sqrt;
        float f12 = f7 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f10));
        float f13 = 90.0f - degrees;
        mVar.l(f11, 0.0f);
        float f14 = f6 * 2.0f;
        mVar.a(f11 - f6, 0.0f, f11 + f6, f14, 270.0f, degrees);
        mVar.a(f7 - f5, (-f5) - f8, f7 + f5, f5 - f8, 180.0f - f13, (f13 * 2.0f) - 180.0f);
        mVar.a(f12 - f6, 0.0f, f12 + f6, f14, 270.0f - degrees, degrees);
        mVar.l(f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f;
    }

    public float e() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(float f) {
        this.i = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f) {
        this.g = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(float f) {
        this.f = f;
    }

    public void i(float f) {
        this.h = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(float f) {
        this.j = f;
    }
}
