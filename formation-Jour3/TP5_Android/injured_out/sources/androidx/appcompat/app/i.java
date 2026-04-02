package androidx.appcompat.app;

import a.g.k.s;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.d0;
import androidx.appcompat.widget.x0;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends androidx.appcompat.app.a {

    /* renamed from: a  reason: collision with root package name */
    d0 f513a;

    /* renamed from: b  reason: collision with root package name */
    boolean f514b;

    /* renamed from: c  reason: collision with root package name */
    Window.Callback f515c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f516d;
    private boolean e;
    private ArrayList<a.b> f = new ArrayList<>();
    private final Runnable g = new a();
    private final Toolbar.f h = new b();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.x();
        }
    }

    /* loaded from: classes.dex */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return i.this.f515c.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class c implements m.a {
        private boolean f;

        c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (this.f) {
                return;
            }
            this.f = true;
            i.this.f513a.i();
            Window.Callback callback = i.this.f515c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.f = false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = i.this.f515c;
            if (callback != null) {
                callback.onMenuOpened(108, gVar);
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d implements g.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(androidx.appcompat.view.menu.g gVar) {
            i iVar = i.this;
            if (iVar.f515c != null) {
                if (iVar.f513a.b()) {
                    i.this.f515c.onPanelClosed(108, gVar);
                } else if (i.this.f515c.onPreparePanel(0, null, gVar)) {
                    i.this.f515c.onMenuOpened(108, gVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private class e extends a.a.n.i {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(i.this.f513a.c()) : super.onCreatePanelView(i);
        }

        @Override // a.a.n.i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                i iVar = i.this;
                if (!iVar.f514b) {
                    iVar.f513a.d();
                    i.this.f514b = true;
                }
            }
            return onPreparePanel;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f513a = new x0(toolbar, false);
        e eVar = new e(callback);
        this.f515c = eVar;
        this.f513a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f513a.setWindowTitle(charSequence);
    }

    private Menu v() {
        if (!this.f516d) {
            this.f513a.j(new c(), new d());
            this.f516d = true;
        }
        return this.f513a.r();
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f513a.f();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (this.f513a.o()) {
            this.f513a.collapseActionView();
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z) {
        if (z == this.e) {
            return;
        }
        this.e = z;
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            this.f.get(i).a(z);
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f513a.q();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f513a.c();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f513a.m().removeCallbacks(this.g);
        s.Y(this.f513a.m(), this.g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void n() {
        this.f513a.m().removeCallbacks(this.g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i, KeyEvent keyEvent) {
        Menu v = v();
        if (v != null) {
            v.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            return v.performShortcut(i, keyEvent, 0);
        }
        return false;
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f513a.g();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z) {
    }

    @Override // androidx.appcompat.app.a
    public void t(CharSequence charSequence) {
        this.f513a.setWindowTitle(charSequence);
    }

    public Window.Callback w() {
        return this.f515c;
    }

    void x() {
        Menu v = v();
        androidx.appcompat.view.menu.g gVar = v instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) v : null;
        if (gVar != null) {
            gVar.d0();
        }
        try {
            v.clear();
            if (!this.f515c.onCreatePanelMenu(0, v) || !this.f515c.onPreparePanel(0, null, v)) {
                v.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.c0();
            }
        }
    }
}
