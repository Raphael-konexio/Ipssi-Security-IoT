package a.g.d;

import a.g.h.f;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.d.c;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f149a = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c<f.b> {
        a(j jVar) {
        }

        @Override // a.g.d.j.c
        /* renamed from: c */
        public int a(f.b bVar) {
            return bVar.e();
        }

        @Override // a.g.d.j.c
        /* renamed from: d */
        public boolean b(f.b bVar) {
            return bVar.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements c<c.C0041c> {
        b(j jVar) {
        }

        @Override // a.g.d.j.c
        /* renamed from: c */
        public int a(c.C0041c c0041c) {
            return c0041c.e();
        }

        @Override // a.g.d.j.c
        /* renamed from: d */
        public boolean b(c.C0041c c0041c) {
            return c0041c.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c<T> {
        int a(T t);

        boolean b(T t);
    }

    private void a(Typeface typeface, c.b bVar) {
        long j = j(typeface);
        if (j != 0) {
            this.f149a.put(Long.valueOf(j), bVar);
        }
    }

    private c.C0041c f(c.b bVar, int i) {
        return (c.C0041c) g(bVar.a(), i, new b(this));
    }

    private static <T> T g(T[] tArr, int i, c<T> cVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Reader.READ_DONE;
        for (T t2 : tArr) {
            int abs = (Math.abs(cVar.a(t2) - i2) * 2) + (cVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    private static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public Typeface b(Context context, c.b bVar, Resources resources, int i) {
        c.C0041c f = f(bVar, i);
        if (f == null) {
            return null;
        }
        Typeface d2 = d.d(context, resources, f.b(), f.a(), i);
        a(d2, bVar);
        return d2;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(bVarArr, i).d());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface d2 = d(context, inputStream);
            k.a(inputStream);
            return d2;
        } catch (IOException unused2) {
            k.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            k.a(inputStream2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface d(Context context, InputStream inputStream) {
        File e = k.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (k.d(e, inputStream)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File e = k.e(context);
        if (e == null) {
            return null;
        }
        try {
            if (k.c(e, resources, i)) {
                return Typeface.createFromFile(e.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f.b h(f.b[] bVarArr, int i) {
        return (f.b) g(bVarArr, i, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c.b i(Typeface typeface) {
        long j = j(typeface);
        if (j == 0) {
            return null;
        }
        return this.f149a.get(Long.valueOf(j));
    }
}
