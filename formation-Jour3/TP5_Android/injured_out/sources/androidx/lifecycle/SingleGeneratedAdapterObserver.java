package androidx.lifecycle;

import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements h {

    /* renamed from: a  reason: collision with root package name */
    private final d f879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingleGeneratedAdapterObserver(d dVar) {
        this.f879a = dVar;
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        this.f879a.a(jVar, aVar, false, null);
        this.f879a.a(jVar, aVar, true, null);
    }
}
