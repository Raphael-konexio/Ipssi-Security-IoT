package b.c.a.a.b;

import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
abstract class s extends q {

    /* renamed from: c  reason: collision with root package name */
    private static final WeakReference<byte[]> f1235c = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<byte[]> f1236b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(byte[] bArr) {
        super(bArr);
        this.f1236b = f1235c;
    }

    protected abstract byte[] Y();

    @Override // b.c.a.a.b.q
    final byte[] g() {
        byte[] bArr;
        synchronized (this) {
            bArr = this.f1236b.get();
            if (bArr == null) {
                bArr = Y();
                this.f1236b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
