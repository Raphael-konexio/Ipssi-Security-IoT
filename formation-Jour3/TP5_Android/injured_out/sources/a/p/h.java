package a.p;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;
/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* renamed from: a  reason: collision with root package name */
    private final Property<T, PointF> f369a;

    /* renamed from: b  reason: collision with root package name */
    private final PathMeasure f370b;

    /* renamed from: c  reason: collision with root package name */
    private final float f371c;

    /* renamed from: d  reason: collision with root package name */
    private final float[] f372d;
    private final PointF e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f372d = new float[2];
        this.e = new PointF();
        this.f369a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f370b = pathMeasure;
        this.f371c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: b */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.f370b.getPosTan(this.f371c * f.floatValue(), this.f372d, null);
        PointF pointF = this.e;
        float[] fArr = this.f372d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f369a.set(t, pointF);
    }
}
