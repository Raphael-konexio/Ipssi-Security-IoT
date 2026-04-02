package a.p;

import android.view.ViewGroup;
/* loaded from: classes.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private ViewGroup f391a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f392b;

    public static l b(ViewGroup viewGroup) {
        return (l) viewGroup.getTag(j.transition_current_scene);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(ViewGroup viewGroup, l lVar) {
        viewGroup.setTag(j.transition_current_scene, lVar);
    }

    public void a() {
        Runnable runnable;
        if (b(this.f391a) != this || (runnable = this.f392b) == null) {
            return;
        }
        runnable.run();
    }
}
