package b.c.a.a.b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.m;
/* loaded from: classes.dex */
public class j extends androidx.fragment.app.c {
    private Dialog p0 = null;
    private DialogInterface.OnCancelListener q0 = null;

    public static j B1(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        j jVar = new j();
        com.google.android.gms.common.internal.r.i(dialog, "Cannot display null dialog");
        Dialog dialog2 = dialog;
        dialog2.setOnCancelListener(null);
        dialog2.setOnDismissListener(null);
        jVar.p0 = dialog2;
        if (onCancelListener != null) {
            jVar.q0 = onCancelListener;
        }
        return jVar;
    }

    @Override // androidx.fragment.app.c
    public void A1(m mVar, String str) {
        super.A1(mVar, str);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.q0;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    @Override // androidx.fragment.app.c
    public Dialog w1(Bundle bundle) {
        if (this.p0 == null) {
            y1(false);
        }
        return this.p0;
    }
}
