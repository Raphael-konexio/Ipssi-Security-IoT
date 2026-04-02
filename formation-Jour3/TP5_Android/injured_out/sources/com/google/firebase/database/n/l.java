package com.google.firebase.database.n;

import java.lang.Comparable;
import java.util.Comparator;
/* loaded from: classes.dex */
public class l<A extends Comparable<A>> implements Comparator<A> {
    private static l f = new l();

    private l() {
    }

    public static <T extends Comparable<T>> l<T> b(Class<T> cls) {
        return f;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(A a2, A a3) {
        return a2.compareTo(a3);
    }
}
