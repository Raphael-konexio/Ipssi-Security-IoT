package a.g.h;

import a.g.j.i;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
/* loaded from: classes.dex */
public class f {

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f177a;

        /* renamed from: b  reason: collision with root package name */
        private final b[] f178b;

        @Deprecated
        public a(int i, b[] bVarArr) {
            this.f177a = i;
            this.f178b = bVarArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static a a(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }

        public b[] b() {
            return this.f178b;
        }

        public int c() {
            return this.f177a;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f179a;

        /* renamed from: b  reason: collision with root package name */
        private final int f180b;

        /* renamed from: c  reason: collision with root package name */
        private final int f181c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f182d;
        private final int e;

        @Deprecated
        public b(Uri uri, int i, int i2, boolean z, int i3) {
            i.c(uri);
            this.f179a = uri;
            this.f180b = i;
            this.f181c = i2;
            this.f182d = z;
            this.e = i3;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static b a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.f180b;
        }

        public Uri d() {
            return this.f179a;
        }

        public int e() {
            return this.f181c;
        }

        public boolean f() {
            return this.f182d;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public abstract void a(int i);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, d dVar, int i, boolean z, int i2, Handler handler, c cVar) {
        a.g.h.a aVar = new a.g.h.a(cVar, handler);
        return z ? e.e(context, dVar, aVar, i, i2) : e.d(context, dVar, i, null, aVar);
    }
}
