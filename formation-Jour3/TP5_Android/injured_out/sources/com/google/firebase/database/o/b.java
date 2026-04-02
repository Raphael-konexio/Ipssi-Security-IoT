package com.google.firebase.database.o;

import com.google.firebase.database.o.l;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements l.c {
    private static long f;

    /* renamed from: a  reason: collision with root package name */
    private f f2059a;

    /* renamed from: b  reason: collision with root package name */
    private l f2060b;

    /* renamed from: c  reason: collision with root package name */
    private a f2061c;

    /* renamed from: d  reason: collision with root package name */
    private c f2062d;
    private final com.google.firebase.database.q.c e;

    /* loaded from: classes.dex */
    public interface a {
        void c(long j, String str);

        void g(Map<String, Object> map);

        void k(EnumC0096b enumC0096b);

        void l(String str);

        void n(String str);
    }

    /* renamed from: com.google.firebase.database.o.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0096b {
        SERVER_RESET,
        OTHER
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED
    }

    public b(d dVar, f fVar, String str, a aVar, String str2) {
        long j = f;
        f = 1 + j;
        this.f2059a = fVar;
        this.f2061c = aVar;
        com.google.firebase.database.q.d d2 = dVar.d();
        this.e = new com.google.firebase.database.q.c(d2, "Connection", "conn_" + j);
        this.f2062d = c.REALTIME_CONNECTING;
        this.f2060b = new l(dVar, fVar, str, this, str2);
    }

    private void e(long j, String str) {
        if (this.e.f()) {
            this.e.b("realtime connection established", new Object[0]);
        }
        this.f2062d = c.REALTIME_CONNECTED;
        this.f2061c.c(j, str);
    }

    private void f(String str) {
        if (this.e.f()) {
            this.e.b("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.f2061c.n(str);
        c();
    }

    private void g(Map<String, Object> map) {
        if (this.e.f()) {
            com.google.firebase.database.q.c cVar = this.e;
            cVar.b("Got control message: " + map.toString(), new Object[0]);
        }
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.e.f()) {
                    com.google.firebase.database.q.c cVar2 = this.e;
                    cVar2.b("Got invalid control message: " + map.toString(), new Object[0]);
                }
                c();
            } else if (str.equals("s")) {
                f((String) map.get("d"));
            } else if (str.equals("r")) {
                j((String) map.get("d"));
            } else if (str.equals("h")) {
                i((Map) map.get("d"));
            } else if (this.e.f()) {
                com.google.firebase.database.q.c cVar3 = this.e;
                cVar3.b("Ignoring unknown control message: " + str, new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.e.f()) {
                com.google.firebase.database.q.c cVar4 = this.e;
                cVar4.b("Failed to parse control message: " + e.toString(), new Object[0]);
            }
            c();
        }
    }

    private void h(Map<String, Object> map) {
        if (this.e.f()) {
            com.google.firebase.database.q.c cVar = this.e;
            cVar.b("received data message: " + map.toString(), new Object[0]);
        }
        this.f2061c.g(map);
    }

    private void i(Map<String, Object> map) {
        long longValue = ((Long) map.get("ts")).longValue();
        this.f2061c.l((String) map.get("h"));
        String str = (String) map.get("s");
        if (this.f2062d == c.REALTIME_CONNECTING) {
            this.f2060b.y();
            e(longValue, str);
        }
    }

    private void j(String str) {
        if (this.e.f()) {
            com.google.firebase.database.q.c cVar = this.e;
            cVar.b("Got a reset; killing connection to " + this.f2059a.b() + "; Updating internalHost to " + str, new Object[0]);
        }
        this.f2061c.l(str);
        d(EnumC0096b.SERVER_RESET);
    }

    private void l(Map<String, Object> map, boolean z) {
        if (this.f2062d != c.REALTIME_CONNECTED) {
            this.e.b("Tried to send on an unconnected connection", new Object[0]);
            return;
        }
        if (z) {
            this.e.b("Sending data (contents hidden)", new Object[0]);
        } else {
            this.e.b("Sending data: %s", map);
        }
        this.f2060b.v(map);
    }

    @Override // com.google.firebase.database.o.l.c
    public void a(Map<String, Object> map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.e.f()) {
                    com.google.firebase.database.q.c cVar = this.e;
                    cVar.b("Failed to parse server message: missing message type:" + map.toString(), new Object[0]);
                }
                c();
            } else if (str.equals("d")) {
                h((Map) map.get("d"));
            } else if (str.equals("c")) {
                g((Map) map.get("d"));
            } else if (this.e.f()) {
                com.google.firebase.database.q.c cVar2 = this.e;
                cVar2.b("Ignoring unknown server message type: " + str, new Object[0]);
            }
        } catch (ClassCastException e) {
            if (this.e.f()) {
                com.google.firebase.database.q.c cVar3 = this.e;
                cVar3.b("Failed to parse server message: " + e.toString(), new Object[0]);
            }
            c();
        }
    }

    @Override // com.google.firebase.database.o.l.c
    public void b(boolean z) {
        this.f2060b = null;
        if (z || this.f2062d != c.REALTIME_CONNECTING) {
            if (this.e.f()) {
                this.e.b("Realtime connection lost", new Object[0]);
            }
        } else if (this.e.f()) {
            this.e.b("Realtime connection failed", new Object[0]);
        }
        c();
    }

    public void c() {
        d(EnumC0096b.OTHER);
    }

    public void d(EnumC0096b enumC0096b) {
        if (this.f2062d != c.REALTIME_DISCONNECTED) {
            if (this.e.f()) {
                this.e.b("closing realtime connection", new Object[0]);
            }
            this.f2062d = c.REALTIME_DISCONNECTED;
            l lVar = this.f2060b;
            if (lVar != null) {
                lVar.k();
                this.f2060b = null;
            }
            this.f2061c.k(enumC0096b);
        }
    }

    public void k() {
        if (this.e.f()) {
            this.e.b("Opening a connection", new Object[0]);
        }
        this.f2060b.t();
    }

    public void m(Map<String, Object> map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        l(hashMap, z);
    }
}
