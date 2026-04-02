package b3nac.injuredandroid;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
/* loaded from: classes.dex */
public final class DisplayPostXSS extends androidx.appcompat.app.c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        setContentView(webView);
        String stringExtra = getIntent().getStringExtra("com.b3nac.injuredandroid.DisplayPostXSS");
        WebSettings settings = webView.getSettings();
        d.s.d.g.d(settings, "vulnWebView.settings");
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadData(stringExtra, "text/html", "UTF-8");
    }
}
