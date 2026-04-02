package com.google.firebase.auth;

import androidx.annotation.Keep;
import com.google.firebase.components.d;
import java.util.Arrays;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class FirebaseAuthRegistrar implements com.google.firebase.components.h {
    @Override // com.google.firebase.components.h
    @Keep
    public List<com.google.firebase.components.d<?>> getComponents() {
        d.b b2 = com.google.firebase.components.d.b(FirebaseAuth.class, com.google.firebase.auth.internal.b.class);
        b2.b(com.google.firebase.components.n.g(b.c.c.c.class));
        b2.e(r0.f1915a);
        b2.d();
        return Arrays.asList(b2.c(), b.c.c.n.g.a("fire-auth", "19.2.0"));
    }
}
