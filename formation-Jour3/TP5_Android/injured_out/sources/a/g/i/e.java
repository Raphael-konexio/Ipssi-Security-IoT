package a.g.i;

import java.util.Locale;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g.i.d f206a = new C0010e(null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final a.g.i.d f207b = new C0010e(null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final a.g.i.d f208c = new C0010e(b.f212a, false);

    /* renamed from: d  reason: collision with root package name */
    public static final a.g.i.d f209d = new C0010e(b.f212a, true);

    /* loaded from: classes.dex */
    private static class a implements c {

        /* renamed from: b  reason: collision with root package name */
        static final a f210b = new a(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f211a;

        private a(boolean z) {
            this.f211a = z;
        }

        @Override // a.g.i.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int a2 = e.a(Character.getDirectionality(charSequence.charAt(i)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i++;
                    } else if (!this.f211a) {
                        return 1;
                    }
                } else if (this.f211a) {
                    return 0;
                }
                z = true;
                i++;
            }
            if (z) {
                return this.f211a ? 1 : 0;
            }
            return 2;
        }
    }

    /* loaded from: classes.dex */
    private static class b implements c {

        /* renamed from: a  reason: collision with root package name */
        static final b f212a = new b();

        private b() {
        }

        @Override // a.g.i.e.c
        public int a(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int i4 = 2;
            while (i < i3 && i4 == 2) {
                i4 = e.b(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface c {
        int a(CharSequence charSequence, int i, int i2);
    }

    /* loaded from: classes.dex */
    private static abstract class d implements a.g.i.d {

        /* renamed from: a  reason: collision with root package name */
        private final c f213a;

        d(c cVar) {
            this.f213a = cVar;
        }

        private boolean c(CharSequence charSequence, int i, int i2) {
            int a2 = this.f213a.a(charSequence, i, i2);
            if (a2 != 0) {
                if (a2 != 1) {
                    return b();
                }
                return false;
            }
            return true;
        }

        @Override // a.g.i.d
        public boolean a(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f213a == null ? b() : c(charSequence, i, i2);
        }

        protected abstract boolean b();
    }

    /* renamed from: a.g.i.e$e  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0010e extends d {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f214b;

        C0010e(c cVar, boolean z) {
            super(cVar);
            this.f214b = z;
        }

        @Override // a.g.i.e.d
        protected boolean b() {
            return this.f214b;
        }
    }

    /* loaded from: classes.dex */
    private static class f extends d {

        /* renamed from: b  reason: collision with root package name */
        static final f f215b = new f();

        f() {
            super(null);
        }

        @Override // a.g.i.e.d
        protected boolean b() {
            return a.g.i.f.b(Locale.getDefault()) == 1;
        }
    }

    static {
        a aVar = a.f210b;
        f fVar = f.f215b;
    }

    static int a(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
