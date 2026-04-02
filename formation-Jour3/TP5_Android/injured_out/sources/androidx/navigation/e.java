package androidx.navigation;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.savedstate.SavedStateRegistry;
import java.util.UUID;
/* loaded from: classes.dex */
public final class e implements androidx.lifecycle.j, w, androidx.savedstate.b {
    private final j f;
    private Bundle g;
    private final androidx.lifecycle.k h;
    private final androidx.savedstate.a i;
    final UUID j;
    private e.b k;
    private e.b l;
    private g m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f921a;

        static {
            int[] iArr = new int[e.a.values().length];
            f921a = iArr;
            try {
                iArr[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f921a[e.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f921a[e.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f921a[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f921a[e.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f921a[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f921a[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, j jVar, Bundle bundle, androidx.lifecycle.j jVar2, g gVar) {
        this(context, jVar, bundle, jVar2, gVar, UUID.randomUUID(), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Context context, j jVar, Bundle bundle, androidx.lifecycle.j jVar2, g gVar, UUID uuid, Bundle bundle2) {
        this.h = new androidx.lifecycle.k(this);
        androidx.savedstate.a a2 = androidx.savedstate.a.a(this);
        this.i = a2;
        this.k = e.b.CREATED;
        this.l = e.b.RESUMED;
        this.j = uuid;
        this.f = jVar;
        this.g = bundle;
        this.m = gVar;
        a2.c(bundle2);
        if (jVar2 != null) {
            this.k = jVar2.a().b();
        }
    }

    private static e.b e(e.a aVar) {
        switch (a.f921a[aVar.ordinal()]) {
            case 1:
            case 2:
                return e.b.CREATED;
            case 3:
            case 4:
                return e.b.STARTED;
            case 5:
                return e.b.RESUMED;
            case 6:
                return e.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    @Override // androidx.lifecycle.j
    public androidx.lifecycle.e a() {
        return this.h;
    }

    public Bundle b() {
        return this.g;
    }

    public j c() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.b d() {
        return this.l;
    }

    @Override // androidx.lifecycle.w
    public v f() {
        g gVar = this.m;
        if (gVar != null) {
            return gVar.g(this.j);
        }
        throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(e.a aVar) {
        this.k = e(aVar);
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(Bundle bundle) {
        this.g = bundle;
    }

    @Override // androidx.savedstate.b
    public SavedStateRegistry j() {
        return this.i.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Bundle bundle) {
        this.i.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(e.b bVar) {
        this.l = bVar;
        m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        androidx.lifecycle.k kVar;
        e.b bVar;
        if (this.k.ordinal() < this.l.ordinal()) {
            kVar = this.h;
            bVar = this.k;
        } else {
            kVar = this.h;
            bVar = this.l;
        }
        kVar.p(bVar);
    }
}
