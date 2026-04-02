package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class b implements m {
    protected Context f;
    protected Context g;
    protected g h;
    protected LayoutInflater i;
    private m.a j;
    private int k;
    private int l;
    protected n m;

    public b(Context context, int i, int i2) {
        this.f = context;
        this.i = LayoutInflater.from(context);
        this.k = i;
        this.l = i2;
    }

    protected void a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.m).addView(view, i);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.j;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public abstract void c(i iVar, n.a aVar);

    @Override // androidx.appcompat.view.menu.m
    public void d(Context context, g gVar) {
        this.g = context;
        LayoutInflater.from(context);
        this.h = gVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(r rVar) {
        m.a aVar = this.j;
        if (aVar != null) {
            return aVar.c(rVar);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.m;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.h;
        int i = 0;
        if (gVar != null) {
            gVar.r();
            ArrayList<i> E = this.h.E();
            int size = E.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                i iVar = E.get(i3);
                if (q(i2, iVar)) {
                    View childAt = viewGroup.getChildAt(i2);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View n = n(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        n.setPressed(false);
                        n.jumpDrawablesToCurrentState();
                    }
                    if (n != childAt) {
                        a(n, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!l(viewGroup, i)) {
                i++;
            }
        }
    }

    public n.a h(ViewGroup viewGroup) {
        return (n.a) this.i.inflate(this.l, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean i(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean j(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void k(m.a aVar) {
        this.j = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public m.a m() {
        return this.j;
    }

    public View n(i iVar, View view, ViewGroup viewGroup) {
        n.a h = view instanceof n.a ? (n.a) view : h(viewGroup);
        c(iVar, h);
        return (View) h;
    }

    public n o(ViewGroup viewGroup) {
        if (this.m == null) {
            n nVar = (n) this.i.inflate(this.k, viewGroup, false);
            this.m = nVar;
            nVar.b(this.h);
            f(true);
        }
        return this.m;
    }

    public void p(int i) {
    }

    public abstract boolean q(int i, i iVar);
}
