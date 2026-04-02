package androidx.fragment.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
/* loaded from: classes.dex */
public class c extends Fragment implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener {
    private Handler b0;
    private Runnable c0 = new a();
    private DialogInterface.OnCancelListener d0 = new b();
    private DialogInterface.OnDismissListener e0 = new DialogInterface$OnDismissListenerC0043c();
    private int f0 = 0;
    private int g0 = 0;
    private boolean h0 = true;
    private boolean i0 = true;
    private int j0 = -1;
    private boolean k0;
    private Dialog l0;
    private boolean m0;
    private boolean n0;
    private boolean o0;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.e0.onDismiss(c.this.l0);
        }
    }

    /* loaded from: classes.dex */
    class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (c.this.l0 != null) {
                c cVar = c.this;
                cVar.onCancel(cVar.l0);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class DialogInterface$OnDismissListenerC0043c implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC0043c() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (c.this.l0 != null) {
                c cVar = c.this;
                cVar.onDismiss(cVar.l0);
            }
        }
    }

    private void t1(boolean z, boolean z2) {
        if (this.n0) {
            return;
        }
        this.n0 = true;
        this.o0 = false;
        Dialog dialog = this.l0;
        if (dialog != null) {
            dialog.setOnDismissListener(null);
            this.l0.dismiss();
            if (!z2) {
                if (Looper.myLooper() == this.b0.getLooper()) {
                    onDismiss(this.l0);
                } else {
                    this.b0.post(this.c0);
                }
            }
        }
        this.m0 = true;
        if (this.j0 >= 0) {
            C().D0(this.j0, 1);
            this.j0 = -1;
            return;
        }
        t i = C().i();
        i.n(this);
        if (z) {
            i.i();
        } else {
            i.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void A0(Bundle bundle) {
        super.A0(bundle);
        Dialog dialog = this.l0;
        if (dialog != null) {
            bundle.putBundle("android:savedDialogState", dialog.onSaveInstanceState());
        }
        int i = this.f0;
        if (i != 0) {
            bundle.putInt("android:style", i);
        }
        int i2 = this.g0;
        if (i2 != 0) {
            bundle.putInt("android:theme", i2);
        }
        boolean z = this.h0;
        if (!z) {
            bundle.putBoolean("android:cancelable", z);
        }
        boolean z2 = this.i0;
        if (!z2) {
            bundle.putBoolean("android:showsDialog", z2);
        }
        int i3 = this.j0;
        if (i3 != -1) {
            bundle.putInt("android:backStackId", i3);
        }
    }

    public void A1(m mVar, String str) {
        this.n0 = false;
        this.o0 = true;
        t i = mVar.i();
        i.d(this, str);
        i.h();
    }

    @Override // androidx.fragment.app.Fragment
    public void B0() {
        super.B0();
        Dialog dialog = this.l0;
        if (dialog != null) {
            this.m0 = false;
            dialog.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void C0() {
        super.C0();
        Dialog dialog = this.l0;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void Y(Bundle bundle) {
        Bundle bundle2;
        super.Y(bundle);
        if (this.i0) {
            View N = N();
            if (this.l0 != null) {
                if (N != null) {
                    if (N.getParent() != null) {
                        throw new IllegalStateException("DialogFragment can not be attached to a container view");
                    }
                    this.l0.setContentView(N);
                }
                d k = k();
                if (k != null) {
                    this.l0.setOwnerActivity(k);
                }
                this.l0.setCancelable(this.h0);
                this.l0.setOnCancelListener(this.d0);
                this.l0.setOnDismissListener(this.e0);
                if (bundle == null || (bundle2 = bundle.getBundle("android:savedDialogState")) == null) {
                    return;
                }
                this.l0.onRestoreInstanceState(bundle2);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void b0(Context context) {
        super.b0(context);
        if (this.o0) {
            return;
        }
        this.n0 = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        this.b0 = new Handler();
        this.i0 = this.B == 0;
        if (bundle != null) {
            this.f0 = bundle.getInt("android:style", 0);
            this.g0 = bundle.getInt("android:theme", 0);
            this.h0 = bundle.getBoolean("android:cancelable", true);
            this.i0 = bundle.getBoolean("android:showsDialog", this.i0);
            this.j0 = bundle.getInt("android:backStackId", -1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void l0() {
        super.l0();
        Dialog dialog = this.l0;
        if (dialog != null) {
            this.m0 = true;
            dialog.setOnDismissListener(null);
            this.l0.dismiss();
            if (!this.n0) {
                onDismiss(this.l0);
            }
            this.l0 = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void m0() {
        super.m0();
        if (this.o0 || this.n0) {
            return;
        }
        this.n0 = true;
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater n0(Bundle bundle) {
        LayoutInflater n0 = super.n0(bundle);
        if (!this.i0 || this.k0) {
            return n0;
        }
        try {
            this.k0 = true;
            Dialog w1 = w1(bundle);
            this.l0 = w1;
            z1(w1, this.f0);
            this.k0 = false;
            return n0.cloneInContext(x1().getContext());
        } catch (Throwable th) {
            this.k0 = false;
            throw th;
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (this.m0) {
            return;
        }
        t1(true, true);
    }

    public void s1() {
        t1(false, false);
    }

    public Dialog u1() {
        return this.l0;
    }

    public int v1() {
        return this.g0;
    }

    public Dialog w1(Bundle bundle) {
        return new Dialog(d1(), v1());
    }

    public final Dialog x1() {
        Dialog u1 = u1();
        if (u1 != null) {
            return u1;
        }
        throw new IllegalStateException("DialogFragment " + this + " does not have a Dialog.");
    }

    public void y1(boolean z) {
        this.i0 = z;
    }

    public void z1(Dialog dialog, int i) {
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            Window window = dialog.getWindow();
            if (window != null) {
                window.addFlags(24);
            }
        }
        dialog.requestWindowFeature(1);
    }
}
