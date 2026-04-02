package b3nac.injuredandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.webkit.WebView;
/* loaded from: classes.dex */
public class TestBroadcastReceiver extends androidx.appcompat.app.c {

    /* loaded from: classes.dex */
    private class b extends BroadcastReceiver {
        private b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            ((WebView) TestBroadcastReceiver.this.findViewById(R.id.Bob)).loadUrl(intent.getExtras().getString("url"));
        }
    }

    public void F() {
        Intent intent = new Intent(getApplicationContext(), FlagFiveReceiver.class);
        intent.setAction("com.b3nac.injuredandroid.intent.action.CUSTOM_INTENT");
        intent.putExtra("url", "Hi");
        sendBroadcast(intent);
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerReceiver(new b(), new IntentFilter("com.b3nac.injuredandroid.intent.action.CUSTOM_INTENT"));
        F();
    }
}
