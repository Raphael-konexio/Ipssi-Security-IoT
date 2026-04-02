package com.google.firebase.database;

import com.google.firebase.database.r.n;
/* loaded from: classes.dex */
public class k {

    /* loaded from: classes.dex */
    public interface b {
        void a(com.google.firebase.database.b bVar, boolean z, com.google.firebase.database.a aVar);

        c b(i iVar);
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2021a;

        /* renamed from: b  reason: collision with root package name */
        private n f2022b;

        private c(boolean z, n nVar) {
            this.f2021a = z;
            this.f2022b = nVar;
        }

        public n a() {
            return this.f2022b;
        }

        public boolean b() {
            return this.f2021a;
        }
    }

    public static c a() {
        return new c(false, null);
    }
}
