package io.flutter.embedding.engine.i;

import android.os.Bundle;
import c.a.c.a.i;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    public final c.a.c.a.i f2579a;

    /* renamed from: b  reason: collision with root package name */
    private f f2580b;

    /* renamed from: c  reason: collision with root package name */
    private final i.c f2581c = new a();

    /* loaded from: classes.dex */
    class a implements i.c {
        a() {
        }

        @Override // c.a.c.a.i.c
        public void b(c.a.c.a.h hVar, i.d dVar) {
            String message;
            Bundle bundle;
            if (m.this.f2580b == null) {
                return;
            }
            String str = hVar.f1490a;
            Object obj = hVar.f1491b;
            c.a.b.d("TextInputChannel", "Received '" + str + "' message.");
            char c2 = 65535;
            switch (str.hashCode()) {
                case -1779068172:
                    if (str.equals("TextInput.setPlatformViewClient")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1015421462:
                    if (str.equals("TextInput.setEditingState")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -37561188:
                    if (str.equals("TextInput.setClient")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 270476819:
                    if (str.equals("TextInput.hide")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 270803918:
                    if (str.equals("TextInput.show")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 649192816:
                    if (str.equals("TextInput.sendAppPrivateCommand")) {
                        c2 = '\b';
                        break;
                    }
                    break;
                case 1204752139:
                    if (str.equals("TextInput.setEditableSizeAndTransform")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 1727570905:
                    if (str.equals("TextInput.finishAutofillContext")) {
                        c2 = '\t';
                        break;
                    }
                    break;
                case 1904427655:
                    if (str.equals("TextInput.clearClient")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case 2113369584:
                    if (str.equals("TextInput.requestAutofill")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            try {
                switch (c2) {
                    case 0:
                        m.this.f2580b.a();
                        break;
                    case 1:
                        m.this.f2580b.j();
                        break;
                    case 2:
                        try {
                            JSONArray jSONArray = (JSONArray) obj;
                            m.this.f2580b.c(jSONArray.getInt(0), b.a(jSONArray.getJSONObject(1)));
                            dVar.c(null);
                            return;
                        } catch (NoSuchFieldException | JSONException e) {
                            message = e.getMessage();
                            dVar.b("error", message, null);
                            return;
                        }
                    case 3:
                        m.this.f2580b.h();
                        break;
                    case 4:
                        m.this.f2580b.f(((Integer) obj).intValue());
                        return;
                    case 5:
                        m.this.f2580b.d(e.a((JSONObject) obj));
                        dVar.c(null);
                        return;
                    case 6:
                        JSONObject jSONObject = (JSONObject) obj;
                        double d2 = jSONObject.getDouble("width");
                        double d3 = jSONObject.getDouble("height");
                        JSONArray jSONArray2 = jSONObject.getJSONArray("transform");
                        double[] dArr = new double[16];
                        for (int i = 0; i < 16; i++) {
                            dArr[i] = jSONArray2.getDouble(i);
                        }
                        m.this.f2580b.g(d2, d3, dArr);
                        return;
                    case 7:
                        m.this.f2580b.b();
                        break;
                    case '\b':
                        JSONObject jSONObject2 = (JSONObject) obj;
                        String string = jSONObject2.getString("action");
                        String string2 = jSONObject2.getString("data");
                        if (string2 == null || string2.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = new Bundle();
                            bundle.putString("data", string2);
                        }
                        m.this.f2580b.e(string, bundle);
                        dVar.c(null);
                        return;
                    case '\t':
                        m.this.f2580b.i(((Boolean) obj).booleanValue());
                        break;
                    default:
                        dVar.a();
                        return;
                }
                dVar.c(null);
            } catch (JSONException e2) {
                message = e2.getMessage();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f2583a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2584b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f2585c;

        /* renamed from: d  reason: collision with root package name */
        public final d f2586d;
        public final c e;
        public final Integer f;
        public final String g;
        public final a h;
        public final b[] i;

        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final String f2587a;

            /* renamed from: b  reason: collision with root package name */
            public final String[] f2588b;

            /* renamed from: c  reason: collision with root package name */
            public final e f2589c;

            public a(String str, String[] strArr, e eVar) {
                this.f2587a = str;
                this.f2588b = strArr;
                this.f2589c = eVar;
            }

            public static a a(JSONObject jSONObject) {
                String string = jSONObject.getString("uniqueIdentifier");
                JSONArray jSONArray = jSONObject.getJSONArray("hints");
                JSONObject jSONObject2 = jSONObject.getJSONObject("editingValue");
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = b(jSONArray.getString(i));
                }
                return new a(string, strArr, e.a(jSONObject2));
            }

            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
                if (r16.equals("password") != false) goto L10;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            private static java.lang.String b(java.lang.String r16) {
                /*
                    Method dump skipped, instructions count: 740
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.m.b.a.b(java.lang.String):java.lang.String");
            }
        }

        public b(boolean z, boolean z2, boolean z3, d dVar, c cVar, Integer num, String str, a aVar, b[] bVarArr) {
            this.f2583a = z;
            this.f2584b = z2;
            this.f2585c = z3;
            this.f2586d = dVar;
            this.e = cVar;
            this.f = num;
            this.g = str;
            this.h = aVar;
            this.i = bVarArr;
        }

        public static b a(JSONObject jSONObject) {
            b[] bVarArr;
            String string = jSONObject.getString("inputAction");
            if (string != null) {
                if (jSONObject.isNull("fields")) {
                    bVarArr = null;
                } else {
                    JSONArray jSONArray = jSONObject.getJSONArray("fields");
                    int length = jSONArray.length();
                    b[] bVarArr2 = new b[length];
                    for (int i = 0; i < length; i++) {
                        bVarArr2[i] = a(jSONArray.getJSONObject(i));
                    }
                    bVarArr = bVarArr2;
                }
                return new b(jSONObject.optBoolean("obscureText"), jSONObject.optBoolean("autocorrect", true), jSONObject.optBoolean("enableSuggestions"), d.d(jSONObject.getString("textCapitalization")), c.a(jSONObject.getJSONObject("inputType")), b(string), jSONObject.isNull("actionLabel") ? null : jSONObject.getString("actionLabel"), jSONObject.isNull("autofill") ? null : a.a(jSONObject.getJSONObject("autofill")), bVarArr);
            }
            throw new JSONException("Configuration JSON missing 'inputAction' property.");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (r11.equals("TextInputAction.newline") != false) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.lang.Integer b(java.lang.String r11) {
            /*
                int r0 = r11.hashCode()
                r1 = 7
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 6
                r7 = 0
                java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
                r9 = 1
                java.lang.Integer r10 = java.lang.Integer.valueOf(r9)
                switch(r0) {
                    case -810971940: goto L68;
                    case -737377923: goto L5e;
                    case -737089298: goto L54;
                    case -737080013: goto L4a;
                    case -736940669: goto L40;
                    case 469250275: goto L36;
                    case 1241689507: goto L2c;
                    case 1539450297: goto L23;
                    case 2110497650: goto L18;
                    default: goto L17;
                }
            L17:
                goto L72
            L18:
                java.lang.String r0 = "TextInputAction.previous"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 8
                goto L73
            L23:
                java.lang.String r0 = "TextInputAction.newline"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                goto L73
            L2c:
                java.lang.String r0 = "TextInputAction.go"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 4
                goto L73
            L36:
                java.lang.String r0 = "TextInputAction.search"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 5
                goto L73
            L40:
                java.lang.String r0 = "TextInputAction.send"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 6
                goto L73
            L4a:
                java.lang.String r0 = "TextInputAction.none"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 1
                goto L73
            L54:
                java.lang.String r0 = "TextInputAction.next"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 7
                goto L73
            L5e:
                java.lang.String r0 = "TextInputAction.done"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 3
                goto L73
            L68:
                java.lang.String r0 = "TextInputAction.unspecified"
                boolean r11 = r11.equals(r0)
                if (r11 == 0) goto L72
                r7 = 2
                goto L73
            L72:
                r7 = -1
            L73:
                switch(r7) {
                    case 0: goto L96;
                    case 1: goto L96;
                    case 2: goto L95;
                    case 3: goto L90;
                    case 4: goto L8b;
                    case 5: goto L86;
                    case 6: goto L81;
                    case 7: goto L7c;
                    case 8: goto L77;
                    default: goto L76;
                }
            L76:
                return r8
            L77:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r1)
                return r11
            L7c:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r2)
                return r11
            L81:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r3)
                return r11
            L86:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
                return r11
            L8b:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r5)
                return r11
            L90:
                java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
                return r11
            L95:
                return r8
            L96:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.i.m.b.b(java.lang.String):java.lang.Integer");
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final g f2590a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2591b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f2592c;

        public c(g gVar, boolean z, boolean z2) {
            this.f2590a = gVar;
            this.f2591b = z;
            this.f2592c = z2;
        }

        public static c a(JSONObject jSONObject) {
            return new c(g.d(jSONObject.getString("name")), jSONObject.optBoolean("signed", false), jSONObject.optBoolean("decimal", false));
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        CHARACTERS("TextCapitalization.characters"),
        WORDS("TextCapitalization.words"),
        SENTENCES("TextCapitalization.sentences"),
        NONE("TextCapitalization.none");
        
        private final String f;

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
            throw new NoSuchFieldException("No such TextCapitalization: " + str);
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f2593a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2594b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2595c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2596d;
        public final int e;

        public e(String str, int i, int i2, int i3, int i4) {
            if (!(i == -1 && i2 == -1) && (i < 0 || i2 < 0)) {
                throw new IndexOutOfBoundsException("invalid selection: (" + String.valueOf(i) + ", " + String.valueOf(i2) + ")");
            } else if (!(i3 == -1 && i4 == -1) && (i3 < 0 || i3 >= i4)) {
                throw new IndexOutOfBoundsException("invalid composing range: (" + String.valueOf(i3) + ", " + String.valueOf(i4) + ")");
            } else if (i4 > str.length()) {
                throw new IndexOutOfBoundsException("invalid composing start: " + String.valueOf(i3));
            } else if (i > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection start: " + String.valueOf(i));
            } else if (i2 > str.length()) {
                throw new IndexOutOfBoundsException("invalid selection end: " + String.valueOf(i2));
            } else {
                this.f2593a = str;
                this.f2594b = i;
                this.f2595c = i2;
                this.f2596d = i3;
                this.e = i4;
            }
        }

        public static e a(JSONObject jSONObject) {
            return new e(jSONObject.getString("text"), jSONObject.getInt("selectionBase"), jSONObject.getInt("selectionExtent"), jSONObject.getInt("composingBase"), jSONObject.getInt("composingExtent"));
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();

        void c(int i, b bVar);

        void d(e eVar);

        void e(String str, Bundle bundle);

        void f(int i);

        void g(double d2, double d3, double[] dArr);

        void h();

        void i(boolean z);

        void j();
    }

    /* loaded from: classes.dex */
    public enum g {
        TEXT("TextInputType.text"),
        DATETIME("TextInputType.datetime"),
        NAME("TextInputType.name"),
        POSTAL_ADDRESS("TextInputType.address"),
        NUMBER("TextInputType.number"),
        PHONE("TextInputType.phone"),
        MULTILINE("TextInputType.multiline"),
        EMAIL_ADDRESS("TextInputType.emailAddress"),
        URL("TextInputType.url"),
        VISIBLE_PASSWORD("TextInputType.visiblePassword");
        
        private final String f;

        g(String str) {
            this.f = str;
        }

        static g d(String str) {
            g[] values;
            for (g gVar : values()) {
                if (gVar.f.equals(str)) {
                    return gVar;
                }
            }
            throw new NoSuchFieldException("No such TextInputType: " + str);
        }
    }

    public m(io.flutter.embedding.engine.e.a aVar) {
        c.a.c.a.i iVar = new c.a.c.a.i(aVar, "flutter/textinput", c.a.c.a.e.f1489a);
        this.f2579a = iVar;
        iVar.e(this.f2581c);
    }

    private static HashMap<Object, Object> b(String str, int i, int i2, int i3, int i4) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("text", str);
        hashMap.put("selectionBase", Integer.valueOf(i));
        hashMap.put("selectionExtent", Integer.valueOf(i2));
        hashMap.put("composingBase", Integer.valueOf(i3));
        hashMap.put("composingExtent", Integer.valueOf(i4));
        return hashMap;
    }

    public void c(int i) {
        c.a.b.d("TextInputChannel", "Sending 'done' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.done"));
    }

    public void d(int i) {
        c.a.b.d("TextInputChannel", "Sending 'go' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.go"));
    }

    public void e(int i) {
        c.a.b.d("TextInputChannel", "Sending 'newline' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.newline"));
    }

    public void f(int i) {
        c.a.b.d("TextInputChannel", "Sending 'next' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.next"));
    }

    public void g(int i, String str, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put("action", str);
        if (bundle != null) {
            HashMap hashMap2 = new HashMap();
            for (String str2 : bundle.keySet()) {
                Object obj = bundle.get(str2);
                if (obj instanceof byte[]) {
                    hashMap2.put(str2, bundle.getByteArray(str2));
                } else if (obj instanceof Byte) {
                    hashMap2.put(str2, Byte.valueOf(bundle.getByte(str2)));
                } else if (obj instanceof char[]) {
                    hashMap2.put(str2, bundle.getCharArray(str2));
                } else if (obj instanceof Character) {
                    hashMap2.put(str2, Character.valueOf(bundle.getChar(str2)));
                } else if (obj instanceof CharSequence[]) {
                    hashMap2.put(str2, bundle.getCharSequenceArray(str2));
                } else if (obj instanceof CharSequence) {
                    hashMap2.put(str2, bundle.getCharSequence(str2));
                } else if (obj instanceof float[]) {
                    hashMap2.put(str2, bundle.getFloatArray(str2));
                } else if (obj instanceof Float) {
                    hashMap2.put(str2, Float.valueOf(bundle.getFloat(str2)));
                }
            }
            hashMap.put("data", hashMap2);
        }
        this.f2579a.c("TextInputClient.performPrivateCommand", Arrays.asList(Integer.valueOf(i), hashMap));
    }

    public void h(int i) {
        c.a.b.d("TextInputChannel", "Sending 'previous' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.previous"));
    }

    public void i() {
        this.f2579a.c("TextInputClient.requestExistingInputState", null);
    }

    public void j(int i) {
        c.a.b.d("TextInputChannel", "Sending 'search' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.search"));
    }

    public void k(int i) {
        c.a.b.d("TextInputChannel", "Sending 'send' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.send"));
    }

    public void l(f fVar) {
        this.f2580b = fVar;
    }

    public void m(int i) {
        c.a.b.d("TextInputChannel", "Sending 'unspecified' message.");
        this.f2579a.c("TextInputClient.performAction", Arrays.asList(Integer.valueOf(i), "TextInputAction.unspecified"));
    }

    public void n(int i, String str, int i2, int i3, int i4, int i5) {
        c.a.b.d("TextInputChannel", "Sending message to update editing state: \nText: " + str + "\nSelection start: " + i2 + "\nSelection end: " + i3 + "\nComposing start: " + i4 + "\nComposing end: " + i5);
        this.f2579a.c("TextInputClient.updateEditingState", Arrays.asList(Integer.valueOf(i), b(str, i2, i3, i4, i5)));
    }

    public void o(int i, HashMap<String, e> hashMap) {
        c.a.b.d("TextInputChannel", "Sending message to update editing state for " + String.valueOf(hashMap.size()) + " field(s).");
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, e> entry : hashMap.entrySet()) {
            e value = entry.getValue();
            hashMap2.put(entry.getKey(), b(value.f2593a, value.f2594b, value.f2595c, -1, -1));
        }
        this.f2579a.c("TextInputClient.updateEditingStateWithTag", Arrays.asList(Integer.valueOf(i), hashMap2));
    }
}
