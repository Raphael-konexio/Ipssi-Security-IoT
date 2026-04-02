package a.e.a.j;

import a.e.a.j.e;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private int f124a;

    /* renamed from: b  reason: collision with root package name */
    private int f125b;

    /* renamed from: c  reason: collision with root package name */
    private int f126c;

    /* renamed from: d  reason: collision with root package name */
    private int f127d;
    private ArrayList<a> e = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private e f128a;

        /* renamed from: b  reason: collision with root package name */
        private e f129b;

        /* renamed from: c  reason: collision with root package name */
        private int f130c;

        /* renamed from: d  reason: collision with root package name */
        private e.c f131d;
        private int e;

        public a(e eVar) {
            this.f128a = eVar;
            this.f129b = eVar.i();
            this.f130c = eVar.d();
            this.f131d = eVar.h();
            this.e = eVar.c();
        }

        public void a(f fVar) {
            fVar.h(this.f128a.j()).b(this.f129b, this.f130c, this.f131d, this.e);
        }

        public void b(f fVar) {
            int i;
            e h = fVar.h(this.f128a.j());
            this.f128a = h;
            if (h != null) {
                this.f129b = h.i();
                this.f130c = this.f128a.d();
                this.f131d = this.f128a.h();
                i = this.f128a.c();
            } else {
                this.f129b = null;
                i = 0;
                this.f130c = 0;
                this.f131d = e.c.STRONG;
            }
            this.e = i;
        }
    }

    public o(f fVar) {
        this.f124a = fVar.G();
        this.f125b = fVar.H();
        this.f126c = fVar.D();
        this.f127d = fVar.r();
        ArrayList<e> i = fVar.i();
        int size = i.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.e.add(new a(i.get(i2)));
        }
    }

    public void a(f fVar) {
        fVar.C0(this.f124a);
        fVar.D0(this.f125b);
        fVar.y0(this.f126c);
        fVar.b0(this.f127d);
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f124a = fVar.G();
        this.f125b = fVar.H();
        this.f126c = fVar.D();
        this.f127d = fVar.r();
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).b(fVar);
        }
    }
}
