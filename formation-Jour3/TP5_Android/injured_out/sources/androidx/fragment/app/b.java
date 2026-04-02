package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.t;
import androidx.lifecycle.e;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();
    final int[] f;
    final ArrayList<String> g;
    final int[] h;
    final int[] i;
    final int j;
    final String k;
    final int l;
    final int m;
    final CharSequence n;
    final int o;
    final CharSequence p;
    final ArrayList<String> q;
    final ArrayList<String> r;
    final boolean s;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<b> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public b[] newArray(int i) {
            return new b[i];
        }
    }

    public b(Parcel parcel) {
        this.f = parcel.createIntArray();
        this.g = parcel.createStringArrayList();
        this.h = parcel.createIntArray();
        this.i = parcel.createIntArray();
        this.j = parcel.readInt();
        this.k = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
        this.n = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.o = parcel.readInt();
        this.p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.q = parcel.createStringArrayList();
        this.r = parcel.createStringArrayList();
        this.s = parcel.readInt() != 0;
    }

    public b(androidx.fragment.app.a aVar) {
        int size = aVar.f831a.size();
        this.f = new int[size * 5];
        if (!aVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.g = new ArrayList<>(size);
        this.h = new int[size];
        this.i = new int[size];
        int i = 0;
        int i2 = 0;
        while (i < size) {
            t.a aVar2 = aVar.f831a.get(i);
            int i3 = i2 + 1;
            this.f[i2] = aVar2.f835a;
            ArrayList<String> arrayList = this.g;
            Fragment fragment = aVar2.f836b;
            arrayList.add(fragment != null ? fragment.j : null);
            int[] iArr = this.f;
            int i4 = i3 + 1;
            iArr[i3] = aVar2.f837c;
            int i5 = i4 + 1;
            iArr[i4] = aVar2.f838d;
            int i6 = i5 + 1;
            iArr[i5] = aVar2.e;
            iArr[i6] = aVar2.f;
            this.h[i] = aVar2.g.ordinal();
            this.i[i] = aVar2.h.ordinal();
            i++;
            i2 = i6 + 1;
        }
        this.j = aVar.f;
        this.k = aVar.i;
        this.l = aVar.t;
        this.m = aVar.j;
        this.n = aVar.k;
        this.o = aVar.l;
        this.p = aVar.m;
        this.q = aVar.n;
        this.r = aVar.o;
        this.s = aVar.p;
    }

    public androidx.fragment.app.a a(m mVar) {
        androidx.fragment.app.a aVar = new androidx.fragment.app.a(mVar);
        int i = 0;
        int i2 = 0;
        while (i < this.f.length) {
            t.a aVar2 = new t.a();
            int i3 = i + 1;
            aVar2.f835a = this.f[i];
            if (m.p0(2)) {
                Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i2 + " base fragment #" + this.f[i3]);
            }
            String str = this.g.get(i2);
            aVar2.f836b = str != null ? mVar.V(str) : null;
            aVar2.g = e.b.values()[this.h[i2]];
            aVar2.h = e.b.values()[this.i[i2]];
            int[] iArr = this.f;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            aVar2.f837c = i5;
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            aVar2.f838d = i7;
            int i8 = i6 + 1;
            int i9 = iArr[i6];
            aVar2.e = i9;
            int i10 = iArr[i8];
            aVar2.f = i10;
            aVar.f832b = i5;
            aVar.f833c = i7;
            aVar.f834d = i9;
            aVar.e = i10;
            aVar.e(aVar2);
            i2++;
            i = i8 + 1;
        }
        aVar.f = this.j;
        aVar.i = this.k;
        aVar.t = this.l;
        aVar.g = true;
        aVar.j = this.m;
        aVar.k = this.n;
        aVar.l = this.o;
        aVar.m = this.p;
        aVar.n = this.q;
        aVar.o = this.r;
        aVar.p = this.s;
        aVar.t(1);
        return aVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f);
        parcel.writeStringList(this.g);
        parcel.writeIntArray(this.h);
        parcel.writeIntArray(this.i);
        parcel.writeInt(this.j);
        parcel.writeString(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
        TextUtils.writeToParcel(this.n, parcel, 0);
        parcel.writeInt(this.o);
        TextUtils.writeToParcel(this.p, parcel, 0);
        parcel.writeStringList(this.q);
        parcel.writeStringList(this.r);
        parcel.writeInt(this.s ? 1 : 0);
    }
}
