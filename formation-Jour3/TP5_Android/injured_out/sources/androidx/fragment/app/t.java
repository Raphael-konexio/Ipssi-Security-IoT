package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.e;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: b  reason: collision with root package name */
    int f832b;

    /* renamed from: c  reason: collision with root package name */
    int f833c;

    /* renamed from: d  reason: collision with root package name */
    int f834d;
    int e;
    int f;
    boolean g;
    String i;
    int j;
    CharSequence k;
    int l;
    CharSequence m;
    ArrayList<String> n;
    ArrayList<String> o;
    ArrayList<Runnable> q;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<a> f831a = new ArrayList<>();
    boolean h = true;
    boolean p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f835a;

        /* renamed from: b  reason: collision with root package name */
        Fragment f836b;

        /* renamed from: c  reason: collision with root package name */
        int f837c;

        /* renamed from: d  reason: collision with root package name */
        int f838d;
        int e;
        int f;
        e.b g;
        e.b h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, Fragment fragment) {
            this.f835a = i;
            this.f836b = fragment;
            e.b bVar = e.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(i iVar, ClassLoader classLoader) {
    }

    public t b(int i, Fragment fragment, String str) {
        m(i, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t c(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.K = viewGroup;
        b(viewGroup.getId(), fragment, str);
        return this;
    }

    public t d(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(a aVar) {
        this.f831a.add(aVar);
        aVar.f837c = this.f832b;
        aVar.f838d = this.f833c;
        aVar.e = this.f834d;
        aVar.f = this.e;
    }

    public t f(View view, String str) {
        if (u.D()) {
            String E = a.g.k.s.E(view);
            if (E == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.n == null) {
                this.n = new ArrayList<>();
                this.o = new ArrayList<>();
            } else if (this.o.contains(str)) {
                throw new IllegalArgumentException("A shared element with the target name '" + str + "' has already been added to the transaction.");
            } else if (this.n.contains(E)) {
                throw new IllegalArgumentException("A shared element with the source name '" + E + "' has already been added to the transaction.");
            }
            this.n.add(E);
            this.o.add(str);
        }
        return this;
    }

    public t g(String str) {
        if (this.h) {
            this.g = true;
            this.i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public t l() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.h = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.C;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.C + " now " + str);
            }
            fragment.C = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.A;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.A + " now " + i);
            }
            fragment.A = i;
            fragment.B = i;
        }
        e(new a(i2, fragment));
    }

    public t n(Fragment fragment) {
        e(new a(3, fragment));
        return this;
    }

    public t o(int i, Fragment fragment) {
        p(i, fragment, null);
        return this;
    }

    public t p(int i, Fragment fragment, String str) {
        if (i != 0) {
            m(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public t q(int i, int i2, int i3, int i4) {
        this.f832b = i;
        this.f833c = i2;
        this.f834d = i3;
        this.e = i4;
        return this;
    }

    public t r(Fragment fragment) {
        e(new a(8, fragment));
        return this;
    }

    public t s(boolean z) {
        this.p = z;
        return this;
    }
}
