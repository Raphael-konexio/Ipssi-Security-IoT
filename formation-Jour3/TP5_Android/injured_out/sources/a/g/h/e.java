package a.g.h;

import a.g.h.f;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    static final a.d.e<String, Typeface> f161a = new a.d.e<>(16);

    /* renamed from: b  reason: collision with root package name */
    private static final ExecutorService f162b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c  reason: collision with root package name */
    static final Object f163c = new Object();

    /* renamed from: d  reason: collision with root package name */
    static final a.d.g<String, ArrayList<a.g.j.a<C0006e>>> f164d = new a.d.g<>();

    /* loaded from: classes.dex */
    class a implements Callable<C0006e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f165a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f166b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.g.h.d f167c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f168d;

        a(String str, Context context, a.g.h.d dVar, int i) {
            this.f165a = str;
            this.f166b = context;
            this.f167c = dVar;
            this.f168d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0006e call() {
            return e.c(this.f165a, this.f166b, this.f167c, this.f168d);
        }
    }

    /* loaded from: classes.dex */
    class b implements a.g.j.a<C0006e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a.g.h.a f169a;

        b(a.g.h.a aVar) {
            this.f169a = aVar;
        }

        @Override // a.g.j.a
        /* renamed from: b */
        public void a(C0006e c0006e) {
            this.f169a.b(c0006e);
        }
    }

    /* loaded from: classes.dex */
    class c implements Callable<C0006e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f170a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f171b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a.g.h.d f172c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f173d;

        c(String str, Context context, a.g.h.d dVar, int i) {
            this.f170a = str;
            this.f171b = context;
            this.f172c = dVar;
            this.f173d = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public C0006e call() {
            return e.c(this.f170a, this.f171b, this.f172c, this.f173d);
        }
    }

    /* loaded from: classes.dex */
    class d implements a.g.j.a<C0006e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f174a;

        d(String str) {
            this.f174a = str;
        }

        @Override // a.g.j.a
        /* renamed from: b */
        public void a(C0006e c0006e) {
            synchronized (e.f163c) {
                ArrayList<a.g.j.a<C0006e>> arrayList = e.f164d.get(this.f174a);
                if (arrayList == null) {
                    return;
                }
                e.f164d.remove(this.f174a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).a(c0006e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.g.h.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0006e {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f175a;

        /* renamed from: b  reason: collision with root package name */
        final int f176b;

        C0006e(int i) {
            this.f175a = null;
            this.f176b = i;
        }

        C0006e(Typeface typeface) {
            this.f175a = typeface;
            this.f176b = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f176b == 0;
        }
    }

    private static String a(a.g.h.d dVar, int i) {
        return dVar.d() + "-" + i;
    }

    private static int b(f.a aVar) {
        int i = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b2 = aVar.b();
        if (b2 != null && b2.length != 0) {
            i = 0;
            for (f.b bVar : b2) {
                int b3 = bVar.b();
                if (b3 != 0) {
                    if (b3 < 0) {
                        return -3;
                    }
                    return b3;
                }
            }
        }
        return i;
    }

    static C0006e c(String str, Context context, a.g.h.d dVar, int i) {
        Typeface c2 = f161a.c(str);
        if (c2 != null) {
            return new C0006e(c2);
        }
        try {
            f.a d2 = a.g.h.c.d(context, dVar, null);
            int b2 = b(d2);
            if (b2 != 0) {
                return new C0006e(b2);
            }
            Typeface b3 = a.g.d.d.b(context, null, d2.b(), i);
            if (b3 != null) {
                f161a.d(str, b3);
                return new C0006e(b3);
            }
            return new C0006e(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0006e(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface d(Context context, a.g.h.d dVar, int i, Executor executor, a.g.h.a aVar) {
        String a2 = a(dVar, i);
        Typeface c2 = f161a.c(a2);
        if (c2 != null) {
            aVar.b(new C0006e(c2));
            return c2;
        }
        b bVar = new b(aVar);
        synchronized (f163c) {
            ArrayList<a.g.j.a<C0006e>> arrayList = f164d.get(a2);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList<a.g.j.a<C0006e>> arrayList2 = new ArrayList<>();
            arrayList2.add(bVar);
            f164d.put(a2, arrayList2);
            c cVar = new c(a2, context, dVar, i);
            if (executor == null) {
                executor = f162b;
            }
            g.b(executor, cVar, new d(a2));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface e(Context context, a.g.h.d dVar, a.g.h.a aVar, int i, int i2) {
        String a2 = a(dVar, i);
        Typeface c2 = f161a.c(a2);
        if (c2 != null) {
            aVar.b(new C0006e(c2));
            return c2;
        } else if (i2 == -1) {
            C0006e c3 = c(a2, context, dVar, i);
            aVar.b(c3);
            return c3.f175a;
        } else {
            try {
                C0006e c0006e = (C0006e) g.c(f162b, new a(a2, context, dVar, i), i2);
                aVar.b(c0006e);
                return c0006e.f175a;
            } catch (InterruptedException unused) {
                aVar.b(new C0006e(-3));
                return null;
            }
        }
    }
}
