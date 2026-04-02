package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.Keep;
import b.c.c.c;
import b.c.c.n.g;
import com.google.firebase.components.d;
import com.google.firebase.components.e;
import com.google.firebase.components.h;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class FirestoreRegistrar implements h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ a lambda$getComponents$0(e eVar) {
        return new a((Context) eVar.a(Context.class), (c) eVar.a(c.class), (com.google.firebase.auth.internal.b) eVar.a(com.google.firebase.auth.internal.b.class), new com.google.firebase.firestore.c.a(eVar.c(b.c.c.n.h.class), eVar.c(b.c.c.k.c.class)));
    }

    @Override // com.google.firebase.components.h
    @Keep
    public List<d<?>> getComponents() {
        d.b a2 = d.a(a.class);
        a2.b(n.g(c.class));
        a2.b(n.g(Context.class));
        a2.b(n.f(b.c.c.k.c.class));
        a2.b(n.f(b.c.c.n.h.class));
        a2.b(n.e(com.google.firebase.auth.internal.b.class));
        a2.e(b.b());
        return Arrays.asList(a2.c(), g.a("fire-fst", "21.4.0"));
    }
}
