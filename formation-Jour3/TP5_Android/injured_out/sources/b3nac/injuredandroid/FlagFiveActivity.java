package b3nac.injuredandroid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public class FlagFiveActivity extends androidx.appcompat.app.c {
    int w = 0;
    private FlagFiveReceiver x = new FlagFiveReceiver();

    public void F() {
        sendBroadcast(new Intent("com.b3nac.injuredandroid.intent.action.CUSTOM_INTENT"));
    }

    public /* synthetic */ void G(View view) {
        int i = this.w;
        if (i == 0) {
            Snackbar X = Snackbar.X(view, "Where is bob.", 0);
            X.Y("Action", null);
            X.N();
            this.w++;
        } else if (i == 1) {
            Snackbar X2 = Snackbar.X(view, "Classes and imports.", 0);
            X2.Y("Action", null);
            X2.N();
            this.w = 0;
        }
    }

    public /* synthetic */ void H(View view) {
        F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_five);
        C((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() { // from class: b3nac.injuredandroid.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlagFiveActivity.this.G(view);
            }
        });
        new ComponentName(this, FlagFiveReceiver.class);
        getPackageManager();
        a.m.a.a.b(this).c(this.x, new IntentFilter("com.b3nac.injuredandroid.intent.action.CUSTOM_INTENT"));
        ((Button) findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() { // from class: b3nac.injuredandroid.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlagFiveActivity.this.H(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, android.app.Activity
    public void onDestroy() {
        a.m.a.a.b(this).e(this.x);
        super.onDestroy();
    }
}
