package a.e.a.j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f113a;

    /* renamed from: b  reason: collision with root package name */
    int f114b;

    /* renamed from: c  reason: collision with root package name */
    int f115c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f116d;
    public final int[] e;
    List<f> f;
    List<f> g;
    HashSet<f> h;
    HashSet<f> i;
    List<f> j;
    List<f> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list) {
        this.f114b = -1;
        this.f115c = -1;
        this.f116d = false;
        this.e = new int[]{-1, -1};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f113a = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(List<f> list, boolean z) {
        this.f114b = -1;
        this.f115c = -1;
        this.f116d = false;
        this.e = new int[]{-1, -1};
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new HashSet<>();
        this.i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f113a = list;
        this.f116d = z;
    }

    private void e(ArrayList<f> arrayList, f fVar) {
        if (fVar.d0) {
            return;
        }
        arrayList.add(fVar);
        fVar.d0 = true;
        if (fVar.L()) {
            return;
        }
        if (fVar instanceof j) {
            j jVar = (j) fVar;
            int i = jVar.l0;
            for (int i2 = 0; i2 < i; i2++) {
                e(arrayList, jVar.k0[i2]);
            }
        }
        int length = fVar.A.length;
        for (int i3 = 0; i3 < length; i3++) {
            e eVar = fVar.A[i3].f105d;
            if (eVar != null) {
                f fVar2 = eVar.f103b;
                if (eVar != null && fVar2 != fVar.u()) {
                    e(arrayList, fVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f(a.e.a.j.f r7) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.e.a.j.h.f(a.e.a.j.f):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(f fVar, int i) {
        HashSet<f> hashSet;
        if (i == 0) {
            hashSet = this.h;
        } else if (i != 1) {
            return;
        } else {
            hashSet = this.i;
        }
        hashSet.add(fVar);
    }

    public List<f> b(int i) {
        if (i == 0) {
            return this.f;
        }
        if (i == 1) {
            return this.g;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<f> c(int i) {
        if (i == 0) {
            return this.h;
        }
        if (i == 1) {
            return this.i;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<f> d() {
        if (this.j.isEmpty()) {
            int size = this.f113a.size();
            for (int i = 0; i < size; i++) {
                f fVar = this.f113a.get(i);
                if (!fVar.b0) {
                    e((ArrayList) this.j, fVar);
                }
            }
            this.k.clear();
            this.k.addAll(this.f113a);
            this.k.removeAll(this.j);
            return this.j;
        }
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            f(this.k.get(i));
        }
    }
}
