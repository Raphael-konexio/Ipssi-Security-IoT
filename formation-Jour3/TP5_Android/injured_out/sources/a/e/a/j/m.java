package a.e.a.j;
/* loaded from: classes.dex */
public class m extends n {

    /* renamed from: c  reason: collision with root package name */
    float f121c = 0.0f;

    @Override // a.e.a.j.n
    public void e() {
        super.e();
        this.f121c = 0.0f;
    }

    public void g() {
        this.f123b = 2;
    }

    public void h(int i) {
        if (this.f123b == 0 || this.f121c != i) {
            this.f121c = i;
            if (this.f123b == 1) {
                c();
            }
            b();
        }
    }
}
