package a.g.h;

import a.g.h.e;
import a.g.h.f;
import android.graphics.Typeface;
import android.os.Handler;
/* loaded from: classes.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private final f.c f154a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f155b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0005a implements Runnable {
        final /* synthetic */ f.c f;
        final /* synthetic */ Typeface g;

        RunnableC0005a(a aVar, f.c cVar, Typeface typeface) {
            this.f = cVar;
            this.g = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.b(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        final /* synthetic */ f.c f;
        final /* synthetic */ int g;

        b(a aVar, f.c cVar, int i) {
            this.f = cVar;
            this.g = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.a(this.g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f.c cVar, Handler handler) {
        this.f154a = cVar;
        this.f155b = handler;
    }

    private void a(int i) {
        this.f155b.post(new b(this, this.f154a, i));
    }

    private void c(Typeface typeface) {
        this.f155b.post(new RunnableC0005a(this, this.f154a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.C0006e c0006e) {
        if (c0006e.a()) {
            c(c0006e.f175a);
        } else {
            a(c0006e.f176b);
        }
    }
}
