package b.c.a.b.a0;

import android.graphics.RectF;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f1295a;

    public a(float f) {
        this.f1295a = f;
    }

    @Override // b.c.a.b.a0.c
    public float a(RectF rectF) {
        return this.f1295a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f1295a == ((a) obj).f1295a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f1295a)});
    }
}
