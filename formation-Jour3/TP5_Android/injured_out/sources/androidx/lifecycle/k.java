package androidx.lifecycle;

import androidx.lifecycle.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends e {

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<j> f891c;

    /* renamed from: a  reason: collision with root package name */
    private a.b.a.b.a<i, b> f889a = new a.b.a.b.a<>();

    /* renamed from: d  reason: collision with root package name */
    private int f892d = 0;
    private boolean e = false;
    private boolean f = false;
    private ArrayList<e.b> g = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private e.b f890b = e.b.INITIALIZED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f893a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f894b;

        static {
            int[] iArr = new int[e.b.values().length];
            f894b = iArr;
            try {
                iArr[e.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f894b[e.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f894b[e.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f894b[e.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f894b[e.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[e.a.values().length];
            f893a = iArr2;
            try {
                iArr2[e.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f893a[e.a.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f893a[e.a.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f893a[e.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f893a[e.a.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f893a[e.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f893a[e.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        e.b f895a;

        /* renamed from: b  reason: collision with root package name */
        h f896b;

        b(i iVar, e.b bVar) {
            this.f896b = m.f(iVar);
            this.f895a = bVar;
        }

        void a(j jVar, e.a aVar) {
            e.b h = k.h(aVar);
            this.f895a = k.l(this.f895a, h);
            this.f896b.d(jVar, aVar);
            this.f895a = h;
        }
    }

    public k(j jVar) {
        this.f891c = new WeakReference<>(jVar);
    }

    private void d(j jVar) {
        Iterator<Map.Entry<i, b>> d2 = this.f889a.d();
        while (d2.hasNext() && !this.f) {
            Map.Entry<i, b> next = d2.next();
            b value = next.getValue();
            while (value.f895a.compareTo(this.f890b) > 0 && !this.f && this.f889a.contains(next.getKey())) {
                e.a f = f(value.f895a);
                o(h(f));
                value.a(jVar, f);
                n();
            }
        }
    }

    private e.b e(i iVar) {
        Map.Entry<i, b> u = this.f889a.u(iVar);
        e.b bVar = null;
        e.b bVar2 = u != null ? u.getValue().f895a : null;
        if (!this.g.isEmpty()) {
            ArrayList<e.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return l(l(this.f890b, bVar2), bVar);
    }

    private static e.a f(e.b bVar) {
        int i = a.f894b[bVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            throw new IllegalArgumentException("Unexpected state value " + bVar);
                        }
                        throw new IllegalArgumentException();
                    }
                    return e.a.ON_PAUSE;
                }
                return e.a.ON_STOP;
            }
            return e.a.ON_DESTROY;
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void g(j jVar) {
        a.b.a.b.b<i, b>.d g = this.f889a.g();
        while (g.hasNext() && !this.f) {
            Map.Entry next = g.next();
            b bVar = (b) next.getValue();
            while (bVar.f895a.compareTo(this.f890b) < 0 && !this.f && this.f889a.contains(next.getKey())) {
                o(bVar.f895a);
                bVar.a(jVar, r(bVar.f895a));
                n();
            }
        }
    }

    static e.b h(e.a aVar) {
        switch (a.f893a[aVar.ordinal()]) {
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

    private boolean j() {
        if (this.f889a.size() == 0) {
            return true;
        }
        e.b bVar = this.f889a.e().getValue().f895a;
        e.b bVar2 = this.f889a.i().getValue().f895a;
        return bVar == bVar2 && this.f890b == bVar2;
    }

    static e.b l(e.b bVar, e.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    private void m(e.b bVar) {
        if (this.f890b == bVar) {
            return;
        }
        this.f890b = bVar;
        if (this.e || this.f892d != 0) {
            this.f = true;
            return;
        }
        this.e = true;
        q();
        this.e = false;
    }

    private void n() {
        ArrayList<e.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    private void o(e.b bVar) {
        this.g.add(bVar);
    }

    private void q() {
        j jVar = this.f891c.get();
        if (jVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean j = j();
            this.f = false;
            if (j) {
                return;
            }
            if (this.f890b.compareTo(this.f889a.e().getValue().f895a) < 0) {
                d(jVar);
            }
            Map.Entry<i, b> i = this.f889a.i();
            if (!this.f && i != null && this.f890b.compareTo(i.getValue().f895a) > 0) {
                g(jVar);
            }
        }
    }

    private static e.a r(e.b bVar) {
        int i = a.f894b[bVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return e.a.ON_START;
            }
            if (i == 3) {
                return e.a.ON_RESUME;
            }
            if (i == 4) {
                throw new IllegalArgumentException();
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unexpected state value " + bVar);
            }
        }
        return e.a.ON_CREATE;
    }

    @Override // androidx.lifecycle.e
    public void a(i iVar) {
        j jVar;
        e.b bVar = this.f890b;
        e.b bVar2 = e.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = e.b.INITIALIZED;
        }
        b bVar3 = new b(iVar, bVar2);
        if (this.f889a.m(iVar, bVar3) == null && (jVar = this.f891c.get()) != null) {
            boolean z = this.f892d != 0 || this.e;
            e.b e = e(iVar);
            this.f892d++;
            while (bVar3.f895a.compareTo(e) < 0 && this.f889a.contains(iVar)) {
                o(bVar3.f895a);
                bVar3.a(jVar, r(bVar3.f895a));
                n();
                e = e(iVar);
            }
            if (!z) {
                q();
            }
            this.f892d--;
        }
    }

    @Override // androidx.lifecycle.e
    public e.b b() {
        return this.f890b;
    }

    @Override // androidx.lifecycle.e
    public void c(i iVar) {
        this.f889a.s(iVar);
    }

    public void i(e.a aVar) {
        m(h(aVar));
    }

    @Deprecated
    public void k(e.b bVar) {
        p(bVar);
    }

    public void p(e.b bVar) {
        m(bVar);
    }
}
