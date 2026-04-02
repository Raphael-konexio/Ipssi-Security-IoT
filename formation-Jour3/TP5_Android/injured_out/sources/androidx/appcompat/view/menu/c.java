package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    final Context f541a;

    /* renamed from: b  reason: collision with root package name */
    private Map<a.g.e.a.b, MenuItem> f542b;

    /* renamed from: c  reason: collision with root package name */
    private Map<a.g.e.a.c, SubMenu> f543c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.f541a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (menuItem instanceof a.g.e.a.b) {
            a.g.e.a.b bVar = (a.g.e.a.b) menuItem;
            if (this.f542b == null) {
                this.f542b = new a.d.a();
            }
            MenuItem menuItem2 = this.f542b.get(menuItem);
            if (menuItem2 == null) {
                j jVar = new j(this.f541a, bVar);
                this.f542b.put(bVar, jVar);
                return jVar;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (subMenu instanceof a.g.e.a.c) {
            a.g.e.a.c cVar = (a.g.e.a.c) subMenu;
            if (this.f543c == null) {
                this.f543c = new a.d.a();
            }
            SubMenu subMenu2 = this.f543c.get(cVar);
            if (subMenu2 == null) {
                s sVar = new s(this.f541a, cVar);
                this.f543c.put(cVar, sVar);
                return sVar;
            }
            return subMenu2;
        }
        return subMenu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        Map<a.g.e.a.b, MenuItem> map = this.f542b;
        if (map != null) {
            map.clear();
        }
        Map<a.g.e.a.c, SubMenu> map2 = this.f543c;
        if (map2 != null) {
            map2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i) {
        Map<a.g.e.a.b, MenuItem> map = this.f542b;
        if (map == null) {
            return;
        }
        Iterator<a.g.e.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i) {
        Map<a.g.e.a.b, MenuItem> map = this.f542b;
        if (map == null) {
            return;
        }
        Iterator<a.g.e.a.b> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
