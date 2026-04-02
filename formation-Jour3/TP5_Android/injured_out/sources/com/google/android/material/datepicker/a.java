package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0082a();
    private final l f;
    private final l g;
    private final l h;
    private final c i;
    private final int j;
    private final int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.android.material.datepicker.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0082a implements Parcelable.Creator<a> {
        C0082a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a((l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (l) parcel.readParcelable(l.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public a[] newArray(int i) {
            return new a[i];
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        static final long e = r.a(l.x(1900, 0).l);
        static final long f = r.a(l.x(2100, 11).l);

        /* renamed from: a  reason: collision with root package name */
        private long f1714a;

        /* renamed from: b  reason: collision with root package name */
        private long f1715b;

        /* renamed from: c  reason: collision with root package name */
        private Long f1716c;

        /* renamed from: d  reason: collision with root package name */
        private c f1717d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(a aVar) {
            this.f1714a = e;
            this.f1715b = f;
            this.f1717d = f.a(Long.MIN_VALUE);
            this.f1714a = aVar.f.l;
            this.f1715b = aVar.g.l;
            this.f1716c = Long.valueOf(aVar.h.l);
            this.f1717d = aVar.i;
        }

        public a a() {
            if (this.f1716c == null) {
                long S1 = i.S1();
                if (this.f1714a > S1 || S1 > this.f1715b) {
                    S1 = this.f1714a;
                }
                this.f1716c = Long.valueOf(S1);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("DEEP_COPY_VALIDATOR_KEY", this.f1717d);
            return new a(l.y(this.f1714a), l.y(this.f1715b), l.y(this.f1716c.longValue()), (c) bundle.getParcelable("DEEP_COPY_VALIDATOR_KEY"), null);
        }

        public b b(long j) {
            this.f1716c = Long.valueOf(j);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c extends Parcelable {
        boolean g(long j);
    }

    private a(l lVar, l lVar2, l lVar3, c cVar) {
        this.f = lVar;
        this.g = lVar2;
        this.h = lVar3;
        this.i = cVar;
        if (lVar.compareTo(lVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (lVar3.compareTo(lVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.k = lVar.E(lVar2) + 1;
        this.j = (lVar2.i - lVar.i) + 1;
    }

    /* synthetic */ a(l lVar, l lVar2, l lVar3, c cVar, C0082a c0082a) {
        this(lVar, lVar2, lVar3, cVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f.equals(aVar.f) && this.g.equals(aVar.g) && this.h.equals(aVar.h) && this.i.equals(aVar.i);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f, this.g, this.h, this.i});
    }

    public c j() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l k() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int n() {
        return this.k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l o() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l p() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f, 0);
        parcel.writeParcelable(this.g, 0);
        parcel.writeParcelable(this.h, 0);
        parcel.writeParcelable(this.i, 0);
    }
}
