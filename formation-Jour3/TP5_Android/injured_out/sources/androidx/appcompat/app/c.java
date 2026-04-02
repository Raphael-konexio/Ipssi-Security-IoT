package androidx.appcompat.app;

import a.a.n.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b1;
import androidx.core.app.n;
/* loaded from: classes.dex */
public class c extends androidx.fragment.app.d implements d, n.a {
    private e u;
    private Resources v;

    private boolean B(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    public boolean A() {
        Intent e = e();
        if (e != null) {
            if (!E(e)) {
                D(e);
                return true;
            }
            n i = n.i(this);
            w(i);
            y(i);
            i.l();
            try {
                androidx.core.app.a.j(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        }
        return false;
    }

    public void C(Toolbar toolbar) {
        u().F(toolbar);
    }

    public void D(Intent intent) {
        androidx.core.app.f.e(this, intent);
    }

    public boolean E(Intent intent) {
        return androidx.core.app.f.f(this, intent);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u().c(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        u().f(context);
    }

    @Override // androidx.appcompat.app.d
    public void c(a.a.n.b bVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        a v = v();
        if (getWindow().hasFeature(0)) {
            if (v == null || !v.g()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public void d(a.a.n.b bVar) {
    }

    @Override // androidx.core.app.e, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        a v = v();
        if (keyCode == 82 && v != null && v.p(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.core.app.n.a
    public Intent e() {
        return androidx.core.app.f.a(this);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) u().i(i);
    }

    @Override // androidx.appcompat.app.d
    public a.a.n.b g(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return u().l();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.v == null && b1.b()) {
            this.v = new b1(this, super.getResources());
        }
        Resources resources = this.v;
        return resources == null ? super.getResources() : resources;
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        u().o();
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.v != null) {
            this.v.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
        u().r(configuration);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        e u = u();
        u.n();
        u.s(bundle);
        super.onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        u().t();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (B(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        a v = v();
        if (menuItem.getItemId() != 16908332 || v == null || (v.j() & 4) == 0) {
            return false;
        }
        return A();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.fragment.app.d, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        u().u(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        u().v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        u().w(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStart() {
        super.onStart();
        u().x();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onStop() {
        super.onStop();
        u().y();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        u().H(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        a v = v();
        if (getWindow().hasFeature(0)) {
            if (v == null || !v.q()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        u().B(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        u().C(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        u().D(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        u().G(i);
    }

    @Override // androidx.fragment.app.d
    public void t() {
        u().o();
    }

    public e u() {
        if (this.u == null) {
            this.u = e.g(this, this);
        }
        return this.u;
    }

    public a v() {
        return u().m();
    }

    public void w(n nVar) {
        nVar.f(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i) {
    }

    public void y(n nVar) {
    }

    @Deprecated
    public void z() {
    }
}
