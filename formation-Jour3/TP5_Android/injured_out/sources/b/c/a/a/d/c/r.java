package b.c.a.a.d.c;
/* loaded from: classes.dex */
abstract class r extends c<String> {
    final CharSequence h;
    private final d i;
    private final boolean j;
    private int k = 0;
    private int l;

    /* JADX INFO: Access modifiers changed from: protected */
    public r(l lVar, CharSequence charSequence) {
        d dVar;
        int i;
        dVar = lVar.f1258a;
        this.i = dVar;
        this.j = false;
        i = lVar.f1260c;
        this.l = i;
        this.h = charSequence;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
        if (r0 >= r1) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        if (r6.i.b(r6.h.charAt(r0)) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r1 <= r0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
        if (r6.i.b(r6.h.charAt(r1 - 1)) == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r6.j == false) goto L45;
     */
    @Override // b.c.a.a.d.c.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final /* synthetic */ java.lang.String a() {
        /*
            r6 = this;
        L0:
            int r0 = r6.k
        L2:
            int r1 = r6.k
            r2 = -1
            if (r1 == r2) goto L8e
            int r1 = r6.c(r1)
            if (r1 != r2) goto L16
            java.lang.CharSequence r1 = r6.h
            int r1 = r1.length()
            r6.k = r2
            goto L1c
        L16:
            int r3 = r6.d(r1)
            r6.k = r3
        L1c:
            int r3 = r6.k
            if (r3 != r0) goto L2f
            int r3 = r3 + 1
            r6.k = r3
            java.lang.CharSequence r1 = r6.h
            int r1 = r1.length()
            if (r3 <= r1) goto L2
            r6.k = r2
            goto L2
        L2f:
            if (r0 >= r1) goto L42
            b.c.a.a.d.c.d r3 = r6.i
            java.lang.CharSequence r4 = r6.h
            char r4 = r4.charAt(r0)
            boolean r3 = r3.b(r4)
            if (r3 == 0) goto L42
            int r0 = r0 + 1
            goto L2f
        L42:
            if (r1 <= r0) goto L57
            b.c.a.a.d.c.d r3 = r6.i
            java.lang.CharSequence r4 = r6.h
            int r5 = r1 + (-1)
            char r4 = r4.charAt(r5)
            boolean r3 = r3.b(r4)
            if (r3 == 0) goto L57
            int r1 = r1 + (-1)
            goto L42
        L57:
            boolean r3 = r6.j
            if (r3 == 0) goto L5e
            if (r0 != r1) goto L5e
            goto L0
        L5e:
            int r3 = r6.l
            r4 = 1
            if (r3 != r4) goto L80
            java.lang.CharSequence r1 = r6.h
            int r1 = r1.length()
            r6.k = r2
        L6b:
            if (r1 <= r0) goto L83
            b.c.a.a.d.c.d r2 = r6.i
            java.lang.CharSequence r3 = r6.h
            int r4 = r1 + (-1)
            char r3 = r3.charAt(r4)
            boolean r2 = r2.b(r3)
            if (r2 == 0) goto L83
            int r1 = r1 + (-1)
            goto L6b
        L80:
            int r3 = r3 - r4
            r6.l = r3
        L83:
            java.lang.CharSequence r2 = r6.h
            java.lang.CharSequence r0 = r2.subSequence(r0, r1)
            java.lang.String r0 = r0.toString()
            return r0
        L8e:
            r6.b()
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.c.a.a.d.c.r.a():java.lang.Object");
    }

    abstract int c(int i);

    abstract int d(int i);
}
