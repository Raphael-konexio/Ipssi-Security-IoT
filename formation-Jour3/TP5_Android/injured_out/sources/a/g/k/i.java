package a.g.k;

import android.view.MotionEvent;
/* loaded from: classes.dex */
public final class i {
    public static boolean a(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
