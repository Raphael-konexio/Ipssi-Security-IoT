package b.a.a;
/* loaded from: classes.dex */
public class e implements q {

    /* renamed from: a  reason: collision with root package name */
    private int f1151a;

    /* renamed from: b  reason: collision with root package name */
    private int f1152b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1153c;

    /* renamed from: d  reason: collision with root package name */
    private final float f1154d;

    public e() {
        this(2500, 1, 1.0f);
    }

    public e(int i, int i2, float f) {
        this.f1151a = i;
        this.f1153c = i2;
        this.f1154d = f;
    }

    @Override // b.a.a.q
    public void a(t tVar) {
        this.f1152b++;
        int i = this.f1151a;
        this.f1151a = i + ((int) (i * this.f1154d));
        if (!d()) {
            throw tVar;
        }
    }

    @Override // b.a.a.q
    public int b() {
        return this.f1151a;
    }

    @Override // b.a.a.q
    public int c() {
        return this.f1152b;
    }

    protected boolean d() {
        return this.f1152b <= this.f1153c;
    }
}
