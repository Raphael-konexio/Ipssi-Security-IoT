package a.g.j;
/* loaded from: classes.dex */
public class g<T> implements f<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f219a;

    /* renamed from: b  reason: collision with root package name */
    private int f220b;

    public g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f219a = new Object[i];
    }

    private boolean c(T t) {
        for (int i = 0; i < this.f220b; i++) {
            if (this.f219a[i] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // a.g.j.f
    public boolean a(T t) {
        if (c(t)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i = this.f220b;
        Object[] objArr = this.f219a;
        if (i < objArr.length) {
            objArr[i] = t;
            this.f220b = i + 1;
            return true;
        }
        return false;
    }

    @Override // a.g.j.f
    public T b() {
        int i = this.f220b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f219a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f220b = i - 1;
            return t;
        }
        return null;
    }
}
