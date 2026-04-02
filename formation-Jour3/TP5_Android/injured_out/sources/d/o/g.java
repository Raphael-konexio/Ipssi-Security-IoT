package d.o;

import java.util.List;
/* loaded from: classes.dex */
public final class g extends q {
    public static /* bridge */ /* synthetic */ <T> int c(List<? extends T> list) {
        return i.c(list);
    }

    public static /* bridge */ /* synthetic */ void f() {
        i.f();
        throw null;
    }

    public static /* bridge */ /* synthetic */ <T> int g(Iterable<? extends T> iterable, int i) {
        return j.g(iterable, i);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: d.o.q.i(java.lang.Iterable, java.lang.Appendable, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, d.s.c.l, int, java.lang.Object):java.lang.Appendable
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
        	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
        	... 1 more
        */
    public static /* bridge */ /* synthetic */ java.lang.Appendable i(java.lang.Iterable r0, java.lang.Appendable r1, java.lang.CharSequence r2, java.lang.CharSequence r3, java.lang.CharSequence r4, int r5, java.lang.CharSequence r6, d.s.c.l r7, int r8, java.lang.Object r9) {
        /*
            d.o.q.i(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.o.g.i(java.lang.Iterable, java.lang.Appendable, java.lang.CharSequence, java.lang.CharSequence, java.lang.CharSequence, int, java.lang.CharSequence, d.s.c.l, int, java.lang.Object):java.lang.Appendable");
    }

    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T l(Iterable<? extends T> iterable) {
        return (T) q.l(iterable);
    }

    public static /* bridge */ /* synthetic */ <T> T m(Iterable<? extends T> iterable) {
        return (T) q.m(iterable);
    }
}
