package com.google.firebase.database.p.h0;

import com.google.firebase.database.p.c0;
import com.google.firebase.database.p.e0.d;
import com.google.firebase.database.p.h0.m.d;
import com.google.firebase.database.r.m;
import com.google.firebase.database.r.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static d.a f2228b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final com.google.firebase.database.p.h0.m.d f2229a;

    /* loaded from: classes.dex */
    class a implements d.a {
        a() {
        }

        @Override // com.google.firebase.database.p.h0.m.d.a
        public m a(com.google.firebase.database.r.h hVar, m mVar, boolean z) {
            return null;
        }

        @Override // com.google.firebase.database.p.h0.m.d.a
        public n b(com.google.firebase.database.r.b bVar) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2230a;

        static {
            int[] iArr = new int[d.a.values().length];
            f2230a = iArr;
            try {
                iArr[d.a.Overwrite.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2230a[d.a.Merge.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2230a[d.a.AckUserWrite.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2230a[d.a.ListenComplete.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final k f2231a;

        /* renamed from: b  reason: collision with root package name */
        public final List<com.google.firebase.database.p.h0.c> f2232b;

        public c(k kVar, List<com.google.firebase.database.p.h0.c> list) {
            this.f2231a = kVar;
            this.f2232b = list;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements d.a {

        /* renamed from: a  reason: collision with root package name */
        private final c0 f2233a;

        /* renamed from: b  reason: collision with root package name */
        private final k f2234b;

        /* renamed from: c  reason: collision with root package name */
        private final n f2235c;

        public d(c0 c0Var, k kVar, n nVar) {
            this.f2233a = c0Var;
            this.f2234b = kVar;
            this.f2235c = nVar;
        }

        @Override // com.google.firebase.database.p.h0.m.d.a
        public m a(com.google.firebase.database.r.h hVar, m mVar, boolean z) {
            n nVar = this.f2235c;
            if (nVar == null) {
                nVar = this.f2234b.b();
            }
            return this.f2233a.g(nVar, mVar, z, hVar);
        }

        @Override // com.google.firebase.database.p.h0.m.d.a
        public n b(com.google.firebase.database.r.b bVar) {
            com.google.firebase.database.p.h0.a c2 = this.f2234b.c();
            if (c2.c(bVar)) {
                return c2.b().b(bVar);
            }
            n nVar = this.f2235c;
            return this.f2233a.a(bVar, nVar != null ? new com.google.firebase.database.p.h0.a(com.google.firebase.database.r.i.f(nVar, com.google.firebase.database.r.j.j()), true, false) : this.f2234b.d());
        }
    }

    public l(com.google.firebase.database.p.h0.m.d dVar) {
        this.f2229a = dVar;
    }

    private k a(k kVar, com.google.firebase.database.p.l lVar, com.google.firebase.database.p.g0.d<Boolean> dVar, c0 c0Var, n nVar, com.google.firebase.database.p.h0.m.a aVar) {
        if (c0Var.i(lVar) != null) {
            return kVar;
        }
        boolean e = kVar.d().e();
        com.google.firebase.database.p.h0.a d2 = kVar.d();
        if (dVar.getValue() == null) {
            com.google.firebase.database.p.b s = com.google.firebase.database.p.b.s();
            Iterator<Map.Entry<com.google.firebase.database.p.l, Boolean>> it = dVar.iterator();
            com.google.firebase.database.p.b bVar = s;
            while (it.hasNext()) {
                com.google.firebase.database.p.l key = it.next().getKey();
                com.google.firebase.database.p.l i = lVar.i(key);
                if (d2.d(i)) {
                    bVar = bVar.d(key, d2.b().h(i));
                }
            }
            return c(kVar, lVar, bVar, c0Var, nVar, e, aVar);
        } else if ((lVar.isEmpty() && d2.f()) || d2.d(lVar)) {
            return d(kVar, lVar, d2.b().h(lVar), c0Var, nVar, e, aVar);
        } else {
            if (lVar.isEmpty()) {
                com.google.firebase.database.p.b s2 = com.google.firebase.database.p.b.s();
                com.google.firebase.database.p.b bVar2 = s2;
                for (m mVar : d2.b()) {
                    bVar2 = bVar2.e(mVar.c(), mVar.d());
                }
                return c(kVar, lVar, bVar2, c0Var, nVar, e, aVar);
            }
            return kVar;
        }
    }

    private k c(k kVar, com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar, c0 c0Var, n nVar, boolean z, com.google.firebase.database.p.h0.m.a aVar) {
        if (!kVar.d().b().isEmpty() || kVar.d().f()) {
            com.google.firebase.database.p.b f = lVar.isEmpty() ? bVar : com.google.firebase.database.p.b.s().f(lVar, bVar);
            n b2 = kVar.d().b();
            Map<com.google.firebase.database.r.b, com.google.firebase.database.p.b> m = f.m();
            k kVar2 = kVar;
            for (Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.b> entry : m.entrySet()) {
                com.google.firebase.database.r.b key = entry.getKey();
                if (b2.o(key)) {
                    kVar2 = d(kVar2, new com.google.firebase.database.p.l(key), entry.getValue().g(b2.b(key)), c0Var, nVar, z, aVar);
                }
            }
            k kVar3 = kVar2;
            for (Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.b> entry2 : m.entrySet()) {
                com.google.firebase.database.r.b key2 = entry2.getKey();
                boolean z2 = !kVar.d().c(key2) && entry2.getValue().C() == null;
                if (!b2.o(key2) && !z2) {
                    kVar3 = d(kVar3, new com.google.firebase.database.p.l(key2), entry2.getValue().g(b2.b(key2)), c0Var, nVar, z, aVar);
                }
            }
            return kVar3;
        }
        return kVar;
    }

    private k d(k kVar, com.google.firebase.database.p.l lVar, n nVar, c0 c0Var, n nVar2, boolean z, com.google.firebase.database.p.h0.m.a aVar) {
        com.google.firebase.database.r.i e;
        com.google.firebase.database.r.i s;
        com.google.firebase.database.r.i a2;
        com.google.firebase.database.p.h0.a d2 = kVar.d();
        com.google.firebase.database.p.h0.m.d dVar = this.f2229a;
        if (!z) {
            dVar = dVar.a();
        }
        boolean z2 = true;
        if (lVar.isEmpty()) {
            a2 = d2.a();
            s = com.google.firebase.database.r.i.f(nVar, dVar.d());
        } else if (!dVar.c() || d2.e()) {
            com.google.firebase.database.r.b x = lVar.x();
            if (d2.d(lVar) || lVar.size() <= 1) {
                com.google.firebase.database.p.l A = lVar.A();
                n q = d2.b().b(x).q(A, nVar);
                if (x.w()) {
                    e = dVar.b(d2.a(), q);
                } else {
                    e = dVar.e(d2.a(), x, q, A, f2228b, null);
                }
                if (!d2.f() && !lVar.isEmpty()) {
                    z2 = false;
                }
                k f = kVar.f(e, z2, dVar.c());
                return h(f, lVar, c0Var, new d(c0Var, f, nVar2), aVar);
            }
            return kVar;
        } else {
            com.google.firebase.database.r.b x2 = lVar.x();
            s = d2.a().s(x2, d2.b().b(x2).q(lVar.A(), nVar));
            a2 = d2.a();
        }
        e = dVar.f(a2, s, null);
        if (!d2.f()) {
            z2 = false;
        }
        k f2 = kVar.f(e, z2, dVar.c());
        return h(f2, lVar, c0Var, new d(c0Var, f2, nVar2), aVar);
    }

    private k e(k kVar, com.google.firebase.database.p.l lVar, com.google.firebase.database.p.b bVar, c0 c0Var, n nVar, com.google.firebase.database.p.h0.m.a aVar) {
        Iterator<Map.Entry<com.google.firebase.database.p.l, n>> it = bVar.iterator();
        k kVar2 = kVar;
        while (it.hasNext()) {
            Map.Entry<com.google.firebase.database.p.l, n> next = it.next();
            com.google.firebase.database.p.l i = lVar.i(next.getKey());
            if (g(kVar, i.x())) {
                kVar2 = f(kVar2, i, next.getValue(), c0Var, nVar, aVar);
            }
        }
        Iterator<Map.Entry<com.google.firebase.database.p.l, n>> it2 = bVar.iterator();
        k kVar3 = kVar2;
        while (it2.hasNext()) {
            Map.Entry<com.google.firebase.database.p.l, n> next2 = it2.next();
            com.google.firebase.database.p.l i2 = lVar.i(next2.getKey());
            if (!g(kVar, i2.x())) {
                kVar3 = f(kVar3, i2, next2.getValue(), c0Var, nVar, aVar);
            }
        }
        return kVar3;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.firebase.database.p.h0.k f(com.google.firebase.database.p.h0.k r9, com.google.firebase.database.p.l r10, com.google.firebase.database.r.n r11, com.google.firebase.database.p.c0 r12, com.google.firebase.database.r.n r13, com.google.firebase.database.p.h0.m.a r14) {
        /*
            r8 = this;
            com.google.firebase.database.p.h0.a r0 = r9.c()
            com.google.firebase.database.p.h0.l$d r6 = new com.google.firebase.database.p.h0.l$d
            r6.<init>(r12, r9, r13)
            boolean r12 = r10.isEmpty()
            if (r12 == 0) goto L34
            com.google.firebase.database.p.h0.m.d r10 = r8.f2229a
            com.google.firebase.database.r.h r10 = r10.d()
            com.google.firebase.database.r.i r10 = com.google.firebase.database.r.i.f(r11, r10)
            com.google.firebase.database.p.h0.m.d r11 = r8.f2229a
            com.google.firebase.database.p.h0.a r12 = r9.c()
            com.google.firebase.database.r.i r12 = r12.a()
            com.google.firebase.database.r.i r10 = r11.f(r12, r10, r14)
            r11 = 1
        L28:
            com.google.firebase.database.p.h0.m.d r12 = r8.f2229a
            boolean r12 = r12.c()
        L2e:
            com.google.firebase.database.p.h0.k r9 = r9.e(r10, r11, r12)
            goto Laa
        L34:
            com.google.firebase.database.r.b r3 = r10.x()
            boolean r12 = r3.w()
            if (r12 == 0) goto L55
            com.google.firebase.database.p.h0.m.d r10 = r8.f2229a
            com.google.firebase.database.p.h0.a r12 = r9.c()
            com.google.firebase.database.r.i r12 = r12.a()
            com.google.firebase.database.r.i r10 = r10.b(r12, r11)
            boolean r11 = r0.f()
            boolean r12 = r0.e()
            goto L2e
        L55:
            com.google.firebase.database.p.l r5 = r10.A()
            com.google.firebase.database.r.n r10 = r0.b()
            com.google.firebase.database.r.n r10 = r10.b(r3)
            boolean r12 = r5.isEmpty()
            if (r12 == 0) goto L69
        L67:
            r4 = r11
            goto L93
        L69:
            com.google.firebase.database.r.n r12 = r6.b(r3)
            if (r12 == 0) goto L8e
            com.google.firebase.database.r.b r13 = r5.u()
            boolean r13 = r13.w()
            if (r13 == 0) goto L89
            com.google.firebase.database.p.l r13 = r5.y()
            com.google.firebase.database.r.n r13 = r12.h(r13)
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L89
            r4 = r12
            goto L93
        L89:
            com.google.firebase.database.r.n r11 = r12.q(r5, r11)
            goto L67
        L8e:
            com.google.firebase.database.r.g r11 = com.google.firebase.database.r.g.s()
            goto L67
        L93:
            boolean r10 = r10.equals(r4)
            if (r10 != 0) goto Laa
            com.google.firebase.database.p.h0.m.d r1 = r8.f2229a
            com.google.firebase.database.r.i r2 = r0.a()
            r7 = r14
            com.google.firebase.database.r.i r10 = r1.e(r2, r3, r4, r5, r6, r7)
            boolean r11 = r0.f()
            goto L28
        Laa:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.p.h0.l.f(com.google.firebase.database.p.h0.k, com.google.firebase.database.p.l, com.google.firebase.database.r.n, com.google.firebase.database.p.c0, com.google.firebase.database.r.n, com.google.firebase.database.p.h0.m.a):com.google.firebase.database.p.h0.k");
    }

    private static boolean g(k kVar, com.google.firebase.database.r.b bVar) {
        return kVar.c().c(bVar);
    }

    private k h(k kVar, com.google.firebase.database.p.l lVar, c0 c0Var, d.a aVar, com.google.firebase.database.p.h0.m.a aVar2) {
        n a2;
        com.google.firebase.database.r.i e;
        n b2;
        com.google.firebase.database.p.h0.a c2 = kVar.c();
        if (c0Var.i(lVar) != null) {
            return kVar;
        }
        if (lVar.isEmpty()) {
            if (kVar.d().e()) {
                n b3 = kVar.b();
                if (!(b3 instanceof com.google.firebase.database.r.c)) {
                    b3 = com.google.firebase.database.r.g.s();
                }
                b2 = c0Var.e(b3);
            } else {
                b2 = c0Var.b(kVar.b());
            }
            e = this.f2229a.f(kVar.c().a(), com.google.firebase.database.r.i.f(b2, this.f2229a.d()), aVar2);
        } else {
            com.google.firebase.database.r.b x = lVar.x();
            if (x.w()) {
                n f = c0Var.f(lVar, c2.b(), kVar.d().b());
                if (f != null) {
                    e = this.f2229a.b(c2.a(), f);
                }
                e = c2.a();
            } else {
                com.google.firebase.database.p.l A = lVar.A();
                if (c2.c(x)) {
                    n f2 = c0Var.f(lVar, c2.b(), kVar.d().b());
                    a2 = f2 != null ? c2.b().b(x).q(A, f2) : c2.b().b(x);
                } else {
                    a2 = c0Var.a(x, kVar.d());
                }
                n nVar = a2;
                if (nVar != null) {
                    e = this.f2229a.e(c2.a(), x, nVar, A, aVar, aVar2);
                }
                e = c2.a();
            }
        }
        return kVar.e(e, c2.f() || lVar.isEmpty(), this.f2229a.c());
    }

    private k i(k kVar, com.google.firebase.database.p.l lVar, c0 c0Var, n nVar, com.google.firebase.database.p.h0.m.a aVar) {
        com.google.firebase.database.p.h0.a d2 = kVar.d();
        return h(kVar.f(d2.a(), d2.f() || lVar.isEmpty(), d2.e()), lVar, c0Var, f2228b, aVar);
    }

    private void j(k kVar, k kVar2, List<com.google.firebase.database.p.h0.c> list) {
        com.google.firebase.database.p.h0.a c2 = kVar2.c();
        if (c2.f()) {
            boolean z = c2.b().k() || c2.b().isEmpty();
            if (list.isEmpty() && kVar.c().f() && ((!z || c2.b().equals(kVar.a())) && c2.b().c().equals(kVar.a().c()))) {
                return;
            }
            list.add(com.google.firebase.database.p.h0.c.m(c2.a()));
        }
    }

    public c b(k kVar, com.google.firebase.database.p.e0.d dVar, c0 c0Var, n nVar) {
        k d2;
        com.google.firebase.database.p.h0.m.a aVar = new com.google.firebase.database.p.h0.m.a();
        int i = b.f2230a[dVar.c().ordinal()];
        if (i == 1) {
            com.google.firebase.database.p.e0.f fVar = (com.google.firebase.database.p.e0.f) dVar;
            if (fVar.b().c()) {
                d2 = f(kVar, fVar.a(), fVar.e(), c0Var, nVar, aVar);
            } else {
                d2 = d(kVar, fVar.a(), fVar.e(), c0Var, nVar, fVar.b().d() || (kVar.d().e() && !fVar.a().isEmpty()), aVar);
            }
        } else if (i == 2) {
            com.google.firebase.database.p.e0.c cVar = (com.google.firebase.database.p.e0.c) dVar;
            if (cVar.b().c()) {
                d2 = e(kVar, cVar.a(), cVar.e(), c0Var, nVar, aVar);
            } else {
                d2 = c(kVar, cVar.a(), cVar.e(), c0Var, nVar, cVar.b().d() || kVar.d().e(), aVar);
            }
        } else if (i == 3) {
            com.google.firebase.database.p.e0.a aVar2 = (com.google.firebase.database.p.e0.a) dVar;
            boolean f = aVar2.f();
            com.google.firebase.database.p.l a2 = aVar2.a();
            d2 = !f ? a(kVar, a2, aVar2.e(), c0Var, nVar, aVar) : k(kVar, a2, c0Var, nVar, aVar);
        } else if (i != 4) {
            throw new AssertionError("Unknown operation: " + dVar.c());
        } else {
            d2 = i(kVar, dVar.a(), c0Var, nVar, aVar);
        }
        ArrayList arrayList = new ArrayList(aVar.a());
        j(kVar, d2, arrayList);
        return new c(d2, arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
        if (r10.k() == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.firebase.database.p.h0.k k(com.google.firebase.database.p.h0.k r9, com.google.firebase.database.p.l r10, com.google.firebase.database.p.c0 r11, com.google.firebase.database.r.n r12, com.google.firebase.database.p.h0.m.a r13) {
        /*
            r8 = this;
            com.google.firebase.database.r.n r0 = r11.i(r10)
            if (r0 == 0) goto L7
            return r9
        L7:
            com.google.firebase.database.p.h0.l$d r6 = new com.google.firebase.database.p.h0.l$d
            r6.<init>(r11, r9, r12)
            com.google.firebase.database.p.h0.a r12 = r9.c()
            com.google.firebase.database.r.i r2 = r12.a()
            boolean r12 = r10.isEmpty()
            if (r12 != 0) goto L8e
            com.google.firebase.database.r.b r12 = r10.x()
            boolean r12 = r12.w()
            if (r12 == 0) goto L25
            goto L8e
        L25:
            com.google.firebase.database.r.b r3 = r10.x()
            com.google.firebase.database.p.h0.a r12 = r9.d()
            com.google.firebase.database.r.n r12 = r11.a(r3, r12)
            if (r12 != 0) goto L45
            com.google.firebase.database.p.h0.a r0 = r9.d()
            boolean r0 = r0.c(r3)
            if (r0 == 0) goto L45
            com.google.firebase.database.r.n r12 = r2.l()
            com.google.firebase.database.r.n r12 = r12.b(r3)
        L45:
            r4 = r12
            if (r4 == 0) goto L54
            com.google.firebase.database.p.h0.m.d r1 = r8.f2229a
        L4a:
            com.google.firebase.database.p.l r5 = r10.A()
            r7 = r13
            com.google.firebase.database.r.i r2 = r1.e(r2, r3, r4, r5, r6, r7)
            goto L6b
        L54:
            if (r4 != 0) goto L6b
            com.google.firebase.database.p.h0.a r12 = r9.c()
            com.google.firebase.database.r.n r12 = r12.b()
            boolean r12 = r12.o(r3)
            if (r12 == 0) goto L6b
            com.google.firebase.database.p.h0.m.d r1 = r8.f2229a
            com.google.firebase.database.r.g r4 = com.google.firebase.database.r.g.s()
            goto L4a
        L6b:
            com.google.firebase.database.r.n r10 = r2.l()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto Lbd
            com.google.firebase.database.p.h0.a r10 = r9.d()
            boolean r10 = r10.f()
            if (r10 == 0) goto Lbd
            com.google.firebase.database.r.n r10 = r9.b()
            com.google.firebase.database.r.n r10 = r11.b(r10)
            boolean r12 = r10.k()
            if (r12 == 0) goto Lbd
            goto Lad
        L8e:
            com.google.firebase.database.p.h0.a r10 = r9.d()
            boolean r10 = r10.f()
            if (r10 == 0) goto La1
            com.google.firebase.database.r.n r10 = r9.b()
            com.google.firebase.database.r.n r10 = r11.b(r10)
            goto Lad
        La1:
            com.google.firebase.database.p.h0.a r10 = r9.d()
            com.google.firebase.database.r.n r10 = r10.b()
            com.google.firebase.database.r.n r10 = r11.e(r10)
        Lad:
            com.google.firebase.database.p.h0.m.d r12 = r8.f2229a
            com.google.firebase.database.r.h r12 = r12.d()
            com.google.firebase.database.r.i r10 = com.google.firebase.database.r.i.f(r10, r12)
            com.google.firebase.database.p.h0.m.d r12 = r8.f2229a
            com.google.firebase.database.r.i r2 = r12.f(r2, r10, r13)
        Lbd:
            com.google.firebase.database.p.h0.a r10 = r9.d()
            boolean r10 = r10.f()
            if (r10 != 0) goto Ld4
            com.google.firebase.database.p.l r10 = com.google.firebase.database.p.l.w()
            com.google.firebase.database.r.n r10 = r11.i(r10)
            if (r10 == 0) goto Ld2
            goto Ld4
        Ld2:
            r10 = 0
            goto Ld5
        Ld4:
            r10 = 1
        Ld5:
            com.google.firebase.database.p.h0.m.d r11 = r8.f2229a
            boolean r11 = r11.c()
            com.google.firebase.database.p.h0.k r9 = r9.e(r2, r10, r11)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.p.h0.l.k(com.google.firebase.database.p.h0.k, com.google.firebase.database.p.l, com.google.firebase.database.p.c0, com.google.firebase.database.r.n, com.google.firebase.database.p.h0.m.a):com.google.firebase.database.p.h0.k");
    }
}
