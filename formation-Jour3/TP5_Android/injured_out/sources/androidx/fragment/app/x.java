package androidx.fragment.app;

import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements androidx.lifecycle.j {
    private androidx.lifecycle.k f = null;

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.e a() {
        c();
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.a aVar) {
        this.f.i(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (this.f == null) {
            this.f = new androidx.lifecycle.k(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f != null;
    }
}
