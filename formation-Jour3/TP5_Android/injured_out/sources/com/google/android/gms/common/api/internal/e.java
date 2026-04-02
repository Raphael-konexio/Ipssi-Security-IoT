package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class e implements Handler.Callback {
    public static final Status n = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status o = new Status(4, "The user must be signed in to make this API call.");
    private static final Object p = new Object();
    private static e q;

    /* renamed from: d  reason: collision with root package name */
    private final Context f1549d;
    private final b.c.a.a.b.d e;
    private final com.google.android.gms.common.internal.k f;
    private final Handler m;

    /* renamed from: a  reason: collision with root package name */
    private long f1546a = 5000;

    /* renamed from: b  reason: collision with root package name */
    private long f1547b = 120000;

    /* renamed from: c  reason: collision with root package name */
    private long f1548c = 10000;
    private final AtomicInteger g = new AtomicInteger(1);
    private final AtomicInteger h = new AtomicInteger(0);
    private final Map<com.google.android.gms.common.api.internal.b<?>, a<?>> i = new ConcurrentHashMap(5, 0.75f, 1);
    private p j = null;
    private final Set<com.google.android.gms.common.api.internal.b<?>> k = new a.d.b();
    private final Set<com.google.android.gms.common.api.internal.b<?>> l = new a.d.b();

    /* loaded from: classes.dex */
    public class a<O extends a.d> implements com.google.android.gms.common.api.f, com.google.android.gms.common.api.g {

        /* renamed from: b  reason: collision with root package name */
        private final a.f f1551b;

        /* renamed from: c  reason: collision with root package name */
        private final a.b f1552c;

        /* renamed from: d  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<O> f1553d;
        private final p0 e;
        private final int h;
        private final c0 i;
        private boolean j;

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a0> f1550a = new LinkedList();
        private final Set<m0> f = new HashSet();
        private final Map<h<?>, z> g = new HashMap();
        private final List<c> k = new ArrayList();
        private b.c.a.a.b.a l = null;

        public a(com.google.android.gms.common.api.e<O> eVar) {
            a.f g = eVar.g(e.this.m.getLooper(), this);
            this.f1551b = g;
            this.f1552c = g instanceof com.google.android.gms.common.internal.u ? ((com.google.android.gms.common.internal.u) g).k0() : g;
            this.f1553d = eVar.d();
            this.e = new p0();
            this.h = eVar.f();
            if (this.f1551b.q()) {
                this.i = eVar.h(e.this.f1549d, e.this.m);
            } else {
                this.i = null;
            }
        }

        private final void A() {
            if (this.j) {
                e.this.m.removeMessages(11, this.f1553d);
                e.this.m.removeMessages(9, this.f1553d);
                this.j = false;
            }
        }

        private final void B() {
            e.this.m.removeMessages(12, this.f1553d);
            e.this.m.sendMessageDelayed(e.this.m.obtainMessage(12, this.f1553d), e.this.f1548c);
        }

        private final void E(a0 a0Var) {
            a0Var.c(this.e, e());
            try {
                a0Var.f(this);
            } catch (DeadObjectException unused) {
                d(1);
                this.f1551b.p();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean F(boolean z) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            if (this.f1551b.d() && this.g.size() == 0) {
                if (!this.e.c()) {
                    this.f1551b.p();
                    return true;
                }
                if (z) {
                    B();
                }
                return false;
            }
            return false;
        }

        private final boolean K(b.c.a.a.b.a aVar) {
            synchronized (e.p) {
                if (e.this.j != null && e.this.k.contains(this.f1553d)) {
                    e.this.j.k(aVar, this.h);
                    throw null;
                }
            }
            return false;
        }

        private final void L(b.c.a.a.b.a aVar) {
            for (m0 m0Var : this.f) {
                String str = null;
                if (com.google.android.gms.common.internal.q.a(aVar, b.c.a.a.b.a.j)) {
                    str = this.f1551b.n();
                }
                m0Var.a(this.f1553d, aVar, str);
            }
            this.f.clear();
        }

        private final b.c.a.a.b.c i(b.c.a.a.b.c[] cVarArr) {
            if (cVarArr != null && cVarArr.length != 0) {
                b.c.a.a.b.c[] m = this.f1551b.m();
                if (m == null) {
                    m = new b.c.a.a.b.c[0];
                }
                a.d.a aVar = new a.d.a(m.length);
                for (b.c.a.a.b.c cVar : m) {
                    aVar.put(cVar.b(), Long.valueOf(cVar.c()));
                }
                for (b.c.a.a.b.c cVar2 : cVarArr) {
                    if (!aVar.containsKey(cVar2.b()) || ((Long) aVar.get(cVar2.b())).longValue() < cVar2.c()) {
                        return cVar2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(c cVar) {
            if (this.k.contains(cVar) && !this.j) {
                if (this.f1551b.d()) {
                    v();
                } else {
                    a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r(c cVar) {
            b.c.a.a.b.c[] g;
            if (this.k.remove(cVar)) {
                e.this.m.removeMessages(15, cVar);
                e.this.m.removeMessages(16, cVar);
                b.c.a.a.b.c cVar2 = cVar.f1559b;
                ArrayList arrayList = new ArrayList(this.f1550a.size());
                for (a0 a0Var : this.f1550a) {
                    if ((a0Var instanceof r) && (g = ((r) a0Var).g(this)) != null && com.google.android.gms.common.util.a.a(g, cVar2)) {
                        arrayList.add(a0Var);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    a0 a0Var2 = (a0) obj;
                    this.f1550a.remove(a0Var2);
                    a0Var2.d(new com.google.android.gms.common.api.m(cVar2));
                }
            }
        }

        private final boolean s(a0 a0Var) {
            if (!(a0Var instanceof r)) {
                E(a0Var);
                return true;
            }
            r rVar = (r) a0Var;
            b.c.a.a.b.c i = i(rVar.g(this));
            if (i == null) {
                E(a0Var);
                return true;
            } else if (!rVar.h(this)) {
                rVar.d(new com.google.android.gms.common.api.m(i));
                return false;
            } else {
                c cVar = new c(this.f1553d, i, null);
                int indexOf = this.k.indexOf(cVar);
                if (indexOf >= 0) {
                    c cVar2 = this.k.get(indexOf);
                    e.this.m.removeMessages(15, cVar2);
                    e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 15, cVar2), e.this.f1546a);
                    return false;
                }
                this.k.add(cVar);
                e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 15, cVar), e.this.f1546a);
                e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 16, cVar), e.this.f1547b);
                b.c.a.a.b.a aVar = new b.c.a.a.b.a(2, null);
                if (K(aVar)) {
                    return false;
                }
                e.this.l(aVar, this.h);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void t() {
            y();
            L(b.c.a.a.b.a.j);
            A();
            Iterator<z> it = this.g.values().iterator();
            while (it.hasNext()) {
                z next = it.next();
                if (i(next.f1590a.b()) == null) {
                    try {
                        next.f1590a.c(this.f1552c, new b.c.a.a.f.h<>());
                    } catch (DeadObjectException unused) {
                        d(1);
                        this.f1551b.p();
                    } catch (RemoteException unused2) {
                    }
                }
                it.remove();
            }
            v();
            B();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void u() {
            y();
            this.j = true;
            this.e.e();
            e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 9, this.f1553d), e.this.f1546a);
            e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 11, this.f1553d), e.this.f1547b);
            e.this.f.a();
        }

        private final void v() {
            ArrayList arrayList = new ArrayList(this.f1550a);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                a0 a0Var = (a0) obj;
                if (!this.f1551b.d()) {
                    return;
                }
                if (s(a0Var)) {
                    this.f1550a.remove(a0Var);
                }
            }
        }

        public final boolean C() {
            return F(true);
        }

        public final void D(Status status) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            for (a0 a0Var : this.f1550a) {
                a0Var.b(status);
            }
            this.f1550a.clear();
        }

        public final void J(b.c.a.a.b.a aVar) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            this.f1551b.p();
            g(aVar);
        }

        public final void a() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            if (this.f1551b.d() || this.f1551b.l()) {
                return;
            }
            int b2 = e.this.f.b(e.this.f1549d, this.f1551b);
            if (b2 != 0) {
                g(new b.c.a.a.b.a(b2, null));
                return;
            }
            b bVar = new b(this.f1551b, this.f1553d);
            if (this.f1551b.q()) {
                this.i.b0(bVar);
            }
            this.f1551b.o(bVar);
        }

        public final int b() {
            return this.h;
        }

        final boolean c() {
            return this.f1551b.d();
        }

        @Override // com.google.android.gms.common.api.internal.d
        public final void d(int i) {
            if (Looper.myLooper() == e.this.m.getLooper()) {
                u();
            } else {
                e.this.m.post(new u(this));
            }
        }

        public final boolean e() {
            return this.f1551b.q();
        }

        public final void f() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            if (this.j) {
                a();
            }
        }

        @Override // com.google.android.gms.common.api.internal.i
        public final void g(b.c.a.a.b.a aVar) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            c0 c0Var = this.i;
            if (c0Var != null) {
                c0Var.c0();
            }
            y();
            e.this.f.a();
            L(aVar);
            if (aVar.b() == 4) {
                D(e.o);
            } else if (this.f1550a.isEmpty()) {
                this.l = aVar;
            } else if (K(aVar) || e.this.l(aVar, this.h)) {
            } else {
                if (aVar.b() == 18) {
                    this.j = true;
                }
                if (this.j) {
                    e.this.m.sendMessageDelayed(Message.obtain(e.this.m, 9, this.f1553d), e.this.f1546a);
                    return;
                }
                String a2 = this.f1553d.a();
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 63 + String.valueOf(valueOf).length());
                sb.append("API: ");
                sb.append(a2);
                sb.append(" is not available on this device. Connection failed with: ");
                sb.append(valueOf);
                D(new Status(17, sb.toString()));
            }
        }

        @Override // com.google.android.gms.common.api.internal.d
        public final void h(Bundle bundle) {
            if (Looper.myLooper() == e.this.m.getLooper()) {
                t();
            } else {
                e.this.m.post(new t(this));
            }
        }

        public final void l(a0 a0Var) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            if (this.f1551b.d()) {
                if (s(a0Var)) {
                    B();
                    return;
                } else {
                    this.f1550a.add(a0Var);
                    return;
                }
            }
            this.f1550a.add(a0Var);
            b.c.a.a.b.a aVar = this.l;
            if (aVar == null || !aVar.j()) {
                a();
            } else {
                g(this.l);
            }
        }

        public final void m(m0 m0Var) {
            com.google.android.gms.common.internal.r.d(e.this.m);
            this.f.add(m0Var);
        }

        public final a.f o() {
            return this.f1551b;
        }

        public final void p() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            if (this.j) {
                A();
                D(e.this.e.f(e.this.f1549d) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f1551b.p();
            }
        }

        public final void w() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            D(e.n);
            this.e.d();
            for (h hVar : (h[]) this.g.keySet().toArray(new h[this.g.size()])) {
                l(new l0(hVar, new b.c.a.a.f.h()));
            }
            L(new b.c.a.a.b.a(4));
            if (this.f1551b.d()) {
                this.f1551b.b(new w(this));
            }
        }

        public final Map<h<?>, z> x() {
            return this.g;
        }

        public final void y() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            this.l = null;
        }

        public final b.c.a.a.b.a z() {
            com.google.android.gms.common.internal.r.d(e.this.m);
            return this.l;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b implements d0, c.InterfaceC0078c {

        /* renamed from: a  reason: collision with root package name */
        private final a.f f1554a;

        /* renamed from: b  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<?> f1555b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.android.gms.common.internal.l f1556c = null;

        /* renamed from: d  reason: collision with root package name */
        private Set<Scope> f1557d = null;
        private boolean e = false;

        public b(a.f fVar, com.google.android.gms.common.api.internal.b<?> bVar) {
            this.f1554a = fVar;
            this.f1555b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ boolean e(b bVar, boolean z) {
            bVar.e = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            com.google.android.gms.common.internal.l lVar;
            if (!this.e || (lVar = this.f1556c) == null) {
                return;
            }
            this.f1554a.g(lVar, this.f1557d);
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0078c
        public final void a(b.c.a.a.b.a aVar) {
            e.this.m.post(new x(this, aVar));
        }

        @Override // com.google.android.gms.common.api.internal.d0
        public final void b(b.c.a.a.b.a aVar) {
            ((a) e.this.i.get(this.f1555b)).J(aVar);
        }

        @Override // com.google.android.gms.common.api.internal.d0
        public final void c(com.google.android.gms.common.internal.l lVar, Set<Scope> set) {
            if (lVar == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                b(new b.c.a.a.b.a(4));
                return;
            }
            this.f1556c = lVar;
            this.f1557d = set;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.android.gms.common.api.internal.b<?> f1558a;

        /* renamed from: b  reason: collision with root package name */
        private final b.c.a.a.b.c f1559b;

        private c(com.google.android.gms.common.api.internal.b<?> bVar, b.c.a.a.b.c cVar) {
            this.f1558a = bVar;
            this.f1559b = cVar;
        }

        /* synthetic */ c(com.google.android.gms.common.api.internal.b bVar, b.c.a.a.b.c cVar, s sVar) {
            this(bVar, cVar);
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof c)) {
                c cVar = (c) obj;
                if (com.google.android.gms.common.internal.q.a(this.f1558a, cVar.f1558a) && com.google.android.gms.common.internal.q.a(this.f1559b, cVar.f1559b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return com.google.android.gms.common.internal.q.b(this.f1558a, this.f1559b);
        }

        public final String toString() {
            q.a c2 = com.google.android.gms.common.internal.q.c(this);
            c2.a("key", this.f1558a);
            c2.a("feature", this.f1559b);
            return c2.toString();
        }
    }

    private e(Context context, Looper looper, b.c.a.a.b.d dVar) {
        this.f1549d = context;
        this.m = new b.c.a.a.d.a.d(looper, this);
        this.e = dVar;
        this.f = new com.google.android.gms.common.internal.k(dVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6));
    }

    public static e f(Context context) {
        e eVar;
        synchronized (p) {
            if (q == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                q = new e(context.getApplicationContext(), handlerThread.getLooper(), b.c.a.a.b.d.l());
            }
            eVar = q;
        }
        return eVar;
    }

    private final void g(com.google.android.gms.common.api.e<?> eVar) {
        com.google.android.gms.common.api.internal.b<?> d2 = eVar.d();
        a<?> aVar = this.i.get(d2);
        if (aVar == null) {
            aVar = new a<>(eVar);
            this.i.put(d2, aVar);
        }
        if (aVar.e()) {
            this.l.add(d2);
        }
        aVar.a();
    }

    public final void b(b.c.a.a.b.a aVar, int i) {
        if (l(aVar, i)) {
            return;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(5, i, 0, aVar));
    }

    public final void c(com.google.android.gms.common.api.e<?> eVar) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, eVar));
    }

    public final <O extends a.d, ResultT> void d(com.google.android.gms.common.api.e<O> eVar, int i, m<a.b, ResultT> mVar, b.c.a.a.f.h<ResultT> hVar, l lVar) {
        k0 k0Var = new k0(i, mVar, hVar, lVar);
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(4, new y(k0Var, this.h.get(), eVar)));
    }

    public final int h() {
        return this.g.getAndIncrement();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a<?> aVar;
        b.c.a.a.f.h<Boolean> b2;
        Boolean valueOf;
        int i = message.what;
        switch (i) {
            case 1:
                this.f1548c = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.m.removeMessages(12);
                for (com.google.android.gms.common.api.internal.b<?> bVar : this.i.keySet()) {
                    Handler handler = this.m;
                    handler.sendMessageDelayed(handler.obtainMessage(12, bVar), this.f1548c);
                }
                break;
            case 2:
                m0 m0Var = (m0) message.obj;
                Iterator<com.google.android.gms.common.api.internal.b<?>> it = m0Var.b().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        com.google.android.gms.common.api.internal.b<?> next = it.next();
                        a<?> aVar2 = this.i.get(next);
                        if (aVar2 == null) {
                            m0Var.a(next, new b.c.a.a.b.a(13), null);
                            break;
                        } else if (aVar2.c()) {
                            m0Var.a(next, b.c.a.a.b.a.j, aVar2.o().n());
                        } else if (aVar2.z() != null) {
                            m0Var.a(next, aVar2.z(), null);
                        } else {
                            aVar2.m(m0Var);
                            aVar2.a();
                        }
                    }
                }
            case 3:
                for (a<?> aVar3 : this.i.values()) {
                    aVar3.y();
                    aVar3.a();
                }
                break;
            case 4:
            case 8:
            case 13:
                y yVar = (y) message.obj;
                a<?> aVar4 = this.i.get(yVar.f1589c.d());
                if (aVar4 == null) {
                    g(yVar.f1589c);
                    aVar4 = this.i.get(yVar.f1589c.d());
                }
                if (!aVar4.e() || this.h.get() == yVar.f1588b) {
                    aVar4.l(yVar.f1587a);
                    break;
                } else {
                    yVar.f1587a.b(n);
                    aVar4.w();
                    break;
                }
            case 5:
                int i2 = message.arg1;
                b.c.a.a.b.a aVar5 = (b.c.a.a.b.a) message.obj;
                Iterator<a<?>> it2 = this.i.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        a<?> next2 = it2.next();
                        aVar = next2.b() == i2 ? next2 : null;
                    }
                }
                if (aVar != null) {
                    String d2 = this.e.d(aVar5.b());
                    String c2 = aVar5.c();
                    StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 69 + String.valueOf(c2).length());
                    sb.append("Error resolution was canceled by the user, original error message: ");
                    sb.append(d2);
                    sb.append(": ");
                    sb.append(c2);
                    aVar.D(new Status(17, sb.toString()));
                    break;
                } else {
                    StringBuilder sb2 = new StringBuilder(76);
                    sb2.append("Could not find API instance ");
                    sb2.append(i2);
                    sb2.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                    break;
                }
            case 6:
                if (com.google.android.gms.common.util.i.a() && (this.f1549d.getApplicationContext() instanceof Application)) {
                    com.google.android.gms.common.api.internal.c.c((Application) this.f1549d.getApplicationContext());
                    com.google.android.gms.common.api.internal.c.b().a(new s(this));
                    if (!com.google.android.gms.common.api.internal.c.b().f(true)) {
                        this.f1548c = 300000L;
                        break;
                    }
                }
                break;
            case 7:
                g((com.google.android.gms.common.api.e) message.obj);
                break;
            case 9:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).f();
                    break;
                }
                break;
            case 10:
                for (com.google.android.gms.common.api.internal.b<?> bVar2 : this.l) {
                    this.i.remove(bVar2).w();
                }
                this.l.clear();
                break;
            case 11:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).p();
                    break;
                }
                break;
            case 12:
                if (this.i.containsKey(message.obj)) {
                    this.i.get(message.obj).C();
                    break;
                }
                break;
            case 14:
                q qVar = (q) message.obj;
                com.google.android.gms.common.api.internal.b<?> a2 = qVar.a();
                if (this.i.containsKey(a2)) {
                    boolean F = this.i.get(a2).F(false);
                    b2 = qVar.b();
                    valueOf = Boolean.valueOf(F);
                } else {
                    b2 = qVar.b();
                    valueOf = Boolean.FALSE;
                }
                b2.c(valueOf);
                break;
            case 15:
                c cVar = (c) message.obj;
                if (this.i.containsKey(cVar.f1558a)) {
                    this.i.get(cVar.f1558a).k(cVar);
                    break;
                }
                break;
            case 16:
                c cVar2 = (c) message.obj;
                if (this.i.containsKey(cVar2.f1558a)) {
                    this.i.get(cVar2.f1558a).r(cVar2);
                    break;
                }
                break;
            default:
                StringBuilder sb3 = new StringBuilder(31);
                sb3.append("Unknown message id: ");
                sb3.append(i);
                Log.w("GoogleApiManager", sb3.toString());
                return false;
        }
        return true;
    }

    final boolean l(b.c.a.a.b.a aVar, int i) {
        return this.e.s(this.f1549d, aVar, i);
    }

    public final void t() {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3));
    }
}
