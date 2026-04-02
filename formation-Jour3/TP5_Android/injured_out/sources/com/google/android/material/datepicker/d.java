package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;
/* loaded from: classes.dex */
public interface d<S> extends Parcelable {
    String d(Context context);

    int e(Context context);

    Collection<a.g.j.e<Long, Long>> f();

    boolean i();

    Collection<Long> l();

    S m();

    void s(long j);

    View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, o<S> oVar);
}
