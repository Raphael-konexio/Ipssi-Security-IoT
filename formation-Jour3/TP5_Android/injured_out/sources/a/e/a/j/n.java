package a.e.a.j;

import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    HashSet<n> f122a = new HashSet<>(2);

    /* renamed from: b  reason: collision with root package name */
    int f123b = 0;

    public void a(n nVar) {
        this.f122a.add(nVar);
    }

    public void b() {
        this.f123b = 1;
        Iterator<n> it = this.f122a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    public void c() {
        this.f123b = 0;
        Iterator<n> it = this.f122a.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public boolean d() {
        return this.f123b == 1;
    }

    public void e() {
        this.f123b = 0;
        this.f122a.clear();
    }

    public void f() {
    }
}
