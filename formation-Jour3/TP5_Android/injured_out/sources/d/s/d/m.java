package d.s.d;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final n f2413a;

    static {
        n nVar = null;
        try {
            nVar = (n) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (nVar == null) {
            nVar = new n();
        }
        f2413a = nVar;
    }

    public static d.u.b a(Class cls) {
        return f2413a.a(cls);
    }

    public static d.u.c b(Class cls) {
        return f2413a.b(cls, "");
    }

    public static d.u.d c(j jVar) {
        f2413a.c(jVar);
        return jVar;
    }

    public static String d(h hVar) {
        return f2413a.e(hVar);
    }
}
