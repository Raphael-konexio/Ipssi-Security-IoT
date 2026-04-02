package io.flutter.embedding.engine.i;

import c.a.c.a.i;
import c.a.c.a.r;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final c.a.c.a.i f2553a;

    /* renamed from: b  reason: collision with root package name */
    private e f2554b;

    /* renamed from: c  reason: collision with root package name */
    private final i.c f2555c = new a();

    /* loaded from: classes.dex */
    class a implements i.c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.flutter.embedding.engine.i.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0123a implements Runnable {
            final /* synthetic */ i.d f;

            RunnableC0123a(a aVar, i.d dVar) {
                this.f = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.c(null);
            }
        }

        a() {
        }

        private void a(c.a.c.a.h hVar, i.d dVar) {
            try {
                i.this.f2554b.e(((Integer) hVar.b()).intValue());
                dVar.c(null);
            } catch (IllegalStateException e) {
                dVar.b("error", i.c(e), null);
            }
        }

        private void c(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            boolean z = map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue();
            b bVar = new b(((Integer) map.get("id")).intValue(), (String) map.get("viewType"), z ? 0.0d : ((Double) map.get("width")).doubleValue(), z ? 0.0d : ((Double) map.get("height")).doubleValue(), ((Integer) map.get("direction")).intValue(), map.containsKey("params") ? ByteBuffer.wrap((byte[]) map.get("params")) : null);
            try {
                if (z) {
                    i.this.f2554b.g(bVar);
                    dVar.c(null);
                } else {
                    dVar.c(Long.valueOf(i.this.f2554b.d(bVar)));
                }
            } catch (IllegalStateException e) {
                dVar.b("error", i.c(e), null);
            }
        }

        private void d(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            int intValue = ((Integer) map.get("id")).intValue();
            try {
                if (map.containsKey("hybrid") && ((Boolean) map.get("hybrid")).booleanValue()) {
                    i.this.f2554b.b(intValue);
                } else {
                    i.this.f2554b.f(intValue);
                }
                dVar.c(null);
            } catch (IllegalStateException e) {
                dVar.b("error", i.c(e), null);
            }
        }

        private void e(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            try {
                i.this.f2554b.a(new c(((Integer) map.get("id")).intValue(), ((Double) map.get("width")).doubleValue(), ((Double) map.get("height")).doubleValue()), new RunnableC0123a(this, dVar));
            } catch (IllegalStateException e) {
                dVar.b("error", i.c(e), null);
            }
        }

        private void f(c.a.c.a.h hVar, i.d dVar) {
            Map map = (Map) hVar.b();
            try {
                i.this.f2554b.c(((Integer) map.get("id")).intValue(), ((Integer) map.get("direction")).intValue());
                dVar.c(null);
            } catch (IllegalStateException e) {
                dVar.b("error", i.c(e), null);
            }
        }

        private void g(c.a.c.a.h hVar, i.d dVar) {
            i.d dVar2;
            List list = (List) hVar.b();
            try {
                i.this.f2554b.h(new d(((Integer) list.get(0)).intValue(), (Number) list.get(1), (Number) list.get(2), ((Integer) list.get(3)).intValue(), ((Integer) list.get(4)).intValue(), list.get(5), list.get(6), ((Integer) list.get(7)).intValue(), ((Integer) list.get(8)).intValue(), (float) ((Double) list.get(9)).doubleValue(), (float) ((Double) list.get(10)).doubleValue(), ((Integer) list.get(11)).intValue(), ((Integer) list.get(12)).intValue(), ((Integer) list.get(13)).intValue(), ((Integer) list.get(14)).intValue(), ((Number) list.get(15)).longValue()));
                dVar2 = dVar;
            } catch (IllegalStateException e) {
                e = e;
                dVar2 = dVar;
            }
            try {
                dVar2.c(null);
            } catch (IllegalStateException e2) {
                e = e2;
                dVar2.b("error", i.c(e), null);
            }
        }

        @Override // c.a.c.a.i.c
        public void b(c.a.c.a.h hVar, i.d dVar) {
            if (i.this.f2554b == null) {
                return;
            }
            c.a.b.d("PlatformViewsChannel", "Received '" + hVar.f1490a + "' message.");
            String str = hVar.f1490a;
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1352294148:
                    if (str.equals("create")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -934437708:
                    if (str.equals("resize")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -756050293:
                    if (str.equals("clearFocus")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 110550847:
                    if (str.equals("touch")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 576796989:
                    if (str.equals("setDirection")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                c(hVar, dVar);
            } else if (c2 == 1) {
                d(hVar, dVar);
            } else if (c2 == 2) {
                e(hVar, dVar);
            } else if (c2 == 3) {
                g(hVar, dVar);
            } else if (c2 == 4) {
                f(hVar, dVar);
            } else if (c2 != 5) {
                dVar.a();
            } else {
                a(hVar, dVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f2557a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2558b;

        /* renamed from: c  reason: collision with root package name */
        public final double f2559c;

        /* renamed from: d  reason: collision with root package name */
        public final double f2560d;
        public final int e;
        public final ByteBuffer f;

        public b(int i, String str, double d2, double d3, int i2, ByteBuffer byteBuffer) {
            this.f2557a = i;
            this.f2558b = str;
            this.f2559c = d2;
            this.f2560d = d3;
            this.e = i2;
            this.f = byteBuffer;
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f2561a;

        /* renamed from: b  reason: collision with root package name */
        public final double f2562b;

        /* renamed from: c  reason: collision with root package name */
        public final double f2563c;

        public c(int i, double d2, double d3) {
            this.f2561a = i;
            this.f2562b = d2;
            this.f2563c = d3;
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f2564a;

        /* renamed from: b  reason: collision with root package name */
        public final Number f2565b;

        /* renamed from: c  reason: collision with root package name */
        public final Number f2566c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2567d;
        public final int e;
        public final Object f;
        public final Object g;
        public final int h;
        public final int i;
        public final float j;
        public final float k;
        public final int l;
        public final int m;
        public final int n;
        public final int o;
        public final long p;

        public d(int i, Number number, Number number2, int i2, int i3, Object obj, Object obj2, int i4, int i5, float f, float f2, int i6, int i7, int i8, int i9, long j) {
            this.f2564a = i;
            this.f2565b = number;
            this.f2566c = number2;
            this.f2567d = i2;
            this.e = i3;
            this.f = obj;
            this.g = obj2;
            this.h = i4;
            this.i = i5;
            this.j = f;
            this.k = f2;
            this.l = i6;
            this.m = i7;
            this.n = i8;
            this.o = i9;
            this.p = j;
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(c cVar, Runnable runnable);

        void b(int i);

        void c(int i, int i2);

        long d(b bVar);

        void e(int i);

        void f(int i);

        void g(b bVar);

        void h(d dVar);
    }

    public i(io.flutter.embedding.engine.e.a aVar) {
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/platform_views", r.f1504b);
        this.f2553a = iVar;
        iVar.e(this.f2555c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void d(int i) {
        c.a.c.a.i iVar = this.f2553a;
        if (iVar == null) {
            return;
        }
        iVar.c("viewFocused", Integer.valueOf(i));
    }

    public void e(e eVar) {
        this.f2554b = eVar;
    }
}
