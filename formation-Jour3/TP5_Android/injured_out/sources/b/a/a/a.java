package b.a.a;

import android.content.Intent;
/* loaded from: classes.dex */
public class a extends t {
    private Intent f;

    public a(k kVar) {
        super(kVar);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f != null ? "User needs to (re)enter credentials." : super.getMessage();
    }
}
