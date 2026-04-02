package b.c.c.n;

import java.util.HashSet;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f1433a;

    d() {
        new HashSet();
    }

    public static d a() {
        d dVar = f1433a;
        if (dVar == null) {
            synchronized (d.class) {
                dVar = f1433a;
                if (dVar == null) {
                    dVar = new d();
                    f1433a = dVar;
                }
            }
        }
        return dVar;
    }
}
