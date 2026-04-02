package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    TextInputLayout f1846a;

    /* renamed from: b  reason: collision with root package name */
    Context f1847b;

    /* renamed from: c  reason: collision with root package name */
    CheckableImageButton f1848c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(TextInputLayout textInputLayout) {
        this.f1846a = textInputLayout;
        this.f1847b = textInputLayout.getContext();
        this.f1848c = textInputLayout.getEndIconView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return false;
    }
}
