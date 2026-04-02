package a.l.a;

import a.d.h;
import a.l.b.a;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.j;
import androidx.lifecycle.o;
import androidx.lifecycle.p;
import androidx.lifecycle.t;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends a.l.a.a {

    /* renamed from: c  reason: collision with root package name */
    static boolean f307c = false;

    /* renamed from: a  reason: collision with root package name */
    private final j f308a;

    /* renamed from: b  reason: collision with root package name */
    private final c f309b;

    /* loaded from: classes.dex */
    public static class a<D> extends o<D> implements a.InterfaceC0021a<D> {
        private final int j;
        private final Bundle k;
        private final a.l.b.a<D> l;
        private j m;
        private C0020b<D> n;
        private a.l.b.a<D> o;

        @Override // androidx.lifecycle.LiveData
        protected void g() {
            if (b.f307c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.l.f();
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        protected void h() {
            if (b.f307c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.l.g();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void i(p<? super D> pVar) {
            super.i(pVar);
            this.m = null;
            this.n = null;
        }

        @Override // androidx.lifecycle.o, androidx.lifecycle.LiveData
        public void j(D d2) {
            super.j(d2);
            a.l.b.a<D> aVar = this.o;
            if (aVar != null) {
                aVar.e();
                this.o = null;
            }
        }

        a.l.b.a<D> k(boolean z) {
            if (b.f307c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.l.b();
            this.l.a();
            C0020b<D> c0020b = this.n;
            if (c0020b != null) {
                i(c0020b);
                if (z) {
                    c0020b.d();
                }
            }
            this.l.h(this);
            if ((c0020b == null || c0020b.c()) && !z) {
                return this.l;
            }
            this.l.e();
            return this.o;
        }

        public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.j);
            printWriter.print(" mArgs=");
            printWriter.println(this.k);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.l);
            a.l.b.a<D> aVar = this.l;
            aVar.d(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.n != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.n);
                C0020b<D> c0020b = this.n;
                c0020b.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m().c(d()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(e());
        }

        a.l.b.a<D> m() {
            return this.l;
        }

        void n() {
            j jVar = this.m;
            C0020b<D> c0020b = this.n;
            if (jVar == null || c0020b == null) {
                return;
            }
            super.i(c0020b);
            f(jVar, c0020b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.j);
            sb.append(" : ");
            a.g.j.b.a(this.l, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.l.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0020b<D> implements p<D> {
        public abstract void b(String str, PrintWriter printWriter);

        abstract boolean c();

        abstract void d();
    }

    /* loaded from: classes.dex */
    static class c extends t {

        /* renamed from: c  reason: collision with root package name */
        private static final u.a f310c = new a();

        /* renamed from: b  reason: collision with root package name */
        private h<a> f311b = new h<>();

        /* loaded from: classes.dex */
        static class a implements u.a {
            a() {
            }

            @Override // androidx.lifecycle.u.a
            public <T extends t> T a(Class<T> cls) {
                return new c();
            }
        }

        c() {
        }

        static c f(v vVar) {
            return (c) new u(vVar, f310c).a(c.class);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.t
        public void d() {
            super.d();
            int l = this.f311b.l();
            for (int i = 0; i < l; i++) {
                this.f311b.m(i).k(true);
            }
            this.f311b.b();
        }

        public void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f311b.l() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f311b.l(); i++) {
                    a m = this.f311b.m(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f311b.h(i));
                    printWriter.print(": ");
                    printWriter.println(m.toString());
                    m.l(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void g() {
            int l = this.f311b.l();
            for (int i = 0; i < l; i++) {
                this.f311b.m(i).n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(j jVar, v vVar) {
        this.f308a = jVar;
        this.f309b = c.f(vVar);
    }

    @Override // a.l.a.a
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f309b.e(str, fileDescriptor, printWriter, strArr);
    }

    @Override // a.l.a.a
    public void c() {
        this.f309b.g();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a.g.j.b.a(this.f308a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
