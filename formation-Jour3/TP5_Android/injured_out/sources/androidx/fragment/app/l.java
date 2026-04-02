package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private final CopyOnWriteArrayList<a> f801a = new CopyOnWriteArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final m f802b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final m.f f803a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f804b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar) {
        this.f802b = mVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().a(fragment, bundle, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.a(this.f802b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Fragment fragment, Context context, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().b(fragment, context, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.b(this.f802b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().c(fragment, bundle, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.c(this.f802b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().d(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.d(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().e(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.e(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().f(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.f(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Fragment fragment, Context context, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().g(fragment, context, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.g(this.f802b, fragment, context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().h(fragment, bundle, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.h(this.f802b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().i(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.i(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().j(fragment, bundle, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.j(this.f802b, fragment, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().k(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.k(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().l(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.l(this.f802b, fragment);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.m(this.f802b, fragment, view, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Fragment fragment, boolean z) {
        Fragment i0 = this.f802b.i0();
        if (i0 != null) {
            i0.C().h0().n(fragment, true);
        }
        Iterator<a> it = this.f801a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.f804b) {
                next.f803a.n(this.f802b, fragment);
            }
        }
    }
}
