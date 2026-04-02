package com.google.firebase.components;

import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class a implements e {
    @Override // com.google.firebase.components.e
    public <T> T a(Class<T> cls) {
        b.c.c.l.a<T> c2 = c(cls);
        if (c2 == null) {
            return null;
        }
        return c2.get();
    }

    @Override // com.google.firebase.components.e
    public <T> Set<T> b(Class<T> cls) {
        return d(cls).get();
    }
}
