package a.e.a;

import java.util.Arrays;
/* loaded from: classes.dex */
public class i {
    private static int k = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f94a;
    public float e;
    a g;

    /* renamed from: b  reason: collision with root package name */
    public int f95b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f96c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f97d = 0;
    float[] f = new float[7];
    b[] h = new b[8];
    int i = 0;
    public int j = 0;

    /* loaded from: classes.dex */
    public enum a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public i(a aVar, String str) {
        this.g = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        k++;
    }

    public final void a(b bVar) {
        int i = 0;
        while (true) {
            int i2 = this.i;
            if (i >= i2) {
                b[] bVarArr = this.h;
                if (i2 >= bVarArr.length) {
                    this.h = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.h;
                int i3 = this.i;
                bVarArr2[i3] = bVar;
                this.i = i3 + 1;
                return;
            } else if (this.h[i] == bVar) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void c(b bVar) {
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.h[i2] == bVar) {
                for (int i3 = 0; i3 < (i - i2) - 1; i3++) {
                    b[] bVarArr = this.h;
                    int i4 = i2 + i3;
                    bVarArr[i4] = bVarArr[i4 + 1];
                }
                this.i--;
                return;
            }
        }
    }

    public void d() {
        this.f94a = null;
        this.g = a.UNKNOWN;
        this.f97d = 0;
        this.f95b = -1;
        this.f96c = -1;
        this.e = 0.0f;
        this.i = 0;
        this.j = 0;
    }

    public void e(a aVar, String str) {
        this.g = aVar;
    }

    public final void f(b bVar) {
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            b[] bVarArr = this.h;
            bVarArr[i2].f80d.n(bVarArr[i2], bVar, false);
        }
        this.i = 0;
    }

    public String toString() {
        return "" + this.f94a;
    }
}
