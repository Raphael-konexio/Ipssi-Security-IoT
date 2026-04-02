package androidx.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new a();
    private final UUID f;
    private final int g;
    private final Bundle h;
    private final Bundle i;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<f> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public f[] newArray(int i) {
            return new f[i];
        }
    }

    f(Parcel parcel) {
        this.f = UUID.fromString(parcel.readString());
        this.g = parcel.readInt();
        this.h = parcel.readBundle(f.class.getClassLoader());
        this.i = parcel.readBundle(f.class.getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f = eVar.j;
        this.g = eVar.c().s();
        this.h = eVar.b();
        Bundle bundle = new Bundle();
        this.i = bundle;
        eVar.k(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UUID h() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f.toString());
        parcel.writeInt(this.g);
        parcel.writeBundle(this.h);
        parcel.writeBundle(this.i);
    }
}
