package a.a.n;

import a.a.n.b;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.o;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f21a;

    /* renamed from: b  reason: collision with root package name */
    final b f22b;

    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f23a;

        /* renamed from: b  reason: collision with root package name */
        final Context f24b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f25c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final a.d.g<Menu, Menu> f26d = new a.d.g<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f24b = context;
            this.f23a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f26d.get(menu);
            if (menu2 == null) {
                o oVar = new o(this.f24b, (a.g.e.a.a) menu);
                this.f26d.put(menu, oVar);
                return oVar;
            }
            return menu2;
        }

        @Override // a.a.n.b.a
        public boolean a(b bVar, Menu menu) {
            return this.f23a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // a.a.n.b.a
        public void b(b bVar) {
            this.f23a.onDestroyActionMode(e(bVar));
        }

        @Override // a.a.n.b.a
        public boolean c(b bVar, MenuItem menuItem) {
            return this.f23a.onActionItemClicked(e(bVar), new j(this.f24b, (a.g.e.a.b) menuItem));
        }

        @Override // a.a.n.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f23a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f25c.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f25c.get(i);
                if (fVar != null && fVar.f22b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f24b, bVar);
            this.f25c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f21a = context;
        this.f22b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f22b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f22b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f21a, (a.g.e.a.a) this.f22b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f22b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f22b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f22b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f22b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f22b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f22b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f22b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f22b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f22b.n(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f22b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f22b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f22b.q(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f22b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f22b.s(z);
    }
}
