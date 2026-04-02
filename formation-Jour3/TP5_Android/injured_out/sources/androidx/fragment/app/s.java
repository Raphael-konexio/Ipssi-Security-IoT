package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Fragment> f829a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, r> f830b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Fragment fragment) {
        if (this.f829a.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f829a) {
            this.f829a.add(fragment);
        }
        fragment.p = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f830b.values().removeAll(Collections.singleton(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        return this.f830b.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i) {
        Iterator<Fragment> it = this.f829a.iterator();
        while (it.hasNext()) {
            r rVar = this.f830b.get(it.next().j);
            if (rVar != null) {
                rVar.q(i);
            }
        }
        for (r rVar2 : this.f830b.values()) {
            if (rVar2 != null) {
                rVar2.q(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2 = str + "    ";
        if (!this.f830b.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments:");
            for (r rVar : this.f830b.values()) {
                printWriter.print(str);
                if (rVar != null) {
                    Fragment i = rVar.i();
                    printWriter.println(i);
                    i.e(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        int size = this.f829a.size();
        if (size > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f829a.get(i2).toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment f(String str) {
        r rVar = this.f830b.get(str);
        if (rVar != null) {
            return rVar.i();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment g(int i) {
        for (int size = this.f829a.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f829a.get(size);
            if (fragment != null && fragment.A == i) {
                return fragment;
            }
        }
        for (r rVar : this.f830b.values()) {
            if (rVar != null) {
                Fragment i2 = rVar.i();
                if (i2.A == i) {
                    return i2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment h(String str) {
        if (str != null) {
            for (int size = this.f829a.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f829a.get(size);
                if (fragment != null && str.equals(fragment.C)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (r rVar : this.f830b.values()) {
                if (rVar != null) {
                    Fragment i = rVar.i();
                    if (str.equals(i.C)) {
                        return i;
                    }
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        Fragment h;
        for (r rVar : this.f830b.values()) {
            if (rVar != null && (h = rVar.i().h(str)) != null) {
                return h;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment j(Fragment fragment) {
        ViewGroup viewGroup = fragment.K;
        View view = fragment.L;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f829a.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f829a.get(indexOf);
                if (fragment2.K == viewGroup && fragment2.L != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> k() {
        ArrayList arrayList = new ArrayList();
        Iterator<r> it = this.f830b.values().iterator();
        while (it.hasNext()) {
            r next = it.next();
            arrayList.add(next != null ? next.i() : null);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r l(String str) {
        return this.f830b.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Fragment> m() {
        ArrayList arrayList;
        if (this.f829a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f829a) {
            arrayList = new ArrayList(this.f829a);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(r rVar) {
        this.f830b.put(rVar.i().j, rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(r rVar) {
        Fragment i = rVar.i();
        for (r rVar2 : this.f830b.values()) {
            if (rVar2 != null) {
                Fragment i2 = rVar2.i();
                if (i.j.equals(i2.m)) {
                    i2.l = i;
                    i2.m = null;
                }
            }
        }
        this.f830b.put(i.j, null);
        String str = i.m;
        if (str != null) {
            i.l = f(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Fragment fragment) {
        synchronized (this.f829a) {
            this.f829a.remove(fragment);
        }
        fragment.p = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f830b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(List<String> list) {
        this.f829a.clear();
        if (list != null) {
            for (String str : list) {
                Fragment f = f(str);
                if (f == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (m.p0(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + f);
                }
                a(f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<q> s() {
        ArrayList<q> arrayList = new ArrayList<>(this.f830b.size());
        for (r rVar : this.f830b.values()) {
            if (rVar != null) {
                Fragment i = rVar.i();
                q o = rVar.o();
                arrayList.add(o);
                if (m.p0(2)) {
                    Log.v("FragmentManager", "Saved state of " + i + ": " + o.r);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> t() {
        synchronized (this.f829a) {
            if (this.f829a.isEmpty()) {
                return null;
            }
            ArrayList<String> arrayList = new ArrayList<>(this.f829a.size());
            Iterator<Fragment> it = this.f829a.iterator();
            while (it.hasNext()) {
                Fragment next = it.next();
                arrayList.add(next.j);
                if (m.p0(2)) {
                    Log.v("FragmentManager", "saveAllState: adding fragment (" + next.j + "): " + next);
                }
            }
            return arrayList;
        }
    }
}
