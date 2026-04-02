package b3nac.injuredandroid;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
/* loaded from: classes.dex */
public class SettingsActivity extends androidx.appcompat.app.c {
    public void clearFlags(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("b3nac.injuredandroid", 0);
        SharedPreferences sharedPreferences2 = getSharedPreferences("FlutterSharedPreferences", 0);
        SharedPreferences sharedPreferences3 = getSharedPreferences("b3nac.injuredandroid.encrypted", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        SharedPreferences.Editor edit3 = sharedPreferences3.edit();
        edit.clear();
        edit.apply();
        edit2.clear();
        edit2.apply();
        edit3.clear();
        edit3.apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_settings);
        ((Switch) findViewById(R.id.switch1)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: b3nac.injuredandroid.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                androidx.appcompat.app.e.E(r1 ? 2 : 1);
            }
        });
    }
}
