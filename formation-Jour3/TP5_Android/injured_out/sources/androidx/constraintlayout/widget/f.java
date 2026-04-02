package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class f extends View {
    private int f;
    private View g;
    private int h;

    public void a(ConstraintLayout constraintLayout) {
        if (this.g == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.g.getLayoutParams();
        aVar2.k0.x0(0);
        aVar.k0.y0(aVar2.k0.D());
        aVar.k0.b0(aVar2.k0.r());
        aVar2.k0.x0(8);
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f == -1 && !isInEditMode()) {
            setVisibility(this.h);
        }
        View findViewById = constraintLayout.findViewById(this.f);
        this.g = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.a) findViewById.getLayoutParams()).Z = true;
            this.g.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.g;
    }

    public int getEmptyVisibility() {
        return this.h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f == i) {
            return;
        }
        View view = this.g;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.g.getLayoutParams()).Z = false;
            this.g = null;
        }
        this.f = i;
        if (i == -1 || (findViewById = ((View) getParent()).findViewById(i)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int i) {
        this.h = i;
    }
}
