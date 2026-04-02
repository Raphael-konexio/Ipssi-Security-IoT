package b.b;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import b.b.c;
import c.a.c.a.h;
import c.a.c.a.i;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private ValueCallback<Uri> f1206a;

    /* renamed from: b  reason: collision with root package name */
    private ValueCallback<Uri[]> f1207b;

    /* renamed from: d  reason: collision with root package name */
    WebView f1209d;

    /* renamed from: c  reason: collision with root package name */
    boolean f1208c = false;
    f e = new f();

    /* loaded from: classes.dex */
    class a implements View.OnKeyListener {
        a() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0 && i == 4) {
                if (d.this.f1209d.canGoBack()) {
                    d.this.f1209d.goBack();
                    return true;
                }
                d.this.h();
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements c.a {
        b(d dVar) {
        }

        @Override // b.b.c.a
        public void a(int i, int i2, int i3, int i4) {
            HashMap hashMap = new HashMap();
            hashMap.put("yDirection", Double.valueOf(i2));
            b.b.b.f1203c.c("onScrollYChanged", hashMap);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("xDirection", Double.valueOf(i));
            b.b.b.f1203c.c("onScrollXChanged", hashMap2);
        }
    }

    /* loaded from: classes.dex */
    class c extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Activity f1210a;

        c(Activity activity) {
            this.f1210a = activity;
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (d.this.f1207b != null) {
                d.this.f1207b.onReceiveValue(null);
            }
            d.this.f1207b = valueCallback;
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("*/*");
            Intent intent2 = new Intent("android.intent.action.CHOOSER");
            intent2.putExtra("android.intent.extra.INTENT", intent);
            intent2.putExtra("android.intent.extra.TITLE", "Image Chooser");
            intent2.putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[0]);
            this.f1210a.startActivityForResult(intent2, 1);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0056d implements ValueCallback<Boolean> {
        C0056d(d dVar) {
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(Boolean bool) {
        }
    }

    /* loaded from: classes.dex */
    class e implements ValueCallback<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i.d f1212a;

        e(d dVar, i.d dVar2) {
            this.f1212a = dVar2;
        }

        @Override // android.webkit.ValueCallback
        /* renamed from: a */
        public void onReceiveValue(String str) {
            this.f1212a.c(str);
        }
    }

    /* loaded from: classes.dex */
    class f {
        f() {
        }

        public boolean a(int i, int i2, Intent intent) {
            String dataString;
            if (Build.VERSION.SDK_INT >= 21) {
                if (i != 1) {
                    return false;
                }
                Uri[] uriArr = (i2 != -1 || (dataString = intent.getDataString()) == null) ? null : new Uri[]{Uri.parse(dataString)};
                if (d.this.f1207b != null) {
                    d.this.f1207b.onReceiveValue(uriArr);
                    d.this.f1207b = null;
                }
            } else if (i != 1) {
                return false;
            } else {
                Uri data = (i2 != -1 || intent == null) ? null : intent.getData();
                if (d.this.f1206a != null) {
                    d.this.f1206a.onReceiveValue(data);
                    d.this.f1206a = null;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Activity activity) {
        this.f1209d = new b.b.c(activity);
        b.b.a aVar = new b.b.a();
        this.f1209d.setOnKeyListener(new a());
        ((b.b.c) this.f1209d).setOnScrollChangedCallback(new b(this));
        this.f1209d.setWebViewClient(aVar);
        this.f1209d.setWebChromeClient(new c(activity));
    }

    private void f() {
        this.f1209d.clearCache(true);
        this.f1209d.clearFormData();
    }

    private void g() {
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().removeAllCookies(new C0056d(this));
        } else {
            CookieManager.getInstance().removeAllCookie();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView == null || !webView.canGoBack()) {
            return;
        }
        this.f1209d.goBack();
    }

    void h() {
        i(null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView != null) {
            ((ViewGroup) webView.getParent()).removeView(this.f1209d);
        }
        this.f1209d = null;
        if (dVar != null) {
            dVar.c(null);
        }
        this.f1208c = true;
        b.b.b.f1203c.c("onDestroy", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(h hVar, i.d dVar) {
        this.f1209d.evaluateJavascript((String) hVar.a("code"), new e(this, dVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView == null || !webView.canGoForward()) {
            return;
        }
        this.f1209d.goForward();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView != null) {
            webView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(boolean z, boolean z2, boolean z3, boolean z4, String str, String str2, Map<String, String> map, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f1209d.getSettings().setJavaScriptEnabled(z);
        this.f1209d.getSettings().setBuiltInZoomControls(z5);
        this.f1209d.getSettings().setSupportZoom(z5);
        this.f1209d.getSettings().setDomStorageEnabled(z6);
        this.f1209d.getSettings().setJavaScriptCanOpenWindowsAutomatically(z8);
        this.f1209d.getSettings().setSupportMultipleWindows(z8);
        this.f1209d.getSettings().setAppCacheEnabled(z9);
        this.f1209d.getSettings().setAllowFileAccessFromFileURLs(z10);
        this.f1209d.getSettings().setAllowUniversalAccessFromFileURLs(z10);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f1209d.getSettings().setMixedContentMode(2);
        }
        if (z2) {
            f();
        }
        if (z3) {
            this.f1209d.setVisibility(4);
        }
        if (z4) {
            g();
        }
        if (str != null) {
            this.f1209d.getSettings().setUserAgentString(str);
        }
        if (!z7) {
            this.f1209d.setVerticalScrollBarEnabled(false);
        }
        WebView webView = this.f1209d;
        if (map != null) {
            webView.loadUrl(str2, map);
        } else {
            webView.loadUrl(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView != null) {
            webView.reload();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(String str) {
        this.f1209d.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(FrameLayout.LayoutParams layoutParams) {
        this.f1209d.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView != null) {
            webView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(h hVar, i.d dVar) {
        WebView webView = this.f1209d;
        if (webView != null) {
            webView.stopLoading();
        }
    }
}
