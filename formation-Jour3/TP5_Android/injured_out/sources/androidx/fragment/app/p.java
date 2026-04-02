package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.u;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends androidx.lifecycle.t {
    private static final u.a h = new a();
    private final boolean e;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Fragment> f822b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, p> f823c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.v> f824d = new HashMap<>();
    private boolean f = false;
    private boolean g = false;

    /* loaded from: classes.dex */
    static class a implements u.a {
        a() {
        }

        @Override // androidx.lifecycle.u.a
        public <T extends androidx.lifecycle.t> T a(Class<T> cls) {
            return new p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(boolean z) {
        this.e = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p i(androidx.lifecycle.v vVar) {
        return (p) new androidx.lifecycle.u(vVar, h).a(p.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.t
    public void d() {
        if (m.p0(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(Fragment fragment) {
        if (this.f822b.containsKey(fragment.j)) {
            return false;
        }
        this.f822b.put(fragment.j, fragment);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.f822b.equals(pVar.f822b) && this.f823c.equals(pVar.f823c) && this.f824d.equals(pVar.f824d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (m.p0(3)) {
            Log.d("FragmentManager", "Clearing non-config state for " + fragment);
        }
        p pVar = this.f823c.get(fragment.j);
        if (pVar != null) {
            pVar.d();
            this.f823c.remove(fragment.j);
        }
        androidx.lifecycle.v vVar = this.f824d.get(fragment.j);
        if (vVar != null) {
            vVar.a();
            this.f824d.remove(fragment.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(String str) {
        return this.f822b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p h(Fragment fragment) {
        p pVar = this.f823c.get(fragment.j);
        if (pVar == null) {
            p pVar2 = new p(this.e);
            this.f823c.put(fragment.j, pVar2);
            return pVar2;
        }
        return pVar;
    }

    public int hashCode() {
        return (((this.f822b.hashCode() * 31) + this.f823c.hashCode()) * 31) + this.f824d.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> j() {
        return this.f822b.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.v k(Fragment fragment) {
        androidx.lifecycle.v vVar = this.f824d.get(fragment.j);
        if (vVar == null) {
            androidx.lifecycle.v vVar2 = new androidx.lifecycle.v();
            this.f824d.put(fragment.j, vVar2);
            return vVar2;
        }
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m(Fragment fragment) {
        return this.f822b.remove(fragment.j) != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(Fragment fragment) {
        if (this.f822b.containsKey(fragment.j)) {
            return this.e ? this.f : !this.g;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f822b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f823c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f824d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
