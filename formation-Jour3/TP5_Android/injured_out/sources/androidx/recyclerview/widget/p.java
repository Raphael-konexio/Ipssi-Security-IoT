package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    final a.d.g<RecyclerView.d0, a> f1121a = new a.d.g<>();

    /* renamed from: b  reason: collision with root package name */
    final a.d.d<RecyclerView.d0> f1122b = new a.d.d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static a.g.j.f<a> f1123d = new a.g.j.g(20);

        /* renamed from: a  reason: collision with root package name */
        int f1124a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.c f1125b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f1126c;

        private a() {
        }

        static void a() {
            do {
            } while (f1123d.b() != null);
        }

        static a b() {
            a b2 = f1123d.b();
            return b2 == null ? new a() : b2;
        }

        static void c(a aVar) {
            aVar.f1124a = 0;
            aVar.f1125b = null;
            aVar.f1126c = null;
            f1123d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.d0 d0Var);

        void b(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.d0 d0Var, int i) {
        a m;
        RecyclerView.l.c cVar;
        int f = this.f1121a.f(d0Var);
        if (f >= 0 && (m = this.f1121a.m(f)) != null) {
            int i2 = m.f1124a;
            if ((i2 & i) != 0) {
                m.f1124a = (~i) & i2;
                if (i == 4) {
                    cVar = m.f1125b;
                } else if (i != 8) {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                } else {
                    cVar = m.f1126c;
                }
                if ((m.f1124a & 12) == 0) {
                    this.f1121a.k(f);
                    a.c(m);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1121a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1121a.put(d0Var, aVar);
        }
        aVar.f1124a |= 2;
        aVar.f1125b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.d0 d0Var) {
        a aVar = this.f1121a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1121a.put(d0Var, aVar);
        }
        aVar.f1124a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j, RecyclerView.d0 d0Var) {
        this.f1122b.j(j, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1121a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1121a.put(d0Var, aVar);
        }
        aVar.f1126c = cVar;
        aVar.f1124a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.d0 d0Var, RecyclerView.l.c cVar) {
        a aVar = this.f1121a.get(d0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f1121a.put(d0Var, aVar);
        }
        aVar.f1125b = cVar;
        aVar.f1124a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f1121a.clear();
        this.f1122b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.d0 g(long j) {
        return this.f1122b.f(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.d0 d0Var) {
        a aVar = this.f1121a.get(d0Var);
        return (aVar == null || (aVar.f1124a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.d0 d0Var) {
        a aVar = this.f1121a.get(d0Var);
        return (aVar == null || (aVar.f1124a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.d0 d0Var) {
        p(d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.d0 d0Var) {
        return l(d0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.d0 d0Var) {
        return l(d0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        RecyclerView.l.c cVar;
        RecyclerView.l.c cVar2;
        for (int size = this.f1121a.size() - 1; size >= 0; size--) {
            RecyclerView.d0 i = this.f1121a.i(size);
            a k = this.f1121a.k(size);
            int i2 = k.f1124a;
            if ((i2 & 3) != 3) {
                if ((i2 & 1) != 0) {
                    cVar = k.f1125b;
                    cVar2 = cVar != null ? k.f1126c : null;
                } else {
                    if ((i2 & 14) != 14) {
                        if ((i2 & 12) == 12) {
                            bVar.d(i, k.f1125b, k.f1126c);
                        } else if ((i2 & 4) != 0) {
                            cVar = k.f1125b;
                        } else if ((i2 & 8) == 0) {
                        }
                        a.c(k);
                    }
                    bVar.b(i, k.f1125b, k.f1126c);
                    a.c(k);
                }
                bVar.c(i, cVar, cVar2);
                a.c(k);
            }
            bVar.a(i);
            a.c(k);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.d0 d0Var) {
        a aVar = this.f1121a.get(d0Var);
        if (aVar == null) {
            return;
        }
        aVar.f1124a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.d0 d0Var) {
        int m = this.f1122b.m() - 1;
        while (true) {
            if (m < 0) {
                break;
            } else if (d0Var == this.f1122b.n(m)) {
                this.f1122b.l(m);
                break;
            } else {
                m--;
            }
        }
        a remove = this.f1121a.remove(d0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
