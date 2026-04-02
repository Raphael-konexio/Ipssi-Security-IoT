package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f1134a;

    /* renamed from: b  reason: collision with root package name */
    private final SavedStateRegistry f1135b = new SavedStateRegistry();

    private a(b bVar) {
        this.f1134a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f1135b;
    }

    public void c(Bundle bundle) {
        e a2 = this.f1134a.a();
        if (a2.b() != e.b.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        a2.a(new Recreator(this.f1134a));
        this.f1135b.b(a2, bundle);
    }

    public void d(Bundle bundle) {
        this.f1135b.c(bundle);
    }
}
