package androidx.lifecycle;
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private final a f900a;

    /* renamed from: b  reason: collision with root package name */
    private final v f901b;

    /* loaded from: classes.dex */
    public interface a {
        <T extends t> T a(Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b extends c implements a {
        b() {
        }

        @Override // androidx.lifecycle.u.a
        public <T extends t> T a(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends t> T c(String str, Class<T> cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        c() {
        }

        void b(t tVar) {
        }
    }

    public u(v vVar, a aVar) {
        this.f900a = aVar;
        this.f901b = vVar;
    }

    public <T extends t> T a(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public <T extends t> T b(String str, Class<T> cls) {
        T t = (T) this.f901b.b(str);
        if (cls.isInstance(t)) {
            a aVar = this.f900a;
            if (aVar instanceof c) {
                ((c) aVar).b(t);
            }
            return t;
        }
        a aVar2 = this.f900a;
        T t2 = aVar2 instanceof b ? (T) ((b) aVar2).c(str, cls) : (T) aVar2.a(cls);
        this.f901b.d(str, t2);
        return t2;
    }
}
