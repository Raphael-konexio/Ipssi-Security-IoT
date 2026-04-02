package d;
/* loaded from: classes.dex */
public final class c implements Comparable<c> {
    public static final c j = d.a();
    private final int f;
    private final int g;
    private final int h;
    private final int i;

    public c(int i, int i2, int i3) {
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.f = e(i, i2, i3);
    }

    private final int e(int i, int i2, int i3) {
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(c cVar) {
        d.s.d.g.e(cVar, "other");
        return this.f - cVar.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            obj = null;
        }
        c cVar = (c) obj;
        return cVar != null && this.f == cVar.f;
    }

    public int hashCode() {
        return this.f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.g);
        sb.append('.');
        sb.append(this.h);
        sb.append('.');
        sb.append(this.i);
        return sb.toString();
    }
}
