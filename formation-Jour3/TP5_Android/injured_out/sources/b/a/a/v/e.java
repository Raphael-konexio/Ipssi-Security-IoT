package b.a.a.v;

import android.os.SystemClock;
import android.text.TextUtils;
import b.a.a.b;
import b.a.a.u;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class e implements b.a.a.b {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f1188a;

    /* renamed from: b  reason: collision with root package name */
    private long f1189b;

    /* renamed from: c  reason: collision with root package name */
    private final File f1190c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1191d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        long f1192a;

        /* renamed from: b  reason: collision with root package name */
        final String f1193b;

        /* renamed from: c  reason: collision with root package name */
        final String f1194c;

        /* renamed from: d  reason: collision with root package name */
        final long f1195d;
        final long e;
        final long f;
        final long g;
        final List<b.a.a.g> h;

        a(String str, b.a aVar) {
            this(str, aVar.f1146b, aVar.f1147c, aVar.f1148d, aVar.e, aVar.f, a(aVar));
            this.f1192a = aVar.f1145a.length;
        }

        private a(String str, String str2, long j, long j2, long j3, long j4, List<b.a.a.g> list) {
            this.f1193b = str;
            this.f1194c = "".equals(str2) ? null : str2;
            this.f1195d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
        }

        private static List<b.a.a.g> a(b.a aVar) {
            List<b.a.a.g> list = aVar.h;
            return list != null ? list : g.g(aVar.g);
        }

        static a b(b bVar) {
            if (e.l(bVar) == 538247942) {
                return new a(e.n(bVar), e.n(bVar), e.m(bVar), e.m(bVar), e.m(bVar), e.m(bVar), e.k(bVar));
            }
            throw new IOException();
        }

        b.a c(byte[] bArr) {
            b.a aVar = new b.a();
            aVar.f1145a = bArr;
            aVar.f1146b = this.f1194c;
            aVar.f1147c = this.f1195d;
            aVar.f1148d = this.e;
            aVar.e = this.f;
            aVar.f = this.g;
            aVar.g = g.h(this.h);
            aVar.h = Collections.unmodifiableList(this.h);
            return aVar;
        }

        boolean d(OutputStream outputStream) {
            try {
                e.s(outputStream, 538247942);
                e.u(outputStream, this.f1193b);
                e.u(outputStream, this.f1194c == null ? "" : this.f1194c);
                e.t(outputStream, this.f1195d);
                e.t(outputStream, this.e);
                e.t(outputStream, this.f);
                e.t(outputStream, this.g);
                e.r(this.h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                u.b("%s", e.toString());
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {
        private final long f;
        private long g;

        b(InputStream inputStream, long j) {
            super(inputStream);
            this.f = j;
        }

        long a() {
            return this.f - this.g;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = super.read();
            if (read != -1) {
                this.g++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.g += read;
            }
            return read;
        }
    }

    public e(File file) {
        this(file, 5242880);
    }

    public e(File file, int i) {
        this.f1188a = new LinkedHashMap(16, 0.75f, true);
        this.f1189b = 0L;
        this.f1190c = file;
        this.f1191d = i;
    }

    private String g(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    private void h(int i) {
        long j;
        long j2 = i;
        if (this.f1189b + j2 < this.f1191d) {
            return;
        }
        if (u.f1172b) {
            u.e("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f1189b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f1188a.entrySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (f(value.f1193b).delete()) {
                j = j2;
                this.f1189b -= value.f1192a;
            } else {
                j = j2;
                String str = value.f1193b;
                u.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
            }
            it.remove();
            i2++;
            if (((float) (this.f1189b + j)) < this.f1191d * 0.9f) {
                break;
            }
            j2 = j;
        }
        if (u.f1172b) {
            u.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.f1189b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void i(String str, a aVar) {
        if (this.f1188a.containsKey(str)) {
            this.f1189b += aVar.f1192a - this.f1188a.get(str).f1192a;
        } else {
            this.f1189b += aVar.f1192a;
        }
        this.f1188a.put(str, aVar);
    }

    private static int j(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static List<b.a.a.g> k(b bVar) {
        int l = l(bVar);
        if (l < 0) {
            throw new IOException("readHeaderList size=" + l);
        }
        List<b.a.a.g> emptyList = l == 0 ? Collections.emptyList() : new ArrayList<>();
        for (int i = 0; i < l; i++) {
            emptyList.add(new b.a.a.g(n(bVar).intern(), n(bVar).intern()));
        }
        return emptyList;
    }

    static int l(InputStream inputStream) {
        return (j(inputStream) << 24) | (j(inputStream) << 0) | 0 | (j(inputStream) << 8) | (j(inputStream) << 16);
    }

    static long m(InputStream inputStream) {
        return ((j(inputStream) & 255) << 0) | 0 | ((j(inputStream) & 255) << 8) | ((j(inputStream) & 255) << 16) | ((j(inputStream) & 255) << 24) | ((j(inputStream) & 255) << 32) | ((j(inputStream) & 255) << 40) | ((j(inputStream) & 255) << 48) | ((255 & j(inputStream)) << 56);
    }

    static String n(b bVar) {
        return new String(q(bVar, m(bVar)), "UTF-8");
    }

    private void p(String str) {
        a remove = this.f1188a.remove(str);
        if (remove != null) {
            this.f1189b -= remove.f1192a;
        }
    }

    static byte[] q(b bVar, long j) {
        long a2 = bVar.a();
        if (j >= 0 && j <= a2) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j + ", maxLength=" + a2);
    }

    static void r(List<b.a.a.g> list, OutputStream outputStream) {
        if (list == null) {
            s(outputStream, 0);
            return;
        }
        s(outputStream, list.size());
        for (b.a.a.g gVar : list) {
            u(outputStream, gVar.a());
            u(outputStream, gVar.b());
        }
    }

    static void s(OutputStream outputStream, int i) {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void t(OutputStream outputStream, long j) {
        outputStream.write((byte) (j >>> 0));
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static void u(OutputStream outputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        t(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // b.a.a.b
    public synchronized void a() {
        long length;
        b bVar;
        if (!this.f1190c.exists()) {
            if (!this.f1190c.mkdirs()) {
                u.c("Unable to create cache dir %s", this.f1190c.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = this.f1190c.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            try {
                length = file.length();
                bVar = new b(new BufferedInputStream(d(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                a b2 = a.b(bVar);
                b2.f1192a = length;
                i(b2.f1193b, b2);
                bVar.close();
            } catch (Throwable th) {
                bVar.close();
                throw th;
                break;
            }
        }
    }

    @Override // b.a.a.b
    public synchronized void b(String str, b.a aVar) {
        h(aVar.f1145a.length);
        File f = f(str);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(e(f));
            a aVar2 = new a(str, aVar);
            if (!aVar2.d(bufferedOutputStream)) {
                bufferedOutputStream.close();
                u.b("Failed to write header for %s", f.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(aVar.f1145a);
            bufferedOutputStream.close();
            i(str, aVar2);
        } catch (IOException unused) {
            if (f.delete()) {
                return;
            }
            u.b("Could not clean up file %s", f.getAbsolutePath());
        }
    }

    @Override // b.a.a.b
    public synchronized b.a c(String str) {
        a aVar = this.f1188a.get(str);
        if (aVar == null) {
            return null;
        }
        File f = f(str);
        try {
            b bVar = new b(new BufferedInputStream(d(f)), f.length());
            try {
                a b2 = a.b(bVar);
                if (TextUtils.equals(str, b2.f1193b)) {
                    return aVar.c(q(bVar, bVar.a()));
                }
                u.b("%s: key=%s, found=%s", f.getAbsolutePath(), str, b2.f1193b);
                p(str);
                return null;
            } finally {
                bVar.close();
            }
        } catch (IOException e) {
            u.b("%s: %s", f.getAbsolutePath(), e.toString());
            o(str);
            return null;
        }
    }

    InputStream d(File file) {
        return new FileInputStream(file);
    }

    OutputStream e(File file) {
        return new FileOutputStream(file);
    }

    public File f(String str) {
        return new File(this.f1190c, g(str));
    }

    public synchronized void o(String str) {
        boolean delete = f(str).delete();
        p(str);
        if (!delete) {
            u.b("Could not delete cache entry for key=%s, filename=%s", str, g(str));
        }
    }
}
