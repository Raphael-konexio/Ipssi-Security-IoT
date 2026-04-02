package a.a.n;

import a.a.n.b;
import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class e extends b implements g.a {
    private Context h;
    private ActionBarContextView i;
    private b.a j;
    private WeakReference<View> k;
    private boolean l;
    private androidx.appcompat.view.menu.g m;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.h = context;
        this.i = actionBarContextView;
        this.j = aVar;
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(actionBarContextView.getContext());
        gVar.S(1);
        this.m = gVar;
        gVar.R(this);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.j.c(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(androidx.appcompat.view.menu.g gVar) {
        k();
        this.i.l();
    }

    @Override // a.a.n.b
    public void c() {
        if (this.l) {
            return;
        }
        this.l = true;
        this.i.sendAccessibilityEvent(32);
        this.j.b(this);
    }

    @Override // a.a.n.b
    public View d() {
        WeakReference<View> weakReference = this.k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // a.a.n.b
    public Menu e() {
        return this.m;
    }

    @Override // a.a.n.b
    public MenuInflater f() {
        return new g(this.i.getContext());
    }

    @Override // a.a.n.b
    public CharSequence g() {
        return this.i.getSubtitle();
    }

    @Override // a.a.n.b
    public CharSequence i() {
        return this.i.getTitle();
    }

    @Override // a.a.n.b
    public void k() {
        this.j.a(this, this.m);
    }

    @Override // a.a.n.b
    public boolean l() {
        return this.i.j();
    }

    @Override // a.a.n.b
    public void m(View view) {
        this.i.setCustomView(view);
        this.k = view != null ? new WeakReference<>(view) : null;
    }

    @Override // a.a.n.b
    public void n(int i) {
        o(this.h.getString(i));
    }

    @Override // a.a.n.b
    public void o(CharSequence charSequence) {
        this.i.setSubtitle(charSequence);
    }

    @Override // a.a.n.b
    public void q(int i) {
        r(this.h.getString(i));
    }

    @Override // a.a.n.b
    public void r(CharSequence charSequence) {
        this.i.setTitle(charSequence);
    }

    @Override // a.a.n.b
    public void s(boolean z) {
        super.s(z);
        this.i.setTitleOptional(z);
    }
}
