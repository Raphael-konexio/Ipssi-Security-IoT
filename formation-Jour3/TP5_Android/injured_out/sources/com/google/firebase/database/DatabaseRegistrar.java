package com.google.firebase.database;

import androidx.annotation.Keep;
import com.google.firebase.components.d;
import com.google.firebase.components.n;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class DatabaseRegistrar implements com.google.firebase.components.h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ g lambda$getComponents$0(com.google.firebase.components.e eVar) {
        return new g((b.c.c.c) eVar.a(b.c.c.c.class), (com.google.firebase.auth.internal.b) eVar.a(com.google.firebase.auth.internal.b.class));
    }

    @Override // com.google.firebase.components.h
    public List<com.google.firebase.components.d<?>> getComponents() {
        d.b a2 = com.google.firebase.components.d.a(g.class);
        a2.b(n.g(b.c.c.c.class));
        a2.b(n.e(com.google.firebase.auth.internal.b.class));
        a2.e(e.b());
        return Arrays.asList(a2.c(), b.c.c.n.g.a("fire-rtdb", "19.2.1"));
    }
}
