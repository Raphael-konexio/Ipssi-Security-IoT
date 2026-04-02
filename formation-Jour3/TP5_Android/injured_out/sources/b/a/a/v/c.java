package b.a.a.v;

import b.a.a.b;
import b.a.a.q;
import b.a.a.r;
import b.a.a.t;
import b.a.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
/* loaded from: classes.dex */
public class c implements b.a.a.h {

    /* renamed from: c  reason: collision with root package name */
    protected static final boolean f1181c = u.f1172b;

    /* renamed from: a  reason: collision with root package name */
    private final b f1182a;

    /* renamed from: b  reason: collision with root package name */
    protected final d f1183b;

    public c(b bVar) {
        this(bVar, new d(4096));
    }

    public c(b bVar, d dVar) {
        this.f1182a = bVar;
        this.f1183b = dVar;
    }

    @Deprecated
    public c(i iVar) {
        this(iVar, new d(4096));
    }

    @Deprecated
    public c(i iVar, d dVar) {
        this.f1182a = new a(iVar);
        this.f1183b = dVar;
    }

    private static void b(String str, b.a.a.m<?> mVar, t tVar) {
        q I = mVar.I();
        int J = mVar.J();
        try {
            I.a(tVar);
            mVar.e(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(J)));
        } catch (t e) {
            mVar.e(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(J)));
            throw e;
        }
    }

    private static List<b.a.a.g> c(List<b.a.a.g> list, b.a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (b.a.a.g gVar : list) {
                treeSet.add(gVar.a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List<b.a.a.g> list2 = aVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (b.a.a.g gVar2 : aVar.h) {
                    if (!treeSet.contains(gVar2.a())) {
                        arrayList.add(gVar2);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry<String, String> entry : aVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new b.a.a.g(entry.getKey(), entry.getValue()));
                }
            }
        }
        return arrayList;
    }

    private Map<String, String> d(b.a aVar) {
        if (aVar == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        String str = aVar.f1146b;
        if (str != null) {
            hashMap.put("If-None-Match", str);
        }
        long j = aVar.f1148d;
        if (j > 0) {
            hashMap.put("If-Modified-Since", g.a(j));
        }
        return hashMap;
    }

    private byte[] e(InputStream inputStream, int i) {
        k kVar = new k(this.f1183b, i);
        try {
            if (inputStream != null) {
                byte[] a2 = this.f1183b.a(1024);
                while (true) {
                    int read = inputStream.read(a2);
                    if (read == -1) {
                        break;
                    }
                    kVar.write(a2, 0, read);
                }
                byte[] byteArray = kVar.toByteArray();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        u.e("Error occurred when closing InputStream", new Object[0]);
                    }
                }
                this.f1183b.b(a2);
                kVar.close();
                return byteArray;
            }
            throw new r();
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    u.e("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f1183b.b(null);
            kVar.close();
            throw th;
        }
    }

    private void f(long j, b.a.a.m<?> mVar, byte[] bArr, int i) {
        if (f1181c || j > 3000) {
            Object[] objArr = new Object[5];
            objArr[0] = mVar;
            objArr[1] = Long.valueOf(j);
            objArr[2] = bArr != null ? Integer.valueOf(bArr.length) : "null";
            objArr[3] = Integer.valueOf(i);
            objArr[4] = Integer.valueOf(mVar.I().c());
            u.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v5 */
    @Override // b.a.a.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b.a.a.k a(b.a.a.m<?> r29) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.a.a.v.c.a(b.a.a.m):b.a.a.k");
    }
}
