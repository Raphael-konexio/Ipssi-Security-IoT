package d.o;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Collections;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends x {
    public static int a(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : Reader.READ_DONE;
    }

    public static final <K, V> Map<K, V> b(d.i<? extends K, ? extends V> iVar) {
        d.s.d.g.e(iVar, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(iVar.c(), iVar.d());
        d.s.d.g.d(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> c(Map<? extends K, ? extends V> map) {
        d.s.d.g.e(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        d.s.d.g.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
