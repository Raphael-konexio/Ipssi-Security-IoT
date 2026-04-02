package b.c.a.a.d.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes.dex */
public class a extends Binder implements IInterface {
    /* JADX INFO: Access modifiers changed from: protected */
    public a(String str) {
        attachInterface(this, str);
    }

    protected abstract boolean Y(int i, Parcel parcel, Parcel parcel2, int i2);

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        return Y(i, parcel, parcel2, i2);
    }
}
