package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Comparable<l>, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new a();
    private final Calendar f;
    private final String g;
    final int h;
    final int i;
    final int j;
    final int k;
    final long l;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<l> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return l.x(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public l[] newArray(int i) {
            return new l[i];
        }
    }

    private l(Calendar calendar) {
        calendar.set(5, 1);
        Calendar d2 = r.d(calendar);
        this.f = d2;
        this.h = d2.get(2);
        this.i = this.f.get(1);
        this.j = this.f.getMaximum(7);
        this.k = this.f.getActualMaximum(5);
        this.g = r.n().format(this.f.getTime());
        this.l = this.f.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l F() {
        return new l(r.i());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l x(int i, int i2) {
        Calendar k = r.k();
        k.set(1, i);
        k.set(2, i2);
        return new l(k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l y(long j) {
        Calendar k = r.k();
        k.setTimeInMillis(j);
        return new l(k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long A(int i) {
        Calendar d2 = r.d(this.f);
        d2.set(5, i);
        return d2.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String B() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long C() {
        return this.f.getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l D(int i) {
        Calendar d2 = r.d(this.f);
        d2.add(2, i);
        return new l(d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int E(l lVar) {
        if (this.f instanceof GregorianCalendar) {
            return ((lVar.i - this.i) * 12) + (lVar.h - this.h);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            return this.h == lVar.h && this.i == lVar.i;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.h), Integer.valueOf(this.i)});
    }

    @Override // java.lang.Comparable
    /* renamed from: w */
    public int compareTo(l lVar) {
        return this.f.compareTo(lVar.f);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.i);
        parcel.writeInt(this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z() {
        int firstDayOfWeek = this.f.get(7) - this.f.getFirstDayOfWeek();
        return firstDayOfWeek < 0 ? firstDayOfWeek + this.j : firstDayOfWeek;
    }
}
