package androidx.recyclerview.widget;

import android.view.View;
/* loaded from: classes.dex */
class o {

    /* renamed from: a  reason: collision with root package name */
    final b f1115a;

    /* renamed from: b  reason: collision with root package name */
    a f1116b = new a();

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f1117a = 0;

        /* renamed from: b  reason: collision with root package name */
        int f1118b;

        /* renamed from: c  reason: collision with root package name */
        int f1119c;

        /* renamed from: d  reason: collision with root package name */
        int f1120d;
        int e;

        a() {
        }

        void a(int i) {
            this.f1117a = i | this.f1117a;
        }

        boolean b() {
            int i = this.f1117a;
            if ((i & 7) == 0 || (i & (c(this.f1120d, this.f1118b) << 0)) != 0) {
                int i2 = this.f1117a;
                if ((i2 & 112) == 0 || (i2 & (c(this.f1120d, this.f1119c) << 4)) != 0) {
                    int i3 = this.f1117a;
                    if ((i3 & 1792) == 0 || (i3 & (c(this.e, this.f1118b) << 8)) != 0) {
                        int i4 = this.f1117a;
                        return (i4 & 28672) == 0 || (i4 & (c(this.e, this.f1119c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        int c(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        void d() {
            this.f1117a = 0;
        }

        void e(int i, int i2, int i3, int i4) {
            this.f1118b = i;
            this.f1119c = i2;
            this.f1120d = i3;
            this.e = i4;
        }
    }

    /* loaded from: classes.dex */
    interface b {
        int a();

        View b(int i);

        int c(View view);

        int d();

        int e(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.f1115a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i, int i2, int i3, int i4) {
        int d2 = this.f1115a.d();
        int a2 = this.f1115a.a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View b2 = this.f1115a.b(i);
            this.f1116b.e(d2, a2, this.f1115a.c(b2), this.f1115a.e(b2));
            if (i3 != 0) {
                this.f1116b.d();
                this.f1116b.a(i3);
                if (this.f1116b.b()) {
                    return b2;
                }
            }
            if (i4 != 0) {
                this.f1116b.d();
                this.f1116b.a(i4);
                if (this.f1116b.b()) {
                    view = b2;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i) {
        this.f1116b.e(this.f1115a.d(), this.f1115a.a(), this.f1115a.c(view), this.f1115a.e(view));
        if (i != 0) {
            this.f1116b.d();
            this.f1116b.a(i);
            return this.f1116b.b();
        }
        return false;
    }
}
