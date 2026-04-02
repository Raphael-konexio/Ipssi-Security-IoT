package b.c.a.b.l;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f1349a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f1350b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f1351c = new Matrix();

    public Matrix a(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f1349a);
        matrix2.getValues(this.f1350b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.f1350b;
            float f2 = fArr[i];
            float[] fArr2 = this.f1349a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.f1351c.setValues(this.f1350b);
        return this.f1351c;
    }
}
