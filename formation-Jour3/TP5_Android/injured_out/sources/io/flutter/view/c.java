package io.flutter.view;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.embedding.engine.i.b;
import io.flutter.view.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class c extends AccessibilityNodeProvider {
    private static int y = 267386881;

    /* renamed from: a  reason: collision with root package name */
    private final View f2672a;

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.i.b f2673b;

    /* renamed from: c  reason: collision with root package name */
    private final AccessibilityManager f2674c;

    /* renamed from: d  reason: collision with root package name */
    private final AccessibilityViewEmbedder f2675d;
    private final io.flutter.plugin.platform.i e;
    private final ContentResolver f;
    private final Map<Integer, j> g;
    private final Map<Integer, g> h;
    private j i;
    private Integer j;
    private Integer k;
    private int l;
    private j m;
    private j n;
    private j o;
    private final List<Integer> p;
    private int q;
    private Integer r;
    private i s;
    private boolean t;
    private final b.InterfaceC0121b u;
    private final AccessibilityManager.AccessibilityStateChangeListener v;
    private final AccessibilityManager.TouchExplorationStateChangeListener w;
    private final ContentObserver x;

    /* loaded from: classes.dex */
    class a implements b.InterfaceC0121b {
        a() {
        }

        @Override // io.flutter.embedding.engine.i.b.InterfaceC0121b
        public void a(String str) {
            c.this.f2672a.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            c.this.M(byteBuffer, strArr);
        }

        @Override // io.flutter.embedding.engine.i.b.InterfaceC0121b
        public void c(String str) {
            AccessibilityEvent A = c.this.A(0, 32);
            A.getText().add(str);
            c.this.G(A);
        }

        @Override // io.flutter.embedding.engine.i.b.InterfaceC0121b
        public void d(int i) {
            c.this.F(i, 2);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void e(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            c.this.N(byteBuffer, strArr);
        }

        @Override // io.flutter.embedding.engine.i.b.InterfaceC0121b
        public void f(int i) {
            c.this.F(i, 1);
        }
    }

    /* loaded from: classes.dex */
    class b implements AccessibilityManager.AccessibilityStateChangeListener {
        b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z) {
            if (c.this.t) {
                return;
            }
            io.flutter.embedding.engine.i.b bVar = c.this.f2673b;
            if (z) {
                bVar.g(c.this.u);
                c.this.f2673b.e();
            } else {
                bVar.g(null);
                c.this.f2673b.d();
            }
            if (c.this.s != null) {
                c.this.s.a(z, c.this.f2674c.isTouchExplorationEnabled());
            }
        }
    }

    /* renamed from: io.flutter.view.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0130c extends ContentObserver {
        C0130c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            onChange(z, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            c cVar;
            int i;
            if (c.this.t) {
                return;
            }
            String string = Build.VERSION.SDK_INT < 17 ? null : Settings.Global.getString(c.this.f, "transition_animation_scale");
            if (string != null && string.equals("0")) {
                cVar = c.this;
                i = cVar.l | e.DISABLE_ANIMATIONS.f;
            } else {
                cVar = c.this;
                i = cVar.l & (~e.DISABLE_ANIMATIONS.f);
            }
            cVar.l = i;
            c.this.H();
        }
    }

    /* loaded from: classes.dex */
    class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccessibilityManager f2679a;

        d(AccessibilityManager accessibilityManager) {
            this.f2679a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            int i;
            if (c.this.t) {
                return;
            }
            c cVar = c.this;
            if (z) {
                i = cVar.l | e.ACCESSIBLE_NAVIGATION.f;
            } else {
                cVar.C();
                cVar = c.this;
                i = cVar.l & (~e.ACCESSIBLE_NAVIGATION.f);
            }
            cVar.l = i;
            c.this.H();
            if (c.this.s != null) {
                c.this.s.a(this.f2679a.isEnabled(), z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum e {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4);
        
        final int f;

        e(int i) {
            this.f = i;
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576);
        
        public final int f;

        f(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        private int f2681a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f2682b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f2683c = -1;

        /* renamed from: d  reason: collision with root package name */
        private String f2684d;
        private String e;

        g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum h {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304);
        
        final int f;

        h(int i) {
            this.f = i;
        }
    }

    /* loaded from: classes.dex */
    public interface i {
        void a(boolean z, boolean z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {
        private String A;
        private float B;
        private float C;
        private float D;
        private float E;
        private float[] F;
        private j G;
        private List<g> J;
        private g K;
        private g L;
        private float[] N;
        private float[] P;
        private Rect Q;

        /* renamed from: a  reason: collision with root package name */
        final c f2685a;

        /* renamed from: c  reason: collision with root package name */
        private int f2687c;

        /* renamed from: d  reason: collision with root package name */
        private int f2688d;
        private int e;
        private int f;
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private float l;
        private float m;
        private float n;
        private String o;
        private String p;
        private String q;
        private String r;
        private String s;
        private int u;
        private int v;
        private int w;
        private int x;
        private float y;
        private String z;

        /* renamed from: b  reason: collision with root package name */
        private int f2686b = -1;
        private boolean t = false;
        private List<j> H = new ArrayList();
        private List<j> I = new ArrayList();
        private boolean M = true;
        private boolean O = true;

        j(c cVar) {
            this.f2685a = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void T(List<j> list) {
            if (e0(h.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (j jVar : this.H) {
                jVar.T(list);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean U() {
            String str;
            if (this.o == null && this.A == null) {
                return false;
            }
            String str2 = this.o;
            return str2 == null || (str = this.A) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean V() {
            return (Float.isNaN(this.l) || Float.isNaN(this.y) || this.y == this.l) ? false : true;
        }

        private void W() {
            if (this.M) {
                this.M = false;
                if (this.N == null) {
                    this.N = new float[16];
                }
                if (Matrix.invertM(this.N, 0, this.F, 0)) {
                    return;
                }
                Arrays.fill(this.N, 0.0f);
            }
        }

        private j X(c.a.d.b<j> bVar) {
            for (j jVar = this.G; jVar != null; jVar = jVar.G) {
                if (bVar.a(jVar)) {
                    return jVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect Y() {
            return this.Q;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String Z() {
            String str;
            if (!e0(h.NAMES_ROUTE) || (str = this.o) == null || str.isEmpty()) {
                for (j jVar : this.H) {
                    String Z = jVar.Z();
                    if (Z != null && !Z.isEmpty()) {
                        return Z;
                    }
                }
                return null;
            }
            return this.o;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String a0() {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {this.p, this.o, this.s};
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                if (str != null && str.length() > 0) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(str);
                }
            }
            if (sb.length() > 0) {
                return sb.toString();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b0(f fVar) {
            return (fVar.f & this.v) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c0(h hVar) {
            return (hVar.f & this.u) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d0(f fVar) {
            return (fVar.f & this.f2688d) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e0(h hVar) {
            return (hVar.f & this.f2687c) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public j f0(float[] fArr) {
            float f = fArr[3];
            float f2 = fArr[0] / f;
            float f3 = fArr[1] / f;
            if (f2 < this.B || f2 >= this.D || f3 < this.C || f3 >= this.E) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (j jVar : this.I) {
                if (!jVar.e0(h.IS_HIDDEN)) {
                    jVar.W();
                    Matrix.multiplyMV(fArr2, 0, jVar.N, 0, fArr, 0);
                    j f0 = jVar.f0(fArr2);
                    if (f0 != null) {
                        return f0;
                    }
                }
            }
            if (g0()) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g0() {
            String str;
            String str2;
            String str3;
            if (e0(h.SCOPES_ROUTE)) {
                return false;
            }
            if (e0(h.IS_FOCUSABLE)) {
                return true;
            }
            return (((~(((f.SCROLL_RIGHT.f | f.SCROLL_LEFT.f) | f.SCROLL_UP.f) | f.SCROLL_DOWN.f)) & this.f2688d) == 0 && this.f2687c == 0 && ((str = this.o) == null || str.isEmpty()) && (((str2 = this.p) == null || str2.isEmpty()) && ((str3 = this.s) == null || str3.isEmpty()))) ? false : true;
        }

        private float h0(float f, float f2, float f3, float f4) {
            return Math.max(f, Math.max(f2, Math.max(f3, f4)));
        }

        private float i0(float f, float f2, float f3, float f4) {
            return Math.min(f, Math.min(f2, Math.min(f3, f4)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean j0(j jVar, c.a.d.b<j> bVar) {
            return (jVar == null || jVar.X(bVar) == null) ? false : true;
        }

        private void k0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f = fArr[3];
            fArr[0] = fArr[0] / f;
            fArr[1] = fArr[1] / f;
            fArr[2] = fArr[2] / f;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(float[] fArr, Set<j> set, boolean z) {
            set.add(this);
            if (this.O) {
                z = true;
            }
            if (z) {
                if (this.P == null) {
                    this.P = new float[16];
                }
                Matrix.multiplyMM(this.P, 0, fArr, 0, this.F, 0);
                float[] fArr2 = {this.B, this.C, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                k0(fArr3, this.P, fArr2);
                fArr2[0] = this.D;
                fArr2[1] = this.C;
                k0(fArr4, this.P, fArr2);
                fArr2[0] = this.D;
                fArr2[1] = this.E;
                k0(fArr5, this.P, fArr2);
                fArr2[0] = this.B;
                fArr2[1] = this.E;
                k0(fArr6, this.P, fArr2);
                if (this.Q == null) {
                    this.Q = new Rect();
                }
                this.Q.set(Math.round(i0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(i0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(h0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(h0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.O = false;
            }
            for (j jVar : this.H) {
                jVar.l0(this.P, set, z);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(ByteBuffer byteBuffer, String[] strArr) {
            this.t = true;
            this.z = this.p;
            this.A = this.o;
            this.u = this.f2687c;
            this.v = this.f2688d;
            this.w = this.g;
            this.x = this.h;
            this.y = this.l;
            this.f2687c = byteBuffer.getInt();
            this.f2688d = byteBuffer.getInt();
            this.e = byteBuffer.getInt();
            this.f = byteBuffer.getInt();
            this.g = byteBuffer.getInt();
            this.h = byteBuffer.getInt();
            this.i = byteBuffer.getInt();
            this.j = byteBuffer.getInt();
            this.k = byteBuffer.getInt();
            this.l = byteBuffer.getFloat();
            this.m = byteBuffer.getFloat();
            this.n = byteBuffer.getFloat();
            int i = byteBuffer.getInt();
            this.o = i == -1 ? null : strArr[i];
            int i2 = byteBuffer.getInt();
            this.p = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            this.q = i3 == -1 ? null : strArr[i3];
            int i4 = byteBuffer.getInt();
            this.r = i4 == -1 ? null : strArr[i4];
            int i5 = byteBuffer.getInt();
            this.s = i5 == -1 ? null : strArr[i5];
            k.d(byteBuffer.getInt());
            this.B = byteBuffer.getFloat();
            this.C = byteBuffer.getFloat();
            this.D = byteBuffer.getFloat();
            this.E = byteBuffer.getFloat();
            if (this.F == null) {
                this.F = new float[16];
            }
            for (int i6 = 0; i6 < 16; i6++) {
                this.F[i6] = byteBuffer.getFloat();
            }
            this.M = true;
            this.O = true;
            int i7 = byteBuffer.getInt();
            this.H.clear();
            this.I.clear();
            for (int i8 = 0; i8 < i7; i8++) {
                j t = this.f2685a.t(byteBuffer.getInt());
                t.G = this;
                this.H.add(t);
            }
            for (int i9 = 0; i9 < i7; i9++) {
                j t2 = this.f2685a.t(byteBuffer.getInt());
                t2.G = this;
                this.I.add(t2);
            }
            int i10 = byteBuffer.getInt();
            if (i10 == 0) {
                this.J = null;
                return;
            }
            List<g> list = this.J;
            if (list == null) {
                this.J = new ArrayList(i10);
            } else {
                list.clear();
            }
            for (int i11 = 0; i11 < i10; i11++) {
                g s = this.f2685a.s(byteBuffer.getInt());
                if (s.f2683c == f.TAP.f) {
                    this.K = s;
                } else if (s.f2683c == f.LONG_PRESS.f) {
                    this.L = s;
                } else {
                    this.J.add(s);
                }
                this.J.add(s);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum k {
        UNKNOWN,
        LTR,
        RTL;

        public static k d(int i2) {
            return i2 != 1 ? i2 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public c(View view, io.flutter.embedding.engine.i.b bVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.i iVar) {
        this(view, bVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), iVar);
    }

    public c(View view, io.flutter.embedding.engine.i.b bVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.i iVar) {
        this.g = new HashMap();
        this.h = new HashMap();
        this.l = 0;
        this.p = new ArrayList();
        this.q = 0;
        this.r = 0;
        this.t = false;
        this.u = new a();
        this.v = new b();
        this.x = new C0130c(new Handler());
        this.f2672a = view;
        this.f2673b = bVar;
        this.f2674c = accessibilityManager;
        this.f = contentResolver;
        this.f2675d = accessibilityViewEmbedder;
        this.e = iVar;
        this.v.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        this.f2674c.addAccessibilityStateChangeListener(this.v);
        if (Build.VERSION.SDK_INT >= 19) {
            d dVar = new d(accessibilityManager);
            this.w = dVar;
            dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
            this.f2674c.addTouchExplorationStateChangeListener(this.w);
        } else {
            this.w = null;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.x.onChange(false);
            this.f.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.x);
        }
        if (iVar != null) {
            iVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent A(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        obtain.setPackageName(this.f2672a.getContext().getPackageName());
        obtain.setSource(this.f2672a, i2);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        j jVar = this.o;
        if (jVar != null) {
            F(jVar.f2686b, 256);
            this.o = null;
        }
    }

    private boolean D(j jVar, int i2, Bundle bundle, boolean z) {
        io.flutter.embedding.engine.i.b bVar;
        f fVar;
        int i3 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z2 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        if (i3 != 1) {
            if (i3 != 2) {
                return false;
            }
            if (z && jVar.d0(f.MOVE_CURSOR_FORWARD_BY_WORD)) {
                bVar = this.f2673b;
                fVar = f.MOVE_CURSOR_FORWARD_BY_WORD;
            } else if (z || !jVar.d0(f.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                return false;
            } else {
                bVar = this.f2673b;
                fVar = f.MOVE_CURSOR_BACKWARD_BY_WORD;
            }
        } else if (z && jVar.d0(f.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
            bVar = this.f2673b;
            fVar = f.MOVE_CURSOR_FORWARD_BY_CHARACTER;
        } else if (z || !jVar.d0(f.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
            return false;
        } else {
            bVar = this.f2673b;
            fVar = f.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
        }
        bVar.c(i2, fVar, Boolean.valueOf(z2));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(int i2, int i3) {
        if (this.f2674c.isEnabled()) {
            G(A(i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(AccessibilityEvent accessibilityEvent) {
        if (this.f2674c.isEnabled()) {
            this.f2672a.getParent().requestSendAccessibilityEvent(this.f2672a, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f2673b.f(this.l);
    }

    private void I(j jVar) {
        AccessibilityEvent A = A(jVar.f2686b, 32);
        String Z = jVar.Z();
        if (Z == null) {
            Z = " ";
        }
        A.getText().add(Z);
        G(A);
    }

    private void J(int i2) {
        AccessibilityEvent A = A(i2, 2048);
        if (Build.VERSION.SDK_INT >= 19) {
            A.setContentChangeTypes(1);
        }
        G(A);
    }

    private boolean L(final j jVar) {
        return jVar.j > 0 && (j.j0(this.i, new c.a.d.b() { // from class: io.flutter.view.a
            @Override // c.a.d.b
            public final boolean a(Object obj) {
                return c.y(c.j.this, (c.j) obj);
            }
        }) || !j.j0(this.i, new c.a.d.b() { // from class: io.flutter.view.b
            @Override // c.a.d.b
            public final boolean a(Object obj) {
                boolean e0;
                e0 = ((c.j) obj).e0(c.h.HAS_IMPLICIT_SCROLLING);
                return e0;
            }
        }));
    }

    private void O(j jVar) {
        Integer num;
        jVar.G = null;
        if (jVar.i != -1 && (num = this.j) != null && this.f2675d.platformViewOfNode(num.intValue()) == this.e.d(Integer.valueOf(jVar.i))) {
            F(this.j.intValue(), 65536);
            this.j = null;
        }
        j jVar2 = this.i;
        if (jVar2 == jVar) {
            F(jVar2.f2686b, 65536);
            this.i = null;
        }
        if (this.m == jVar) {
            this.m = null;
        }
        if (this.o == jVar) {
            this.o = null;
        }
    }

    private AccessibilityEvent q(int i2, String str, String str2) {
        AccessibilityEvent A = A(i2, 16);
        A.setBeforeText(str);
        A.getText().add(str2);
        int i3 = 0;
        while (i3 < str.length() && i3 < str2.length() && str.charAt(i3) == str2.charAt(i3)) {
            i3++;
        }
        if (i3 < str.length() || i3 < str2.length()) {
            A.setFromIndex(i3);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i3 && length2 >= i3 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            A.setRemovedCount((length - i3) + 1);
            A.setAddedCount((length2 - i3) + 1);
            return A;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public g s(int i2) {
        g gVar = this.h.get(Integer.valueOf(i2));
        if (gVar == null) {
            g gVar2 = new g();
            gVar2.f2682b = i2;
            gVar2.f2681a = y + i2;
            this.h.put(Integer.valueOf(i2), gVar2);
            return gVar2;
        }
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j t(int i2) {
        j jVar = this.g.get(Integer.valueOf(i2));
        if (jVar == null) {
            j jVar2 = new j(this);
            jVar2.f2686b = i2;
            this.g.put(Integer.valueOf(i2), jVar2);
            return jVar2;
        }
        return jVar;
    }

    private j u() {
        return this.g.get(0);
    }

    private void v(float f2, float f3) {
        j f0;
        if (this.g.isEmpty() || (f0 = u().f0(new float[]{f2, f3, 0.0f, 1.0f})) == this.o) {
            return;
        }
        if (f0 != null) {
            F(f0.f2686b, 128);
        }
        j jVar = this.o;
        if (jVar != null) {
            F(jVar.f2686b, 256);
        }
        this.o = f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean y(j jVar, j jVar2) {
        return jVar2 == jVar;
    }

    public boolean B(MotionEvent motionEvent) {
        if (this.f2674c.isTouchExplorationEnabled() && !this.g.isEmpty()) {
            j f0 = u().f0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f});
            if (f0 == null || f0.i == -1) {
                if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                    v(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() != 10) {
                    c.a.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                    return false;
                } else {
                    C();
                }
                return true;
            }
            return this.f2675d.onAccessibilityHoverEvent(f0.f2686b, motionEvent);
        }
        return false;
    }

    public void E() {
        this.t = true;
        io.flutter.plugin.platform.i iVar = this.e;
        if (iVar != null) {
            iVar.b();
        }
        K(null);
        this.f2674c.removeAccessibilityStateChangeListener(this.v);
        if (Build.VERSION.SDK_INT >= 19) {
            this.f2674c.removeTouchExplorationStateChangeListener(this.w);
        }
        this.f.unregisterContentObserver(this.x);
        this.f2673b.g(null);
    }

    public void K(i iVar) {
        this.s = iVar;
    }

    void M(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            g s = s(byteBuffer.getInt());
            s.f2683c = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            String str = null;
            s.f2684d = i2 == -1 ? null : strArr[i2];
            int i3 = byteBuffer.getInt();
            if (i3 != -1) {
                str = strArr[i3];
            }
            s.e = str;
        }
    }

    void N(ByteBuffer byteBuffer, String[] strArr) {
        j jVar;
        j jVar2;
        float f2;
        float f3;
        WindowInsets rootWindowInsets;
        Integer valueOf;
        ArrayList arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            j t = t(byteBuffer.getInt());
            t.m0(byteBuffer, strArr);
            if (!t.e0(h.IS_HIDDEN)) {
                if (t.e0(h.IS_FOCUSED)) {
                    this.m = t;
                }
                if (t.t) {
                    arrayList.add(t);
                }
            }
        }
        HashSet hashSet = new HashSet();
        j u = u();
        ArrayList<j> arrayList2 = new ArrayList();
        if (u != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            if (Build.VERSION.SDK_INT >= 23 && (rootWindowInsets = this.f2672a.getRootWindowInsets()) != null) {
                if (!this.r.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                    u.O = true;
                    u.M = true;
                }
                this.r = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                Matrix.translateM(fArr, 0, valueOf.intValue(), 0.0f, 0.0f);
            }
            u.l0(fArr, hashSet, false);
            u.T(arrayList2);
        }
        j jVar3 = null;
        for (j jVar4 : arrayList2) {
            if (!this.p.contains(Integer.valueOf(jVar4.f2686b))) {
                jVar3 = jVar4;
            }
        }
        if (jVar3 == null && arrayList2.size() > 0) {
            jVar3 = (j) arrayList2.get(arrayList2.size() - 1);
        }
        if (jVar3 != null && (jVar3.f2686b != this.q || arrayList2.size() != this.p.size())) {
            this.q = jVar3.f2686b;
            I(jVar3);
        }
        this.p.clear();
        for (j jVar5 : arrayList2) {
            this.p.add(Integer.valueOf(jVar5.f2686b));
        }
        Iterator<Map.Entry<Integer, j>> it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            j value = it.next().getValue();
            if (!hashSet.contains(value)) {
                O(value);
                it.remove();
            }
        }
        J(0);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            j jVar6 = (j) it2.next();
            if (jVar6.V()) {
                AccessibilityEvent A = A(jVar6.f2686b, 4096);
                float f4 = jVar6.l;
                float f5 = jVar6.m;
                if (Float.isInfinite(jVar6.m)) {
                    if (f4 > 70000.0f) {
                        f4 = 70000.0f;
                    }
                    f5 = 100000.0f;
                }
                if (Float.isInfinite(jVar6.n)) {
                    f2 = f5 + 100000.0f;
                    if (f4 < -70000.0f) {
                        f4 = -70000.0f;
                    }
                    f3 = f4 + 100000.0f;
                } else {
                    f2 = f5 - jVar6.n;
                    f3 = f4 - jVar6.n;
                }
                if (jVar6.b0(f.SCROLL_UP) || jVar6.b0(f.SCROLL_DOWN)) {
                    A.setScrollY((int) f3);
                    A.setMaxScrollY((int) f2);
                } else if (jVar6.b0(f.SCROLL_LEFT) || jVar6.b0(f.SCROLL_RIGHT)) {
                    A.setScrollX((int) f3);
                    A.setMaxScrollX((int) f2);
                }
                if (jVar6.j > 0) {
                    A.setItemCount(jVar6.j);
                    A.setFromIndex(jVar6.k);
                    int i2 = 0;
                    for (j jVar7 : jVar6.I) {
                        if (!jVar7.e0(h.IS_HIDDEN)) {
                            i2++;
                        }
                    }
                    A.setToIndex((jVar6.k + i2) - 1);
                }
                G(A);
            }
            if (jVar6.e0(h.IS_LIVE_REGION) && jVar6.U()) {
                J(jVar6.f2686b);
            }
            j jVar8 = this.i;
            if (jVar8 != null && jVar8.f2686b == jVar6.f2686b && !jVar6.c0(h.IS_SELECTED) && jVar6.e0(h.IS_SELECTED)) {
                AccessibilityEvent A2 = A(jVar6.f2686b, 4);
                A2.getText().add(jVar6.o);
                G(A2);
            }
            j jVar9 = this.m;
            if (jVar9 != null && jVar9.f2686b == jVar6.f2686b && ((jVar2 = this.n) == null || jVar2.f2686b != this.m.f2686b)) {
                this.n = this.m;
                G(A(jVar6.f2686b, 8));
            } else if (this.m == null) {
                this.n = null;
            }
            j jVar10 = this.m;
            if (jVar10 != null && jVar10.f2686b == jVar6.f2686b && jVar6.c0(h.IS_TEXT_FIELD) && jVar6.e0(h.IS_TEXT_FIELD) && ((jVar = this.i) == null || jVar.f2686b == this.m.f2686b)) {
                String str = jVar6.z != null ? jVar6.z : "";
                String str2 = jVar6.p != null ? jVar6.p : "";
                AccessibilityEvent q = q(jVar6.f2686b, str, str2);
                if (q != null) {
                    G(q);
                }
                if (jVar6.w != jVar6.g || jVar6.x != jVar6.h) {
                    AccessibilityEvent A3 = A(jVar6.f2686b, 8192);
                    A3.getText().add(str2);
                    A3.setFromIndex(jVar6.g);
                    A3.setToIndex(jVar6.h);
                    A3.setItemCount(str2.length());
                    G(A3);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:215:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x040f A[LOOP:0: B:227:0x0409->B:229:0x040f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0434  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r13) {
        /*
            Method dump skipped, instructions count: 1142
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.c.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
        if (r2 != null) goto L11;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.c$j r2 = r1.m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.c.j.a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.c$j r2 = r1.i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.c.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i2, int i3, Bundle bundle) {
        io.flutter.embedding.engine.i.b bVar;
        f fVar;
        io.flutter.embedding.engine.i.b bVar2;
        f fVar2;
        int i4;
        if (i2 >= 65536) {
            boolean performAction = this.f2675d.performAction(i2, i3, bundle);
            if (performAction && i3 == 128) {
                this.j = null;
            }
            return performAction;
        }
        j jVar = this.g.get(Integer.valueOf(i2));
        boolean z = false;
        if (jVar == null) {
            return false;
        }
        switch (i3) {
            case 16:
                this.f2673b.b(i2, f.TAP);
                return true;
            case 32:
                this.f2673b.b(i2, f.LONG_PRESS);
                return true;
            case 64:
                this.f2673b.b(i2, f.DID_GAIN_ACCESSIBILITY_FOCUS);
                F(i2, 32768);
                if (this.i == null) {
                    this.f2672a.invalidate();
                }
                this.i = jVar;
                if (jVar.d0(f.INCREASE) || jVar.d0(f.DECREASE)) {
                    F(i2, 4);
                }
                return true;
            case 128:
                this.f2673b.b(i2, f.DID_LOSE_ACCESSIBILITY_FOCUS);
                F(i2, 65536);
                this.i = null;
                this.j = null;
                return true;
            case 256:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return D(jVar, i2, bundle, true);
            case 512:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                return D(jVar, i2, bundle, false);
            case 4096:
                if (jVar.d0(f.SCROLL_UP)) {
                    bVar = this.f2673b;
                    fVar = f.SCROLL_UP;
                } else if (jVar.d0(f.SCROLL_LEFT)) {
                    bVar = this.f2673b;
                    fVar = f.SCROLL_LEFT;
                } else if (!jVar.d0(f.INCREASE)) {
                    return false;
                } else {
                    jVar.p = jVar.q;
                    F(i2, 4);
                    bVar = this.f2673b;
                    fVar = f.INCREASE;
                }
                bVar.b(i2, fVar);
                return true;
            case 8192:
                if (jVar.d0(f.SCROLL_DOWN)) {
                    bVar2 = this.f2673b;
                    fVar2 = f.SCROLL_DOWN;
                } else if (jVar.d0(f.SCROLL_RIGHT)) {
                    bVar2 = this.f2673b;
                    fVar2 = f.SCROLL_RIGHT;
                } else if (!jVar.d0(f.DECREASE)) {
                    return false;
                } else {
                    jVar.p = jVar.r;
                    F(i2, 4);
                    bVar2 = this.f2673b;
                    fVar2 = f.DECREASE;
                }
                bVar2.b(i2, fVar2);
                return true;
            case 16384:
                this.f2673b.b(i2, f.COPY);
                return true;
            case 32768:
                this.f2673b.b(i2, f.PASTE);
                return true;
            case 65536:
                this.f2673b.b(i2, f.CUT);
                return true;
            case 131072:
                if (Build.VERSION.SDK_INT < 18) {
                    return false;
                }
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z = true;
                }
                if (z) {
                    hashMap.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i4 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap.put("base", Integer.valueOf(jVar.h));
                    i4 = jVar.h;
                }
                hashMap.put("extent", Integer.valueOf(i4));
                this.f2673b.c(i2, f.SET_SELECTION, hashMap);
                return true;
            case 1048576:
                this.f2673b.b(i2, f.DISMISS);
                return true;
            case 16908342:
                this.f2673b.b(i2, f.SHOW_ON_SCREEN);
                return true;
            default:
                g gVar = this.h.get(Integer.valueOf(i3 - y));
                if (gVar != null) {
                    this.f2673b.c(i2, f.CUSTOM_ACTION, Integer.valueOf(gVar.f2682b));
                    return true;
                }
                return false;
        }
    }

    public boolean r(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.f2675d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.f2675d.getRecordFlutterId(view, accessibilityEvent)) != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType == 8) {
                this.k = recordFlutterId;
                this.m = null;
                return true;
            } else if (eventType == 128) {
                this.o = null;
                return true;
            } else if (eventType == 32768) {
                this.j = recordFlutterId;
                this.i = null;
                return true;
            } else if (eventType != 65536) {
                return true;
            } else {
                this.k = null;
                this.j = null;
                return true;
            }
        }
        return false;
    }

    public boolean w() {
        return this.f2674c.isEnabled();
    }

    public boolean x() {
        return this.f2674c.isTouchExplorationEnabled();
    }
}
