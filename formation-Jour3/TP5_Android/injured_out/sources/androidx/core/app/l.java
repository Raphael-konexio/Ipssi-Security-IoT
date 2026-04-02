package androidx.core.app;

import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import java.util.Set;
/* loaded from: classes.dex */
public final class l {
    static RemoteInput a(l lVar) {
        Set<String> d2;
        RemoteInput.Builder addExtras = new RemoteInput.Builder(lVar.i()).setLabel(lVar.h()).setChoices(lVar.e()).setAllowFreeFormInput(lVar.c()).addExtras(lVar.g());
        if (Build.VERSION.SDK_INT >= 26 && (d2 = lVar.d()) != null) {
            for (String str : d2) {
                addExtras.setAllowDataType(str, true);
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            addExtras.setEditChoicesBeforeSending(lVar.f());
        }
        return addExtras.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RemoteInput[] b(l[] lVarArr) {
        if (lVarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[lVarArr.length];
        for (int i = 0; i < lVarArr.length; i++) {
            remoteInputArr[i] = a(lVarArr[i]);
        }
        return remoteInputArr;
    }

    public abstract boolean c();

    public abstract Set<String> d();

    public abstract CharSequence[] e();

    public abstract int f();

    public abstract Bundle g();

    public abstract CharSequence h();

    public abstract String i();
}
