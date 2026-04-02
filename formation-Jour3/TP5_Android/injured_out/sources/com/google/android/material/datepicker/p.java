package com.google.android.material.datepicker;

import androidx.fragment.app.Fragment;
import java.util.LinkedHashSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class p<S> extends Fragment {
    protected final LinkedHashSet<o<S>> b0 = new LinkedHashSet<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q1(o<S> oVar) {
        return this.b0.add(oVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r1() {
        this.b0.clear();
    }
}
