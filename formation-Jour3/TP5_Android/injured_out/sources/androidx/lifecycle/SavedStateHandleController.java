package androidx.lifecycle;

import androidx.lifecycle.e;
import androidx.savedstate.SavedStateRegistry;
/* loaded from: classes.dex */
final class SavedStateHandleController implements h {

    /* renamed from: a  reason: collision with root package name */
    private final String f874a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f875b;

    /* renamed from: c  reason: collision with root package name */
    private final s f876c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements SavedStateRegistry.a {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.a
        public void a(androidx.savedstate.b bVar) {
            if (!(bVar instanceof w)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on componentsthat implement ViewModelStoreOwner");
            }
            v f = ((w) bVar).f();
            SavedStateRegistry j = bVar.j();
            for (String str : f.c()) {
                SavedStateHandleController.h(f.b(str), j, bVar.a());
            }
            if (f.c().isEmpty()) {
                return;
            }
            j.e(a.class);
        }
    }

    static void h(t tVar, SavedStateRegistry savedStateRegistry, e eVar) {
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) tVar.c("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.j()) {
            return;
        }
        savedStateHandleController.i(savedStateRegistry, eVar);
        k(savedStateRegistry, eVar);
    }

    private static void k(final SavedStateRegistry savedStateRegistry, final e eVar) {
        e.b b2 = eVar.b();
        if (b2 == e.b.INITIALIZED || b2.d(e.b.STARTED)) {
            savedStateRegistry.e(a.class);
        } else {
            eVar.a(new h() { // from class: androidx.lifecycle.SavedStateHandleController.1
                @Override // androidx.lifecycle.h
                public void d(j jVar, e.a aVar) {
                    if (aVar == e.a.ON_START) {
                        e.this.c(this);
                        savedStateRegistry.e(a.class);
                    }
                }
            });
        }
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        if (aVar == e.a.ON_DESTROY) {
            this.f875b = false;
            jVar.a().c(this);
        }
    }

    void i(SavedStateRegistry savedStateRegistry, e eVar) {
        if (this.f875b) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.f875b = true;
        eVar.a(this);
        savedStateRegistry.d(this.f874a, this.f876c.a());
    }

    boolean j() {
        return this.f875b;
    }
}
