package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.internal.i;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f0 extends i implements Handler.Callback {

    /* renamed from: d  reason: collision with root package name */
    private final Context f1617d;
    private final Handler e;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<i.a, g0> f1616c = new HashMap<>();
    private final b.c.a.a.b.l.a f = b.c.a.a.b.l.a.a();
    private final long g = 5000;
    private final long h = 300000;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(Context context) {
        this.f1617d = context.getApplicationContext();
        this.e = new b.c.a.a.d.b.d(context.getMainLooper(), this);
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean c(i.a aVar, ServiceConnection serviceConnection, String str) {
        boolean d2;
        r.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1616c) {
            g0 g0Var = this.f1616c.get(aVar);
            if (g0Var == null) {
                g0Var = new g0(this, aVar);
                g0Var.e(serviceConnection, str);
                g0Var.h(str);
                this.f1616c.put(aVar, g0Var);
            } else {
                this.e.removeMessages(0, aVar);
                if (g0Var.f(serviceConnection)) {
                    String valueOf = String.valueOf(aVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
                g0Var.e(serviceConnection, str);
                int c2 = g0Var.c();
                if (c2 == 1) {
                    serviceConnection.onServiceConnected(g0Var.b(), g0Var.a());
                } else if (c2 == 2) {
                    g0Var.h(str);
                }
            }
            d2 = g0Var.d();
        }
        return d2;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void d(i.a aVar, ServiceConnection serviceConnection, String str) {
        r.i(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f1616c) {
            g0 g0Var = this.f1616c.get(aVar);
            if (g0Var == null) {
                String valueOf = String.valueOf(aVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!g0Var.f(serviceConnection)) {
                String valueOf2 = String.valueOf(aVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                g0Var.g(serviceConnection, str);
                if (g0Var.j()) {
                    this.e.sendMessageDelayed(this.e.obtainMessage(0, aVar), this.g);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f1616c) {
                i.a aVar = (i.a) message.obj;
                g0 g0Var = this.f1616c.get(aVar);
                if (g0Var != null && g0Var.j()) {
                    if (g0Var.d()) {
                        g0Var.i("GmsClientSupervisor");
                    }
                    this.f1616c.remove(aVar);
                }
            }
            return true;
        } else if (i != 1) {
            return false;
        } else {
            synchronized (this.f1616c) {
                i.a aVar2 = (i.a) message.obj;
                g0 g0Var2 = this.f1616c.get(aVar2);
                if (g0Var2 != null && g0Var2.c() == 3) {
                    String valueOf = String.valueOf(aVar2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Timeout waiting for ServiceConnection callback ");
                    sb.append(valueOf);
                    Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                    ComponentName b2 = g0Var2.b();
                    if (b2 == null) {
                        b2 = aVar2.a();
                    }
                    if (b2 == null) {
                        b2 = new ComponentName(aVar2.b(), "unknown");
                    }
                    g0Var2.onServiceDisconnected(b2);
                }
            }
            return true;
        }
    }
}
