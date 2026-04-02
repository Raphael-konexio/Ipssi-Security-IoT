package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1622a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static i f1623b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f1624a;

        /* renamed from: b  reason: collision with root package name */
        private final String f1625b;

        /* renamed from: c  reason: collision with root package name */
        private final ComponentName f1626c;

        /* renamed from: d  reason: collision with root package name */
        private final int f1627d;

        public a(String str, String str2, int i) {
            r.f(str);
            this.f1624a = str;
            r.f(str2);
            this.f1625b = str2;
            this.f1626c = null;
            this.f1627d = i;
        }

        public final ComponentName a() {
            return this.f1626c;
        }

        public final String b() {
            return this.f1625b;
        }

        public final Intent c(Context context) {
            return this.f1624a != null ? new Intent(this.f1624a).setPackage(this.f1625b) : new Intent().setComponent(this.f1626c);
        }

        public final int d() {
            return this.f1627d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return q.a(this.f1624a, aVar.f1624a) && q.a(this.f1625b, aVar.f1625b) && q.a(this.f1626c, aVar.f1626c) && this.f1627d == aVar.f1627d;
            }
            return false;
        }

        public final int hashCode() {
            return q.b(this.f1624a, this.f1625b, this.f1626c, Integer.valueOf(this.f1627d));
        }

        public final String toString() {
            String str = this.f1624a;
            return str == null ? this.f1626c.flattenToString() : str;
        }
    }

    public static i a(Context context) {
        synchronized (f1622a) {
            if (f1623b == null) {
                f1623b = new f0(context.getApplicationContext());
            }
        }
        return f1623b;
    }

    public final void b(String str, String str2, int i, ServiceConnection serviceConnection, String str3) {
        d(new a(str, str2, i), serviceConnection, str3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean c(a aVar, ServiceConnection serviceConnection, String str);

    protected abstract void d(a aVar, ServiceConnection serviceConnection, String str);
}
