package com.google.firebase.database.s;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
class i {

    /* renamed from: a  reason: collision with root package name */
    private BlockingQueue<ByteBuffer> f2392a;
    private c e;
    private WritableByteChannel f;

    /* renamed from: b  reason: collision with root package name */
    private final Random f2393b = new Random();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f2394c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2395d = false;
    private final Thread g = c.j().newThread(new a());

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            i.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar, String str, int i) {
        b i2 = c.i();
        Thread d2 = d();
        i2.a(d2, str + "Writer-" + i);
        this.e = cVar;
        this.f2392a = new LinkedBlockingQueue();
    }

    private ByteBuffer b(byte b2, boolean z, byte[] bArr) {
        int i = z ? 6 : 2;
        int length = bArr.length;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (b2 | Byte.MIN_VALUE));
        if (length < 126) {
            if (z) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            allocate.put((byte) (z ? 254 : 126));
            allocate.putShort((short) length);
        } else {
            allocate.put((byte) (z ? 255 : 127));
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] c2 = c();
            allocate.put(c2);
            for (int i2 = 0; i2 < bArr.length; i2++) {
                allocate.put((byte) (bArr[i2] ^ c2[i2 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] c() {
        byte[] bArr = new byte[4];
        this.f2393b.nextBytes(bArr);
        return bArr;
    }

    private void e(e eVar) {
        this.e.k(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        while (!this.f2394c && !Thread.interrupted()) {
            try {
                j();
            } catch (IOException e) {
                e(new e("IO Exception", e));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i = 0; i < this.f2392a.size(); i++) {
            j();
        }
    }

    private void j() {
        this.f.write(this.f2392a.take());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Thread d() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
        r1.f2395d = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void g(byte r2, boolean r3, byte[] r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.nio.ByteBuffer r3 = r1.b(r2, r3, r4)     // Catch: java.lang.Throwable -> L26
            boolean r4 = r1.f2394c     // Catch: java.lang.Throwable -> L26
            r0 = 8
            if (r4 == 0) goto L1a
            boolean r4 = r1.f2395d     // Catch: java.lang.Throwable -> L26
            if (r4 != 0) goto L12
            if (r2 != r0) goto L12
            goto L1a
        L12:
            com.google.firebase.database.s.e r2 = new com.google.firebase.database.s.e     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "Shouldn't be sending"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L26
            throw r2     // Catch: java.lang.Throwable -> L26
        L1a:
            if (r2 != r0) goto L1f
            r2 = 1
            r1.f2395d = r2     // Catch: java.lang.Throwable -> L26
        L1f:
            java.util.concurrent.BlockingQueue<java.nio.ByteBuffer> r2 = r1.f2392a     // Catch: java.lang.Throwable -> L26
            r2.add(r3)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)
            return
        L26:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.s.i.g(byte, boolean, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(OutputStream outputStream) {
        this.f = Channels.newChannel(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        this.f2394c = true;
    }
}
