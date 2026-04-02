package b.c.a.a.d.c;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    private final d f1258a;

    /* renamed from: b  reason: collision with root package name */
    private final q f1259b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1260c;

    private l(q qVar) {
        this(qVar, false, h.f1255b, Reader.READ_DONE);
    }

    private l(q qVar, boolean z, d dVar, int i) {
        this.f1259b = qVar;
        this.f1258a = dVar;
        this.f1260c = Reader.READ_DONE;
    }

    public static l b(char c2) {
        f fVar = new f('.');
        m.c(fVar);
        return new l(new o(fVar));
    }

    public final List<String> c(CharSequence charSequence) {
        m.c(charSequence);
        Iterator<String> a2 = this.f1259b.a(this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (a2.hasNext()) {
            arrayList.add(a2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
