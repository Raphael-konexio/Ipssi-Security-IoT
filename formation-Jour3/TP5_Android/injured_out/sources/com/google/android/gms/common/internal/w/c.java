package com.google.android.gms.common.internal.w;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    public static int a(Parcel parcel) {
        return o(parcel, 20293);
    }

    public static void b(Parcel parcel, int i) {
        q(parcel, i);
    }

    public static void c(Parcel parcel, int i, boolean z) {
        r(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void d(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            r(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            r(parcel, i, 0);
        }
    }

    public static void e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcel.writeBundle(bundle);
        q(parcel, o);
    }

    public static void f(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcel.writeStrongBinder(iBinder);
        q(parcel, o);
    }

    public static void g(Parcel parcel, int i, int i2) {
        r(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void h(Parcel parcel, int i, long j) {
        r(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void i(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            r(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            r(parcel, i, 0);
        }
    }

    public static void j(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcelable.writeToParcel(parcel, i2);
        q(parcel, o);
    }

    public static void k(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcel.writeString(str);
        q(parcel, o);
    }

    public static void l(Parcel parcel, int i, List<String> list, boolean z) {
        if (list == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcel.writeStringList(list);
        q(parcel, o);
    }

    public static <T extends Parcelable> void m(Parcel parcel, int i, T[] tArr, int i2, boolean z) {
        if (tArr == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        parcel.writeInt(tArr.length);
        for (T t : tArr) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                p(parcel, t, i2);
            }
        }
        q(parcel, o);
    }

    public static <T extends Parcelable> void n(Parcel parcel, int i, List<T> list, boolean z) {
        if (list == null) {
            if (z) {
                r(parcel, i, 0);
                return;
            }
            return;
        }
        int o = o(parcel, i);
        int size = list.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t == null) {
                parcel.writeInt(0);
            } else {
                p(parcel, t, 0);
            }
        }
        q(parcel, o);
    }

    private static int o(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static <T extends Parcelable> void p(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    private static void q(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    private static void r(Parcel parcel, int i, int i2) {
        if (i2 < 65535) {
            parcel.writeInt(i | (i2 << 16));
            return;
        }
        parcel.writeInt(i | (-65536));
        parcel.writeInt(i2);
    }
}
