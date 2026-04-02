package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
public abstract class j<E> extends f {
    private final Activity f;
    private final Context g;
    private final Handler h;
    final m i;

    j(Activity activity, Context context, Handler handler, int i) {
        this.i = new n();
        this.f = activity;
        a.g.j.i.d(context, "context == null");
        this.g = context;
        a.g.j.i.d(handler, "handler == null");
        this.h = handler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this(dVar, dVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.f
    public View c(int i) {
        return null;
    }

    @Override // androidx.fragment.app.f
    public boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Activity e() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context g() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler h() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Fragment fragment) {
    }

    public abstract E l();

    public LayoutInflater m() {
        return LayoutInflater.from(this.g);
    }

    public boolean n(Fragment fragment) {
        return true;
    }

    public void o() {
    }
}
