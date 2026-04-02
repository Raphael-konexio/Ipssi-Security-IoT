package b.c.a.b.a0;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f1296a;

    /* renamed from: b  reason: collision with root package name */
    private final float f1297b;

    public b(float f, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f1296a;
            f += ((b) cVar).f1297b;
        }
        this.f1296a = cVar;
        this.f1297b = f;
    }

    @Override // b.c.a.b.a0.c
    public float a(RectF rectF) {
        return Math.max(0.0f, this.f1296a.a(rectF) + this.f1297b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f1296a.equals(bVar.f1296a) && this.f1297b == bVar.f1297b;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f1296a, Float.valueOf(this.f1297b)});
    }
}
