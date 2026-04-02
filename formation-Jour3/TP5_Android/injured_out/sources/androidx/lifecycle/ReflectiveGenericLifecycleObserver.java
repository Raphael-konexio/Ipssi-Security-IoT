package androidx.lifecycle;

import androidx.lifecycle.a;
import androidx.lifecycle.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Object f872a;

    /* renamed from: b  reason: collision with root package name */
    private final a.C0045a f873b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f872a = obj;
        this.f873b = a.f880c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.h
    public void d(j jVar, e.a aVar) {
        this.f873b.a(jVar, aVar, this.f872a);
    }
}
