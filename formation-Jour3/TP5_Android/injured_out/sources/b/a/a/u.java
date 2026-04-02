package b.a.a;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    public static String f1171a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f1172b = Log.isLoggable("Volley", 2);

    /* renamed from: c  reason: collision with root package name */
    private static final String f1173c = u.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        public static final boolean f1174c = u.f1172b;

        /* renamed from: a  reason: collision with root package name */
        private final List<C0055a> f1175a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private boolean f1176b = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b.a.a.u$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0055a {

            /* renamed from: a  reason: collision with root package name */
            public final String f1177a;

            /* renamed from: b  reason: collision with root package name */
            public final long f1178b;

            /* renamed from: c  reason: collision with root package name */
            public final long f1179c;

            public C0055a(String str, long j, long j2) {
                this.f1177a = str;
                this.f1178b = j;
                this.f1179c = j2;
            }
        }

        private long c() {
            if (this.f1175a.size() == 0) {
                return 0L;
            }
            long j = this.f1175a.get(0).f1179c;
            List<C0055a> list = this.f1175a;
            return list.get(list.size() - 1).f1179c - j;
        }

        public synchronized void a(String str, long j) {
            if (this.f1176b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f1175a.add(new C0055a(str, j, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f1176b = true;
            long c2 = c();
            if (c2 <= 0) {
                return;
            }
            long j = this.f1175a.get(0).f1179c;
            u.b("(%-4d ms) %s", Long.valueOf(c2), str);
            for (C0055a c0055a : this.f1175a) {
                long j2 = c0055a.f1179c;
                u.b("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(c0055a.f1178b), c0055a.f1177a);
                j = j2;
            }
        }

        protected void finalize() {
            if (this.f1176b) {
                return;
            }
            b("Request on the loose");
            u.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(f1173c)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i].getMethodName();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f1171a, a(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f1171a, a(str, objArr));
    }

    public static void d(Throwable th, String str, Object... objArr) {
        Log.e(f1171a, a(str, objArr), th);
    }

    public static void e(String str, Object... objArr) {
        if (f1172b) {
            Log.v(f1171a, a(str, objArr));
        }
    }
}
