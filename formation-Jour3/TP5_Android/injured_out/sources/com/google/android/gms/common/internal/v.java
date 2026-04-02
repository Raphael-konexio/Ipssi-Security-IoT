package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f1644a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1645b;

    public v(Context context) {
        r.h(context);
        Resources resources = context.getResources();
        this.f1644a = resources;
        this.f1645b = resources.getResourcePackageName(b.c.a.a.b.i.common_google_play_services_unknown_issue);
    }

    public String a(String str) {
        int identifier = this.f1644a.getIdentifier(str, "string", this.f1645b);
        if (identifier == 0) {
            return null;
        }
        return this.f1644a.getString(identifier);
    }
}
