package androidx.navigation;

import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
/* loaded from: classes.dex */
class g extends androidx.lifecycle.t {

    /* renamed from: c  reason: collision with root package name */
    private static final u.a f931c = new a();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<UUID, v> f932b = new HashMap<>();

    /* loaded from: classes.dex */
    class a implements u.a {
        a() {
        }

        @Override // androidx.lifecycle.u.a
        public <T extends androidx.lifecycle.t> T a(Class<T> cls) {
            return new g();
        }
    }

    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g f(v vVar) {
        return (g) new androidx.lifecycle.u(vVar, f931c).a(g.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.t
    public void d() {
        for (v vVar : this.f932b.values()) {
            vVar.a();
        }
        this.f932b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(UUID uuid) {
        v remove = this.f932b.remove(uuid);
        if (remove != null) {
            remove.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v g(UUID uuid) {
        v vVar = this.f932b.get(uuid);
        if (vVar == null) {
            v vVar2 = new v();
            this.f932b.put(uuid, vVar2);
            return vVar2;
        }
        return vVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.f932b.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
