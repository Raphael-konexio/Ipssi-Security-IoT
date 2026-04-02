package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
/* loaded from: classes.dex */
public final class FlagTwelveProtectedActivity extends androidx.appcompat.app.c {
    private final void F() {
        startActivity(new Intent(this, FlagOneSuccess.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        setContentView(webView);
        j.j.a(this);
        C((Toolbar) findViewById(R.id.toolbar));
        Uri parse = Uri.parse(getIntent().getStringExtra("totally_secure"));
        WebSettings settings = webView.getSettings();
        d.s.d.g.d(settings, "flagWebView.settings");
        settings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        if (getIntent() == null || !getIntent().hasExtra("totally_secure")) {
            finish();
            return;
        }
        d.s.d.g.d(parse, "uri");
        if (!d.s.d.g.a("https", parse.getScheme())) {
            webView.loadData(getIntent().getStringExtra("totally_secure"), "text/html", "UTF-8");
            return;
        }
        FlagsOverview.K = true;
        j jVar = new j();
        Context applicationContext = getApplicationContext();
        d.s.d.g.d(applicationContext, "applicationContext");
        jVar.b(applicationContext, "flagTwelveButtonColor", true);
        F();
    }
}
