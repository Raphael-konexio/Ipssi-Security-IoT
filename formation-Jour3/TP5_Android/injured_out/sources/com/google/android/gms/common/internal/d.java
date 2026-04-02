package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Account f1606a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f1607b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f1608c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, b> f1609d;
    private final String e;
    private final String f;
    private final b.c.a.a.e.a g;
    private Integer h;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f1610a;

        /* renamed from: b  reason: collision with root package name */
        private a.d.b<Scope> f1611b;

        /* renamed from: c  reason: collision with root package name */
        private Map<com.google.android.gms.common.api.a<?>, b> f1612c;
        private View e;
        private String f;
        private String g;
        private boolean i;

        /* renamed from: d  reason: collision with root package name */
        private int f1613d = 0;
        private b.c.a.a.e.a h = b.c.a.a.e.a.o;

        public final a a(Collection<Scope> collection) {
            if (this.f1611b == null) {
                this.f1611b = new a.d.b<>();
            }
            this.f1611b.addAll(collection);
            return this;
        }

        public final d b() {
            return new d(this.f1610a, this.f1611b, this.f1612c, this.f1613d, this.e, this.f, this.g, this.h, this.i);
        }

        public final a c(Account account) {
            this.f1610a = account;
            return this;
        }

        public final a d(String str) {
            this.g = str;
            return this;
        }

        public final a e(String str) {
            this.f = str;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Set<Scope> f1614a;
    }

    public d(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, b> map, int i, View view, String str, String str2, b.c.a.a.e.a aVar, boolean z) {
        this.f1606a = account;
        this.f1607b = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f1609d = map == null ? Collections.emptyMap() : map;
        this.e = str;
        this.f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(this.f1607b);
        for (b bVar : this.f1609d.values()) {
            hashSet.addAll(bVar.f1614a);
        }
        this.f1608c = Collections.unmodifiableSet(hashSet);
    }

    public final Account a() {
        return this.f1606a;
    }

    public final Account b() {
        Account account = this.f1606a;
        return account != null ? account : new Account("<<default account>>", "com.google");
    }

    public final Set<Scope> c() {
        return this.f1608c;
    }

    public final Integer d() {
        return this.h;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.e;
    }

    public final Set<Scope> g() {
        return this.f1607b;
    }

    public final b.c.a.a.e.a h() {
        return this.g;
    }

    public final void i(Integer num) {
        this.h = num;
    }
}
