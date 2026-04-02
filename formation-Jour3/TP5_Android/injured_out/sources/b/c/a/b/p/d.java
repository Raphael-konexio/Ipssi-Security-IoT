package b.c.a.b.p;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* loaded from: classes.dex */
public interface d {

    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f1363b = new b();

        /* renamed from: a  reason: collision with root package name */
        private final e f1364a = new e();

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public e evaluate(float f, e eVar, e eVar2) {
            this.f1364a.a(b.c.a.b.v.a.c(eVar.f1367a, eVar2.f1367a, f), b.c.a.b.v.a.c(eVar.f1368b, eVar2.f1368b, f), b.c.a.b.v.a.c(eVar.f1369c, eVar2.f1369c, f));
            return this.f1364a;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f1365a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* renamed from: b.c.a.b.p.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0061d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f1366a = new C0061d("circularRevealScrimColor");

        private C0061d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* renamed from: b */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f1367a;

        /* renamed from: b  reason: collision with root package name */
        public float f1368b;

        /* renamed from: c  reason: collision with root package name */
        public float f1369c;

        private e() {
        }

        public e(float f, float f2, float f3) {
            this.f1367a = f;
            this.f1368b = f2;
            this.f1369c = f3;
        }

        public void a(float f, float f2, float f3) {
            this.f1367a = f;
            this.f1368b = f2;
            this.f1369c = f3;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i);

    void setRevealInfo(e eVar);
}
