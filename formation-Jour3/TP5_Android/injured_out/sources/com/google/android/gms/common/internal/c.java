package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.m;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class c<T extends IInterface> {
    private static final b.c.a.a.b.c[] u = new b.c.a.a.b.c[0];

    /* renamed from: a  reason: collision with root package name */
    private i0 f1592a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f1593b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.internal.i f1594c;

    /* renamed from: d  reason: collision with root package name */
    final Handler f1595d;
    private o g;
    protected InterfaceC0078c h;
    private T i;
    private j k;
    private final a m;
    private final b n;
    private final int o;
    private final String p;
    private final Object e = new Object();
    private final Object f = new Object();
    private final ArrayList<h<?>> j = new ArrayList<>();
    private int l = 1;
    private b.c.a.a.b.a q = null;
    private boolean r = false;
    private volatile c0 s = null;
    protected AtomicInteger t = new AtomicInteger(0);

    /* loaded from: classes.dex */
    public interface a {
        void d(int i);

        void h(Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface b {
        void g(b.c.a.a.b.a aVar);
    }

    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078c {
        void a(b.c.a.a.b.a aVar);
    }

    /* loaded from: classes.dex */
    protected class d implements InterfaceC0078c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0078c
        public void a(b.c.a.a.b.a aVar) {
            if (aVar.k()) {
                c cVar = c.this;
                cVar.g(null, cVar.B());
            } else if (c.this.n != null) {
                c.this.n.g(aVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes.dex */
    private abstract class f extends h<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        private final int f1597d;
        private final Bundle e;

        protected f(int i, Bundle bundle) {
            super(Boolean.TRUE);
            this.f1597d = i;
            this.e = bundle;
        }

        @Override // com.google.android.gms.common.internal.c.h
        protected final /* synthetic */ void c(Boolean bool) {
            if (bool == null) {
                c.this.P(1, null);
                return;
            }
            int i = this.f1597d;
            if (i == 0) {
                if (g()) {
                    return;
                }
                c.this.P(1, null);
                f(new b.c.a.a.b.a(8, null));
            } else if (i == 10) {
                c.this.P(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), c.this.r(), c.this.f()));
            } else {
                c.this.P(1, null);
                Bundle bundle = this.e;
                f(new b.c.a.a.b.a(this.f1597d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            }
        }

        @Override // com.google.android.gms.common.internal.c.h
        protected final void d() {
        }

        protected abstract void f(b.c.a.a.b.a aVar);

        protected abstract boolean g();
    }

    /* loaded from: classes.dex */
    final class g extends b.c.a.a.d.b.d {
        public g(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            h hVar = (h) message.obj;
            hVar.d();
            hVar.b();
        }

        private static boolean b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (c.this.t.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !c.this.u()) || message.what == 5)) && !c.this.l()) {
                a(message);
                return;
            }
            int i2 = message.what;
            if (i2 == 4) {
                c.this.q = new b.c.a.a.b.a(message.arg2);
                if (c.this.f0() && !c.this.r) {
                    c.this.P(3, null);
                    return;
                }
                b.c.a.a.b.a aVar = c.this.q != null ? c.this.q : new b.c.a.a.b.a(8);
                c.this.h.a(aVar);
                c.this.F(aVar);
            } else if (i2 == 5) {
                b.c.a.a.b.a aVar2 = c.this.q != null ? c.this.q : new b.c.a.a.b.a(8);
                c.this.h.a(aVar2);
                c.this.F(aVar2);
            } else if (i2 == 3) {
                Object obj = message.obj;
                b.c.a.a.b.a aVar3 = new b.c.a.a.b.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                c.this.h.a(aVar3);
                c.this.F(aVar3);
            } else if (i2 == 6) {
                c.this.P(5, null);
                if (c.this.m != null) {
                    c.this.m.d(message.arg2);
                }
                c.this.G(message.arg2);
                c.this.U(5, 1, null);
            } else if (i2 == 2 && !c.this.d()) {
                a(message);
            } else if (b(message)) {
                ((h) message.obj).e();
            } else {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i3);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public abstract class h<TListener> {

        /* renamed from: a  reason: collision with root package name */
        private TListener f1599a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1600b = false;

        public h(TListener tlistener) {
            this.f1599a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.f1599a = null;
            }
        }

        public final void b() {
            a();
            synchronized (c.this.j) {
                c.this.j.remove(this);
            }
        }

        protected abstract void c(TListener tlistener);

        protected abstract void d();

        public final void e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f1599a;
                if (this.f1600b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    c(tlistener);
                } catch (RuntimeException e) {
                    d();
                    throw e;
                }
            } else {
                d();
            }
            synchronized (this) {
                this.f1600b = true;
            }
            b();
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends m.a {

        /* renamed from: a  reason: collision with root package name */
        private c f1602a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1603b;

        public i(c cVar, int i) {
            this.f1602a = cVar;
            this.f1603b = i;
        }

        @Override // com.google.android.gms.common.internal.m
        public final void N(int i, IBinder iBinder, c0 c0Var) {
            r.i(this.f1602a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            r.h(c0Var);
            this.f1602a.T(c0Var);
            X(i, iBinder, c0Var.f);
        }

        @Override // com.google.android.gms.common.internal.m
        public final void Q(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.m
        public final void X(int i, IBinder iBinder, Bundle bundle) {
            r.i(this.f1602a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1602a.H(i, iBinder, bundle, this.f1603b);
            this.f1602a = null;
        }
    }

    /* loaded from: classes.dex */
    public final class j implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final int f1604a;

        public j(int i) {
            this.f1604a = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            o nVar;
            c cVar = c.this;
            if (iBinder == null) {
                cVar.W(16);
                return;
            }
            synchronized (cVar.f) {
                c cVar2 = c.this;
                if (iBinder == null) {
                    nVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    nVar = (queryLocalInterface == null || !(queryLocalInterface instanceof o)) ? new n(iBinder) : (o) queryLocalInterface;
                }
                cVar2.g = nVar;
            }
            c.this.O(0, null, this.f1604a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.f) {
                c.this.g = null;
            }
            Handler handler = c.this.f1595d;
            handler.sendMessage(handler.obtainMessage(6, this.f1604a, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class k extends f {
        private final IBinder g;

        public k(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(b.c.a.a.b.a aVar) {
            if (c.this.n != null) {
                c.this.n.g(aVar);
            }
            c.this.F(aVar);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            try {
                String interfaceDescriptor = this.g.getInterfaceDescriptor();
                if (!c.this.f().equals(interfaceDescriptor)) {
                    String f = c.this.f();
                    StringBuilder sb = new StringBuilder(String.valueOf(f).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(f);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface h = c.this.h(this.g);
                if (h == null || !(c.this.U(2, 4, h) || c.this.U(3, 4, h))) {
                    return false;
                }
                c.this.q = null;
                Bundle x = c.this.x();
                if (c.this.m != null) {
                    c.this.m.h(x);
                    return true;
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class l extends f {
        public l(int i, Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(b.c.a.a.b.a aVar) {
            if (c.this.u() && c.this.f0()) {
                c.this.W(16);
                return;
            }
            c.this.h.a(aVar);
            c.this.F(aVar);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            c.this.h.a(b.c.a.a.b.a.j);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, com.google.android.gms.common.internal.i iVar, b.c.a.a.b.e eVar, int i2, a aVar, b bVar, String str) {
        r.i(context, "Context must not be null");
        this.f1593b = context;
        r.i(looper, "Looper must not be null");
        r.i(iVar, "Supervisor must not be null");
        this.f1594c = iVar;
        r.i(eVar, "API availability must not be null");
        this.f1595d = new g(looper);
        this.o = i2;
        this.m = aVar;
        this.n = bVar;
        this.p = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(int i2, T t) {
        r.a((i2 == 4) == (t != null));
        synchronized (this.e) {
            this.l = i2;
            this.i = t;
            I(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.k != null && this.f1592a != null) {
                        String c2 = this.f1592a.c();
                        String a2 = this.f1592a.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f1594c.b(this.f1592a.c(), this.f1592a.a(), this.f1592a.b(), this.k, d0());
                        this.t.incrementAndGet();
                    }
                    this.k = new j(this.t.get());
                    i0 i0Var = (this.l != 3 || A() == null) ? new i0(D(), r(), false, 129) : new i0(y().getPackageName(), A(), true, 129);
                    this.f1592a = i0Var;
                    if (!this.f1594c.c(new i.a(i0Var.c(), this.f1592a.a(), this.f1592a.b()), this.k, d0())) {
                        String c3 = this.f1592a.c();
                        String a3 = this.f1592a.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        O(16, null, this.t.get());
                    }
                } else if (i2 == 4) {
                    E(t);
                }
            } else if (this.k != null) {
                this.f1594c.b(this.f1592a.c(), this.f1592a.a(), this.f1592a.b(), this.k, d0());
                this.k = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T(c0 c0Var) {
        this.s = c0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean U(int i2, int i3, T t) {
        synchronized (this.e) {
            if (this.l != i2) {
                return false;
            }
            P(i3, t);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void W(int i2) {
        int i3;
        if (e0()) {
            i3 = 5;
            this.r = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.f1595d;
        handler.sendMessage(handler.obtainMessage(i3, this.t.get(), 16));
    }

    private final String d0() {
        String str = this.p;
        return str == null ? this.f1593b.getClass().getName() : str;
    }

    private final boolean e0() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean f0() {
        if (this.r || TextUtils.isEmpty(f()) || TextUtils.isEmpty(A())) {
            return false;
        }
        try {
            Class.forName(f());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    protected String A() {
        return null;
    }

    protected abstract Set<Scope> B();

    public final T C() {
        T t;
        synchronized (this.e) {
            if (this.l == 5) {
                throw new DeadObjectException();
            }
            t();
            r.k(this.i != null, "Client is connected but service is null");
            t = this.i;
        }
        return t;
    }

    protected String D() {
        return "com.google.android.gms";
    }

    protected void E(T t) {
        System.currentTimeMillis();
    }

    protected void F(b.c.a.a.b.a aVar) {
        aVar.b();
        System.currentTimeMillis();
    }

    protected void G(int i2) {
        System.currentTimeMillis();
    }

    protected void H(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.f1595d;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new k(i2, iBinder, bundle)));
    }

    void I(int i2, T t) {
    }

    public boolean J() {
        return false;
    }

    public void K(int i2) {
        Handler handler = this.f1595d;
        handler.sendMessage(handler.obtainMessage(6, this.t.get(), i2));
    }

    protected final void O(int i2, Bundle bundle, int i3) {
        Handler handler = this.f1595d;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new l(i2, null)));
    }

    public void b(e eVar) {
        eVar.a();
    }

    public boolean d() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 4;
        }
        return z;
    }

    protected abstract String f();

    public void g(com.google.android.gms.common.internal.l lVar, Set<Scope> set) {
        Bundle z = z();
        com.google.android.gms.common.internal.g gVar = new com.google.android.gms.common.internal.g(this.o);
        gVar.i = this.f1593b.getPackageName();
        gVar.l = z;
        if (set != null) {
            gVar.k = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (q()) {
            gVar.m = v() != null ? v() : new Account("<<default account>>", "com.google");
            if (lVar != null) {
                gVar.j = lVar.asBinder();
            }
        } else if (J()) {
            gVar.m = v();
        }
        gVar.n = u;
        gVar.o = w();
        try {
            synchronized (this.f) {
                if (this.g != null) {
                    this.g.C(new i(this, this.t.get()), gVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            K(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            H(8, null, null, this.t.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            H(8, null, null, this.t.get());
        }
    }

    protected abstract T h(IBinder iBinder);

    public boolean j() {
        return true;
    }

    public int k() {
        return b.c.a.a.b.e.f1218a;
    }

    public boolean l() {
        boolean z;
        synchronized (this.e) {
            z = this.l == 2 || this.l == 3;
        }
        return z;
    }

    public final b.c.a.a.b.c[] m() {
        c0 c0Var = this.s;
        if (c0Var == null) {
            return null;
        }
        return c0Var.g;
    }

    public String n() {
        i0 i0Var;
        if (!d() || (i0Var = this.f1592a) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return i0Var.a();
    }

    public void o(InterfaceC0078c interfaceC0078c) {
        r.i(interfaceC0078c, "Connection progress callbacks cannot be null.");
        this.h = interfaceC0078c;
        P(2, null);
    }

    public void p() {
        this.t.incrementAndGet();
        synchronized (this.j) {
            int size = this.j.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.j.get(i2).a();
            }
            this.j.clear();
        }
        synchronized (this.f) {
            this.g = null;
        }
        P(1, null);
    }

    public boolean q() {
        return false;
    }

    protected abstract String r();

    protected final void t() {
        if (!d()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected boolean u() {
        return false;
    }

    public abstract Account v();

    public b.c.a.a.b.c[] w() {
        return u;
    }

    public Bundle x() {
        return null;
    }

    public final Context y() {
        return this.f1593b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle z() {
        return new Bundle();
    }
}
