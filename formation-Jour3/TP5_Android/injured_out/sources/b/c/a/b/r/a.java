package b.c.a.b.r;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {
    private final Dialog f;
    private final int g;
    private final int h;
    private final int i;

    public a(Dialog dialog, Rect rect) {
        this.f = dialog;
        this.g = rect.left;
        this.h = rect.top;
        this.i = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.g + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.h + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(4);
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i = this.i;
            obtain.setLocation((-i) - 1, (-i) - 1);
        }
        view.performClick();
        return this.f.onTouchEvent(obtain);
    }
}
