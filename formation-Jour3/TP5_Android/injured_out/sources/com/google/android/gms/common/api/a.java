package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.internal.c;
import com.google.android.gms.common.internal.r;
import java.util.Set;
/* loaded from: classes.dex */
public final class a<O extends d> {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0075a<?, O> f1523a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1524b;

    /* renamed from: com.google.android.gms.common.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0075a<T extends f, O> extends e<T, O> {
        @Deprecated
        public T a(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, com.google.android.gms.common.api.f fVar, com.google.android.gms.common.api.g gVar) {
            return b(context, looper, dVar, o, fVar, gVar);
        }

        public T b(Context context, Looper looper, com.google.android.gms.common.internal.d dVar, O o, com.google.android.gms.common.api.internal.d dVar2, com.google.android.gms.common.api.internal.i iVar) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public static class c<C extends b> {
    }

    /* loaded from: classes.dex */
    public interface d {

        /* renamed from: com.google.android.gms.common.api.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0076a extends d {
            Account c();
        }

        /* loaded from: classes.dex */
        public interface b extends d {
            GoogleSignInAccount a();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e<T extends b, O> {
    }

    /* loaded from: classes.dex */
    public interface f extends b {
        void b(c.e eVar);

        boolean d();

        Set<Scope> e();

        void g(com.google.android.gms.common.internal.l lVar, Set<Scope> set);

        boolean j();

        int k();

        boolean l();

        b.c.a.a.b.c[] m();

        String n();

        void o(c.InterfaceC0078c interfaceC0078c);

        void p();

        boolean q();
    }

    /* loaded from: classes.dex */
    public static final class g<C extends f> extends c<C> {
    }

    /* loaded from: classes.dex */
    public interface h<T extends IInterface> extends b {
        String f();

        T h(IBinder iBinder);

        String r();

        void s(int i, T t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, AbstractC0075a<C, O> abstractC0075a, g<C> gVar) {
        r.i(abstractC0075a, "Cannot construct an Api with a null ClientBuilder");
        r.i(gVar, "Cannot construct an Api with a null ClientKey");
        this.f1524b = str;
        this.f1523a = abstractC0075a;
    }

    public final String a() {
        return this.f1524b;
    }

    public final AbstractC0075a<?, O> b() {
        r.k(this.f1523a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f1523a;
    }
}
