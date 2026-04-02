package b.c.a.a.d.c;

import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class a0<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f1243a;

    /* renamed from: b  reason: collision with root package name */
    private int f1244b;

    public a0() {
        this(4);
    }

    private a0(int i) {
        this.f1243a = new Object[8];
        this.f1244b = 0;
    }

    public final a0<K, V> a(K k, V v) {
        int i = (this.f1244b + 1) << 1;
        Object[] objArr = this.f1243a;
        if (i > objArr.length) {
            int length = objArr.length;
            if (i < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i2 = length + (length >> 1) + 1;
            if (i2 < i) {
                i2 = Integer.highestOneBit(i - 1) << 1;
            }
            if (i2 < 0) {
                i2 = Reader.READ_DONE;
            }
            this.f1243a = Arrays.copyOf(objArr, i2);
        }
        v.a(k, v);
        Object[] objArr2 = this.f1243a;
        int i3 = this.f1244b;
        objArr2[i3 * 2] = k;
        objArr2[(i3 * 2) + 1] = v;
        this.f1244b = i3 + 1;
        return this;
    }

    public final b0<K, V> b() {
        return f0.e(this.f1244b, this.f1243a);
    }
}
