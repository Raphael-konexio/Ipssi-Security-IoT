package b.a.a.v;

import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes.dex */
public class j extends b.a.a.v.b {

    /* renamed from: a  reason: collision with root package name */
    private final b f1201a;

    /* renamed from: b  reason: collision with root package name */
    private final SSLSocketFactory f1202b;

    /* loaded from: classes.dex */
    static class a extends FilterInputStream {
        private final HttpURLConnection f;

        a(HttpURLConnection httpURLConnection) {
            super(j.i(httpURLConnection));
            this.f = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            this.f.disconnect();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        String a(String str);
    }

    public j() {
        this(null);
    }

    public j(b bVar) {
        this(bVar, null);
    }

    public j(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f1201a = bVar;
        this.f1202b = sSLSocketFactory;
    }

    private static void d(HttpURLConnection httpURLConnection, b.a.a.m<?> mVar, byte[] bArr) {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", mVar.w());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }

    private static void e(HttpURLConnection httpURLConnection, b.a.a.m<?> mVar) {
        byte[] u = mVar.u();
        if (u != null) {
            d(httpURLConnection, mVar, u);
        }
    }

    static List<b.a.a.g> f(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String str : entry.getValue()) {
                    arrayList.add(new b.a.a.g(entry.getKey(), str));
                }
            }
        }
        return arrayList;
    }

    private static boolean h(int i, int i2) {
        return (i == 4 || (100 <= i2 && i2 < 200) || i2 == 204 || i2 == 304) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream i(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private HttpURLConnection j(URL url, b.a.a.m<?> mVar) {
        SSLSocketFactory sSLSocketFactory;
        HttpURLConnection g = g(url);
        int J = mVar.J();
        g.setConnectTimeout(J);
        g.setReadTimeout(J);
        g.setUseCaches(false);
        g.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f1202b) != null) {
            ((HttpsURLConnection) g).setSSLSocketFactory(sSLSocketFactory);
        }
        return g;
    }

    static void k(HttpURLConnection httpURLConnection, b.a.a.m<?> mVar) {
        String str;
        String str2;
        switch (mVar.A()) {
            case -1:
                byte[] D = mVar.D();
                if (D != null) {
                    httpURLConnection.setRequestMethod("POST");
                    d(httpURLConnection, mVar, D);
                    return;
                }
                return;
            case 0:
                str = "GET";
                httpURLConnection.setRequestMethod(str);
                return;
            case 1:
                httpURLConnection.setRequestMethod("POST");
                e(httpURLConnection, mVar);
                return;
            case 2:
                str2 = "PUT";
                httpURLConnection.setRequestMethod(str2);
                e(httpURLConnection, mVar);
                return;
            case 3:
                str = "DELETE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 4:
                str = "HEAD";
                httpURLConnection.setRequestMethod(str);
                return;
            case 5:
                str = "OPTIONS";
                httpURLConnection.setRequestMethod(str);
                return;
            case 6:
                str = "TRACE";
                httpURLConnection.setRequestMethod(str);
                return;
            case 7:
                str2 = "PATCH";
                httpURLConnection.setRequestMethod(str2);
                e(httpURLConnection, mVar);
                return;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }

    @Override // b.a.a.v.b
    public h b(b.a.a.m<?> mVar, Map<String, String> map) {
        String L = mVar.L();
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.putAll(mVar.z());
        b bVar = this.f1201a;
        if (bVar != null) {
            String a2 = bVar.a(L);
            if (a2 == null) {
                throw new IOException("URL blocked by rewriter: " + L);
            }
            L = a2;
        }
        HttpURLConnection j = j(new URL(L), mVar);
        try {
            for (String str : hashMap.keySet()) {
                j.setRequestProperty(str, (String) hashMap.get(str));
            }
            k(j, mVar);
            int responseCode = j.getResponseCode();
            if (responseCode != -1) {
                if (h(mVar.A(), responseCode)) {
                    return new h(responseCode, f(j.getHeaderFields()), j.getContentLength(), new a(j));
                }
                h hVar = new h(responseCode, f(j.getHeaderFields()));
                j.disconnect();
                return hVar;
            }
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        } catch (Throwable th) {
            if (0 == 0) {
                j.disconnect();
            }
            throw th;
        }
    }

    protected HttpURLConnection g(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }
}
