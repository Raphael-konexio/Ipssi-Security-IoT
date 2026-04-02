package b.a.a.v;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes.dex */
class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private final i f1180a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(i iVar) {
        this.f1180a = iVar;
    }

    @Override // b.a.a.v.b
    public h b(b.a.a.m<?> mVar, Map<String, String> map) {
        try {
            HttpResponse a2 = this.f1180a.a(mVar, map);
            int statusCode = a2.getStatusLine().getStatusCode();
            Header[] allHeaders = a2.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new b.a.a.g(header.getName(), header.getValue()));
            }
            if (a2.getEntity() == null) {
                return new h(statusCode, arrayList);
            }
            long contentLength = a2.getEntity().getContentLength();
            if (((int) contentLength) == contentLength) {
                return new h(statusCode, arrayList, (int) a2.getEntity().getContentLength(), a2.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
