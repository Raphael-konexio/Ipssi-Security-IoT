package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private io.flutter.view.c f2638a;

    public boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.c cVar = this.f2638a;
        if (cVar == null) {
            return false;
        }
        return cVar.r(view, view2, accessibilityEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(io.flutter.view.c cVar) {
        this.f2638a = cVar;
    }
}
