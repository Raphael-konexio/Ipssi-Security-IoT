package com.google.firebase.database.r;

import com.google.firebase.database.r.c;
import com.google.firebase.database.r.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.google.firebase.database.p.l> f2355a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f2356b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends c.AbstractC0104c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f2357a;

        a(b bVar) {
            this.f2357a = bVar;
        }

        @Override // com.google.firebase.database.r.c.AbstractC0104c
        public void b(com.google.firebase.database.r.b bVar, n nVar) {
            this.f2357a.q(bVar);
            d.f(nVar, this.f2357a);
            this.f2357a.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: d  reason: collision with root package name */
        private int f2361d;
        private final InterfaceC0105d h;

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f2358a = null;

        /* renamed from: b  reason: collision with root package name */
        private Stack<com.google.firebase.database.r.b> f2359b = new Stack<>();

        /* renamed from: c  reason: collision with root package name */
        private int f2360c = -1;
        private boolean e = true;
        private final List<com.google.firebase.database.p.l> f = new ArrayList();
        private final List<String> g = new ArrayList();

        public b(InterfaceC0105d interfaceC0105d) {
            this.h = interfaceC0105d;
        }

        private void g(StringBuilder sb, com.google.firebase.database.r.b bVar) {
            sb.append(com.google.firebase.database.p.g0.l.i(bVar.e()));
        }

        private com.google.firebase.database.p.l k(int i) {
            com.google.firebase.database.r.b[] bVarArr = new com.google.firebase.database.r.b[i];
            for (int i2 = 0; i2 < i; i2++) {
                bVarArr[i2] = this.f2359b.get(i2);
            }
            return new com.google.firebase.database.p.l(bVarArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            this.f2361d--;
            if (h()) {
                this.f2358a.append(")");
            }
            this.e = true;
        }

        private void m() {
            com.google.firebase.database.p.g0.l.f(h(), "Can't end range without starting a range!");
            for (int i = 0; i < this.f2361d; i++) {
                this.f2358a.append(")");
            }
            this.f2358a.append(")");
            com.google.firebase.database.p.l k = k(this.f2360c);
            this.g.add(com.google.firebase.database.p.g0.l.h(this.f2358a.toString()));
            this.f.add(k);
            this.f2358a = null;
        }

        private void n() {
            if (h()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            this.f2358a = sb;
            sb.append("(");
            Iterator<com.google.firebase.database.r.b> it = k(this.f2361d).iterator();
            while (it.hasNext()) {
                g(this.f2358a, it.next());
                this.f2358a.append(":(");
            }
            this.e = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o() {
            com.google.firebase.database.p.g0.l.f(this.f2361d == 0, "Can't finish hashing in the middle processing a child");
            if (h()) {
                m();
            }
            this.g.add("");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(k<?> kVar) {
            n();
            this.f2360c = this.f2361d;
            this.f2358a.append(kVar.v(n.b.V2));
            this.e = true;
            if (this.h.a(this)) {
                m();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(com.google.firebase.database.r.b bVar) {
            n();
            if (this.e) {
                this.f2358a.append(",");
            }
            g(this.f2358a, bVar);
            this.f2358a.append(":(");
            if (this.f2361d == this.f2359b.size()) {
                this.f2359b.add(bVar);
            } else {
                this.f2359b.set(this.f2361d, bVar);
            }
            this.f2361d++;
            this.e = false;
        }

        public boolean h() {
            return this.f2358a != null;
        }

        public int i() {
            return this.f2358a.length();
        }

        public com.google.firebase.database.p.l j() {
            return k(this.f2361d);
        }
    }

    /* loaded from: classes.dex */
    private static class c implements InterfaceC0105d {

        /* renamed from: a  reason: collision with root package name */
        private final long f2362a;

        public c(n nVar) {
            this.f2362a = Math.max(512L, (long) Math.sqrt(com.google.firebase.database.p.g0.e.b(nVar) * 100));
        }

        @Override // com.google.firebase.database.r.d.InterfaceC0105d
        public boolean a(b bVar) {
            return ((long) bVar.i()) > this.f2362a && (bVar.j().isEmpty() || !bVar.j().u().equals(com.google.firebase.database.r.b.m()));
        }
    }

    /* renamed from: com.google.firebase.database.r.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0105d {
        boolean a(b bVar);
    }

    private d(List<com.google.firebase.database.p.l> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f2355a = list;
        this.f2356b = list2;
    }

    public static d b(n nVar) {
        return c(nVar, new c(nVar));
    }

    public static d c(n nVar, InterfaceC0105d interfaceC0105d) {
        if (nVar.isEmpty()) {
            return new d(Collections.emptyList(), Collections.singletonList(""));
        }
        b bVar = new b(interfaceC0105d);
        f(nVar, bVar);
        bVar.o();
        return new d(bVar.f, bVar.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(n nVar, b bVar) {
        if (nVar.k()) {
            bVar.p((k) nVar);
        } else if (nVar.isEmpty()) {
            throw new IllegalArgumentException("Can't calculate hash on empty node!");
        } else {
            if (nVar instanceof com.google.firebase.database.r.c) {
                ((com.google.firebase.database.r.c) nVar).g(new a(bVar), true);
                return;
            }
            throw new IllegalStateException("Expected children node, but got: " + nVar);
        }
    }

    public List<String> d() {
        return Collections.unmodifiableList(this.f2356b);
    }

    public List<com.google.firebase.database.p.l> e() {
        return Collections.unmodifiableList(this.f2355a);
    }
}
