package com.google.firebase.auth.z.a;

import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class v0 extends d implements a.d {
    private final String g;

    private v0(String str) {
        com.google.android.gms.common.internal.r.g(str, "A valid API key must be provided");
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v0(String str, w0 w0Var) {
        this(str);
    }

    @Override // com.google.firebase.auth.z.a.d
    public final /* synthetic */ d b() {
        return (v0) clone();
    }

    @Override // com.google.firebase.auth.z.a.d
    public final /* synthetic */ Object clone() {
        return new y0(this.g).a();
    }

    public final String d() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v0) {
            return com.google.android.gms.common.internal.q.a(this.g, ((v0) obj).g);
        }
        return false;
    }

    public final int hashCode() {
        return com.google.android.gms.common.internal.q.b(this.g);
    }
}
