package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class e {
    private static int f = -100;
    private static final a.d.b<WeakReference<e>> g = new a.d.b<>();
    private static final Object h = new Object();

    public static void E(int i) {
        if (i != -1 && i != 0 && i != 1 && i != 2 && i != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f != i) {
            f = i;
            e();
        }
    }

    private static void e() {
        synchronized (h) {
            Iterator<WeakReference<e>> it = g.iterator();
            while (it.hasNext()) {
                e eVar = it.next().get();
                if (eVar != null) {
                    eVar.d();
                }
            }
        }
    }

    public static e g(Activity activity, d dVar) {
        return new f(activity, dVar);
    }

    public static e h(Dialog dialog, d dVar) {
        return new f(dialog, dVar);
    }

    public static int j() {
        return f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void p(e eVar) {
        synchronized (h) {
            z(eVar);
            g.add(new WeakReference<>(eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void q(e eVar) {
        synchronized (h) {
            z(eVar);
        }
    }

    private static void z(e eVar) {
        synchronized (h) {
            Iterator<WeakReference<e>> it = g.iterator();
            while (it.hasNext()) {
                e eVar2 = it.next().get();
                if (eVar2 == eVar || eVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract boolean A(int i);

    public abstract void B(int i);

    public abstract void C(View view);

    public abstract void D(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void F(Toolbar toolbar);

    public void G(int i) {
    }

    public abstract void H(CharSequence charSequence);

    public abstract void c(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean d();

    public void f(Context context) {
    }

    public abstract <T extends View> T i(int i);

    public int k() {
        return -100;
    }

    public abstract MenuInflater l();

    public abstract a m();

    public abstract void n();

    public abstract void o();

    public abstract void r(Configuration configuration);

    public abstract void s(Bundle bundle);

    public abstract void t();

    public abstract void u(Bundle bundle);

    public abstract void v();

    public abstract void w(Bundle bundle);

    public abstract void x();

    public abstract void y();
}
