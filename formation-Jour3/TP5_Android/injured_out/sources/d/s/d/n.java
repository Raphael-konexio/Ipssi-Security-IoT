package d.s.d;
/* loaded from: classes.dex */
public class n {
    public d.u.b a(Class cls) {
        return new c(cls);
    }

    public d.u.c b(Class cls, String str) {
        return new i(cls, str);
    }

    public d.u.d c(j jVar) {
        return jVar;
    }

    public String d(f fVar) {
        String obj = fVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String e(h hVar) {
        return d(hVar);
    }
}
