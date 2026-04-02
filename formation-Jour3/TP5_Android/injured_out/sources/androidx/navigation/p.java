package androidx.navigation;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
/* loaded from: classes.dex */
public abstract class p<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final p<Integer> f957b = new c(false);

    /* renamed from: c  reason: collision with root package name */
    public static final p<Integer> f958c = new d(false);

    /* renamed from: d  reason: collision with root package name */
    public static final p<int[]> f959d = new e(true);
    public static final p<Long> e = new f(false);
    public static final p<long[]> f = new g(true);
    public static final p<Float> g = new h(false);
    public static final p<float[]> h = new i(true);
    public static final p<Boolean> i = new j(false);
    public static final p<boolean[]> j = new k(true);
    public static final p<String> k = new a(true);
    public static final p<String[]> l = new b(true);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f960a;

    /* loaded from: classes.dex */
    class a extends p<String> {
        a(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "string";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ String h(String str) {
            k(str);
            return str;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public String b(Bundle bundle, String str) {
            return (String) bundle.get(str);
        }

        public String k(String str) {
            return str;
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, String str2) {
            bundle.putString(str, str2);
        }
    }

    /* loaded from: classes.dex */
    class b extends p<String[]> {
        b(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "string[]";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ String[] h(String str) {
            k(str);
            throw null;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public String[] b(Bundle bundle, String str) {
            return (String[]) bundle.get(str);
        }

        public String[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, String[] strArr) {
            bundle.putStringArray(str, strArr);
        }
    }

    /* loaded from: classes.dex */
    class c extends p<Integer> {
        c(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "integer";
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    class d extends p<Integer> {
        d(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "reference";
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public Integer b(Bundle bundle, String str) {
            return (Integer) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public Integer h(String str) {
            return Integer.valueOf(str.startsWith("0x") ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str));
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, Integer num) {
            bundle.putInt(str, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    class e extends p<int[]> {
        e(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "integer[]";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ int[] h(String str) {
            k(str);
            throw null;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public int[] b(Bundle bundle, String str) {
            return (int[]) bundle.get(str);
        }

        public int[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, int[] iArr) {
            bundle.putIntArray(str, iArr);
        }
    }

    /* loaded from: classes.dex */
    class f extends p<Long> {
        f(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "long";
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public Long b(Bundle bundle, String str) {
            return (Long) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public Long h(String str) {
            if (str.endsWith("L")) {
                str = str.substring(0, str.length() - 1);
            }
            return Long.valueOf(str.startsWith("0x") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str));
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, Long l) {
            bundle.putLong(str, l.longValue());
        }
    }

    /* loaded from: classes.dex */
    class g extends p<long[]> {
        g(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "long[]";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ long[] h(String str) {
            k(str);
            throw null;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public long[] b(Bundle bundle, String str) {
            return (long[]) bundle.get(str);
        }

        public long[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, long[] jArr) {
            bundle.putLongArray(str, jArr);
        }
    }

    /* loaded from: classes.dex */
    class h extends p<Float> {
        h(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "float";
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public Float b(Bundle bundle, String str) {
            return (Float) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public Float h(String str) {
            return Float.valueOf(Float.parseFloat(str));
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, Float f) {
            bundle.putFloat(str, f.floatValue());
        }
    }

    /* loaded from: classes.dex */
    class i extends p<float[]> {
        i(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "float[]";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ float[] h(String str) {
            k(str);
            throw null;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public float[] b(Bundle bundle, String str) {
            return (float[]) bundle.get(str);
        }

        public float[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, float[] fArr) {
            bundle.putFloatArray(str, fArr);
        }
    }

    /* loaded from: classes.dex */
    class j extends p<Boolean> {
        j(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "boolean";
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public Boolean b(Bundle bundle, String str) {
            return (Boolean) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public Boolean h(String str) {
            if ("true".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equals(str)) {
                return Boolean.FALSE;
            }
            throw new IllegalArgumentException("A boolean NavType only accepts \"true\" or \"false\" values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, Boolean bool) {
            bundle.putBoolean(str, bool.booleanValue());
        }
    }

    /* loaded from: classes.dex */
    class k extends p<boolean[]> {
        k(boolean z) {
            super(z);
        }

        @Override // androidx.navigation.p
        public String c() {
            return "boolean[]";
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ boolean[] h(String str) {
            k(str);
            throw null;
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public boolean[] b(Bundle bundle, String str) {
            return (boolean[]) bundle.get(str);
        }

        public boolean[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, boolean[] zArr) {
            bundle.putBooleanArray(str, zArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class l<D extends Enum> extends C0048p<D> {
        private final Class<D> n;

        public l(Class<D> cls) {
            super(false, cls);
            if (cls.isEnum()) {
                this.n = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " is not an Enum type.");
        }

        @Override // androidx.navigation.p.C0048p, androidx.navigation.p
        public String c() {
            return this.n.getName();
        }

        @Override // androidx.navigation.p.C0048p
        /* renamed from: m */
        public D k(String str) {
            D[] enumConstants;
            for (D d2 : this.n.getEnumConstants()) {
                if (d2.name().equals(str)) {
                    return d2;
                }
            }
            throw new IllegalArgumentException("Enum value " + str + " not found for type " + this.n.getName() + ".");
        }
    }

    /* loaded from: classes.dex */
    public static final class m<D extends Parcelable> extends p<D[]> {
        private final Class<D[]> m;

        public m(Class<D> cls) {
            super(true);
            if (!Parcelable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Parcelable.");
            }
            try {
                this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.navigation.p
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || m.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((m) obj).m);
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ Object h(String str) {
            k(str);
            throw null;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Parcelable[]) bundle.get(str));
        }

        public D[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.m.cast(dArr);
            bundle.putParcelableArray(str, dArr);
        }
    }

    /* loaded from: classes.dex */
    public static final class n<D> extends p<D> {
        private final Class<D> m;

        public n(Class<D> cls) {
            super(true);
            if (Parcelable.class.isAssignableFrom(cls) || Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Parcelable or Serializable.");
        }

        @Override // androidx.navigation.p
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.p
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || n.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((n) obj).m);
        }

        @Override // androidx.navigation.p
        public D h(String str) {
            throw new UnsupportedOperationException("Parcelables don't support default values.");
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.p
        public void i(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            if (d2 == null || (d2 instanceof Parcelable)) {
                bundle.putParcelable(str, (Parcelable) d2);
            } else if (d2 instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) d2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class o<D extends Serializable> extends p<D[]> {
        private final Class<D[]> m;

        public o(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            }
            try {
                this.m = (Class<D[]>) Class.forName("[L" + cls.getName() + ";");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // androidx.navigation.p
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || o.class != obj.getClass()) {
                return false;
            }
            return this.m.equals(((o) obj).m);
        }

        @Override // androidx.navigation.p
        public /* bridge */ /* synthetic */ Object h(String str) {
            k(str);
            throw null;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public D[] b(Bundle bundle, String str) {
            return (D[]) ((Serializable[]) bundle.get(str));
        }

        public D[] k(String str) {
            throw new UnsupportedOperationException("Arrays don't support default values.");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, D[] dArr) {
            this.m.cast(dArr);
            bundle.putSerializable(str, dArr);
        }
    }

    /* renamed from: androidx.navigation.p$p  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0048p<D extends Serializable> extends p<D> {
        private final Class<D> m;

        public C0048p(Class<D> cls) {
            super(true);
            if (!Serializable.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException(cls + " does not implement Serializable.");
            } else if (!cls.isEnum()) {
                this.m = cls;
            } else {
                throw new IllegalArgumentException(cls + " is an Enum. You should use EnumType instead.");
            }
        }

        C0048p(boolean z, Class<D> cls) {
            super(z);
            if (Serializable.class.isAssignableFrom(cls)) {
                this.m = cls;
                return;
            }
            throw new IllegalArgumentException(cls + " does not implement Serializable.");
        }

        @Override // androidx.navigation.p
        public String c() {
            return this.m.getName();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof C0048p) {
                return this.m.equals(((C0048p) obj).m);
            }
            return false;
        }

        public int hashCode() {
            return this.m.hashCode();
        }

        @Override // androidx.navigation.p
        /* renamed from: j */
        public D b(Bundle bundle, String str) {
            return (D) bundle.get(str);
        }

        @Override // androidx.navigation.p
        /* renamed from: k */
        public D h(String str) {
            throw new UnsupportedOperationException("Serializables don't support default values.");
        }

        @Override // androidx.navigation.p
        /* renamed from: l */
        public void i(Bundle bundle, String str, D d2) {
            this.m.cast(d2);
            bundle.putSerializable(str, d2);
        }
    }

    p(boolean z) {
        this.f960a = z;
    }

    public static p<?> a(String str, String str2) {
        String str3;
        if (f957b.c().equals(str)) {
            return f957b;
        }
        if (f959d.c().equals(str)) {
            return f959d;
        }
        if (e.c().equals(str)) {
            return e;
        }
        if (f.c().equals(str)) {
            return f;
        }
        if (i.c().equals(str)) {
            return i;
        }
        if (j.c().equals(str)) {
            return j;
        }
        if (k.c().equals(str)) {
            return k;
        }
        if (l.c().equals(str)) {
            return l;
        }
        if (g.c().equals(str)) {
            return g;
        }
        if (h.c().equals(str)) {
            return h;
        }
        if (f958c.c().equals(str)) {
            return f958c;
        }
        if (str == null || str.isEmpty()) {
            return k;
        }
        try {
            if (!str.startsWith(".") || str2 == null) {
                str3 = str;
            } else {
                str3 = str2 + str;
            }
            if (str.endsWith("[]")) {
                str3 = str3.substring(0, str3.length() - 2);
                Class<?> cls = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls)) {
                    return new m(cls);
                }
                if (Serializable.class.isAssignableFrom(cls)) {
                    return new o(cls);
                }
            } else {
                Class<?> cls2 = Class.forName(str3);
                if (Parcelable.class.isAssignableFrom(cls2)) {
                    return new n(cls2);
                }
                if (Enum.class.isAssignableFrom(cls2)) {
                    return new l(cls2);
                }
                if (Serializable.class.isAssignableFrom(cls2)) {
                    return new C0048p(cls2);
                }
            }
            throw new IllegalArgumentException(str3 + " is not Serializable or Parcelable.");
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p d(String str) {
        try {
            try {
                try {
                    try {
                        f957b.h(str);
                        return f957b;
                    } catch (IllegalArgumentException unused) {
                        return k;
                    }
                } catch (IllegalArgumentException unused2) {
                    g.h(str);
                    return g;
                }
            } catch (IllegalArgumentException unused3) {
                i.h(str);
                return i;
            }
        } catch (IllegalArgumentException unused4) {
            e.h(str);
            return e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static p e(Object obj) {
        if (obj instanceof Integer) {
            return f957b;
        }
        if (obj instanceof int[]) {
            return f959d;
        }
        if (obj instanceof Long) {
            return e;
        }
        if (obj instanceof long[]) {
            return f;
        }
        if (obj instanceof Float) {
            return g;
        }
        if (obj instanceof float[]) {
            return h;
        }
        if (obj instanceof Boolean) {
            return i;
        }
        if (obj instanceof boolean[]) {
            return j;
        }
        if ((obj instanceof String) || obj == null) {
            return k;
        }
        if (obj instanceof String[]) {
            return l;
        }
        if (obj.getClass().isArray() && Parcelable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new m(obj.getClass().getComponentType());
        }
        if (obj.getClass().isArray() && Serializable.class.isAssignableFrom(obj.getClass().getComponentType())) {
            return new o(obj.getClass().getComponentType());
        }
        if (obj instanceof Parcelable) {
            return new n(obj.getClass());
        }
        if (obj instanceof Enum) {
            return new l(obj.getClass());
        }
        if (obj instanceof Serializable) {
            return new C0048p(obj.getClass());
        }
        throw new IllegalArgumentException("Object of type " + obj.getClass().getName() + " is not supported for navigation arguments.");
    }

    public abstract T b(Bundle bundle, String str);

    public abstract String c();

    public boolean f() {
        return this.f960a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T g(Bundle bundle, String str, String str2) {
        T h2 = h(str2);
        i(bundle, str, h2);
        return h2;
    }

    public abstract T h(String str);

    public abstract void i(Bundle bundle, String str, T t);

    public String toString() {
        return c();
    }
}
