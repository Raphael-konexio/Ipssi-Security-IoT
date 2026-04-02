package b.d.a.a;

import c.a.c.a.h;
import c.a.c.a.i;
import d.o.j;
import d.o.q;
import d.s.d.g;
import d.s.d.o;
import d.w.e;
import io.flutter.embedding.engine.h.a;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public final class a implements i.c, io.flutter.embedding.engine.h.a {

    /* renamed from: a  reason: collision with root package name */
    private i f1434a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.d.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0067a<T, U> implements BiConsumer<String, String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ HttpsURLConnection f1435a;

        C0067a(HttpsURLConnection httpsURLConnection) {
            this.f1435a = httpsURLConnection;
        }

        @Override // java.util.function.BiConsumer
        /* renamed from: a */
        public final void accept(String str, String str2) {
            g.e(str, "key");
            g.e(str2, "value");
            this.f1435a.setRequestProperty(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<T> implements Supplier<Boolean> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1437b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f1438c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map f1439d;
        final /* synthetic */ int e;
        final /* synthetic */ String f;

        b(String str, List list, Map map, int i, String str2) {
            this.f1437b = str;
            this.f1438c = list;
            this.f1439d = map;
            this.e = i;
            this.f = str2;
        }

        @Override // java.util.function.Supplier
        /* renamed from: a */
        public final Boolean get() {
            return Boolean.valueOf(a.this.a(this.f1437b, this.f1438c, this.f1439d, this.e, this.f));
        }
    }

    private final String d(String str, int i, Map<String, String> map, String str2) {
        URLConnection openConnection = new URL(str).openConnection();
        if (openConnection != null) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
            map.forEach(new C0067a(httpsURLConnection));
            httpsURLConnection.connect();
            Certificate certificate = httpsURLConnection.getServerCertificates()[0];
            if (certificate != null) {
                httpsURLConnection.disconnect();
                byte[] encoded = certificate.getEncoded();
                g.d(encoded, "cert.getEncoded()");
                return g(str2, encoded);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.Certificate");
        }
        throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
    }

    private final void e(h hVar, i.d dVar) {
        Object obj = hVar.f1491b;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.Any> /* = java.util.HashMap<kotlin.String, kotlin.Any> */");
        }
        HashMap hashMap = (HashMap) obj;
        Object obj2 = hashMap.get("url");
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        String str = (String) obj2;
        Object obj3 = hashMap.get("fingerprints");
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        }
        List list = (List) obj3;
        Object obj4 = hashMap.get("headers");
        if (obj4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        }
        Map map = (Map) obj4;
        Object obj5 = hashMap.get("timeout");
        if (obj5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = ((Integer) obj5).intValue();
        Object obj6 = hashMap.get("type");
        if (obj6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
        Object obj7 = CompletableFuture.supplyAsync(new b(str, list, map, intValue, (String) obj6)).get();
        g.d(obj7, "CompletableFuture.supply…s, timeout, type) }.get()");
        if (((Boolean) obj7).booleanValue()) {
            dVar.c("CONNECTION_SECURE");
        } else {
            dVar.b("CONNECTION_NOT_SECURE", "Connection is not secure", "Fingerprint doesn't match");
        }
    }

    private final String g(String str, byte[] bArr) {
        String k;
        byte[] digest = MessageDigest.getInstance(str).digest(bArr);
        g.d(digest, "MessageDigest\n          …           .digest(input)");
        ArrayList arrayList = new ArrayList(digest.length);
        for (byte b2 : digest) {
            o oVar = o.f2414a;
            String format = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b2)}, 1));
            g.d(format, "java.lang.String.format(format, *args)");
            arrayList.add(format);
        }
        k = q.k(arrayList, "", null, null, 0, null, null, 62, null);
        return k;
    }

    public final boolean a(String str, List<String> list, Map<String, String> map, int i, String str2) {
        int g;
        g.e(str, "serverURL");
        g.e(list, "allowedFingerprints");
        g.e(map, "httpHeaderArgs");
        g.e(str2, "type");
        String d2 = d(str, i, map, str2);
        g = j.g(list, 10);
        ArrayList arrayList = new ArrayList(g);
        for (String str3 : list) {
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String upperCase = str3.toUpperCase();
            g.d(upperCase, "(this as java.lang.String).toUpperCase()");
            arrayList.add(new e("\\s").a(upperCase, ""));
        }
        return arrayList.contains(d2);
    }

    @Override // c.a.c.a.i.c
    public void b(h hVar, i.d dVar) {
        g.e(hVar, "call");
        g.e(dVar, "result");
        try {
            String str = hVar.f1490a;
            if (str != null && str.hashCode() == 94627080 && str.equals("check")) {
                e(hVar, dVar);
            }
            dVar.a();
        } catch (Exception e) {
            dVar.b(e.toString(), "", "");
        }
    }

    @Override // io.flutter.embedding.engine.h.a
    public void c(a.b bVar) {
        g.e(bVar, "flutterPluginBinding");
        i iVar = new i(bVar.c().h(), "ssl_pinning_plugin");
        this.f1434a = iVar;
        if (iVar != null) {
            iVar.e(this);
        } else {
            g.n("channel");
            throw null;
        }
    }

    @Override // io.flutter.embedding.engine.h.a
    public void f(a.b bVar) {
        g.e(bVar, "binding");
        i iVar = this.f1434a;
        if (iVar != null) {
            iVar.e(null);
        } else {
            g.n("channel");
            throw null;
        }
    }
}
