package d.q;

import d.s.d.g;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0110a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f2404a;

        /* JADX WARN: Removed duplicated region for block: B:13:0x003e A[LOOP:0: B:3:0x000e->B:13:0x003e, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0042 A[EDGE_INSN: B:23:0x0042->B:15:0x0042 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                d.s.d.g.d(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            Le:
                java.lang.String r5 = "it"
                if (r4 >= r2) goto L41
                r6 = r1[r4]
                d.s.d.g.d(r6, r5)
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = d.s.d.g.a(r7, r8)
                if (r7 == 0) goto L3a
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                d.s.d.g.d(r7, r8)
                java.lang.Object r7 = d.o.a.c(r7)
                java.lang.Class r7 = (java.lang.Class) r7
                boolean r7 = d.s.d.g.a(r7, r0)
                if (r7 == 0) goto L3a
                r7 = 1
                goto L3b
            L3a:
                r7 = 0
            L3b:
                if (r7 == 0) goto L3e
                goto L42
            L3e:
                int r4 = r4 + 1
                goto Le
            L41:
                r6 = 0
            L42:
                d.q.a.C0110a.f2404a = r6
                int r0 = r1.length
            L45:
                if (r3 >= r0) goto L5c
                r2 = r1[r3]
                d.s.d.g.d(r2, r5)
                java.lang.String r2 = r2.getName()
                java.lang.String r4 = "getSuppressed"
                boolean r2 = d.s.d.g.a(r2, r4)
                if (r2 == 0) goto L59
                goto L5c
            L59:
                int r3 = r3 + 1
                goto L45
            L5c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.q.a.C0110a.<clinit>():void");
        }
    }

    public void a(Throwable th, Throwable th2) {
        g.e(th, "cause");
        g.e(th2, "exception");
        Method method = C0110a.f2404a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
