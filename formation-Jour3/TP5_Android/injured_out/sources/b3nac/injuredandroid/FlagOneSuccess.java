package b3nac.injuredandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
/* loaded from: classes.dex */
public final class FlagOneSuccess extends androidx.appcompat.app.c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_flag_one_success);
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
