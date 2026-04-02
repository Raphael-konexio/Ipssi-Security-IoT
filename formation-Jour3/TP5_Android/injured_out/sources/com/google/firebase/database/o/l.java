package com.google.firebase.database.o;

import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l {
    private static long l;

    /* renamed from: a  reason: collision with root package name */
    private d f2103a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2104b = false;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2105c = false;

    /* renamed from: d  reason: collision with root package name */
    private long f2106d = 0;
    private com.google.firebase.database.o.m.b e;
    private c f;
    private ScheduledFuture<?> g;
    private ScheduledFuture<?> h;
    private final com.google.firebase.database.o.d i;
    private final ScheduledExecutorService j;
    private final com.google.firebase.database.q.c k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f2103a != null) {
                l.this.f2103a.d("0");
                l.this.u();
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(Map<String, Object> map);

        void b(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        void a();

        void close();

        void d(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e implements d, com.google.firebase.database.s.d {

        /* renamed from: a  reason: collision with root package name */
        private com.google.firebase.database.s.c f2107a;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.h.cancel(false);
                l.this.f2104b = true;
                if (l.this.k.f()) {
                    l.this.k.b("websocket opened", new Object[0]);
                }
                l.this.u();
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {
            final /* synthetic */ String f;

            b(String str) {
                this.f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                l.this.o(this.f);
            }
        }

        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.k.f()) {
                    l.this.k.b("closed", new Object[0]);
                }
                l.this.s();
            }
        }

        /* loaded from: classes.dex */
        class d implements Runnable {
            final /* synthetic */ com.google.firebase.database.s.e f;

            d(com.google.firebase.database.s.e eVar) {
                this.f = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f.getCause() == null || !(this.f.getCause() instanceof EOFException)) {
                    l.this.k.a("WebSocket error.", this.f, new Object[0]);
                } else {
                    l.this.k.b("WebSocket reached EOF.", new Object[0]);
                }
                l.this.s();
            }
        }

        private e(com.google.firebase.database.s.c cVar) {
            this.f2107a = cVar;
            cVar.r(this);
        }

        /* synthetic */ e(l lVar, com.google.firebase.database.s.c cVar, a aVar) {
            this(cVar);
        }

        private void g() {
            this.f2107a.c();
            try {
                this.f2107a.b();
            } catch (InterruptedException e) {
                l.this.k.c("Interrupted while shutting down websocket threads", e);
            }
        }

        @Override // com.google.firebase.database.o.l.d
        public void a() {
            try {
                this.f2107a.e();
            } catch (com.google.firebase.database.s.e e) {
                if (l.this.k.f()) {
                    l.this.k.a("Error connecting", e, new Object[0]);
                }
                g();
            }
        }

        @Override // com.google.firebase.database.s.d
        public void b() {
            l.this.j.execute(new c());
        }

        @Override // com.google.firebase.database.s.d
        public void c() {
            l.this.j.execute(new a());
        }

        @Override // com.google.firebase.database.o.l.d
        public void close() {
            this.f2107a.c();
        }

        @Override // com.google.firebase.database.o.l.d
        public void d(String str) {
            this.f2107a.p(str);
        }

        @Override // com.google.firebase.database.s.d
        public void e(com.google.firebase.database.s.g gVar) {
            String a2 = gVar.a();
            if (l.this.k.f()) {
                com.google.firebase.database.q.c cVar = l.this.k;
                cVar.b("ws message: " + a2, new Object[0]);
            }
            l.this.j.execute(new b(a2));
        }

        @Override // com.google.firebase.database.s.d
        public void f(com.google.firebase.database.s.e eVar) {
            l.this.j.execute(new d(eVar));
        }
    }

    public l(com.google.firebase.database.o.d dVar, f fVar, String str, c cVar, String str2) {
        this.i = dVar;
        this.j = dVar.c();
        this.f = cVar;
        long j = l;
        l = 1 + j;
        com.google.firebase.database.q.d d2 = dVar.d();
        this.k = new com.google.firebase.database.q.c(d2, "WebSocket", "ws_" + j);
        this.f2103a = m(fVar, str, str2);
    }

    private void j(String str) {
        com.google.firebase.database.q.c cVar;
        StringBuilder sb;
        String str2;
        this.e.a(str);
        long j = this.f2106d - 1;
        this.f2106d = j;
        if (j == 0) {
            try {
                this.e.f();
                Map<String, Object> a2 = com.google.firebase.database.t.b.a(this.e.toString());
                this.e = null;
                if (this.k.f()) {
                    com.google.firebase.database.q.c cVar2 = this.k;
                    cVar2.b("handleIncomingFrame complete frame: " + a2, new Object[0]);
                }
                this.f.a(a2);
            } catch (IOException e2) {
                e = e2;
                cVar = this.k;
                sb = new StringBuilder();
                str2 = "Error parsing frame: ";
                sb.append(str2);
                sb.append(this.e.toString());
                cVar.c(sb.toString(), e);
                k();
                w();
            } catch (ClassCastException e3) {
                e = e3;
                cVar = this.k;
                sb = new StringBuilder();
                str2 = "Error parsing frame (cast error): ";
                sb.append(str2);
                sb.append(this.e.toString());
                cVar.c(sb.toString(), e);
                k();
                w();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f2104b || this.f2105c) {
            return;
        }
        if (this.k.f()) {
            this.k.b("timed out on connect", new Object[0]);
        }
        this.f2103a.close();
    }

    private d m(f fVar, String str, String str2) {
        if (str == null) {
            str = fVar.b();
        }
        URI a2 = f.a(str, fVar.d(), fVar.c(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.i.f());
        return new e(this, new com.google.firebase.database.s.c(this.i, a2, null, hashMap), null);
    }

    private String n(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    p(parseInt);
                    return null;
                }
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        p(1);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str) {
        if (this.f2105c) {
            return;
        }
        u();
        if (!q() && (str = n(str)) == null) {
            return;
        }
        j(str);
    }

    private void p(int i) {
        this.f2106d = i;
        this.e = new com.google.firebase.database.o.m.b();
        if (this.k.f()) {
            com.google.firebase.database.q.c cVar = this.k;
            cVar.b("HandleNewFrameCount: " + this.f2106d, new Object[0]);
        }
    }

    private boolean q() {
        return this.e != null;
    }

    private Runnable r() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        if (!this.f2105c) {
            if (this.k.f()) {
                this.k.b("closing itself", new Object[0]);
            }
            w();
        }
        this.f2103a = null;
        ScheduledFuture<?> scheduledFuture = this.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (this.f2105c) {
            return;
        }
        ScheduledFuture<?> scheduledFuture = this.g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            if (this.k.f()) {
                com.google.firebase.database.q.c cVar = this.k;
                cVar.b("Reset keepAlive. Remaining: " + this.g.getDelay(TimeUnit.MILLISECONDS), new Object[0]);
            }
        } else if (this.k.f()) {
            this.k.b("Reset keepAlive", new Object[0]);
        }
        this.g = this.j.schedule(r(), 45000L, TimeUnit.MILLISECONDS);
    }

    private void w() {
        this.f2105c = true;
        this.f.b(this.f2104b);
    }

    private static String[] x(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int i3 = i2 + i;
            arrayList.add(str.substring(i2, Math.min(i3, str.length())));
            i2 = i3;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void k() {
        if (this.k.f()) {
            this.k.b("websocket is being closed", new Object[0]);
        }
        this.f2105c = true;
        this.f2103a.close();
        ScheduledFuture<?> scheduledFuture = this.h;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.g;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void t() {
        this.f2103a.a();
        this.h = this.j.schedule(new a(), 30000L, TimeUnit.MILLISECONDS);
    }

    public void v(Map<String, Object> map) {
        u();
        try {
            String[] x = x(com.google.firebase.database.t.b.c(map), 16384);
            if (x.length > 1) {
                this.f2103a.d("" + x.length);
            }
            for (String str : x) {
                this.f2103a.d(str);
            }
        } catch (IOException e2) {
            this.k.c("Failed to serialize message: " + map.toString(), e2);
            w();
        }
    }

    public void y() {
    }
}
