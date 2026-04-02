package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements Parcelable {
    public static final Parcelable.Creator<o> CREATOR = new a();
    ArrayList<q> f;
    ArrayList<String> g;
    b[] h;
    int i;
    String j;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<o> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public o[] newArray(int i) {
            return new o[i];
        }
    }

    public o() {
        this.j = null;
    }

    public o(Parcel parcel) {
        this.j = null;
        this.f = parcel.createTypedArrayList(q.CREATOR);
        this.g = parcel.createStringArrayList();
        this.h = (b[]) parcel.createTypedArray(b.CREATOR);
        this.i = parcel.readInt();
        this.j = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f);
        parcel.writeStringList(this.g);
        parcel.writeTypedArray(this.h, i);
        parcel.writeInt(this.i);
        parcel.writeString(this.j);
    }
}
