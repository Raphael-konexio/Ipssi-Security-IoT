package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.e;
import androidx.lifecycle.v;
import androidx.navigation.j;
import androidx.navigation.o;
import androidx.navigation.r;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public class NavController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f903a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f904b;

    /* renamed from: c  reason: collision with root package name */
    private n f905c;

    /* renamed from: d  reason: collision with root package name */
    k f906d;
    private Bundle e;
    private Parcelable[] f;
    private boolean g;
    private androidx.lifecycle.j i;
    private g j;
    final Deque<e> h = new ArrayDeque();
    private s k = new s();
    private final CopyOnWriteArrayList<b> l = new CopyOnWriteArrayList<>();
    private final androidx.lifecycle.i m = new androidx.lifecycle.h() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.h
        public void d(androidx.lifecycle.j jVar, e.a aVar) {
            NavController navController = NavController.this;
            if (navController.f906d != null) {
                for (e eVar : navController.h) {
                    eVar.g(aVar);
                }
            }
        }
    };
    private final androidx.activity.b n = new a(false);
    private boolean o = true;

    /* loaded from: classes.dex */
    class a extends androidx.activity.b {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.activity.b
        public void b() {
            NavController.this.m();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NavController navController, j jVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.f903a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.f904b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        s sVar = this.k;
        sVar.a(new l(sVar));
        this.k.a(new androidx.navigation.a(this.f903a));
    }

    private boolean a() {
        while (!this.h.isEmpty() && (this.h.peekLast().c() instanceof k) && o(this.h.peekLast().c().s(), true)) {
        }
        if (this.h.isEmpty()) {
            return false;
        }
        j c2 = this.h.peekLast().c();
        j jVar = null;
        if (c2 instanceof androidx.navigation.b) {
            Iterator<e> descendingIterator = this.h.descendingIterator();
            while (true) {
                if (!descendingIterator.hasNext()) {
                    break;
                }
                j c3 = descendingIterator.next().c();
                if (!(c3 instanceof k) && !(c3 instanceof androidx.navigation.b)) {
                    jVar = c3;
                    break;
                }
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<e> descendingIterator2 = this.h.descendingIterator();
        while (descendingIterator2.hasNext()) {
            e next = descendingIterator2.next();
            e.b d2 = next.d();
            j c4 = next.c();
            if (c2 != null && c4.s() == c2.s()) {
                e.b bVar = e.b.RESUMED;
                if (d2 != bVar) {
                    hashMap.put(next, bVar);
                }
                c2 = c2.w();
            } else if (jVar == null || c4.s() != jVar.s()) {
                next.l(e.b.CREATED);
            } else {
                if (d2 == e.b.RESUMED) {
                    next.l(e.b.STARTED);
                } else {
                    e.b bVar2 = e.b.STARTED;
                    if (d2 != bVar2) {
                        hashMap.put(next, bVar2);
                    }
                }
                jVar = jVar.w();
            }
        }
        for (e eVar : this.h) {
            e.b bVar3 = (e.b) hashMap.get(eVar);
            if (bVar3 != null) {
                eVar.l(bVar3);
            } else {
                eVar.m();
            }
        }
        e peekLast = this.h.peekLast();
        Iterator<b> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().a(this, peekLast.c(), peekLast.b());
        }
        return true;
    }

    private String d(int[] iArr) {
        k kVar;
        k kVar2 = this.f906d;
        int i = 0;
        while (true) {
            j jVar = null;
            if (i >= iArr.length) {
                return null;
            }
            int i2 = iArr[i];
            if (i != 0) {
                jVar = kVar2.F(i2);
            } else if (this.f906d.s() == i2) {
                jVar = this.f906d;
            }
            if (jVar == null) {
                return j.m(this.f903a, i2);
            }
            if (i != iArr.length - 1) {
                while (true) {
                    kVar = (k) jVar;
                    if (!(kVar.F(kVar.I()) instanceof k)) {
                        break;
                    }
                    jVar = kVar.F(kVar.I());
                }
                kVar2 = kVar;
            }
            i++;
        }
    }

    private int g() {
        int i = 0;
        for (e eVar : this.h) {
            if (!(eVar.c() instanceof k)) {
                i++;
            }
        }
        return i;
    }

    private void k(j jVar, Bundle bundle, o oVar, r.a aVar) {
        boolean z = false;
        boolean o = (oVar == null || oVar.e() == -1) ? false : o(oVar.e(), oVar.f());
        r e = this.k.e(jVar.u());
        Bundle f = jVar.f(bundle);
        j b2 = e.b(jVar, f, oVar, aVar);
        if (b2 != null) {
            if (!(b2 instanceof androidx.navigation.b)) {
                while (!this.h.isEmpty() && (this.h.peekLast().c() instanceof androidx.navigation.b) && o(this.h.peekLast().c().s(), true)) {
                }
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            if (jVar instanceof k) {
                k kVar = b2;
                while (true) {
                    k w = kVar.w();
                    if (w != null) {
                        arrayDeque.addFirst(new e(this.f903a, w, f, this.i, this.j));
                        if (!this.h.isEmpty() && this.h.getLast().c() == w) {
                            o(w.s(), true);
                        }
                    }
                    if (w == null || w == jVar) {
                        break;
                    }
                    kVar = w;
                }
            }
            k c2 = arrayDeque.isEmpty() ? b2 : ((e) arrayDeque.getFirst()).c();
            while (c2 != null && c(c2.s()) == null) {
                c2 = c2.w();
                if (c2 != null) {
                    arrayDeque.addFirst(new e(this.f903a, c2, f, this.i, this.j));
                }
            }
            j c3 = arrayDeque.isEmpty() ? b2 : ((e) arrayDeque.getLast()).c();
            while (!this.h.isEmpty() && (this.h.getLast().c() instanceof k) && ((k) this.h.getLast().c()).G(c3.s(), false) == null && o(this.h.getLast().c().s(), true)) {
            }
            this.h.addAll(arrayDeque);
            if (this.h.isEmpty() || this.h.getFirst().c() != this.f906d) {
                this.h.addFirst(new e(this.f903a, this.f906d, f, this.i, this.j));
            }
            this.h.add(new e(this.f903a, b2, b2.f(f), this.i, this.j));
        } else if (oVar != null && oVar.g()) {
            e peekLast = this.h.peekLast();
            if (peekLast != null) {
                peekLast.h(f);
            }
            z = true;
        }
        x();
        if (o || b2 != null || z) {
            a();
        }
    }

    private void l(Bundle bundle) {
        Activity activity;
        ArrayList<String> stringArrayList;
        Bundle bundle2 = this.e;
        if (bundle2 != null && (stringArrayList = bundle2.getStringArrayList("android-support-nav:controller:navigatorState:names")) != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                r e = this.k.e(next);
                Bundle bundle3 = this.e.getBundle(next);
                if (bundle3 != null) {
                    e.c(bundle3);
                }
            }
        }
        Parcelable[] parcelableArr = this.f;
        boolean z = false;
        if (parcelableArr != null) {
            for (Parcelable parcelable : parcelableArr) {
                f fVar = (f) parcelable;
                j c2 = c(fVar.b());
                if (c2 == null) {
                    throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + j.m(this.f903a, fVar.b()) + " cannot be found from the current destination " + f());
                }
                Bundle a2 = fVar.a();
                if (a2 != null) {
                    a2.setClassLoader(this.f903a.getClassLoader());
                }
                this.h.add(new e(this.f903a, c2, a2, this.i, this.j, fVar.h(), fVar.c()));
            }
            x();
            this.f = null;
        }
        if (this.f906d == null || !this.h.isEmpty()) {
            a();
            return;
        }
        if (!this.g && (activity = this.f904b) != null && j(activity.getIntent())) {
            z = true;
        }
        if (z) {
            return;
        }
        k(this.f906d, bundle, null, null);
    }

    private void x() {
        boolean z = true;
        this.n.f((!this.o || g() <= 1) ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z) {
        this.o = z;
        x();
    }

    j c(int i) {
        k kVar = this.f906d;
        if (kVar == null) {
            return null;
        }
        if (kVar.s() == i) {
            return this.f906d;
        }
        k c2 = this.h.isEmpty() ? this.f906d : this.h.getLast().c();
        return (c2 instanceof k ? c2 : c2.w()).F(i);
    }

    public e e() {
        if (this.h.isEmpty()) {
            return null;
        }
        return this.h.getLast();
    }

    public j f() {
        e e = e();
        if (e != null) {
            return e.c();
        }
        return null;
    }

    public n h() {
        if (this.f905c == null) {
            this.f905c = new n(this.f903a, this.k);
        }
        return this.f905c;
    }

    public s i() {
        return this.k;
    }

    public boolean j(Intent intent) {
        j.a x;
        k kVar;
        if (intent == null) {
            return false;
        }
        Bundle extras = intent.getExtras();
        int[] intArray = extras != null ? extras.getIntArray("android-support-nav:controller:deepLinkIds") : null;
        Bundle bundle = new Bundle();
        Bundle bundle2 = extras != null ? extras.getBundle("android-support-nav:controller:deepLinkExtras") : null;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if ((intArray == null || intArray.length == 0) && intent.getData() != null && (x = this.f906d.x(new i(intent))) != null) {
            j e = x.e();
            int[] g = e.g();
            bundle.putAll(e.f(x.f()));
            intArray = g;
        }
        if (intArray == null || intArray.length == 0) {
            return false;
        }
        String d2 = d(intArray);
        if (d2 != null) {
            Log.i("NavController", "Could not find destination " + d2 + " in the navigation graph, ignoring the deep link from " + intent);
            return false;
        }
        bundle.putParcelable("android-support-nav:controller:deepLinkIntent", intent);
        int flags = intent.getFlags();
        int i = 268435456 & flags;
        if (i != 0 && (flags & 32768) == 0) {
            intent.addFlags(32768);
            androidx.core.app.n i2 = androidx.core.app.n.i(this.f903a);
            i2.e(intent);
            i2.l();
            Activity activity = this.f904b;
            if (activity != null) {
                activity.finish();
                this.f904b.overridePendingTransition(0, 0);
            }
            return true;
        } else if (i != 0) {
            if (!this.h.isEmpty()) {
                o(this.f906d.s(), true);
            }
            int i3 = 0;
            while (i3 < intArray.length) {
                int i4 = i3 + 1;
                int i5 = intArray[i3];
                j c2 = c(i5);
                if (c2 == null) {
                    String m = j.m(this.f903a, i5);
                    throw new IllegalStateException("Deep Linking failed: destination " + m + " cannot be found from the current destination " + f());
                }
                o.a aVar = new o.a();
                aVar.b(0);
                aVar.c(0);
                k(c2, bundle, aVar.a(), null);
                i3 = i4;
            }
            return true;
        } else {
            k kVar2 = this.f906d;
            int i6 = 0;
            while (i6 < intArray.length) {
                int i7 = intArray[i6];
                j F = i6 == 0 ? this.f906d : kVar2.F(i7);
                if (F == null) {
                    String m2 = j.m(this.f903a, i7);
                    throw new IllegalStateException("Deep Linking failed: destination " + m2 + " cannot be found in graph " + kVar2);
                }
                if (i6 != intArray.length - 1) {
                    while (true) {
                        kVar = (k) F;
                        if (!(kVar.F(kVar.I()) instanceof k)) {
                            break;
                        }
                        F = kVar.F(kVar.I());
                    }
                    kVar2 = kVar;
                } else {
                    Bundle f = F.f(bundle);
                    o.a aVar2 = new o.a();
                    aVar2.g(this.f906d.s(), true);
                    aVar2.b(0);
                    aVar2.c(0);
                    k(F, f, aVar2.a(), null);
                }
                i6++;
            }
            this.g = true;
            return true;
        }
    }

    public boolean m() {
        if (this.h.isEmpty()) {
            return false;
        }
        return n(f().s(), true);
    }

    public boolean n(int i, boolean z) {
        return o(i, z) && a();
    }

    boolean o(int i, boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> descendingIterator = this.h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            j c2 = descendingIterator.next().c();
            r e = this.k.e(c2.u());
            if (z || c2.s() != i) {
                arrayList.add(e);
            }
            if (c2.s() == i) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            String m = j.m(this.f903a, i);
            Log.i("NavController", "Ignoring popBackStack to destination " + m + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((r) it.next()).e()) {
            e removeLast = this.h.removeLast();
            if (removeLast.a().b().d(e.b.CREATED)) {
                removeLast.l(e.b.DESTROYED);
            }
            g gVar = this.j;
            if (gVar != null) {
                gVar.e(removeLast.j);
            }
            z3 = true;
        }
        x();
        return z3;
    }

    public void p(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(this.f903a.getClassLoader());
        this.e = bundle.getBundle("android-support-nav:controller:navigatorState");
        this.f = bundle.getParcelableArray("android-support-nav:controller:backStack");
        this.g = bundle.getBoolean("android-support-nav:controller:deepLinkHandled");
    }

    public Bundle q() {
        Bundle bundle;
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle bundle2 = new Bundle();
        for (Map.Entry<String, r<? extends j>> entry : this.k.f().entrySet()) {
            String key = entry.getKey();
            Bundle d2 = entry.getValue().d();
            if (d2 != null) {
                arrayList.add(key);
                bundle2.putBundle(key, d2);
            }
        }
        if (arrayList.isEmpty()) {
            bundle = null;
        } else {
            bundle = new Bundle();
            bundle2.putStringArrayList("android-support-nav:controller:navigatorState:names", arrayList);
            bundle.putBundle("android-support-nav:controller:navigatorState", bundle2);
        }
        if (!this.h.isEmpty()) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Parcelable[] parcelableArr = new Parcelable[this.h.size()];
            int i = 0;
            for (e eVar : this.h) {
                parcelableArr[i] = new f(eVar);
                i++;
            }
            bundle.putParcelableArray("android-support-nav:controller:backStack", parcelableArr);
        }
        if (this.g) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android-support-nav:controller:deepLinkHandled", this.g);
        }
        return bundle;
    }

    public void r(int i) {
        s(i, null);
    }

    public void s(int i, Bundle bundle) {
        t(h().c(i), bundle);
    }

    public void t(k kVar, Bundle bundle) {
        k kVar2 = this.f906d;
        if (kVar2 != null) {
            o(kVar2.s(), true);
        }
        this.f906d = kVar;
        l(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(androidx.lifecycle.j jVar) {
        if (jVar == this.i) {
            return;
        }
        this.i = jVar;
        jVar.a().a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (this.i == null) {
            throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()");
        }
        this.n.d();
        onBackPressedDispatcher.a(this.i, this.n);
        this.i.a().c(this.m);
        this.i.a().a(this.m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(v vVar) {
        if (this.j == g.f(vVar)) {
            return;
        }
        if (!this.h.isEmpty()) {
            throw new IllegalStateException("ViewModelStore should be set before setGraph call");
        }
        this.j = g.f(vVar);
    }
}
