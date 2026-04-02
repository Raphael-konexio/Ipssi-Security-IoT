package b.c.a.a.d.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class p implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1263a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1264b;

    /* JADX INFO: Access modifiers changed from: protected */
    public p(IBinder iBinder, String str) {
        this.f1263a = iBinder;
        this.f1264b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1263a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel d() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1264b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1263a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
