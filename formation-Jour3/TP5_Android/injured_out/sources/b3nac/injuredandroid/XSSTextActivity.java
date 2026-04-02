package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
public class XSSTextActivity extends androidx.appcompat.app.c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_xsstext);
    }

    public void submitText(View view) {
        Intent intent = new Intent(this, DisplayPostXSS.class);
        intent.putExtra("com.b3nac.injuredandroid.DisplayPostXSS", ((EditText) findViewById(R.id.editText)).getText().toString());
        startActivity(intent);
    }
}
