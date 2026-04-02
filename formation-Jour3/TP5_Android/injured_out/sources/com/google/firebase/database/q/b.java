package com.google.firebase.database.q;

import com.google.firebase.database.q.d;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f2346a;

    /* renamed from: b  reason: collision with root package name */
    private final d.a f2347b;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2348a;

        static {
            int[] iArr = new int[d.a.values().length];
            f2348a = iArr;
            try {
                iArr[d.a.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2348a[d.a.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2348a[d.a.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2348a[d.a.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b(d.a aVar, List<String> list) {
        if (list != null) {
            this.f2346a = new HashSet(list);
        } else {
            this.f2346a = null;
        }
        this.f2347b = aVar;
    }

    @Override // com.google.firebase.database.q.d
    public void a(d.a aVar, String str, String str2, long j) {
        if (g(aVar, str)) {
            String c2 = c(aVar, str, str2, j);
            int i = a.f2348a[aVar.ordinal()];
            if (i == 1) {
                e(str, c2);
            } else if (i == 2) {
                h(str, c2);
            } else if (i == 3) {
                f(str, c2);
            } else if (i != 4) {
                throw new RuntimeException("Should not reach here!");
            } else {
                d(str, c2);
            }
        }
    }

    @Override // com.google.firebase.database.q.d
    public d.a b() {
        return this.f2347b;
    }

    protected abstract String c(d.a aVar, String str, String str2, long j);

    protected abstract void d(String str, String str2);

    protected abstract void e(String str, String str2);

    protected abstract void f(String str, String str2);

    protected boolean g(d.a aVar, String str) {
        return aVar.ordinal() >= this.f2347b.ordinal() && (this.f2346a == null || aVar.ordinal() > d.a.DEBUG.ordinal() || this.f2346a.contains(str));
    }

    protected abstract void h(String str, String str2);
}
