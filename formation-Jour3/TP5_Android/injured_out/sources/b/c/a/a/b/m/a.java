package b.c.a.a.b.m;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1229a;

    public a(Context context) {
        this.f1229a = context;
    }

    public ApplicationInfo a(String str, int i) {
        return this.f1229a.getPackageManager().getApplicationInfo(str, i);
    }

    public CharSequence b(String str) {
        return this.f1229a.getPackageManager().getApplicationLabel(this.f1229a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo c(String str, int i) {
        return this.f1229a.getPackageManager().getPackageInfo(str, i);
    }
}
