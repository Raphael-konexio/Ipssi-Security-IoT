package a.e.a;
/* loaded from: classes.dex */
class h<T> implements g<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f92a;

    /* renamed from: b  reason: collision with root package name */
    private int f93b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f92a = new Object[i];
    }

    @Override // a.e.a.g
    public boolean a(T t) {
        int i = this.f93b;
        Object[] objArr = this.f92a;
        if (i < objArr.length) {
            objArr[i] = t;
            this.f93b = i + 1;
            return true;
        }
        return false;
    }

    @Override // a.e.a.g
    public T b() {
        int i = this.f93b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = this.f92a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.f93b = i - 1;
            return t;
        }
        return null;
    }

    @Override // a.e.a.g
    public void c(T[] tArr, int i) {
        if (i > tArr.length) {
            i = tArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            int i3 = this.f93b;
            Object[] objArr = this.f92a;
            if (i3 < objArr.length) {
                objArr[i3] = t;
                this.f93b = i3 + 1;
            }
        }
    }
}
