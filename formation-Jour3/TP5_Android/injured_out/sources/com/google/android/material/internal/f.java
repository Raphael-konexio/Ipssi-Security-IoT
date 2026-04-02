package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private float f1794c;
    private b.c.a.b.x.d f;

    /* renamed from: a  reason: collision with root package name */
    private final TextPaint f1792a = new TextPaint(1);

    /* renamed from: b  reason: collision with root package name */
    private final b.c.a.b.x.f f1793b = new a();

    /* renamed from: d  reason: collision with root package name */
    private boolean f1795d = true;
    private WeakReference<b> e = new WeakReference<>(null);

    /* loaded from: classes.dex */
    class a extends b.c.a.b.x.f {
        a() {
        }

        @Override // b.c.a.b.x.f
        public void a(int i) {
            f.this.f1795d = true;
            b bVar = (b) f.this.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // b.c.a.b.x.f
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            f.this.f1795d = true;
            b bVar = (b) f.this.e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public f(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f1792a.measureText(charSequence, 0, charSequence.length());
    }

    public b.c.a.b.x.d d() {
        return this.f;
    }

    public TextPaint e() {
        return this.f1792a;
    }

    public float f(String str) {
        if (this.f1795d) {
            float c2 = c(str);
            this.f1794c = c2;
            this.f1795d = false;
            return c2;
        }
        return this.f1794c;
    }

    public void g(b bVar) {
        this.e = new WeakReference<>(bVar);
    }

    public void h(b.c.a.b.x.d dVar, Context context) {
        if (this.f != dVar) {
            this.f = dVar;
            if (dVar != null) {
                dVar.j(context, this.f1792a, this.f1793b);
                b bVar = this.e.get();
                if (bVar != null) {
                    this.f1792a.drawableState = bVar.getState();
                }
                dVar.i(context, this.f1792a, this.f1793b);
                this.f1795d = true;
            }
            b bVar2 = this.e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f1795d = z;
    }

    public void j(Context context) {
        this.f.i(context, this.f1792a, this.f1793b);
    }
}
