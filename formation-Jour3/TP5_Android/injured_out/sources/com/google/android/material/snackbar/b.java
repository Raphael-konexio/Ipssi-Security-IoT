package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class b {
    private static b e;

    /* renamed from: a  reason: collision with root package name */
    private final Object f1825a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Handler f1826b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: c  reason: collision with root package name */
    private c f1827c;

    /* renamed from: d  reason: collision with root package name */
    private c f1828d;

    /* loaded from: classes.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            b.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.snackbar.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0087b {
        void a();

        void b(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final WeakReference<InterfaceC0087b> f1830a;

        /* renamed from: b  reason: collision with root package name */
        int f1831b;

        /* renamed from: c  reason: collision with root package name */
        boolean f1832c;

        c(int i, InterfaceC0087b interfaceC0087b) {
            this.f1830a = new WeakReference<>(interfaceC0087b);
            this.f1831b = i;
        }

        boolean a(InterfaceC0087b interfaceC0087b) {
            return interfaceC0087b != null && this.f1830a.get() == interfaceC0087b;
        }
    }

    private b() {
    }

    private boolean a(c cVar, int i) {
        InterfaceC0087b interfaceC0087b = cVar.f1830a.get();
        if (interfaceC0087b != null) {
            this.f1826b.removeCallbacksAndMessages(cVar);
            interfaceC0087b.b(i);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b c() {
        if (e == null) {
            e = new b();
        }
        return e;
    }

    private boolean f(InterfaceC0087b interfaceC0087b) {
        c cVar = this.f1827c;
        return cVar != null && cVar.a(interfaceC0087b);
    }

    private boolean g(InterfaceC0087b interfaceC0087b) {
        c cVar = this.f1828d;
        return cVar != null && cVar.a(interfaceC0087b);
    }

    private void l(c cVar) {
        int i = cVar.f1831b;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f1826b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f1826b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
    }

    private void n() {
        c cVar = this.f1828d;
        if (cVar != null) {
            this.f1827c = cVar;
            this.f1828d = null;
            InterfaceC0087b interfaceC0087b = cVar.f1830a.get();
            if (interfaceC0087b != null) {
                interfaceC0087b.a();
            } else {
                this.f1827c = null;
            }
        }
    }

    public void b(InterfaceC0087b interfaceC0087b, int i) {
        c cVar;
        synchronized (this.f1825a) {
            if (f(interfaceC0087b)) {
                cVar = this.f1827c;
            } else if (g(interfaceC0087b)) {
                cVar = this.f1828d;
            }
            a(cVar, i);
        }
    }

    void d(c cVar) {
        synchronized (this.f1825a) {
            if (this.f1827c == cVar || this.f1828d == cVar) {
                a(cVar, 2);
            }
        }
    }

    public boolean e(InterfaceC0087b interfaceC0087b) {
        boolean z;
        synchronized (this.f1825a) {
            z = f(interfaceC0087b) || g(interfaceC0087b);
        }
        return z;
    }

    public void h(InterfaceC0087b interfaceC0087b) {
        synchronized (this.f1825a) {
            if (f(interfaceC0087b)) {
                this.f1827c = null;
                if (this.f1828d != null) {
                    n();
                }
            }
        }
    }

    public void i(InterfaceC0087b interfaceC0087b) {
        synchronized (this.f1825a) {
            if (f(interfaceC0087b)) {
                l(this.f1827c);
            }
        }
    }

    public void j(InterfaceC0087b interfaceC0087b) {
        synchronized (this.f1825a) {
            if (f(interfaceC0087b) && !this.f1827c.f1832c) {
                this.f1827c.f1832c = true;
                this.f1826b.removeCallbacksAndMessages(this.f1827c);
            }
        }
    }

    public void k(InterfaceC0087b interfaceC0087b) {
        synchronized (this.f1825a) {
            if (f(interfaceC0087b) && this.f1827c.f1832c) {
                this.f1827c.f1832c = false;
                l(this.f1827c);
            }
        }
    }

    public void m(int i, InterfaceC0087b interfaceC0087b) {
        synchronized (this.f1825a) {
            if (f(interfaceC0087b)) {
                this.f1827c.f1831b = i;
                this.f1826b.removeCallbacksAndMessages(this.f1827c);
                l(this.f1827c);
                return;
            }
            if (g(interfaceC0087b)) {
                this.f1828d.f1831b = i;
            } else {
                this.f1828d = new c(i, interfaceC0087b);
            }
            if (this.f1827c == null || !a(this.f1827c, 4)) {
                this.f1827c = null;
                n();
            }
        }
    }
}
