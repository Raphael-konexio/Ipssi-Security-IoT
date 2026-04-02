package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.a;
import androidx.lifecycle.e;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class d extends ComponentActivity {
    boolean n;
    boolean o;
    boolean q;
    boolean r;
    int s;
    a.d.h<String> t;
    final h l = h.b(new a());
    final androidx.lifecycle.k m = new androidx.lifecycle.k(this);
    boolean p = true;

    /* loaded from: classes.dex */
    class a extends j<d> implements androidx.lifecycle.w, androidx.activity.c {
        public a() {
            super(d.this);
        }

        @Override // androidx.lifecycle.j
        public androidx.lifecycle.e a() {
            return d.this.m;
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public View c(int i) {
            return d.this.findViewById(i);
        }

        @Override // androidx.fragment.app.j, androidx.fragment.app.f
        public boolean d() {
            Window window = d.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.lifecycle.w
        public androidx.lifecycle.v f() {
            return d.this.f();
        }

        @Override // androidx.activity.c
        public OnBackPressedDispatcher i() {
            return d.this.i();
        }

        @Override // androidx.fragment.app.j
        public void k(Fragment fragment) {
            d.this.q(fragment);
        }

        @Override // androidx.fragment.app.j
        public LayoutInflater m() {
            return d.this.getLayoutInflater().cloneInContext(d.this);
        }

        @Override // androidx.fragment.app.j
        public boolean n(Fragment fragment) {
            return !d.this.isFinishing();
        }

        @Override // androidx.fragment.app.j
        public void o() {
            d.this.t();
        }

        @Override // androidx.fragment.app.j
        /* renamed from: p */
        public d l() {
            return d.this;
        }
    }

    static void l(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    private void o() {
        do {
        } while (p(n(), e.b.CREATED));
    }

    private static boolean p(m mVar, e.b bVar) {
        boolean z = false;
        for (Fragment fragment : mVar.f0()) {
            if (fragment != null) {
                if (fragment.w() != null) {
                    z |= p(fragment.q(), bVar);
                }
                if (fragment.a().b().d(e.b.STARTED)) {
                    fragment.V.p(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.n);
        printWriter.print(" mResumed=");
        printWriter.print(this.o);
        printWriter.print(" mStopped=");
        printWriter.print(this.p);
        if (getApplication() != null) {
            a.l.a.a.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.l.u().M(str, fileDescriptor, printWriter, strArr);
    }

    final View m(View view, String str, Context context, AttributeSet attributeSet) {
        return this.l.w(view, str, context, attributeSet);
    }

    public m n() {
        return this.l.u();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.l.v();
        int i3 = i >> 16;
        if (i3 == 0) {
            a.b k = androidx.core.app.a.k();
            if (k == null || !k.a(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String e = this.t.e(i4);
        this.t.j(i4);
        if (e == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        Fragment t = this.l.t(e);
        if (t != null) {
            t.Z(i & 65535, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.l.v();
        this.l.d(configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.l.a(null);
        if (bundle != null) {
            this.l.x(bundle.getParcelable("android:support:fragments"));
            if (bundle.containsKey("android:support:next_request_index")) {
                this.s = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.t = new a.d.h<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.t.i(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.t == null) {
            this.t = new a.d.h<>();
            this.s = 0;
        }
        super.onCreate(bundle);
        this.m.i(e.a.ON_CREATE);
        this.l.f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.l.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View m = m(view, str, context, attributeSet);
        return m == null ? super.onCreateView(view, str, context, attributeSet) : m;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View m = m(null, str, context, attributeSet);
        return m == null ? super.onCreateView(str, context, attributeSet) : m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.l.h();
        this.m.i(e.a.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.l.i();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i != 0) {
            if (i != 6) {
                return false;
            }
            return this.l.e(menuItem);
        }
        return this.l.k(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.l.j(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.l.v();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.l.l(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.o = false;
        this.l.m();
        this.m.i(e.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.l.n(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        s();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return i == 0 ? r(view, menu) | this.l.o(menu) : super.onPreparePanel(i, view, menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.l.v();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String e = this.t.e(i3);
            this.t.j(i3);
            if (e == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            Fragment t = this.l.t(e);
            if (t != null) {
                t.y0(i & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.o = true;
        this.l.v();
        this.l.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        o();
        this.m.i(e.a.ON_STOP);
        Parcelable y = this.l.y();
        if (y != null) {
            bundle.putParcelable("android:support:fragments", y);
        }
        if (this.t.l() > 0) {
            bundle.putInt("android:support:next_request_index", this.s);
            int[] iArr = new int[this.t.l()];
            String[] strArr = new String[this.t.l()];
            for (int i = 0; i < this.t.l(); i++) {
                iArr[i] = this.t.h(i);
                strArr[i] = this.t.m(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        this.p = false;
        if (!this.n) {
            this.n = true;
            this.l.c();
        }
        this.l.v();
        this.l.s();
        this.m.i(e.a.ON_START);
        this.l.q();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.l.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.p = true;
        o();
        this.l.r();
        this.m.i(e.a.ON_STOP);
    }

    public void q(Fragment fragment) {
    }

    @Deprecated
    protected boolean r(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    protected void s() {
        this.m.i(e.a.ON_RESUME);
        this.l.p();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.r && i != -1) {
            l(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.r && i != -1) {
            l(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.q && i != -1) {
            l(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.q && i != -1) {
            l(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    @Deprecated
    public void t() {
        invalidateOptionsMenu();
    }
}
