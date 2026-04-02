package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, t> f902a = new HashMap<>();

    public final void a() {
        for (t tVar : this.f902a.values()) {
            tVar.a();
        }
        this.f902a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final t b(String str) {
        return this.f902a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> c() {
        return new HashSet(this.f902a.keySet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str, t tVar) {
        t put = this.f902a.put(str, tVar);
        if (put != null) {
            put.d();
        }
    }
}
