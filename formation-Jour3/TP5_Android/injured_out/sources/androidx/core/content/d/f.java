package androidx.core.content.d;

import a.g.j.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f748a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<b, SparseArray<a>> f749b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f750c = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f751a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f752b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f751a = colorStateList;
            this.f752b = configuration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Resources f753a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f754b;

        b(Resources resources, Resources.Theme theme) {
            this.f753a = resources;
            this.f754b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f753a.equals(bVar.f753a) && a.g.j.d.a(this.f754b, bVar.f754b);
        }

        public int hashCode() {
            return a.g.j.d.b(this.f753a, this.f754b);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            final /* synthetic */ Typeface f;

            a(Typeface typeface) {
                this.f = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e(this.f);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements Runnable {
            final /* synthetic */ int f;

            b(int i) {
                this.f = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.d(this.f);
            }
        }

        public static Handler c(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void a(int i, Handler handler) {
            c(handler).post(new b(i));
        }

        public final void b(Typeface typeface, Handler handler) {
            c(handler).post(new a(typeface));
        }

        public abstract void d(int i);

        public abstract void e(Typeface typeface);
    }

    private static void a(b bVar, int i, ColorStateList colorStateList) {
        synchronized (f750c) {
            SparseArray<a> sparseArray = f749b.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f749b.put(bVar, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, bVar.f753a.getConfiguration()));
        }
    }

    private static ColorStateList b(b bVar, int i) {
        a aVar;
        synchronized (f750c) {
            SparseArray<a> sparseArray = f749b.get(bVar);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.f752b.equals(bVar.f753a.getConfiguration())) {
                    return aVar.f751a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList b2 = b(bVar, i);
        if (b2 != null) {
            return b2;
        }
        ColorStateList i2 = i(resources, i, theme);
        if (i2 != null) {
            a(bVar, i, i2);
            return i2;
        }
        return resources.getColorStateList(i);
    }

    public static Drawable d(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Typeface e(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface f(Context context, int i, TypedValue typedValue, int i2, c cVar) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i, typedValue, i2, cVar, null, true, false);
    }

    public static void g(Context context, int i, c cVar, Handler handler) {
        i.c(cVar);
        if (context.isRestricted()) {
            cVar.a(-4, handler);
        } else {
            k(context, i, new TypedValue(), 0, cVar, handler, false, false);
        }
    }

    private static TypedValue h() {
        TypedValue typedValue = f748a.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            f748a.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList i(Resources resources, int i, Resources.Theme theme) {
        if (j(resources, i)) {
            return null;
        }
        try {
            return androidx.core.content.d.a.a(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    private static boolean j(Resources resources, int i) {
        TypedValue h = h();
        resources.getValue(i, h, true);
        int i2 = h.type;
        return i2 >= 28 && i2 <= 31;
    }

    private static Typeface k(Context context, int i, TypedValue typedValue, int i2, c cVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface l = l(context, resources, typedValue, i, i2, cVar, handler, z, z2);
        if (l == null && cVar == null && !z2) {
            throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
        }
        return l;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.graphics.Typeface l(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, androidx.core.content.d.f.c r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L9d
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.a(r13, r10)
        L25:
            return r14
        L26:
            android.graphics.Typeface r1 = a.g.d.d.f(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.b(r1, r10)
        L31:
            return r1
        L32:
            if (r23 == 0) goto L35
            return r14
        L35:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            if (r1 == 0) goto L68
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            androidx.core.content.d.c$a r2 = androidx.core.content.d.c.b(r1, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            if (r2 != 0) goto L56
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            if (r9 == 0) goto L55
            r9.a(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
        L55:
            return r14
        L56:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = a.g.d.d.c(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            return r0
        L68:
            r1 = r15
            android.graphics.Typeface r0 = a.g.d.d.d(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            if (r9 == 0) goto L78
            if (r0 == 0) goto L75
            r9.b(r0, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
            goto L78
        L75:
            r9.a(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L82
        L78:
            return r0
        L79:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L8a
        L82:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L8a:
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            if (r9 == 0) goto L9c
            r9.a(r13, r10)
        L9c:
            return r14
        L9d:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.d.f.l(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.d.f$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
