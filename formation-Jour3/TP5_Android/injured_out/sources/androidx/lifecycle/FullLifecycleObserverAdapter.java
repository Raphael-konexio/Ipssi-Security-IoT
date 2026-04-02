package androidx.lifecycle;

import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements h {

    /* renamed from: a  reason: collision with root package name */
    private final c f856a;

    /* renamed from: b  reason: collision with root package name */
    private final h f857b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f858a;

        static {
            int[] iArr = new int[e.a.values().length];
            f858a = iArr;
            try {
                iArr[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f858a[e.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f858a[e.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f858a[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f858a[e.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f858a[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f858a[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FullLifecycleObserverAdapter(c cVar, h hVar) {
        this.f856a = cVar;
        this.f857b = hVar;
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        switch (a.f858a[aVar.ordinal()]) {
            case 1:
                this.f856a.c(jVar);
                break;
            case 2:
                this.f856a.f(jVar);
                break;
            case 3:
                this.f856a.a(jVar);
                break;
            case 4:
                this.f856a.e(jVar);
                break;
            case 5:
                this.f856a.g(jVar);
                break;
            case 6:
                this.f856a.b(jVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        h hVar = this.f857b;
        if (hVar != null) {
            hVar.d(jVar, aVar);
        }
    }
}
