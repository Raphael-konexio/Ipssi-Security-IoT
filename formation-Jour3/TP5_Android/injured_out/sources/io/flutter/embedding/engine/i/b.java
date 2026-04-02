package io.flutter.embedding.engine.i;

import c.a.c.a.a;
import c.a.c.a.q;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.c;
import java.util.HashMap;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.a<Object> f2525a;

    /* renamed from: b  reason: collision with root package name */
    public final FlutterJNI f2526b;

    /* renamed from: c  reason: collision with root package name */
    private InterfaceC0121b f2527c;

    /* renamed from: d  reason: collision with root package name */
    private final a.d<Object> f2528d = new a();

    /* loaded from: classes.dex */
    class a implements a.d<Object> {
        a() {
        }

        @Override // c.a.c.a.a.d
        public void a(Object obj, a.e<Object> eVar) {
            String str;
            if (b.this.f2527c == null) {
                return;
            }
            HashMap hashMap = (HashMap) obj;
            String str2 = (String) hashMap.get("type");
            HashMap hashMap2 = (HashMap) hashMap.get("data");
            c.a.b.d("AccessibilityChannel", "Received " + str2 + " message.");
            char c2 = 65535;
            switch (str2.hashCode()) {
                case -1140076541:
                    if (str2.equals("tooltip")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -649620375:
                    if (str2.equals("announce")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 114595:
                    if (str2.equals("tap")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 114203431:
                    if (str2.equals("longPress")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                String str3 = (String) hashMap2.get("message");
                if (str3 != null) {
                    b.this.f2527c.a(str3);
                }
            } else if (c2 == 1) {
                Integer num = (Integer) hashMap.get("nodeId");
                if (num != null) {
                    b.this.f2527c.f(num.intValue());
                }
            } else if (c2 == 2) {
                Integer num2 = (Integer) hashMap.get("nodeId");
                if (num2 != null) {
                    b.this.f2527c.d(num2.intValue());
                }
            } else if (c2 == 3 && (str = (String) hashMap2.get("message")) != null) {
                b.this.f2527c.c(str);
            }
            eVar.a(null);
        }
    }

    /* renamed from: io.flutter.embedding.engine.i.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0121b extends FlutterJNI.a {
        void a(String str);

        void c(String str);

        void d(int i);

        void f(int i);
    }

    public b(io.flutter.embedding.engine.e.a aVar, FlutterJNI flutterJNI) {
        c.a.c.a.a<Object> aVar2 = new c.a.c.a.a<>(aVar, "flutter/accessibility", q.f1501a);
        this.f2525a = aVar2;
        aVar2.e(this.f2528d);
        this.f2526b = flutterJNI;
    }

    public void b(int i, c.f fVar) {
        this.f2526b.dispatchSemanticsAction(i, fVar);
    }

    public void c(int i, c.f fVar, Object obj) {
        this.f2526b.dispatchSemanticsAction(i, fVar, obj);
    }

    public void d() {
        this.f2526b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f2526b.setSemanticsEnabled(true);
    }

    public void f(int i) {
        this.f2526b.setAccessibilityFeatures(i);
    }

    public void g(InterfaceC0121b interfaceC0121b) {
        this.f2527c = interfaceC0121b;
        this.f2526b.setAccessibilityDelegate(interfaceC0121b);
    }
}
