package b.a.a.v;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final int f1197a;

    /* renamed from: b  reason: collision with root package name */
    private final List<b.a.a.g> f1198b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1199c;

    /* renamed from: d  reason: collision with root package name */
    private final InputStream f1200d;

    public h(int i, List<b.a.a.g> list) {
        this(i, list, -1, null);
    }

    public h(int i, List<b.a.a.g> list, int i2, InputStream inputStream) {
        this.f1197a = i;
        this.f1198b = list;
        this.f1199c = i2;
        this.f1200d = inputStream;
    }

    public final InputStream a() {
        return this.f1200d;
    }

    public final int b() {
        return this.f1199c;
    }

    public final List<b.a.a.g> c() {
        return Collections.unmodifiableList(this.f1198b);
    }

    public final int d() {
        return this.f1197a;
    }
}
