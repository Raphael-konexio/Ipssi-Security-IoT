package b.c.a.b.a0;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class i implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f1305a;

    public i(float f) {
        this.f1305a = f;
    }

    @Override // b.c.a.b.a0.c
    public float a(RectF rectF) {
        return this.f1305a * rectF.height();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f1305a == ((i) obj).f1305a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f1305a)});
    }
}
