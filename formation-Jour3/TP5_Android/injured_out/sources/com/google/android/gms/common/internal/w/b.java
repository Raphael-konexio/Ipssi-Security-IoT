package com.google.android.gms.common.internal.w;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public a(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                int r1 = r1 + 41
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.w.b.a.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static Bundle a(Parcel parcel, int i) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + p);
        return readBundle;
    }

    public static <T extends Parcelable> T b(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + p);
        return createFromParcel;
    }

    public static String c(Parcel parcel, int i) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + p);
        return readString;
    }

    public static ArrayList<String> d(Parcel parcel, int i) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + p);
        return createStringArrayList;
    }

    public static <T> T[] e(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + p);
        return tArr;
    }

    public static <T> ArrayList<T> f(Parcel parcel, int i, Parcelable.Creator<T> creator) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + p);
        return createTypedArrayList;
    }

    public static void g(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Overread allowed size end=");
        sb.append(i);
        throw new a(sb.toString(), parcel);
    }

    public static int h(int i) {
        return i & 65535;
    }

    public static boolean i(Parcel parcel, int i) {
        s(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean j(Parcel parcel, int i) {
        int p = p(parcel, i);
        if (p == 0) {
            return null;
        }
        t(parcel, i, p, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static int k(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder l(Parcel parcel, int i) {
        int p = p(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (p == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + p);
        return readStrongBinder;
    }

    public static int m(Parcel parcel, int i) {
        s(parcel, i, 4);
        return parcel.readInt();
    }

    public static long n(Parcel parcel, int i) {
        s(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long o(Parcel parcel, int i) {
        int p = p(parcel, i);
        if (p == 0) {
            return null;
        }
        t(parcel, i, p, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int p(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (i >> 16) & 65535 : parcel.readInt();
    }

    public static void q(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + p(parcel, i));
    }

    public static int r(Parcel parcel) {
        int k = k(parcel);
        int p = p(parcel, k);
        int dataPosition = parcel.dataPosition();
        if (h(k) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(k));
            throw new a(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i = p + dataPosition;
        if (i < dataPosition || i > parcel.dataSize()) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("Size read is invalid start=");
            sb.append(dataPosition);
            sb.append(" end=");
            sb.append(i);
            throw new a(sb.toString(), parcel);
        }
        return i;
    }

    private static void s(Parcel parcel, int i, int i2) {
        int p = p(parcel, i);
        if (p == i2) {
            return;
        }
        String hexString = Integer.toHexString(p);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i2);
        sb.append(" got ");
        sb.append(p);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }

    private static void t(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        String hexString = Integer.toHexString(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
        sb.append("Expected size ");
        sb.append(i3);
        sb.append(" got ");
        sb.append(i2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }
}
