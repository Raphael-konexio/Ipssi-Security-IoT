package b.a.a.v;

import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
@Deprecated
/* loaded from: classes.dex */
public class f implements i {

    /* renamed from: a  reason: collision with root package name */
    protected final HttpClient f1196a;

    /* loaded from: classes.dex */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public a(String str) {
            setURI(URI.create(str));
        }

        public String getMethod() {
            return "PATCH";
        }
    }

    public f(HttpClient httpClient) {
        this.f1196a = httpClient;
    }

    static HttpUriRequest b(b.a.a.m<?> mVar, Map<String, String> map) {
        switch (mVar.A()) {
            case -1:
                byte[] D = mVar.D();
                if (D != null) {
                    HttpPost httpPost = new HttpPost(mVar.L());
                    httpPost.addHeader("Content-Type", mVar.E());
                    httpPost.setEntity(new ByteArrayEntity(D));
                    return httpPost;
                }
                return new HttpGet(mVar.L());
            case 0:
                return new HttpGet(mVar.L());
            case 1:
                HttpPost httpPost2 = new HttpPost(mVar.L());
                httpPost2.addHeader("Content-Type", mVar.w());
                d(httpPost2, mVar);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(mVar.L());
                httpPut.addHeader("Content-Type", mVar.w());
                d(httpPut, mVar);
                return httpPut;
            case 3:
                return new HttpDelete(mVar.L());
            case 4:
                return new HttpHead(mVar.L());
            case 5:
                return new HttpOptions(mVar.L());
            case 6:
                return new HttpTrace(mVar.L());
            case 7:
                a aVar = new a(mVar.L());
                aVar.addHeader("Content-Type", mVar.w());
                d(aVar, mVar);
                return aVar;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
    }

    private static void d(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, b.a.a.m<?> mVar) {
        byte[] u = mVar.u();
        if (u != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(u));
        }
    }

    private static void e(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, map.get(str));
        }
    }

    @Override // b.a.a.v.i
    public HttpResponse a(b.a.a.m<?> mVar, Map<String, String> map) {
        HttpUriRequest b2 = b(mVar, map);
        e(b2, map);
        e(b2, mVar.z());
        c(b2);
        HttpParams params = b2.getParams();
        int J = mVar.J();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, J);
        return this.f1196a.execute(b2);
    }

    protected void c(HttpUriRequest httpUriRequest) {
    }
}
