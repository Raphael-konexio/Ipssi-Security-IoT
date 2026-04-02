package a.g.d;

import android.graphics.Insets;
import android.graphics.Rect;
/* loaded from: classes.dex */
public final class b {
    public static final b e = new b(0, 0, 0, 0);

    /* renamed from: a  reason: collision with root package name */
    public final int f132a;

    /* renamed from: b  reason: collision with root package name */
    public final int f133b;

    /* renamed from: c  reason: collision with root package name */
    public final int f134c;

    /* renamed from: d  reason: collision with root package name */
    public final int f135d;

    private b(int i, int i2, int i3, int i4) {
        this.f132a = i;
        this.f133b = i2;
        this.f134c = i3;
        this.f135d = i4;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f132a, bVar2.f132a), Math.max(bVar.f133b, bVar2.f133b), Math.max(bVar.f134c, bVar2.f134c), Math.max(bVar.f135d, bVar2.f135d));
    }

    public static b b(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? e : new b(i, i2, i3, i4);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f132a, this.f133b, this.f134c, this.f135d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f135d == bVar.f135d && this.f132a == bVar.f132a && this.f134c == bVar.f134c && this.f133b == bVar.f133b;
    }

    public int hashCode() {
        return (((((this.f132a * 31) + this.f133b) * 31) + this.f134c) * 31) + this.f135d;
    }

    public String toString() {
        return "Insets{left=" + this.f132a + ", top=" + this.f133b + ", right=" + this.f134c + ", bottom=" + this.f135d + '}';
    }
}
