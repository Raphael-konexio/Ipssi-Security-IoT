package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
/* loaded from: classes.dex */
public interface d0 {
    void a(Menu menu, m.a aVar);

    boolean b();

    Context c();

    void collapseActionView();

    void d();

    boolean e();

    boolean f();

    boolean g();

    CharSequence getTitle();

    boolean h();

    void i();

    void j(m.a aVar, g.a aVar2);

    void k(int i);

    void l(p0 p0Var);

    ViewGroup m();

    void n(boolean z);

    boolean o();

    void p(int i);

    int q();

    Menu r();

    void s(int i);

    void setIcon(int i);

    void setIcon(Drawable drawable);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);

    int t();

    a.g.k.w u(int i, long j);

    void v();

    void w();

    void x(boolean z);
}
