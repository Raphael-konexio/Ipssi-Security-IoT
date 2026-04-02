package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final InterfaceC0051b f1050a;

    /* renamed from: b  reason: collision with root package name */
    final a f1051b = new a();

    /* renamed from: c  reason: collision with root package name */
    final List<View> f1052c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f1053a = 0;

        /* renamed from: b  reason: collision with root package name */
        a f1054b;

        a() {
        }

        private void c() {
            if (this.f1054b == null) {
                this.f1054b = new a();
            }
        }

        void a(int i) {
            if (i < 64) {
                this.f1053a &= ~(1 << i);
                return;
            }
            a aVar = this.f1054b;
            if (aVar != null) {
                aVar.a(i - 64);
            }
        }

        int b(int i) {
            a aVar = this.f1054b;
            return aVar == null ? i >= 64 ? Long.bitCount(this.f1053a) : Long.bitCount(this.f1053a & ((1 << i) - 1)) : i < 64 ? Long.bitCount(this.f1053a & ((1 << i) - 1)) : aVar.b(i - 64) + Long.bitCount(this.f1053a);
        }

        boolean d(int i) {
            if (i < 64) {
                return (this.f1053a & (1 << i)) != 0;
            }
            c();
            return this.f1054b.d(i - 64);
        }

        void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.f1054b.e(i - 64, z);
                return;
            }
            boolean z2 = (this.f1053a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.f1053a;
            this.f1053a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f1054b != null) {
                c();
                this.f1054b.e(0, z2);
            }
        }

        boolean f(int i) {
            if (i >= 64) {
                c();
                return this.f1054b.f(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f1053a & j) != 0;
            long j2 = this.f1053a & (~j);
            this.f1053a = j2;
            long j3 = j - 1;
            this.f1053a = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
            a aVar = this.f1054b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f1054b.f(0);
            }
            return z;
        }

        void g() {
            this.f1053a = 0L;
            a aVar = this.f1054b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i) {
            if (i < 64) {
                this.f1053a |= 1 << i;
                return;
            }
            c();
            this.f1054b.h(i - 64);
        }

        public String toString() {
            if (this.f1054b == null) {
                return Long.toBinaryString(this.f1053a);
            }
            return this.f1054b.toString() + "xx" + Long.toBinaryString(this.f1053a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0051b {
        int a();

        View b(int i);

        void c(View view);

        RecyclerView.d0 d(View view);

        void e(int i);

        void f(View view);

        void g(View view, int i);

        void h(int i);

        void i();

        void j(View view, int i, ViewGroup.LayoutParams layoutParams);

        int k(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0051b interfaceC0051b) {
        this.f1050a = interfaceC0051b;
    }

    private int h(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = this.f1050a.a();
        int i2 = i;
        while (i2 < a2) {
            int b2 = i - (i2 - this.f1051b.b(i2));
            if (b2 == 0) {
                while (this.f1051b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f1052c.add(view);
        this.f1050a.c(view);
    }

    private boolean t(View view) {
        if (this.f1052c.remove(view)) {
            this.f1050a.f(view);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i, boolean z) {
        int a2 = i < 0 ? this.f1050a.a() : h(i);
        this.f1051b.e(a2, z);
        if (z) {
            l(view);
        }
        this.f1050a.g(view, a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int a2 = i < 0 ? this.f1050a.a() : h(i);
        this.f1051b.e(a2, z);
        if (z) {
            l(view);
        }
        this.f1050a.j(view, a2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        int h = h(i);
        this.f1051b.f(h);
        this.f1050a.e(h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i) {
        int size = this.f1052c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f1052c.get(i2);
            RecyclerView.d0 d2 = this.f1050a.d(view);
            if (d2.m() == i && !d2.t() && !d2.v()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i) {
        return this.f1050a.b(h(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f1050a.a() - this.f1052c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i) {
        return this.f1050a.b(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f1050a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int k = this.f1050a.k(view);
        if (k >= 0) {
            this.f1051b.h(k);
            l(view);
            return;
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int k = this.f1050a.k(view);
        if (k == -1 || this.f1051b.d(k)) {
            return -1;
        }
        return k - this.f1051b.b(k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f1052c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f1051b.g();
        for (int size = this.f1052c.size() - 1; size >= 0; size--) {
            this.f1050a.f(this.f1052c.get(size));
            this.f1052c.remove(size);
        }
        this.f1050a.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int k = this.f1050a.k(view);
        if (k < 0) {
            return;
        }
        if (this.f1051b.f(k)) {
            t(view);
        }
        this.f1050a.h(k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i) {
        int h = h(i);
        View b2 = this.f1050a.b(h);
        if (b2 == null) {
            return;
        }
        if (this.f1051b.f(h)) {
            t(b2);
        }
        this.f1050a.h(h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int k = this.f1050a.k(view);
        if (k == -1) {
            t(view);
            return true;
        } else if (this.f1051b.d(k)) {
            this.f1051b.f(k);
            t(view);
            this.f1050a.h(k);
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int k = this.f1050a.k(view);
        if (k < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        } else if (this.f1051b.d(k)) {
            this.f1051b.a(k);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1051b.toString() + ", hidden list:" + this.f1052c.size();
    }
}
