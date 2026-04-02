package androidx.lifecycle;

import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements h {

    /* renamed from: a  reason: collision with root package name */
    private final d[] f855a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CompositeGeneratedAdaptersObserver(d[] dVarArr) {
        this.f855a = dVarArr;
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        n nVar = new n();
        for (d dVar : this.f855a) {
            dVar.a(jVar, aVar, false, nVar);
        }
        for (d dVar2 : this.f855a) {
            dVar2.a(jVar, aVar, true, nVar);
        }
    }
}
