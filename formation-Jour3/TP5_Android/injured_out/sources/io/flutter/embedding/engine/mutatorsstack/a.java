package io.flutter.embedding.engine.mutatorsstack;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import io.flutter.embedding.android.b;
/* loaded from: classes.dex */
public class a extends FrameLayout {
    private FlutterMutatorsStack f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private final b l;

    public a(Context context, float f, b bVar) {
        super(context, null);
        this.g = f;
        this.l = bVar;
    }

    private Matrix getPlatformViewMatrix() {
        Matrix matrix = new Matrix(this.f.getFinalMatrix());
        float f = this.g;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate(-this.h, -this.i);
        return matrix;
    }

    public void a(FlutterMutatorsStack flutterMutatorsStack, int i, int i2, int i3, int i4) {
        this.f = flutterMutatorsStack;
        this.h = i;
        this.i = i2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.leftMargin = i;
        layoutParams.topMargin = i2;
        setLayoutParams(layoutParams);
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        canvas.save();
        for (Path path : this.f.getFinalClippingPaths()) {
            Path path2 = new Path(path);
            path2.offset(-this.h, -this.i);
            canvas.clipPath(path2);
        }
        super.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        float f;
        if (this.l == null) {
            return super.onTouchEvent(motionEvent);
        }
        Matrix matrix = new Matrix();
        int action = motionEvent.getAction();
        if (action == 0) {
            int i2 = this.h;
            this.j = i2;
            i = this.i;
            this.k = i;
            f = i2;
        } else if (action == 2) {
            matrix.postTranslate(this.j, this.k);
            this.j = this.h;
            this.k = this.i;
            return this.l.f(motionEvent, matrix);
        } else {
            f = this.h;
            i = this.i;
        }
        matrix.postTranslate(f, i);
        return this.l.f(motionEvent, matrix);
    }
}
