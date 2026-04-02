package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
/* loaded from: classes.dex */
public class ExportedProtectedIntent extends androidx.appcompat.app.c {
    private void F(Intent intent) {
        Intent intent2 = (Intent) intent.getParcelableExtra("access_protected_component");
        if (intent2.resolveActivity(getPackageManager()).getPackageName().equals("b3nac.injuredandroid")) {
            startActivity(intent2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void G(View view) {
        Snackbar X = Snackbar.X(view, "Replace with your own action", 0);
        X.Y("Action", null);
        X.N();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exported_protected_intent);
        C((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() { // from class: b3nac.injuredandroid.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExportedProtectedIntent.G(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onResume() {
        super.onResume();
        F(getIntent());
    }
}
