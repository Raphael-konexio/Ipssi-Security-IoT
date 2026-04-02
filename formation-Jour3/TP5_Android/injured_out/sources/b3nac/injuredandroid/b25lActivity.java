package b3nac.injuredandroid;

import android.os.Bundle;
/* loaded from: classes.dex */
public final class b25lActivity extends androidx.appcompat.app.c {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_b25l);
        j.j.a(this);
        new FlagsOverview().M(true);
        new j().b(this, "flagTwoButtonColor", true);
    }
}
