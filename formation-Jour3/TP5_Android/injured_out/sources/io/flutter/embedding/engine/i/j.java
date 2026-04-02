package io.flutter.embedding.engine.i;

import c.a.c.a.i;
import c.a.c.a.r;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f2568a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f2569b;

    /* renamed from: c  reason: collision with root package name */
    private c.a.c.a.i f2570c;

    /* renamed from: d  reason: collision with root package name */
    private i.d f2571d;
    private boolean e;
    private boolean f;
    private final i.c g;

    /* loaded from: classes.dex */
    class a implements i.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ byte[] f2572a;

        a(byte[] bArr) {
            this.f2572a = bArr;
        }

        @Override // c.a.c.a.i.d
        public void a() {
        }

        @Override // c.a.c.a.i.d
        public void b(String str, String str2, Object obj) {
            c.a.b.b("RestorationChannel", "Error " + str + " while sending restoration data to framework: " + str2);
        }

        @Override // c.a.c.a.i.d
        public void c(Object obj) {
            j.this.f2569b = this.f2572a;
        }
    }

    /* loaded from: classes.dex */
    class b implements i.c {
        b() {
        }

        @Override // c.a.c.a.i.c
        public void b(c.a.c.a.h hVar, i.d dVar) {
            char c2;
            Map map;
            String str = hVar.f1490a;
            Object obj = hVar.f1491b;
            int hashCode = str.hashCode();
            if (hashCode != 102230) {
                if (hashCode == 111375 && str.equals("put")) {
                    c2 = 0;
                }
                c2 = 65535;
            } else {
                if (str.equals("get")) {
                    c2 = 1;
                }
                c2 = 65535;
            }
            if (c2 == 0) {
                j.this.f2569b = (byte[]) obj;
                map = null;
            } else if (c2 != 1) {
                dVar.a();
                return;
            } else {
                j.this.f = true;
                if (!j.this.e) {
                    j jVar = j.this;
                    if (jVar.f2568a) {
                        jVar.f2571d = dVar;
                        return;
                    }
                }
                j jVar2 = j.this;
                map = jVar2.i(jVar2.f2569b);
            }
            dVar.c(map);
        }
    }

    j(c.a.c.a.i iVar, boolean z) {
        this.e = false;
        this.f = false;
        b bVar = new b();
        this.g = bVar;
        this.f2570c = iVar;
        this.f2568a = z;
        iVar.e(bVar);
    }

    public j(io.flutter.embedding.engine.e.a aVar, boolean z) {
        this(new c.a.c.a.i(aVar, "flutter/restoration", r.f1504b), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> i(byte[] bArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("enabled", Boolean.TRUE);
        hashMap.put("data", bArr);
        return hashMap;
    }

    public void g() {
        this.f2569b = null;
    }

    public byte[] h() {
        return this.f2569b;
    }

    public void j(byte[] bArr) {
        this.e = true;
        i.d dVar = this.f2571d;
        if (dVar != null) {
            dVar.c(i(bArr));
            this.f2571d = null;
        } else if (this.f) {
            this.f2570c.d("push", i(bArr), new a(bArr));
            return;
        }
        this.f2569b = bArr;
    }
}
