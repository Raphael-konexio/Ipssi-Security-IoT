package b.a.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f1159a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f1160b;

    /* renamed from: c  reason: collision with root package name */
    public final List<g> f1161c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f1162d;

    private k(int i, byte[] bArr, Map<String, String> map, List<g> list, boolean z, long j) {
        this.f1159a = bArr;
        this.f1160b = map;
        this.f1161c = list == null ? null : Collections.unmodifiableList(list);
        this.f1162d = z;
    }

    @Deprecated
    public k(int i, byte[] bArr, Map<String, String> map, boolean z, long j) {
        this(i, bArr, map, a(map), z, j);
    }

    public k(int i, byte[] bArr, boolean z, long j, List<g> list) {
        this(i, bArr, b(list), list, z, j);
    }

    @Deprecated
    public k(byte[] bArr, Map<String, String> map) {
        this(200, bArr, map, false, 0L);
    }

    private static List<g> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(new g(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private static Map<String, String> b(List<g> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        for (g gVar : list) {
            treeMap.put(gVar.a(), gVar.b());
        }
        return treeMap;
    }
}
