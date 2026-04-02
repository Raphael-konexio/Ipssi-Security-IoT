package b3nac.injuredandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
/* loaded from: classes.dex */
public final class FlagFiveReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f1454a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        int i;
        String e;
        String e2;
        d.s.d.g.e(context, "context");
        d.s.d.g.e(intent, "intent");
        j.j.a(context);
        int i2 = f1454a;
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            e = d.w.h.e("\n    Action: " + intent.getAction() + "\n\n    ");
            sb.append(e);
            e2 = d.w.h.e("\n    URI: " + intent.toUri(1) + "\n\n    ");
            sb.append(e2);
            str = sb.toString();
            d.s.d.g.d(str, "sb.toString()");
            Log.d("DUDE!:", str);
        } else {
            str = "Keep trying!";
            if (i2 != 1) {
                if (i2 != 2) {
                    Toast.makeText(context, "Keep trying!", 1).show();
                    return;
                }
                new FlagsOverview().H(true);
                new j().b(context, "flagFiveButtonColor", true);
                Toast.makeText(context, "You are a winner " + k.a("Zkdlt0WwtLQ="), 1).show();
                i = 0;
                f1454a = i;
            }
        }
        Toast.makeText(context, str, 1).show();
        i = f1454a + 1;
        f1454a = i;
    }
}
