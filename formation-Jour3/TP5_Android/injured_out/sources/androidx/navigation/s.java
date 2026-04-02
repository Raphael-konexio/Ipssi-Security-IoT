package androidx.navigation;

import androidx.navigation.r;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class s {

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<Class<?>, String> f961b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, r<? extends j>> f962a = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Class<? extends r> cls) {
        String str = f961b.get(cls);
        if (str == null) {
            r.b bVar = (r.b) cls.getAnnotation(r.b.class);
            str = bVar != null ? bVar.value() : null;
            if (!g(str)) {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
            f961b.put(cls, str);
        }
        return str;
    }

    private static boolean g(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public final r<? extends j> a(r<? extends j> rVar) {
        return b(c(rVar.getClass()), rVar);
    }

    public r<? extends j> b(String str, r<? extends j> rVar) {
        if (g(str)) {
            return this.f962a.put(str, rVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public final <T extends r<?>> T d(Class<T> cls) {
        return (T) e(c(cls));
    }

    public <T extends r<?>> T e(String str) {
        if (g(str)) {
            r<? extends j> rVar = this.f962a.get(str);
            if (rVar != null) {
                return rVar;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, r<? extends j>> f() {
        return this.f962a;
    }
}
