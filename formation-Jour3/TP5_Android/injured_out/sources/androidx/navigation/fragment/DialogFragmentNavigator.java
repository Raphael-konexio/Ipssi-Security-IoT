package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.navigation.o;
import androidx.navigation.r;
import java.util.HashSet;
@r.b("dialog")
/* loaded from: classes.dex */
public final class DialogFragmentNavigator extends r<a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f922a;

    /* renamed from: b  reason: collision with root package name */
    private final m f923b;

    /* renamed from: c  reason: collision with root package name */
    private int f924c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final HashSet<String> f925d = new HashSet<>();
    private h e = new h(this) { // from class: androidx.navigation.fragment.DialogFragmentNavigator.1
        @Override // androidx.lifecycle.h
        public void d(j jVar, e.a aVar) {
            if (aVar == e.a.ON_STOP) {
                androidx.fragment.app.c cVar = (androidx.fragment.app.c) jVar;
                if (cVar.x1().isShowing()) {
                    return;
                }
                b.r1(cVar).m();
            }
        }
    };

    /* loaded from: classes.dex */
    public static class a extends androidx.navigation.j implements androidx.navigation.b {
        private String n;

        public a(r<? extends a> rVar) {
            super(rVar);
        }

        public final String E() {
            String str = this.n;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("DialogFragment class was not set");
        }

        public final a F(String str) {
            this.n = str;
            return this;
        }

        @Override // androidx.navigation.j
        public void y(Context context, AttributeSet attributeSet) {
            super.y(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.DialogFragmentNavigator);
            String string = obtainAttributes.getString(d.DialogFragmentNavigator_android_name);
            if (string != null) {
                F(string);
            }
            obtainAttributes.recycle();
        }
    }

    public DialogFragmentNavigator(Context context, m mVar) {
        this.f922a = context;
        this.f923b = mVar;
    }

    @Override // androidx.navigation.r
    public void c(Bundle bundle) {
        if (bundle != null) {
            this.f924c = bundle.getInt("androidx-nav-dialogfragment:navigator:count", 0);
            for (int i = 0; i < this.f924c; i++) {
                m mVar = this.f923b;
                androidx.fragment.app.c cVar = (androidx.fragment.app.c) mVar.X("androidx-nav-fragment:navigator:dialog:" + i);
                if (cVar != null) {
                    cVar.a().a(this.e);
                } else {
                    HashSet<String> hashSet = this.f925d;
                    hashSet.add("androidx-nav-fragment:navigator:dialog:" + i);
                }
            }
        }
    }

    @Override // androidx.navigation.r
    public Bundle d() {
        if (this.f924c == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("androidx-nav-dialogfragment:navigator:count", this.f924c);
        return bundle;
    }

    @Override // androidx.navigation.r
    public boolean e() {
        if (this.f924c == 0) {
            return false;
        }
        if (this.f923b.t0()) {
            Log.i("DialogFragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        m mVar = this.f923b;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i = this.f924c - 1;
        this.f924c = i;
        sb.append(i);
        Fragment X = mVar.X(sb.toString());
        if (X != null) {
            X.a().c(this.e);
            ((androidx.fragment.app.c) X).s1();
        }
        return true;
    }

    @Override // androidx.navigation.r
    /* renamed from: f */
    public a a() {
        return new a(this);
    }

    @Override // androidx.navigation.r
    /* renamed from: g */
    public androidx.navigation.j b(a aVar, Bundle bundle, o oVar, r.a aVar2) {
        if (this.f923b.t0()) {
            Log.i("DialogFragmentNavigator", "Ignoring navigate() call: FragmentManager has already saved its state");
            return null;
        }
        String E = aVar.E();
        if (E.charAt(0) == '.') {
            E = this.f922a.getPackageName() + E;
        }
        Fragment a2 = this.f923b.e0().a(this.f922a.getClassLoader(), E);
        if (!androidx.fragment.app.c.class.isAssignableFrom(a2.getClass())) {
            throw new IllegalArgumentException("Dialog destination " + aVar.E() + " is not an instance of DialogFragment");
        }
        androidx.fragment.app.c cVar = (androidx.fragment.app.c) a2;
        cVar.j1(bundle);
        cVar.a().a(this.e);
        m mVar = this.f923b;
        StringBuilder sb = new StringBuilder();
        sb.append("androidx-nav-fragment:navigator:dialog:");
        int i = this.f924c;
        this.f924c = i + 1;
        sb.append(i);
        cVar.A1(mVar, sb.toString());
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Fragment fragment) {
        if (this.f925d.remove(fragment.L())) {
            fragment.a().a(this.e);
        }
    }
}
