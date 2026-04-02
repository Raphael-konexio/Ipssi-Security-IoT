package io.flutter.embedding.engine.i;

import c.a.c.a.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f2541a;

    /* renamed from: b  reason: collision with root package name */
    private InterfaceC0122h f2542b;

    /* renamed from: c  reason: collision with root package name */
    final i.c f2543c = new a();

    /* loaded from: classes.dex */
    class a implements i.c {
        a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0107 A[Catch: JSONException -> 0x01d4, TryCatch #2 {JSONException -> 0x01d4, blocks: (B:6:0x002c, B:7:0x0030, B:44:0x00ab, B:45:0x00b0, B:46:0x00c9, B:47:0x00d8, B:48:0x00dd, B:50:0x00e1, B:54:0x00fb, B:56:0x0107, B:52:0x00e6, B:57:0x0114, B:66:0x0140, B:87:0x01a1, B:92:0x01ba, B:64:0x0137, B:65:0x013b, B:73:0x0163, B:78:0x017f, B:85:0x019c, B:90:0x01b5, B:95:0x01ce, B:9:0x0035, B:12:0x0040, B:15:0x004a, B:18:0x0055, B:21:0x005f, B:24:0x006a, B:27:0x0074, B:30:0x007e, B:33:0x0088, B:36:0x0092, B:39:0x009d, B:75:0x0168), top: B:100:0x002c, inners: #3, #7, #8, #9 }] */
        @Override // c.a.c.a.i.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void b(c.a.c.a.h r6, c.a.c.a.i.d r7) {
            /*
                Method dump skipped, instructions count: 566
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.h.a.b(c.a.c.a.h, c.a.c.a.i$d):void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2545a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2546b;

        static {
            int[] iArr = new int[k.values().length];
            f2546b = iArr;
            try {
                iArr[k.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2546b[k.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[f.values().length];
            f2545a = iArr2;
            try {
                iArr2[f.PORTRAIT_UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2545a[f.PORTRAIT_DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2545a[f.LANDSCAPE_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2545a[f.LANDSCAPE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f2547a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2548b;

        public c(int i, String str) {
            this.f2547a = i;
            this.f2548b = str;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        LIGHT("Brightness.light"),
        DARK("Brightness.dark");
        
        private String f;

        d(String str) {
            this.f = str;
        }

        static d d(String str) {
            d[] values;
            for (d dVar : values()) {
                if (dVar.f.equals(str)) {
                    return dVar;
                }
            }
            throw new NoSuchFieldException("No such Brightness: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        PLAIN_TEXT("text/plain");
        
        private String f;

        e(String str) {
            this.f = str;
        }

        static e d(String str) {
            e[] values;
            for (e eVar : values()) {
                if (eVar.f.equals(str)) {
                    return eVar;
                }
            }
            throw new NoSuchFieldException("No such ClipboardContentFormat: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum f {
        PORTRAIT_UP("DeviceOrientation.portraitUp"),
        PORTRAIT_DOWN("DeviceOrientation.portraitDown"),
        LANDSCAPE_LEFT("DeviceOrientation.landscapeLeft"),
        LANDSCAPE_RIGHT("DeviceOrientation.landscapeRight");
        
        private String f;

        f(String str) {
            this.f = str;
        }

        static f d(String str) {
            f[] values;
            for (f fVar : values()) {
                if (fVar.f.equals(str)) {
                    return fVar;
                }
            }
            throw new NoSuchFieldException("No such DeviceOrientation: " + str);
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        STANDARD(null),
        LIGHT_IMPACT("HapticFeedbackType.lightImpact"),
        MEDIUM_IMPACT("HapticFeedbackType.mediumImpact"),
        HEAVY_IMPACT("HapticFeedbackType.heavyImpact"),
        SELECTION_CLICK("HapticFeedbackType.selectionClick");
        
        private final String f;

        g(String str) {
            this.f = str;
        }

        static g d(String str) {
            g[] values;
            String str2;
            for (g gVar : values()) {
                if ((gVar.f == null && str == null) || ((str2 = gVar.f) != null && str2.equals(str))) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such HapticFeedbackType: " + str);
        }
    }

    /* renamed from: io.flutter.embedding.engine.i.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0122h {
        void b();

        void c(i iVar);

        void d(List<k> list);

        void e();

        void f(String str);

        void g(j jVar);

        void h(int i);

        void i(c cVar);

        void j(g gVar);

        boolean k();

        CharSequence l(e eVar);
    }

    /* loaded from: classes.dex */
    public enum i {
        CLICK("SystemSoundType.click"),
        ALERT("SystemSoundType.alert");
        
        private final String f;

        i(String str) {
            this.f = str;
        }

        static i d(String str) {
            i[] values;
            for (i iVar : values()) {
                if (iVar.f.equals(str)) {
                    return iVar;
                }
            }
            throw new NoSuchFieldException("No such SoundType: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        public final Integer f2549a;

        /* renamed from: b  reason: collision with root package name */
        public final d f2550b;

        /* renamed from: c  reason: collision with root package name */
        public final Integer f2551c;

        /* renamed from: d  reason: collision with root package name */
        public final d f2552d;
        public final Integer e;

        public j(Integer num, d dVar, Integer num2, d dVar2, Integer num3) {
            this.f2549a = num;
            this.f2550b = dVar;
            this.f2551c = num2;
            this.f2552d = dVar2;
            this.e = num3;
        }
    }

    /* loaded from: classes.dex */
    public enum k {
        TOP_OVERLAYS("SystemUiOverlay.top"),
        BOTTOM_OVERLAYS("SystemUiOverlay.bottom");
        
        private String f;

        k(String str) {
            this.f = str;
        }

        static k d(String str) {
            k[] values;
            for (k kVar : values()) {
                if (kVar.f.equals(str)) {
                    return kVar;
                }
            }
            throw new NoSuchFieldException("No such SystemUiOverlay: " + str);
        }
    }

    public h(io.flutter.embedding.engine.e.a aVar) {
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/platform", c.a.c.a.e.f1489a);
        this.f2541a = iVar;
        iVar.e(this.f2543c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c f(JSONObject jSONObject) {
        int i2 = jSONObject.getInt("primaryColor");
        if (i2 != 0) {
            i2 |= -16777216;
        }
        return new c(i2, jSONObject.getString("label"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int g(org.json.JSONArray r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = 0
            r3 = 0
        L4:
            int r4 = r10.length()
            r5 = 4
            r6 = 2
            r7 = 1
            if (r1 >= r4) goto L38
            java.lang.String r4 = r10.getString(r1)
            io.flutter.embedding.engine.i.h$f r4 = io.flutter.embedding.engine.i.h.f.d(r4)
            int[] r8 = io.flutter.embedding.engine.i.h.b.f2545a
            int r4 = r4.ordinal()
            r4 = r8[r4]
            if (r4 == r7) goto L30
            if (r4 == r6) goto L2d
            r6 = 3
            if (r4 == r6) goto L2a
            if (r4 == r5) goto L27
            goto L32
        L27:
            r2 = r2 | 8
            goto L32
        L2a:
            r2 = r2 | 2
            goto L32
        L2d:
            r2 = r2 | 4
            goto L32
        L30:
            r2 = r2 | 1
        L32:
            if (r3 != 0) goto L35
            r3 = r2
        L35:
            int r1 = r1 + 1
            goto L4
        L38:
            if (r2 == 0) goto L57
            r10 = 9
            r1 = 8
            switch(r2) {
                case 2: goto L56;
                case 3: goto L4d;
                case 4: goto L4c;
                case 5: goto L4a;
                case 6: goto L4d;
                case 7: goto L4d;
                case 8: goto L49;
                case 9: goto L4d;
                case 10: goto L46;
                case 11: goto L45;
                case 12: goto L4d;
                case 13: goto L4d;
                case 14: goto L4d;
                case 15: goto L42;
                default: goto L41;
            }
        L41:
            goto L53
        L42:
            r10 = 13
            return r10
        L45:
            return r6
        L46:
            r10 = 11
            return r10
        L49:
            return r1
        L4a:
            r10 = 12
        L4c:
            return r10
        L4d:
            if (r3 == r6) goto L56
            if (r3 == r5) goto L55
            if (r3 == r1) goto L54
        L53:
            return r7
        L54:
            return r1
        L55:
            return r10
        L56:
            return r0
        L57:
            r10 = -1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.h.g(org.json.JSONArray):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public j h(JSONObject jSONObject) {
        d d2 = !jSONObject.isNull("systemNavigationBarIconBrightness") ? d.d(jSONObject.getString("systemNavigationBarIconBrightness")) : null;
        Integer valueOf = !jSONObject.isNull("systemNavigationBarColor") ? Integer.valueOf(jSONObject.getInt("systemNavigationBarColor")) : null;
        return new j(!jSONObject.isNull("statusBarColor") ? Integer.valueOf(jSONObject.getInt("statusBarColor")) : null, !jSONObject.isNull("statusBarIconBrightness") ? d.d(jSONObject.getString("statusBarIconBrightness")) : null, valueOf, d2, jSONObject.isNull("systemNavigationBarDividerColor") ? null : Integer.valueOf(jSONObject.getInt("systemNavigationBarDividerColor")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<k> i(JSONArray jSONArray) {
        k kVar;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            int i3 = b.f2546b[k.d(jSONArray.getString(i2)).ordinal()];
            if (i3 == 1) {
                kVar = k.TOP_OVERLAYS;
            } else if (i3 == 2) {
                kVar = k.BOTTOM_OVERLAYS;
            }
            arrayList.add(kVar);
        }
        return arrayList;
    }

    public void j(InterfaceC0122h interfaceC0122h) {
        this.f2542b = interfaceC0122h;
    }
}
