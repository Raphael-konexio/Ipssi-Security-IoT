package com.google.firebase.database.m;

import com.google.firebase.auth.p;
import com.google.firebase.database.p.a;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public abstract class e implements com.google.firebase.database.p.a {

    /* loaded from: classes.dex */
    class a implements com.google.firebase.database.p.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.firebase.auth.internal.b f2027a;

        a(com.google.firebase.auth.internal.b bVar) {
            this.f2027a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void f(a.InterfaceC0100a interfaceC0100a, Exception exc) {
            if (e.f(exc)) {
                interfaceC0100a.a(null);
            } else {
                interfaceC0100a.b(exc.getMessage());
            }
        }

        @Override // com.google.firebase.database.p.a
        public void a(boolean z, a.InterfaceC0100a interfaceC0100a) {
            b.c.a.a.f.g<p> b2 = this.f2027a.b(z);
            b2.f(com.google.firebase.database.m.a.a(interfaceC0100a));
            b2.d(com.google.firebase.database.m.b.a(interfaceC0100a));
        }

        @Override // com.google.firebase.database.p.a
        public void b(ExecutorService executorService, a.b bVar) {
            this.f2027a.a(c.b(executorService, bVar));
        }
    }

    /* loaded from: classes.dex */
    class b implements com.google.firebase.database.p.a {
        b() {
        }

        @Override // com.google.firebase.database.p.a
        public void a(boolean z, a.InterfaceC0100a interfaceC0100a) {
            interfaceC0100a.a(null);
        }

        @Override // com.google.firebase.database.p.a
        public void b(ExecutorService executorService, a.b bVar) {
            executorService.execute(f.a(bVar));
        }
    }

    public static com.google.firebase.database.p.a d(com.google.firebase.auth.internal.b bVar) {
        return new a(bVar);
    }

    public static com.google.firebase.database.p.a e() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(Exception exc) {
        return (exc instanceof b.c.c.a) || (exc instanceof b.c.c.m.c.a);
    }
}
