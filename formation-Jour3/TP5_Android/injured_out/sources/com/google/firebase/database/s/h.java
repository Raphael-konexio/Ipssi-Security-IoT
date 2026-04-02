package com.google.firebase.database.s;

import com.google.firebase.database.s.a;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
class h {

    /* renamed from: b  reason: collision with root package name */
    private c f2389b;
    private a.b e;

    /* renamed from: a  reason: collision with root package name */
    private DataInputStream f2388a = null;

    /* renamed from: c  reason: collision with root package name */
    private d f2390c = null;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f2391d = new byte[112];
    private volatile boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.f2389b = null;
        this.f2389b = cVar;
    }

    private void a(boolean z, byte b2, byte[] bArr) {
        if (b2 == 9) {
            if (!z) {
                throw new e("PING must not fragment across frames");
            }
            c(bArr);
        } else if (this.e != null && b2 != 0) {
            throw new e("Failed to continue outstanding frame");
        } else {
            if (this.e == null && b2 == 0) {
                throw new e("Received continuing frame, but there's nothing to continue");
            }
            if (this.e == null) {
                this.e = a.a(b2);
            }
            if (!this.e.a(bArr)) {
                throw new e("Failed to decode frame");
            }
            if (z) {
                g b3 = this.e.b();
                this.e = null;
                if (b3 == null) {
                    throw new e("Failed to decode whole message");
                }
                this.f2390c.e(b3);
            }
        }
    }

    private void b(e eVar) {
        h();
        this.f2389b.k(eVar);
    }

    private void c(byte[] bArr) {
        if (bArr.length > 125) {
            throw new e("PING frame too long");
        }
        this.f2389b.m(bArr);
    }

    private long d(byte[] bArr, int i) {
        return (bArr[i + 0] << 56) + ((bArr[i + 1] & 255) << 48) + ((bArr[i + 2] & 255) << 40) + ((bArr[i + 3] & 255) << 32) + ((bArr[i + 4] & 255) << 24) + ((bArr[i + 5] & 255) << 16) + ((bArr[i + 6] & 255) << 8) + ((bArr[i + 7] & 255) << 0);
    }

    private int e(byte[] bArr, int i, int i2) {
        this.f2388a.readFully(bArr, i, i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        boolean z;
        this.f2390c = this.f2389b.g();
        while (!this.f) {
            try {
                e(this.f2391d, 0, 1);
                z = (this.f2391d[0] & 128) != 0;
            } catch (e e) {
                b(e);
            } catch (SocketTimeoutException unused) {
            } catch (IOException e2) {
                b(new e("IO Error", e2));
            }
            if ((this.f2391d[0] & 112) != 0) {
                throw new e("Invalid frame received");
            }
            byte b2 = (byte) (this.f2391d[0] & 15);
            e(this.f2391d, 1, 1);
            byte b3 = this.f2391d[1];
            long j = 0;
            if (b3 < 126) {
                j = b3;
            } else if (b3 == 126) {
                e(this.f2391d, 2, 2);
                j = ((this.f2391d[2] & 255) << 8) | (this.f2391d[3] & 255);
            } else if (b3 == Byte.MAX_VALUE) {
                e(this.f2391d, 2, 8);
                j = d(this.f2391d, 2);
            }
            int i = (int) j;
            byte[] bArr = new byte[i];
            e(bArr, 0, i);
            if (b2 == 8) {
                this.f2389b.l();
            } else if (b2 != 10) {
                if (b2 != 1 && b2 != 2 && b2 != 9 && b2 != 0) {
                    throw new e("Unsupported opcode: " + ((int) b2));
                }
                a(z, b2, bArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(DataInputStream dataInputStream) {
        this.f2388a = dataInputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f = true;
    }
}
