package b.b;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a extends WebViewClient {
    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        b.f1203c.c("onUrlChanged", hashMap);
        hashMap.put("type", "finishLoad");
        b.f1203c.c("onState", hashMap);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        HashMap hashMap = new HashMap();
        hashMap.put("url", str);
        hashMap.put("type", "startLoad");
        b.f1203c.c("onState", hashMap);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        HashMap hashMap = new HashMap();
        hashMap.put("url", webResourceRequest.getUrl().toString());
        hashMap.put("code", Integer.toString(webResourceResponse.getStatusCode()));
        b.f1203c.c("onHttpError", hashMap);
    }
}
