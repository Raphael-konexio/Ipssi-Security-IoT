package com.google.firebase.database.o;

import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<List<String>> f2057a;

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f2058b;

    public a(List<List<String>> list, List<String> list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f2057a = list;
        this.f2058b = list2;
    }

    public List<String> a() {
        return Collections.unmodifiableList(this.f2058b);
    }

    public List<List<String>> b() {
        return Collections.unmodifiableList(this.f2057a);
    }
}
