package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class k<S> extends p<S> {
    private d<S> c0;
    private com.google.android.material.datepicker.a d0;

    /* loaded from: classes.dex */
    class a implements o<S> {
        a() {
        }

        @Override // com.google.android.material.datepicker.o
        public void a(S s) {
            Iterator<o<S>> it = k.this.b0.iterator();
            while (it.hasNext()) {
                it.next().a(s);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> k<T> s1(d<T> dVar, com.google.android.material.datepicker.a aVar) {
        k<T> kVar = new k<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATE_SELECTOR_KEY", dVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar);
        kVar.j1(bundle);
        return kVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void A0(Bundle bundle) {
        super.A0(bundle);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.c0);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.d0);
    }

    @Override // androidx.fragment.app.Fragment
    public void e0(Bundle bundle) {
        super.e0(bundle);
        if (bundle == null) {
            bundle = p();
        }
        this.c0 = (d) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.d0 = (com.google.android.material.datepicker.a) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.c0.u(layoutInflater, viewGroup, bundle, this.d0, new a());
    }
}
