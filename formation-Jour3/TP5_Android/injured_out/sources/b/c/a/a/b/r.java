package b.c.a.a.b;

import java.util.Arrays;
/* loaded from: classes.dex */
final class r extends q {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f1234b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f1234b = bArr;
    }

    @Override // b.c.a.a.b.q
    final byte[] g() {
        return this.f1234b;
    }
}
