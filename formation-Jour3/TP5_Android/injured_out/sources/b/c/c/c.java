package b.c.c;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.j;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.l;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class c {
    private static final Object i = new Object();
    private static final Executor j = new d();
    static final Map<String, c> k = new a.d.a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f1411a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1412b;

    /* renamed from: c  reason: collision with root package name */
    private final h f1413c;

    /* renamed from: d  reason: collision with root package name */
    private final l f1414d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicBoolean f = new AtomicBoolean();
    private final List<b> g = new CopyOnWriteArrayList();
    private final List<b.c.c.d> h = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b.c.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0066c implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<C0066c> f1415a = new AtomicReference<>();

        private C0066c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (com.google.android.gms.common.util.i.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f1415a.get() == null) {
                    C0066c c0066c = new C0066c();
                    if (f1415a.compareAndSet(null, c0066c)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(c0066c);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z) {
            synchronized (c.i) {
                Iterator it = new ArrayList(c.k.values()).iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.e.get()) {
                        cVar.w(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private static final Handler f1416a = new Handler(Looper.getMainLooper());

        private d() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            f1416a.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<e> f1417b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f1418a;

        public e(Context context) {
            this.f1418a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f1417b.get() == null) {
                e eVar = new e(context);
                if (f1417b.compareAndSet(null, eVar)) {
                    context.registerReceiver(eVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f1418a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (c.i) {
                for (c cVar : c.k.values()) {
                    cVar.p();
                }
            }
            c();
        }
    }

    protected c(Context context, String str, h hVar) {
        r.h(context);
        this.f1411a = context;
        r.f(str);
        this.f1412b = str;
        r.h(hVar);
        this.f1413c = hVar;
        List<com.google.firebase.components.h> a2 = com.google.firebase.components.f.b(context, ComponentDiscoveryService.class).a();
        String a3 = b.c.c.n.e.a();
        Executor executor = j;
        com.google.firebase.components.d[] dVarArr = new com.google.firebase.components.d[8];
        dVarArr[0] = com.google.firebase.components.d.n(context, Context.class, new Class[0]);
        dVarArr[1] = com.google.firebase.components.d.n(this, c.class, new Class[0]);
        dVarArr[2] = com.google.firebase.components.d.n(hVar, h.class, new Class[0]);
        dVarArr[3] = b.c.c.n.g.a("fire-android", "");
        dVarArr[4] = b.c.c.n.g.a("fire-core", "19.3.0");
        dVarArr[5] = a3 != null ? b.c.c.n.g.a("kotlin", a3) : null;
        dVarArr[6] = b.c.c.n.c.a();
        dVarArr[7] = b.c.c.k.b.a();
        this.f1414d = new l(executor, a2, dVarArr);
        b.c.c.b.a(this, context);
    }

    private void g() {
        r.k(!this.f.get(), "FirebaseApp was deleted");
    }

    private static List<String> i() {
        ArrayList arrayList = new ArrayList();
        synchronized (i) {
            for (c cVar : k.values()) {
                arrayList.add(cVar.m());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static c k() {
        c cVar;
        synchronized (i) {
            cVar = k.get("[DEFAULT]");
            if (cVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + j.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
        }
        return cVar;
    }

    public static c l(String str) {
        c cVar;
        List<String> i2;
        String str2;
        synchronized (i) {
            cVar = k.get(v(str));
            if (cVar == null) {
                if (i().isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", i2);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!a.g.g.d.a(this.f1411a)) {
            e.b(this.f1411a);
        } else {
            this.f1414d.e(t());
        }
    }

    public static c q(Context context) {
        synchronized (i) {
            if (k.containsKey("[DEFAULT]")) {
                return k();
            }
            h a2 = h.a(context);
            if (a2 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return r(context, a2);
        }
    }

    public static c r(Context context, h hVar) {
        return s(context, hVar, "[DEFAULT]");
    }

    public static c s(Context context, h hVar, String str) {
        c cVar;
        C0066c.c(context);
        String v = v(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (i) {
            boolean z = !k.containsKey(v);
            r.k(z, "FirebaseApp name " + v + " already exists!");
            r.i(context, "Application context cannot be null.");
            cVar = new c(context, v, hVar);
            k.put(v, cVar);
        }
        cVar.p();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ b.c.c.m.a u(c cVar, Context context) {
        return new b.c.c.m.a(context, cVar.o(), (b.c.c.j.c) cVar.f1414d.a(b.c.c.j.c.class));
    }

    private static String v(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (b bVar : this.g) {
            bVar.a(z);
        }
    }

    public void e(b bVar) {
        g();
        if (this.e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            bVar.a(true);
        }
        this.g.add(bVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f1412b.equals(((c) obj).m());
        }
        return false;
    }

    public void f(b.c.c.d dVar) {
        g();
        r.h(dVar);
        this.h.add(dVar);
    }

    public <T> T h(Class<T> cls) {
        g();
        return (T) this.f1414d.a(cls);
    }

    public int hashCode() {
        return this.f1412b.hashCode();
    }

    public Context j() {
        g();
        return this.f1411a;
    }

    public String m() {
        g();
        return this.f1412b;
    }

    public h n() {
        g();
        return this.f1413c;
    }

    public String o() {
        return com.google.android.gms.common.util.b.d(m().getBytes(Charset.defaultCharset())) + "+" + com.google.android.gms.common.util.b.d(n().c().getBytes(Charset.defaultCharset()));
    }

    public boolean t() {
        return "[DEFAULT]".equals(m());
    }

    public String toString() {
        q.a c2 = q.c(this);
        c2.a("name", this.f1412b);
        c2.a("options", this.f1413c);
        return c2.toString();
    }
}
