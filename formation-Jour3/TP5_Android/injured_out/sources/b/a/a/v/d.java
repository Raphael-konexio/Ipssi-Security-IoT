package b.a.a.v;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public class d {
    protected static final Comparator<byte[]> e = new a();

    /* renamed from: a  reason: collision with root package name */
    private final List<byte[]> f1184a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final List<byte[]> f1185b = new ArrayList(64);

    /* renamed from: c  reason: collision with root package name */
    private int f1186c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final int f1187d;

    /* loaded from: classes.dex */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i) {
        this.f1187d = i;
    }

    private synchronized void c() {
        while (this.f1186c > this.f1187d) {
            byte[] remove = this.f1184a.remove(0);
            this.f1185b.remove(remove);
            this.f1186c -= remove.length;
        }
    }

    public synchronized byte[] a(int i) {
        for (int i2 = 0; i2 < this.f1185b.size(); i2++) {
            byte[] bArr = this.f1185b.get(i2);
            if (bArr.length >= i) {
                this.f1186c -= bArr.length;
                this.f1185b.remove(i2);
                this.f1184a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f1187d) {
                this.f1184a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f1185b, bArr, e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f1185b.add(binarySearch, bArr);
                this.f1186c += bArr.length;
                c();
            }
        }
    }
}
