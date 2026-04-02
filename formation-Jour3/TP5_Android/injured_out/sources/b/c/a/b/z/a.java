package b.c.a.b.z;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
/* loaded from: classes.dex */
public class a {
    private static final int[] h = new int[3];
    private static final float[] i = {0.0f, 0.5f, 1.0f};
    private static final int[] j = new int[4];
    private static final float[] k = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: a  reason: collision with root package name */
    private final Paint f1395a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f1396b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f1397c;

    /* renamed from: d  reason: collision with root package name */
    private int f1398d;
    private int e;
    private int f;
    private final Path g;

    public a() {
        this(-16777216);
    }

    public a(int i2) {
        this.g = new Path();
        d(i2);
        Paint paint = new Paint(4);
        this.f1396b = paint;
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f1395a = paint2;
        paint2.setColor(this.f1398d);
        this.f1397c = new Paint(this.f1396b);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i2, float f, float f2) {
        boolean z = f2 < 0.0f;
        Path path = this.g;
        if (z) {
            int[] iArr = j;
            iArr[0] = 0;
            iArr[1] = this.f;
            iArr[2] = this.e;
            iArr[3] = this.f1398d;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f, f2);
            path.close();
            float f3 = -i2;
            rectF.inset(f3, f3);
            int[] iArr2 = j;
            iArr2[0] = 0;
            iArr2[1] = this.f1398d;
            iArr2[2] = this.e;
            iArr2[3] = this.f;
        }
        float width = 1.0f - (i2 / (rectF.width() / 2.0f));
        float[] fArr = k;
        fArr[1] = width;
        fArr[2] = ((1.0f - width) / 2.0f) + width;
        this.f1396b.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, j, k, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
        }
        canvas.drawArc(rectF, f, f2, true, this.f1396b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = h;
        iArr[0] = this.f;
        iArr[1] = this.e;
        iArr[2] = this.f1398d;
        Paint paint = this.f1397c;
        float f = rectF.left;
        paint.setShader(new LinearGradient(f, rectF.top, f, rectF.bottom, h, i, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f1397c);
        canvas.restore();
    }

    public Paint c() {
        return this.f1395a;
    }

    public void d(int i2) {
        this.f1398d = a.g.d.a.d(i2, 68);
        this.e = a.g.d.a.d(i2, 20);
        this.f = a.g.d.a.d(i2, 0);
    }
}
