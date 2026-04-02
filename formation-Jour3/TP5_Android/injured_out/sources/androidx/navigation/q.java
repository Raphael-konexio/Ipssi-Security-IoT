package androidx.navigation;

import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class q {
    public static NavController a(View view) {
        NavController b2 = b(view);
        if (b2 != null) {
            return b2;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private static NavController b(View view) {
        while (view != null) {
            NavController c2 = c(view);
            if (c2 != null) {
                return c2;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private static NavController c(View view) {
        Object tag = view.getTag(t.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            tag = ((WeakReference) tag).get();
        } else if (!(tag instanceof NavController)) {
            return null;
        }
        return (NavController) tag;
    }

    public static void d(View view, NavController navController) {
        view.setTag(t.nav_controller_view_tag, navController);
    }
}
