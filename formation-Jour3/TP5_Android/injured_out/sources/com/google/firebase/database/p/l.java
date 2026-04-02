package com.google.firebase.database.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class l implements Iterable<com.google.firebase.database.r.b>, Comparable<l> {
    private static final l i = new l("");
    private final com.google.firebase.database.r.b[] f;
    private final int g;
    private final int h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Iterator<com.google.firebase.database.r.b> {
        int f;

        a() {
            this.f = l.this.g;
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public com.google.firebase.database.r.b next() {
            if (hasNext()) {
                com.google.firebase.database.r.b[] bVarArr = l.this.f;
                int i = this.f;
                com.google.firebase.database.r.b bVar = bVarArr[i];
                this.f = i + 1;
                return bVar;
            }
            throw new NoSuchElementException("No more elements.");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f < l.this.h;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove component from immutable Path!");
        }
    }

    public l(String str) {
        String[] split = str.split("/", -1);
        int i2 = 0;
        for (String str2 : split) {
            if (str2.length() > 0) {
                i2++;
            }
        }
        this.f = new com.google.firebase.database.r.b[i2];
        int i3 = 0;
        for (String str3 : split) {
            if (str3.length() > 0) {
                this.f[i3] = com.google.firebase.database.r.b.g(str3);
                i3++;
            }
        }
        this.g = 0;
        this.h = this.f.length;
    }

    public l(List<String> list) {
        this.f = new com.google.firebase.database.r.b[list.size()];
        int i2 = 0;
        for (String str : list) {
            this.f[i2] = com.google.firebase.database.r.b.g(str);
            i2++;
        }
        this.g = 0;
        this.h = list.size();
    }

    public l(com.google.firebase.database.r.b... bVarArr) {
        this.f = (com.google.firebase.database.r.b[]) Arrays.copyOf(bVarArr, bVarArr.length);
        this.g = 0;
        this.h = bVarArr.length;
        for (com.google.firebase.database.r.b bVar : bVarArr) {
        }
    }

    private l(com.google.firebase.database.r.b[] bVarArr, int i2, int i3) {
        this.f = bVarArr;
        this.g = i2;
        this.h = i3;
    }

    public static l w() {
        return i;
    }

    public static l z(l lVar, l lVar2) {
        com.google.firebase.database.r.b x = lVar.x();
        com.google.firebase.database.r.b x2 = lVar2.x();
        if (x == null) {
            return lVar2;
        }
        if (x.equals(x2)) {
            return z(lVar.A(), lVar2.A());
        }
        throw new com.google.firebase.database.c("INTERNAL ERROR: " + lVar2 + " is not contained in " + lVar);
    }

    public l A() {
        int i2 = this.g;
        if (!isEmpty()) {
            i2++;
        }
        return new l(this.f, i2, this.h);
    }

    public String B() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = this.g; i2 < this.h; i2++) {
            if (i2 > this.g) {
                sb.append("/");
            }
            sb.append(this.f[i2].e());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            if (this == obj) {
                return true;
            }
            l lVar = (l) obj;
            if (size() != lVar.size()) {
                return false;
            }
            int i2 = this.g;
            for (int i3 = lVar.g; i2 < this.h && i3 < lVar.h; i3++) {
                if (!this.f[i2].equals(lVar.f[i3])) {
                    return false;
                }
                i2++;
            }
            return true;
        }
        return false;
    }

    public List<String> g() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<com.google.firebase.database.r.b> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().e());
        }
        return arrayList;
    }

    public int hashCode() {
        int i2 = 0;
        for (int i3 = this.g; i3 < this.h; i3++) {
            i2 = (i2 * 37) + this.f[i3].hashCode();
        }
        return i2;
    }

    public l i(l lVar) {
        int size = size() + lVar.size();
        com.google.firebase.database.r.b[] bVarArr = new com.google.firebase.database.r.b[size];
        System.arraycopy(this.f, this.g, bVarArr, 0, size());
        System.arraycopy(lVar.f, lVar.g, bVarArr, size(), lVar.size());
        return new l(bVarArr, 0, size);
    }

    public boolean isEmpty() {
        return this.g >= this.h;
    }

    @Override // java.lang.Iterable
    public Iterator<com.google.firebase.database.r.b> iterator() {
        return new a();
    }

    public l l(com.google.firebase.database.r.b bVar) {
        int size = size();
        int i2 = size + 1;
        com.google.firebase.database.r.b[] bVarArr = new com.google.firebase.database.r.b[i2];
        System.arraycopy(this.f, this.g, bVarArr, 0, size);
        bVarArr[size] = bVar;
        return new l(bVarArr, 0, i2);
    }

    @Override // java.lang.Comparable
    /* renamed from: m */
    public int compareTo(l lVar) {
        int i2 = this.g;
        int i3 = lVar.g;
        while (i2 < this.h && i3 < lVar.h) {
            int compareTo = this.f[i2].compareTo(lVar.f[i3]);
            if (compareTo != 0) {
                return compareTo;
            }
            i2++;
            i3++;
        }
        if (i2 == this.h && i3 == lVar.h) {
            return 0;
        }
        return i2 == this.h ? -1 : 1;
    }

    public boolean s(l lVar) {
        if (size() > lVar.size()) {
            return false;
        }
        int i2 = this.g;
        int i3 = lVar.g;
        while (i2 < this.h) {
            if (!this.f[i2].equals(lVar.f[i3])) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public int size() {
        return this.h - this.g;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = this.g; i2 < this.h; i2++) {
            sb.append("/");
            sb.append(this.f[i2].e());
        }
        return sb.toString();
    }

    public com.google.firebase.database.r.b u() {
        if (isEmpty()) {
            return null;
        }
        return this.f[this.h - 1];
    }

    public com.google.firebase.database.r.b x() {
        if (isEmpty()) {
            return null;
        }
        return this.f[this.g];
    }

    public l y() {
        if (isEmpty()) {
            return null;
        }
        return new l(this.f, this.g, this.h - 1);
    }
}
