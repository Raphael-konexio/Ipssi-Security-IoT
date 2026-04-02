package b.c.a.a.d.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class b implements IInterface {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f1239a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1240b;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(IBinder iBinder, String str) {
        this.f1239a = iBinder;
        this.f1240b = str;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f1239a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Parcel d() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f1240b);
        return obtain;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.f1239a.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
