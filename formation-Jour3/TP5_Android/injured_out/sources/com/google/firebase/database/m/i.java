package com.google.firebase.database.m;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.database.p.g0.d;
import com.google.firebase.database.p.l;
import com.google.firebase.database.p.y;
import com.google.firebase.database.r.m;
import com.google.firebase.database.r.n;
import com.google.firebase.database.r.o;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class i implements com.google.firebase.database.p.f0.f {
    private static final Charset e = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f2035a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.firebase.database.q.c f2036b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2037c;

    /* renamed from: d  reason: collision with root package name */
    private long f2038d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements d.c<Void, Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.g0.d f2039a;

        a(i iVar, com.google.firebase.database.p.g0.d dVar) {
            this.f2039a = dVar;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Integer a(l lVar, Void r2, Integer num) {
            return Integer.valueOf(this.f2039a.s(lVar) == null ? num.intValue() + 1 : num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d.c<Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.database.p.g0.d f2040a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f2041b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l f2042c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ n f2043d;

        b(i iVar, com.google.firebase.database.p.g0.d dVar, List list, l lVar, n nVar) {
            this.f2040a = dVar;
            this.f2041b = list;
            this.f2042c = lVar;
            this.f2043d = nVar;
        }

        @Override // com.google.firebase.database.p.g0.d.c
        /* renamed from: b */
        public Void a(l lVar, Void r4, Void r5) {
            if (this.f2040a.s(lVar) == null) {
                this.f2041b.add(new com.google.firebase.database.p.g0.g(this.f2042c.i(lVar), this.f2043d.h(lVar)));
                return null;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends SQLiteOpenHelper {
        public c(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        private void a(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            sQLiteDatabase.execSQL("CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (i > 1) {
                throw new AssertionError("We don't handle upgrading to " + i2);
            }
            a(sQLiteDatabase, "serverCache");
            sQLiteDatabase.execSQL("CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);");
            a(sQLiteDatabase, "complete");
            sQLiteDatabase.execSQL("CREATE TABLE trackedKeys (id INTEGER, key TEXT);");
            sQLiteDatabase.execSQL("CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);");
        }
    }

    public i(Context context, com.google.firebase.database.p.g gVar, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.f2036b = gVar.n("Persistence");
            this.f2035a = B(context, encode);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private Cursor A(l lVar, String[] strArr) {
        String E = E(lVar);
        String D = D(E);
        String[] strArr2 = new String[lVar.size() + 3];
        String str = v(lVar, strArr2) + " OR (path > ? AND path < ?)";
        strArr2[lVar.size() + 1] = E;
        strArr2[lVar.size() + 2] = D;
        return this.f2035a.query("serverCache", strArr, str, strArr2, null, null, "path");
    }

    private SQLiteDatabase B(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new c(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e2) {
            if (e2 instanceof SQLiteDatabaseLockedException) {
                throw new com.google.firebase.database.c("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e2);
            }
            throw e2;
        }
    }

    private String C(l lVar, int i) {
        return E(lVar) + String.format(".part-%04d", Integer.valueOf(i));
    }

    private static String D(String str) {
        return str.substring(0, str.length() - 1) + '0';
    }

    private static String E(l lVar) {
        if (lVar.isEmpty()) {
            return "/";
        }
        return lVar.toString() + "/";
    }

    private void F(l lVar, l lVar2, com.google.firebase.database.p.g0.d<Long> dVar, com.google.firebase.database.p.g0.d<Long> dVar2, com.google.firebase.database.p.f0.g gVar, List<com.google.firebase.database.p.g0.g<l, n>> list) {
        if (dVar.getValue() == null) {
            Iterator<Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<Long>>> it = dVar.w().iterator();
            while (it.hasNext()) {
                Map.Entry<com.google.firebase.database.r.b, com.google.firebase.database.p.g0.d<Long>> next = it.next();
                com.google.firebase.database.r.b key = next.getKey();
                F(lVar, lVar2.l(key), next.getValue(), dVar2.u(key), gVar.a(next.getKey()), list);
            }
            return;
        }
        int intValue = ((Integer) gVar.b(0, new a(this, dVar2))).intValue();
        if (intValue > 0) {
            l i = lVar.i(lVar2);
            if (this.f2036b.f()) {
                this.f2036b.b(String.format("Need to rewrite %d nodes below path %s", Integer.valueOf(intValue), i), new Object[0]);
            }
            gVar.b(null, new b(this, dVar2, list, lVar2, z(i)));
        }
    }

    private int G(String str, l lVar) {
        String E = E(lVar);
        return this.f2035a.delete(str, "path >= ? AND path < ?", new String[]{E, D(E)});
    }

    private int H(l lVar, n nVar) {
        long b2 = com.google.firebase.database.p.g0.e.b(nVar);
        if (!(nVar instanceof com.google.firebase.database.r.c) || b2 <= 16384) {
            I(lVar, nVar);
            return 1;
        }
        int i = 0;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", lVar, Long.valueOf(b2), 16384), new Object[0]);
        }
        for (m mVar : nVar) {
            i += H(lVar.l(mVar.c()), mVar.d());
        }
        if (!nVar.c().isEmpty()) {
            I(lVar.l(com.google.firebase.database.r.b.m()), nVar.c());
            i++;
        }
        I(lVar, com.google.firebase.database.r.g.s());
        return i + 1;
    }

    private void I(l lVar, n nVar) {
        byte[] K = K(nVar.r(true));
        if (K.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", E(lVar));
            contentValues.put("value", K);
            this.f2035a.insertWithOnConflict("serverCache", null, contentValues, 5);
            return;
        }
        List<byte[]> L = L(K, 262144);
        if (this.f2036b.f()) {
            com.google.firebase.database.q.c cVar = this.f2036b;
            cVar.b("Saving huge leaf node with " + L.size() + " parts.", new Object[0]);
        }
        for (int i = 0; i < L.size(); i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("path", C(lVar, i));
            contentValues2.put("value", L.get(i));
            this.f2035a.insertWithOnConflict("serverCache", null, contentValues2, 5);
        }
    }

    private void J(l lVar, long j, String str, byte[] bArr) {
        O();
        this.f2035a.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("path", E(lVar));
            contentValues.put("type", str);
            contentValues.put("part", (Integer) null);
            contentValues.put("node", bArr);
            this.f2035a.insertWithOnConflict("writes", null, contentValues, 5);
            return;
        }
        List<byte[]> L = L(bArr, 262144);
        for (int i = 0; i < L.size(); i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", Long.valueOf(j));
            contentValues2.put("path", E(lVar));
            contentValues2.put("type", str);
            contentValues2.put("part", Integer.valueOf(i));
            contentValues2.put("node", L.get(i));
            this.f2035a.insertWithOnConflict("writes", null, contentValues2, 5);
        }
    }

    private byte[] K(Object obj) {
        try {
            return com.google.firebase.database.t.b.d(obj).getBytes(e);
        } catch (IOException e2) {
            throw new RuntimeException("Could not serialize leaf node", e2);
        }
    }

    private static List<byte[]> L(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int min = Math.min(i, bArr.length - i3);
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i3, bArr2, 0, min);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private int M(l lVar, List<String> list, int i) {
        int i2 = i + 1;
        String E = E(lVar);
        if (list.get(i).startsWith(E)) {
            while (i2 < list.size() && list.get(i2).equals(C(lVar, i2 - i))) {
                i2++;
            }
            if (i2 < list.size()) {
                if (list.get(i2).startsWith(E + ".part-")) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i2 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private void N(l lVar, n nVar, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (z) {
            int i3 = 0;
            int i4 = 0;
            for (m mVar : nVar) {
                i4 += G("serverCache", lVar.l(mVar.c()));
                i3 += H(lVar.l(mVar.c()), mVar.d());
            }
            i = i3;
            i2 = i4;
        } else {
            i2 = G("serverCache", lVar);
            i = H(lVar, nVar);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", Integer.valueOf(i), Integer.valueOf(i2), lVar.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    private void O() {
        com.google.firebase.database.p.g0.l.f(this.f2037c, "Transaction expected to already be in progress.");
    }

    private static String v(l lVar, String[] strArr) {
        int i = 0;
        StringBuilder sb = new StringBuilder("(");
        while (true) {
            boolean isEmpty = lVar.isEmpty();
            sb.append("path");
            if (isEmpty) {
                sb.append(" = ?)");
                strArr[i] = E(l.w());
                return sb.toString();
            }
            sb.append(" = ? OR ");
            strArr[i] = E(lVar);
            lVar = lVar.y();
            i++;
        }
    }

    private String w(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Long l : collection) {
            long longValue = l.longValue();
            if (!z) {
                sb.append(",");
            }
            z = false;
            sb.append(longValue);
        }
        return sb.toString();
    }

    private n x(byte[] bArr) {
        try {
            return o.a(com.google.firebase.database.t.b.b(new String(bArr, e)));
        } catch (IOException e2) {
            String str = new String(bArr, e);
            throw new RuntimeException("Could not deserialize node: " + str, e2);
        }
    }

    private byte[] y(List<byte[]> list) {
        int i = 0;
        for (byte[] bArr : list) {
            i += bArr.length;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (byte[] bArr3 : list) {
            System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
            i2 += bArr3.length;
        }
        return bArr2;
    }

    private n z(l lVar) {
        long j;
        n x;
        l lVar2;
        int i;
        l lVar3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor A = A(lVar, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (A.moveToNext()) {
            try {
                arrayList.add(A.getString(0));
                arrayList2.add(A.getBlob(1));
            } catch (Throwable th) {
                A.close();
                throw th;
            }
        }
        A.close();
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        n s = com.google.firebase.database.r.g.s();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        boolean z = false;
        while (true) {
            long j2 = currentTimeMillis4;
            if (i2 >= arrayList2.size()) {
                long j3 = currentTimeMillis2;
                for (Map.Entry entry : hashMap.entrySet()) {
                    s = s.q(l.z(lVar, (l) entry.getKey()), (n) entry.getValue());
                }
                long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
                if (this.f2036b.f()) {
                    this.f2036b.b(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList2.size()), Integer.valueOf(com.google.firebase.database.p.g0.e.c(s)), lVar, Long.valueOf(currentTimeMillis7), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(currentTimeMillis6)), new Object[0]);
                }
                return s;
            }
            if (arrayList.get(i2).endsWith(".part-0000")) {
                String str = arrayList.get(i2);
                j = currentTimeMillis2;
                l lVar4 = new l(str.substring(0, str.length() - 10));
                int M = M(lVar4, arrayList, i2);
                if (this.f2036b.f()) {
                    com.google.firebase.database.q.c cVar = this.f2036b;
                    lVar3 = lVar4;
                    cVar.b("Loading split node with " + M + " parts.", new Object[0]);
                } else {
                    lVar3 = lVar4;
                }
                int i3 = M + i2;
                x = x(y(arrayList2.subList(i2, i3)));
                i2 = i3 - 1;
                lVar2 = lVar3;
            } else {
                j = currentTimeMillis2;
                x = x((byte[]) arrayList2.get(i2));
                lVar2 = new l(arrayList.get(i2));
            }
            if (lVar2.u() != null && lVar2.u().w()) {
                hashMap.put(lVar2, x);
            } else if (lVar2.s(lVar)) {
                com.google.firebase.database.p.g0.l.f(!z, "Descendants of path must come after ancestors.");
                s = x.h(l.z(lVar2, lVar));
            } else if (!lVar.s(lVar2)) {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", lVar2, lVar));
            } else {
                s = s.q(l.z(lVar, lVar2), x);
                i = 1;
                z = true;
                i2 += i;
                currentTimeMillis4 = j2;
                currentTimeMillis2 = j;
            }
            i = 1;
            i2 += i;
            currentTimeMillis4 = j2;
            currentTimeMillis2 = j;
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void a(long j) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.f2035a.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Deleted %d write(s) with writeId %d in %dms", Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void b(l lVar, com.google.firebase.database.p.b bVar, long j) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        J(lVar, j, "m", K(bVar.z(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Persisted user merge in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public List<y> c() {
        byte[] y;
        y yVar;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f2035a.query("writes", new String[]{"id", "path", "type", "part", "node"}, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    long j = query.getLong(0);
                    l lVar = new l(query.getString(1));
                    String string = query.getString(2);
                    if (query.isNull(3)) {
                        y = query.getBlob(4);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList2.add(query.getBlob(4));
                            if (!query.moveToNext()) {
                                break;
                            }
                        } while (query.getLong(0) == j);
                        query.moveToPrevious();
                        y = y(arrayList2);
                    }
                    Object b2 = com.google.firebase.database.t.b.b(new String(y, e));
                    if ("o".equals(string)) {
                        yVar = new y(j, lVar, o.a(b2), true);
                    } else if (!"m".equals(string)) {
                        throw new IllegalStateException("Got invalid write type: " + string);
                    } else {
                        yVar = new y(j, lVar, com.google.firebase.database.p.b.w((Map) b2));
                    }
                    arrayList.add(yVar);
                } catch (IOException e2) {
                    throw new RuntimeException("Failed to load writes", e2);
                }
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Loaded %d writes in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.p.f0.f
    public void d(l lVar, n nVar, long j) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        J(lVar, j, "o", K(nVar.r(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Persisted user overwrite in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void e() {
        this.f2035a.endTransaction();
        this.f2037c = false;
        long currentTimeMillis = System.currentTimeMillis() - this.f2038d;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Transaction completed. Elapsed: %dms", Long.valueOf(currentTimeMillis)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void f() {
        com.google.firebase.database.p.g0.l.f(!this.f2037c, "runInTransaction called when an existing transaction is already in progress.");
        if (this.f2036b.f()) {
            this.f2036b.b("Starting transaction.", new Object[0]);
        }
        this.f2035a.beginTransaction();
        this.f2037c = true;
        this.f2038d = System.currentTimeMillis();
    }

    @Override // com.google.firebase.database.p.f0.f
    public void g(long j) {
        O();
        String valueOf = String.valueOf(j);
        this.f2035a.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.f2035a.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    @Override // com.google.firebase.database.p.f0.f
    public Set<com.google.firebase.database.r.b> h(long j) {
        return t(Collections.singleton(Long.valueOf(j)));
    }

    @Override // com.google.firebase.database.p.f0.f
    public void i(long j) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.FALSE);
        contentValues.put("lastUse", Long.valueOf(j));
        this.f2035a.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Reset active tracked queries in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void j(l lVar, n nVar) {
        O();
        N(lVar, nVar, true);
    }

    @Override // com.google.firebase.database.p.f0.f
    public void k(long j, Set<com.google.firebase.database.r.b> set) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        this.f2035a.delete("trackedKeys", "id = ?", new String[]{String.valueOf(j)});
        for (com.google.firebase.database.r.b bVar : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", bVar.e());
            this.f2035a.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Set %d tracked query keys for tracked query %d in %dms", Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void l(com.google.firebase.database.p.f0.h hVar) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(hVar.f2159a));
        contentValues.put("path", E(hVar.f2160b.e()));
        contentValues.put("queryParams", hVar.f2160b.d().q());
        contentValues.put("lastUse", Long.valueOf(hVar.f2161c));
        contentValues.put("complete", Boolean.valueOf(hVar.f2162d));
        contentValues.put("active", Boolean.valueOf(hVar.e));
        this.f2035a.insertWithOnConflict("trackedQueries", null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Saved new tracked query in %dms", Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void m(l lVar, n nVar) {
        O();
        N(lVar, nVar, false);
    }

    @Override // com.google.firebase.database.p.f0.f
    public long n() {
        Cursor rawQuery = this.f2035a.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", "value", "path", "serverCache"), null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public void o(l lVar, com.google.firebase.database.p.b bVar) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<l, n>> it = bVar.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry<l, n> next = it.next();
            i += G("serverCache", lVar.i(next.getKey()));
            i2 += H(lVar.i(next.getKey()), next.getValue());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", Integer.valueOf(i2), Integer.valueOf(i), lVar.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public List<com.google.firebase.database.p.f0.h> p() {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f2035a.query("trackedQueries", new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"}, null, null, null, null, "id");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    arrayList.add(new com.google.firebase.database.p.f0.h(query.getLong(0), com.google.firebase.database.p.h0.i.b(new l(query.getString(1)), com.google.firebase.database.t.b.a(query.getString(2))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Loaded %d tracked queries in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.p.f0.f
    public n q(l lVar) {
        return z(lVar);
    }

    @Override // com.google.firebase.database.p.f0.f
    public void r() {
        this.f2035a.setTransactionSuccessful();
    }

    @Override // com.google.firebase.database.p.f0.f
    public void s(long j, Set<com.google.firebase.database.r.b> set, Set<com.google.firebase.database.r.b> set2) {
        O();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        Iterator<com.google.firebase.database.r.b> it = set2.iterator();
        while (it.hasNext()) {
            this.f2035a.delete("trackedKeys", "id = ? AND key = ?", new String[]{valueOf, it.next().e()});
        }
        for (com.google.firebase.database.r.b bVar : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", bVar.e());
            this.f2035a.insertWithOnConflict("trackedKeys", null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.p.f0.f
    public Set<com.google.firebase.database.r.b> t(Set<Long> set) {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.f2035a.query(true, "trackedKeys", new String[]{"key"}, "id IN (" + w(set) + ")", null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(com.google.firebase.database.r.b.g(query.getString(0)));
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.f2036b.f()) {
            this.f2036b.b(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)), new Object[0]);
        }
        return hashSet;
    }

    @Override // com.google.firebase.database.p.f0.f
    public void u(l lVar, com.google.firebase.database.p.f0.g gVar) {
        int i;
        int i2;
        com.google.firebase.database.q.c cVar;
        StringBuilder sb;
        String str;
        if (gVar.e()) {
            O();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor A = A(lVar, new String[]{"rowid", "path"});
            com.google.firebase.database.p.g0.d<Long> dVar = new com.google.firebase.database.p.g0.d<>(null);
            com.google.firebase.database.p.g0.d<Long> dVar2 = new com.google.firebase.database.p.g0.d<>(null);
            while (A.moveToNext()) {
                long j = A.getLong(0);
                l lVar2 = new l(A.getString(1));
                if (lVar.s(lVar2)) {
                    l z = l.z(lVar, lVar2);
                    if (gVar.g(z)) {
                        dVar = dVar.B(z, Long.valueOf(j));
                    } else if (gVar.f(z)) {
                        dVar2 = dVar2.B(z, Long.valueOf(j));
                    } else {
                        cVar = this.f2036b;
                        sb = new StringBuilder();
                        sb.append("We are pruning at ");
                        sb.append(lVar);
                        sb.append(" and have data at ");
                        sb.append(lVar2);
                        str = " that isn't marked for pruning or keeping. Ignoring.";
                    }
                } else {
                    cVar = this.f2036b;
                    sb = new StringBuilder();
                    sb.append("We are pruning at ");
                    sb.append(lVar);
                    sb.append(" but we have data stored higher up at ");
                    sb.append(lVar2);
                    str = ". Ignoring.";
                }
                sb.append(str);
                cVar.i(sb.toString());
            }
            if (dVar.isEmpty()) {
                i = 0;
                i2 = 0;
            } else {
                ArrayList arrayList = new ArrayList();
                F(lVar, l.w(), dVar, dVar2, gVar, arrayList);
                Collection<Long> E = dVar.E();
                this.f2035a.delete("serverCache", "rowid IN (" + w(E) + ")", null);
                for (com.google.firebase.database.p.g0.g<l, n> gVar2 : arrayList) {
                    H(lVar.i(gVar2.a()), gVar2.b());
                }
                i = E.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.f2036b.f()) {
                this.f2036b.b(String.format("Pruned %d rows with %d nodes resaved in %dms", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)), new Object[0]);
            }
        }
    }
}
