package b.a.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import b.a.a.b;
import b.a.a.o;
import b.a.a.u;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class m<T> implements Comparable<m<T>> {
    private final u.a f;
    private final int g;
    private final String h;
    private final int i;
    private final Object j;
    private o.a k;
    private Integer l;
    private n m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private q r;
    private b.a s;
    private b t;

    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ String f;
        final /* synthetic */ long g;

        a(String str, long j) {
            this.f = str;
            this.g = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            m.this.f.a(this.f, this.g);
            m.this.f.b(m.this.toString());
        }
    }

    /* loaded from: classes.dex */
    interface b {
        void a(m<?> mVar);

        void b(m<?> mVar, o<?> oVar);
    }

    /* loaded from: classes.dex */
    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public m(int i, String str, o.a aVar) {
        this.f = u.a.f1174c ? new u.a() : null;
        this.j = new Object();
        this.n = true;
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        this.g = i;
        this.h = str;
        this.k = aVar;
        W(new e());
        this.i = m(str);
    }

    private byte[] l(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", entry.getKey(), entry.getValue()));
                }
                sb.append(URLEncoder.encode(entry.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encoding not supported: " + str, e);
        }
    }

    private static int m(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        return host.hashCode();
    }

    public int A() {
        return this.g;
    }

    protected Map<String, String> B() {
        return null;
    }

    protected String C() {
        return "UTF-8";
    }

    @Deprecated
    public byte[] D() {
        Map<String, String> F = F();
        if (F == null || F.size() <= 0) {
            return null;
        }
        return l(F, G());
    }

    @Deprecated
    public String E() {
        return w();
    }

    @Deprecated
    protected Map<String, String> F() {
        return B();
    }

    @Deprecated
    protected String G() {
        return C();
    }

    public c H() {
        return c.NORMAL;
    }

    public q I() {
        return this.r;
    }

    public final int J() {
        return I().b();
    }

    public int K() {
        return this.i;
    }

    public String L() {
        return this.h;
    }

    public boolean M() {
        boolean z;
        synchronized (this.j) {
            z = this.p;
        }
        return z;
    }

    public boolean N() {
        boolean z;
        synchronized (this.j) {
            z = this.o;
        }
        return z;
    }

    public void O() {
        synchronized (this.j) {
            this.p = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P() {
        b bVar;
        synchronized (this.j) {
            bVar = this.t;
        }
        if (bVar != null) {
            bVar.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(o<?> oVar) {
        b bVar;
        synchronized (this.j) {
            bVar = this.t;
        }
        if (bVar != null) {
            bVar.b(this, oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public t R(t tVar) {
        return tVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract o<T> S(k kVar);

    /* JADX WARN: Multi-variable type inference failed */
    public m<?> T(b.a aVar) {
        this.s = aVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(b bVar) {
        synchronized (this.j) {
            this.t = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m<?> V(n nVar) {
        this.m = nVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m<?> W(q qVar) {
        this.r = qVar;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final m<?> X(int i) {
        this.l = Integer.valueOf(i);
        return this;
    }

    public final boolean Y() {
        return this.n;
    }

    public final boolean Z() {
        return this.q;
    }

    public void e(String str) {
        if (u.a.f1174c) {
            this.f.a(str, Thread.currentThread().getId());
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: f */
    public int compareTo(m<T> mVar) {
        H();
        mVar.H();
        return this.l.intValue() - mVar.l.intValue();
    }

    public void g(t tVar) {
        o.a aVar;
        synchronized (this.j) {
            aVar = this.k;
        }
        if (aVar != null) {
            aVar.a(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void i(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(String str) {
        n nVar = this.m;
        if (nVar != null) {
            nVar.b(this);
        }
        if (u.a.f1174c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
                return;
            }
            this.f.a(str, id);
            this.f.b(toString());
        }
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(K());
        StringBuilder sb = new StringBuilder();
        sb.append(N() ? "[X] " : "[ ] ");
        sb.append(L());
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(H());
        sb.append(" ");
        sb.append(this.l);
        return sb.toString();
    }

    public byte[] u() {
        Map<String, String> B = B();
        if (B == null || B.size() <= 0) {
            return null;
        }
        return l(B, C());
    }

    public String w() {
        return "application/x-www-form-urlencoded; charset=" + C();
    }

    public b.a x() {
        return this.s;
    }

    public String y() {
        String L = L();
        int A = A();
        if (A == 0 || A == -1) {
            return L;
        }
        return Integer.toString(A) + '-' + L;
    }

    public Map<String, String> z() {
        return Collections.emptyMap();
    }
}
