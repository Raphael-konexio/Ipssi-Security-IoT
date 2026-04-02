package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.internal.i;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ServiceConnection> f1618a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    private int f1619b = 2;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1620c;

    /* renamed from: d  reason: collision with root package name */
    private IBinder f1621d;
    private final i.a e;
    private ComponentName f;
    private final /* synthetic */ f0 g;

    public g0(f0 f0Var, i.a aVar) {
        this.g = f0Var;
        this.e = aVar;
    }

    public final IBinder a() {
        return this.f1621d;
    }

    public final ComponentName b() {
        return this.f;
    }

    public final int c() {
        return this.f1619b;
    }

    public final boolean d() {
        return this.f1620c;
    }

    public final void e(ServiceConnection serviceConnection, String str) {
        Context context;
        b.c.a.a.b.l.a unused;
        Context unused2;
        unused = this.g.f;
        unused2 = this.g.f1617d;
        i.a aVar = this.e;
        context = this.g.f1617d;
        aVar.c(context);
        this.f1618a.add(serviceConnection);
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f1618a.contains(serviceConnection);
    }

    public final void g(ServiceConnection serviceConnection, String str) {
        b.c.a.a.b.l.a unused;
        Context unused2;
        unused = this.g.f;
        unused2 = this.g.f1617d;
        this.f1618a.remove(serviceConnection);
    }

    public final void h(String str) {
        b.c.a.a.b.l.a aVar;
        Context context;
        Context context2;
        b.c.a.a.b.l.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.f1619b = 3;
        aVar = this.g.f;
        context = this.g.f1617d;
        i.a aVar3 = this.e;
        context2 = this.g.f1617d;
        boolean c2 = aVar.c(context, str, aVar3.c(context2), this, this.e.d());
        this.f1620c = c2;
        if (c2) {
            handler = this.g.e;
            Message obtainMessage = handler.obtainMessage(1, this.e);
            handler2 = this.g.e;
            j = this.g.h;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.f1619b = 2;
        try {
            aVar2 = this.g.f;
            context3 = this.g.f1617d;
            aVar2.b(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final void i(String str) {
        Handler handler;
        b.c.a.a.b.l.a aVar;
        Context context;
        handler = this.g.e;
        handler.removeMessages(1, this.e);
        aVar = this.g.f;
        context = this.g.f1617d;
        aVar.b(context, this);
        this.f1620c = false;
        this.f1619b = 2;
    }

    public final boolean j() {
        return this.f1618a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.f1616c;
        synchronized (hashMap) {
            handler = this.g.e;
            handler.removeMessages(1, this.e);
            this.f1621d = iBinder;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f1618a) {
                serviceConnection.onServiceConnected(componentName, iBinder);
            }
            this.f1619b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.g.f1616c;
        synchronized (hashMap) {
            handler = this.g.e;
            handler.removeMessages(1, this.e);
            this.f1621d = null;
            this.f = componentName;
            for (ServiceConnection serviceConnection : this.f1618a) {
                serviceConnection.onServiceDisconnected(componentName);
            }
            this.f1619b = 2;
        }
    }
}
