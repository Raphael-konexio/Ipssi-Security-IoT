package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import c.a.c.a.k;
import c.a.c.a.l;
import c.a.c.a.n;
import c.a.c.a.o;
import io.flutter.embedding.engine.h.a;
import io.flutter.embedding.engine.h.c.c;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements io.flutter.embedding.engine.h.b, io.flutter.embedding.engine.h.c.b {

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.a f2470b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f2471c;
    @Deprecated
    private Activity e;
    private io.flutter.embedding.android.d<Activity> f;
    private C0115c g;
    private Service j;
    private f k;
    private BroadcastReceiver m;
    private d n;
    private ContentProvider p;
    private e q;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.a> f2469a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.c.a> f2472d = new HashMap();
    private boolean h = false;
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.f.a> i = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.d.a> l = new HashMap();
    private final Map<Class<? extends io.flutter.embedding.engine.h.a>, io.flutter.embedding.engine.h.e.a> o = new HashMap();

    /* loaded from: classes.dex */
    private static class b implements a.InterfaceC0119a {
        private b(io.flutter.embedding.engine.g.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.embedding.engine.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0115c implements io.flutter.embedding.engine.h.c.c {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f2473a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<n> f2474b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<k> f2475c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private final Set<l> f2476d = new HashSet();
        private final Set<o> e = new HashSet();
        private final Set<c.a> f = new HashSet();

        public C0115c(Activity activity, androidx.lifecycle.e eVar) {
            this.f2473a = activity;
            new HiddenLifecycleReference(eVar);
        }

        @Override // io.flutter.embedding.engine.h.c.c
        public void a(k kVar) {
            this.f2475c.add(kVar);
        }

        @Override // io.flutter.embedding.engine.h.c.c
        public void b(l lVar) {
            this.f2476d.add(lVar);
        }

        @Override // io.flutter.embedding.engine.h.c.c
        public void c(n nVar) {
            this.f2474b.add(nVar);
        }

        @Override // io.flutter.embedding.engine.h.c.c
        public void d(o oVar) {
            this.e.add(oVar);
        }

        @Override // io.flutter.embedding.engine.h.c.c
        public Activity e() {
            return this.f2473a;
        }

        boolean f(int i, int i2, Intent intent) {
            boolean z;
            Iterator it = new HashSet(this.f2475c).iterator();
            while (true) {
                while (it.hasNext()) {
                    z = ((k) it.next()).a(i, i2, intent) || z;
                }
                return z;
            }
        }

        void g(Intent intent) {
            for (l lVar : this.f2476d) {
                lVar.c(intent);
            }
        }

        boolean h(int i, String[] strArr, int[] iArr) {
            boolean z;
            while (true) {
                for (n nVar : this.f2474b) {
                    z = nVar.b(i, strArr, iArr) || z;
                }
                return z;
            }
        }

        void i(Bundle bundle) {
            for (c.a aVar : this.f) {
                aVar.d(bundle);
            }
        }

        void j(Bundle bundle) {
            for (c.a aVar : this.f) {
                aVar.e(bundle);
            }
        }

        void k() {
            for (o oVar : this.e) {
                oVar.f();
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements io.flutter.embedding.engine.h.d.b {
    }

    /* loaded from: classes.dex */
    private static class e implements io.flutter.embedding.engine.h.e.b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f implements io.flutter.embedding.engine.h.f.b {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, io.flutter.embedding.engine.a aVar, io.flutter.embedding.engine.g.c cVar) {
        this.f2470b = aVar;
        this.f2471c = new a.b(context, aVar, aVar.h(), aVar.q(), aVar.o().H(), new b(cVar));
    }

    private void k(Activity activity, androidx.lifecycle.e eVar) {
        this.g = new C0115c(activity, eVar);
        this.f2470b.o().t(activity, this.f2470b.q(), this.f2470b.h());
        for (io.flutter.embedding.engine.h.c.a aVar : this.f2472d.values()) {
            if (this.h) {
                aVar.e(this.g);
            } else {
                aVar.b(this.g);
            }
        }
        this.h = false;
    }

    private Activity l() {
        io.flutter.embedding.android.d<Activity> dVar = this.f;
        return dVar != null ? dVar.g() : this.e;
    }

    private void n() {
        this.f2470b.o().B();
        this.f = null;
        this.e = null;
        this.g = null;
    }

    private void o() {
        if (t()) {
            i();
        } else if (w()) {
            r();
        } else if (u()) {
            p();
        } else if (v()) {
            q();
        }
    }

    private boolean t() {
        return (this.e == null && this.f == null) ? false : true;
    }

    private boolean u() {
        return this.m != null;
    }

    private boolean v() {
        return this.p != null;
    }

    private boolean w() {
        return this.j != null;
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public boolean a(int i, int i2, Intent intent) {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onActivityResult() to plugins.");
        if (t()) {
            return this.g.f(i, i2, intent);
        }
        c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public boolean b(int i, String[] strArr, int[] iArr) {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onRequestPermissionsResult() to plugins.");
        if (t()) {
            return this.g.h(i, strArr, iArr);
        }
        c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void c(Intent intent) {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onNewIntent() to plugins.");
        if (t()) {
            this.g.g(intent);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void d(Bundle bundle) {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onRestoreInstanceState() to plugins.");
        if (t()) {
            this.g.i(bundle);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void e(Bundle bundle) {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onSaveInstanceState() to plugins.");
        if (t()) {
            this.g.j(bundle);
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void f() {
        c.a.b.d("FlutterEngineCxnRegstry", "Forwarding onUserLeaveHint() to plugins.");
        if (t()) {
            this.g.k();
        } else {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
        }
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void g(io.flutter.embedding.android.d<Activity> dVar, androidx.lifecycle.e eVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("Attaching to an exclusive Activity: ");
        sb.append(dVar.g());
        if (t()) {
            str = " evicting previous activity " + l();
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(".");
        sb.append(this.h ? " This is after a config change." : "");
        c.a.b.d("FlutterEngineCxnRegstry", sb.toString());
        io.flutter.embedding.android.d<Activity> dVar2 = this.f;
        if (dVar2 != null) {
            dVar2.f();
        }
        o();
        if (this.e != null) {
            throw new AssertionError("Only activity or exclusiveActivity should be set");
        }
        this.f = dVar;
        k(dVar.g(), eVar);
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void h() {
        if (!t()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Detaching from an Activity for config changes: " + l());
        this.h = true;
        for (io.flutter.embedding.engine.h.c.a aVar : this.f2472d.values()) {
            aVar.i();
        }
        n();
    }

    @Override // io.flutter.embedding.engine.h.c.b
    public void i() {
        if (!t()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Detaching from an Activity: " + l());
        for (io.flutter.embedding.engine.h.c.a aVar : this.f2472d.values()) {
            aVar.d();
        }
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.flutter.embedding.engine.h.b
    public void j(io.flutter.embedding.engine.h.a aVar) {
        if (s(aVar.getClass())) {
            c.a.b.e("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f2470b + ").");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
        this.f2469a.put(aVar.getClass(), aVar);
        aVar.c(this.f2471c);
        if (aVar instanceof io.flutter.embedding.engine.h.c.a) {
            io.flutter.embedding.engine.h.c.a aVar2 = (io.flutter.embedding.engine.h.c.a) aVar;
            this.f2472d.put(aVar.getClass(), aVar2);
            if (t()) {
                aVar2.b(this.g);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.h.f.a) {
            io.flutter.embedding.engine.h.f.a aVar3 = (io.flutter.embedding.engine.h.f.a) aVar;
            this.i.put(aVar.getClass(), aVar3);
            if (w()) {
                aVar3.b(this.k);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.h.d.a) {
            io.flutter.embedding.engine.h.d.a aVar4 = (io.flutter.embedding.engine.h.d.a) aVar;
            this.l.put(aVar.getClass(), aVar4);
            if (u()) {
                aVar4.a(this.n);
            }
        }
        if (aVar instanceof io.flutter.embedding.engine.h.e.a) {
            io.flutter.embedding.engine.h.e.a aVar5 = (io.flutter.embedding.engine.h.e.a) aVar;
            this.o.put(aVar.getClass(), aVar5);
            if (v()) {
                aVar5.b(this.q);
            }
        }
    }

    public void m() {
        c.a.b.d("FlutterEngineCxnRegstry", "Destroying.");
        o();
        z();
    }

    public void p() {
        if (!u()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Detaching from BroadcastReceiver: " + this.m);
        for (io.flutter.embedding.engine.h.d.a aVar : this.l.values()) {
            aVar.b();
        }
    }

    public void q() {
        if (!v()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Detaching from ContentProvider: " + this.p);
        for (io.flutter.embedding.engine.h.e.a aVar : this.o.values()) {
            aVar.a();
        }
    }

    public void r() {
        if (!w()) {
            c.a.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        c.a.b.d("FlutterEngineCxnRegstry", "Detaching from a Service: " + this.j);
        for (io.flutter.embedding.engine.h.f.a aVar : this.i.values()) {
            aVar.a();
        }
        this.j = null;
        this.k = null;
    }

    public boolean s(Class<? extends io.flutter.embedding.engine.h.a> cls) {
        return this.f2469a.containsKey(cls);
    }

    public void x(Class<? extends io.flutter.embedding.engine.h.a> cls) {
        io.flutter.embedding.engine.h.a aVar = this.f2469a.get(cls);
        if (aVar != null) {
            c.a.b.d("FlutterEngineCxnRegstry", "Removing plugin: " + aVar);
            if (aVar instanceof io.flutter.embedding.engine.h.c.a) {
                if (t()) {
                    ((io.flutter.embedding.engine.h.c.a) aVar).d();
                }
                this.f2472d.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.f.a) {
                if (w()) {
                    ((io.flutter.embedding.engine.h.f.a) aVar).a();
                }
                this.i.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.d.a) {
                if (u()) {
                    ((io.flutter.embedding.engine.h.d.a) aVar).b();
                }
                this.l.remove(cls);
            }
            if (aVar instanceof io.flutter.embedding.engine.h.e.a) {
                if (v()) {
                    ((io.flutter.embedding.engine.h.e.a) aVar).a();
                }
                this.o.remove(cls);
            }
            aVar.f(this.f2471c);
            this.f2469a.remove(cls);
        }
    }

    public void y(Set<Class<? extends io.flutter.embedding.engine.h.a>> set) {
        for (Class<? extends io.flutter.embedding.engine.h.a> cls : set) {
            x(cls);
        }
    }

    public void z() {
        y(new HashSet(this.f2469a.keySet()));
        this.f2469a.clear();
    }
}
