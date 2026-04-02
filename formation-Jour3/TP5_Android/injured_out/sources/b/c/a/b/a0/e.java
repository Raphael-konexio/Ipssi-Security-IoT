package b.c.a.b.a0;
/* loaded from: classes.dex */
public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    float f1298a = -1.0f;

    @Override // b.c.a.b.a0.d
    public void a(m mVar, float f, float f2, float f3) {
        mVar.n(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d2 = f3;
        double d3 = f2;
        mVar.l((float) (Math.sin(Math.toRadians(f)) * d2 * d3), (float) (Math.sin(Math.toRadians(90.0f - f)) * d2 * d3));
    }
}
