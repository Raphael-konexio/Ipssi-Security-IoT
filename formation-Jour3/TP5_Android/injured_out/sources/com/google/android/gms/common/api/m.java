package com.google.android.gms.common.api;
/* loaded from: classes.dex */
public final class m extends UnsupportedOperationException {
    private final b.c.a.a.b.c f;

    public m(b.c.a.a.b.c cVar) {
        this.f = cVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        String valueOf = String.valueOf(this.f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 8);
        sb.append("Missing ");
        sb.append(valueOf);
        return sb.toString();
    }
}
