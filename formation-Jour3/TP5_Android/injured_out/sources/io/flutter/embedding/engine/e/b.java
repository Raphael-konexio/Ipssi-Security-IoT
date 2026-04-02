package io.flutter.embedding.engine.e;

import c.a.c.a.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements c.a.c.a.b, c {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f2486a;

    /* renamed from: d  reason: collision with root package name */
    private int f2489d = 1;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, b.a> f2487b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Integer, b.InterfaceC0071b> f2488c = new HashMap();

    /* loaded from: classes.dex */
    static class a implements b.InterfaceC0071b {

        /* renamed from: a  reason: collision with root package name */
        private final FlutterJNI f2490a;

        /* renamed from: b  reason: collision with root package name */
        private final int f2491b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicBoolean f2492c = new AtomicBoolean(false);

        a(FlutterJNI flutterJNI, int i) {
            this.f2490a = flutterJNI;
            this.f2491b = i;
        }

        @Override // c.a.c.a.b.InterfaceC0071b
        public void a(ByteBuffer byteBuffer) {
            if (this.f2492c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f2490a.invokePlatformMessageEmptyResponseCallback(this.f2491b);
            } else {
                this.f2490a.invokePlatformMessageResponseCallback(this.f2491b, byteBuffer, byteBuffer.position());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FlutterJNI flutterJNI) {
        this.f2486a = flutterJNI;
    }

    private static void e(Error error) {
        Thread currentThread = Thread.currentThread();
        if (currentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, error);
    }

    @Override // c.a.c.a.b
    public void a(String str, ByteBuffer byteBuffer, b.InterfaceC0071b interfaceC0071b) {
        int i;
        c.a.b.d("DartMessenger", "Sending message with callback over channel '" + str + "'");
        if (interfaceC0071b != null) {
            i = this.f2489d;
            this.f2489d = i + 1;
            this.f2488c.put(Integer.valueOf(i), interfaceC0071b);
        } else {
            i = 0;
        }
        if (byteBuffer == null) {
            this.f2486a.dispatchEmptyPlatformMessage(str, i);
        } else {
            this.f2486a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i);
        }
    }

    @Override // c.a.c.a.b
    public void b(String str, b.a aVar) {
        if (aVar == null) {
            c.a.b.d("DartMessenger", "Removing handler for channel '" + str + "'");
            this.f2487b.remove(str);
            return;
        }
        c.a.b.d("DartMessenger", "Setting handler for channel '" + str + "'");
        this.f2487b.put(str, aVar);
    }

    @Override // io.flutter.embedding.engine.e.c
    public void c(int i, byte[] bArr) {
        c.a.b.d("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0071b remove = this.f2488c.remove(Integer.valueOf(i));
        if (remove != null) {
            try {
                c.a.b.d("DartMessenger", "Invoking registered callback for reply from Dart.");
                remove.a(bArr == null ? null : ByteBuffer.wrap(bArr));
            } catch (Error e) {
                e(e);
            } catch (Exception e2) {
                c.a.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e2);
            }
        }
    }

    @Override // io.flutter.embedding.engine.e.c
    public void d(String str, byte[] bArr, int i) {
        c.a.b.d("DartMessenger", "Received message from Dart over channel '" + str + "'");
        b.a aVar = this.f2487b.get(str);
        if (aVar != null) {
            try {
                c.a.b.d("DartMessenger", "Deferring to registered handler to process message.");
                aVar.a(bArr == null ? null : ByteBuffer.wrap(bArr), new a(this.f2486a, i));
                return;
            } catch (Error e) {
                e(e);
                return;
            } catch (Exception e2) {
                c.a.b.c("DartMessenger", "Uncaught exception in binary message listener", e2);
            }
        } else {
            c.a.b.d("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
        }
        this.f2486a.invokePlatformMessageEmptyResponseCallback(i);
    }
}
