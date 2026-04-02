package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public interface l extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends b.c.a.a.d.b.b implements l {

        /* renamed from: com.google.android.gms.common.internal.l$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0079a extends b.c.a.a.d.b.a implements l {
            C0079a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
            }

            @Override // com.google.android.gms.common.internal.l
            public final Account c() {
                Parcel g = g(2, d());
                Account account = (Account) b.c.a.a.d.b.c.b(g, Account.CREATOR);
                g.recycle();
                return account;
            }
        }

        public static l g(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return queryLocalInterface instanceof l ? (l) queryLocalInterface : new C0079a(iBinder);
        }
    }

    Account c();
}
