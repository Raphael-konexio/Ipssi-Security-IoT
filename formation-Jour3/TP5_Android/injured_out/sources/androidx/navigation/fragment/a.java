package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.m;
import androidx.navigation.j;
import androidx.navigation.r;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
@r.b("fragment")
/* loaded from: classes.dex */
public class a extends r<C0047a> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f926a;

    /* renamed from: b  reason: collision with root package name */
    private final m f927b;

    /* renamed from: c  reason: collision with root package name */
    private final int f928c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayDeque<Integer> f929d = new ArrayDeque<>();

    /* renamed from: androidx.navigation.fragment.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0047a extends j {
        private String n;

        public C0047a(r<? extends C0047a> rVar) {
            super(rVar);
        }

        public final String E() {
            String str = this.n;
            if (str != null) {
                return str;
            }
            throw new IllegalStateException("Fragment class was not set");
        }

        public final C0047a F(String str) {
            this.n = str;
            return this;
        }

        @Override // androidx.navigation.j
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            sb.append(" class=");
            String str = this.n;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
            return sb.toString();
        }

        @Override // androidx.navigation.j
        public void y(Context context, AttributeSet attributeSet) {
            super.y(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, d.FragmentNavigator);
            String string = obtainAttributes.getString(d.FragmentNavigator_android_name);
            if (string != null) {
                F(string);
            }
            obtainAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements r.a {

        /* renamed from: a  reason: collision with root package name */
        private final LinkedHashMap<View, String> f930a;

        public Map<View, String> a() {
            return Collections.unmodifiableMap(this.f930a);
        }
    }

    public a(Context context, m mVar, int i) {
        this.f926a = context;
        this.f927b = mVar;
        this.f928c = i;
    }

    private String g(int i, int i2) {
        return i + "-" + i2;
    }

    @Override // androidx.navigation.r
    public void c(Bundle bundle) {
        int[] intArray;
        if (bundle == null || (intArray = bundle.getIntArray("androidx-nav-fragment:navigator:backStackIds")) == null) {
            return;
        }
        this.f929d.clear();
        for (int i : intArray) {
            this.f929d.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.navigation.r
    public Bundle d() {
        Bundle bundle = new Bundle();
        int[] iArr = new int[this.f929d.size()];
        Iterator<Integer> it = this.f929d.iterator();
        int i = 0;
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        bundle.putIntArray("androidx-nav-fragment:navigator:backStackIds", iArr);
        return bundle;
    }

    @Override // androidx.navigation.r
    public boolean e() {
        if (this.f929d.isEmpty()) {
            return false;
        }
        if (this.f927b.t0()) {
            Log.i("FragmentNavigator", "Ignoring popBackStack() call: FragmentManager has already saved its state");
            return false;
        }
        this.f927b.E0(g(this.f929d.size(), this.f929d.peekLast().intValue()), 1);
        this.f929d.removeLast();
        return true;
    }

    @Override // androidx.navigation.r
    /* renamed from: f */
    public C0047a a() {
        return new C0047a(this);
    }

    @Deprecated
    public Fragment h(Context context, m mVar, String str, Bundle bundle) {
        return mVar.e0().a(context.getClassLoader(), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0134 A[RETURN] */
    @Override // androidx.navigation.r
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.navigation.j b(androidx.navigation.fragment.a.C0047a r9, android.os.Bundle r10, androidx.navigation.o r11, androidx.navigation.r.a r12) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.a.b(androidx.navigation.fragment.a$a, android.os.Bundle, androidx.navigation.o, androidx.navigation.r$a):androidx.navigation.j");
    }
}
