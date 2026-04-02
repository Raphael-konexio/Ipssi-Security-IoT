package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.navigation.j;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class k extends j implements Iterable<j> {
    final a.d.h<j> n;
    private int o;
    private String p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Iterator<j> {
        private int f = -1;
        private boolean g = false;

        a() {
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public j next() {
            if (hasNext()) {
                this.g = true;
                a.d.h<j> hVar = k.this.n;
                int i = this.f + 1;
                this.f = i;
                return hVar.m(i);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f + 1 < k.this.n.l();
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.g) {
                throw new IllegalStateException("You must call next() before you can remove an element");
            }
            k.this.n.m(this.f).C(null);
            k.this.n.k(this.f);
            this.f--;
            this.g = false;
        }
    }

    public k(r<? extends k> rVar) {
        super(rVar);
        this.n = new a.d.h<>();
    }

    public final void E(j jVar) {
        int s = jVar.s();
        if (s == 0) {
            throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
        }
        if (s == s()) {
            throw new IllegalArgumentException("Destination " + jVar + " cannot have the same id as graph " + this);
        }
        j e = this.n.e(s);
        if (e == jVar) {
            return;
        }
        if (jVar.w() != null) {
            throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
        }
        if (e != null) {
            e.C(null);
        }
        jVar.C(this);
        this.n.i(jVar.s(), jVar);
    }

    public final j F(int i) {
        return G(i, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final j G(int i, boolean z) {
        j e = this.n.e(i);
        if (e != null) {
            return e;
        }
        if (!z || w() == null) {
            return null;
        }
        return w().F(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String H() {
        if (this.p == null) {
            this.p = Integer.toString(this.o);
        }
        return this.p;
    }

    public final int I() {
        return this.o;
    }

    public final void J(int i) {
        if (i != s()) {
            this.o = i;
            this.p = null;
            return;
        }
        throw new IllegalArgumentException("Start destination " + i + " cannot use the same id as the graph " + this);
    }

    @Override // java.lang.Iterable
    public final Iterator<j> iterator() {
        return new a();
    }

    @Override // androidx.navigation.j
    public String l() {
        return s() != 0 ? super.l() : "the root navigation";
    }

    @Override // androidx.navigation.j
    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        j F = F(I());
        if (F == null) {
            str = this.p;
            if (str == null) {
                sb.append("0x");
                str = Integer.toHexString(this.o);
            }
        } else {
            sb.append("{");
            sb.append(F.toString());
            str = "}";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.navigation.j
    public j.a x(i iVar) {
        j.a x = super.x(iVar);
        Iterator<j> it = iterator();
        while (it.hasNext()) {
            j.a x2 = it.next().x(iVar);
            if (x2 != null && (x == null || x2.compareTo(x) > 0)) {
                x = x2;
            }
        }
        return x;
    }

    @Override // androidx.navigation.j
    public void y(Context context, AttributeSet attributeSet) {
        super.y(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.v.a.NavGraphNavigator);
        J(obtainAttributes.getResourceId(androidx.navigation.v.a.NavGraphNavigator_startDestination, 0));
        this.p = j.m(context, this.o);
        obtainAttributes.recycle();
    }
}
