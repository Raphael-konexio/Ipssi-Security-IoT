package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final j<?> f799a;

    private h(j<?> jVar) {
        this.f799a = jVar;
    }

    public static h b(j<?> jVar) {
        a.g.j.i.d(jVar, "callbacks == null");
        return new h(jVar);
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f799a;
        jVar.i.g(jVar, jVar, fragment);
    }

    public void c() {
        this.f799a.i.r();
    }

    public void d(Configuration configuration) {
        this.f799a.i.s(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f799a.i.t(menuItem);
    }

    public void f() {
        this.f799a.i.u();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f799a.i.v(menu, menuInflater);
    }

    public void h() {
        this.f799a.i.w();
    }

    public void i() {
        this.f799a.i.y();
    }

    public void j(boolean z) {
        this.f799a.i.z(z);
    }

    public boolean k(MenuItem menuItem) {
        return this.f799a.i.A(menuItem);
    }

    public void l(Menu menu) {
        this.f799a.i.B(menu);
    }

    public void m() {
        this.f799a.i.D();
    }

    public void n(boolean z) {
        this.f799a.i.E(z);
    }

    public boolean o(Menu menu) {
        return this.f799a.i.F(menu);
    }

    public void p() {
        this.f799a.i.H();
    }

    public void q() {
        this.f799a.i.I();
    }

    public void r() {
        this.f799a.i.K();
    }

    public boolean s() {
        return this.f799a.i.Q(true);
    }

    public Fragment t(String str) {
        return this.f799a.i.Y(str);
    }

    public m u() {
        return this.f799a.i;
    }

    public void v() {
        this.f799a.i.B0();
    }

    public View w(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f799a.i.g0().onCreateView(view, str, context, attributeSet);
    }

    public void x(Parcelable parcelable) {
        j<?> jVar = this.f799a;
        if (!(jVar instanceof androidx.lifecycle.w)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        jVar.i.O0(parcelable);
    }

    public Parcelable y() {
        return this.f799a.i.Q0();
    }
}
