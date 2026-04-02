package d.w;

import java.util.Iterator;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements d.v.b<d.t.c> {

    /* renamed from: a  reason: collision with root package name */
    private final CharSequence f2419a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2420b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2421c;

    /* renamed from: d  reason: collision with root package name */
    private final d.s.c.p<CharSequence, Integer, d.i<Integer, Integer>> f2422d;

    /* loaded from: classes.dex */
    public static final class a implements Iterator<d.t.c> {
        private int f = -1;
        private int g;
        private int h;
        private d.t.c i;
        private int j;

        a() {
            int c2;
            c2 = d.t.f.c(d.this.f2420b, 0, d.this.f2419a.length());
            this.g = c2;
            this.h = c2;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0021, code lost:
            if (r0 < r6.k.f2421c) goto L15;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.h
                r1 = 0
                if (r0 >= 0) goto Lc
                r6.f = r1
                r0 = 0
                r6.i = r0
                goto L99
            Lc:
                d.w.d r0 = d.w.d.this
                int r0 = d.w.d.c(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L23
                int r0 = r6.j
                int r0 = r0 + r3
                r6.j = r0
                d.w.d r4 = d.w.d.this
                int r4 = d.w.d.c(r4)
                if (r0 >= r4) goto L31
            L23:
                int r0 = r6.h
                d.w.d r4 = d.w.d.this
                java.lang.CharSequence r4 = d.w.d.b(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L47
            L31:
                int r0 = r6.g
                d.t.c r1 = new d.t.c
                d.w.d r4 = d.w.d.this
                java.lang.CharSequence r4 = d.w.d.b(r4)
                int r4 = d.w.p.k(r4)
                r1.<init>(r0, r4)
            L42:
                r6.i = r1
            L44:
                r6.h = r2
                goto L97
            L47:
                d.w.d r0 = d.w.d.this
                d.s.c.p r0 = d.w.d.a(r0)
                d.w.d r4 = d.w.d.this
                java.lang.CharSequence r4 = d.w.d.b(r4)
                int r5 = r6.h
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.a(r4, r5)
                d.i r0 = (d.i) r0
                if (r0 != 0) goto L73
                int r0 = r6.g
                d.t.c r1 = new d.t.c
                d.w.d r4 = d.w.d.this
                java.lang.CharSequence r4 = d.w.d.b(r4)
                int r4 = d.w.p.k(r4)
                r1.<init>(r0, r4)
                goto L42
            L73:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.g
                d.t.c r4 = d.t.d.e(r4, r2)
                r6.i = r4
                int r2 = r2 + r0
                r6.g = r2
                if (r0 != 0) goto L95
                r1 = 1
            L95:
                int r2 = r2 + r1
                goto L44
            L97:
                r6.f = r3
            L99:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.w.d.a.a():void");
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public d.t.c next() {
            if (this.f == -1) {
                a();
            }
            if (this.f != 0) {
                d.t.c cVar = this.i;
                if (cVar != null) {
                    this.i = null;
                    this.f = -1;
                    return cVar;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f == -1) {
                a();
            }
            return this.f == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(CharSequence charSequence, int i, int i2, d.s.c.p<? super CharSequence, ? super Integer, d.i<Integer, Integer>> pVar) {
        d.s.d.g.e(charSequence, "input");
        d.s.d.g.e(pVar, "getNextMatch");
        this.f2419a = charSequence;
        this.f2420b = i;
        this.f2421c = i2;
        this.f2422d = pVar;
    }

    @Override // d.v.b
    public Iterator<d.t.c> iterator() {
        return new a();
    }
}
