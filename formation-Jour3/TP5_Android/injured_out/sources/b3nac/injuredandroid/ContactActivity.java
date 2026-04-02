package b3nac.injuredandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
/* loaded from: classes.dex */
public class ContactActivity extends androidx.appcompat.app.c {
    public void goToDigitalOcean(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.do.co/c/9348bb7410b4")));
    }

    public void goToEmailAppSelection(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("mailto:b3nac.sec@gmail.com")));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_contact);
    }
}
