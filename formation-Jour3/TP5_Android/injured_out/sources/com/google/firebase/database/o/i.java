package com.google.firebase.database.o;

import com.google.firebase.database.o.b;
import com.google.firebase.database.o.c;
import com.google.firebase.database.o.h;
import com.google.firebase.database.o.m.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class i implements b.a, com.google.firebase.database.o.h {
    private static long B;
    private boolean A;

    /* renamed from: a  reason: collision with root package name */
    private final h.a f2070a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.o.f f2071b;

    /* renamed from: c  reason: collision with root package name */
    private String f2072c;
    private long f;
    private com.google.firebase.database.o.b g;
    private String o;
    private boolean p;
    private final com.google.firebase.database.o.d q;
    private final com.google.firebase.database.o.c r;
    private final ScheduledExecutorService s;
    private final com.google.firebase.database.q.c t;
    private final com.google.firebase.database.o.m.a u;
    private String v;
    private long z;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<String> f2073d = new HashSet<>();
    private boolean e = true;
    private EnumC0098i h = EnumC0098i.Disconnected;
    private long i = 0;
    private long j = 0;
    private long w = 0;
    private int x = 0;
    private ScheduledFuture<?> y = null;
    private Map<j, l> n = new HashMap();
    private Map<Long, h> k = new HashMap();
    private Map<Long, m> m = new HashMap();
    private List<k> l = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        final /* synthetic */ boolean f;

        /* renamed from: com.google.firebase.database.o.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0097a implements c.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ long f2074a;

            C0097a(long j) {
                this.f2074a = j;
            }

            @Override // com.google.firebase.database.o.c.a
            public void a(String str) {
                if (this.f2074a != i.this.w) {
                    i.this.t.b("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
                } else if (i.this.h == EnumC0098i.GettingToken) {
                    i.this.t.b("Successfully fetched token, opening connection", new Object[0]);
                    i.this.Z(str);
                } else {
                    com.google.firebase.database.o.e.b(i.this.h == EnumC0098i.Disconnected, "Expected connection state disconnected, but was %s", i.this.h);
                    i.this.t.b("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                }
            }

            @Override // com.google.firebase.database.o.c.a
            public void b(String str) {
                if (this.f2074a != i.this.w) {
                    i.this.t.b("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
                    return;
                }
                i.this.h = EnumC0098i.Disconnected;
                com.google.firebase.database.q.c cVar = i.this.t;
                cVar.b("Error fetching token: " + str, new Object[0]);
                i.this.r0();
            }
        }

        a(boolean z) {
            this.f = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.t.b("Trying to fetch auth token", new Object[0]);
            com.google.firebase.database.o.e.b(i.this.h == EnumC0098i.Disconnected, "Not in disconnected state: %s", i.this.h);
            i.this.h = EnumC0098i.GettingToken;
            i.I(i.this);
            i.this.r.a(this.f, new C0097a(i.this.w));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.o.k f2076a;

        b(i iVar, com.google.firebase.database.o.k kVar) {
            this.f2076a = kVar;
        }

        @Override // com.google.firebase.database.o.i.h
        public void a(Map<String, Object> map) {
            String str = (String) map.get("s");
            String str2 = null;
            if (str.equals("ok")) {
                str = null;
            } else {
                str2 = (String) map.get("d");
            }
            com.google.firebase.database.o.k kVar = this.f2076a;
            if (kVar != null) {
                kVar.a(str, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f2077a;

        c(boolean z) {
            this.f2077a = z;
        }

        @Override // com.google.firebase.database.o.i.h
        public void a(Map<String, Object> map) {
            i.this.h = EnumC0098i.Connected;
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                i.this.x = 0;
                i.this.f2070a.b(true);
                if (this.f2077a) {
                    i.this.e0();
                    return;
                }
                return;
            }
            i.this.o = null;
            i.this.p = true;
            i.this.f2070a.b(false);
            com.google.firebase.database.q.c cVar = i.this.t;
            cVar.b("Authentication failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
            i.this.g.c();
            if (str.equals("invalid_token")) {
                i.q(i.this);
                if (i.this.x >= 3) {
                    i.this.u.d();
                    i.this.t.i("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2079a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f2080b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ m f2081c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.o.k f2082d;

        d(String str, long j, m mVar, com.google.firebase.database.o.k kVar) {
            this.f2079a = str;
            this.f2080b = j;
            this.f2081c = mVar;
            this.f2082d = kVar;
        }

        @Override // com.google.firebase.database.o.i.h
        public void a(Map<String, Object> map) {
            if (i.this.t.f()) {
                com.google.firebase.database.q.c cVar = i.this.t;
                cVar.b(this.f2079a + " response: " + map, new Object[0]);
            }
            if (((m) i.this.m.get(Long.valueOf(this.f2080b))) == this.f2081c) {
                i.this.m.remove(Long.valueOf(this.f2080b));
                if (this.f2082d != null) {
                    String str = (String) map.get("s");
                    if (str.equals("ok")) {
                        this.f2082d.a(null, null);
                    } else {
                        this.f2082d.a(str, (String) map.get("d"));
                    }
                }
            } else if (i.this.t.f()) {
                com.google.firebase.database.q.c cVar2 = i.this.t;
                cVar2.b("Ignoring on complete for put " + this.f2080b + " because it was removed already.", new Object[0]);
            }
            i.this.O();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f2083a;

        e(l lVar) {
            this.f2083a = lVar;
        }

        @Override // com.google.firebase.database.o.i.h
        public void a(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                Map map2 = (Map) map.get("d");
                if (map2.containsKey("w")) {
                    i.this.t0((List) map2.get("w"), this.f2083a.f2093b);
                }
            }
            if (((l) i.this.n.get(this.f2083a.d())) == this.f2083a) {
                if (str.equals("ok")) {
                    this.f2083a.f2092a.a(null, null);
                    return;
                }
                i.this.b0(this.f2083a.d());
                this.f2083a.f2092a.a(str, (String) map.get("d"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements h {
        f() {
        }

        @Override // com.google.firebase.database.o.i.h
        public void a(Map<String, Object> map) {
            String str = (String) map.get("s");
            if (str.equals("ok")) {
                return;
            }
            String str2 = (String) map.get("d");
            if (i.this.t.f()) {
                com.google.firebase.database.q.c cVar = i.this.t;
                cVar.b("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.y = null;
            if (i.this.R()) {
                i.this.i("connection_idle");
            } else {
                i.this.O();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface h {
        void a(Map<String, Object> map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.firebase.database.o.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0098i {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f2086a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, Object> f2087b;

        public j(List<String> list, Map<String, Object> map) {
            this.f2086a = list;
            this.f2087b = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof j) {
                j jVar = (j) obj;
                if (this.f2086a.equals(jVar.f2086a)) {
                    return this.f2087b.equals(jVar.f2087b);
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (this.f2086a.hashCode() * 31) + this.f2087b.hashCode();
        }

        public String toString() {
            return com.google.firebase.database.o.e.d(this.f2086a) + " (params: " + this.f2087b + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        private final String f2088a;

        /* renamed from: b  reason: collision with root package name */
        private final List<String> f2089b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f2090c;

        /* renamed from: d  reason: collision with root package name */
        private final com.google.firebase.database.o.k f2091d;

        public String a() {
            return this.f2088a;
        }

        public Object b() {
            return this.f2090c;
        }

        public com.google.firebase.database.o.k c() {
            return this.f2091d;
        }

        public List<String> d() {
            return this.f2089b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a  reason: collision with root package name */
        private final com.google.firebase.database.o.k f2092a;

        /* renamed from: b  reason: collision with root package name */
        private final j f2093b;

        /* renamed from: c  reason: collision with root package name */
        private final com.google.firebase.database.o.g f2094c;

        /* renamed from: d  reason: collision with root package name */
        private final Long f2095d;

        private l(com.google.firebase.database.o.k kVar, j jVar, Long l, com.google.firebase.database.o.g gVar) {
            this.f2092a = kVar;
            this.f2093b = jVar;
            this.f2094c = gVar;
            this.f2095d = l;
        }

        /* synthetic */ l(com.google.firebase.database.o.k kVar, j jVar, Long l, com.google.firebase.database.o.g gVar, a aVar) {
            this(kVar, jVar, l, gVar);
        }

        public com.google.firebase.database.o.g c() {
            return this.f2094c;
        }

        public j d() {
            return this.f2093b;
        }

        public Long e() {
            return this.f2095d;
        }

        public String toString() {
            return this.f2093b.toString() + " (Tag: " + this.f2095d + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class m {

        /* renamed from: a  reason: collision with root package name */
        private String f2096a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, Object> f2097b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.firebase.database.o.k f2098c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f2099d;

        private m(String str, Map<String, Object> map, com.google.firebase.database.o.k kVar) {
            this.f2096a = str;
            this.f2097b = map;
            this.f2098c = kVar;
        }

        /* synthetic */ m(String str, Map map, com.google.firebase.database.o.k kVar, a aVar) {
            this(str, map, kVar);
        }

        public String a() {
            return this.f2096a;
        }

        public com.google.firebase.database.o.k b() {
            return this.f2098c;
        }

        public Map<String, Object> c() {
            return this.f2097b;
        }

        public void d() {
            this.f2099d = true;
        }

        public boolean e() {
            return this.f2099d;
        }
    }

    public i(com.google.firebase.database.o.d dVar, com.google.firebase.database.o.f fVar, h.a aVar) {
        this.f2070a = aVar;
        this.q = dVar;
        this.s = dVar.c();
        this.r = dVar.a();
        this.f2071b = fVar;
        a.b bVar = new a.b(this.s, dVar.d(), "ConnectionRetryHelper");
        bVar.d(1000L);
        bVar.e(1.3d);
        bVar.c(30000L);
        bVar.b(0.7d);
        this.u = bVar.a();
        long j2 = B;
        B = 1 + j2;
        com.google.firebase.database.q.d d2 = dVar.d();
        this.t = new com.google.firebase.database.q.c(d2, "PersistentConnection", "pc_" + j2);
        this.v = null;
        O();
    }

    static /* synthetic */ long I(i iVar) {
        long j2 = iVar.w;
        iVar.w = 1 + j2;
        return j2;
    }

    private boolean L() {
        return this.h == EnumC0098i.Connected;
    }

    private void M() {
        ArrayList<m> arrayList = new ArrayList();
        Iterator<Map.Entry<Long, m>> it = this.m.entrySet().iterator();
        while (it.hasNext()) {
            m value = it.next().getValue();
            if (value.c().containsKey("h") && value.e()) {
                arrayList.add(value);
                it.remove();
            }
        }
        for (m mVar : arrayList) {
            mVar.b().a("disconnected", null);
        }
    }

    private boolean N() {
        EnumC0098i enumC0098i = this.h;
        return enumC0098i == EnumC0098i.Authenticating || enumC0098i == EnumC0098i.Connected;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        if (S()) {
            ScheduledFuture<?> scheduledFuture = this.y;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.y = this.s.schedule(new g(), 60000L, TimeUnit.MILLISECONDS);
        } else if (T("connection_idle")) {
            com.google.firebase.database.o.e.a(!S());
            m("connection_idle");
        }
    }

    private Map<String, Object> P(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", com.google.firebase.database.o.e.d(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put("h", str);
        }
        return hashMap;
    }

    private void Q(long j2) {
        if (this.t.f()) {
            this.t.b("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j2 - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(currentTimeMillis));
        this.f2070a.c(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean R() {
        return S() && System.currentTimeMillis() > this.z + 60000;
    }

    private boolean S() {
        return this.n.isEmpty() && this.k.isEmpty() && !this.A && this.m.isEmpty();
    }

    private long U() {
        long j2 = this.j;
        this.j = 1 + j2;
        return j2;
    }

    private void V(String str, String str2) {
        com.google.firebase.database.q.c cVar = this.t;
        cVar.b("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.o = null;
        this.p = true;
        this.f2070a.b(false);
        this.g.c();
    }

    private void W(String str, Map<String, Object> map) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long c2 = com.google.firebase.database.o.e.c(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.f2070a.d(com.google.firebase.database.o.e.e(str2), obj, equals, c2);
            } else if (this.t.f()) {
                com.google.firebase.database.q.c cVar2 = this.t;
                cVar2.b("ignoring empty merge for path " + str2, new Object[0]);
            }
        } else if (str.equals("rm")) {
            String str3 = (String) map.get("p");
            List<String> e2 = com.google.firebase.database.o.e.e(str3);
            Object obj2 = map.get("d");
            Long c3 = com.google.firebase.database.o.e.c(map.get("t"));
            ArrayList arrayList = new ArrayList();
            for (Map map2 : (List) obj2) {
                String str4 = (String) map2.get("s");
                String str5 = (String) map2.get("e");
                List<String> list = null;
                List<String> e3 = str4 != null ? com.google.firebase.database.o.e.e(str4) : null;
                if (str5 != null) {
                    list = com.google.firebase.database.o.e.e(str5);
                }
                arrayList.add(new com.google.firebase.database.o.j(e3, list, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.f2070a.f(e2, arrayList, c3);
            } else if (this.t.f()) {
                com.google.firebase.database.q.c cVar3 = this.t;
                cVar3.b("Ignoring empty range merge for path " + str3, new Object[0]);
            }
        } else if (str.equals("c")) {
            X(com.google.firebase.database.o.e.e((String) map.get("p")));
        } else if (str.equals("ac")) {
            V((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals("sd")) {
            Y(map);
        } else if (this.t.f()) {
            com.google.firebase.database.q.c cVar4 = this.t;
            cVar4.b("Unrecognized action from server: " + str, new Object[0]);
        }
    }

    private void X(List<String> list) {
        Collection<l> c0 = c0(list);
        if (c0 != null) {
            for (l lVar : c0) {
                lVar.f2092a.a("permission_denied", null);
            }
        }
    }

    private void Y(Map<String, Object> map) {
        this.t.e((String) map.get("msg"));
    }

    private void a0(String str, List<String> list, Object obj, String str2, com.google.firebase.database.o.k kVar) {
        Map<String, Object> P = P(list, obj, str2);
        long j2 = this.i;
        this.i = 1 + j2;
        this.m.put(Long.valueOf(j2), new m(str, P, kVar, null));
        if (L()) {
            l0(j2);
        }
        this.z = System.currentTimeMillis();
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l b0(j jVar) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("removing query " + jVar, new Object[0]);
        }
        if (this.n.containsKey(jVar)) {
            l lVar = this.n.get(jVar);
            this.n.remove(jVar);
            O();
            return lVar;
        } else if (this.t.f()) {
            com.google.firebase.database.q.c cVar2 = this.t;
            cVar2.b("Trying to remove listener for QuerySpec " + jVar + " but no listener exists.", new Object[0]);
            return null;
        } else {
            return null;
        }
    }

    private Collection<l> c0(List<String> list) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("removing all listens at path " + list, new Object[0]);
        }
        ArrayList<l> arrayList = new ArrayList();
        for (Map.Entry<j, l> entry : this.n.entrySet()) {
            l value = entry.getValue();
            if (entry.getKey().f2086a.equals(list)) {
                arrayList.add(value);
            }
        }
        for (l lVar : arrayList) {
            this.n.remove(lVar.d());
        }
        O();
        return arrayList;
    }

    private void d0() {
        if (this.t.f()) {
            this.t.b("calling restore state", new Object[0]);
        }
        com.google.firebase.database.o.e.b(this.h == EnumC0098i.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.h);
        if (this.o == null) {
            if (this.t.f()) {
                this.t.b("Not restoring auth because token is null.", new Object[0]);
            }
            this.h = EnumC0098i.Connected;
            e0();
            return;
        }
        if (this.t.f()) {
            this.t.b("Restoring auth.", new Object[0]);
        }
        this.h = EnumC0098i.Authenticating;
        g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        com.google.firebase.database.o.e.b(this.h == EnumC0098i.Connected, "Should be connected if we're restoring state, but we are: %s", this.h);
        if (this.t.f()) {
            this.t.b("Restoring outstanding listens", new Object[0]);
        }
        for (l lVar : this.n.values()) {
            if (this.t.f()) {
                com.google.firebase.database.q.c cVar = this.t;
                cVar.b("Restoring listen " + lVar.d(), new Object[0]);
            }
            j0(lVar);
        }
        if (this.t.f()) {
            this.t.b("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.m.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l0(((Long) it.next()).longValue());
        }
        for (k kVar : this.l) {
            k0(kVar.a(), kVar.d(), kVar.b(), kVar.c());
        }
        this.l.clear();
    }

    private void f0(String str, Map<String, Object> map, h hVar) {
        m0(str, false, map, hVar);
    }

    private void g0() {
        h0(true);
    }

    private void h0(boolean z) {
        String str;
        com.google.firebase.database.o.e.b(N(), "Must be connected to send auth, but was: %s", this.h);
        com.google.firebase.database.o.e.b(this.o != null, "Auth token must be set to authenticate!", new Object[0]);
        c cVar = new c(z);
        HashMap hashMap = new HashMap();
        com.google.firebase.database.t.a c2 = com.google.firebase.database.t.a.c(this.o);
        if (c2 != null) {
            hashMap.put("cred", c2.b());
            if (c2.a() != null) {
                hashMap.put("authvar", c2.a());
            }
            str = "gauth";
        } else {
            hashMap.put("cred", this.o);
            str = "auth";
        }
        m0(str, true, hashMap, cVar);
    }

    private void i0() {
        HashMap hashMap = new HashMap();
        if (this.q.g()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        hashMap.put("sdk.android." + this.q.b().replace('.', '-'), 1);
        if (this.t.f()) {
            this.t.b("Sending first connection stats", new Object[0]);
        }
        n0(hashMap);
    }

    private void j0(l lVar) {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("p", com.google.firebase.database.o.e.d(lVar.d().f2086a));
        Object e2 = lVar.e();
        if (e2 != null) {
            hashMap.put("q", lVar.f2093b.f2087b);
            hashMap.put("t", e2);
        }
        com.google.firebase.database.o.g c2 = lVar.c();
        hashMap.put("h", c2.d());
        if (c2.c()) {
            com.google.firebase.database.o.a b2 = c2.b();
            ArrayList arrayList = new ArrayList();
            for (List<String> list : b2.b()) {
                arrayList.add(com.google.firebase.database.o.e.d(list));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("hs", b2.a());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        f0("q", hashMap, new e(lVar));
    }

    private void k0(String str, List<String> list, Object obj, com.google.firebase.database.o.k kVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", com.google.firebase.database.o.e.d(list));
        hashMap.put("d", obj);
        f0(str, hashMap, new b(this, kVar));
    }

    private void l0(long j2) {
        m mVar = this.m.get(Long.valueOf(j2));
        com.google.firebase.database.o.k b2 = mVar.b();
        String a2 = mVar.a();
        mVar.d();
        f0(a2, mVar.c(), new d(a2, j2, mVar, b2));
    }

    private void m0(String str, boolean z, Map<String, Object> map, h hVar) {
        long U = U();
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(U));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.g.m(hashMap, z);
        this.k.put(Long.valueOf(U), hVar);
    }

    private void n0(Map<String, Integer> map) {
        if (map.isEmpty()) {
            if (this.t.f()) {
                this.t.b("Not sending stats because stats are empty", new Object[0]);
                return;
            }
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("c", map);
        f0("s", hashMap, new f());
    }

    private void o0() {
        com.google.firebase.database.o.e.b(N(), "Must be connected to send unauth.", new Object[0]);
        com.google.firebase.database.o.e.b(this.o == null, "Auth token must not be set.", new Object[0]);
        f0("unauth", Collections.emptyMap(), null);
    }

    private void p0(l lVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", com.google.firebase.database.o.e.d(lVar.f2093b.f2086a));
        Long e2 = lVar.e();
        if (e2 != null) {
            hashMap.put("q", lVar.d().f2087b);
            hashMap.put("t", e2);
        }
        f0("n", hashMap, null);
    }

    static /* synthetic */ int q(i iVar) {
        int i = iVar.x;
        iVar.x = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        if (q0()) {
            com.google.firebase.database.o.e.b(this.h == EnumC0098i.Disconnected, "Not in disconnected state: %s", this.h);
            boolean z = this.p;
            this.t.b("Scheduling connection attempt", new Object[0]);
            this.p = false;
            this.u.c(new a(z));
        }
    }

    private void s0() {
        h0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(List<String> list, j jVar) {
        if (list.contains("no_index")) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.i("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '" + ("\".indexOn\": \"" + jVar.f2087b.get("i") + '\"') + "' at " + com.google.firebase.database.o.e.d(jVar.f2086a) + " to your security and Firebase Database rules for better performance");
        }
    }

    public boolean T(String str) {
        return this.f2073d.contains(str);
    }

    public void Z(String str) {
        com.google.firebase.database.o.e.b(this.h == EnumC0098i.GettingToken, "Trying to open network connection while in the wrong state: %s", this.h);
        if (str == null) {
            this.f2070a.b(false);
        }
        this.o = str;
        this.h = EnumC0098i.Connecting;
        com.google.firebase.database.o.b bVar = new com.google.firebase.database.o.b(this.q, this.f2071b, this.f2072c, this, this.v);
        this.g = bVar;
        bVar.k();
    }

    @Override // com.google.firebase.database.o.h
    public void a() {
        r0();
    }

    @Override // com.google.firebase.database.o.h
    public void b(List<String> list, Object obj, com.google.firebase.database.o.k kVar) {
        a0("p", list, obj, null, kVar);
    }

    @Override // com.google.firebase.database.o.b.a
    public void c(long j2, String str) {
        if (this.t.f()) {
            this.t.b("onReady", new Object[0]);
        }
        this.f = System.currentTimeMillis();
        Q(j2);
        if (this.e) {
            i0();
        }
        d0();
        this.e = false;
        this.v = str;
        this.f2070a.a();
    }

    @Override // com.google.firebase.database.o.h
    public void d(List<String> list, Object obj, String str, com.google.firebase.database.o.k kVar) {
        a0("p", list, obj, str, kVar);
    }

    @Override // com.google.firebase.database.o.h
    public void e(String str) {
        this.t.b("Auth token refreshed.", new Object[0]);
        this.o = str;
        if (N()) {
            if (str != null) {
                s0();
            } else {
                o0();
            }
        }
    }

    @Override // com.google.firebase.database.o.h
    public void f(List<String> list, Map<String, Object> map, com.google.firebase.database.o.g gVar, Long l2, com.google.firebase.database.o.k kVar) {
        j jVar = new j(list, map);
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("Listening on " + jVar, new Object[0]);
        }
        com.google.firebase.database.o.e.b(!this.n.containsKey(jVar), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar2 = this.t;
            cVar2.b("Adding listen query: " + jVar, new Object[0]);
        }
        l lVar = new l(kVar, jVar, l2, gVar, null);
        this.n.put(jVar, lVar);
        if (N()) {
            j0(lVar);
        }
        O();
    }

    @Override // com.google.firebase.database.o.b.a
    public void g(Map<String, Object> map) {
        if (map.containsKey("r")) {
            h remove = this.k.remove(Long.valueOf(((Integer) map.get("r")).intValue()));
            if (remove != null) {
                remove.a((Map) map.get("b"));
            }
        } else if (map.containsKey("error")) {
        } else {
            if (map.containsKey("a")) {
                W((String) map.get("a"), (Map) map.get("b"));
            } else if (this.t.f()) {
                com.google.firebase.database.q.c cVar = this.t;
                cVar.b("Ignoring unknown message: " + map, new Object[0]);
            }
        }
    }

    @Override // com.google.firebase.database.o.h
    public void h(List<String> list, Map<String, Object> map, com.google.firebase.database.o.k kVar) {
        a0("m", list, map, null, kVar);
    }

    @Override // com.google.firebase.database.o.h
    public void i(String str) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("Connection interrupted for: " + str, new Object[0]);
        }
        this.f2073d.add(str);
        com.google.firebase.database.o.b bVar = this.g;
        if (bVar != null) {
            bVar.c();
            this.g = null;
        } else {
            this.u.b();
            this.h = EnumC0098i.Disconnected;
        }
        this.u.e();
    }

    @Override // com.google.firebase.database.o.h
    public void j(List<String> list, Map<String, Object> map) {
        j jVar = new j(list, map);
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("unlistening on " + jVar, new Object[0]);
        }
        l b0 = b0(jVar);
        if (b0 != null && N()) {
            p0(b0);
        }
        O();
    }

    @Override // com.google.firebase.database.o.b.a
    public void k(b.EnumC0096b enumC0096b) {
        boolean z = false;
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("Got on disconnect due to " + enumC0096b.name(), new Object[0]);
        }
        this.h = EnumC0098i.Disconnected;
        this.g = null;
        this.A = false;
        this.k.clear();
        M();
        if (q0()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = this.f;
            long j3 = currentTimeMillis - j2;
            if (j2 > 0 && j3 > 30000) {
                z = true;
            }
            if (enumC0096b == b.EnumC0096b.SERVER_RESET || z) {
                this.u.e();
            }
            r0();
        }
        this.f = 0L;
        this.f2070a.e();
    }

    @Override // com.google.firebase.database.o.b.a
    public void l(String str) {
        this.f2072c = str;
    }

    @Override // com.google.firebase.database.o.h
    public void m(String str) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("Connection no longer interrupted for: " + str, new Object[0]);
        }
        this.f2073d.remove(str);
        if (q0() && this.h == EnumC0098i.Disconnected) {
            r0();
        }
    }

    @Override // com.google.firebase.database.o.b.a
    public void n(String str) {
        if (this.t.f()) {
            com.google.firebase.database.q.c cVar = this.t;
            cVar.b("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: " + str, new Object[0]);
        }
        i("server_kill");
    }

    boolean q0() {
        return this.f2073d.size() == 0;
    }
}
