package com.google.firebase.database.s;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public class c {
    private static final AtomicInteger l = new AtomicInteger(0);
    private static final Charset m = Charset.forName("UTF-8");
    private static ThreadFactory n = Executors.defaultThreadFactory();
    private static com.google.firebase.database.s.b o = new a();

    /* renamed from: d  reason: collision with root package name */
    private final URI f2381d;
    private final String e;
    private final h f;
    private final i g;
    private final f h;
    private final com.google.firebase.database.q.c i;

    /* renamed from: a  reason: collision with root package name */
    private volatile d f2378a = d.NONE;

    /* renamed from: b  reason: collision with root package name */
    private volatile Socket f2379b = null;

    /* renamed from: c  reason: collision with root package name */
    private com.google.firebase.database.s.d f2380c = null;
    private final int j = l.incrementAndGet();
    private final Thread k = j().newThread(new b());

    /* loaded from: classes.dex */
    class a implements com.google.firebase.database.s.b {
        a() {
        }

        @Override // com.google.firebase.database.s.b
        public void a(Thread thread, String str) {
            thread.setName(str);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.database.s.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0108c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2382a;

        static {
            int[] iArr = new int[d.values().length];
            f2382a = iArr;
            try {
                iArr[d.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2382a[d.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2382a[d.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2382a[d.DISCONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2382a[d.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum d {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public c(com.google.firebase.database.o.d dVar, URI uri, String str, Map<String, String> map) {
        this.f2381d = uri;
        this.e = dVar.e();
        com.google.firebase.database.q.d d2 = dVar.d();
        this.i = new com.google.firebase.database.q.c(d2, "WebSocket", "sk_" + this.j);
        this.h = new f(uri, str, map);
        this.f = new h(this);
        this.g = new i(this, "TubeSock", this.j);
    }

    private synchronized void d() {
        if (this.f2378a == d.DISCONNECTED) {
            return;
        }
        this.f.h();
        this.g.i();
        if (this.f2379b != null) {
            try {
                this.f2379b.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.f2378a = d.DISCONNECTED;
        this.f2380c.b();
    }

    private Socket f() {
        String scheme = this.f2381d.getScheme();
        String host = this.f2381d.getHost();
        int port = this.f2381d.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e) {
                throw new e("unknown host: " + host, e);
            } catch (IOException e2) {
                throw new e("error while creating socket to " + this.f2381d, e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            throw new e("unsupported protocol: " + scheme);
        } else {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sSLSessionCache = null;
            try {
                if (this.e != null) {
                    sSLSessionCache = new SSLSessionCache(new File(this.e));
                }
            } catch (IOException e3) {
                this.i.a("Failed to initialize SSL session cache", e3, new Object[0]);
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                throw new e("Error while verifying secure socket to " + this.f2381d);
            } catch (UnknownHostException e4) {
                throw new e("unknown host: " + host, e4);
            } catch (IOException e5) {
                throw new e("error while creating secure socket to " + this.f2381d, e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.google.firebase.database.s.b i() {
        return o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadFactory j() {
        return n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            try {
                Socket f = f();
                synchronized (this) {
                    this.f2379b = f;
                    if (this.f2378a == d.DISCONNECTED) {
                        try {
                            this.f2379b.close();
                            this.f2379b = null;
                            return;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    DataInputStream dataInputStream = new DataInputStream(f.getInputStream());
                    OutputStream outputStream = f.getOutputStream();
                    outputStream.write(this.h.c());
                    byte[] bArr = new byte[1000];
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    while (true) {
                        int i = 0;
                        while (!z) {
                            int read = dataInputStream.read();
                            if (read == -1) {
                                throw new e("Connection closed before handshake was complete");
                            }
                            bArr[i] = (byte) read;
                            i++;
                            if (bArr[i - 1] == 10 && bArr[i - 2] == 13) {
                                String str = new String(bArr, m);
                                if (str.trim().equals("")) {
                                    z = true;
                                } else {
                                    arrayList.add(str.trim());
                                }
                                bArr = new byte[1000];
                            } else if (i == 1000) {
                                String str2 = new String(bArr, m);
                                throw new e("Unexpected long line in handshake: " + str2);
                            }
                        }
                        this.h.f((String) arrayList.get(0));
                        arrayList.remove(0);
                        HashMap<String, String> hashMap = new HashMap<>();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String[] split = ((String) it.next()).split(": ", 2);
                            hashMap.put(split[0].toLowerCase(Locale.US), split[1].toLowerCase(Locale.US));
                        }
                        this.h.e(hashMap);
                        this.g.h(outputStream);
                        this.f.g(dataInputStream);
                        this.f2378a = d.CONNECTED;
                        this.g.d().start();
                        this.f2380c.c();
                        this.f.f();
                    }
                }
            } finally {
                c();
            }
        } catch (e e2) {
            this.f2380c.f(e2);
        } catch (Throwable th) {
            com.google.firebase.database.s.d dVar = this.f2380c;
            dVar.f(new e("error while connecting: " + th.getMessage(), th));
        }
    }

    private synchronized void o(byte b2, byte[] bArr) {
        if (this.f2378a != d.CONNECTED) {
            this.f2380c.f(new e("error while sending data: not connected"));
        } else {
            try {
                this.g.g(b2, true, bArr);
            } catch (IOException e) {
                this.f2380c.f(new e("Failed to send frame", e));
                c();
            }
        }
    }

    private void q() {
        try {
            this.f2378a = d.DISCONNECTING;
            this.g.i();
            this.g.g((byte) 8, true, new byte[0]);
        } catch (IOException e) {
            this.f2380c.f(new e("Failed to send close frame", e));
        }
    }

    public void b() {
        if (this.g.d().getState() != Thread.State.NEW) {
            this.g.d().join();
        }
        h().join();
    }

    public synchronized void c() {
        int i = C0108c.f2382a[this.f2378a.ordinal()];
        if (i == 1) {
            this.f2378a = d.DISCONNECTED;
        } else if (i == 2) {
            d();
        } else if (i == 3) {
            q();
        } else if (i != 4) {
        }
    }

    public synchronized void e() {
        if (this.f2378a != d.NONE) {
            this.f2380c.f(new e("connect() already called"));
            c();
            return;
        }
        com.google.firebase.database.s.b i = i();
        Thread h = h();
        i.a(h, "TubeSockReader-" + this.j);
        this.f2378a = d.CONNECTING;
        h().start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.database.s.d g() {
        return this.f2380c;
    }

    Thread h() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(e eVar) {
        this.f2380c.f(eVar);
        if (this.f2378a == d.CONNECTED) {
            c();
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void m(byte[] bArr) {
        o((byte) 10, bArr);
    }

    public synchronized void p(String str) {
        o((byte) 1, str.getBytes(m));
    }

    public void r(com.google.firebase.database.s.d dVar) {
        this.f2380c = dVar;
    }
}
