package io.flutter.embedding.engine.g;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f2501a;

    /* renamed from: b  reason: collision with root package name */
    private C0118c f2502b;

    /* renamed from: c  reason: collision with root package name */
    private long f2503c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.engine.g.b f2504d;
    private FlutterJNI e;
    Future<b> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f2505a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.flutter.embedding.engine.g.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0117a implements Runnable {
            RunnableC0117a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.e.prefetchDefaultFontManager();
            }
        }

        a(Context context) {
            this.f2505a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public b call() {
            d e = c.this.e(this.f2505a);
            c.this.e.loadLibrary();
            Executors.newSingleThreadExecutor().execute(new RunnableC0117a());
            if (e != null) {
                e.a();
            }
            return new b(c.a.d.a.c(this.f2505a), c.a.d.a.a(this.f2505a), c.a.d.a.b(this.f2505a), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final String f2507a;

        /* renamed from: b  reason: collision with root package name */
        final String f2508b;

        private b(String str, String str2, String str3) {
            this.f2507a = str;
            this.f2508b = str2;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    /* renamed from: io.flutter.embedding.engine.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0118c {

        /* renamed from: a  reason: collision with root package name */
        private String f2509a;

        public String a() {
            return this.f2509a;
        }
    }

    public c() {
        this(new FlutterJNI());
    }

    public c(FlutterJNI flutterJNI) {
        this.f2501a = false;
        this.e = flutterJNI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d e(Context context) {
        return null;
    }

    public void c(Context context, String[] strArr) {
        if (this.f2501a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f2502b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            b bVar = this.f.get();
            ArrayList arrayList = new ArrayList();
            arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            arrayList.add("--icu-native-lib-path=" + this.f2504d.f2500d + File.separator + "libflutter.so");
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            arrayList.add("--aot-shared-library-name=" + this.f2504d.f2497a);
            arrayList.add("--aot-shared-library-name=" + this.f2504d.f2500d + File.separator + this.f2504d.f2497a);
            StringBuilder sb = new StringBuilder();
            sb.append("--cache-dir-path=");
            sb.append(bVar.f2508b);
            arrayList.add(sb.toString());
            if (!this.f2504d.e) {
                arrayList.add("--disallow-insecure-connections");
            }
            if (this.f2504d.f2499c != null) {
                arrayList.add("--domain-network-policy=" + this.f2504d.f2499c);
            }
            if (this.f2502b.a() != null) {
                arrayList.add("--log-tag=" + this.f2502b.a());
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            int i = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
            if (i == 0) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                i = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
            }
            arrayList.add("--old-gen-heap-size=" + i);
            this.e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f2507a, bVar.f2508b, SystemClock.uptimeMillis() - this.f2503c);
            this.f2501a = true;
        } catch (Exception e) {
            c.a.b.c("FlutterLoader", "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    public String d() {
        return this.f2504d.f2498b;
    }

    public void f(Context context) {
        g(context, new C0118c());
    }

    public void g(Context context, C0118c c0118c) {
        if (this.f2502b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        Context applicationContext = context.getApplicationContext();
        this.f2502b = c0118c;
        this.f2503c = SystemClock.uptimeMillis();
        this.f2504d = io.flutter.embedding.engine.g.a.d(applicationContext);
        f.b((WindowManager) applicationContext.getSystemService("window")).c();
        this.f = Executors.newSingleThreadExecutor().submit(new a(applicationContext));
    }
}
