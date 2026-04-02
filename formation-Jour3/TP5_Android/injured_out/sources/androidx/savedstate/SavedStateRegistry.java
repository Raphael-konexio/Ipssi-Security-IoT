package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.savedstate.Recreator;
import java.util.Map;
/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b  reason: collision with root package name */
    private Bundle f1130b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1131c;

    /* renamed from: d  reason: collision with root package name */
    private Recreator.a f1132d;

    /* renamed from: a  reason: collision with root package name */
    private a.b.a.b.b<String, b> f1129a = new a.b.a.b.b<>();
    boolean e = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.f1131c) {
            Bundle bundle = this.f1130b;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                this.f1130b.remove(str);
                if (this.f1130b.isEmpty()) {
                    this.f1130b = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e eVar, Bundle bundle) {
        if (this.f1131c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f1130b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        eVar.a(new h() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.h
            public void d(j jVar, e.a aVar) {
                SavedStateRegistry savedStateRegistry;
                boolean z;
                if (aVar == e.a.ON_START) {
                    savedStateRegistry = SavedStateRegistry.this;
                    z = true;
                } else if (aVar != e.a.ON_STOP) {
                    return;
                } else {
                    savedStateRegistry = SavedStateRegistry.this;
                    z = false;
                }
                savedStateRegistry.e = z;
            }
        });
        this.f1131c = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f1130b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        a.b.a.b.b<String, b>.d g = this.f1129a.g();
        while (g.hasNext()) {
            Map.Entry next = g.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void d(String str, b bVar) {
        if (this.f1129a.m(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void e(Class<? extends a> cls) {
        if (!this.e) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f1132d == null) {
            this.f1132d = new Recreator.a(this);
        }
        try {
            cls.getDeclaredConstructor(new Class[0]);
            this.f1132d.b(cls.getName());
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class" + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
