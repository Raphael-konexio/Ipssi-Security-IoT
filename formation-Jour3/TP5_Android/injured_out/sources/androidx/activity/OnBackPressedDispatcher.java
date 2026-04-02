package androidx.activity;

import androidx.lifecycle.e;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import java.util.ArrayDeque;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f463a;

    /* renamed from: b  reason: collision with root package name */
    final ArrayDeque<b> f464b = new ArrayDeque<>();

    /* loaded from: classes.dex */
    private class LifecycleOnBackPressedCancellable implements h, androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final e f465a;

        /* renamed from: b  reason: collision with root package name */
        private final b f466b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.activity.a f467c;

        LifecycleOnBackPressedCancellable(e eVar, b bVar) {
            this.f465a = eVar;
            this.f466b = bVar;
            eVar.a(this);
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f465a.c(this);
            this.f466b.e(this);
            androidx.activity.a aVar = this.f467c;
            if (aVar != null) {
                aVar.cancel();
                this.f467c = null;
            }
        }

        @Override // androidx.lifecycle.h
        public void d(j jVar, e.a aVar) {
            if (aVar == e.a.ON_START) {
                this.f467c = OnBackPressedDispatcher.this.b(this.f466b);
            } else if (aVar != e.a.ON_STOP) {
                if (aVar == e.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar2 = this.f467c;
                if (aVar2 != null) {
                    aVar2.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements androidx.activity.a {

        /* renamed from: a  reason: collision with root package name */
        private final b f469a;

        a(b bVar) {
            this.f469a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f464b.remove(this.f469a);
            this.f469a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f463a = runnable;
    }

    public void a(j jVar, b bVar) {
        e a2 = jVar.a();
        if (a2.b() == e.b.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(a2, bVar));
    }

    androidx.activity.a b(b bVar) {
        this.f464b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator<b> descendingIterator = this.f464b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b next = descendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f463a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
