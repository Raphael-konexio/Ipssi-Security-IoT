package com.google.firebase.database.r;

import java.util.Iterator;
/* loaded from: classes.dex */
public interface n extends Comparable<n>, Iterable<m> {

    /* renamed from: b  reason: collision with root package name */
    public static final c f2368b = new a();

    /* loaded from: classes.dex */
    class a extends c {
        a() {
        }

        @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
        public n b(com.google.firebase.database.r.b bVar) {
            if (bVar.w()) {
                c();
                return this;
            }
            return g.s();
        }

        @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
        public n c() {
            return this;
        }

        @Override // com.google.firebase.database.r.c, java.lang.Comparable
        /* renamed from: e */
        public int compareTo(n nVar) {
            return nVar == this ? 0 : 1;
        }

        @Override // com.google.firebase.database.r.c
        public boolean equals(Object obj) {
            return obj == this;
        }

        @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
        public boolean isEmpty() {
            return false;
        }

        @Override // com.google.firebase.database.r.c, com.google.firebase.database.r.n
        public boolean o(com.google.firebase.database.r.b bVar) {
            return false;
        }

        @Override // com.google.firebase.database.r.c
        public String toString() {
            return "<Max Node>";
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        V1,
        V2
    }

    int a();

    n b(com.google.firebase.database.r.b bVar);

    n c();

    String getHash();

    Object getValue();

    n h(com.google.firebase.database.p.l lVar);

    boolean isEmpty();

    n j(n nVar);

    boolean k();

    com.google.firebase.database.r.b n(com.google.firebase.database.r.b bVar);

    boolean o(com.google.firebase.database.r.b bVar);

    n p(com.google.firebase.database.r.b bVar, n nVar);

    n q(com.google.firebase.database.p.l lVar, n nVar);

    Object r(boolean z);

    Iterator<m> t();

    String v(b bVar);
}
