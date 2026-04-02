package b3nac.injuredandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import io.flutter.embedding.android.FlutterActivity;
/* loaded from: classes.dex */
public final class MainActivity extends androidx.appcompat.app.c {
    private int w;

    private final void F() {
        Intent intent = getIntent();
        d.s.d.g.d(intent, "intent");
        Uri data = intent.getData();
        if (data == null) {
            return;
        }
        if (d.s.d.g.a(data.getScheme(), "flag11")) {
            startActivity(new Intent(this, DeepLinkActivity.class));
        }
        if (d.s.d.g.a(data.getScheme(), "flag13")) {
            startActivity(new Intent(this, RCEActivity.class));
        }
    }

    public final void goToFlagEightLoginActivity(View view) {
        startActivity(new Intent(this, FlagEightLoginActivity.class));
    }

    public final void goToFlagEighteenActivity(View view) {
        startActivity(new Intent(this, FlagEighteenActivity.class));
    }

    public final void goToFlagElevenDeeplinkActivity(View view) {
        int i;
        int i2 = this.w;
        if (i2 == 0) {
            Toast.makeText(getApplicationContext(), "Exploit the schema!", 1).show();
            i = this.w + 1;
        } else if (i2 != 1) {
            return;
        } else {
            Toast.makeText(getApplicationContext(), "Check the Manifest!", 1).show();
            i = 0;
        }
        this.w = i;
    }

    public final void goToFlagFifteenActivity(View view) {
        startActivity(new Intent(this, AssemblyActivity.class));
    }

    public final void goToFlagFiveReceiver(View view) {
        startActivity(new Intent(this, TestBroadcastReceiver.class));
    }

    public final void goToFlagFlagsOverview(View view) {
        startActivity(new Intent(this, FlagsOverview.class));
    }

    public final void goToFlagFourLogin(View view) {
        startActivity(new Intent(this, FlagFourActivity.class));
    }

    public final void goToFlagFourteenActivity(View view) {
        FlutterActivity.a M = FlutterActivity.M();
        M.b("splashRoute");
        startActivity(M.a(this));
    }

    public final void goToFlagNineFirebaseActivity(View view) {
        startActivity(new Intent(this, FlagNineFirebaseActivity.class));
    }

    public final void goToFlagOneLogin(View view) {
        startActivity(new Intent(this, FlagOneLoginActivity.class));
    }

    public final void goToFlagSevenSqliteActivity(View view) {
        startActivity(new Intent(this, FlagSevenSqliteActivity.class));
    }

    public final void goToFlagSeventeenActivity(View view) {
        startActivity(new Intent(this, FlagSeventeenActivity.class));
    }

    public final void goToFlagSixLoginActivity(View view) {
        startActivity(new Intent(this, FlagSixLoginActivity.class));
    }

    public final void goToFlagSixteenActivity(View view) {
        startActivity(new Intent(this, CSPBypassActivity.class));
    }

    public final void goToFlagTenUnicodeActivity(View view) {
        startActivity(new Intent(this, FlagTenUnicodeActivity.class));
    }

    public final void goToFlagThirteenActivity(View view) {
        startActivity(new Intent(this, RCEActivity.class));
    }

    public final void goToFlagThreeResources(View view) {
        startActivity(new Intent(this, FlagThreeActivity.class));
    }

    public final void goToFlagTwelveProtectedActivity(View view) {
        Context applicationContext;
        String str;
        int i;
        int i2 = this.w;
        if (i2 == 0) {
            applicationContext = getApplicationContext();
            str = "Use an exported activity!";
        } else if (i2 != 1) {
            if (i2 != 2) {
                return;
            }
            Toast.makeText(getApplicationContext(), "Check my Youtube :)", 1).show();
            i = 0;
            this.w = i;
        } else {
            applicationContext = getApplicationContext();
            str = "A PoC app is needed!";
        }
        Toast.makeText(applicationContext, str, 1).show();
        i = this.w + 1;
        this.w = i;
    }

    public final void goToFlagTwoBypass(View view) {
        startActivity(new Intent(this, FlagTwoActivity.class));
    }

    public final void goToXSSText(View view) {
        startActivity(new Intent(this, XSSTextActivity.class));
    }

    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        F();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        d.s.d.g.e(menu, "menu");
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        d.s.d.g.e(menuItem, "item");
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_home) {
            startActivity(new Intent(this, MainActivity.class));
        }
        if (itemId == R.id.action_contact) {
            startActivity(new Intent(this, ContactActivity.class));
        }
        if (itemId == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        return true;
    }
}
