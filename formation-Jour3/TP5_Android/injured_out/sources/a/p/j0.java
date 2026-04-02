package a.p;

import a.p.a;
import a.p.m;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public abstract class j0 extends m {
    private static final String[] P = {"android:visibility:visibility", "android:visibility:parent"};
    private int O = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ViewGroup f377a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f378b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f379c;

        a(ViewGroup viewGroup, View view, View view2) {
            this.f377a = viewGroup;
            this.f378b = view;
            this.f379c = view2;
        }

        @Override // a.p.n, a.p.m.f
        public void c(m mVar) {
            x.a(this.f377a).c(this.f378b);
        }

        @Override // a.p.n, a.p.m.f
        public void d(m mVar) {
            if (this.f378b.getParent() == null) {
                x.a(this.f377a).a(this.f378b);
            } else {
                j0.this.f();
            }
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            this.f379c.setTag(j.save_overlay_view, null);
            x.a(this.f377a).c(this.f378b);
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter implements m.f, a.InterfaceC0025a {

        /* renamed from: a  reason: collision with root package name */
        private final View f381a;

        /* renamed from: b  reason: collision with root package name */
        private final int f382b;

        /* renamed from: c  reason: collision with root package name */
        private final ViewGroup f383c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f384d;
        private boolean e;
        boolean f = false;

        b(View view, int i, boolean z) {
            this.f381a = view;
            this.f382b = i;
            this.f383c = (ViewGroup) view.getParent();
            this.f384d = z;
            g(true);
        }

        private void f() {
            if (!this.f) {
                c0.h(this.f381a, this.f382b);
                ViewGroup viewGroup = this.f383c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        private void g(boolean z) {
            ViewGroup viewGroup;
            if (!this.f384d || this.e == z || (viewGroup = this.f383c) == null) {
                return;
            }
            this.e = z;
            x.c(viewGroup, z);
        }

        @Override // a.p.m.f
        public void a(m mVar) {
        }

        @Override // a.p.m.f
        public void b(m mVar) {
        }

        @Override // a.p.m.f
        public void c(m mVar) {
            g(false);
        }

        @Override // a.p.m.f
        public void d(m mVar) {
            g(true);
        }

        @Override // a.p.m.f
        public void e(m mVar) {
            f();
            mVar.P(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.p.a.InterfaceC0025a
        public void onAnimationPause(Animator animator) {
            if (this.f) {
                return;
            }
            c0.h(this.f381a, this.f382b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, a.p.a.InterfaceC0025a
        public void onAnimationResume(Animator animator) {
            if (this.f) {
                return;
            }
            c0.h(this.f381a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        boolean f385a;

        /* renamed from: b  reason: collision with root package name */
        boolean f386b;

        /* renamed from: c  reason: collision with root package name */
        int f387c;

        /* renamed from: d  reason: collision with root package name */
        int f388d;
        ViewGroup e;
        ViewGroup f;

        c() {
        }
    }

    private void c0(s sVar) {
        sVar.f411a.put("android:visibility:visibility", Integer.valueOf(sVar.f412b.getVisibility()));
        sVar.f411a.put("android:visibility:parent", sVar.f412b.getParent());
        int[] iArr = new int[2];
        sVar.f412b.getLocationOnScreen(iArr);
        sVar.f411a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        if (r9 == 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r0.e == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
        if (r0.f387c == 0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private a.p.j0.c d0(a.p.s r8, a.p.s r9) {
        /*
            r7 = this;
            a.p.j0$c r0 = new a.p.j0$c
            r0.<init>()
            r1 = 0
            r0.f385a = r1
            r0.f386b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f411a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f411a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f387c = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f411a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.e = r6
            goto L37
        L33:
            r0.f387c = r4
            r0.e = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f411a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f411a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.f388d = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f411a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f = r2
            goto L5e
        L5a:
            r0.f388d = r4
            r0.f = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L86
            if (r9 == 0) goto L86
            int r8 = r0.f387c
            int r9 = r0.f388d
            if (r8 != r9) goto L70
            android.view.ViewGroup r8 = r0.e
            android.view.ViewGroup r9 = r0.f
            if (r8 != r9) goto L70
            return r0
        L70:
            int r8 = r0.f387c
            int r9 = r0.f388d
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L79
            goto L97
        L79:
            if (r9 != 0) goto L9a
            goto L8c
        L7c:
            android.view.ViewGroup r8 = r0.f
            if (r8 != 0) goto L81
            goto L97
        L81:
            android.view.ViewGroup r8 = r0.e
            if (r8 != 0) goto L9a
            goto L8c
        L86:
            if (r8 != 0) goto L91
            int r8 = r0.f388d
            if (r8 != 0) goto L91
        L8c:
            r0.f386b = r2
        L8e:
            r0.f385a = r2
            goto L9a
        L91:
            if (r9 != 0) goto L9a
            int r8 = r0.f387c
            if (r8 != 0) goto L9a
        L97:
            r0.f386b = r1
            goto L8e
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.j0.d0(a.p.s, a.p.s):a.p.j0$c");
    }

    @Override // a.p.m
    public String[] D() {
        return P;
    }

    @Override // a.p.m
    public boolean F(s sVar, s sVar2) {
        if (sVar == null && sVar2 == null) {
            return false;
        }
        if (sVar == null || sVar2 == null || sVar2.f411a.containsKey("android:visibility:visibility") == sVar.f411a.containsKey("android:visibility:visibility")) {
            c d0 = d0(sVar, sVar2);
            if (d0.f385a) {
                return d0.f387c == 0 || d0.f388d == 0;
            }
            return false;
        }
        return false;
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    public Animator f0(ViewGroup viewGroup, s sVar, int i, s sVar2, int i2) {
        if ((this.O & 1) != 1 || sVar2 == null) {
            return null;
        }
        if (sVar == null) {
            View view = (View) sVar2.f412b.getParent();
            if (d0(t(view, false), E(view, false)).f385a) {
                return null;
            }
        }
        return e0(viewGroup, sVar2.f412b, sVar, sVar2);
    }

    @Override // a.p.m
    public void g(s sVar) {
        c0(sVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2);

    /* JADX WARN: Code restructure failed: missing block: B:42:0x007f, code lost:
        if (r10.A != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator h0(android.view.ViewGroup r11, a.p.s r12, int r13, a.p.s r14, int r15) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.p.j0.h0(android.view.ViewGroup, a.p.s, int, a.p.s, int):android.animation.Animator");
    }

    public void i0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.O = i;
    }

    @Override // a.p.m
    public void j(s sVar) {
        c0(sVar);
    }

    @Override // a.p.m
    public Animator n(ViewGroup viewGroup, s sVar, s sVar2) {
        c d0 = d0(sVar, sVar2);
        if (d0.f385a) {
            if (d0.e == null && d0.f == null) {
                return null;
            }
            return d0.f386b ? f0(viewGroup, sVar, d0.f387c, sVar2, d0.f388d) : h0(viewGroup, sVar, d0.f387c, sVar2, d0.f388d);
        }
        return null;
    }
}
